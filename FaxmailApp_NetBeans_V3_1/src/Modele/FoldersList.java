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
import javax.swing.plaf.synth.Region;
import utilitaire.Affichage;

/**
 *
 * @author camsl
 */
public class FoldersList extends ArrayList<Folder> implements Affichage{

    

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
     * @param dos
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
        for(Folder fold:folds){            
            for(String reg:enq.getRegions()){
                if (fold!=null && reg!=null) {
                    if (fold.getPatient().getRegion().equals(reg)) {
                        nFold.addFolder(fold);
                    }
                }
            }        
        }
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
    
    
}
