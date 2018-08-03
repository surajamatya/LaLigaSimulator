import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class MatchSimulation {

	int[][] start(Team[] allTeams, int[][] allMatches)
	{

		int[] outcomes= {0,1,2};
		// initialize league table : team no., played, won, drawn, lost, points
		int[][] leagueTable = new int[allTeams.length][6];
		
		for(int i=0; i<allMatches.length; i++)
		{
			System.out.println("\n Matchday "+(i+1)+" :  "+ allTeams[allMatches[i][0]].getTeamName() + " vs " + allTeams[allMatches[i][1]].getTeamName());
			
			int pick = outcomes[new Random().nextInt(outcomes.length)];
			switch(pick)
			{
			case 0: // team 1 lost
				// team 1
				leagueTable[allMatches[i][0]][1]++;
				leagueTable[allMatches[i][0]][4]++;
				
				// team 2
				leagueTable[allMatches[i][1]][1]++;
				leagueTable[allMatches[i][1]][2]++;
				leagueTable[allMatches[i][1]][5] += 3;
				System.out.println(allTeams[allMatches[i][1]].getTeamName() + " WON ");
				break;
				
			case 1: // draw				
				// team 1
				leagueTable[allMatches[i][0]][1]++;
				leagueTable[allMatches[i][0]][3]++;
				leagueTable[allMatches[i][0]][5]++;
				
				// team 2
				leagueTable[allMatches[i][1]][1]++;
				leagueTable[allMatches[i][1]][3]++;
				leagueTable[allMatches[i][1]][5]++;
				System.out.println(" DRAW ");
				break;
				
			case 2: // team 1 win				
				// team 1
				leagueTable[allMatches[i][0]][1]++;
				leagueTable[allMatches[i][0]][2]++;
				leagueTable[allMatches[i][0]][5] += 3;
				
				// team 2
				leagueTable[allMatches[i][1]][1]++;
				leagueTable[allMatches[i][1]][4]++;
				
				System.out.println(allTeams[allMatches[i][0]].getTeamName() + " WON ");
				break;
				
			}
		}
		
		for(int i=0;i<allTeams.length; i++)
		{
			//team attributes
			leagueTable[i][0]=i;
			allTeams[i].setGamesPlayed(leagueTable[i][1]);
			allTeams[i].setGamesWon(leagueTable[i][2]);
			allTeams[i].setGamesDrawn(leagueTable[i][3]);
			allTeams[i].setGamesLost(leagueTable[i][4]);
			allTeams[i].setLeaguePoints(leagueTable[i][5]);
		}
		return leagueTable;
	}
	
	public int[][] leagueStanding(int [][] leagueTable) 
	{
		int[][] leagueStanding = leagueTable;
		Arrays.sort(leagueStanding, Comparator.comparingInt(arr ->arr[5]));
		return leagueStanding;
	}
}
