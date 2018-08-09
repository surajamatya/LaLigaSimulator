import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeagueGames {
	
	int[][] matchingTeam(Team[] allTeams)
	{		
		int numTeams = allTeams.length;
		int numMatches = numTeams * (numTeams-1)/2;		
		int teamMatches[][] = new int[numMatches][2];
		
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
			//matches[i+1] = "Match: " + allTeams[j].getTeamName() + " vs " + allTeams[k].getTeamName();
			teamMatches[i][0]=j;
			teamMatches[i][1]=k;
			k++;
			
			if (k > numTeams-1)
			{
				j++;
				k = j+1;
			}
		}	
		
		int[][] allMatches = teamMatches;
		List<int[]> asList = Arrays.asList(allMatches);
		Collections.shuffle(asList);
		allMatches = asList.toArray(new int[0][0]);
		
		for(int i=0; i<numMatches; i++)
		{
			matches[i+1] = "Matchday "+ (i+1) + ": " + allTeams[allMatches[i][0]].getTeamName()+ " vs " + allTeams[allMatches[i][1]].getTeamName();
			ArrayList<String> team1 = allTeams[allMatches[i][0]].getTeamGames();
			ArrayList<String> team2 = allTeams[allMatches[i][1]].getTeamGames();
			team1.add(matches[i+1]);
			team2.add(matches[i+1]);
			allTeams[allMatches[i][0]].setTeamGames(team1);
			allTeams[allMatches[i][1]].setTeamGames(team2);

			System.out.println(matches[i+1]);
		}				
		return allMatches;		
	}
}
