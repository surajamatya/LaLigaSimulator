import java.util.ArrayList;
import java.util.Random;

public class Team {
	
	private String teamName;
	private int numberOfPlayers;
	private int gamesPlayed;
	private int gamesWon;
	private int gamesLost;
	private int gamesDrawn;
	private int leaguePoints;
	private ArrayList<String> teamGames;	

	public Team()
	{
		Random rand = new Random(); 
		int  n = rand.nextInt(100) + 1;
		this.teamName = "Team " + Integer.toString(n);
		this.numberOfPlayers = 17;
		ArrayList<String> teamGames = new ArrayList<String>(1);
		this.teamGames = teamGames;
		this.gamesDrawn = 0;
		this.gamesLost = 0;
		this.gamesPlayed = 0;
		this.gamesWon = 0;
		this.leaguePoints = 0;
	}
	
	public Team(String teamName)
	{
		this.teamName = teamName;
		this.numberOfPlayers = 15;
		ArrayList<String> teamGames = new ArrayList<String>(1);
		this.teamGames = teamGames;
		this.gamesDrawn = 0;
		this.gamesLost = 0;
		this.gamesPlayed = 0;
		this.gamesWon = 0;
		this.leaguePoints = 0;
	}
	
	public Team(String teamName, int numberOfPlayers)
	{
		this.teamName = teamName;
		this.numberOfPlayers = numberOfPlayers;
		ArrayList<String> teamGames = new ArrayList<String>(1);
		this.teamGames = teamGames;
		this.gamesDrawn = 0;
		this.gamesLost = 0;
		this.gamesPlayed = 0;
		this.gamesWon = 0;
		this.leaguePoints = 0;
	}
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}
	public int getGamesWon() {
		return gamesWon;
	}
	public void setGamesWon(int gamesWon) {
		this.gamesWon = gamesWon;
	}
	public int getGamesLost() {
		return gamesLost;
	}
	public void setGamesLost(int gamesLost) {
		this.gamesLost = gamesLost;
	}
	public int getGamesDrawn() {
		return gamesDrawn;
	}
	public void setGamesDrawn(int gamesDrawn) {
		this.gamesDrawn = gamesDrawn;
	}
	public int getLeaguePoints() {
		return leaguePoints;
	}
	public void setLeaguePoints(int leaguePoints) {
		this.leaguePoints = leaguePoints;
	}
	
	public ArrayList<String> getTeamGames() {
		return teamGames;
	}

	public void setTeamGames(ArrayList<String> teamGames) {
		this.teamGames = teamGames;
	}

}
