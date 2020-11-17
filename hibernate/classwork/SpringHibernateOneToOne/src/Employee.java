//Mapping is specified here in Employee class using OnetoOne Annotation
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_one_to_one")


public class Employee{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	private int id;
	private String firstName;
	private String lastName;
	private int salary;
	@OneToOne(targetEntity=Address.class, cascade=CascadeType.ALL)
	private Address address;
	
	public Employee() {}
	public Employee(int id, String fname, String lname, int salary, Address address) {
		this.id = id;
		this.firstName = fname;
		this.lastName = lname;
		this.salary = salary;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String last_name) {
		this.lastName = last_name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address addr) {
		this.address = addr;
	}
}