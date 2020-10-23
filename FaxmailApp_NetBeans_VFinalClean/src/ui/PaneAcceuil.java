/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import static Control.AppCtr.folds;
import Data.ManipFichier;
import Exception.AdminException;
import Exception.NotUpdateYetExecption;
import Modele.Adresse;
import Modele.Agent;
import Modele.Declaration;
import Modele.Enqueteur;
import Modele.Episode;
import Modele.Folder;
import Modele.Patient;
import com.toedter.calendar.JDateChooser;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.ParseException;
import java.util.Calendar;
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
 * Principale 
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
     * @throws NullPointerException : Si un object est null
     * @param agt : Agent.
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
  
        if (agt.getClass()!=Enqueteur.class) {
            type=false;
            userUse=agt;
            this.jlblAccount.setText("Bienvenue " + agt.getNomUtilisateur());
                      
         try {
               
                jListDossiers.removeAll();
                jListDossiers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                jListDossiers.setAlignmentY(TOP_ALIGNMENT);
                UpdateDatas(); 
            } catch (NullPointerException e) {
                           
            txtAeraError.setText(e.getMessage());
            DialogErreur.setVisible(true);
            DialogErreur.isFocusableWindow();
            }
        }else{
        btnNewFolder.setEnabled(false);
        Enqueteur e1=(Enqueteur)agt;
        type = true;
        userUse=e1;
        this.jlblAccount.setText("Bienvenue " + e1.getMatricule());
       
            try {
               
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
        jPCenterError = new javax.swing.JPanel();
        lblError = new javax.swing.JLabel();
        jScrollError = new javax.swing.JScrollPane();
        txtAeraError = new javax.swing.JTextArea();
        jFDeclaration = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jSCDeclaration = new javax.swing.JScrollPane();
        jpDeclaration = new javax.swing.JPanel();
        jPBottomDe = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TxtAeraNote = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        btnCancelDec = new javax.swing.JButton();
        btnSaveDec = new javax.swing.JButton();
        jPUpDe = new javax.swing.JPanel();
        lblDeclarant = new javax.swing.JLabel();
        lblNamePatientDe = new javax.swing.JLabel();
        lblDateDeNaissance = new javax.swing.JLabel();
        lblDeAdresse = new javax.swing.JLabel();
        lblNAM = new javax.swing.JLabel();
        lblDeTel = new javax.swing.JLabel();
        txtDeclarant = new javax.swing.JFormattedTextField();
        txtNomPatient = new javax.swing.JFormattedTextField();
        txtDeTel = new javax.swing.JFormattedTextField();
        txtDeAdresse = new javax.swing.JFormattedTextField();
        txtNumASsM = new javax.swing.JFormattedTextField();
        jDateBirthDe = new com.toedter.calendar.JDateChooser();
        jPanelCenter = new javax.swing.JPanel();
        jCBStatus = new javax.swing.JComboBox<>();
        jDateExe = new com.toedter.calendar.JDateChooser();
        JDatePre = new com.toedter.calendar.JDateChooser();
        lblStatus = new javax.swing.JLabel();
        txtAnalyse = new javax.swing.JFormattedTextField();
        txtResultat = new javax.swing.JFormattedTextField();
        txtNomDemande = new javax.swing.JFormattedTextField();
        txtTypePre = new javax.swing.JFormattedTextField();
        txtSitePre = new javax.swing.JFormattedTextField();
        txtAdresseDr = new javax.swing.JFormattedTextField();
        txtMilieuConsult = new javax.swing.JFormattedTextField();
        txtPermis = new javax.swing.JFormattedTextField();
        txtDrDemandeur = new javax.swing.JFormattedTextField();
        lblAnalyse = new javax.swing.JLabel();
        lblResultat = new javax.swing.JLabel();
        lblDateExecution = new javax.swing.JLabel();
        lblNomDemande = new javax.swing.JLabel();
        lblTypePre = new javax.swing.JLabel();
        lblSitePre = new javax.swing.JLabel();
        lblDatePre = new javax.swing.JLabel();
        lblAdresseDr = new javax.swing.JLabel();
        lblMilieuConsult = new javax.swing.JLabel();
        lblPermis = new javax.swing.JLabel();
        lblDrDemandeur = new javax.swing.JLabel();
        ChooserDeclaration = new javax.swing.JFileChooser();
        jFNewFolder = new javax.swing.JFrame();
        jpFolder = new javax.swing.JPanel();
        jpUp = new javax.swing.JPanel();
        txtNumFolder = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        jpCenter = new javax.swing.JPanel();
        lblNamePatient = new javax.swing.JLabel();
        lblbFirstNamePatient = new javax.swing.JLabel();
        lblOtherName = new javax.swing.JLabel();
        lblSexeP = new javax.swing.JLabel();
        lblRegionPatient = new javax.swing.JLabel();
        lblRAMQPatient = new javax.swing.JLabel();
        lblEmailPatient = new javax.swing.JLabel();
        CBSexPatient = new javax.swing.JComboBox<>();
        txtNamePatient = new javax.swing.JTextField();
        txtFirstNamePatient = new javax.swing.JTextField();
        txtOtherNameP = new javax.swing.JTextField();
        txtRegionP = new javax.swing.JTextField();
        txtRAMQP = new javax.swing.JTextField();
        txtEmailP = new javax.swing.JTextField();
        lblBirthDateP = new javax.swing.JLabel();
        jDateCBirth = new com.toedter.calendar.JDateChooser();
        jpBottom = new javax.swing.JPanel();
        lblNumCivil = new javax.swing.JLabel();
        lblSt = new javax.swing.JLabel();
        lblApp = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        lblCountry = new javax.swing.JLabel();
        lblZIP = new javax.swing.JLabel();
        txtNumCP = new javax.swing.JTextField();
        txtSt = new javax.swing.JTextField();
        txtAppP = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        txtCountry = new javax.swing.JTextField();
        txtZIP = new javax.swing.JTextField();
        lblState = new javax.swing.JLabel();
        txtState = new javax.swing.JTextField();
        btnSaveNF = new javax.swing.JButton();
        btnCancelNF = new javax.swing.JButton();
        internalHall = new javax.swing.JInternalFrame();
        jSPList = new javax.swing.JScrollPane();
        jListDossiers = new javax.swing.JList<>();
        btnEnregistrer = new javax.swing.JButton();
        btnFermer = new javax.swing.JButton();
        btnDeconnecter = new javax.swing.JButton();
        jScrollPAcceuil = new javax.swing.JScrollPane();
        jTabPAcceuil = new javax.swing.JTabbedPane();
        jpDossier = new javax.swing.JPanel();
        lblPreviousEpisodes = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabPrevious = new javax.swing.JTable();
        btnAddDec = new javax.swing.JButton();
        btnConsult = new javax.swing.JButton();
        btnTelecharger = new javax.swing.JButton();
        jPTFoldUP = new javax.swing.JPanel();
        txtDAdresse = new javax.swing.JTextField();
        lblAdresse = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        jComboSexe = new javax.swing.JComboBox<>();
        lblBirthDate = new javax.swing.JLabel();
        lblRegion = new javax.swing.JLabel();
        lblDPrenom = new javax.swing.JLabel();
        lblDNom = new javax.swing.JLabel();
        txtDPrenom = new javax.swing.JTextField();
        txtDMiddleName = new javax.swing.JTextField();
        txtDCourriel = new javax.swing.JTextField();
        txtDREgion = new javax.swing.JTextField();
        lblSexe = new javax.swing.JLabel();
        lblDMiddleName = new javax.swing.JLabel();
        txtDNom = new javax.swing.JTextField();
        jDateBirthTab = new com.toedter.calendar.JDateChooser();
        btnModifier = new javax.swing.JButton();
        btnConsulter = new javax.swing.JButton();
        btnNewFolder = new javax.swing.JButton();
        jPanelTop = new javax.swing.JPanel();
        jlblAccount = new javax.swing.JLabel();

        DialogErreur.setTitle("Error!!");
        DialogErreur.setBackground(new java.awt.Color(20, 88, 130));
        DialogErreur.setMinimumSize(new java.awt.Dimension(400, 167));
        DialogErreur.setModal(true);
        DialogErreur.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                DialogErreurPropertyChange(evt);
            }
        });

        jPCenterError.setBackground(new java.awt.Color(20, 88, 130));

        lblError.setForeground(new java.awt.Color(255, 255, 255));
        lblError.setText("Error:");

        jScrollError.setBackground(new java.awt.Color(0, 102, 102));
        jScrollError.setForeground(new java.awt.Color(255, 255, 255));
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

        javax.swing.GroupLayout jPCenterErrorLayout = new javax.swing.GroupLayout(jPCenterError);
        jPCenterError.setLayout(jPCenterErrorLayout);
        jPCenterErrorLayout.setHorizontalGroup(
            jPCenterErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCenterErrorLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollError, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPCenterErrorLayout.setVerticalGroup(
            jPCenterErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCenterErrorLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPCenterErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollError, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblError))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DialogErreurLayout = new javax.swing.GroupLayout(DialogErreur.getContentPane());
        DialogErreur.getContentPane().setLayout(DialogErreurLayout);
        DialogErreurLayout.setHorizontalGroup(
            DialogErreurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DialogErreurLayout.createSequentialGroup()
                .addComponent(jPCenterError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        DialogErreurLayout.setVerticalGroup(
            DialogErreurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPCenterError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jFDeclaration.setTitle("Déclaration");
        jFDeclaration.setBackground(new java.awt.Color(20, 88, 130));
        jFDeclaration.setMaximizedBounds(new java.awt.Rectangle(0, 0, 645, 700));
        jFDeclaration.setMaximumSize(new java.awt.Dimension(800, 700));
        jFDeclaration.setMinimumSize(new java.awt.Dimension(762, 680));
        jFDeclaration.setName("frameDeclaration\n"); // NOI18N
        jFDeclaration.setResizable(false);
        jFDeclaration.setSize(new java.awt.Dimension(762, 680));

        jPanel1.setBackground(new java.awt.Color(20, 88, 130));

        jSCDeclaration.setBackground(new java.awt.Color(20, 88, 130));
        jSCDeclaration.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jSCDeclaration.setAutoscrolls(true);
        jSCDeclaration.setMaximumSize(new java.awt.Dimension(800, 800));
        jSCDeclaration.setMinimumSize(new java.awt.Dimension(762, 680));
        jSCDeclaration.setNextFocusableComponent(jpDeclaration);
        jSCDeclaration.setPreferredSize(new java.awt.Dimension(762, 680));
        jSCDeclaration.setVerifyInputWhenFocusTarget(false);

        jpDeclaration.setBackground(new java.awt.Color(20, 88, 130));
        jpDeclaration.setAutoscrolls(true);
        jpDeclaration.setMaximumSize(new java.awt.Dimension(800, 700));
        jpDeclaration.setMinimumSize(new java.awt.Dimension(762, 680));
        jpDeclaration.setPreferredSize(new java.awt.Dimension(645, 650));

        jPBottomDe.setBackground(new java.awt.Color(20, 88, 130));

        TxtAeraNote.setColumns(20);
        TxtAeraNote.setRows(5);
        TxtAeraNote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAnalyseKeyPressed(evt);
            }
        });
        jScrollPane5.setViewportView(TxtAeraNote);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Notes:");

        btnCancelDec.setBackground(new java.awt.Color(25, 25, 112));
        btnCancelDec.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelDec.setText("Annuler");
        btnCancelDec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelDecActionPerformed(evt);
            }
        });

        btnSaveDec.setBackground(new java.awt.Color(25, 25, 112));
        btnSaveDec.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveDec.setText("Sauvegarder");
        btnSaveDec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveDecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPBottomDeLayout = new javax.swing.GroupLayout(jPBottomDe);
        jPBottomDe.setLayout(jPBottomDeLayout);
        jPBottomDeLayout.setHorizontalGroup(
            jPBottomDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBottomDeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPBottomDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPBottomDeLayout.createSequentialGroup()
                        .addComponent(btnCancelDec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(9, 9, 9))
                    .addGroup(jPBottomDeLayout.createSequentialGroup()
                        .addComponent(btnSaveDec)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPBottomDeLayout.setVerticalGroup(
            jPBottomDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBottomDeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBottomDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPBottomDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPBottomDeLayout.createSequentialGroup()
                            .addComponent(btnSaveDec)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelDec))
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPUpDe.setBackground(new java.awt.Color(20, 88, 130));
        jPUpDe.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(51, 0, 153))); // NOI18N

        lblDeclarant.setForeground(new java.awt.Color(255, 255, 255));
        lblDeclarant.setLabelFor(txtDeclarant);
        lblDeclarant.setText("Déclarant:");

        lblNamePatientDe.setForeground(new java.awt.Color(255, 255, 255));
        lblNamePatientDe.setLabelFor(txtNomPatient);
        lblNamePatientDe.setText("Nom du patient:");

        lblDateDeNaissance.setForeground(new java.awt.Color(255, 255, 255));
        lblDateDeNaissance.setText("Date de naissance:");

        lblDeAdresse.setForeground(new java.awt.Color(255, 255, 255));
        lblDeAdresse.setLabelFor(txtDeAdresse);
        lblDeAdresse.setText("Adresse:");

        lblNAM.setForeground(new java.awt.Color(255, 255, 255));
        lblNAM.setLabelFor(txtNumASsM);
        lblNAM.setText("Numéro d'assurance maladie:");

        lblDeTel.setForeground(new java.awt.Color(255, 255, 255));
        lblDeTel.setLabelFor(txtDeTel);
        lblDeTel.setText("Téléphone:");

        txtDeclarant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAnalyseKeyPressed(evt);
            }
        });

        txtNomPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomPatientActionPerformed(evt);
            }
        });
        txtNomPatient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAnalyseKeyPressed(evt);
            }
        });

        txtDeTel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAnalyseKeyPressed(evt);
            }
        });

        txtDeAdresse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAnalyseKeyPressed(evt);
            }
        });

        txtNumASsM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAnalyseKeyPressed(evt);
            }
        });

        jDateBirthDe.setDateFormatString("yy-MM-dd");
        jDateBirthDe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAnalyseKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPUpDeLayout = new javax.swing.GroupLayout(jPUpDe);
        jPUpDe.setLayout(jPUpDeLayout);
        jPUpDeLayout.setHorizontalGroup(
            jPUpDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPUpDeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPUpDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNamePatientDe)
                    .addComponent(lblDeclarant)
                    .addComponent(lblDateDeNaissance)
                    .addComponent(lblDeAdresse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPUpDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPUpDeLayout.createSequentialGroup()
                        .addGroup(jPUpDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDeclarant)
                            .addGroup(jPUpDeLayout.createSequentialGroup()
                                .addGroup(jPUpDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPUpDeLayout.createSequentialGroup()
                                        .addComponent(jDateBirthDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblNAM))
                                    .addGroup(jPUpDeLayout.createSequentialGroup()
                                        .addComponent(txtNomPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblDeTel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPUpDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDeTel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNumASsM, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPUpDeLayout.createSequentialGroup()
                        .addComponent(txtDeAdresse)
                        .addGap(42, 42, 42))))
        );
        jPUpDeLayout.setVerticalGroup(
            jPUpDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPUpDeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPUpDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDeclarant)
                    .addComponent(txtDeclarant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPUpDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNamePatientDe)
                    .addComponent(txtNomPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDeTel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDeTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPUpDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPUpDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDateDeNaissance)
                        .addComponent(lblNAM)
                        .addComponent(txtNumASsM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateBirthDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPUpDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDeAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDeAdresse))
                .addContainerGap())
        );

        jPanelCenter.setBackground(new java.awt.Color(20, 88, 130));
        jPanelCenter.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Test", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(51, 0, 153))); // NOI18N

        jCBStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Confirmé", "Infirmé", "En suspend", "Suspect", "Probable" }));

        jDateExe.setDateFormatString("yy-MM-dd");

        JDatePre.setDateFormatString("yy-MM-dd");

        lblStatus.setForeground(new java.awt.Color(255, 255, 255));
        lblStatus.setLabelFor(txtTypePre);
        lblStatus.setText("Status:");

        txtAnalyse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAnalyseKeyPressed(evt);
            }
        });

        txtResultat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAnalyseKeyPressed(evt);
            }
        });

        txtNomDemande.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAnalyseKeyPressed(evt);
            }
        });

        txtTypePre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAnalyseKeyPressed(evt);
            }
        });

        txtSitePre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAnalyseKeyPressed(evt);
            }
        });

        txtAdresseDr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAnalyseKeyPressed(evt);
            }
        });

        txtMilieuConsult.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAnalyseKeyPressed(evt);
            }
        });

        txtPermis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAnalyseKeyPressed(evt);
            }
        });

        txtDrDemandeur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAnalyseKeyPressed(evt);
            }
        });

        lblAnalyse.setForeground(new java.awt.Color(255, 255, 255));
        lblAnalyse.setLabelFor(txtAnalyse);
        lblAnalyse.setText("Analyse:");

        lblResultat.setForeground(new java.awt.Color(255, 255, 255));
        lblResultat.setLabelFor(txtResultat);
        lblResultat.setText("Résultat:");

        lblDateExecution.setForeground(new java.awt.Color(255, 255, 255));
        lblDateExecution.setText("Date d'exécution:");

        lblNomDemande.setForeground(new java.awt.Color(255, 255, 255));
        lblNomDemande.setLabelFor(txtNomDemande);
        lblNomDemande.setText("Nom de la demande:");

        lblTypePre.setForeground(new java.awt.Color(255, 255, 255));
        lblTypePre.setLabelFor(txtTypePre);
        lblTypePre.setText("Type de prélèvement:");

        lblSitePre.setForeground(new java.awt.Color(255, 255, 255));
        lblSitePre.setText("Site de prélèvement:");

        lblDatePre.setForeground(new java.awt.Color(255, 255, 255));
        lblDatePre.setText("Date de prélèvement:");

        lblAdresseDr.setForeground(new java.awt.Color(255, 255, 255));
        lblAdresseDr.setLabelFor(txtAdresseDr);
        lblAdresseDr.setText("Adresse médecin demandeur:");

        lblMilieuConsult.setForeground(new java.awt.Color(255, 255, 255));
        lblMilieuConsult.setLabelFor(txtMilieuConsult);
        lblMilieuConsult.setText("Milieu de consultation:");

        lblPermis.setForeground(new java.awt.Color(255, 255, 255));
        lblPermis.setLabelFor(txtPermis);
        lblPermis.setText("Numéro du permis d'exercice:");

        lblDrDemandeur.setForeground(new java.awt.Color(255, 255, 255));
        lblDrDemandeur.setLabelFor(txtDrDemandeur);
        lblDrDemandeur.setText("Nom du médecin demandeur:");

        javax.swing.GroupLayout jPanelCenterLayout = new javax.swing.GroupLayout(jPanelCenter);
        jPanelCenter.setLayout(jPanelCenterLayout);
        jPanelCenterLayout.setHorizontalGroup(
            jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCenterLayout.createSequentialGroup()
                .addGap(384, 384, 384)
                .addComponent(lblStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCenterLayout.createSequentialGroup()
                .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDrDemandeur)
                    .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblAdresseDr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPermis, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(lblMilieuConsult, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNomDemande, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblSitePre)
                        .addComponent(lblDatePre)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCenterLayout.createSequentialGroup()
                        .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPermis, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDrDemandeur, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelCenterLayout.createSequentialGroup()
                                .addComponent(txtMilieuConsult, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTypePre)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtAdresseDr)
                    .addGroup(jPanelCenterLayout.createSequentialGroup()
                        .addComponent(JDatePre, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDateExecution))
                    .addGroup(jPanelCenterLayout.createSequentialGroup()
                        .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSitePre)
                            .addComponent(txtNomDemande))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAnalyse, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblResultat, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTypePre, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateExe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAnalyse)
                    .addComponent(txtResultat))
                .addGap(87, 87, 87))
        );
        jPanelCenterLayout.setVerticalGroup(
            jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDrDemandeur, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDrDemandeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus)
                    .addComponent(jCBStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPermis)
                    .addComponent(txtPermis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMilieuConsult)
                    .addComponent(txtMilieuConsult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTypePre)
                    .addComponent(txtTypePre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdresseDr)
                    .addComponent(txtAdresseDr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCenterLayout.createSequentialGroup()
                        .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDateExecution)
                            .addComponent(lblDatePre)
                            .addComponent(JDatePre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSitePre)
                            .addComponent(txtSitePre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomDemande, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNomDemande)))
                    .addGroup(jPanelCenterLayout.createSequentialGroup()
                        .addComponent(jDateExe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAnalyse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAnalyse))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtResultat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblResultat))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jpDeclarationLayout = new javax.swing.GroupLayout(jpDeclaration);
        jpDeclaration.setLayout(jpDeclarationLayout);
        jpDeclarationLayout.setHorizontalGroup(
            jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDeclarationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPUpDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jpDeclarationLayout.createSequentialGroup()
                .addGroup(jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelCenter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPBottomDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpDeclarationLayout.setVerticalGroup(
            jpDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDeclarationLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPUpDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPBottomDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSCDeclaration.setViewportView(jpDeclaration);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSCDeclaration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSCDeclaration, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jFDeclarationLayout = new javax.swing.GroupLayout(jFDeclaration.getContentPane());
        jFDeclaration.getContentPane().setLayout(jFDeclarationLayout);
        jFDeclarationLayout.setHorizontalGroup(
            jFDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jFDeclarationLayout.setVerticalGroup(
            jFDeclarationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFDeclarationLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        ChooserDeclaration.setBackground(java.awt.Color.magenta);
        ChooserDeclaration.setDialogTitle("Choisir votre Déclaration.txt que vous voulé enregistrer...");
        ChooserDeclaration.setToolTipText("fichier .txt ou .bin");
        ChooserDeclaration.setEnabled(false);
        ChooserDeclaration.setFocusCycleRoot(true);
        ChooserDeclaration.setName(""); // NOI18N

        jFNewFolder.setTitle("Création de Dossier");
        jFNewFolder.setBackground(new java.awt.Color(20, 88, 130));
        jFNewFolder.setMaximumSize(new java.awt.Dimension(810, 510));
        jFNewFolder.setMinimumSize(new java.awt.Dimension(800, 500));
        jFNewFolder.setPreferredSize(new java.awt.Dimension(800, 500));
        jFNewFolder.setResizable(false);

        jpFolder.setBackground(new java.awt.Color(20, 88, 130));

        jpUp.setBackground(new java.awt.Color(20, 88, 130));
        jpUp.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Numéro de dossier", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(51, 0, 153))); // NOI18N

        txtNumFolder.setForeground(new java.awt.Color(51, 0, 204));
        txtNumFolder.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(51, 0, 153), new java.awt.Color(102, 0, 102)), null));
        txtNumFolder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailPKeyPressed(evt);
            }
        });

        lblID.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblID.setForeground(new java.awt.Color(255, 255, 255));
        lblID.setText("Équivaut au numéro d'assurance maladie");

        javax.swing.GroupLayout jpUpLayout = new javax.swing.GroupLayout(jpUp);
        jpUp.setLayout(jpUpLayout);
        jpUpLayout.setHorizontalGroup(
            jpUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNumFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
        );
        jpUpLayout.setVerticalGroup(
            jpUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUpLayout.createSequentialGroup()
                .addGroup(jpUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jpUpLayout.createSequentialGroup()
                        .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpUpLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtNumFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jpCenter.setBackground(new java.awt.Color(20, 88, 130));
        jpCenter.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Patient", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(51, 0, 153))); // NOI18N

        lblNamePatient.setForeground(new java.awt.Color(255, 255, 255));
        lblNamePatient.setText("Nom:");

        lblbFirstNamePatient.setForeground(new java.awt.Color(255, 255, 255));
        lblbFirstNamePatient.setText("Prénom:");

        lblOtherName.setForeground(new java.awt.Color(255, 255, 255));
        lblOtherName.setText("Autre nom:");

        lblSexeP.setForeground(new java.awt.Color(255, 255, 255));
        lblSexeP.setText("Sexe:");

        lblRegionPatient.setForeground(new java.awt.Color(255, 255, 255));
        lblRegionPatient.setText("Région:");

        lblRAMQPatient.setForeground(new java.awt.Color(255, 255, 255));
        lblRAMQPatient.setText("RAMQ:");

        lblEmailPatient.setForeground(new java.awt.Color(255, 255, 255));
        lblEmailPatient.setText("Courriel:");

        CBSexPatient.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F", "T" }));

        txtNamePatient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailPKeyPressed(evt);
            }
        });

        txtFirstNamePatient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailPKeyPressed(evt);
            }
        });

        txtOtherNameP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailPKeyPressed(evt);
            }
        });

        txtRegionP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailPKeyPressed(evt);
            }
        });

        txtRAMQP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailPKeyPressed(evt);
            }
        });

        txtEmailP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailPKeyPressed(evt);
            }
        });

        lblBirthDateP.setForeground(new java.awt.Color(255, 255, 255));
        lblBirthDateP.setText("Date de Naissance:");

        jDateCBirth.setDateFormatString("yy-MM-dd");

        javax.swing.GroupLayout jpCenterLayout = new javax.swing.GroupLayout(jpCenter);
        jpCenter.setLayout(jpCenterLayout);
        jpCenterLayout.setHorizontalGroup(
            jpCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCenterLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jpCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCenterLayout.createSequentialGroup()
                        .addComponent(lblOtherName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOtherNameP))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCenterLayout.createSequentialGroup()
                        .addComponent(lblbFirstNamePatient)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFirstNamePatient))
                    .addGroup(jpCenterLayout.createSequentialGroup()
                        .addComponent(lblNamePatient)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNamePatient))
                    .addGroup(jpCenterLayout.createSequentialGroup()
                        .addGroup(jpCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRegionPatient)
                            .addComponent(lblEmailPatient))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpCenterLayout.createSequentialGroup()
                                .addComponent(txtRegionP, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblRAMQPatient)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRAMQP))
                            .addGroup(jpCenterLayout.createSequentialGroup()
                                .addComponent(txtEmailP, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblBirthDateP)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateCBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpCenterLayout.createSequentialGroup()
                                .addComponent(lblSexeP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CBSexPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(13, 13, 13))
        );
        jpCenterLayout.setVerticalGroup(
            jpCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNamePatient)
                    .addComponent(txtNamePatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblbFirstNamePatient)
                    .addComponent(txtFirstNamePatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOtherName)
                    .addComponent(txtOtherNameP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegionPatient)
                    .addComponent(txtRegionP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRAMQPatient)
                    .addComponent(txtRAMQP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSexeP)
                    .addComponent(CBSexPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEmailPatient)
                        .addComponent(txtEmailP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBirthDateP))
                    .addComponent(jDateCBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jpBottom.setBackground(new java.awt.Color(20, 88, 130));
        jpBottom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adresse", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(51, 0, 153))); // NOI18N

        lblNumCivil.setForeground(new java.awt.Color(255, 255, 255));
        lblNumCivil.setText("Numéro civil:");

        lblSt.setForeground(new java.awt.Color(255, 255, 255));
        lblSt.setText("Rue:");

        lblApp.setForeground(new java.awt.Color(255, 255, 255));
        lblApp.setText("App:");

        lblCity.setForeground(new java.awt.Color(255, 255, 255));
        lblCity.setText("Ville:");

        lblCountry.setForeground(new java.awt.Color(255, 255, 255));
        lblCountry.setText("Pays:");

        lblZIP.setForeground(new java.awt.Color(255, 255, 255));
        lblZIP.setText("Code Postal:");

        txtNumCP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailPKeyPressed(evt);
            }
        });

        txtSt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailPKeyPressed(evt);
            }
        });

        txtAppP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailPKeyPressed(evt);
            }
        });

        txtCity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailPKeyPressed(evt);
            }
        });

        txtCountry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailPKeyPressed(evt);
            }
        });

        txtZIP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailPKeyPressed(evt);
            }
        });

        lblState.setForeground(new java.awt.Color(255, 255, 255));
        lblState.setText("Province:");

        txtState.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailPKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jpBottomLayout = new javax.swing.GroupLayout(jpBottom);
        jpBottom.setLayout(jpBottomLayout);
        jpBottomLayout.setHorizontalGroup(
            jpBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBottomLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jpBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpBottomLayout.createSequentialGroup()
                        .addComponent(lblApp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAppP))
                    .addComponent(lblNumCivil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBottomLayout.createSequentialGroup()
                        .addComponent(lblCity)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblState)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCountry)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblZIP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtZIP, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpBottomLayout.createSequentialGroup()
                        .addComponent(txtNumCP, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(lblSt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSt)
                        .addGap(81, 81, 81))))
        );
        jpBottomLayout.setVerticalGroup(
            jpBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumCivil)
                    .addComponent(lblSt)
                    .addComponent(txtNumCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jpBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApp)
                    .addComponent(txtAppP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCity)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCountry)
                    .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblZIP)
                    .addComponent(txtZIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblState)
                    .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSaveNF.setBackground(new java.awt.Color(25, 25, 112));
        btnSaveNF.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveNF.setText("Enregistrer");
        btnSaveNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveNFActionPerformed(evt);
            }
        });

        btnCancelNF.setBackground(new java.awt.Color(25, 25, 112));
        btnCancelNF.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelNF.setText("Annuler");
        btnCancelNF.setMaximumSize(new java.awt.Dimension(94, 32));
        btnCancelNF.setMinimumSize(new java.awt.Dimension(94, 32));
        btnCancelNF.setPreferredSize(new java.awt.Dimension(94, 32));
        btnCancelNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelNFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpFolderLayout = new javax.swing.GroupLayout(jpFolder);
        jpFolder.setLayout(jpFolderLayout);
        jpFolderLayout.setHorizontalGroup(
            jpFolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFolderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jpCenter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpFolderLayout.createSequentialGroup()
                        .addComponent(jpUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jpFolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSaveNF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelNF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpFolderLayout.setVerticalGroup(
            jpFolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFolderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpFolderLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btnSaveNF, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelNF, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpCenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jFNewFolderLayout = new javax.swing.GroupLayout(jFNewFolder.getContentPane());
        jFNewFolder.getContentPane().setLayout(jFNewFolderLayout);
        jFNewFolderLayout.setHorizontalGroup(
            jFNewFolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFNewFolderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jFNewFolderLayout.setVerticalGroup(
            jFNewFolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFNewFolderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(20, 88, 130));

        internalHall.setBackground(new java.awt.Color(20, 88, 130));
        internalHall.setEnabled(false);
        internalHall.setVisible(true);

        jSPList.setBackground(new java.awt.Color(255, 255, 255));
        jSPList.setMaximumSize(new java.awt.Dimension(710, 370));

        jListDossiers.setBackground(new java.awt.Color(102, 204, 255));
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

        btnEnregistrer.setBackground(new java.awt.Color(25, 25, 112));
        btnEnregistrer.setForeground(new java.awt.Color(255, 255, 255));
        btnEnregistrer.setText("Enregistrer");
        btnEnregistrer.setMaximumSize(new java.awt.Dimension(103, 32));
        btnEnregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnregistrerActionPerformed(evt);
            }
        });

        btnFermer.setBackground(new java.awt.Color(25, 25, 112));
        btnFermer.setForeground(new java.awt.Color(255, 255, 255));
        btnFermer.setText("Fermer");
        btnFermer.setMaximumSize(new java.awt.Dimension(103, 32));

        btnDeconnecter.setBackground(new java.awt.Color(25, 25, 112));
        btnDeconnecter.setForeground(new java.awt.Color(255, 255, 255));
        btnDeconnecter.setText("Déconnecter");
        btnDeconnecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeconnecterActionPerformed(evt);
            }
        });

        jScrollPAcceuil.setBackground(new java.awt.Color(20, 88, 130));
        jScrollPAcceuil.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPAcceuil.setMaximumSize(new java.awt.Dimension(32767, 800));

        jTabPAcceuil.setBackground(new java.awt.Color(20, 88, 130));
        jTabPAcceuil.setForeground(new java.awt.Color(255, 255, 255));
        jTabPAcceuil.setMaximumSize(new java.awt.Dimension(710, 362));

        jpDossier.setBackground(new java.awt.Color(20, 88, 130));
        jpDossier.setForeground(new java.awt.Color(255, 255, 255));
        jpDossier.setAutoscrolls(true);
        jpDossier.setMaximumSize(new java.awt.Dimension(710, 362));

        lblPreviousEpisodes.setForeground(new java.awt.Color(255, 255, 255));
        lblPreviousEpisodes.setText("Maladie antérieurs:");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));

        jScrollPane3.setBackground(new java.awt.Color(20, 88, 130));

        tabPrevious.setBackground(new java.awt.Color(87, 87, 91));
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
        tabPrevious.setGridColor(new java.awt.Color(102, 204, 255));
        jScrollPane3.setViewportView(tabPrevious);

        btnAddDec.setBackground(new java.awt.Color(25, 25, 112));
        btnAddDec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_add_32px.png"))); // NOI18N
        btnAddDec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDecActionPerformed(evt);
            }
        });

        btnConsult.setBackground(new java.awt.Color(25, 25, 112));
        btnConsult.setForeground(new java.awt.Color(255, 255, 255));
        btnConsult.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_detective_26px.png"))); // NOI18N
        btnConsult.setText("Consulter");
        btnConsult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultActionPerformed(evt);
            }
        });

        btnTelecharger.setBackground(new java.awt.Color(25, 25, 112));
        btnTelecharger.setForeground(new java.awt.Color(255, 255, 255));
        btnTelecharger.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_download_26px.png"))); // NOI18N
        btnTelecharger.setText("Télécharger");
        btnTelecharger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelechargerActionPerformed(evt);
            }
        });

        jPTFoldUP.setBackground(new java.awt.Color(20, 88, 130));
        jPTFoldUP.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Client", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(51, 0, 153))); // NOI18N
        jPTFoldUP.setForeground(new java.awt.Color(255, 255, 255));
        jPTFoldUP.setToolTipText("");

        lblAdresse.setForeground(new java.awt.Color(255, 255, 255));
        lblAdresse.setLabelFor(txtDAdresse);
        lblAdresse.setText("Adresse:");

        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setLabelFor(txtDCourriel);
        lblEmail.setText("Courriel:");

        jComboSexe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F", "T" }));

        lblBirthDate.setForeground(new java.awt.Color(255, 255, 255));
        lblBirthDate.setText("Date de naissance:");

        lblRegion.setForeground(new java.awt.Color(255, 255, 255));
        lblRegion.setLabelFor(txtDREgion);
        lblRegion.setText("Region:");

        lblDPrenom.setForeground(new java.awt.Color(255, 255, 255));
        lblDPrenom.setLabelFor(txtDPrenom);
        lblDPrenom.setText("Prénom:");

        lblDNom.setForeground(new java.awt.Color(255, 255, 255));
        lblDNom.setLabelFor(txtDNom);
        lblDNom.setText("Nom:");

        lblSexe.setForeground(new java.awt.Color(255, 255, 255));
        lblSexe.setLabelFor(jComboSexe);
        lblSexe.setText("Sexe:");

        lblDMiddleName.setForeground(new java.awt.Color(255, 255, 255));
        lblDMiddleName.setLabelFor(txtDMiddleName);
        lblDMiddleName.setText("Autre nom:");

        jDateBirthTab.setBackground(new java.awt.Color(87, 87, 91));
        jDateBirthTab.setDateFormatString("yy-MM-dd\n");
        jDateBirthTab.setIcon(null);

        javax.swing.GroupLayout jPTFoldUPLayout = new javax.swing.GroupLayout(jPTFoldUP);
        jPTFoldUP.setLayout(jPTFoldUPLayout);
        jPTFoldUPLayout.setHorizontalGroup(
            jPTFoldUPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTFoldUPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPTFoldUPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEmail)
                    .addComponent(lblBirthDate)
                    .addComponent(lblAdresse)
                    .addComponent(lblDNom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPTFoldUPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDCourriel, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPTFoldUPLayout.createSequentialGroup()
                        .addGroup(jPTFoldUPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPTFoldUPLayout.createSequentialGroup()
                                .addComponent(txtDNom, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDPrenom))
                            .addComponent(jDateBirthTab, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPTFoldUPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPTFoldUPLayout.createSequentialGroup()
                                .addComponent(lblSexe)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboSexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPTFoldUPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPTFoldUPLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lblRegion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDREgion))
                            .addGroup(jPTFoldUPLayout.createSequentialGroup()
                                .addComponent(lblDMiddleName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(txtDAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPTFoldUPLayout.setVerticalGroup(
            jPTFoldUPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTFoldUPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPTFoldUPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDNom)
                    .addComponent(lblDPrenom)
                    .addComponent(lblDMiddleName)
                    .addComponent(txtDNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPTFoldUPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPTFoldUPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSexe)
                        .addComponent(jComboSexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBirthDate)
                        .addComponent(lblRegion)
                        .addComponent(txtDREgion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateBirthTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPTFoldUPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdresse)
                    .addComponent(txtDAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPTFoldUPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtDCourriel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpDossierLayout = new javax.swing.GroupLayout(jpDossier);
        jpDossier.setLayout(jpDossierLayout);
        jpDossierLayout.setHorizontalGroup(
            jpDossierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDossierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDossierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jpDossierLayout.createSequentialGroup()
                        .addGroup(jpDossierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPTFoldUP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPreviousEpisodes)
                            .addGroup(jpDossierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jpDossierLayout.createSequentialGroup()
                                    .addComponent(btnTelecharger)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnConsult)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnAddDec))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpDossierLayout.setVerticalGroup(
            jpDossierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDossierLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPTFoldUP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPreviousEpisodes)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDossierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddDec, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jpDossierLayout.createSequentialGroup()
                        .addGroup(jpDossierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnConsult)
                            .addComponent(btnTelecharger))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(60, 60, 60))
        );

        jTabPAcceuil.addTab("Dossier", jpDossier);

        jScrollPAcceuil.setViewportView(jTabPAcceuil);

        btnModifier.setBackground(new java.awt.Color(25, 25, 112));
        btnModifier.setForeground(new java.awt.Color(255, 255, 255));
        btnModifier.setText("Modifier");
        btnModifier.setMaximumSize(new java.awt.Dimension(103, 32));
        btnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierActionPerformed(evt);
            }
        });

        btnConsulter.setBackground(new java.awt.Color(25, 25, 112));
        btnConsulter.setForeground(new java.awt.Color(255, 255, 255));
        btnConsulter.setText("Consulter");
        btnConsulter.setMaximumSize(new java.awt.Dimension(103, 32));
        btnConsulter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsulterActionPerformed(evt);
            }
        });

        btnNewFolder.setBackground(new java.awt.Color(25, 25, 112));
        btnNewFolder.setForeground(new java.awt.Color(255, 255, 255));
        btnNewFolder.setText("Nouveau");
        btnNewFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewFolderActionPerformed(evt);
            }
        });

        jPanelTop.setBackground(new java.awt.Color(0, 51, 153));
        jPanelTop.setForeground(new java.awt.Color(255, 255, 255));

        jlblAccount.setBackground(new java.awt.Color(51, 51, 255));
        jlblAccount.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jlblAccount.setForeground(new java.awt.Color(255, 255, 255));
        jlblAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_user_32px.png"))); // NOI18N
        jlblAccount.setText("Account Settings --username@mailserver");
        jlblAccount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jPanelTopLayout = new javax.swing.GroupLayout(jPanelTop);
        jPanelTop.setLayout(jPanelTopLayout);
        jPanelTopLayout.setHorizontalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelTopLayout.setVerticalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout internalHallLayout = new javax.swing.GroupLayout(internalHall.getContentPane());
        internalHall.getContentPane().setLayout(internalHallLayout);
        internalHallLayout.setHorizontalGroup(
            internalHallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(internalHallLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(internalHallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(internalHallLayout.createSequentialGroup()
                        .addGroup(internalHallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnModifier, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDeconnecter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFermer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEnregistrer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSPList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnConsulter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNewFolder, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPAcceuil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        internalHallLayout.setVerticalGroup(
            internalHallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(internalHallLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(internalHallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(internalHallLayout.createSequentialGroup()
                        .addComponent(jSPList, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNewFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConsulter, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFermer, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeconnecter, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addComponent(jScrollPAcceuil, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(internalHall)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(internalHall, javax.swing.GroupLayout.Alignment.TRAILING)
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
        System.out.println(jListDossiers.getModel().getElementAt(jListDossiers.getSelectionModel().getMaxSelectionIndex()));
          folderUse=folds.searchFolder(jListDossiers.getModel().getElementAt(jListDossiers.getSelectionModel().getMaxSelectionIndex()));
          setData(folderUse);

            
            
        //consulteur.execute();       
        
            txtDPrenom.setEnabled(false);
            txtDNom.setEnabled(false);
            txtDMiddleName.setEnabled(false);
            jDateBirthTab.setEnabled(false);
            jComboSexe.setEnabled(false);
            txtDREgion.setEnabled(false);
            txtDAdresse.setEnabled(false);
            txtDCourriel.setEnabled(false);            
    }//GEN-LAST:event_btnConsulterActionPerformed

    private void btnDeconnecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeconnecterActionPerformed
          
           this.getParent().getParent().getParent().setVisible(false);
            new FenLogin().setVisible(true);

    }//GEN-LAST:event_btnDeconnecterActionPerformed

    private void DialogErreurPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DialogErreurPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_DialogErreurPropertyChange


    private void btnAddDecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDecActionPerformed
       //jFDeclaration.setSize(762, 680);
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
        CreateNewDeclaration();
    }//GEN-LAST:event_btnSaveDecActionPerformed

    private void btnCancelDecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelDecActionPerformed
       this.jFDeclaration.dispose();
    }//GEN-LAST:event_btnCancelDecActionPerformed

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
        int colunm = tabPrevious.getSelectionModel().getMaxSelectionIndex();
        int row = tabPrevious.getSelectionModel().getMaxSelectionIndex();
        long noEvent=(long) tabPrevious.getModel().getValueAt(row, colunm);
        System.out.println(tabPrevious.getModel().getValueAt(row, colunm));
        jFDeclaration.setVisible(true);
        Calendar birth = Calendar.getInstance();
        //Recherche la déclaration par sont numéro d'evenement
        for(Declaration d:folderUse.getEpisodes()){
            if (d.getNoEven()==noEvent) {
                    
                    txtDeclarant.setText(d.getDeclarant());
                    txtNomPatient.setText(d.getNomPatient());
                    DateToCalendarD(birth,d.getDateDeNaissance(), jDateBirthDe);
                    txtDeTel.setText(d.getTel());
                    txtDeAdresse.setText(d.getAdresse().toString());
                    txtNumASsM.setText(d.getNumAssMAl());
                    txtDrDemandeur.setText(d.getNomDr());
                    txtNomDemande.setText(d.getNomDemande());
                    txtPermis.setText(d.getPermis());
                    txtMilieuConsult.setText(d.getMilieuDeConsultation());
                    txtAdresseDr.setText(d.getAdresseDuDemandeur());
                    txtSitePre.setText(d.getSiteDePre());
                    jCBStatus.setSelectedItem(d.getStatus());
                    DateToCalendarD(birth,d.getDateDePre(), JDatePre);
                if (d.getDateExecution()==null) {
                    jDateExe.setCalendar(null);
                }else
                   DateToCalendarD(birth,d.getDateExecution(), jDateExe);
                    txtTypePre.setText(d.getTypeDePre());
                    txtAnalyse.setText(d.getAnalyse());
                    txtResultat.setText(d.getResultat());
                    
                    //Empêchement de edit le contenue
                    txtDeclarant.setEnabled(false);
                    txtNomPatient.setEnabled(false);
                    jDateBirthDe.setEnabled(false);//change for jdate
                    txtDeTel.setEnabled(false);
                    txtDeAdresse.setEnabled(false);
                    txtNumASsM.setEnabled(false);
                    txtDrDemandeur.setEnabled(false);
                    txtNomDemande.setEnabled(false);
                    txtPermis.setEnabled(false);
                    txtMilieuConsult.setEnabled(false);
                    txtAdresseDr.setEnabled(false);
                    txtSitePre.setEnabled(false);
                    jCBStatus.setEnabled(false);
                    JDatePre.setEnabled(false);//change jdate
                    jDateExe.setEnabled(false);//change jdate
                    txtTypePre.setEnabled(false);
                    txtAnalyse.setEnabled(false);
                    txtResultat.setEnabled(false);
                    btnSaveDec.setEnabled(false);
                    
                
            }
        }
        
        
        
    }//GEN-LAST:event_btnConsultActionPerformed

    private void btnTelechargerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelechargerActionPerformed
        ChooserDeclaration = new JFileChooser(FileSystemView.getFileSystemView());
        ChooserDeclaration.setVisible(true);
        ChooserDeclaration.setFocusable(true);
        
        //Retirer l'option de selection de tout type de fichier
        ChooserDeclaration.setAcceptAllFileFilterUsed(false);
        

        //Spécification des types d ewdossiers acceptable
        FileNameExtensionFilter restrictTxt = new FileNameExtensionFilter("Only .txt files", "txt");
        FileNameExtensionFilter restrictBin = new FileNameExtensionFilter("Only .bin files", "bin");
        ChooserDeclaration.addChoosableFileFilter(restrictTxt);
        ChooserDeclaration.addChoosableFileFilter(restrictBin);
        int r =ChooserDeclaration.showSaveDialog(null);
        
        if (r == JFileChooser.APPROVE_OPTION) {
            File f = ChooserDeclaration.getSelectedFile().getAbsoluteFile();
            try {
                ManipFichier.lectureDeclaration(f,folds);
            } catch (NotUpdateYetExecption ex) {
                //Logger.getLogger(PaneAcceuil.class.getName()).log(Level.SEVERE, null, ex);
                 txtAeraError.setText(ex.getMessage());
                DialogErreur.setVisible(true);
                DialogErreur.isFocusableWindow();
            }
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

    private void btnSaveNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveNFActionPerformed
        CreateNewFolder();
               
    }//GEN-LAST:event_btnSaveNFActionPerformed


    private void btnCancelNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelNFActionPerformed
        jFNewFolder.dispose();
    }//GEN-LAST:event_btnCancelNFActionPerformed

    private void btnNewFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewFolderActionPerformed
        jFNewFolder.setVisible(true);     
    }//GEN-LAST:event_btnNewFolderActionPerformed

    private void txtAnalyseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnalyseKeyPressed
       if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
             CreateNewDeclaration();
            
            
        }
    }//GEN-LAST:event_txtAnalyseKeyPressed

    private void txtEmailPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailPKeyPressed
       if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
             
            CreateNewFolder();
            
        }
    }//GEN-LAST:event_txtEmailPKeyPressed
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBSexPatient;
    private javax.swing.JFileChooser ChooserDeclaration;
    private javax.swing.JDialog DialogErreur;
    private com.toedter.calendar.JDateChooser JDatePre;
    private javax.swing.JTextArea TxtAeraNote;
    private javax.swing.JButton btnAddDec;
    private javax.swing.JButton btnCancelDec;
    private javax.swing.JButton btnCancelNF;
    private javax.swing.JButton btnConsult;
    private javax.swing.JButton btnConsulter;
    private javax.swing.JButton btnDeconnecter;
    private javax.swing.JButton btnEnregistrer;
    private javax.swing.JButton btnFermer;
    private javax.swing.JButton btnModifier;
    private javax.swing.JButton btnNewFolder;
    private javax.swing.JButton btnSaveDec;
    private javax.swing.JButton btnSaveNF;
    private javax.swing.JButton btnTelecharger;
    private javax.swing.JInternalFrame internalHall;
    private javax.swing.JComboBox<String> jCBStatus;
    private javax.swing.JComboBox<String> jComboSexe;
    private com.toedter.calendar.JDateChooser jDateBirthDe;
    private com.toedter.calendar.JDateChooser jDateBirthTab;
    private com.toedter.calendar.JDateChooser jDateCBirth;
    private com.toedter.calendar.JDateChooser jDateExe;
    private javax.swing.JFrame jFDeclaration;
    private javax.swing.JFrame jFNewFolder;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jListDossiers;
    private javax.swing.JPanel jPBottomDe;
    private javax.swing.JPanel jPCenterError;
    private javax.swing.JPanel jPTFoldUP;
    private javax.swing.JPanel jPUpDe;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelCenter;
    private javax.swing.JPanel jPanelTop;
    private javax.swing.JScrollPane jSCDeclaration;
    private javax.swing.JScrollPane jSPList;
    private javax.swing.JScrollPane jScrollError;
    private javax.swing.JScrollPane jScrollPAcceuil;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabPAcceuil;
    protected javax.swing.JLabel jlblAccount;
    private javax.swing.JPanel jpBottom;
    private javax.swing.JPanel jpCenter;
    private javax.swing.JPanel jpDeclaration;
    private javax.swing.JPanel jpDossier;
    private javax.swing.JPanel jpFolder;
    private javax.swing.JPanel jpUp;
    private javax.swing.JLabel lblAdresse;
    private javax.swing.JLabel lblAdresseDr;
    private javax.swing.JLabel lblAnalyse;
    private javax.swing.JLabel lblApp;
    private javax.swing.JLabel lblBirthDate;
    private javax.swing.JLabel lblBirthDateP;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblCountry;
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
    private javax.swing.JLabel lblEmailPatient;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblMilieuConsult;
    private javax.swing.JLabel lblNAM;
    private javax.swing.JLabel lblNamePatient;
    private javax.swing.JLabel lblNamePatientDe;
    private javax.swing.JLabel lblNomDemande;
    private javax.swing.JLabel lblNumCivil;
    private javax.swing.JLabel lblOtherName;
    private javax.swing.JLabel lblPermis;
    private javax.swing.JLabel lblPreviousEpisodes;
    private javax.swing.JLabel lblRAMQPatient;
    private javax.swing.JLabel lblRegion;
    private javax.swing.JLabel lblRegionPatient;
    private javax.swing.JLabel lblResultat;
    private javax.swing.JLabel lblSexe;
    private javax.swing.JLabel lblSexeP;
    private javax.swing.JLabel lblSitePre;
    private javax.swing.JLabel lblSt;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTypePre;
    private javax.swing.JLabel lblZIP;
    private javax.swing.JLabel lblbFirstNamePatient;
    private javax.swing.JTable tabPrevious;
    private javax.swing.JFormattedTextField txtAdresseDr;
    private javax.swing.JTextArea txtAeraError;
    private javax.swing.JFormattedTextField txtAnalyse;
    private javax.swing.JTextField txtAppP;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtDAdresse;
    private javax.swing.JTextField txtDCourriel;
    protected javax.swing.JTextField txtDMiddleName;
    protected javax.swing.JTextField txtDNom;
    protected javax.swing.JTextField txtDPrenom;
    private javax.swing.JTextField txtDREgion;
    private javax.swing.JFormattedTextField txtDeAdresse;
    private javax.swing.JFormattedTextField txtDeTel;
    private javax.swing.JFormattedTextField txtDeclarant;
    private javax.swing.JFormattedTextField txtDrDemandeur;
    private javax.swing.JTextField txtEmailP;
    private javax.swing.JTextField txtFirstNamePatient;
    private javax.swing.JFormattedTextField txtMilieuConsult;
    private javax.swing.JTextField txtNamePatient;
    private javax.swing.JFormattedTextField txtNomDemande;
    private javax.swing.JFormattedTextField txtNomPatient;
    private javax.swing.JFormattedTextField txtNumASsM;
    private javax.swing.JTextField txtNumCP;
    private javax.swing.JTextField txtNumFolder;
    private javax.swing.JTextField txtOtherNameP;
    private javax.swing.JFormattedTextField txtPermis;
    private javax.swing.JTextField txtRAMQP;
    private javax.swing.JTextField txtRegionP;
    private javax.swing.JFormattedTextField txtResultat;
    private javax.swing.JFormattedTextField txtSitePre;
    private javax.swing.JTextField txtSt;
    private javax.swing.JTextField txtState;
    private javax.swing.JFormattedTextField txtTypePre;
    private javax.swing.JTextField txtZIP;
    // End of variables declaration//GEN-END:variables

    
    /**
     * Création de déclaration
     */
    private void CreateNewDeclaration() {
        try {
            Declaration NouvelleDeclaration = getNewEpisode();
            folderUse.addNewEpisode(NouvelleDeclaration);
            jFDeclaration.setVisible(false);
            fullTable(tabPrevious,folderUse.getEpisodes());
            
            //to be continue..
        } catch (ParseException ex) {
            Logger.getLogger(PaneAcceuil.class.getName()).log(Level.SEVERE, null, ex);
        }catch (NumberFormatException|NullPointerException e) {
                    txtAeraError.setText("Tout les champs sont obligatoire!!");
                    DialogErreur.setVisible(true);
                    DialogErreur.isFocusableWindow();
                }
    }

    /**
     * Création de Folder
     */
    private void CreateNewFolder() {
        try {
        //ctor the address
        int num = Integer.parseInt(txtNumCP.getText());
        String appart = txtAppP.getText();
        String street = txtSt.getText();
        String city = txtCity.getText();
        String state = txtState.getText();
        String country = txtCountry.getText();
        String zip = txtZIP.getText();
        Adresse adresse = new Adresse(num, street, appart, zip, city, state, country);

        //create the new folder/Patient
        int numF = Integer.parseInt(txtNumFolder.getText());
        String name = txtNamePatient.getText();
        String firstName = txtFirstNamePatient.getText();
        String region = txtRegionP.getText();
        String sexe = jComboSexe.getItemAt(jComboSexe.getSelectedIndex());
        String ramq = txtRAMQP.getText();
        String otherName = txtOtherNameP.getText();
        String email = txtEmailP.getText();
        Date birthDate = jDateCBirth.getCalendar().getTime();
        System.out.println("Test getDate"+ jDateCBirth.getDate());
        System.out.println("Test getCalendar().getTime()"+ birthDate);
        //ctor
        Patient p = new Patient(numF, name, firstName, region, sexe, ramq, otherName, email, birthDate, adresse);
        //new folder
        Folder f = new Folder(numF + 2020, p, new Episode());
        folds.addFolder(f);

        jFNewFolder.dispose();

        UpdateDatas();
                } catch (NumberFormatException|NullPointerException e) {
                    txtAeraError.setText("Tout les champs sont obligatoire!!");
                    DialogErreur.setVisible(true);
                    DialogErreur.isFocusableWindow();
                }
    }

    /**
     * Essaie pour si la désiralization prend trop de temps.
     */
    final SwingWorker<Folder, Folder> consulteur;
    private void clean(){
    txtDPrenom.setText("");
        txtDNom.setText("");
        txtDMiddleName.setText("");
        jDateBirthTab.setDate(null);
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
        //Changement pour jDaTE
        Calendar birth = Calendar.getInstance();
        DateToCalendarF(birth, f,jDateBirthTab);
        jComboSexe.setSelectedItem(f.getPatient().getSexe());
        txtDREgion.setText(f.getPatient().getRegion());
        txtDAdresse.setText(f.getPatient().getAdresse().toString());
        txtDCourriel.setText(f.getPatient().getEmail());
        fullTable(tabPrevious,f.getEpisodes());
    }

    /**
     * 
     * @param birth
     * @param f
     * @param jD 
     */
    private void DateToCalendarF(Calendar birth,Folder f,JDateChooser jD) {
        
        System.out.println(f.getPatient().getDateDeNaissance());
        birth.setTime(f.getPatient().getDateDeNaissance());
        System.out.println("Test de sorti \n : "+f.getPatient().getDateDeNaissance().getYear()+" "+ f.getPatient().getDateDeNaissance().getMonth()+" "+ f.getPatient().getDateDeNaissance().getDay());
        jD.setCalendar(birth);//probleme d''affichage de la date en format DD-MM-YYYY//regler 02:23AM 2020-09-29
    }
    /**
     * 
     * @param calendar
     * @param d
     * @param jD 
     */
     private void DateToCalendarD(Calendar calendar,Date d, JDateChooser jD) {
        
        calendar.setTime(d);
        
        jD.setCalendar(calendar);//probleme d''affichage 

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
 * @throws ParseException :Exeeption pour la fonction de parse
 * 
 */
    protected Declaration getNewEpisode() throws ParseException {
        Declaration NouvelleDeclaration = new Declaration();
        NouvelleDeclaration.setDeclarant(txtDeclarant.getText());
        NouvelleDeclaration.setNomPatient(txtNomPatient.getText());
        NouvelleDeclaration.setDateDeNaissance(jDateBirthDe.getDate());
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
        NouvelleDeclaration.setDateDePre(JDatePre.getDate());
        NouvelleDeclaration.setDateExecution(jDateExe.getDate());
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
