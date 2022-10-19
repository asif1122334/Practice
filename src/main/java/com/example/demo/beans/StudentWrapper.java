package com.example.demo.beans;

public class StudentWrapper {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public StudentWrapper() {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "StudentWrapper [id=" + id + ", name=" + name + "]";
	}
	 
	 

}
