/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadeproject;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author selim
 */
public class centerHelp {
    Random rand=new Random();
     ArrayList<String> group1 =new ArrayList<>(); //"a","b","c","d","e","f","g","h"};
     ArrayList<String> group2 = new ArrayList<>();//{"i","j","k","l","m","n","o","p"};
     String[] stadium= {"s1","s2","s3","s4","s5","s6","s7","s8"};
     String[] referees= {"r1","r2","r3","r4","r5","r6","r7","r8"};
     String[] times ={"t1","t2","t3","t4","t5","t6","t7","t8"};
     ArrayList<String> rWinners= new ArrayList<>();
     ArrayList<Integer> rWinnersScores = new ArrayList<>();
     ArrayList<String> rLosers= new ArrayList<>();
     ArrayList<Integer> rLosersScores = new ArrayList<>();
     int team1Score = rand.nextInt(10);
     int team2Score = rand.nextInt(10);
     static int counter=1;
     
     public  ArrayList<String> returnRoundWinner(ArrayList<String> group1 , ArrayList<String> group2 , int size ){
         rWinners.clear();
         for (int j = 0; j < size; j++) {
                if(team1Score==team2Score){
                while(team1Score!=team2Score){
                    team1Score=rand.nextInt(10);
                    team2Score=rand.nextInt(10);
                    }
                }
                    else {
                        if(team1Score>team2Score){
                            rWinnersScores.add(team1Score);
                            rLosersScores.add(team2Score);
                            rWinners.add(group1.get(j));
                            rLosers.add(group2.get(j));
//                            frame.getContentPane().add(new JButton("team "+s1[j]));a

                        }
                        else{
                            rWinnersScores.add(team2Score);
                            rLosersScores.add(team1Score);
                            rWinners.add(group2.get(j));
                            rLosers.add(group1.get(j));
//                            frame.getContentPane().add(new JButton("team "+s2[j]));
                        }
                            team1Score=rand.nextInt(10);
                            team2Score=rand.nextInt(10);
                    }
            }
                group1.clear();
                group2.clear();
                rWinnersScores.clear();
                rLosers.clear();
                rLosersScores.clear();
                return rWinners;
     }
     
        
}
