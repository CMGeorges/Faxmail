/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Exception.NotUpdateYetExecption;
import Exception.TrueUserException;
import Modele.Adresse;
import Modele.Enqueteur;
import Modele.UserList;
import Modele.Agent;
import Modele.Declaration;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @version 0.5
 * La manipulation de fichier txt et binaire
 * pour la lecture et l'ecriture de donnée
 * dans une version future des requêtes à une base de donnée sera effectuer
 *
 * @author camsl
 */
public class ManipFichier{
    
    
    /**
     * Lecture de fichiers text.
     * Simulation de connection a une BDD
     * Cette méthode est pour la récupération des Comptes utilisateurs:
     * Agent,Enqueteur
     * @param nomFichier : chemin du fichiers
     * @param datas : list d'utlisateurs
     * @throws TrueUserException : vérification d'utilisateur existant
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
                    Logger.getLogger(ManipFichier.class.getName()).log(Level.SEVERE, null, e);
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
     * Méthode de Désérialisation  d'un utilisateur:
     * Agent,Enqueteur.
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
     * Simulation de la requète a la BD pour la liste de dossiers.
     * @param data : chemin fichier
     * @param folders : list de dossiers
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
      * Méthode de sortie d'une list de Dossiers sous format d'un fichier binaire.
      * créer un fichier binaire pour simuler une BDD.
      * @param data : chemin du fichiers ou bien nom du fichier
      * @param folders : list de dossier/Folder
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
      * Méthode de sortie d'une list Object sous format d'un fichier binaire.
      * @param data : nom du fichier
      * @param monSet : liste d'object 
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
     * Lecture de fichiers binaires.
     * Simulation de connection a une BDD
     * Cette méthode est pour la récupération des Comptes utilisateurs:
     * Agent,Enqueteur
     * @param data : chemin du fichier
     * @param utilisateurs : liste d'utilisateurs
     */
    public static void LectureObjet(String data, UserList utilisateurs){
         int size = 0;        
        BufferedInputStream bi = null;            
        InputStream input =null;     
        ObjectInputStream objInpoutStream=null;
        Agent agt=null;
       // Enqueteur enq=null;
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
                            //System.out.println(agt);
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
    /**
     * Méthode de Désérialisation  d'une Date
     * @param dateString : date en string 
     * @return : date
     * @throws ParseException : exception de parse
     */
    public static Date StringToDate(String dateString) throws ParseException {
      //Instantiating the SimpleDateFormat class
      SimpleDateFormat formatter = new SimpleDateFormat("DD-MM-YYYY");
      //Parsing the given String to Date object
      Date date;  
      if (dateString==null||"".equals(dateString)) {
           date=null; 
        }else
            date= formatter.parse(dateString);
      //System.out.println("Date object value: "+date);
      return date;
   }

    /**
     * Méthode de Désérialisation pour une Adresse 
     * @param text : Adresse en String
     * @return : Adresse
     */
    public static Adresse parseAdresse(String text) {
        final String[] tokens = text.split(",");
        final Adresse A;
        
        final int numCivil = Integer.parseInt(tokens[0]);
        final String app =tokens[1];
        final  String rue = tokens[2];
        final String codeP = tokens[6];
        final String ville= tokens[3];
        final String province= tokens[4];
        final String pays  = tokens[5];   
       
        A= new Adresse(numCivil, rue, app,codeP,ville,province,pays);
    
        return A;
    }

    /**
     * Pour traduire un object Date en object String. 
     * @param dateDeNaissance : date de naissnce (Date)
     * @return : String
     */
    public static String toStringDate(Date dateDeNaissance) {
        if (dateDeNaissance==null) {
            return "";
        }
        System.out.println("Date trouver: "+dateDeNaissance);
        return dateDeNaissance.getDate()+"-"+dateDeNaissance.getMonth()+"-"+dateDeNaissance.getYear();
    }

    /**
     * Le lecture par type de fichiers.
     * @param f : File
     * @param folds :FoldersList
     * @throws NotUpdateYetExecption : NotUpdateYetExecption
     */
    public static void lectureDeclaration(File f, FoldersList folds) throws NotUpdateYetExecption {
/*           ÉVENTUELLEMENT LA POSSIBILITÉ DE LIRE DES FICHIER TXT                                                    */
        String suffix = ".txt";
        if (f.getPath().endsWith(suffix)) {
           //Pour Txt
        //lectureDeclarationTxt(f, folds); 
        throw new NotUpdateYetExecption("Cette version d'application ne dispose pas de la capacité de lire des fichiers txt.\n Veuillez attendre la prochaine version pour cette capacité.");
        }else      
        //Pour Bin
        lectureDeclarationBin(f, folds);
        
    }

    /**
     * La Lecture d'une déclaration.
     * fichier binaire seulement.
     * @param f : File
     * @param folds : FoldersList
     */
    public static void lectureDeclarationBin(File f, FoldersList folds) {
        
        //long size = 0;
        BufferedInputStream bi = null;
        InputStream input =null;     
        ObjectInputStream objInpoutStream=null;
        Declaration declaration;
        try {
            
            input =new FileInputStream(f);
            bi = new BufferedInputStream(input);             
            objInpoutStream = new ObjectInputStream(bi);
            try {
                //size = objInpoutStream.readUnsignedByte();
                //for (int i = 0; i < size; i++) {
                    declaration = (Declaration)objInpoutStream.readObject();
                   // System.out.println("La déclaration: "+declaration);
                   
                    //gestion de la nouvelle déclaration
                    folds.receptionDeDeclaration(declaration);
                    folds.display();
               // }
                
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

        
    /**
     * L'impression de déclaration sous forme binaire.
     * il sort un fichier binaire .
     * @param declaration : Declaration
     * @param countD : int
     */
    public static void ecrireDeclaration(Declaration declaration,int countD ){  
        //int count=0;
        File file =null;
        FileOutputStream fos =null;
        BufferedOutputStream bos = null;
        ObjectOutputStream objectOutputStream=null;   
        try {
            String dile = declaration.getNomPatient()+String.valueOf(countD)+".bin";
          file = new File(dile); 
          fos = new FileOutputStream(file);
          bos = new BufferedOutputStream(fos);
          objectOutputStream = new ObjectOutputStream(bos);
          objectOutputStream.writeObject(declaration);
              
        } catch (IOException e) {
            Logger.getLogger(ManipFichier.class.getName()).log(Level.SEVERE, null, e);

        }finally{
            try {
                if (objectOutputStream!=null) {
                    objectOutputStream.close();
                }
                if (bos !=null) {
                    bos.close();
            System.out.println("Ecriture du fichier binaire reussie."+declaration.getNomPatient());
                }
                
            } catch (IOException e) {
                  Logger.getLogger(ManipFichier.class.getName()).log(Level.SEVERE, null, e);

            }
            
        }
    }

    
}

    /**
     * 
     * @param f : File
     * @param folds 
     *//*
    public static void lectureDeclarationTxt(File f, FoldersList folds) {
        
        FileReader fr = null;
        BufferedReader br=null;
        try {
            
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            //la lecture
            String ligne;
            while ((ligne = br.readLine()) != null) {
                //System.out.println(ligne);
                //ArrayList<String> lignes = new ArrayList<String>();
                //lignes.add(ligne);
                
                try {
                    Declaration declaration = parseLigneDeclaration(ligne);
                    if (declaration != null) {
                        //gestion de la nouvelle déclaration
                        folds.receptionDeDeclaration(declaration);
                        //System.out.println("Test"+U);
                    }
                } catch (NullPointerException | ParseException e) {
                    //System.out.println(e.getMessage());
                    Logger.getLogger(ManipFichier.class.getName()).log(Level.SEVERE, null, e);
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
     * A terminer... 
     * @param ligne
     * @return
     * @throws ParseException 
     *//*
    private static Declaration parseLigneDeclaration(String ligne) throws ParseException {
        Declaration declaration = new Declaration();
        //String[] tokens = lignes.split(";");
        Scanner s = new Scanner(ligne);
        s.skip("\\p{:}");
        String declarant=s.next();
        //String[] tokensP = lignes[0].spli;
        
//        
//        String nomPatient = tokens[1];
//        String sexe = tokens[2];
//        Date dateNaissance = StringToDate(tokens[3]);
//        Adresse adress = parseAdresse(tokens[4]);
//        String numAss = tokens[5];
//        String telephone = tokens[6];
//        String nomMedecin = tokens[7];
//        String numPermis = tokens[8];
//        String milieu = tokens[9];
//        String adressM = tokens[10];
//        Date datePre = StringToDate(tokens[11]);
//        String typePre = tokens[12];
//        String SitePre = tokens[13];
//        Date dateExec = StringToDate(tokens[14]);
//        String nomDemande = tokens[15];
//        String analyse = tokens[16];
//        String resultat = tokens[17];
        
        
        
        
        return declaration;
    }*/
    
