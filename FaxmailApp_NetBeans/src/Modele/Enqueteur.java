/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *L'enqueteur hérite de la class Utilisateur. 
 * C'est l'utilisateur qui fait les suivie avec les patients.
 * 
 * @author camsl
 */
public class Enqueteur extends Utilisateur{
    private int matricule;

    public Enqueteur(int matricule, String nomUtilisateur, String motDePasse) {
        super(nomUtilisateur, motDePasse);
        this.matricule = matricule;
    }

    public Enqueteur(String nomUtilisateur, String motDePasse) {
        super(nomUtilisateur, motDePasse);
    }
    
    
    
    
    
}
