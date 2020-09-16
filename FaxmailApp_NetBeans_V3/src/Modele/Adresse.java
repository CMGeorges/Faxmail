/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.io.Serializable;

/**
 *
 * @author camsl
 */
public class Adresse implements Serializable{

    public Adresse(int numCivil, String rue, String appartement, String codePostal, String ville, String province, String pays) {
        this.numCivil = numCivil;
        this.rue = rue;
        this.appartement = appartement;
        this.codePostal = codePostal;
        this.ville = ville;
        this.province = province;
        this.pays = pays;
    }
           private int numCivil;
                private String rue,appartement,codePostal,ville,province,pays;
        public Adresse() {
            
        }
    
}
