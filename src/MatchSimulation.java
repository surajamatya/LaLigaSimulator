import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class MatchSimulation {

	int[][] start(Team[] allTeams, int[][] allMatches)
	{

		int[] outcomes= {0,1,1,2};
		// initialize league table : team no., played, won, drawn, lost, points
		int[][] leagueTable = new int[allTeams.length][6];
		
		// setup output window
		int rows = allMatches.length;
	    int cols = 4;
	    
	    int frameHeight = (rows*30);
	    int frameWidth = (cols * 100);
	    
	    if(frameHeight>1000)
	    	frameHeight=1000;

	    JFrame frame = new JFrame("Match Simulation");

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(frameWidth,frameHeight);
	    

	    JPanel pane = new JPanel(new GridBagLayout());
	    JScrollPane scrollFrame = new JScrollPane(pane, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    

	    GridBagConstraints c = new GridBagConstraints();
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 10;
	    c.ipadx = 10;
	    
	    for(int i=0; i<rows; i++)
	    {
	    	JLabel label1 = new JLabel("Matchday "+ (i+1));
	    	c.gridx = 0;
	    	c.gridy = i;
	    	label1.setHorizontalAlignment(SwingConstants.LEFT);
	    	pane.add(label1,c);
	    	
	    	label1 = new JLabel(allTeams[allMatches[i][0]].getTeamName());
	    	c.gridx = 1;
	    	c.gridy = i;
	    	label1.setHorizontalAlignment(SwingConstants.RIGHT);
	    	pane.add(label1,c);
	    	
	    	label1 = new JLabel("  vs  ");
	    	c.gridx = 2;
	    	c.gridy = i;
	    	label1.setHorizontalAlignment(SwingConstants.CENTER);
	    	pane.add(label1,c);
	    	
	    	label1 = new JLabel(allTeams[allMatches[i][1]].getTeamName());
	    	c.gridx = 3;
	    	c.gridy = i;
	    	label1.setHorizontalAlignment(SwingConstants.LEFT);
	    	pane.add(label1,c);	    	
	    }
	    
	    frame.add(scrollFrame);    
	    //frame.getContentPane().add(pane);
	    frame.setVisible(true);
	    	    
		// start simulation
		for(int i=0; i<allMatches.length; i++)
		{
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Matchday "+(i+1)+" :  "+ allTeams[allMatches[i][0]].getTeamName() + " vs " + allTeams[allMatches[i][1]].getTeamName());
			
			int pick = outcomes[new Random().nextInt(outcomes.length)];
			JLabel label1;
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
				System.out.println("                       " + allTeams[allMatches[i][1]].getTeamName() + " WON ");
				
				// set panel colors
				label1 = new JLabel(allTeams[allMatches[i][0]].getTeamName());
		    	c.gridx = 1;
		    	c.gridy = i;
		    	label1.setHorizontalAlignment(SwingConstants.RIGHT);
		    	label1.setBackground(Color.RED);
		    	label1.setOpaque(true);
		    	pane.add(label1,c);
		    	
		    	label1 = new JLabel(allTeams[allMatches[i][1]].getTeamName());
		    	c.gridx = 3;
		    	c.gridy = i;
		    	label1.setHorizontalAlignment(SwingConstants.LEFT);
		    	label1.setBackground(Color.GREEN);
		    	label1.setOpaque(true);
		    	pane.add(label1,c);
		    	
		    	pane.revalidate();
	    	    frame.revalidate();
	    	    
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
				System.out.println("                       " + " DRAW ");
				
				// set panel colors
				label1 = new JLabel(allTeams[allMatches[i][0]].getTeamName());
		    	c.gridx = 1;
		    	c.gridy = i;
		    	label1.setHorizontalAlignment(SwingConstants.RIGHT);
		    	label1.setBackground(Color.YELLOW);
		    	label1.setOpaque(true);
		    	pane.add(label1,c);
		    	
		    	label1 = new JLabel(allTeams[allMatches[i][1]].getTeamName());
		    	c.gridx = 3;
		    	c.gridy = i;
		    	label1.setHorizontalAlignment(SwingConstants.LEFT);
		    	label1.setBackground(Color.YELLOW);
		    	label1.setOpaque(true);
		    	pane.add(label1,c);
		    	
		    	pane.revalidate();
	    	    frame.revalidate();
				break;
				
			case 2: // team 1 win				
				// team 1
				leagueTable[allMatches[i][0]][1]++;
				leagueTable[allMatches[i][0]][2]++;
				leagueTable[allMatches[i][0]][5] += 3;
				
				// team 2
				leagueTable[allMatches[i][1]][1]++;
				leagueTable[allMatches[i][1]][4]++;
				
				System.out.println("                       " + allTeams[allMatches[i][0]].getTeamName() + " WON ");
				
				// set panel colors
				label1 = new JLabel(allTeams[allMatches[i][0]].getTeamName());
		    	c.gridx = 1;
		    	c.gridy = i;
		    	label1.setHorizontalAlignment(SwingConstants.RIGHT);
		    	label1.setBackground(Color.GREEN);
		    	label1.setOpaque(true);
		    	pane.add(label1,c);
		    	
		    	label1 = new JLabel(allTeams[allMatches[i][1]].getTeamName());
		    	c.gridx = 3;
		    	c.gridy = i;
		    	label1.setHorizontalAlignment(SwingConstants.LEFT);
		    	label1.setBackground(Color.RED);
		    	label1.setOpaque(true);
		    	pane.add(label1,c);
		    	
		    	pane.revalidate();
	    	    frame.revalidate();
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
		int[][] leagueStandingReverse = leagueTable;
		int[][] leagueStanding = new int[leagueTable.length][6];
		Arrays.sort(leagueStandingReverse, Comparator.comparingInt(arr ->arr[5]));
				
		for(int i=0; i<leagueTable.length; i++)
		{
			for(int j=0; j<6; j++)
			{
				leagueStanding[(leagueTable.length-1-i)][j] = leagueStandingReverse[i][j];
			}		
		}
		return leagueStanding;
	}
}
