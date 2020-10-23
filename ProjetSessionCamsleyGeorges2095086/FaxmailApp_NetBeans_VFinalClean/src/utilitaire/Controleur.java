/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaire;

import Control.AppCtr;
import static Control.AppCtr.utilisateurs;
import Data.ManipFichier;
import Exception.TrueUserException;
import Modele.UserList;
import Modele.Agent;
import java.io.IOException;
import ui.FenLogin;

/**
 *Cette class est dédier au méthode de controle d'accès au session.
 * 
 * @author camsl
 */
public class Controleur {
   
   

    /**
     * Méthode de connection.
     * @param userN: nom de l'utilisateur
     * @param pwd : Mot de passe
     * @return boolean
     * @throws TrueUserException : vérification d'utilisateur existant
     */
    public static boolean ConnexionUtilisateur(String userN, String pwd) throws TrueUserException {
        while(userN != null && pwd != null) {
           Agent u1 = new Agent(userN,pwd);
            if (Controleur.isAUser(u1)) {
                return true;
            }else              
                throw new TrueUserException("L'utilisateur ou le Mot de passe inséré sont incorrecte");
         
        }
            return false;
    }


    /**
     * Fonction booléan qui  vérifie si l'utilisateur existe.
     * @param u1 : Agent= utilisateur
     * @return :result
     * @throws TrueUserException : vérification d'utilisateur existant
     */
    public static boolean isAUser(Agent u1) throws TrueUserException {
        boolean result=false;
        //ManipFichier.lectureFichier("UtilisateurData.txt",AppCtr.utilisateurs);
        for (Agent u : AppCtr.utilisateurs) {
            
            if (u.equals(u1)) {
                result =true ;
                break;
            }else
                result = false;
            //System.out.println("Test equals"+u.equals(u1));
        }
        return result;
    }
}
