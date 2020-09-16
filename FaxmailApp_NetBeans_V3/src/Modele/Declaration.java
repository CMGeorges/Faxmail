/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *les declaration reçu pour un patient
 * @author camsl
 */
public class Declaration implements Serializable, Comparable<Declaration>{
//nummero d'evenement
private int noEven;
//Déclarant    
        private String declarant;
    //Patient
        private String nomPatient,sexe,numAssMAl,dateDeNaissance,tel;
    //Medecin
        private String nomDr,milieuDeConsultation;
        private Adresse adresseDuDemandeur;
    //Laboratoire
        private Date dateDePre,dateExecution;
        private String typeDePre,siteDePre,nomDemande,analyse,resultat;
    
    

        /**
         * 
         * @param declarant
         * @param nomPatient
         * @param sexe
         * @param numAssMAl
         * @param dateDeNaissance
         * @param tel
         * @param nomDr
         * @param milieuDeConsultation
         * @param adresseDuDemandeur
         * @param dateDePre
         * @param dateExecution
         * @param typeDePre
         * @param siteDePre
         * @param nomDemande
         * @param analyse
         * @param resultat 
         */
    public Declaration(String declarant, String nomPatient, String sexe, String numAssMAl, String dateDeNaissance, String tel, String nomDr, String milieuDeConsultation, Adresse adresseDuDemandeur, Date dateDePre, Date dateExecution, String typeDePre, String siteDePre, String nomDemande, String analyse, String resultat) {
        this.declarant = declarant;
        this.nomPatient = nomPatient;
        this.sexe = sexe;
        this.numAssMAl = numAssMAl;
        this.dateDeNaissance = dateDeNaissance;
        this.tel = tel;
        this.nomDr = nomDr;
        this.milieuDeConsultation = milieuDeConsultation;
        this.adresseDuDemandeur = adresseDuDemandeur;
        this.dateDePre = dateDePre;
        this.dateExecution = dateExecution;
        this.typeDePre = typeDePre;
        this.siteDePre = siteDePre;
        this.nomDemande = nomDemande;
        this.analyse = analyse;
        this.resultat = resultat;
    }

    public Declaration() {
    }

    public String getDeclarant() {
        return declarant;
    }

    public void setDeclarant(String declarant) {
        this.declarant = declarant;
    }

    public String getNomPatient() {
        return nomPatient;
    }

    public void setNomPatient(String nomPatient) {
        this.nomPatient = nomPatient;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getNumAssMAl() {
        return numAssMAl;
    }

    public void setNumAssMAl(String numAssMAl) {
        this.numAssMAl = numAssMAl;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNomDr() {
        return nomDr;
    }

    public void setNomDr(String nomDr) {
        this.nomDr = nomDr;
    }

    public String getMilieuDeConsultation() {
        return milieuDeConsultation;
    }

    public void setMilieuDeConsultation(String milieuDeConsultation) {
        this.milieuDeConsultation = milieuDeConsultation;
    }

    public Adresse getAdresseDuDemandeur() {
        return adresseDuDemandeur;
    }

    
    public Date getDateDePre() {
        return dateDePre;
    }

    public void setDateDePre(Date dateDePre) {
        this.dateDePre = dateDePre;
    }

    public Date getDateExecution() {
        return dateExecution;
    }

    public void setDateExecution(Date dateExecution) {
        this.dateExecution = dateExecution;
    }

    public String getTypeDePre() {
        return typeDePre;
    }

    public void setTypeDePre(String typeDePre) {
        this.typeDePre = typeDePre;
    }

    public String getSiteDePre() {
        return siteDePre;
    }

    public void setSiteDePre(String siteDePre) {
        this.siteDePre = siteDePre;
    }

    public String getNomDemande() {
        return nomDemande;
    }

    public void setNomDemande(String nomDemande) {
        this.nomDemande = nomDemande;
    }

    public String getAnalyse() {
        return analyse;
    }

    public void setAnalyse(String analyse) {
        this.analyse = analyse;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    @Override
    public int compareTo(Declaration o) {
         if (dateDePre == o.getDateDePre()) {
            return 0;
        }else if (dateDePre.before(o.getDateDePre()))  {
                return -1;
            }else
            return 1;
    }

    public int getNoEven() {
        return noEven;
    }

    public void setNoEven(int noEven) {
        this.noEven = noEven;
    }
    
    
    
}
