package shiva.model;

public class User {
	
	private String name;
	private int age;
	
	public User() {
		
	}
	
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	@Override
	public String toString() {
		return "Name : "+this.getName()+"\tAge : "+this.getAge();
	}
	
}
