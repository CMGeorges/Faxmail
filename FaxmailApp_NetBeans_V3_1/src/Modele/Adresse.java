/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.io.Serializable;
import utilitaire.Affichage;

/**
 *
 * @author camsl
 */
public class Adresse implements Serializable{

    private int numCivil;
    private String rue,appartement,codePostal,ville,province,pays;
    
    public int getNumCivil() {
        return numCivil;
    }

    public void setNumCivil(int numCivil) {
        this.numCivil = numCivil;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getAppartement() {
        return appartement;
    }

    public void setAppartement(String appartement) {
        this.appartement = appartement;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
    
    
    
    public Adresse(int numCivil, String rue, String appartement, String codePostal, String ville, String province, String pays) {
        this.numCivil = numCivil;
        this.rue = rue;
        this.appartement = appartement;
        this.codePostal = codePostal;
        this.ville = ville;
        this.province = province;
        this.pays = pays;
    }
           
        public Adresse() {
            
        }

    @Override
    public String toString(){
        return numCivil+", "+appartement+", "+rue+", "+ville+", "+province +", "+ pays +", "+codePostal;
    }
    
}
