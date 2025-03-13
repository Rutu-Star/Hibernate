package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import java.util.List;
import java.util.ArrayList;

//import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity
public class Department {
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String Name;
	
	
	
    public Department() {
		
	}

	public Department(String name) {
		super();
		Name = name;
	}
	
	@OneToMany(mappedBy="departmet")
	List<Employee> employeeList=new ArrayList<>();

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

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", Name=" + Name + "]";
	}
	
	
	
	

}
