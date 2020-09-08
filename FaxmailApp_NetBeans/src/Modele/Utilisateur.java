/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author camsl
 */
public class Utilisateur {
    
        private String nomUtilisateur;
        private String motDePasse;

    public Utilisateur(String nomUtilisateur, String motDePasse) {
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
        return nomUtilisateur; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==null) {
            return false;
        }
        if (Utilisateur.class != obj.getClass()) {
            return false;
            
        } else {            
            final Utilisateur other = (Utilisateur)obj;
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

       
    

    
    
}
