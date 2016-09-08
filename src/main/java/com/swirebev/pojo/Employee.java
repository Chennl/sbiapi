package com.swirebev.pojo;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="dt_employee")
public class Employee implements Serializable {
 
	private static final long serialVersionUID = 1L;
	private long id;
    private String name;
    private String  sex;
  //  private Date birthday;
    private String remark;
   // private 
    public Employee(){}
   /* public Employee(long id,String name,String sex,String remark)
    {
    	this.id=id;
    	this.name=name;
    	this.sex=sex;
    	this.remark=remark;
    	
    }*/
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	/*@JsonSerialize(using= CustomerDateSerializer.class)
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}*/
	 
}
