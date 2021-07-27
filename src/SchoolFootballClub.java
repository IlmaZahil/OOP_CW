//Ilma Zahil
//w1790405

public class SchoolFootballClub extends FootballClub {

	private String schoolName;

	public SchoolFootballClub(int position, String schoolName, String nameOfTheClub, String location, int noOfMembers,
							  String matchDate, int noOfPlayedMatches, int won, int drawn, int lost, int noOfGoalsScored,
							  int noOfGoalsReceived, int noOfGoalsDifference, int noOfPoints ) {
		super(position,nameOfTheClub, location, noOfMembers, matchDate, noOfPlayedMatches, won, drawn, lost, noOfGoalsScored,
				noOfGoalsReceived, noOfGoalsDifference, noOfPoints);
		this.schoolName = schoolName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
}
