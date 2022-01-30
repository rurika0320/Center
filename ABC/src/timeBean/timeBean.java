package timeBean;


import java.io.Serializable;

public class timeBean implements Serializable {

	private int id;
	private String pass;
	private String date;
	private int year;
	private int month;
	private String clockIn;
	private String clockOut;
	private  String workingHours;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getYear() {
		return year;
	}
	public  void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public  void setMonth(int month) {
		this.month = month;
	}
	public String getClockIn() {
		return clockIn;
	}
	public void setClockIn(String clockIn) {
		this.clockIn = clockIn;
	}
	public String getClockOut() {
		return clockOut;
	}
	public void setClockOut(String clockOut) {
		this.clockOut = clockOut;
	}
	public String getWorkingHours() {
		return workingHours;
	}
	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}

}