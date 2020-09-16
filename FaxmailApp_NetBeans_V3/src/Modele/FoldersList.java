/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Control.AppCtr;
import Data.ManipFichier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.plaf.synth.Region;

/**
 *
 * @author camsl
 */
public class FoldersList extends ArrayList<Folder>{

    

    public FoldersList() {
    }

    public FoldersList(Collection<? extends Folder> c) {
        super(c);
    }
    
    public FoldersList getFolders() {
        return this;
    }
    
    public void addFolder(Folder dos){
        this.add(dos);
    }
    public void listerFolders(){
    	Iterator it = this.iterator();
    	while (it.hasNext()){
    		System.out.println(it.next());
    	}
    }
    
    public FoldersList findFolders(Enqueteur enq){
        FoldersList nFold=null;
        ManipFichier.LectureObjet("FoldersData.bin", this);
        for(Folder fold:this){
            
            for(String reg:enq.getRegions()){
                if (fold.getPatient().getRegion()==reg) {
                    nFold.addFolder(fold);
                }
            }
        
        }
        return nFold;
    }
    
    
}
