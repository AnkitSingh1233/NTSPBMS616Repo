package com.nt.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.nt.entity.JobSeekerInfo;
import com.nt.model.JobSeekerData;
import com.nt.service.IJobSeekerMgmtSerice;

@Controller
public class OerationController {

	@Autowired
	private IJobSeekerMgmtSerice service;

	@Autowired
	private Environment env;

	@GetMapping("/")
	public String showHomePage() {

		return "welcome";
	}

	@GetMapping("/register")
	public String showRegistrationForm(@ModelAttribute("js") JobSeekerData jsData) {

		return "jobseeker_register";

	}

	@PostMapping("/register")
	public String registerBYFileUploadingFile(@ModelAttribute("js") JobSeekerData jsData, Map<String, Object> map)
			throws Exception {

		String storeLocation = env.getRequiredProperty("upload.store");

		//File file = new File("storeLocation");  //hard coded path
		File file = new File(storeLocation);
		if (!file.exists())
			file.mkdir();

		MultipartFile resumeFile = jsData.getResume();
		MultipartFile photoFile = jsData.getPhoto();

		InputStream isResume = resumeFile.getInputStream();
		InputStream isPhoto = photoFile.getInputStream();

		String resumeFileName = resumeFile.getOriginalFilename();
		String photoFileName = photoFile.getOriginalFilename();

		OutputStream osResume = new FileOutputStream(file.getAbsolutePath() + "\\" + resumeFileName);
		OutputStream osPhoto = new FileOutputStream(file.getAbsolutePath() + "\\" + photoFileName);

		IOUtils.copy(isResume, osResume);
		IOUtils.copy(isPhoto, osPhoto);

		isResume.close();
		isPhoto.close();

		osResume.close();
		osPhoto.close();

		JobSeekerInfo jsInfo = new JobSeekerInfo();
		jsInfo.setJsName(jsData.getJsName());
		jsInfo.setJsAddrs(jsData.getJsAddrs());

		jsInfo.setResumePath(file.getPath() + "//" + resumeFileName);

		jsInfo.setPhototPath(file.getPath() + "//" + photoFileName);

		String msg = service.registerJobSeeker(jsInfo);

		map.put("file1", resumeFileName);

		map.put("file2", photoFileName);

		map.put("resultMsg", msg);

		return "show_result";
	}

}
