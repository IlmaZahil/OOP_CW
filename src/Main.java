//Ilma Zahil
//w1790405

import javafx.application.Application;
import java.io.IOException;
import java.util.Scanner;


public class Main {
	private static final LeagueManager leagueManager = new PremierLeagueManager();
	final static Scanner USER_INPUT = new Scanner(System.in);
	private static boolean validationCheck;
	private static boolean decisionCheck;
	private static String clubName;
	private static String clubLocation;
	private static int clubMembers;
	private static String date;
	private static String stadiumName;
	private static String homeTeamName;
	private static String awayTeamName;
	private static int homeTeamScore;
	private static int awayTeamScore;
	private static int score;
	private static String endDecision;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::: Welcome To Premier League Championship Manager :::::::::::::::::::::::::::::::::::::::::::::::::::::::");

		do {
			try{
				Scanner input = new Scanner(System.in);
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Menu Options ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				System.out.println("\t\t1. Create and add a new football club in the premier league");
				System.out.println("\t\t2. Relegate an existing three club from the premier league");
				System.out.println("\t\t3. Delete a club from the premier league");
				System.out.println("\t\t4. Display the various statistics for a selected club");
				System.out.println("\t\t5. Display the Premier League Table");
				System.out.println("\t\t6. Add a played match");
				System.out.println("\t\t7. Open GUI");
				System.out.println("\t\t8. Exit");
				System.out.print("Enter the number you want(1 to 7) : ");
				String select = input.next();

				switch (select) {

					case "1":
						System.out.println("\n============================ Adding a new football club to the Premier League ============================");
						addANewFootballClub();
						break;

					case "2":
						System.out.println("\n============================ Relegate of clubs from the tournament ============================");
						leagueManager.relegateTheClubs();
						break;

					case "3":
						System.out.println("\n============================ Delete a club from the league ============================");
						deleteClub();
						break;

					case "4":
						System.out.println("\n============================ Details of a selected club ============================");
						selectedClubDetails();
						break;

					case "5":
						System.out.println("\n============================ Premier League Table ============================");
						leagueManager.displayPremierLeagueTable();
						break;

					case "6":
						System.out.println("\n============================ Details of a match played ============================");
						matchDetails();
						break;

					case "7":
						Application.launch(PremierLeagueGUIFX.class);
						leagueManager.dataSaveToFile("premierLeagueClubsList.txt");
						System.exit(0);
						break;

					case "8":
						leagueManager.dataSaveToFile("premierLeagueClubsList.txt");
						System.out.println("\n******************************** End the Programme ********************************");
						decisionCheck = true;
						break;

					default:
						System.out.println("Invalid Input!");
				}
			}finally {
				do {
					Scanner input = new Scanner(System.in);
					System.out.print("\n\tE - Exit the Programme\n\tC - Continue the programme\nChoose the decision you want : ");
					endDecision = input.nextLine();
					if (endDecision.equalsIgnoreCase("e")) {
						leagueManager.dataSaveToFile("premierLeagueClubsList.txt");
						System.out.println("\n******************************** End the Programme ********************************");
						decisionCheck = true;
					} else if (endDecision.equalsIgnoreCase("c")) {
						decisionCheck = false;
					} else {
						System.out.println("Invalid choice!");
					}
				}while (!(endDecision.equalsIgnoreCase("e") || endDecision.equalsIgnoreCase("c")));
			}

		}while (!decisionCheck);
	}

	private static void addANewFootballClub() {

		SportsClub sportsClub1 = new FootballClub("Leicester City", "London", 23);
		SportsClub sportsClub2 = new FootballClub("Chelsea", "America", 32);
		SportsClub sportsClub3 = new FootballClub("Everton", "Mexico", 33);
		SportsClub sportsClub4 = new FootballClub("Manchester United", "Africa", 30);
		SportsClub sportsClub5 = new FootballClub("Aston Villa", "Russia", 32);
		SportsClub sportsClub6 = new FootballClub("Fulham", "France", 31);
		leagueManager.addFootballClubToPremierLeague(sportsClub1);
		leagueManager.addFootballClubToPremierLeague(sportsClub2);
		leagueManager.addFootballClubToPremierLeague(sportsClub3);
		leagueManager.addFootballClubToPremierLeague(sportsClub4);
		leagueManager.addFootballClubToPremierLeague(sportsClub5);
		leagueManager.addFootballClubToPremierLeague(sportsClub6);
	}

	private static void inputClubName() {
		do {
			Scanner input = new Scanner(System.in);
			System.out.print("Enter the name of the club          : ");
			clubName = input.nextLine();
			validationCheck = stringsChecker(clubName);
			if (validationCheck){
				for (SportsClub club : PremierLeagueManager.premierLeagueClubsList) {
					if (club.getNameOfTheClub().equalsIgnoreCase(clubName)) {
						System.out.println("\tClub name is Already Registered!");
						validationCheck = false;
						break;
					} else {
						validationCheck = true;
					}
				}
			}
		}while (!validationCheck);
	}

	private static void inputClubLocation() {
		do {
			Scanner input = new Scanner(System.in);
			System.out.print("Enter the location of the club : ");
			clubLocation = input.nextLine();
			validationCheck = stringsChecker(clubLocation);
		}while (!validationCheck);
	}

	private static void inputClubMembers() {
		do {
			try{
				Scanner input = new Scanner(System.in);
				System.out.print("Enter the Number of team members    : ");
				clubMembers = input.nextInt();
				validationCheck = (clubMembers >= 11);
				System.out.println(validationCheck ? "": "\tEach group must have 11 or more members!");
			}catch (RuntimeException e){
				System.out.println("\tPlease enter an integer input!");
				validationCheck = false;
			}
		}while (!validationCheck);
	}

	private static void deleteClub() {
		if (!PremierLeagueManager.premierLeagueClubsList.isEmpty()){
			do {
				Scanner input = new Scanner(System.in);
				System.out.print("Enter club name : ");
				clubName = input.nextLine();
				validationCheck = stringsChecker(clubName);
				if (validationCheck){
					for (SportsClub club : PremierLeagueManager.premierLeagueClubsList) {
						if (club.getNameOfTheClub().equalsIgnoreCase(clubName)) {
							leagueManager.deleteAClub(clubName);
							validationCheck = true;
							break;
						} else {
							validationCheck = false;
						}
					}
					if (!validationCheck){
						System.out.println("Invalid club name \"" + clubName + "\"!");
					}
				}
			}while (!validationCheck);
		}else {
			System.out.println("No clubs available to delete");
		}
	}
	private static void matchDetails(){

		leagueManager.addPlayedMatchDetails("2021-04-09","Emirates Stadium, London","Manchester United",6,"Everton",12);

		leagueManager.addPlayedMatchDetails("2020-11-12","Emirates Stadium, London","Chelsea",10,"Manchester United",8);

		leagueManager.addPlayedMatchDetails("2020-09-29","Emirates Stadium, London","Manchester United",8,"Chelsea",8);

		leagueManager.addPlayedMatchDetails("2021-11-18","Emirates Stadium, London","Chelsea",5,"Leicester City",8);

		leagueManager.addPlayedMatchDetails("2021-03-14","Emirates Stadium, London","Aston Villa",6,"Leicester City",14);

		leagueManager.addPlayedMatchDetails("2020-01-02","Emirates Stadium, London","Aston Villa",3,"Manchester United",3);

		leagueManager.addPlayedMatchDetails("2020-12-30","Emirates Stadium, London","Leicester City",3,"Manchester United",10);

		leagueManager.addPlayedMatchDetails("2020-12-21","Emirates Stadium, London","Fulham",10,"Manchester United",10);

	}



	private static void inputMatchDate() {
		do {
			Scanner input = new Scanner(System.in);
			System.out.print("Enter the match date in the following format (YYYY-MM-DD) : ");
			date = input.nextLine();
			validationCheck = dateChecker(date);
		}while (!validationCheck);

	}

	private static void inputMatchVenue() {
		do {
			Scanner input = new Scanner(System.in);
			System.out.print("Enter the name of the stadium : ");
			stadiumName = input.nextLine();
			validationCheck = stringsChecker(stadiumName);
		}while (!validationCheck);
	}

	private static String inputClubName(String team) {
		do {
			Scanner input = new Scanner(System.in);
			System.out.print("Enter the name of the "+ team +" Team : ");
			clubName = input.nextLine();
			validationCheck = stringsChecker(clubName);
			if(validationCheck){
				for (SportsClub club : PremierLeagueManager.premierLeagueClubsList) {
					if (club.getNameOfTheClub().equalsIgnoreCase(clubName)) {
						validationCheck = true;
						break;
					} else {
						validationCheck = false;
					}
				}
				if (!validationCheck){
					System.out.println("\tThere is no team in the league called \"" + clubName+"\"");
				}
				if (validationCheck && team.equalsIgnoreCase("Away") && homeTeamName.equalsIgnoreCase(clubName)){
					System.out.println("\tPlease enter the name of the 2nd group again!\n\tThe names of the first team " +
							"and the second team cannot be the same in a match.");
					validationCheck = false;
				}
			}
		}while (!validationCheck);
		return clubName;
	}

	public static boolean matchDuplicateCheck(String homeTeam, String awayTeam) {
		if (!(homeTeam.equalsIgnoreCase(awayTeam))){
			for (SportsClub club:PremierLeagueManager.listOfMatches){
				if (club.getNameOfTheClub().equalsIgnoreCase(homeTeam) && ((FootballClub) club).getOtherTeamName().equalsIgnoreCase(awayTeam)){
					return false;
				}
			}
			return true;
		}else {
			return false;
		}
	}

	private static int inputScore(String teamScore) {

		do {
			try {
				Scanner input = new Scanner(System.in);
				System.out.print("Enter the number of goal score in the "+teamScore+" team : ");
				score = input.nextInt();
				validationCheck = (score >= 0);
				if (!validationCheck){
					System.out.println("\tPlease enter valid input!");
				}			}catch (RuntimeException e){
				System.out.println("\tPlease enter integer input!");
				validationCheck = false;
			}

		}while (!validationCheck);
		return score;

	}

	private static void selectedClubDetails() {

		if (!PremierLeagueManager.premierLeagueClubsList.isEmpty()){
			do {
				Scanner input = new Scanner(System.in);
				System.out.print("1. Enter the name of the Team : ");
				clubName = input.nextLine();
				validationCheck = stringsChecker(clubName);
				for (SportsClub club : PremierLeagueManager.premierLeagueClubsList) {
					if (club.getNameOfTheClub().equalsIgnoreCase(clubName)) {
						validationCheck = true;
						break;
					} else {
						validationCheck = false;
					}
				}
				if (!validationCheck) {
					System.out.println("\tThere is no team in the league called \"" + clubName + "\"");
				}
			} while (!validationCheck);
			leagueManager.displayVariousStatistics(clubName);
		}else {
			System.out.println("\tThere are currently no teams in the Premier League");
		}
	}



	public static boolean stringsChecker(String value) {    //string checker

		if (!(value == null || value.trim().isEmpty())){		//https://www.programiz.com/java-programming/examples/string-empty-null
			if (value.matches("^[ A-Za-z]+$")){		//https://stackoverflow.com/questions/24191040/checking-to-see-if-a-string-is-letters-spaces-only/24191088
				return true;
			}else {
			System.out.println("\tPlease enter a valid input!(Only Strings)");
				return false;
			}
		}else {
				System.out.println("\tPlease enter an input!");
				return false;
		}
	}

	private static boolean dateChecker(String date) {		// date checker
		if (!(date == null || date.trim().isEmpty())){		//https://www.regexlib.com/Search.aspx?k=yyyy-mm
			if ((date.matches("^((((19[0-9][0-9])|(2[0-9][0-9][0-9]))([-])(0[13578]|10|12)([-])(0[1-9]|[12][0-9]|3[01]))|(((19[0-9][0-9])|(2[0-9][0-9][0-9]))([-])(0[469]|11)([-])([0][1-9]|[12][0-9]|30))|(((19[0-9][0-9])|(2[0-9][0-9][0-9]))([-])(02)([-])(0[1-9]|1[0-9]|2[0-8]))|(([02468][048]00)([-])(02)([-])(29))|(([13579][26]00)([-])(02)([-])(29))|(([0-9][0-9][0][48])([-])(02)([-])(29))|(([0-9][0-9][2468][048])([-])(02)([-])(29))|(([0-9][0-9][13579][26])([-])(02)([-])(29)))$"))){
				return true;
			}else {
				System.out.println("\tInvalid Date Format!");
				return false;
			}
		}else {
			System.out.println("\tPlease enter valid time!");

					return false;
		}
	}
}
