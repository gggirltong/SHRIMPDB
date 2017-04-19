package com.shrimpdb.common;

import java.util.Comparator;

import com.shrimpdb.entity.User;

import net.sourceforge.pinyin4j.PinyinHelper;

public class PYUSER implements Comparator<Object> {

	public int compare(Object o1, Object o2) {
		String key1 = ((User)o1).getName();
		String key2 = ((User)o2).getName();
		for (int i = 0; i < key1.length() && i < key2.length(); i++) {

			int codePoint1 = key1.charAt(i);
			int codePoint2 = key2.charAt(i);

			if (Character.isSupplementaryCodePoint(codePoint1) || Character.isSupplementaryCodePoint(codePoint2)) {
				i++;
			}

			if (codePoint1 != codePoint2) {
				if (Character.isSupplementaryCodePoint(codePoint1) || Character.isSupplementaryCodePoint(codePoint2)) {
					return codePoint1 - codePoint2;
				}

				String pinyin1 = pinyin((char) codePoint1);
				String pinyin2 = pinyin((char) codePoint2);

				if (pinyin1 != null && pinyin2 != null) { // �����ַ��Ǻ���
					if (!pinyin1.equals(pinyin2)) {
						return pinyin1.compareTo(pinyin2);
					}
				} else {
					return codePoint1 - codePoint2;
				}
			}
		}
		return key1.length() - key2.length();
	}

	private String pinyin(char c) {
		String[] pinyins = PinyinHelper.toHanyuPinyinStringArray(c);
		if (pinyins == null) {
			return null; 
		}
		return pinyins[0]; 
	}
}
