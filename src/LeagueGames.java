import java.util.ArrayList;

public class LeagueGames {
	
	int[][] matchingTeam(Team[] allTeams)
	{
		
		int numTeams = allTeams.length;
		int numMatches = numTeams * (numTeams-1)/2;
		
		int allMatches[][] = new int[numMatches][2];
		
		String matches[] = new String[numMatches +1];
		System.out.println("                                           ");
		matches[0] = "Total League Games = " + Integer.toString(numMatches);
		System.out.println("                                           ");
		System.out.println(matches[0]);
		
		System.out.println("                   League Games                         ");
		System.out.println("--------------------------------------------------------");
		int j = 0;
		int k = 1;
		for(int i=0; i<numMatches; ++i)
		{
			matches[i+1] = "Match " + (i+1) + ": " + allTeams[j].getTeamName() + " vs " + allTeams[k].getTeamName();
			allMatches[i][0]=j;
			allMatches[i][1]=k;
			
			ArrayList<String> team1 = allTeams[j].getTeamGames();
			ArrayList<String> team2 = allTeams[k].getTeamGames();
			team1.add(matches[i+1]);
			team2.add(matches[i+1]);
			allTeams[j].setTeamGames(team1);
			allTeams[k].setTeamGames(team2);

			System.out.println(matches[i+1]);
			k++;
			
			if (k > numTeams-1)
			{
				j++;
				k = j+1;
			}
		}
		
		return allMatches;
		
	}

}