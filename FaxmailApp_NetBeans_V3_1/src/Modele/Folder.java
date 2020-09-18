/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.io.Serializable;

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
     * @param numDossier
     * @param patient 
     */
    public Folder(int numDossier, Patient patient) {
        this.numDossier = numDossier;
        this.patient = patient;
    }
    /**
     * 
     * @param numDossier
     * @param patient
     * @param episodes 
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
     * @return
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     *
     * @param patient
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     *
     * @return
     */
    public Episode getEpisodes() {
        return episodes;
    }

    /**
     *
     * @param episodes
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
}
