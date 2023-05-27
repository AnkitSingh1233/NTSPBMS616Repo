package com.nt.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;



@Entity

@Data

@Table(name="BOOT_JS_INFO1")

public class JobSeekerInfo implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer jsId;
	
	@Column(length = 15)
	private String jsName;
	
	@Column(length = 15)
	private String jsAddrs;
	
	@Column(length =120)
	private String resumePath;
	
	@Column(length = 120)
	private String phototPath;
	
	
}
