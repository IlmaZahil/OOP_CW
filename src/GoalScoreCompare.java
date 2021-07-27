//Ilma Zahil
//w1790405

import java.util.Comparator;

public class GoalScoreCompare implements Comparator<SportsClub> {

	@Override
	public int compare(SportsClub sportsClub1, SportsClub sportsClub2) {
		int score01 = ((FootballClub) sportsClub1).getNoOfGoalsScored();
		int score02 = ((FootballClub) sportsClub2).getNoOfGoalsScored();

		return Integer.compare(score02, score01);
	}
}
