import java.util.ArrayList;
import java.util.Scanner;

public class LaLigaMain 
{
	
	public static void main(String[] arg) 
	{
		// ask for number of teams in the league
		int numTeams = 0;
		int minTeams = 3;
		do {
		
		System.out.println("How many teams in the league? (minimum 3 teams)");		
		Scanner scanner = new Scanner(System.in);		
		String num = scanner.nextLine();

		numTeams = Integer.parseInt(num);
		}
		while (numTeams<minTeams);
			
		
		// create an array to store all team information
		Team[] allTeams = new Team[numTeams];
		
		// create teams
		String[] myTeamNames = {"Barcelona"};
		allTeams[0] = new Team("Barcelona");	
		allTeams[1] = new Team("Real Madrid", 20);
		allTeams[2] = new Team("Atletico Madrid", 18);
		
		System.out.println("                   Teams                         ");
		System.out.println("-------------------------------------------------");
		System.out.println("Team 1: " + allTeams[0] .getTeamName() + ", Players = " + allTeams[0].getNumberOfPlayers());
		System.out.println("Team 2: " + allTeams[1] .getTeamName() + ", Players = " + allTeams[1].getNumberOfPlayers());
		System.out.println("Team 3: " + allTeams[2] .getTeamName() + ", Players = " + allTeams[2].getNumberOfPlayers());
		
		if(numTeams > minTeams)
		{
			for(int i=minTeams; i<numTeams; ++i)
			{
				allTeams[i] = new Team();
				System.out.println("Team " + (i+1) + ": " + allTeams[i].getTeamName() + ", Players = " + allTeams[i].getNumberOfPlayers());
				
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
        
        int exitthis=0;
        do {
	
        // ask for input
        	System.out.println("Options Menu: ");		
        	System.out.println("[0]-Match schedule");	
        	System.out.println("[1]-Team Info");	
        	System.out.println("[2]-Simulate match");
        	System.out.println("[3]-League Standing");	
    		Scanner scan = new Scanner(System.in);		
    		String answer = scan.nextLine();
   
    		int menu = Integer.parseInt(answer);
		
		switch (menu)
		{
		case 0:
			System.out.println("all match schedule");
			break;
		case 1:
			System.out.println("Select team number");
			String teamNum = scan.nextLine();
    		int num = Integer.parseInt(teamNum);
			System.out.println("Team info of " + allTeams[num].getTeamName());
			System.out.println(allTeams[0]);
			break;
		case 2:
			System.out.println("exit");
			exitthis=1;
			break;
		default:
			System.out.println("all match schedule");
			exitthis=1;
			break;
		}
		
        } while(exitthis !=1);
        
        MatchSimulation simulation = new MatchSimulation();
        simulation.start(allTeams, allMatches);
	}


}
