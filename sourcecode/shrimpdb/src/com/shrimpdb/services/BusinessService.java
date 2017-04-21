package com.shrimpdb.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.shrimpdb.entity.Mount;
import com.shrimpdb.entity.News;
import com.shrimpdb.entity.SampleMount;
import com.shrimpdb.entity.Sample_detail;

public interface BusinessService {

	List<Mount> mountSample();

	void insertData(SampleMount addmount);

	void updateflag(String[] arr, String sysnumber);

	List<SampleMount> measurement();

	void UpdateMount(SampleMount measurement, String[] mountidarr);

	void updatetestflag(String[] systemnumberdarr);

	String saveFile(MultipartFile file1, String path);

	List<SampleMount> testlist();

	void UpdateProcess(SampleMount addmount, String[] mountidarr);

	void updatedetailprocess(String[] systemnumberdarr);

	List<SampleMount> processlist();

	List<SampleMount> resultlist(Long userid);

	List<SampleMount> examplejson();

	List<Sample_detail> samplemount();

}
