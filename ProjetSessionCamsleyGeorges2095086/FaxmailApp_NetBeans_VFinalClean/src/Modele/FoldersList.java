/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Control.AppCtr;
import static Control.AppCtr.folds;
import Data.ManipFichier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.function.Consumer;
import javax.swing.plaf.synth.Region;
import utilitaire.Affichage;

/**
 *Cette classe est une liste de la classe Folder.
 * @author camsl
 */
public class FoldersList extends TreeSet<Folder> implements Affichage{

    

    public FoldersList() {
    }

    public FoldersList(Collection<? extends Folder> c) {
        super(c);
    }
    
    public FoldersList getFolders() {
        return this;
    }
    
    /**
     *
     * @param dos :Folder
     */
    public void addFolder(Folder dos){
        this.add(dos);
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
    
    public FoldersList findFolders(Enqueteur enq)throws NullPointerException{
        FoldersList nFold= new FoldersList();        
        folds.forEach((Folder fold) -> {
            enq.getRegions().stream().filter((reg) -> (fold!=null && reg!=null)).filter((reg) -> (fold.getPatient().getRegion().equals(reg))).forEachOrdered((_item) -> {
                nFold.addFolder(fold);
            });
        });
        return nFold;
    }

    public Folder searchFolder(String elementAt) {
        Folder f = new Folder();
        if(elementAt != null){
            for(Folder fo:folds){
                if (elementAt.equals(String.valueOf(fo.getNumDossier()))) {
                    f=fo;
                } 
            }
        }
       return f;
    }

    /**
     * Problème l'ajout ne ce fait pas.//Problème régler 2020-10-10
     * @param declaration :Declaration
     */
    public void receptionDeDeclaration(Declaration declaration) {
       //Recherhe de l'existance d'un dossier au nom de la Déclaration.
       boolean exist=false;
       for(Folder f:this){
           if (f.getPatient().getRamq() == null ? declaration.getNumAssMAl() == null : f.getPatient().getRamq().equals(declaration.getNumAssMAl())) {
               f.getEpisodes().addDeclaration(declaration);
               System.out.println("Voici la nouvel déclaration: "+f.getEpisodes().toString());
               this.display();
               exist=true;
           }
       
       }
        if (exist!=true) {
            String id = declaration.getNumAssMAl().substring(4);
            String[] tokens = declaration.getNomPatient().split(",");
            Folder newFolder = new Folder(Integer.parseInt(id),new Patient(Integer.parseInt(id),tokens[0], tokens[1], declaration.getAdresse().getVille(), declaration.getSexe(), declaration.getNumAssMAl(), null,null, declaration.getDateDeNaissance(), declaration.getAdresse()),new Episode());
            newFolder.getEpisodes().add(declaration);
            this.addFolder(newFolder);
            
            System.out.println("Nouveau dossier créer!! \n"+newFolder);
            this.display();
        }
       
       

        // Rajouter Declaration dans son dossier
        
        //Sinon Creer nouveau Dossier avec nouvelle declaration a l'intérieur.
    }

    
    
    
    
}
