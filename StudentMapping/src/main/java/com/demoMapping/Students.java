package com.demoMapping;


import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Students {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	private String Name;
	private String Class_Name;
	private int mark;
	private String result;
	public Students(String name, String class_Name, int mark, String result) {
		super();
		Name = name;
		Class_Name = class_Name;
		this.mark = mark;
		this.result = result;
	}
	public Students()
	{
		
	}
	
	
	//@ManyToMany(mappedBy="students")
	//List<Laptop> laptopList=new ArrayList<>();
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getClass_Name() {
		return Class_Name;
	}
	public void setClass_Name(String class_Name) {
		Class_Name = class_Name;
	}
	
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", Name=" + Name + ", Class_Name=" + Class_Name + ", mark=" + mark + ", result="
				+ result + "]";
	}
	

}
