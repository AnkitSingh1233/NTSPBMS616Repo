package com.nt.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity

@Table(name="BOOT_JS_INFO")

public class JobSeekerInfo implements Serializable{

	
	@Id
	@GeneratedValue
	private Integer jsId;
	
	@Column(length = 15)
	private String jsName;
	
	@Column(length = 15)
	private String jsAddrs;
	
	@Column(length =100)
	private String resumePath;
	
	@Column(length = 100)
	private String phototPath;
	
	
}
