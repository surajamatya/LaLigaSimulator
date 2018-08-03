import java.util.ArrayList;
import java.util.Scanner;

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
		
		if(numTeams > minTeams)
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
		
		
//		for (int i=0; i< mymatches.length ; i++)
//        {
//            for (int j=0; j < 2 ; j++)
//                System.out.print(mymatches[i][j] + " ");
// 
//            System.out.println();
//        }
		
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
        
        Object[] menuOptions = {"Teams","Match Schedule","Match Simulation","Standings","Exit"};
        int answer;
        do {
        	answer = JOptionPane.showOptionDialog(null, "message", "Your Options", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, menuOptions, null);
		
		switch (answer)
		{
		case 0:
			System.out.println("                   Teams                         ");
			System.out.println("-------------------------------------------------");
			for(int i=0; i<allTeams.length; i++)
			{
				System.out.format("%4s%2d%2s%-17s%10s%2d\n", "Team" , (i+1) , ": " , allTeams[i].getTeamName() , "-> Players = " , allTeams[i].getNumberOfPlayers());				
				
			}
			break;
		case 1:
			System.out.println("Select team number");
			break;
		case 2:
			System.out.println("exit");
			break;
		default:
			System.out.println("all match schedule");
			break;
		}
		
        } while(answer !=4);
        
        MatchSimulation simulation = new MatchSimulation();
        simulation.start(allTeams, allMatches);
	}


}
