package com.swirebev.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

 
@Entity
@Table(name="dt_user")
 public class User implements Serializable {
	private static final long serialVersionUID = 570235488278506106L;
	private long id;
    private String  userName;
    private String nickName;    
    private String  password;
    private int status;
    private long companyCode;
    private String sex;  
    private String remark; 
    private Date createDate; 
    
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
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
	
	@Column(name="realname",length=30,nullable=false)//字段名与属性不同时
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(long companyCode) {
		this.companyCode = companyCode;
	}
	public int getStatus() {
		return status;
	}
	public int setStatus(int status) {
		return this.status=status;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
/*	Annotation：使用@Temporal(value=TemporalType)来注解表示日期和时间的注解

    其中TemporalType有三个值：TemporalType.TIMESTAMP 表示yyyy-MM-dd HH:mm:ss

                             TemporalType.DATE      表示yyyy-MM-dd

                             TemporalType.TIME      表示HH:mm:ss*/

                             
	 @Temporal(value=TemporalType.TIMESTAMP)
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	    	

}
