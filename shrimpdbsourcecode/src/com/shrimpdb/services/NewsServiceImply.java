package com.shrimpdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrimpdb.dao.NewsDao;
import com.shrimpdb.entity.News;

@Service
public class NewsServiceImply implements NewsService {
	
	@Autowired
	private NewsDao newsDao;
	
	
	
	@Override
	public  List<News> NewsList() {
		List<News>   newsList= newsDao.getNewsList();
	
		return newsList;
	}
	@Override
	public  News ptgklist() {
	News  ptgklist= newsDao.getPtgk();
	
		return ptgklist;
	}
	@Override
	public  News sybz() {
	News  ptgklist= newsDao.getsybz();
	
		return ptgklist;
	}
	@Override
	public  News sfbz() {
	News  sfbz= newsDao.getsfbz();
	
		return sfbz;
	}
	
	@Override
	public void insertData(News news) {
		
		newsDao.insertData(news);
	}
	@Override
	public void deleteData(Long id) {
		newsDao.deleteData(id);

	}
	@Override
	public News News_one(Long id) {
		return newsDao.News_one(id);
	}
	
	
	@Override
	public void updateData(News news) {
		
		newsDao.updateData(news);

	}
	@Override
	public String jsonString(News news) {
		
		int page = news.getPage();
		int rp =news.getRp();
		
		List<News> list = newsDao.newsListJSON(news);
		StringBuffer jsonString = new StringBuffer();
		jsonString.append("{\"page\":" + page);
		jsonString.append(",\"total\":" + newsDao.count());
		jsonString.append(",\"rows\":[");
		int xh = (page - 1) * rp;
		for(int i = 0; i < list.size(); ++i){
			News n = list.get(i);
			++xh;
			jsonString.append("{\"id\":\"" + i + "\"");

			// 序号->仪器名称->姓名->手机号码->样品名称->申请日期->状�?->操作
			jsonString.append(",\"cell\":[\"" + xh + "\",\"" + n.getTitle() + "\",\"" + n.getUpdate() + "\",\"" + n.getId() + "\"]},");
		}
		if(!list.isEmpty()) {
			jsonString.deleteCharAt(jsonString.length()-1);
		}
		jsonString.append("]}");
		return jsonString.toString();
	}
}
