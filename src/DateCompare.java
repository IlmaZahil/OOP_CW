//Ilma Zahil
//w1790405

import java.util.Comparator;

public class DateCompare implements Comparator<SportsClub> {
	@Override
	public int compare(SportsClub club1, SportsClub club2) {
		String date1 = ((FootballClub) club1).getMatchDate();
		String date2 = ((FootballClub) club2).getMatchDate();

		return date1.compareTo(date2);

	}
}
