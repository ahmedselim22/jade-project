/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadeproject;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"
 * @author selim
 */
public class center extends Agent {
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
     
    @Override
    protected void setup(){
        
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                for (int i = 0; i < group1.size(); i++) {
                    ACLMessage m1 = new ACLMessage();
                    m1.addReceiver(new AID(group1.get(i), false));
                    m1.setContent(group1.get(i)+" X "+group2.get(i)+" in "+stadium[i]+"stadium at "+times[i]+" pm, match referee will be "+referees[i]);
                    m1.setPerformative(ACLMessage.INFORM);
                    send(m1);
                    //System.out.println("message of"+i+"sent");
                }
                for (int i = 0; i < group2.size(); i++) {
                    ACLMessage m2 = new ACLMessage();
                    m2.addReceiver(new AID(group2.get(i), false));
                    m2.setContent(group2.get(i)+" X "+group1.get(i)+" in "+stadium[i]+"stadium at "+times[i]+" pm , match referee will be "+referees[i]);
                    m2.setPerformative(ACLMessage.INFORM);
                    send(m2);
                    //System.out.println("message of"+i+"sent");
                }
            }
        });
                    
            addBehaviour(new Behaviour() {
            @Override
            public void action() {
            for(int x = 1; x <=5; x++) {
            if (x==1) {
                group1.add("a");
                group1.add("b");
                group1.add("c");
                group1.add("d");
                group1.add("e");
                group1.add("f");
                group1.add("g");
                group1.add("h");
                group2.add("i");
                group2.add("j");
                group2.add("k");
                group2.add("l");
                group2.add("m");
                group2.add("n");
                group2.add("o");
                group2.add("b");
                System.out.println("group1 "+group1);
                System.out.println("group2 "+group2);
                
//                returnRoundWinner(group1, group2, 8);
//                System.out.println("r 16 winners :"+ rWinners);
//            }
//            else if (i==2) {
//                copyWinnersIn2Groups(rWinners, 8);
//                returnRoundWinner(group1, group2, 4);
//                System.out.println("r 8 winners :"+ rWinners);
//            }
//            else if (i==3) {
//                copyWinnersIn2Groups(rWinners, 2);
//                returnRoundWinner(group1, group2, 2);
//                System.out.println("r 4 winners :"+ rWinners);
//            }
//            else if (i==4) {
//                copyWinnersIn2Groups(rWinners, 1);
//                returnRoundWinner(group1, group2, 1);
//                System.out.println("r 16 winners :"+ rWinners);
//            }
//            else{
//        System.out.println(rWinners+" is the champion ");
//        }
//}}
            
            
                for (int j = 0; j < 8; j++) {
                    while(team1Score==team2Score){
                    team1Score=rand.nextInt(10);
                    team2Score=rand.nextInt(10);
                    }
//                if(team1Score==team2Score){
//                
//                }
//                    else {
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
//            }
                System.out.println("rwinners "+rWinners);
                System.out.println("rLosers "+rLosers);
                sendWinMessage(rWinners);
                sendLoseMessage(rLosers);
                System.out.println(" ******************** Round 16 ******************** ");
                print(rWinners, rWinnersScores, rLosers, rLosersScores);
                System.out.println("round Winners "+ rWinners);
                show(rWinners, rWinnersScores, rLosers, rLosersScores);
//                counter++;
                group1.clear();
                group2.clear();
                rWinnersScores.clear();
                rLosers.clear();
                rLosersScores.clear();
            }
            else if (x==2) {
                //copy r16winners in r8 players
                    for (int i = 0; i < 4; i++) {
                        group1.add(rWinners.get(i));
                        group2.add(rWinners.get(i+4));
                    }
                    rWinners.clear();
                for (int j = 0; j < 4; j++) {
                    while(team1Score==team2Score){
                    team1Score=rand.nextInt(10);
                    team2Score=rand.nextInt(10);
                    }
//                if(team1Score==team2Score){
//                
//                }
//                    else {
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
//            }
                sendWinMessage(rWinners);
                sendLoseMessage(rLosers);
                System.out.println(" ******************** Round 8 ******************** ");
                print(rWinners, rWinnersScores, rLosers, rLosersScores);
                System.out.println("round Winners "+ rWinners);
                show(group1, rWinnersScores, group1, rLosersScores);
//                counter++;
                group1.clear();
                group2.clear();
                rWinnersScores.clear();
                rLosers.clear();
                rLosersScores.clear();
            }
            else if(x==3){
                //copy r8winners in r4 players
                    for (int i = 0; i < 2; i++) {
                        group1.add(rWinners.get(i));
                        group2.add(rWinners.get(i+2));
                    }
                    rWinners.clear();
                for (int j = 0; j < 2; j++) {
                    while(team1Score==team2Score){
                    team1Score=rand.nextInt(10);
                    team2Score=rand.nextInt(10);
                    }
//                if(team1Score==team2Score){
//                
////                }
////                    else {
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
//            }
                sendWinMessage(rWinners);
                sendLoseMessage(rLosers);
                System.out.println(" ******************** Round 4 ******************** ");
                print(rWinners, rWinnersScores, rLosers, rLosersScores);
                System.out.println("round Winners "+ rWinners);
                show(group1, rWinnersScores, group1, rLosersScores);
//                counter++;
                group1.clear();
                group2.clear();
                rWinnersScores.clear();
                rLosers.clear();
                rLosersScores.clear();
            }
            else if(x==4){
                 //copy r4winners in r2 players
                for (int i = 0; i < 1; i++) {
                        group1.add(rWinners.get(i));
                        group2.add(rWinners.get(i+1));
                }
                rWinners.clear();
                for (int j = 0; j < 1; j++) {
                    while(team1Score==team2Score){
                    team1Score=rand.nextInt(10);
                    team2Score=rand.nextInt(10);
                    }
//                if(team1Score==team2Score){
//                
//                }
//                    else {
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
//            }
                sendChampionMessage(rWinners);
                sendFnalLoserMessage(rLosers);
                System.out.println(" ******************** Round 2 ******************** ");
                print(rWinners, rWinnersScores, rLosers, rLosersScores);
                System.out.println("round Winners "+ rWinners);
                Champion(rWinners);
//                counter++; 
//                 
            }else{
                    System.out.println(rWinners+ " is the champion");
                    }
            

            }
            }
                  
            public  void show(ArrayList<String> w,ArrayList<Integer> ws , ArrayList<String> l, ArrayList<Integer> ls) {
                    JFrame frame= new JFrame();
                    frame.setSize(500, 500);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setLayout(new GridLayout(24, 1));
                    for (int i = 0; i < w.size(); i++) {
                    JLabel winner = new JLabel("team "+w.get(i) + " scores "+ Integer.toString(ws.get(i))+" goals",JLabel.LEFT );
                    JLabel loser = new JLabel("team "+l.get(i) + " scores "+ Integer.toString(ls.get(i))+" goals",JLabel.LEFT);
                    JLabel fWinner = new JLabel("team "+ w.get(i)+ " is the winner !",JLabel.LEFT);
                    frame.add(winner);
                    frame.add(loser);
                    frame.add(fWinner);
                    frame.setVisible(true);
                }
            }
            public  void Champion(ArrayList<String> s) {
                    JFrame frame= new JFrame();
                    frame.setSize(500, 500);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setLayout(new GridLayout(1, 1));
                    JLabel finalWinner = new JLabel("team "+s.get(0)+ " is the champion "+JLabel.LEFT );
                    frame.add(finalWinner);
                    frame.setVisible(true);
                    
            }
            
            @Override
            public boolean done() {
                return true;
            }
            
            
         }); 
    }  
    @Override
    protected void takeDown(){
    }
    public void print(ArrayList<String> w , ArrayList<Integer> ws , ArrayList<String> l , ArrayList<Integer> ls ){
        for (int j = 0; j <w.size()  ;j++) {
            System.out.println("team "+w.get(j)+" scores "+ws.get(j));
            System.out.println("team "+l.get(j)+" scores "+ls.get(j));
            System.out.println("team "+w.get(j)+" is the winner !");
//            if (counter==5) {
//                System.out.println("team "+w.get(j)+" is the champion ");
//            }
        }
    }
    public  void sendWinMessage(ArrayList<String> w ) {
        ACLMessage winnerMessage = new ACLMessage();
        for (int i = 0; i < w.size(); i++) {
        winnerMessage.addReceiver(new AID(w.get(i), false));
        winnerMessage.setContent("congratulation you qualified to round 8 !!");
        winnerMessage.setPerformative(ACLMessage.INFORM);
        send(winnerMessage);
    }}
    public  void sendLoseMessage(ArrayList<String> l) {
        ACLMessage loseerMessage = new ACLMessage();
        for (int i = 0; i < l.size(); i++) {
        loseerMessage.addReceiver(new AID(l.get(i), false));
        loseerMessage.setContent("d");
        loseerMessage.setPerformative(ACLMessage.INFORM);
        send(loseerMessage);
    }}
    public void sendChampionMessage(ArrayList<String> s){
        ACLMessage message = new ACLMessage();
        message.addReceiver(new AID(s.get(0), false));
        message.setContent("Congratulation you are the champion !!!");
        message.setPerformative(ACLMessage.INFORM);
        send(message);
    }
    public void sendFnalLoserMessage(ArrayList<String> s){
        ACLMessage message = new ACLMessage();
        message.addReceiver(new AID(s.get(0), false));
        message.setContent("you are in the second plac , good work !");
        message.setPerformative(ACLMessage.INFORM);
        send(message);
    }
    
//     public  void returnRoundWinner(ArrayList<String> group1 , ArrayList<String> group2 , int size ){
//         rWinners.clear();
//         for (int j = 0; j < size; j++) {
//                if(team1Score==team2Score){
//                while(team1Score!=team2Score){
//                    team1Score=rand.nextInt(10);
//                    team2Score=rand.nextInt(10);
//                    }
//                }
//                    else {
//                        if(team1Score>team2Score){
//                            rWinnersScores.add(team1Score);
//                            rLosersScores.add(team2Score);
//                            rWinners.add(group1.get(j));
//                            rLosers.add(group2.get(j));
////                            frame.getContentPane().add(new JButton("team "+s1[j]));a
//
//                        }
//                        else{
//                            rWinnersScores.add(team2Score);
//                            rLosersScores.add(team1Score);
//                            rWinners.add(group2.get(j));
//                            rLosers.add(group1.get(j));
////                            frame.getContentPane().add(new JButton("team "+s2[j]));
//                        }
//                            team1Score=rand.nextInt(10);
//                            team2Score=rand.nextInt(10);
//                    }
//            }
//                group1.clear();
//                group2.clear();
//                rWinnersScores.clear();
//                rLosers.clear();
//                rLosersScores.clear();
//                counter++;
//                
////                System.out.println("round winners "+rWinners);
//            
//     }
//     public void copyWinnersIn2Groups(ArrayList<String> s ,int size){
//         group1.clear();
//         group2.clear();
//         for (int i = 0; i < size; i++) {
//             group1.add(s.get(i));
//             group2.add(s.get(i+(size/2)));
//         }
//     }
}

