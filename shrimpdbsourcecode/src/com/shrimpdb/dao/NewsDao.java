package com.shrimpdb.dao;

import java.util.List;
import com.shrimpdb.entity.News;

public interface NewsDao {
	

	public  List<News>  getNewsList();
	public  void insertData(News news);
	public void deleteData(Long id);
	public void updateData(News news);
	public News News_one (Long id);
	public News getPtgk();
	public News getsybz();
	public News getsfbz();
	public List<News> newsListJSON(News news);
	public int count();
}
