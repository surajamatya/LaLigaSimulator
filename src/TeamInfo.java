import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TeamInfo {
	
	void teamInfo(Team[] allTeams) 
	{	    
		ArrayList<String> arr = new ArrayList<String>(0);
		String temp;
	    for(int i=0;i<allTeams.length;i++)
	    {
	    	temp = allTeams[i].getTeamName();
	    	arr.add(temp);
	    }
	    
	    Object[] teams = arr.toArray(new Object[allTeams.length]);

	    String s = (String)JOptionPane.showInputDialog(null,
	                        "Select a team:","Team Information",
	                        JOptionPane.PLAIN_MESSAGE,null,teams,"Barcelona");
	  
	    int index = arr.indexOf(s);
	    System.out.println(" ");
	    System.out.println("Team Name:          " + s);
	    System.out.println("Number of Players = " + allTeams[index].getNumberOfPlayers());
	    System.out.println("Games Played =      " + allTeams[index].getGamesPlayed());
	    System.out.println("Games Won =         " + allTeams[index].getGamesWon());
	    System.out.println("Games Drawn =       " + allTeams[index].getGamesDrawn());
	    System.out.println("Games Lost =        " + allTeams[index].getGamesLost());
	    System.out.println("League Points =     " + allTeams[index].getLeaguePoints());
	   
	    ArrayList<String> teamMatches = allTeams[index].getTeamGames();
		// Printing elements one by one
		System.out.println(" ");
		System.out.println("Game schedule for " + allTeams[index].getTeamName());
		System.out.println("---------------------------- ");
		
		for (int i=0; i<teamMatches.size(); i++)
          System.out.println(teamMatches.get(i));
	    
	}

}
