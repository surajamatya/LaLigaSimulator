import java.util.Random;

public class MatchSimulation {

	void start(Team[] allTeams, int[][] allMatches)
	{
		System.out.println("teams = " + allTeams.length);
		System.out.println("matches = " + allMatches.length);
		
		int[] outcomes= {0,1,2};
		
		for(int i=0; i<allMatches.length; i++)
		{
			System.out.println("\n Matchday "+(i+1)+": Simulation in progress...");
			System.out.println("   "+ allTeams[allMatches[i][0]].getTeamName() + " vs " + allTeams[allMatches[i][1]].getTeamName());
			
			// games counter
			int played1 = allTeams[allMatches[i][0]].getGamesPlayed();
			int played2 = allTeams[allMatches[i][1]].getGamesPlayed();
			
			played1++;
			played2++;
			allTeams[allMatches[i][0]].setGamesPlayed(played1);
			allTeams[allMatches[i][1]].setGamesPlayed(played2);
			
			int pick = outcomes[new Random().nextInt(outcomes.length)];
			switch(pick)
			{
			case 0: // team 1 lost
				
				int points2 = allTeams[allMatches[i][1]].getLeaguePoints();
				points2 = points2 +3;
				allTeams[allMatches[i][1]].setLeaguePoints(points2);
				System.out.println(allTeams[allMatches[i][1]] + " WON ");
				break;
				
			case 1: // draw
				int points1 = allTeams[allMatches[i][0]].getLeaguePoints();
				points1++;
				allTeams[allMatches[i][0]].setLeaguePoints(points1);
				
				int points22 = allTeams[allMatches[i][1]].getLeaguePoints();
				points22++;
				allTeams[allMatches[i][1]].setLeaguePoints(points22);
				System.out.println(" DRAW ");
				break;
				
			case 2: // team 1 win
				int points11 = allTeams[allMatches[i][0]].getLeaguePoints();
				points11 = points11 +3;
				allTeams[allMatches[i][0]].setLeaguePoints(points11);
				System.out.println(allTeams[allMatches[i][0]] + " WON ");
				break;
				
			}
		}
	}
}
