package com.nt.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name="emp")

public class Employee implements Serializable {

	@Id
	@SequenceGenerator(name = "gen" ,sequenceName ="emp_id_seq",allocationSize = 1,initialValue = 1)
	@GeneratedValue(generator = "gen",strategy = GenerationType.SEQUENCE)
	private Integer empno;
	
	@Column(length = 20)
	private String ename;
	@Column(length = 20)
	private String job;
	private Float sal;
	private Integer deptno;
	@Transient
	private String vflag="no";
	
	
}
