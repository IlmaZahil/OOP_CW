//Ilma Zahil
//w1790405

import java.io.Serializable;

public class SportsClub implements Serializable {

	private String nameOfTheClub;
	private String location;
	private int noOfMembers;
	private String stadium;

	public SportsClub(String nameOfTheClub){

		this.nameOfTheClub = nameOfTheClub;
	}
	public SportsClub(String nameOfTheClub, String location, int noOfMembers) {
		this.nameOfTheClub = nameOfTheClub;
		this.location = location;
		this.noOfMembers = noOfMembers;
	}

	public String getNameOfTheClub() {
		return nameOfTheClub;
	}

	public void setNameOfTheClub(String nameOfTheClub) {
		this.nameOfTheClub = nameOfTheClub;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNoOfMembers() {
		return noOfMembers;
	}

	public void setNoOfMembers(int noOfMembers) {
		this.noOfMembers = noOfMembers;
	}
}
