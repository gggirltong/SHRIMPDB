package com.shrimpdb.services;

import java.util.List;


import com.shrimpdb.entity.News;
import com.shrimpdb.entity.User;

@SuppressWarnings("unused")
public interface NewsService {

	public List<News> NewsList();
	public News News_one (Long id);
	public void insertData(News news);
	public void deleteData(Long id);
	public void updateData(News news);
	public News ptgklist();
	public News sybz ();
	public News sfbz ();
	public String jsonString(News news);
}	  