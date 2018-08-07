import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LaLigaMain 
{
	
	public static void main(String[] arg) 
	{
		// ask for number of teams in the league
		int numTeams = 0;
		int minTeams = 2;
		do {
			String num = JOptionPane.showInputDialog(null,"Please enter the number of teams you want to create.");
			numTeams = Integer.parseInt(num);
		}
		while (numTeams<minTeams);
			
		
		// create an array to store all team information
		Team[] allTeams = new Team[numTeams];
		
		// create teams
		String[] myTeamNames = {"Barcelona","Real Madrid","Atletico Madrid","Valencia","Villareal","Levante","Malaga","Getafe","Atletico Bilbao","Eibar"};
		
		System.out.println("                   Teams                         ");
		System.out.println("-------------------------------------------------");
		
		if(numTeams >= minTeams)
		{
			for(int i=0; i<numTeams; ++i)
			{
				if(i<myTeamNames.length)
				{
					allTeams[i]=new Team(myTeamNames[i]);
				}
				else
				{
					allTeams[i] = new Team();
				}
				
				System.out.format("%4s%2d%2s%-17s%10s%2d\n", "Team" , (i+1) , ": " , allTeams[i].getTeamName() , "-> Players = " , allTeams[i].getNumberOfPlayers());				
			}
		}
		
		LeagueGames leagueGames = new LeagueGames();
		
		int allMatches[][] = new int[2][2];
		allMatches = leagueGames.matchingTeam(allTeams);
				
		ArrayList<String> teama = allTeams[0].getTeamGames();
		// Printing elements one by one
		System.out.println(" ");
		System.out.println("Game schedule for Barcelona ");
		System.out.println("---------------------------- ");
        for (int i=0; i<teama.size(); i++)
            System.out.println(teama.get(i));
        
        ArrayList<String> teamb = allTeams[1].getTeamGames();
		// Printing elements one by one
		System.out.println(" ");
		System.out.println("Game schedule for Real Madrid ");
		System.out.println("---------------------------- ");
        for (int i=0; i<teamb.size(); i++)
            System.out.println(teamb.get(i));
        
        int[][] leagueTable = null;// initialize league table
        int[][] leagueStanding = null; // initialize league standings
        Object[] menuOptions = {"Teams","Match Schedule","Match Simulation","Standings","Exit"};
        int answer;
        do {
        	
        	answer = JOptionPane.showOptionDialog(null, "Pick an option", "Your Options", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, menuOptions, null);
      
        	{
				switch (answer)
				{
				case 0: // team info
					System.out.println("No.  Teams             Played      Wins        Draws       Losses      Points ");
					System.out.println("------------------------------------------------------------------------------");
					for(int i=0; i<allTeams.length; i++)
					{
						System.out.format("%2d%2s%-17s%6d%12d%12d%12d%12d\n", (i+1) , "  " ,
								allTeams[i].getTeamName(),
								allTeams[i].getGamesPlayed(),allTeams[i].getGamesWon(),
								allTeams[i].getGamesDrawn(),allTeams[i].getGamesLost(),
								allTeams[i].getLeaguePoints());
					}
					TeamInfo teaminfo = new TeamInfo();
					teaminfo.teamInfo(allTeams);
					break;
					
				case 1: // match schedule
					System.out.println("                   League Games                         ");
					System.out.println("--------------------------------------------------------");
					for(int i=0; i<allMatches.length; i++)
					{
						System.out.println("Matchday " + (i+1) + ": "+ allTeams[allMatches[i][0]].getTeamName() + " vs " + allTeams[allMatches[i][1]].getTeamName());
					}
					break;
					
				case 2://match simulation
					MatchSimulation simulation = new MatchSimulation();
			        leagueTable = simulation.start(allTeams, allMatches);
					break;
					
				case 3: // league standings
					
					if(leagueTable!=null)
					{
						MatchSimulation simulation1 = new MatchSimulation();
						leagueStanding = simulation1.leagueStanding(leagueTable);
						System.out.println("Rank  Teams             Played      Wins        Draws       Losses      Points ");
						System.out.println("-------------------------------------------------------------------------------");
						for(int i=0; i<allTeams.length; i++)
						{
							System.out.format("%4d%2s%-17s%6d%12d%12d%12d%12d\n", (i+1) , "  " ,
									allTeams[leagueStanding[i][0]].getTeamName(),
									allTeams[leagueStanding[i][0]].getGamesPlayed(),
									allTeams[leagueStanding[i][0]].getGamesWon(),
									allTeams[leagueStanding[i][0]].getGamesDrawn(),
									allTeams[leagueStanding[i][0]].getGamesLost(),
									allTeams[leagueStanding[i][0]].getLeaguePoints());
						}
					}
					else
					{
						System.out.println("First run match simulation");
					}
					
					
					break;
					
				default: 
					break;
				}
        	}
		
        } while(answer !=4);
        
        
	}


}
