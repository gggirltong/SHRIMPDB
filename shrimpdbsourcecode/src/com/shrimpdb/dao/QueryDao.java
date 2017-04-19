package com.shrimpdb.dao;

import java.util.List;

import com.shrimpdb.entity.AnalyticalValue;
import com.shrimpdb.entity.QueryResult;
import com.shrimpdb.entity.Sample_detail;

public interface QueryDao {

	public List<Sample_detail> listSample();
	public List<AnalyticalValue> analyticalValue(Long id);
	public List<QueryResult> jsonage(int samplearr);
	public int update(List<Sample_detail> sampleresult);
	public List<Sample_detail> personSample(Long userid);
	public List<Sample_detail> typeSample(Long id);
	public List<Sample_detail> booklist(Long id);
	public List<Sample_detail> sampleclass(int cdd);
	public List<Sample_detail> personopen(Long id);
	public List<Sample_detail> personprivate(Long id);
	public void updataopen(List<Integer> numTable);
	public List<Sample_detail> homeSample();
	public void changedata(List<String> rem, List<Integer> ag);
	public List<AnalyticalValue> pickav();
	public List<QueryResult> jsonagearray(List<Integer> samplearr);
		}


