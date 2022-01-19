package com.lavanya.gudimella.KafkaConsumer.Model;

public class Employee {
	private String emp_name;
	private int salary;
	private String address;

	public Employee() {
	}

	public Employee(String emp_name, int salary, String address) {
		super();
		this.emp_name = emp_name;
		this.salary = salary;
		this.address = address;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [emp_name=" + emp_name + ", salary=" + salary + ", address=" + address + "]";
	}
}
