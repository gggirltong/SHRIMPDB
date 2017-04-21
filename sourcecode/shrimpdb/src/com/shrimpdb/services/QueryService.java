package com.shrimpdb.services;

import java.util.List;

import com.shrimpdb.entity.AnalyticalValue;
import com.shrimpdb.entity.QueryResult;
import com.shrimpdb.entity.Sample_detail;

public interface QueryService {

	public List<Sample_detail> sampleresult();

	public List<AnalyticalValue> analyticalValue(Long id);

	public List<QueryResult> jsonage(Integer sampleid);

	public int update(List<Sample_detail> sampleresult);

	public List<Sample_detail> personresult(Long userid);

	public List<Sample_detail> booklist(Long id);

	public List<Sample_detail> openlist(Long id);

	public List<Integer> updataopen(List<Integer> numTable);

	List<Sample_detail> homeresult();

	public void changedata(List<String> rem, List<Integer> ag);

	public List<AnalyticalValue> pickav();

	public List<QueryResult> jsonagearray(List<Integer> numTable);
}
