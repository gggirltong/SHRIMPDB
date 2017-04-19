package com.shrimpdb.dao;

import java.util.List;

import com.shrimpdb.entity.Mount;
import com.shrimpdb.entity.SampleMount;
import com.shrimpdb.entity.Sample_detail;

public interface BusinessDao {

	List<Mount> listSample();

	void insertData(SampleMount addmount);

	void updateflag(String[] arr, String sysnumber);

	List<SampleMount> measurement();

	void UpdateMount(SampleMount measurement, String[] mountidarr);

	void updatetestflag(String[] systemnumberdarr);

	List<SampleMount> testlist();

	void updatedetailprocess(String[] systemnumberdarr);

	void UpdateProcess(SampleMount addmount, String[] mountidarr);

	List<SampleMount> processlist();

	List<SampleMount> resultlist(Long userid);

	List<SampleMount> examplejson();

	List<Sample_detail> samplemount();
}
