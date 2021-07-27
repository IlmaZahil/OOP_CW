//Ilma Zahil
//w1790405

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.util.Collections;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PremierLeagueGUIFX extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	//https://stackoverflow.com/questions/47559491/making-a-search-bar-in-javafx
	private final TableView<SportsClub> clubTableView = new TableView<>();
	private final ObservableList<SportsClub> rankingData = FXCollections.observableArrayList(PremierLeagueManager.premierLeagueClubsList);
	private final ObservableList<SportsClub> matchData = FXCollections.observableArrayList(PremierLeagueManager.listOfMatches);

	@Override
	public void start(Stage stage) throws Exception {
		mainWindow();
	}

	private void mainWindow(){
		Stage primaryStage = new Stage();

		// Main window elements
		// PLT Btn
		Button leagueBtn = new Button("Premier League Table");        // Open button on mortgage Calculator.
		leagueBtn.setLayoutX(125);
		leagueBtn.setLayoutY(120);
		leagueBtn.setPrefWidth(250);
		leagueBtn.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;"+"-fx-alignment: center;"+"-fx-background-radius: 50px;");

		// AMT Btn
		Button allMatchesBtn = new Button("All Matches Table");      // Open button on Finance Calculator.
		allMatchesBtn.setLayoutX(125);
		allMatchesBtn.setLayoutY(200);
		allMatchesBtn.setPrefWidth(250);
		allMatchesBtn.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;"+"-fx-alignment: center;"+"-fx-background-radius: 50px;");

		// Exit Btn
		Button btnCloseWin = new Button("Exit");
		btnCloseWin.setLayoutX(300);
		btnCloseWin.setLayoutY(400);
		btnCloseWin.setPrefWidth(100);
		btnCloseWin.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;"+"-fx-alignment: center;"+"-fx-background-radius: 50px;");
		btnCloseWin.setOnAction(event -> primaryStage.close());

		AnchorPane mainLayout = new AnchorPane();
		mainLayout.setStyle("-fx-background-color: #fa98ef;");
		mainLayout.getChildren().addAll(leagueBtn, allMatchesBtn,btnCloseWin);      // 3 buttons add to main window layout
		Scene mainScene = new Scene(mainLayout,500,500);

		primaryStage.setScene(mainScene);
		primaryStage.setTitle("Premier League 2021");
		primaryStage.show();

		leagueBtn.setOnAction(event -> {
			primaryStage.close();
			premierLeagueTable();

		});
		allMatchesBtn.setOnAction(event -> {
			primaryStage.close();
			matchTable();
		});
	}

	private void premierLeagueTable() {

		Stage stage = new Stage();
		stage.setTitle("Premier League Ranked Table");
		stage.setWidth(1290);
		stage.setHeight(700);


		final Label label = new Label("Ranking Table - 2021");
		Font font = Font.font("Georgia", FontWeight.BOLD, 30);
		label.setFont(font);

		TableColumn position = new TableColumn("Position");
		position.setSortable(false);
		position.setMinWidth(100);
		position.setCellValueFactory(new PropertyValueFactory<SportsClub, String>("position"));

		TableColumn clubName = new TableColumn("Name Of the Club");
		clubName.setSortable(false);
		clubName.setMinWidth(150);
		clubName.setCellValueFactory(new PropertyValueFactory<SportsClub, String>("nameOfTheClub"));

		TableColumn location = new TableColumn("Location");
		location.setSortable(false);
		location.setMinWidth(200);
		location.setCellValueFactory(new PropertyValueFactory<SportsClub, String>("location"));

		TableColumn playMatch = new TableColumn("Played");
		playMatch.setSortable(false);
		playMatch.setMinWidth(100);
		playMatch.setCellValueFactory(new PropertyValueFactory<SportsClub, Integer>("noOfPlayedMatches"));

		TableColumn won = new TableColumn("Won");
		won.setSortable(false);
		won.setMinWidth(100);
		won.setCellValueFactory(new PropertyValueFactory<SportsClub, Integer>("won"));

		TableColumn drawn = new TableColumn("Drawn");
		drawn.setSortable(false);
		drawn.setMinWidth(100);
		drawn.setCellValueFactory(new PropertyValueFactory<SportsClub, Integer>("drawn"));

		TableColumn lost = new TableColumn("Lost");
		lost.setSortable(false);
		lost.setMinWidth(100);
		lost.setCellValueFactory(new PropertyValueFactory<SportsClub, Integer>("lost"));

		TableColumn goalsScore = new TableColumn("GF");
		goalsScore.setSortable(false);
		goalsScore.setMinWidth(100);
		goalsScore.setCellValueFactory(new PropertyValueFactory<SportsClub, Integer>("noOfGoalsScored"));

		TableColumn goalsAgainst = new TableColumn("GA");
		goalsAgainst.setSortable(false);
		goalsAgainst.setMinWidth(100);
		goalsAgainst.setCellValueFactory(new PropertyValueFactory<SportsClub, Integer>("noOfGoalsReceived"));

		TableColumn goalsDifference = new TableColumn("GD");
		goalsDifference.setSortable(false);
		goalsDifference.setMinWidth(100);
		goalsDifference.setCellValueFactory(new PropertyValueFactory<SportsClub, Integer>("noOfGoalsDifference"));

		TableColumn points = new TableColumn("Points");
		points.setMinWidth(100);
		points.setSortable(false);
		points.setCellValueFactory(new PropertyValueFactory<SportsClub, Integer>("noOfPoints"));

		clubTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		clubTableView.getColumns().addAll(position, clubName,location,playMatch,won,drawn,lost,goalsScore,goalsAgainst,goalsDifference,points);

		Button btnBack = new Button("Back");
		btnBack.setFont(Font.font("Arial", FontWeight.BOLD, 17));
		btnBack.setLayoutX(900);
		btnBack.setLayoutY(350);
		btnBack.setPrefWidth(100);
		btnBack.setOnAction(event -> {
			stage.close();
			PremierLeagueManager.premierLeagueClubsList.sort(Collections.reverseOrder());
			PremierLeagueGUIFX premierLeagueGUIFX = new PremierLeagueGUIFX();
			premierLeagueGUIFX.mainWindow();
		});

		Button goalsSort = new Button("Sort By Goals");
		goalsSort.setFont(Font.font("Arial", FontWeight.BOLD, 17));
		goalsSort.setLayoutX(900);
		goalsSort.setLayoutY(400);
		goalsSort.setOnAction(event -> {
			PremierLeagueManager.premierLeagueClubsList.sort(new GoalScoreCompare());
			stage.close();
			PremierLeagueGUIFX premierLeagueGUIFX = new PremierLeagueGUIFX();
			premierLeagueGUIFX.premierLeagueTable();
		});

		Button pointsDiff = new Button("Sort By PT & GF");
		pointsDiff.setFont(Font.font("Arial", FontWeight.BOLD, 17));
		pointsDiff.setLayoutX(900);
		pointsDiff.setLayoutY(400);
		pointsDiff.setOnAction(event -> {
			PremierLeagueManager.premierLeagueClubsList.sort(Collections.reverseOrder());
			stage.close();
			PremierLeagueGUIFX premierLeagueGUIFX = new PremierLeagueGUIFX();
			premierLeagueGUIFX.premierLeagueTable();
		});

		Button winBtn = new Button("Sort By Wins");
		winBtn.setFont(Font.font("Arial", FontWeight.BOLD, 17));
		winBtn.setLayoutX(900);
		winBtn.setLayoutY(400);
		winBtn.setOnAction(event -> {
			PremierLeagueManager.premierLeagueClubsList.sort(new WinsCompare());
			stage.close();
			PremierLeagueGUIFX premierLeagueGUIFX = new PremierLeagueGUIFX();
			premierLeagueGUIFX.premierLeagueTable();
		});
		clubTableView.setItems(rankingData);


		clubTableView.setMaxSize(1250,1000);
		HBox hBox = new HBox(50);//Add choiceBox and textField to hBox
		hBox.getChildren().addAll(goalsSort,pointsDiff,winBtn);
		hBox.setAlignment(Pos.CENTER);//Center HBox
		HBox hBox1 = new HBox(50);
		hBox1.getChildren().addAll(btnBack);
		VBox vbox = new VBox(50);
		vbox.setAlignment(Pos.CENTER);
		vbox.setStyle("-fx-background-color: #77edc0;");
		vbox.setMaxSize(500,1500);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, clubTableView, hBox,hBox1);
		Scene scene = new Scene(vbox, 900, 500);
		//((Group) scene.getRoot()).getChildren().addAll(vbox,btnBack);

		stage.setScene(scene);
		stage.show();
	}

	private void matchTable() {

		Stage stage = new Stage();

		stage.setTitle("Matches Table");
		stage.setWidth(1290);
		stage.setHeight(700);


		final Label label = new Label("All Matches - 2021");
		Font font = Font.font("Georgia", FontWeight.BOLD, 30);
		label.setFont(font);

		//clubTableView.setEditable(true);
		TableColumn date = new TableColumn("Date");
		date.setMinWidth(100);
		date.setCellValueFactory(new PropertyValueFactory<SportsClub, String>("matchDate"));

		TableColumn stadium = new TableColumn("Stadium");
		stadium.setMinWidth(250);
		stadium.setCellValueFactory(new PropertyValueFactory<SportsClub, String>("matchVenue"));

		TableColumn homeTeam = new TableColumn("Home Team");
		homeTeam.setMinWidth(250);
		homeTeam.setCellValueFactory(new PropertyValueFactory<SportsClub, String>("nameOfTheClub"));

		TableColumn home = new TableColumn("Home");
		home.setMinWidth(100);
		home.setCellValueFactory(new PropertyValueFactory<SportsClub, Integer>("noOfGoalsScored"));

		TableColumn away = new TableColumn("Away");
		away.setMinWidth(100);
		away.setCellValueFactory(new PropertyValueFactory<SportsClub, Integer>("noOfGoalsReceived"));

		TableColumn result = new TableColumn("Result");
		result.getColumns().addAll(home,away);
		result.setMinWidth(100);
		result.setCellValueFactory(new PropertyValueFactory<SportsClub, String >("noOfPlayedMatches"));

		TableColumn awayTeam = new TableColumn("Away Team");
		awayTeam.setMinWidth(250);
		awayTeam.setCellValueFactory(new PropertyValueFactory<SportsClub, String >("otherTeamName"));



		clubTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		clubTableView.getColumns().addAll(date, stadium,homeTeam,result,awayTeam);

		Button btnBack = new Button("Back");
		btnBack.setFont(Font.font("Arial", FontWeight.BOLD, 17));
		btnBack.setLayoutX(900);
		btnBack.setLayoutY(400);
		btnBack.setPrefWidth(100);
		btnBack.setOnAction(event -> {
			stage.close();
			PremierLeagueGUIFX premierLeagueGUIFX = new PremierLeagueGUIFX();
			premierLeagueGUIFX.mainWindow();
		});

		Button randBtn = new Button("Random Play");
		randBtn.setFont(Font.font("Arial", FontWeight.BOLD, 17));
		randBtn.setLayoutX(900);
		randBtn.setLayoutY(400);
		randBtn.setOnAction(event -> {
			testRandom();
			stage.close();
			PremierLeagueGUIFX premierLeagueGUIFX = new PremierLeagueGUIFX();
			premierLeagueGUIFX.matchTable();

		});

		Button dateSort = new Button("Sort By Date");
		dateSort.setFont(Font.font("Arial", FontWeight.BOLD, 17));
		dateSort.setLayoutX(900);
		dateSort.setLayoutY(400);
		dateSort.setOnAction(event -> {
			Collections.sort(PremierLeagueManager.listOfMatches,new DateCompare());
			stage.close();
			PremierLeagueGUIFX premierLeagueGUIFX = new PremierLeagueGUIFX();
			premierLeagueGUIFX.matchTable();
		});

		ChoiceBox<String> choiceBox = new ChoiceBox();
		choiceBox.setStyle("-fx-font-size: 17;"+"-fx-font-family: Arial;"+"-fx-font-weight: bold;");
		choiceBox.getItems().addAll("Date", "Home Team","Away Team");
		choiceBox.setValue("Date");

		FilteredList<SportsClub> clubs = new FilteredList(matchData, p -> true);
		(clubTableView).setItems(clubs);
		TextField textField = new TextField();
		textField.setPromptText("Search here");
		textField.setOnKeyReleased(keyEvent ->
		{
			switch (choiceBox.getValue())
			{
				case "Date":
					(clubs).setPredicate(search -> ((FootballClub)search).getMatchDate().toLowerCase().contains(textField.getText().toLowerCase().trim()));
					break;
				case "Home Team":
					clubs.setPredicate(search -> search.getNameOfTheClub().toLowerCase().contains(textField.getText().toLowerCase().trim()));
					break;
				case "Away Team":
					clubs.setPredicate(search -> ((FootballClub)search).getOtherTeamName().toLowerCase().contains(textField.getText().toLowerCase().trim()));
					break;
			}
		});

		choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) ->
		{
			if (newVal != null) {
				textField.setText("");
				clubs.setPredicate(null);
			}
		});

		clubTableView.setMaxSize(1050,1000);
		HBox hBox = new HBox(50);
		hBox.getChildren().addAll(choiceBox,textField);
		hBox.setAlignment(Pos.CENTER);
		HBox hBox1 = new HBox(50);
		hBox1.getChildren().addAll(randBtn,dateSort);
		hBox1.setAlignment(Pos.CENTER);
		HBox hBox2 = new HBox(50);
		hBox2.getChildren().addAll(btnBack);
		VBox vbox = new VBox(50);
		vbox.setAlignment(Pos.CENTER);
		vbox.setStyle("-fx-background-color: #81dcf7;");
		vbox.setMaxSize(500,1500);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, clubTableView, hBox,hBox1,hBox2);
		Scene scene = new Scene(vbox, 900, 500);

		stage.setScene(scene);
		stage.show();
	}

	public static void testRandom(){
		LeagueManager leagueManager = new PremierLeagueManager();
		SportsClub homeTeam;
		SportsClub awayTeam;
		boolean duplicateCheck;
		Random rand = new Random();
		int rankedArraySize =PremierLeagueManager.premierLeagueClubsList.size();
		if ((rankedArraySize - 1)*rankedArraySize > PremierLeagueManager.listOfMatches.size()){
			do {
				homeTeam = PremierLeagueManager.premierLeagueClubsList.get(rand.nextInt(PremierLeagueManager.premierLeagueClubsList.size()));
				awayTeam = PremierLeagueManager.premierLeagueClubsList.get(rand.nextInt(PremierLeagueManager.premierLeagueClubsList.size()));
				duplicateCheck = Main.matchDuplicateCheck(homeTeam.getNameOfTheClub(),  awayTeam.getNameOfTheClub());
			} while (!duplicateCheck);
			System.out.println(homeTeam.getNameOfTheClub() + " & " + awayTeam.getNameOfTheClub());
			int homeRandScore = rand.nextInt(15);
			int awayRandScore = rand.nextInt(15);

			LocalDate localDateStart = LocalDate.of(2021, 1, 1);
			long start = localDateStart.toEpochDay();

			LocalDate localDateEnd = LocalDate.of(2022, 5, 1);
			long end = localDateEnd.toEpochDay();

			long randomDate = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
			leagueManager.addPlayedMatchDetails(String.valueOf(LocalDate.ofEpochDay(randomDate)),"xxx",homeTeam.getNameOfTheClub(),homeRandScore, awayTeam.getNameOfTheClub(),awayRandScore);
			System.out.println("Rank List Size : " + rankedArraySize+"-->"+(rankedArraySize - 1)*2 + "\t Matches List : " + PremierLeagueManager.listOfMatches.size());
		}else {
			System.out.println("Season End!!");
		}

	}
}
