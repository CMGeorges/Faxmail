/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Exception.TrueUserException;
import Modele.Enqueteur;
import Modele.UserList;
import Modele.Agent;
import Modele.Episode;
import Modele.Folder;
import Modele.FoldersList;
import Modele.Patient;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.Set;
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
    public static void lectureFichier(String nomFichier,UserList datas) throws TrueUserException{
        FileReader fr = null;
        BufferedReader br=null;
        try {
            File file = new File(nomFichier);
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            //la lecture 
            String ligne;
            while ((ligne = br.readLine()) != null) {                
                //System.out.println(ligne);
                
                Agent U = parseLigneUtilisateur(ligne);                
                try {
                    if (U != null) {
                        datas.add(U);
                        //System.out.println("Test"+U);
                    }
                } catch (NullPointerException e) {
                    //System.out.println(e.getMessage());
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
                if (br!=null) {
                    br.close();
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
    private static Agent parseLigneUtilisateur(String ligne) {
       final String[] tokens = ligne.split(" ");
       final Agent U;
        if (tokens.length==2) {
            final String nomUtilisateur =tokens[0];
            final String motDePasse=tokens[1];
              U= new Agent(nomUtilisateur,motDePasse);
       
        }else{
        //System.out.println("Test1"+tokens.toString());
       final String nomUtilisateur =tokens[0];
       final String motDePasse=tokens[1];
       
       final int matricule = Integer.parseInt(tokens[2]);
             U = new Enqueteur(matricule,nomUtilisateur, motDePasse);
       
        }        
       return U;
        
    }
    
    /**
     * 
     * @param data
     * @param folders 
     */
     public static void LectureObjet(String data,FoldersList folders){
           
        long size = 0;        
        BufferedInputStream bi = null;            
        InputStream input =null;     
        ObjectInputStream objInpoutStream=null;
        Folder fod;
        try {
           
            File file = new File(data);
            input =new FileInputStream(file);
            bi = new BufferedInputStream(input);             
            objInpoutStream = new ObjectInputStream(bi);
           
//            fod = (Folder) objInpoutStream.readObject();
//            folders.addFolder(fod);
                size = objInpoutStream.readInt();
                for (int i = 0; i < size; i++) {
                    fod = (Folder) objInpoutStream.readObject();
//                    System.out.println((Patient)fod.getPatient());
//                    System.out.println((Episode)fod.getEpisodes());
//                    System.out.println(fod.getPatient().getNom());
                    folders.addFolder(fod);
                }
               } catch (FileNotFoundException ex) {
            Logger.getLogger(ManipFichier.class.getName()).log(Level.SEVERE, null, ex);
        }catch(InvalidClassException i){
            Logger.getLogger(ManipFichier.class.getName()).log(Level.SEVERE, null, i);
        }  catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ManipFichier.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try { //registre.afficherArticles();
                if (objInpoutStream!=null) {
                 objInpoutStream.close();   
                }
                if (bi!=null) {
                    bi.close();
            System.out.println("Lecture a partir du fichier binaire reussie:" + size + " enregistrements lus.");
                }
               
            } catch (IOException ex) {
                Logger.getLogger(ManipFichier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

    }
     
     /**
      * 
      * @param data
      * @param folders 
      */
     public static void ecritureOblect(String data,FoldersList folders){
       
                     
        int count=0;
        File file =null;
        FileOutputStream fos =null;
        BufferedOutputStream bos = null;
        ObjectOutputStream objectOutputStream=null;   
        try {
          file = new File(data); 
          fos = new FileOutputStream(file);
          bos = new BufferedOutputStream(fos);
          objectOutputStream = new ObjectOutputStream(bos);
          objectOutputStream.writeInt(folders.getFolders().size());
       
          for(Folder fold :folders.getFolders()){
           
              try {
                  objectOutputStream.writeObject(fold);
           
                    count++;
              } catch (IOException e) {
                  Logger.getLogger(ManipFichier.class.getName()).log(Level.SEVERE, null, e);
                  System.out.println("Erreur ecriture");
              }
          }
       
        } catch (IOException e) {
            Logger.getLogger(ManipFichier.class.getName()).log(Level.SEVERE, null, e);

        }finally{
            try {
                if (objectOutputStream!=null) {
                    objectOutputStream.close();
                }
                if (bos !=null) {
                    bos.close();
            System.out.println("Ecriture du fichier binaire reussie.");
                }
                
            } catch (IOException e) {
                  Logger.getLogger(ManipFichier.class.getName()).log(Level.SEVERE, null, e);

            }
            
        }
    }

     /**
      * 
      * @param data
      * @param monSet 
      */
    public static void ecritureOblect(String data, Set monSet) {
         int count=0;
        File file =null;
        FileOutputStream fos =null;
        BufferedOutputStream bos = null;
        ObjectOutputStream objectOutputStream=null;   
        try {
          file = new File(data); 
          fos = new FileOutputStream(file);
          bos = new BufferedOutputStream(fos);
          objectOutputStream = new ObjectOutputStream(bos);
          objectOutputStream.writeInt(monSet.size());
       
          for(Object o :monSet){
           
              try {
                  objectOutputStream.writeObject(o);
           
                    count++;
              } catch (IOException e) {
                  Logger.getLogger(ManipFichier.class.getName()).log(Level.SEVERE, null, e);
                  System.out.println("Erreur ecriture");
              }
          }
       
        } catch (IOException e) {
            Logger.getLogger(ManipFichier.class.getName()).log(Level.SEVERE, null, e);

        }finally{
            try {
                if (objectOutputStream!=null) {
                    objectOutputStream.close();
                }
                if (bos !=null) {
                    bos.close();
            System.out.println("Ecriture du fichier binaire reussie.");
                }
                
            } catch (IOException e) {
                  Logger.getLogger(ManipFichier.class.getName()).log(Level.SEVERE, null, e);

            }
            
        }
    }

    /**
     * 
     * @param data
     * @param utilisateurs 
     */
    public static void LectureObjet(String data, UserList utilisateurs){
         int size = 0;        
        BufferedInputStream bi = null;            
        InputStream input =null;     
        ObjectInputStream objInpoutStream=null;
        Agent agt=null;
        Enqueteur enq=null;
        try {
           
            File file = new File(data);
            input =new FileInputStream(file);
            bi = new BufferedInputStream(input);             
            objInpoutStream = new ObjectInputStream(bi);
            
            try {
                size = objInpoutStream.readInt();
                 for (int i = 0; i < size; i++) {
//                     if ((Object)objInpoutStream.readObject().getClass()!=Enqueteur.class) {
                    //System.out.println((Agent) objInpoutStream.readObject());
                         agt = (Agent)objInpoutStream.readObject();
                         utilisateurs.addUser(agt);
                            System.out.println(agt);
                     }
            } catch (IOException | ClassNotFoundException e) {
                 Logger.getLogger(ManipFichier.class.getName()).log(Level.SEVERE, null, e);
            }          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManipFichier.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManipFichier.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try { 
                if (objInpoutStream!=null) {
                 objInpoutStream.close();   
                }
                if (bi != null)                   
                        bi.close();
            }catch (IOException ex) {
                Logger.getLogger(ManipFichier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
        
}
