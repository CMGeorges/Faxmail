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
import Modele.RegistreUtilisateur;
import Modele.Utilisateur;

/**
 *Cette class est dédier au méthode de controle d'accès au session.
 * @author camsl
 */
public class Controleur {
   
   

    /**
     * 
     * @param userN
     * @param pwd
     * @return boolean
     * @throws TrueUserException 
     */
    public static boolean ConnexionUtilisateur(String userN, String pwd) throws TrueUserException {
        while(userN != null && pwd != null) {
           Utilisateur u1 = new Utilisateur(userN,pwd);
            if (Controleur.isAUser(u1)) {
                return true;
            }else              
                throw new TrueUserException("L'utilisateur ou le Mot de passe inséré sont incorrecte");
         
        }
            return false;
    }


    /**
     * 
     * @param u1
     * @return
     * @throws TrueUserException 
     */
    private static boolean isAUser(Utilisateur u1) throws TrueUserException {
        boolean result=false;
        ManipFichier.lectureFichier("UtilisateurData.txt",AppCtr.utilisateurs);
        for (Utilisateur u : AppCtr.utilisateurs) {
            
            if (u.equals(u1)) {
                result =true ;
                break;
            }else
                result = false;
            continue;

            //System.out.println("Test equals"+u.equals(u1));
        }
        return result;
    }
    
}
