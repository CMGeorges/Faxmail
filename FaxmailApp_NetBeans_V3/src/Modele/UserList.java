/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;
import java.util.Iterator;
import utilitaire.Controleur;

/**
 *
 * @author camsl
 */
public class UserList extends ArrayList<Agent>{

   
    
public UserList getRegistre() {
        return this;
    }
    
    public void addUser(Agent user){
        this.add(user);
    }
    public void listerUser(){
    	Iterator it = this.iterator();
    	while (it.hasNext()){
    		System.out.println(it.next());
    	}
    }

    public Agent sortirDossiers(Agent u){
        Agent ag =null;
        for(Agent agt:this){
            if (agt.equals(u)) {
                ag= agt;
            }
        }
    return ag;
   
    }
    
    
    
    
}
