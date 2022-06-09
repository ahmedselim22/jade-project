/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadeproject;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author selim
 */
public class n extends Agent{
    @Override
    protected void setup(){
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage acl = receive();
                if(acl!=null){
//                    System.out.println("sender :"+acl.getSender());
//                    System.out.println("content : "+acl.getContent());
                      //System.out.println("n recieved \n");
                      if ("d".equals(acl.getContent())) {
                        doDelete();
                    }
                }
            }
        });
    }
    @Override
    protected void takeDown(){
        
    }
}
