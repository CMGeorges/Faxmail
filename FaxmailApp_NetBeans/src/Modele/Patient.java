/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.Date;

/**
 *Patient est un Objet identifient la clientèle.
 * @author camsl
 */
public class Patient {
    private int numPatient;
    private String nom,prenom,region,sexe,ramq,autreNom,email;
    private Date dateDeNaissance;
    private Adresse adresse;

    public void setRegion(String region) {
        this.region = region;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public int getNumPatient() {
        return numPatient;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getRegion() {
        return region;
    }

    public String getSexe() {
        return sexe;
    }

    public String getRamq() {
        return ramq;
    }

    public String getAutreNom() {
        return autreNom;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public Patient() {
    }
    

    /**
     * 
     * @param numPatient
     * @param nom
     * @param prenom
     * @param region
     * @param sexe
     * @param ramq
     * @param autreNom
     * @param email
     * @param dateDeNaissance
     * @param adresse 
     */
    public Patient(int numPatient, String nom, String prenom, String region, String sexe, String ramq, String autreNom, String email, Date dateDeNaissance, Adresse adresse) {
        this.numPatient = numPatient;
        this.nom = nom;
        this.prenom = prenom;
        this.region = region;
        this.sexe = sexe;
        this.ramq = ramq;
        this.autreNom = autreNom;
        this.email = email;
        this.dateDeNaissance = dateDeNaissance;
        this.adresse = adresse;
    }
    

    
    
}
