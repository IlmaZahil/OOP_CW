//Ilma Zahil
//w1790405

public class UniversityFootballClub extends FootballClub {

	private String universityName;

	public UniversityFootballClub(int position,String universityName, String nameOfTheClub, String location, int noOfMembers,
								  String matchDate , int noOfPlayedMatches, int won, int drawn, int lost, int noOfGoalsScored,
								  int noOfGoalsReceived, int noOfGoalsDifference, int noOfPoints) {
		super(position,nameOfTheClub, location, noOfMembers, matchDate, noOfPlayedMatches, won, drawn, lost, noOfGoalsScored,
				noOfGoalsReceived, noOfGoalsDifference, noOfPoints);
		this.universityName = universityName;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
}
