package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String Name;
	private double salary;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department departmet;
	
	public Employee()
	{
		
	}
	
	
	public Employee(String name, double salary) {
		super();
	
		Name = name;
		this.salary = salary;
	}
	
	
	
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", Name=" + Name + ", salary=" + salary + "]";
	}


	public Department getDempartmet() {
		return departmet;
	}


	public void setDempartmet(Department dempartmet) {
		this.departmet = dempartmet;
	}

}
