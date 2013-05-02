package main;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import java.io.*;
public class Main extends JPanel
{
	private static final long serialVersionUID = 1L;
	static ArrayList<Location> current=new ArrayList<Location>();
	
	static MainPanel M=new MainPanel();
	static int gen=1;
	static int S=5;
	static int maxCol=0;
	static int maxRow=0;
	static int minCol=0;
	static int minRow=0;
	static int rowPadding=5;
	static int colPadding=5;
	public static void calcNext(){
		synchronized(current){
			ArrayList<Location> temp=new ArrayList<Location>();
			
		gen++;
		temp.clear();
                ArrayList<Location> ones=new ArrayList<Location>();
                ArrayList<Location> twos=new ArrayList<Location>();
                ArrayList<Location> threes=new ArrayList<Location>();
                ArrayList<Location> mores=new ArrayList<Location>();
                Location[][] adja=new Location[current.size()][0];
                int i=0;
                for (Location l : current){
                    adja[i++]=l.adjacent();
                }
		for(Location[] adj : adja){
                    for (Location ll : adj){
                        boolean in=mores.contains(ll);
                        if (threes.contains(ll)){
                            threes.remove(ll);
                            mores.add(ll);
                            in=true;
                        }
                        if (twos.contains(ll)){
                            twos.remove(ll);
                            threes.add(ll);
                            in=true;
                        }
                        if (ones.contains(ll)){
                            ones.remove(ll);
                            twos.add(ll);
                            in=true;
                        }
                        if (!in){
                            ones.add(ll);
                        }
                        
                    }
		}
                for (Location l : twos){
                    if (current.contains(l) && !threes.contains(l)){
                        threes.add(l);
                    }
                }
		current=threes;
	}}
	public static void makeGliderGun(){
		current.add(new Location(5,1));
		current.add(new Location(5,2));
		current.add(new Location(6,1));
		current.add(new Location(6,2));
		current.add(new Location(3,13));
		current.add(new Location(3,14));
		current.add(new Location(4,12));
		current.add(new Location(5,11));
		current.add(new Location(6,11));
		current.add(new Location(7,11));
		current.add(new Location(8,12));
		current.add(new Location(9,13));
		current.add(new Location(9,14));
		current.add(new Location(6,15));
		current.add(new Location(6,17));
		current.add(new Location(7,17));
		current.add(new Location(5,17));
		current.add(new Location(4,16));
		current.add(new Location(8,16));
		current.add(new Location(6,18));
		current.add(new Location(5,21));
		current.add(new Location(4,21));
		current.add(new Location(3,21));
		current.add(new Location(5,22));
		current.add(new Location(4,22));
		current.add(new Location(3,22));
		current.add(new Location(2,23));
		current.add(new Location(2,25));
		current.add(new Location(1,25));
		current.add(new Location(6,23));
		current.add(new Location(6,25));
		current.add(new Location(7,25));
		current.add(new Location(3,35));
		current.add(new Location(4,35));
		current.add(new Location(3,36));
		current.add(new Location(4,36));
	}
	public static void makeGlider(){
		current.add(new Location(0,0));
		current.add(new Location(1,1));
		current.add(new Location(1,2));
		current.add(new Location(0,2));
		current.add(new Location(-1,2));
	}
        public static void makeAcorn(){
            current.add(new Location(2,0));
            current.add(new Location(2,1));
            current.add(new Location(0,1));
            current.add(new Location(1,3));
            current.add(new Location(2,4));
            current.add(new Location(2,5));
            current.add(new Location(2,6));
        }
        public static void makeFPentomino(){
            current.add(new Location(0,1));
            current.add(new Location(0,2));
            current.add(new Location(1,0));
            current.add(new Location(1,1));
            current.add(new Location(2,1));
        }
	public static void main(String[] args){
		current.clear();
		
		//Initial state here
		makeGliderGun();//Default
		
		new Main();
	}
	public static void write(String filename, String[] things){
		try{
			  // Create file 
			  FileWriter fstream = new FileWriter("out.txt");
			  BufferedWriter out = new BufferedWriter(fstream);
			  out.flush();
			  for (String a : things){
				  out.write(a);
				  out.write(new char[] {(char)12});
			  }
			  //Close the output stream
			  out.close();
			  }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
	}
	public Main(){
	
	JFrame frame=new JFrame("Conway's Game of Life");
	  M.setFocusable(true);
	  (frame).setContentPane(M);
	  frame.setLayout(new FlowLayout());
	  frame.setSize(1000,700);
	  //frame.setUndecorated(true);
     frame.setExtendedState(Frame.MAXIMIZED_BOTH);
	  frame.setVisible(true);
	  frame.addWindowListener(new WindowAdapter(){
	  public void windowClosing(WindowEvent e){
		RunTicker.running=false;
		System.exit(0);
	  }
	  });
          
}
}
