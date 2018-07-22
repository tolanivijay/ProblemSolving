package com.model;

public class Student {
	
	private String name;
	
	private Integer age;
	
	private Integer salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}

	
	
	

}
