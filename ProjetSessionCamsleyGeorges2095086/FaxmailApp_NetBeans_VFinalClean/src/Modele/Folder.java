/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.io.Serializable;
import java.util.Calendar;

/**
 *les dossiers des patients 
 * @author camsl
 */
public class Folder implements Serializable,Comparable<Folder>{

    
    private int numDossier;
    private Patient patient;
    private Episode episodes;

    
    /**
     * 
     */
    public Folder() {
    }

    /**
     * 
     * @param numDossier :int
     * @param patient : Patient
     */
    public Folder(int numDossier, Patient patient) {
        this.numDossier = numDossier;
        this.patient = patient;
    }
    /**
     * 
     * @param numDossier : int
     * @param patient : PAtient
     * @param episodes : episodes
     */
    public Folder(int numDossier, Patient patient, Episode episodes) {
        this.numDossier = numDossier;
        this.patient = patient;
        this.episodes = episodes;
    }
    public int getNumDossier() {
        return numDossier;
    }

    public void setNumDossier(int numDossier) {
        this.numDossier = numDossier;
    }

    /**
     *
     * @return : Patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     *
     * @param patient : Patient
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     *
     * @return :episodes
     */
    public Episode getEpisodes() {
        return episodes;
    }

    /**
     *
     * @param episodes : episodes
     */
    public void setEpisodes(Episode episodes) {
        this.episodes = episodes;
    }
    
        @Override
    public int compareTo(Folder o) {
        if (numDossier == o.getNumDossier()) {
            return 0;
        }else if (numDossier < o.getNumDossier()) {
                return -1;
            }else
            return 1;
    }@Override
    public String toString() {
        return " "+ numDossier;
    }

    /**
     * 
     * @param NouvelleDeclaration  : declaration
     */
    public void addNewEpisode(Declaration NouvelleDeclaration) {
        NouvelleDeclaration.setNoEven(numDossier + (int)Calendar.DATE);
        this.getEpisodes().add(NouvelleDeclaration);
        System.out.println("Nouveau dossier ajouté");
    }
}
