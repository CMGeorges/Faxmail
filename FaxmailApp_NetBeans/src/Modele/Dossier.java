/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *les dossiers des patients 
 * @author camsl
 */
public class Dossier {
    private int numDossier;
    private Patient patient;

    public Dossier() {
    }

    /**
     * 
     * @param numDossier
     * @param patient 
     */
    public Dossier(int numDossier, Patient patient) {
        this.numDossier = numDossier;
        this.patient = patient;
    }
    
}