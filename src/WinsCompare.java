//Ilma Zahil
//w1790405

import java.util.Comparator;

public class WinsCompare implements Comparator<SportsClub> {

	@Override
	public int compare(SportsClub sportsClub1, SportsClub sportsClub2) {
		int win01 = ((FootballClub) sportsClub1).getWon();
		int win02 = ((FootballClub) sportsClub2).getWon();

		if (win01<win02){
			return 1;
		}else if (win01 == win02){
			return 0;
		}else {
			return -1;
		}
	}
}
