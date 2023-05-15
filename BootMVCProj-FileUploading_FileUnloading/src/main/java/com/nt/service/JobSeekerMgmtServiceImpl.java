package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.JobSeekerData;
import com.nt.entity.JobSeekerInfo;
import com.nt.repository.IJobSeekerRepo;

@Service
public class JobSeekerMgmtServiceImpl implements IJobSeekerMgmtSerice {

	@Autowired
	private IJobSeekerRepo jsRepo;
	
	
	
	
	public String registerJobSeeker(JobSeekerInfo info) {
		// TODO Auto-generated method stub
		return "job Seekeris saved with "+jsRepo.save(info).getJsId()+" id value";
	}




}
