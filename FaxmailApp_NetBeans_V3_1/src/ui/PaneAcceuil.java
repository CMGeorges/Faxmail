/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import static Control.AppCtr.folds;
import Data.ManipFichier;
import Exception.AdminException;
import Modele.Adresse;
import Modele.Agent;
import Modele.Declaration;
import Modele.Enqueteur;
import Modele.Episode;
import Modele.Folder;
import java.awt.Frame;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

/**
 *
 * Page d'acceuil d'ouverture de session.
 * 
 * @author camsl
 */
public class PaneAcceuil extends javax.swing.JPanel {
   
   protected Agent userUse;
   protected Folder folderUse;
   protected boolean type=false;
    /**
     * Creates new form PaneAcceuil
     */
    public PaneAcceuil() {
        this.consulteur = new SwingWorker<Folder, Folder>(){
            @Override
            protected Folder doInBackground() throws Exception {
                folderUse=folds.searchFolder(jListDossiers.getModel().getElementAt(jListDossiers.getSelectionModel().getMaxSelectionIndex()));
                
                return folderUse;
            }
            
            @Override
            protected void done() {
                //get resultat de doInBackground()
                Folder fold;
                try {
                    System.out.println("get doInBackground");
                    fold = get();
                    System.out.println("setData");
                    setData(fold);
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(PaneAcceuil.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
            
        };
        initComponents();
    }
    

    /**
     * Creates new form PaneAcceuil
     * avec le message d'acceuil suivie du paramètre.
     * Lorsque c'est agent  l'app affichera la totalité des dossiers.
     * Lorsque c'est un enqueteur l'application affiche seulement les dossiers associés à sa region.
     * @throws NullPointerException
     * @param agt 
     */
    public PaneAcceuil(Agent agt) {
        this.consulteur = new SwingWorker<Folder, Folder>(){
            @Override
            protected Folder doInBackground() throws Exception {
                folderUse=folds.searchFolder(jListDossiers.getModel().getElementAt(jListDossiers.getSelectionModel().getMaxSelectionIndex()));
                
                return folderUse;
            }
            
            @Override
            protected void done() {
                //get resultat de doInBackground()
                Folder fold;
                try {
                    System.out.println("get doInBackground");
                    fold = get();
                    System.out.println("setData");
                    clean();
                    setData(fold);
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(PaneAcceuil.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
            
            
        };
        initComponents();
        this.jTabPAcceuil.setEnabledAt(0,false);
        this.jpNouveaute.setEnabled(false);
        TabNDossier.setEnabled(false);
        jLabel1.setEnabled(false);
        if (agt.getClass()!=Enqueteur.class) {
            type=false;
            userUse=agt;
            this.jlblAccount.setText("Bienvenue " + agt.getNomUtilisateur());
                        //System.out.println("Bienvenue " +agt.getNomUtilisateur()); 
         try {
                //ManipFichier.LectureObjet("FoldersData.bin", folds);
                //System.out.println("test"+folds );
                jListDossiers.removeAll();
                jListDossiers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                jListDossiers.setAlignmentY(TOP_ALIGNMENT);
                UpdateDatas(); 
            } catch (NullPointerException e) {
                //System.out.println(e.getMessage());               
            txtAeraError.setText(e.getMessage());
            DialogErreur.setVisible(true);
            DialogErreur.isFocusableWindow();
            }
        }else{
        Enqueteur e1=(Enqueteur)agt;
        type = true;
        userUse=e1;
        this.jlblAccount.setText("Bienvenue " + e1.getMatricule());
        //this.jListDossiers.setAutoscrolls(true);
            try {
                //ManipFichier.LectureObjet("FoldersData.bin", folds);
                jListDossiers.removeAll();
                jListDossiers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                jListDossiers.setAlignmentY(TOP_ALIGNMENT);
                UpdateDatasEn(e1);
            } catch (NullPointerException e) {
                //System.out.println(e.getMessage());               
            txtAeraError.setText(e.getMessage());
            DialogErreur.setVisible(true);
            DialogErreur.isFocusableWindow();
            }
                   
        }
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DialogErreur = new javax.swing.JDialog();
        lblError = new javax.swing.JLabel();
        jScrollError = new javax.swing.JScrollPane();
        txtAeraError = new javax.swing.JTextArea();
        jFDeclaration = new javax.swing.JFrame();
        jSCDeclaration = new javax.swing.JScrollPane();
        jpDeclaration = new javax.swing.JPanel();
        lblDeclarant = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblDateDeNaissance = new javax.swing.JLabel();
        lblDeAdresse = new javax.swing.JLabel();
        lblNAM = new javax.swing.JLabel();
        lblDeTel = new javax.swing.JLabel();
        txtDeclarant = new javax.swing.JFormattedTextField();
        txtNomPatient = new javax.swing.JFormattedTextField();
        txtDateDeNaissance = new javax.swing.JFormattedTextField();
        txtDeTel = new javax.swing.JFormattedTextField();
        txtDeAdresse = new javax.swing.JFormattedTextField();
        txtNumASsM = new javax.swing.JFormattedTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane5 = new javax.swing.JScrollPane();
        TxtAeraNote = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        Tab_notes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        lblDrDemandeur = new javax.swing.JLabel();
        lblPermis = new javax.swing.JLabel();
        lblMilieuConsult = new javax.swing.JLabel();
        lblAdresseDr = new javax.swing.JLabel();
        lblDatePre = new javax.swing.JLabel();
        lblSitePre = new javax.swing.JLabel();
        lblTypePre = new javax.swing.JLabel();
        lblNomDemande = new javax.swing.JLabel();
        lblDateExecution = new javax.swing.JLabel();
        lblResultat = new javax.swing.JLabel();
        lblAnalyse = new javax.swing.JLabel();
        txtDrDemandeur = new javax.swing.JFormattedTextField();
        txtPermis = new javax.swing.JFormattedTextField();
        txtMilieuConsult = new javax.swing.JFormattedTextField();
        txtAdresseDr = new javax.swing.JFormattedTextField();
        txtSitePre = new javax.swing.JFormattedTextField();
        txtDatePrelevement = new javax.swing.JFormattedTextField();
        txtDateExecu = new javax.swing.JFormattedTextField();
        txtTypePre = new javax.swing.JFormattedTextField();
        txtNomDemande = new javax.swing.JFormattedTextField();
        txtResultat = new javax.swing.JFormattedTextField();
        txtAnalyse = new javax.swing.JFormattedTextField();
        btnCancelDec = new javax.swing.JButton();
        btnSaveDec = new javax.swing.JButton();
        jCBStatus = new javax.swing.JComboBox<>();
        lblStatus = new javax.swing.JLabel();
        lblFormatDate = new javax.swing.JLabel();
        lblFormatDate1 = new javax.swing.JLabel();
        ChooserDeclaration = new javax.swing.JFileChooser();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jSPList = new javax.swing.JScrollPane();
        jListDossiers = new javax.swing.JList<>();
        btnEnregistrer = new javax.swing.JButton();
        btnFermer = new javax.swing.JButton();
        jlblAccount = new javax.swing.JLabel();
        btnDeconnecter = new javax.swing.JButton();
        jScrollPAcceuil = new javax.swing.JScrollPane();
        jTabPAcceuil = new javax.swing.JTabbedPane();
        jpNouveaute = new javax.swing.JPanel();
        lblNDossier = new javax.swing.JLabel();
        jScrollPNDossier = new javax.swing.JScrollPane();
        TabNDossier = new javax.swing.JTable();
        lblRappel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jpDossier = new javax.swing.JPanel();
        lblDNom = new javax.swing.JLabel();
        lblDPrenom = new javax.swing.JLabel();
        lblDMiddleName = new javax.swing.JLabel();
        lblSexe = new javax.swing.JLabel();
        lblAdresse = new javax.swing.JLabel();
        lblBirthDate = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPreviousEpisodes = new javax.swing.JLabel();
        lblRegion = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabPrevious = new javax.swing.JTable();
        jComboSexe = new javax.swing.JComboBox<>();
        txtDNom = new javax.swing.JTextField();
        txtDPrenom = new javax.swing.JTextField();
        txtDMiddleName = new javax.swing.JTextField();
        txtDDAteDeNaissance = new javax.swing.JTextField();
        txtDAdresse = new javax.swing.JTextField();
        txtDCourriel = new javax.swing.JTextField();
        txtDREgion = new javax.swing.JTextField();
        btnAddDec = new javax.swing.JButton();
        btnConsult = new javax.swing.JButton();
        btnTelecharger = new javax.swing.JButton();
        btnModifier = new javax.swing.JButton();
        btnConsulter = new javax.swing.JButton();

        DialogErreur.setTitle("Error!!");
        DialogErreur.setMinimumSize(new java.awt.Dimension(400, 167));
        DialogErreur.setModal(true);
        DialogErreur.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                DialogErreurPropertyChange(evt);
            }
        });

        lblError.setText("Error:");

        jScrollError.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtAeraError.setEditable(false);
        txtAeraError.setColumns(20);
        txtAeraError.setForeground(new java.awt.Color(204, 0, 51));
        txtAeraError.setLineWrap(true);
        txtAeraError.setRows(5);
        txtAeraError.setWrapStyleWord(true);
        txtAeraError.setAutoscrolls(false);
        txtAeraError.setCaretColor(new java.awt.Color(0, 102, 102));
        txtAeraError.setDisabledTextColor(new java.awt.Color(0, 102, 102));
        txtAeraError.setEnabled(false);
        jScrollError.setViewportView(txtAeraError);

        javax.swing.GroupLayout DialogErreurLayout = new javax.swing.GroupLayout(DialogErreur.getContentPane());
        DialogErreur.getContentPane().setLayout(DialogErreurLayout);
        DialogErreurLayout.setHorizontalGroup(
            DialogErreurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogErreurLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollError, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );
        DialogErreurLayout.setVerticalGroup(
            DialogErreurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogErreurLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(DialogErreurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblError)
                    .addComponent(jScrollError, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        jFDeclaration.setTitle("Déclaration");
        jFDeclaration.setMaximizedBounds(new java.awt.Rectangle(0, 0, 645, 700));
        jFDeclaration.setMinimumSize(new java.awt.Dimension(645, 600));
        jFDeclaration.setResizable(false);
        jFDeclaration.setSize(new java.awt.Dimension(645, 650));

        jSCDeclaration.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jSCDeclaration.setAutoscrolls(true);
        jSCDeclaration.setMaximumSize(new java.awt.Dimension(800, 800));
        jSCDeclaration.setMinimumSize(new java.awt.Dimension(650, 650));
        jSCDeclaration.setNextFocusableComponent(jpDeclaration);
        jSCDeclaration.setPreferredSize(new java.awt.Dimension(645, 680));
        jSCDeclaration.setViewportView(jpDeclaration);

        jpDeclaration.setAutoscrolls(true);
        jpDeclaration.setMaximumSize(new java.awt.Dimension(645, 700));
        jpDeclaration.setMinimumSize(new java.awt.Dimension(645, 680));
        jpDeclaration.setPreferredSize(new java.awt.Dimension(645, 650));

        lblDeclarant.setLabelFor(txtDeclarant);
        lblDeclarant.setText("Déclarant:");

        jLabel3.setLabelFor(txtNomPatient);
        jLabel3.setText("Nom du patient:");

        lblDateDeNaissance.setLabelFor(txtDateDeNaissance);
        lblDateDeNaissance.setText("Date de naissance:");

        lblDeAdresse.setLabelFor(txtDeAdresse);
        lblDeAdresse.setText("Adresse:");

        lblNAM.setLabelFor(txtNumASsM);
        lblNAM.setText("Numéro d'assurance maladie:");

        lblDeTel.setLabelFor(txtDeTel);
        lblDeTel.setText("Téléphone:");

        txtNomPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomPatientActionPerformed(evt);
            }
        });

        txtDateDeNaissance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateDeNaissanceActionPerformed(evt);
            }
        });

        TxtAeraNote.setColumns(20);
        TxtAeraNote.setRows(5);
        jScrollPane5.setViewportView(TxtAeraNote);

        Tab_notes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Enqueteur"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane6.setViewportView(Tab_notes);

        jLabel2.setText("Notes:");

        lblDrDemandeur.setLabelFor(txtDrDemandeur);
        lblDrDemandeur.setText("Nom du médecin demandeur:");

        lblPermis.setLabelFor(txtPermis);
        lblPermis.setText("Numéro du permis d'exercice:");

        lblMilieuConsult.setLabelFor(txtMilieuConsult);
        lblMilieuConsult.setText("Milieu de consultation:");

        lblAdresseDr.setLabelFor(txtAdresseDr);
        lblAdresseDr.setText("Adresse médecin demandeur:");

        lblDatePre.setLabelFor(txtDatePrelevement);
        lblDatePre.setText("Date de prélèvement:");

        lblSitePre.setText("Site de prélèvement:");

        lblTypePre.setLabelFor(txtTypePre);
        lblTypePre.setText("Type de prélèvement:");

        lblNomDemande.setLabelFor(txtNomDemande);
        lblNomDemande.setText("Nom de la demande:");

        lblDateExecution.setLabelFor(txtDateExecu);
        lblDateExecution.setText("Date d'exécution:");

        lblResultat.setLabelFor(txtResultat);
        lblResultat.setText("Résultat:");

        lblAnalyse.setLabelFor(txtAnalyse);
        lblAnalyse.setText("Analyse:");

        btnCancelDec.setText("Annuler");
        btnCancelDec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelDecActionPerformed(evt);
            }
        });

        btnSaveDec.setText("Sauvegarder");
        btnSaveDec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveDecActionPerformed(evt);
            }
        });

        jCBStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Confirmé", "Infirmé", "En suspend", "Suspect", "Probable" }));

        lblStatus.setLabelFor(txtTypePre);
        lblStatus.setText("Status:");

        lblFormatDate.setText("(DD-MM-YYYY)");

        lblFormatDate1.setText("(DD-MM-YYYY)");

        javax.swing.GroupLayout jpDeclarationLayout = new javax.swing.GroupLayout(jpDeclaration);
        jpDeclaration.setLayout(jpDeclarationLayout);
        jpDeclarationLayout.setHorizontalGroup(
            jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDeclarationLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpDeclarationLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblDeTel)
                                .addComponent(jLabel3)
                                .addComponent(lblDeclarant)
                                .addComponent(lblDateDeNaissance))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDeclarant)
                                    .addGroup(jpDeclarationLayout.createSequentialGroup()
                                        .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDateDeNaissance, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                            .addComponent(txtNomPatient))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jpDeclarationLayout.createSequentialGroup()
                                                .addComponent(lblDeAdresse)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtDeAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jpDeclarationLayout.createSequentialGroup()
                                                .addComponent(lblNAM)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtNumASsM, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDeclarationLayout.createSequentialGroup()
                                        .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblDateExecution)
                                            .addComponent(lblStatus, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblFormatDate)
                                            .addComponent(lblAnalyse, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblResultat, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTypePre, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jCBStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDateExecu, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtAnalyse, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtResultat, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(txtDeTel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpDeclarationLayout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDeclarationLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDeclarationLayout.createSequentialGroup()
                                        .addComponent(btnSaveDec)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCancelDec)
                                        .addGap(20, 20, 20))))
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpDeclarationLayout.createSequentialGroup()
                        .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpDeclarationLayout.createSequentialGroup()
                                .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDrDemandeur)
                                    .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lblAdresseDr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblPermis, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(lblMilieuConsult, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblFormatDate1)
                                        .addComponent(lblDatePre))
                                    .addComponent(lblNomDemande, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblSitePre, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPermis, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDrDemandeur, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAdresseDr, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpDeclarationLayout.createSequentialGroup()
                                        .addComponent(txtMilieuConsult, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblTypePre))
                                    .addComponent(txtSitePre, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDatePrelevement, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNomDemande, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(137, 137, 137))))
        );
        jpDeclarationLayout.setVerticalGroup(
            jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDeclarationLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDeclarant)
                    .addComponent(txtDeclarant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNomPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDeAdresse)
                    .addComponent(txtDeAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDateDeNaissance)
                    .addComponent(txtDateDeNaissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNAM)
                    .addComponent(txtNumASsM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDeTel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDeTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDrDemandeur, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDrDemandeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus)
                    .addComponent(jCBStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPermis)
                    .addComponent(txtPermis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMilieuConsult)
                    .addComponent(txtMilieuConsult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTypePre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTypePre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdresseDr)
                    .addComponent(txtAdresseDr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDatePre)
                    .addComponent(txtDatePrelevement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDateExecution)
                    .addComponent(txtDateExecu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFormatDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFormatDate, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSitePre)
                        .addComponent(txtSitePre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAnalyse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblAnalyse, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomDemande, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblResultat)
                        .addComponent(txtResultat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNomDemande)))
                .addGap(36, 36, 36)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpDeclarationLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSaveDec)
                            .addComponent(btnCancelDec))))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jSCDeclaration.setViewportView(jpDeclaration);

        javax.swing.GroupLayout jFDeclarationLayout = new javax.swing.GroupLayout(jFDeclaration.getContentPane());
        jFDeclaration.getContentPane().setLayout(jFDeclarationLayout);
        jFDeclarationLayout.setHorizontalGroup(
            jFDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFDeclarationLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jSCDeclaration, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jFDeclarationLayout.setVerticalGroup(
            jFDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSCDeclaration, javax.swing.GroupLayout.PREFERRED_SIZE, 600, Short.MAX_VALUE)
        );

        ChooserDeclaration.setDialogTitle("Choisir votre Déclaration.txt que vous voulé enregistrer...");
        ChooserDeclaration.setToolTipText("fichier .txt ou .bin");
        ChooserDeclaration.setEnabled(false);
        ChooserDeclaration.setFocusCycleRoot(true);
        ChooserDeclaration.setName(""); // NOI18N

        jInternalFrame1.setVisible(true);

        jSPList.setMaximumSize(new java.awt.Dimension(710, 370));

        jListDossiers.setForeground(new java.awt.Color(51, 51, 51));
        jListDossiers.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "NoDossier 1", "NoDossier 2", "NoDossier 3", "NoDossier 4", "NoDossier 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListDossiers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListDossiers.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSPList.setViewportView(jListDossiers);
        jListDossiers.getAccessibleContext().setAccessibleDescription("");

        btnEnregistrer.setText("Enregistrer");
        btnEnregistrer.setMaximumSize(new java.awt.Dimension(103, 32));
        btnEnregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnregistrerActionPerformed(evt);
            }
        });

        btnFermer.setText("Fermer");
        btnFermer.setMaximumSize(new java.awt.Dimension(103, 32));

        jlblAccount.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jlblAccount.setForeground(new java.awt.Color(102, 0, 153));
        jlblAccount.setText("Account Settings --username@mailserver");
        jlblAccount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        btnDeconnecter.setText("Déconnecter");
        btnDeconnecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeconnecterActionPerformed(evt);
            }
        });

        jScrollPAcceuil.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPAcceuil.setMaximumSize(new java.awt.Dimension(32767, 800));

        jTabPAcceuil.setMaximumSize(new java.awt.Dimension(710, 362));

        lblNDossier.setText("Nouverau Dossier:");

        TabNDossier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NoDossier", "Date Réception", "Région"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Double.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPNDossier.setViewportView(TabNDossier);

        lblRappel.setText("Dernier Dossier ouvert:");

        jLabel1.setBackground(new java.awt.Color(153, 0, 51));
        jLabel1.setText("000000");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, null, new java.awt.Color(153, 0, 51)));

        javax.swing.GroupLayout jpNouveauteLayout = new javax.swing.GroupLayout(jpNouveaute);
        jpNouveaute.setLayout(jpNouveauteLayout);
        jpNouveauteLayout.setHorizontalGroup(
            jpNouveauteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNouveauteLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jpNouveauteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpNouveauteLayout.createSequentialGroup()
                        .addComponent(lblRappel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpNouveauteLayout.createSequentialGroup()
                        .addComponent(lblNDossier)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPNDossier, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(297, Short.MAX_VALUE))
        );
        jpNouveauteLayout.setVerticalGroup(
            jpNouveauteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNouveauteLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jpNouveauteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNDossier)
                    .addComponent(jScrollPNDossier, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jpNouveauteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRappel)
                    .addComponent(jLabel1))
                .addContainerGap(714, Short.MAX_VALUE))
        );

        jTabPAcceuil.addTab("Nouveauté", jpNouveaute);

        jpDossier.setAutoscrolls(true);
        jpDossier.setMaximumSize(new java.awt.Dimension(710, 362));

        lblDNom.setLabelFor(txtDNom);
        lblDNom.setText("Nom:");

        lblDPrenom.setLabelFor(txtDPrenom);
        lblDPrenom.setText("Prénom:");

        lblDMiddleName.setLabelFor(txtDMiddleName);
        lblDMiddleName.setText("Autre nom:");

        lblSexe.setLabelFor(jComboSexe);
        lblSexe.setText("Sexe:");

        lblAdresse.setLabelFor(txtDAdresse);
        lblAdresse.setText("Adresse:");

        lblBirthDate.setLabelFor(txtDDAteDeNaissance);
        lblBirthDate.setText("Date de naissance:");

        lblEmail.setLabelFor(txtDCourriel);
        lblEmail.setText("Courriel:");

        lblPreviousEpisodes.setText("Maladie antérieurs:");

        lblRegion.setLabelFor(txtDREgion);
        lblRegion.setText("Region:");

        tabPrevious.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num Évenement", "Condition de Santé ", "Date déclaré", "Statut", "Date réception"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabPrevious);

        jComboSexe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F", "T" }));

        btnAddDec.setText("+");
        btnAddDec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDecActionPerformed(evt);
            }
        });

        btnConsult.setText("Consulter");
        btnConsult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultActionPerformed(evt);
            }
        });

        btnTelecharger.setText("Télécharger");
        btnTelecharger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelechargerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpDossierLayout = new javax.swing.GroupLayout(jpDossier);
        jpDossier.setLayout(jpDossierLayout);
        jpDossierLayout.setHorizontalGroup(
            jpDossierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDossierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDossierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jpDossierLayout.createSequentialGroup()
                        .addGroup(jpDossierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEmail)
                            .addComponent(lblPreviousEpisodes)
                            .addComponent(lblBirthDate)
                            .addComponent(lblAdresse)
                            .addComponent(lblDNom))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpDossierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDCourriel, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpDossierLayout.createSequentialGroup()
                                .addGroup(jpDossierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDossierLayout.createSequentialGroup()
                                        .addComponent(txtDNom, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblDPrenom)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jpDossierLayout.createSequentialGroup()
                                        .addComponent(txtDDAteDeNaissance, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblSexe)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboSexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(53, 53, 53)))
                                .addGroup(jpDossierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jpDossierLayout.createSequentialGroup()
                                        .addComponent(lblRegion)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDREgion))
                                    .addGroup(jpDossierLayout.createSequentialGroup()
                                        .addComponent(lblDMiddleName)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(txtDAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE))
                    .addGroup(jpDossierLayout.createSequentialGroup()
                        .addGroup(jpDossierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpDossierLayout.createSequentialGroup()
                                .addComponent(btnTelecharger)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnConsult)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddDec))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 126, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpDossierLayout.setVerticalGroup(
            jpDossierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDossierLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jpDossierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDNom)
                    .addComponent(lblDPrenom)
                    .addComponent(lblDMiddleName)
                    .addComponent(txtDNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpDossierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexe)
                    .addComponent(jComboSexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBirthDate)
                    .addComponent(txtDDAteDeNaissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRegion)
                    .addComponent(txtDREgion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jpDossierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdresse)
                    .addComponent(txtDAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpDossierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtDCourriel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(lblPreviousEpisodes)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDossierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddDec)
                    .addComponent(btnConsult)
                    .addComponent(btnTelecharger))
                .addContainerGap(514, Short.MAX_VALUE))
        );

        jTabPAcceuil.addTab("Dossier", jpDossier);

        jScrollPAcceuil.setViewportView(jTabPAcceuil);

        btnModifier.setText("Modifier");
        btnModifier.setMaximumSize(new java.awt.Dimension(103, 32));
        btnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierActionPerformed(evt);
            }
        });

        btnConsulter.setText("Consulter");
        btnConsulter.setMaximumSize(new java.awt.Dimension(103, 32));
        btnConsulter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsulterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnModifier, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDeconnecter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFermer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEnregistrer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSPList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnConsulter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPAcceuil, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jlblAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
                        .addGap(18, 18, 18))))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jSPList, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnConsulter, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFermer, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeconnecter, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addComponent(jScrollPAcceuil, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Lorsque le btnConsulter est presser la page du  Dossier selectionné
     * s'affichera.
     * 
     * @param evt 
     * @return PaneDossier(Dossier)
     */
    private void btnConsulterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsulterActionPerformed
        //Lorsque presser l'app bug.
        //Solution trouvé dans la Méthode FoldersList.searchFolder ligne de code contradictoire 2020-09-23
        System.out.println(Arrays.toString(jListDossiers.getSelectionModel().getSelectedIndices()));       
        System.out.println(jListDossiers.getModel().getElementAt(jListDossiers.getSelectionModel().getMaxSelectionIndex()));
        //Folder f=folds.searchFolder(jListDossiers.getModel().getElementAt(jListDossiers.getSelectionModel().getMaxSelectionIndex()));    
        //clean();
        consulteur.execute();       
        
            txtDPrenom.setEnabled(false);
            txtDNom.setEnabled(false);
            txtDMiddleName.setEnabled(false);
            txtDDAteDeNaissance.setEnabled(false);
            jComboSexe.setEnabled(false);
            txtDREgion.setEnabled(false);
            txtDAdresse.setEnabled(false);
            txtDCourriel.setEnabled(false);            
        
            

//            System.out.println(consulteur.get());
                //setData(f);
        
    }//GEN-LAST:event_btnConsulterActionPerformed

    private void btnDeconnecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeconnecterActionPerformed
          
           this.getParent().getParent().getParent().setVisible(false);
            new FenLogin().setVisible(true);

    }//GEN-LAST:event_btnDeconnecterActionPerformed

    private void DialogErreurPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DialogErreurPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_DialogErreurPropertyChange


    private void btnAddDecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDecActionPerformed
       jFDeclaration.setSize(755, 720);
       jFDeclaration.setExtendedState(Frame.MAXIMIZED_BOTH);
       jFDeclaration.setLocationRelativeTo(this);
        jFDeclaration.setVisible(true); 
    }//GEN-LAST:event_btnAddDecActionPerformed

    /**
     * @version 1: La sauvagarde d'une nouvelle déclaration remplis à la main
     * dans le Dossier présentement ouvert.
     *  
     * @param evt 
     */
    private void btnSaveDecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveDecActionPerformed
       try {
           Declaration NouvelleDeclaration = getNewEpisode();
           folderUse.addNewEpisode(NouvelleDeclaration);
           jFDeclaration.setVisible(false);
           fullTable(tabPrevious,folderUse.getEpisodes());
           
           //to be continue..
       } catch (ParseException ex) {
           Logger.getLogger(PaneAcceuil.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_btnSaveDecActionPerformed

    private void btnCancelDecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelDecActionPerformed
       this.jFDeclaration.setVisible(false);
        
        
    }//GEN-LAST:event_btnCancelDecActionPerformed

    private void txtDateDeNaissanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateDeNaissanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateDeNaissanceActionPerformed

    private void txtNomPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomPatientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomPatientActionPerformed

    private void btnEnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnregistrerActionPerformed
        
        try {
            
            if (type) { //Vérification du type d'utilisateur
                //Mise à jour du dossier dans le cas d'un Enqueteur.
                updateFolder();
                UpdateDatasEn((Enqueteur) userUse);
            }
            else{
               
                //Seule les deux attributs suivant peuvent être changés par un Agent
                folderUse.getPatient().setAdresse(ManipFichier.parseAdresse(txtDAdresse.getText()));          
                folderUse.getPatient().setSexe(jComboSexe.getModel().getSelectedItem().toString()) ;              
                updateFolder();
                //System.out.println("Test folder use :"+  folderUse.getPatient().toString());  
                UpdateDatas();                
            }
        } catch (NullPointerException e) {
             Logger.getLogger(PaneAcceuil.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnEnregistrerActionPerformed

    private void btnConsultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultActionPerformed
        //tabPrevious.getSelectionModel()
        tabPrevious.getSelectionModel().getMaxSelectionIndex();
    }//GEN-LAST:event_btnConsultActionPerformed

    private void btnTelechargerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelechargerActionPerformed
        ChooserDeclaration = new JFileChooser(FileSystemView.getFileSystemView());
        ChooserDeclaration.setVisible(true);
        ChooserDeclaration.setFocusable(true);
        ChooserDeclaration.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter restrictTxt = new FileNameExtensionFilter("Only .txt files", "txt");
        FileNameExtensionFilter restrictBin = new FileNameExtensionFilter("Only .bin files", "bin");
        ChooserDeclaration.addChoosableFileFilter(restrictTxt);
        ChooserDeclaration.addChoosableFileFilter(restrictBin);
        int r =ChooserDeclaration.showSaveDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            File f = ChooserDeclaration.getSelectedFile().getAbsoluteFile();
            ManipFichier.lectureDeclaration(f,folds);
            if (type) {               
                UpdateDatasEn((Enqueteur) userUse);
            }else
                UpdateDatas();
        }else
            ChooserDeclaration.cancelSelection();
        
        
    }//GEN-LAST:event_btnTelechargerActionPerformed

    private void btnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierActionPerformed
        
        if (!type) {
            txtDREgion.setEnabled(true);
            txtDAdresse.setEnabled(true);
            txtDCourriel.setEnabled(true);
        }else
            try {
                throw new AdminException("Seul les Agents ou Admin peuvent modifier un Dossier");
        } catch (AdminException ex) {
            //Logger.getLogger(PaneAcceuil.class.getName()).log(Level.SEVERE, null, ex);
            txtAeraError.setText(ex.getMessage());
            DialogErreur.setVisible(true);
            DialogErreur.isFocusableWindow();
        }
        
            
    }//GEN-LAST:event_btnModifierActionPerformed
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser ChooserDeclaration;
    private javax.swing.JDialog DialogErreur;
    private javax.swing.JTable TabNDossier;
    private javax.swing.JTable Tab_notes;
    private javax.swing.JTextArea TxtAeraNote;
    private javax.swing.JButton btnAddDec;
    private javax.swing.JButton btnCancelDec;
    private javax.swing.JButton btnConsult;
    private javax.swing.JButton btnConsulter;
    private javax.swing.JButton btnDeconnecter;
    private javax.swing.JButton btnEnregistrer;
    private javax.swing.JButton btnFermer;
    private javax.swing.JButton btnModifier;
    private javax.swing.JButton btnSaveDec;
    private javax.swing.JButton btnTelecharger;
    private javax.swing.JComboBox<String> jCBStatus;
    private javax.swing.JComboBox<String> jComboSexe;
    private javax.swing.JFrame jFDeclaration;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jListDossiers;
    private javax.swing.JScrollPane jSCDeclaration;
    private javax.swing.JScrollPane jSPList;
    private javax.swing.JScrollPane jScrollError;
    private javax.swing.JScrollPane jScrollPAcceuil;
    private javax.swing.JScrollPane jScrollPNDossier;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabPAcceuil;
    protected javax.swing.JLabel jlblAccount;
    private javax.swing.JPanel jpDeclaration;
    private javax.swing.JPanel jpDossier;
    private javax.swing.JPanel jpNouveaute;
    private javax.swing.JLabel lblAdresse;
    private javax.swing.JLabel lblAdresseDr;
    private javax.swing.JLabel lblAnalyse;
    private javax.swing.JLabel lblBirthDate;
    private javax.swing.JLabel lblDMiddleName;
    private javax.swing.JLabel lblDNom;
    private javax.swing.JLabel lblDPrenom;
    private javax.swing.JLabel lblDateDeNaissance;
    private javax.swing.JLabel lblDateExecution;
    private javax.swing.JLabel lblDatePre;
    private javax.swing.JLabel lblDeAdresse;
    private javax.swing.JLabel lblDeTel;
    private javax.swing.JLabel lblDeclarant;
    private javax.swing.JLabel lblDrDemandeur;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblFormatDate;
    private javax.swing.JLabel lblFormatDate1;
    private javax.swing.JLabel lblMilieuConsult;
    private javax.swing.JLabel lblNAM;
    private javax.swing.JLabel lblNDossier;
    private javax.swing.JLabel lblNomDemande;
    private javax.swing.JLabel lblPermis;
    private javax.swing.JLabel lblPreviousEpisodes;
    private javax.swing.JLabel lblRappel;
    private javax.swing.JLabel lblRegion;
    private javax.swing.JLabel lblResultat;
    private javax.swing.JLabel lblSexe;
    private javax.swing.JLabel lblSitePre;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTypePre;
    private javax.swing.JTable tabPrevious;
    private javax.swing.JFormattedTextField txtAdresseDr;
    private javax.swing.JTextArea txtAeraError;
    private javax.swing.JFormattedTextField txtAnalyse;
    private javax.swing.JTextField txtDAdresse;
    private javax.swing.JTextField txtDCourriel;
    private javax.swing.JTextField txtDDAteDeNaissance;
    protected javax.swing.JTextField txtDMiddleName;
    protected javax.swing.JTextField txtDNom;
    protected javax.swing.JTextField txtDPrenom;
    private javax.swing.JTextField txtDREgion;
    private javax.swing.JFormattedTextField txtDateDeNaissance;
    private javax.swing.JFormattedTextField txtDateExecu;
    private javax.swing.JFormattedTextField txtDatePrelevement;
    private javax.swing.JFormattedTextField txtDeAdresse;
    private javax.swing.JFormattedTextField txtDeTel;
    private javax.swing.JFormattedTextField txtDeclarant;
    private javax.swing.JFormattedTextField txtDrDemandeur;
    private javax.swing.JFormattedTextField txtMilieuConsult;
    private javax.swing.JFormattedTextField txtNomDemande;
    private javax.swing.JFormattedTextField txtNomPatient;
    private javax.swing.JFormattedTextField txtNumASsM;
    private javax.swing.JFormattedTextField txtPermis;
    private javax.swing.JFormattedTextField txtResultat;
    private javax.swing.JFormattedTextField txtSitePre;
    private javax.swing.JFormattedTextField txtTypePre;
    // End of variables declaration//GEN-END:variables

    
    final SwingWorker<Folder, Folder> consulteur;
    private void clean(){
    txtDPrenom.setText("");
        txtDNom.setText("");
        txtDMiddleName.setText("");
        txtDDAteDeNaissance.setText("");
        jComboSexe.setSelectedItem("F");
        txtDREgion.setText("");
        txtDAdresse.setText("");
        txtDCourriel.setText("");
        tabPrevious.removeAll();
        
    }
    private void setData(Folder f) {
        
        //System.out.println((f.getPatient().getDateDeNaissance().toString()));
        txtDPrenom.setText(f.getPatient().getPrenom());
        txtDNom.setText(f.getPatient().getNom());
        txtDMiddleName.setText(f.getPatient().getAutreNom());
        txtDDAteDeNaissance.setText(ManipFichier.toStringDate(f.getPatient().getDateDeNaissance()));//probleme d''affichage de la date en format DD-MM-YYYY//regler 02:23AM 2020-09-29
        jComboSexe.setSelectedItem(f.getPatient().getSexe());
        txtDREgion.setText(f.getPatient().getRegion());
        txtDAdresse.setText(f.getPatient().getAdresse().toString());
        txtDCourriel.setText(f.getPatient().getEmail());
        fullTable(tabPrevious,f.getEpisodes());
    }

    private void fullTable(JTable table, Episode episodes) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        //Vider JTable table
        try {
            model.setRowCount(0);            
            for (Declaration dec : episodes) {                
                model.addRow(new Object[]{dec.getNoEven(),
                    dec.getResultat(), ManipFichier.toStringDate(dec.getDateDePre()), dec.getStatus(), ManipFichier.toStringDate(dec.getDateExecution())});
            }
        } catch (NullPointerException e) {
            Logger.getLogger(PaneAcceuil.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    /**
     * 
     */
    public void updateFolder() {
        //Mise a jour du dossier
        for (Folder f : folds) {
            if (f.getNumDossier() == folderUse.getNumDossier()) {
                f = folderUse;
            }
            
        }
        ManipFichier.ecritureOblect("FoldersData.bin", folds);
        System.out.println("Modification du Fichier enregistré.");
    }
    /**
 * 
 * @return Declaration
 * @throws ParseException 
 */
    protected Declaration getNewEpisode() throws ParseException {
        Declaration NouvelleDeclaration = new Declaration();
        NouvelleDeclaration.setDeclarant(txtDeclarant.getText());
        NouvelleDeclaration.setNomPatient(txtNomPatient.getText());
        NouvelleDeclaration.setDateDeNaissance(ManipFichier.StringToDate(txtDateDeNaissance.getText()));
        NouvelleDeclaration.setTel(txtDeTel.getText());
        NouvelleDeclaration.setAdresse(ManipFichier.parseAdresse(txtDeAdresse.getText()));
        NouvelleDeclaration.setNumAssMAl(txtNumASsM.getText());
        NouvelleDeclaration.setNomDr(txtDrDemandeur.getText());
        NouvelleDeclaration.setNomDemande(txtNomDemande.getText());
        NouvelleDeclaration.setPermis(txtPermis.getText());
        NouvelleDeclaration.setMilieuDeConsultation(txtMilieuConsult.getText());
        NouvelleDeclaration.setAdresseDuDemandeur(txtAdresseDr.getText());
        NouvelleDeclaration.setSiteDePre(txtSitePre.getText());
        NouvelleDeclaration.setStatus(jCBStatus.getModel().getSelectedItem().toString());
//       DateFormat f = DateFormat.getDateInstance();
//        f.setLenient(false);
////        Date d = );
        NouvelleDeclaration.setDateDePre(ManipFichier.StringToDate(txtDatePrelevement.getText()));
        NouvelleDeclaration.setDateExecution(ManipFichier.StringToDate(txtDateExecu.getText()));
        NouvelleDeclaration.setTypeDePre(txtTypePre.getText());
        NouvelleDeclaration.setAnalyse(txtAnalyse.getText());
        NouvelleDeclaration.setResultat(txtResultat.getText());
        NouvelleDeclaration.setNomDemande(jCBStatus.toString());
        System.out.println("Nouvel: "+NouvelleDeclaration.toString());
        return NouvelleDeclaration;
    }
    /**
     * 
     * @param e1
     * @throws NullPointerException 
     */
        private void UpdateDatasEn(Enqueteur e1) throws NullPointerException {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Folder fo : folds.findFolders(e1)) {
            model.addElement(String.valueOf( fo.getNumDossier()));
        }
        System.out.println("Voici vaux dossiers "+ e1.getMatricule()+":\n" + model);
        jListDossiers.setModel(model);
        // this.jListDossiers.setListData((String[]) folds.findFolders(e1).toArray()); 
    }

    /**
     * 
     */    
    private void UpdateDatas() {
        
        DefaultListModel<String> model = new DefaultListModel<>();
        
        for(Folder fo: folds){
            model.addElement(String.valueOf( fo.getNumDossier()));
            System.out.println("chaque dossiers" + fo.getNumDossier());
        }
        System.out.println("Voici les dossiers :\n" + model);
        jListDossiers.setModel(model);
    }


}
