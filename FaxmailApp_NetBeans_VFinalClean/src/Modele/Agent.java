/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.io.Serializable;

/**
 *Un agent détient les permission d'un Administrateur dans l'application.
 * Il peut modifier et créer des dossiers.
 * @author camsl
 */
public class Agent implements Serializable, Comparable<Agent>{
    
        private String nomUtilisateur;
        private String motDePasse;

    public Agent(String nomUtilisateur, String motDePasse) {
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
    }

        
    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    
    

        @Override
    public String toString() {
        return nomUtilisateur+" "+motDePasse; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==null) {
            return false;
        }
        if (Agent.class != obj.getClass()) {
            return false;
            
        } else {            
            final Agent other = (Agent)obj;
                System.out.println("Test equals source: "+ other + this);
                 System.out.println(this.nomUtilisateur + other.nomUtilisateur +'|'+ this.motDePasse + other.motDePasse);
               System.out.println((this.nomUtilisateur.equals(other.nomUtilisateur)&&this.motDePasse.equals(other.motDePasse)));
               if ((this.nomUtilisateur.equals(other.nomUtilisateur)&&this.motDePasse.equals(other.motDePasse))) {
                return true;
            
            }else
                return false;
            

        }
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Agent o) {
        if (nomUtilisateur.compareTo(o.getNomUtilisateur())==0) {
            return 0;
            
        }else if (nomUtilisateur.compareTo(o.getNomUtilisateur())<0) {
            return -1;
        }else
            return 1;
    }

       
    

    
    
}
