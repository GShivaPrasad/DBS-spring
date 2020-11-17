package com.charan.common.model;

public class Employee {
	private int id;
	
	private String name;
	private int basic;
	private int hra;
	private int allowance;
	private int deductions;
	private int gross_sal;
	private int final_deductions;
	private int total_sal;
	
	public Employee(int id, String name, int basic, int hra, int allowance, int deductions)
	{
		this.id=id;
		this.name=name;
		this.basic=basic;
		this.hra=hra;
		this.allowance=allowance;
		this.deductions=deductions;	
	
	}

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

	public int getBasic() {
		return basic;
	}

	public void setBasic(int basic) {
		this.basic = basic;
	}

	public int getHra() {
		return hra;
	}

	public void setHra(int hra) {
		this.hra = hra;
	}

	public int getAllowance() {
		return allowance;
	}

	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}

	public int getDeductions() {
		return deductions;
	}

	public void setDeductions(int deductions) {
		this.deductions = deductions;
	}

	public int getGross_sal() {
		return gross_sal;
	}

	public void setGross_sal(int gross_sal) {
		this.gross_sal = gross_sal;
	}

	public int getFinal_deductions() {
		return final_deductions;
	}

	public void setFinal_deductions(int final_deductions) {
		this.final_deductions = final_deductions;
	}

	public int getTotal_sal() {
		return total_sal;
	}

	public void setTotal_sal(int total_sal) {
		this.total_sal = total_sal;
	}
	
	

}
