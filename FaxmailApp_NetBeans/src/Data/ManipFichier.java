/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Exception.TrueUserException;
import Modele.Enqueteur;
import Modele.RegistreUtilisateur;
import Modele.Utilisateur;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @version 1.0
 * La manipulation de fichier txt ou xmls
 * pour la lecture et l'ecriture de donnée
 * dans une version future des requêtes à une base de donnée sera effectuer
 *
 * @author camsl
 */
public class ManipFichier {
    
    
    /**
     * 
     * @param nomFichier
     * @param datas
     * @throws TrueUserException 
     */
    public static void lectureFichier(String nomFichier,RegistreUtilisateur datas) throws TrueUserException{
        FileReader fr = null;
        
        try {
            File file = new File(nomFichier);
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            //la lecture 
            String ligne;
            while ((ligne = br.readLine()) != null) {                
                //System.out.println(ligne);
                
                Utilisateur U = parseLigneUtilisateur(ligne);                
                try {
                    if (U != null) {
                        datas.add(U);
                        System.out.println("Test"+U);
                    }
                } catch (NullPointerException e) {
                    //System.out.println(e.getMessage());
                }finally{
                    
                }
            }
        } catch (FileNotFoundException e) {
             Logger.getLogger(ManipFichier.class.getName()).log(Level.SEVERE, null, e);
        }catch(IOException ex){
            Logger.getLogger(ManipFichier.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if (fr!=null) {
                    fr.close();
                }                
            } catch (IOException ex) {
                Logger.getLogger(ManipFichier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
    /**
     * 
     * @param ligne
     * @return 
     */
    private static Utilisateur parseLigneUtilisateur(String ligne) {
       final String[] tokens = ligne.split(" ");
       final Utilisateur U;
        if (tokens.length==2) {
            final String nomUtilisateur =tokens[0];
            final String motDePasse=tokens[1];
              U= new Utilisateur(nomUtilisateur,motDePasse);
       
        }else{
        //System.out.println("Test1"+tokens.toString());
       final String nomUtilisateur =tokens[0];
       final String motDePasse=tokens[1];
       
       final int matricule = Integer.parseInt(tokens[2]);
             U = new Enqueteur(matricule,nomUtilisateur, motDePasse);
       
        }        
       return U;
        
    }
    
}
