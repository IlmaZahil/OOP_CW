//Ilma Zahil
//w1790405

public class FootballClub extends SportsClub implements Comparable<FootballClub> {

	private String matchDate = "Not played yet";
	private String stadium;
	private String otherTeamName;
	private int won;
	private int drawn;
	private int lost;
	private int noOfGoalsScored;
	private int noOfGoalsReceived;
	private int noOfGoalsDifference;
	private int noOfPoints;
	private int noOfPlayedMatches;
	private int position;


	public FootballClub(String nameOfTheClub, String location, int noOfMembers) {		//create a club
		super(nameOfTheClub, location, noOfMembers);
	}
	//for premier league table
	public FootballClub(int position,String nameOfTheClub, String location, int noOfMembers, String matchDate, 
						int noOfPlayedMatches, int won, int drawn, int lost, int noOfGoalsScored, int noOfGoalsReceived, int noOfGoalsDifference, int noOfPoints) {
		super(nameOfTheClub, location, noOfMembers);
		this.position = position;
		this.matchDate = matchDate;
		this.won = won;
		this.drawn = drawn;
		this.lost = lost;
		this.noOfGoalsScored = noOfGoalsScored;
		this.noOfGoalsReceived = noOfGoalsReceived;
		this.noOfGoalsDifference = noOfGoalsDifference;
		this.noOfPoints = noOfPoints;
		this.noOfPlayedMatches = noOfPlayedMatches;
	}

	public FootballClub(String matchDate, String stadium, String nameOfTheClub, int noOfGoalsScored, String otherTeamName, int noOfGoalsReceived) {
		super(nameOfTheClub);
		this.matchDate = matchDate;
		this.stadium = stadium;
		this.noOfGoalsScored = noOfGoalsScored;
		this.otherTeamName = otherTeamName;
		this.noOfGoalsReceived = noOfGoalsReceived;
	}

	public String getOtherTeamName() {
		return otherTeamName;
	}

	public void setOtherTeamName(String otherTeamName) {
		this.otherTeamName = otherTeamName;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getWon() {
		return won;
	}

	public void setWon(int won) {
		this.won = won;
	}

	public int getDrawn() {
		return drawn;
	}

	public void setDrawn(int drawn) {
		this.drawn = drawn;
	}

	public int getLost() {
		return lost;
	}

	public void setLost(int lost) {
		this.lost = lost;
	}

	public int getNoOfGoalsScored() {
		return noOfGoalsScored;
	}

	public void setNoOfGoalsScored(int noOfGoalsScored) {
		this.noOfGoalsScored = noOfGoalsScored;
	}

	public int getNoOfGoalsReceived() {
		return noOfGoalsReceived;
	}

	public void setNoOfGoalsReceived(int noOfGoalsReceived) {
		this.noOfGoalsReceived = noOfGoalsReceived;
	}

	public int getNoOfGoalsDifference() {
		return noOfGoalsDifference;
	}

	public void setNoOfGoalsDifference(int noOfGoalsDifference) {
		this.noOfGoalsDifference = noOfGoalsDifference;
	}

	public int getNoOfPoints() {
		return noOfPoints;
	}

	public void setNoOfPoints(int noOfPoints) {
		this.noOfPoints = noOfPoints;
	}

	public int getNoOfPlayedMatches() {
		return noOfPlayedMatches;
	}

	public void setNoOfPlayedMatches(int noOfPlayedMatches) {
		this.noOfPlayedMatches = noOfPlayedMatches;
	}

	public String getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	@Override
	public String toString() {
		return "FootballClub{" +
				"matchDate='" + matchDate + '\'' +
				", matchVenue='" + stadium + '\'' +
				", otherTeamName='" + otherTeamName + '\'' +
				", noOfGoalsScored=" + noOfGoalsScored +
				", noOfGoalsReceived=" + noOfGoalsReceived +
				'}';
	}

	@Override
	public int compareTo(FootballClub fbc) {
		if (getNoOfPoints() > fbc.getNoOfPoints()){
			return 1;
		}else if (getNoOfPoints() == fbc.getNoOfPoints()){
			return Integer.compare(getNoOfGoalsDifference(), fbc.getNoOfGoalsDifference());
		}else {
			return -1;
		}

	}
}
