//Mapping is specified here in Employee class using OnetoOne Annotation
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name="TrainReservation")


public class TrainReservation{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int id;
	private String passangerName;
	private int age;
	private String journeyDate;
	private int ticketNo;


	public TrainReservation() {}
	public TrainReservation(int id, String passangerName, int age, String journeyDate, int ticketNo) {
		this.id = id;
		this.passangerName = passangerName;
		this.age = age;
		this.journeyDate = journeyDate;
		this.ticketNo = ticketNo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassangerName() {
		return passangerName;
	}
	public void setPassangerName(String passangerName) {
		this.passangerName = passangerName;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}

	public int getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

}