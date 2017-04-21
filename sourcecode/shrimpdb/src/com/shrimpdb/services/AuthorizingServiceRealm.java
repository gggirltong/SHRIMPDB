package com.shrimpdb.services;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrimpdb.common.CacheUtils;
import com.shrimpdb.common.MD5PswMatcher;
import com.shrimpdb.dao.MenuDao;
import com.shrimpdb.dao.RoleDao;
import com.shrimpdb.dao.RoleMenuDao;
import com.shrimpdb.dao.UserDao;
import com.shrimpdb.dao.UserRoleDao;
import com.shrimpdb.entity.Menu;
import com.shrimpdb.entity.Role;
import com.shrimpdb.entity.RoleMenu;
import com.shrimpdb.entity.User;
import com.shrimpdb.entity.UserRole;

@Service
public class AuthorizingServiceRealm extends AuthorizingRealm {

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRoleDao userroleDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private RoleMenuDao rolemenuDao;
	@Autowired
	private MenuDao menuDao;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		User user = userDao.findByLoginName(token.getUsername());
		if (user != null) {
			SecurityUtils.getSubject().getSession().setAttribute("user", user);//����ǰ�û�����session
			return new SimpleAuthenticationInfo(new ShiroUser(user.getId(), user.getUsername(), user.getName()), user.getPassword(), getName());
		} else {
			return null;
		}
	}
	/**
	 * ��Ȩ��ѯ�ص�����, ���м�Ȩ�����������û�����Ȩ��Ϣʱ����
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
		User user = userDao.findByLoginName(shiroUser.getLoginName());
		if (user != null) {
			CacheUtils.put("SHIROUSER", "user", user);
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

			/*//����user���еĵ�һ��ɫ
			UserRole userRole = userroleDao.getRole(user.getLoginName());
			if(userRole!= null) {
				List<RoleMenu> list = rolemenuDao.getMenuIdList(userRole.getRoleid());
				for (int i=0; i<list.size(); i++){
					    Menu menu= menuDao.getMenu(list.get(i).getMenuid());
						// ��ӻ���Permission��Ȩ����Ϣ
						info.addStringPermission(menu.getPermission());
				}
			}	*/
			
			//����user���еĽ�ɫ��������ж����ɫ��
			List<UserRole> userRoleList = userroleDao.getRoleList(user.getId());
			if(userRoleList!= null) {
				for (int j=0; j<userRoleList.size(); j++){	
					Long id=userRoleList.get(j).getRoleId();
					if(id.equals("8"))
					{ 
						return info;}
					Role role=roleDao.getRole(id);
					info.addRole(role.getName());
					List<RoleMenu> list = rolemenuDao.getMenuIdList(id);
				    for (int i=0; i<list.size(); i++){
					    Menu menu= menuDao.getMenu(list.get(i).getMenuid());
						// ��ӻ���Permission��Ȩ����Ϣ
						info.addStringPermission(menu.getPermission());
				    }
				}
			}
			// ���µ�¼IP��ʱ��
			userDao.updateUserLoginTime(user.getId());
			return info;
		} else {
			return null;
		}
	}

	/**
	 * �趨����У��
	 */
	@PostConstruct
	public void initCredentialsMatcher() {			
		setCredentialsMatcher(new MD5PswMatcher());
	}

	/**
	 * ����û�����Ȩ����֤�����´�ʹ��ʱ���¼���
	 */
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	/**
	 * ������й�����֤
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}

	/**
	 * ��Ȩ�û���Ϣ
	 */
	public static class ShiroUser implements Serializable {

		private static final long serialVersionUID = 1L;

		private Long id;
		private String loginName;
		private String name;
		private Map<String, Object> cacheMap;

		public ShiroUser(User user) {
			this.id = user.getId();
			this.loginName = user.getUsername();
			this.name = user.getName();
		}

		public ShiroUser(Long id, String loginName, String name) {
			this.id = id;
			this.loginName = loginName;
			this.name = name;
		}

		public Long getId() {
			return id;
		}

		public String getLoginName() {
			return loginName;
		}

		public String getName() {
			return name;
		}

		public Map<String, Object> getCacheMap() {
			if (cacheMap == null) {
				cacheMap = new HashMap<String, Object>();
			}
			return cacheMap;
		}
	}
}
