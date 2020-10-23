/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *L'enqueteur hérite de la class Utilisateur. 
 * C'est l'utilisateur qui fait les suivie avec les patients.
 * 
 * @author camsl
 */
public class Enqueteur extends Agent implements Serializable{

    

    @Override
    public String toString() {
        return matricule+"================="+regions+"======="+getNomUtilisateur()+" "+getMotDePasse(); //To change body of generated methods, choose Tools | Templates.
    }

    
    private int matricule;
    private ArrayList<String> regions;

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public ArrayList<String> getRegions() {
        return regions;
    }

    public void setRegions(ArrayList<String> regions) {
        this.regions = regions;
    }
    
    
    
    public Enqueteur(int matricule, ArrayList<String> regions, String nomUtilisateur, String motDePasse) {
        super(nomUtilisateur, motDePasse);
        this.matricule = matricule;
        this.regions = regions;
    }

    /**
     *
     * @param matricule : int
     * @param nomUtilisateur : String
     * @param motDePasse : String
     */
    public Enqueteur(int matricule, String nomUtilisateur, String motDePasse) {
        super(nomUtilisateur, motDePasse);
        this.matricule = matricule;
    }

    public Enqueteur(String nomUtilisateur, String motDePasse) {
        super(nomUtilisateur, motDePasse);
    }

    
    
    
    
    
    
}
