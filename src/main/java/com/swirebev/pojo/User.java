package com.swirebev.pojo;

import java.io.Serializable;

 


 
public class User implements Serializable {

	/**
	 * Data Model for Login Form
	 */
	private static final long serialVersionUID = 1L;
	private long id;
    private String  userName;
    private String name;
    private String  password;
    private boolean  remenberMe;
    private boolean isOnJob;
	private long companyId;
    private Integer sex;  
    private String departmentId;
    private String department;
    private String grade;
    private String remark;
    private String[] hobbies;
    
    

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getRemenberMe() {
		return remenberMe;
	}
	public void setRemenberMe(boolean remenberMe) {
		this.remenberMe = remenberMe;
	}
    public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public boolean isOnJob() {
		return isOnJob;
	}
	public void setOnJob(boolean isOnJob) {
		this.isOnJob = isOnJob;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
