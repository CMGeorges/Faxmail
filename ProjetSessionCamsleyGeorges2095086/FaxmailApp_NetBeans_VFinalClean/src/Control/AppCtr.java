/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Data.ManipFichier;
import Modele.Adresse;
import Modele.UserList;
import Modele.Agent;
import Modele.Declaration;
import Modele.Enqueteur;
import Modele.Episode;
import Modele.Folder;
import Modele.FoldersList;
import Modele.Patient;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import ui.FenLogin;

/**
 *
 * @author camsl
 */
public class AppCtr {

    /**
     *
     */
    public static UserList utilisateurs = new UserList();
    public static FoldersList folds = new FoldersList();
/**
 * méthode Main
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//        CreationDeDeclaration();
//        InitiationDataFolders();
//        InitiationDataUtilisateur();
        ManipFichier.LectureObjet("FoldersData.bin", folds);
        ManipFichier.LectureObjet("UserData.bin", utilisateurs);
//        InitiationDataUtilisateur();
//        System.out.println("==================================Lecture De Folders====================");
//        folds.display();
//        System.out.println(folds.size());
//        
//        Enqueteur en = new Enqueteur("Enqueteur1","enqueteur1");
//        for(Folder f:folds.findFolders((Enqueteur) utilisateurs.get(1)))
//            System.out.println("Dos: "+ f.getNumDossier());
//           
//      
//        System.out.println("Fin"+folds);
        
        /* Set the Nimbus look and feel */
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FenLogin().setVisible(true);
        });
  }

    /**
     * Donnée d'essaie (Dossiers)
     */
    public static void InitiationDataFolders() {
        //InitiationDataUtilisateur();
        //SimpleCalendarFormat ft =new SimpleCalendarFormat("yyyy-MM-dd");
        //Calendar ft = Calendar.getInstance();
        Set monSet = new TreeSet();
        //FoldersList folders = new FoldersList();
        monSet.add(new Folder(20152,new Patient(20152,"Flouflou", "Bon", "Anjou","M", "BONF89050510", "","flouflou.B@hotmail.com",new Date(1989,05,05),new Adresse(50, "rue taillon","","H1H1N1", "Anjou","Québec", "Canada")),new Episode(){}));
        monSet.add(new Folder(28526,new Patient(28526,"Jean", "Bon", "Verdun","M", "BONJ00011605", "","jean.B@hotmail.com", new Date(2000,01,16),new Adresse(15335, "Boul. Demarchais","","H4H1N1", "Verdun","Québec", "Canada")),new Episode(){}));
        monSet.add(new Folder(209815,new Patient(209815,"Sarah", "Beaulieu", "Verdun","F", "BEAS68112510", "","Sarah.B@hotmail.com", new Date(1968,11,25),new Adresse(666, "rue Allard","","H4H2C5", "Verdun","Québec", "Canada")),new Episode(){}));
        monSet.add(new Folder(980506,new Patient(980506,"Luce", "Puce", "St-Hubert","F", "PUCL90072910", "","lucep@hotmail.com", new Date(1990,07,29),new Adresse(88, "70e ave","","H1H1N1", "St-Hubert","Québec", "Canada")),new Episode(){}));
        monSet.add(new Folder(12378,new Patient(12378,"Amande", "Noisette", "Boucherville","F", "BONF98021410", "","noisamnd.B@hotmail.com", new Date(1998,02,14),new Adresse(5, "80e ave","","H1H1N1", "Boucherville","Québec", "Canada")),new Episode(){}));
        monSet.add(new Folder(012345,new Patient(012345,"Flou", "Bon", "Château-Guay","T", "BONF91030310", "","flou.B@hotmail.com", new Date(1991,03,03),new Adresse(956, "8e rang","","H1H1N1", "Château-Guay","Québec", "Canada")),new Episode(){}));
        
        ManipFichier.ecritureOblect("FoldersData.bin", monSet);
        ManipFichier.LectureObjet("FoldersData.bin", folds);
    }

    /**
     * Donnée d'essaie (Utilisateurs: Agent et Enqueteur) 
     */
    public static void InitiationDataUtilisateur() {
        //creation du fichier dans enqueteur et user
        Set monSet = new TreeSet();
        ArrayList<String> regionsEst = new ArrayList<>();
        regionsEst.add("Pointes-Aux-Trembles");
        regionsEst.add("Rivière-Des-Prairies");
        regionsEst.add("MTL-Est");
        regionsEst.add("Anjou");
        ArrayList<String> regionsSud = new ArrayList<>();
        regionsSud.add("Longueil");
        regionsSud.add("St-Hubert");
        regionsSud.add("Boucherville");
        ArrayList<String> regionsOuest = new ArrayList<>();
        regionsOuest.add("Château-Guay");
        regionsOuest.add("LaChine");
        regionsOuest.add("LaSalle");
        regionsOuest.add("Verdun");
        
        monSet.add(new Agent("Jean01", "jean01"));
        monSet.add(new Agent("Sarah03", "sarah03"));
        monSet.add(new Agent("Jean22", "jean22"));
        monSet.add(new Enqueteur(023,regionsEst,"Enqueteur1", "enqueteur1"));
        monSet.add(new Agent("Jean01", "jean01"));
        monSet.add(new Enqueteur(223,regionsOuest,"Enqueteur2", "enqueteur2"));
        monSet.add(new Agent("Jean01", "jean01"));
        monSet.add(new Enqueteur(66,regionsSud,"Enqueteur3", "enqueteur3"));
        
        ManipFichier.ecritureOblect("UserData.bin", monSet);
        ManipFichier.LectureObjet("UserData.bin", utilisateurs);
    }
    
    /**
     * Utiliser pour Creer des declaratations externe pour telechargement. 
     */
    public  static  void CreationDeDeclaration(){
    
        Declaration d = new Declaration(34589, "CENTRE HOSPITALIER DE L'UNIVERSITÉ DE MONTRÉAL", "Bon, Flou", "T", "BONF91030310", new Date(1991,03,03), "514-555-6662",new Adresse(956, "8e rang","","H1H1N1", "Château-Guay","Québec", "Canada"), "Confirmé", "Bruneau, Anne","87695", "Clinique medicale Quartier Latin", "1733,rue Berri - 2e étage Montréal Qc H2L 4E9", new Date(2020,8,28),new Date(2020,9,3), "Urine", "CLSC", "CT/NG (Urine)", "Chlamydia PCR U", "Chlam Positif");
        Declaration d1 = new Declaration(8569, "CENTRE HOSPITALIER DE L'UNIVERSITÉ DE MCGILL", "Luce, Puce", "F", "PUCL90072910", new Date(1990,07,29), "514-555-5552",new Adresse(88, "70e ave","","H1H1N1", "St-Hubert","Québec", "Canada"), "Confirmé", "Bruneau, Anne","87695", "Clinique medicale Quartier Latin", "1733,rue Berri - 2e étage Montréal Qc H2L 4E9", new Date(2020,2,28), new Date(2020,3,10), "Sang", "CLSC", "CT/NG (Sang)", "HepatiteB PCR S", "Chlam Positif");
        Declaration d2 = new Declaration(1125, "CENTRE HOSPITALIER DE L'UNIVERSITÉ DE MONTRÉAL", "Bon, Flou", "T", "BONF91030310", new Date(1991,03,03), "514-555-6662",new Adresse(956, "8e rang","","H1H1N1", "Château-Guay","Québec", "Canada"), "Infirmé", "Bruneau, Anne","87695", "Clinique medicale Quartier Latin", "1733,rue Berri - 2e étage Montréal Qc H2L 4E9", new Date(2002,4,28), new Date(2020,5,3), "Urine", "CLSC", "CT/NG (Urine)", "Ghonoré PCR U", "Ghono négatif");
        Declaration d3 = new Declaration(365, "CENTRE HOSPITALIER DE L'UNIVERSITÉ DE MCGILL", "Luce, Puce", "F", "PUCL90072910", new Date(1990,07,29), "514-555-5552",new Adresse(88, "70e ave","","H1H1N1", "St-Hubert","Québec", "Canada"), "Confirmé", "Brown, Alain","88595", "Clinique medicale Quartier Latin", "1733,rue Berri - 2e étage Montréal Qc H2L 4E9", new Date(2020,01,02), new Date(2020,1,19), "Sang", "CLSC", "CT/NG (Sang)", "HepatiteC PCR S", "HepaC Négatif");
        Declaration d4 = new Declaration(125, "CENTRE HOSPITALIER DE L'UNIVERSITÉ DE MONTRÉAL", "Bon, Flou", "T", "BONF91030310", new Date(1991,03,03), "514-555-6662",new Adresse(956, "8e rang","","H1H1N1", "Château-Guay","Québec", "Canada"), "Confirmé", "Brown, Alain","88595", "Clinique medicale Quartier Latin", "1733,rue Berri - 2e étage Montréal Qc H2L 4E9", new Date(2020,2,5), new Date(2020,5,13), "Urine", "CLSC", "CT/NG (Urine)", "Chlamydia PCR U", "Chlam Positif");
        Declaration d5 = new Declaration(74, "CENTRE HOSPITALIER DE L'UNIVERSITÉ DE MCGILL", "Sarah, Beaulieu", "F", "BEAS68112510", new Date(1968,11,25), "514-555-5702",new Adresse(666, "rue Allard","","H4H2C5", "Verdun","Québec", "Canada"), "Confirmé", "Brown, Alain","88595", "Clinique medicale Quartier Latin", "1733,rue Berri - 2e étage Montréal Qc H2L 4E9",new Date(2020,3,24), new Date(2020,4,24), "Sang", "CLSC", "CT/NG (Sang)", "VIH PCR S", "Chlam Positif");
        Declaration d6 = new Declaration(89, "CENTRE HOSPITALIER DE L'UNIVERSITÉ DE MCGILL", "Sarah, Beaulieu", "F", "BEAS68112510", new Date(1968,11,25), "514-555-5702",new Adresse(666, "rue Allard","","H4H2C5", "Verdun","Québec", "Canada"), "Confirmé", "Brown, Alain","88595", "Clinique medicale Quartier Latin", "1733,rue Berri - 2e étage Montréal Qc H2L 4E9", new Date(2020,8,28), new Date(2020,9,3), "Urine", "CLSC", "CT/NG (Urine)", "Herpeste PCR U", "Chlam Positif");
        Declaration d7 = new Declaration(68, "CENTRE HOSPITALIER DE L'UNIVERSITÉ DE MONTRÉAL", "BonBon, Sucre", "T", "BONS99021410", new Date(1999,02,14), "514-555-9999",new Adresse(15355, "boul Notre-Dame","101","H1A2G5", "Pointes-Aux-Trembles","Québec", "Canada"), "Infirmé", "Brown, Alain","88595", "Clinique medicale Quartier Latin", "1733,rue Berri - 2e étage Montréal Qc H2L 4E9", new Date(2020,8,28), new Date(2020,9,3), "Sang", "CLSC", "CT/NG (Sang)", "Chlamydia PCR U", "Chlam Positif");
        Declaration d8 = new Declaration(14, "CENTRE HOSPITALIER DE L'UNIVERSITÉ DE QUEBEC", "Sucre, Blou", "T", "BLOS88103014", new Date(1988,10,30), "514-555-5552",new Adresse(35, "rue Allard","","J6J2Z9", "Boucherville","Québec", "Canada"), "Infirmé", "Bruneau, Anne","87695", "Clinique medicale Quartier Latin", "1733,rue Berri - 2e étage Montréal Qc H2L 4E9",new Date(2020,5,5), new Date(2020,6,1), "Urine", "CLSC", "CT/NG (Urine)", "Ghonoré PCR U", "Gono négatif");
        Declaration d9 = new Declaration(25, "CENTRE HOSPITALIER DE L'UNIVERSITÉ DE MONTRÉAL", "Toutou, Klou", "T", "KLOT78041110", new Date(1978,04,11), "514-555-5552",new Adresse(895, "rue Picard","","J8T8Z9", "Boucherville","Québec", "Canada"), "Probable", "Bruneau, Anne","87695", "Clinique medicale Quartier Latin", "1733,rue Berri - 2e étage Montréal Qc H2L 4E9",new Date(2020,8,28), null, "Urine", "CLSC", "CT/NG (Urine)", "Chlamydia PCR U", null);
        Declaration d10 = new Declaration(1, "CENTRE HOSPITALIER DE L'UNIVERSITÉ DE QUEBEC", "Hibou, Tonton", "T", "TONH95020205", new Date(1995,02,02), "514-555-5552",new Adresse(45, "rue Liles","","K5K1K1", "Boucherville","Québec", "Canada"), "En suspend", "Bruneau, Anne","87695", "Clinique medicale Quartier Latin", "1733,rue Berri - 2e étage Montréal Qc H2L 4E9", new Date(2020,9,28), null, "Urine", "CLSC", "CT/NG (Urine)", "Ghonoré PCR U", null);
        Declaration d11 = new Declaration(2, "CENTRE HOSPITALIER DE L'UNIVERSITÉ DE MONTRÉAL", "ClairClair, Dou", "M", "DOUC95092509", new Date(1995,10,25), "514-855-5552",new Adresse(6, "1st street ","A","H4H2C5", "Verdun","Québec", "Canada"), "Suspect","Brown, Alain","88595", "Clinique medicale Quartier Latin", "1733,rue Berri - 2e étage Montréal Qc H2L 4E9", new Date(2020,10,2), null, "Urine", "CLSC", "CT/NG (Urine)", "Chlamydia PCR U",null);
        ArrayList<Declaration> declarations = new ArrayList<>();
        declarations.add(d);
        declarations.add(d1);
        declarations.add(d2);
        declarations.add(d3);
        declarations.add(d4);
        declarations.add(d5);
        declarations.add(d6);
        declarations.add(d7);
        declarations.add(d8);
        declarations.add(d9);
        declarations.add(d10);
        declarations.add(d11);
        int x=0;
        for(Declaration de:declarations){
            
            
            ManipFichier.ecrireDeclaration(de,x++);
        }
        
        
        
    
    }

    
    
}
