/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;
import java.util.Iterator;
import utilitaire.Affichage;

/**
 *
 * @author camsl
 */
public class Episode extends ArrayList<Declaration> implements Affichage{

    public Episode() {
    }
    
    
    
    
    public Episode getEpisodes() {
        return this;
    }
    
    public void addDeclaration(Declaration dec){
        this.add(dec);
    }

    /**
     *
     */
    @Override
    public void display(){
    	Iterator it = this.iterator();
    	while (it.hasNext()){
    		System.out.println(it.next());
    	}
    }
}
