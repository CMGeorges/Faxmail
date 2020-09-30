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
import Modele.Enqueteur;
import Modele.Episode;
import Modele.Folder;
import Modele.FoldersList;
import Modele.Patient;
import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Calendar;
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

    public static void InitiationDataFolders() {
        //InitiationDataUtilisateur();
        //SimpleCalendarFormat ft =new SimpleCalendarFormat("yyyy-MM-dd");
        Calendar ft = Calendar.getInstance();
        Set monSet = new TreeSet();
        //FoldersList folders = new FoldersList();
        monSet.add(new Folder(20152,new Patient(20152,"Flouflou", "Bon", "Anjou","M", "BONF89050510", "","flouflou.B@hotmail.com",new Date(1989,05,05),new Adresse(50, "rue taillon","","H1H1N1", "Anjou","Québec", "Canada")),new Episode(){}));
        monSet.add(new Folder(28526,new Patient(28526,"Jean", "Bon", "Verdun","M", "BONJ00050505", "","jean.B@hotmail.com", new Date(2000,01,16),new Adresse(15335, "Boul. Demarchais","","H4H1N1", "Verdun","Québec", "Canada")),new Episode(){}));
        monSet.add(new Folder(209815,new Patient(209815,"Sarah", "Beaulieu", "Verdun","F", "BONF89050510", "","Sarah.B@hotmail.com", new Date(1968,11,25),new Adresse(666, "rue Allard","","H4H2C5", "Verdun","Québec", "Canada")),new Episode(){}));
        monSet.add(new Folder(980506,new Patient(980506,"Luce", "Puce", "St-Hubert","F", "BONF89050510", "","lucep@hotmail.com", new Date(1990,07,29),new Adresse(88, "70e ave","","H1H1N1", "St-Hubert","Québec", "Canada")),new Episode(){}));
        monSet.add(new Folder(12378,new Patient(12378,"Amande", "Noisette", "Boucherville","F", "BONF89050510", "","noisamnd.B@hotmail.com", new Date(1998,02,14),new Adresse(5, "80e ave","","H1H1N1", "Boucherville","Québec", "Canada")),new Episode(){}));
        monSet.add(new Folder(012345,new Patient(012345,"Flou", "Bon", "Château-Guay","T", "BONF89050510", "","flou.B@hotmail.com", new Date(1991,03,03),new Adresse(956, "8e rang","","H1H1N1", "Château-Guay","Québec", "Canada")),new Episode(){}));
        
        ManipFichier.ecritureOblect("FoldersData.bin", monSet);
        ManipFichier.LectureObjet("FoldersData.bin", folds);
    }

    public static void InitiationDataUtilisateur() {
        //creation du fichier dans enqueteur et user
        Set monSet = new TreeSet();
        ArrayList<String> regionsEst = new ArrayList<>();
        regionsEst.add("Pointe-Aux-Trembles");
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

    static class PatientImpl extends Patient {

        public PatientImpl(int i, String string, String string1, String string2, String string3, String string4, String string5, String string6, Date date, Adresse adrs) {
            super(i, string, string1, string2, string3, string4, string5, string6, date, adrs);
        }
    }
    
}
