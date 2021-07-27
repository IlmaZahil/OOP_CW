//Ilma Zahil
//w1790405

import java.io.IOException;

public interface LeagueManager {
	void addFootballClubToPremierLeague(SportsClub footballClub);
	void relegateTheClubs();
	void deleteAClub(String clubName);
	void displayVariousStatistics(String clubName);
	void displayPremierLeagueTable();
	void addPlayedMatchDetails(String date, String stadium, String homeTeam, int homeTeamScore, String awayTeamName,
							   int awayTeamGoals);
	void dataSaveToFile(String fileName) throws IOException;
	void dataLoadInFile(String fileName) throws IOException, ClassNotFoundException;
}
