package projetM2L;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Fenetre extends JFrame implements ActionListener {
 private JButton bouton = new JButton("Pret");
 private JButton bouton2 = new JButton("retour");
 private JPanel container = new JPanel();
 private JLabel label = new JLabel("Materiel");
 private JComboBox combo = new JComboBox();
 private JTextField prenom = new JTextField("prenom");
 private JTextField nom = new JTextField("nom");

 public Fenetre() {
  this.setTitle("GestionPret");
  this.setSize(400, 300);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setLocationRelativeTo(null);
  // On définit le layout à utiliser sur le content pane
  this.setLayout(new BorderLayout());
  // On ajoute le bouton au content pane de la JFrame
  // Au sud
  // this.getContentPane().add(new JButton("Pret"), BorderLayout.SOUTH);
  container.setBackground(Color.white);
  container.setLayout(new BorderLayout());
  combo.setPreferredSize(new Dimension(100, 20));
  /*
   * Création de l'objet gérant les requêtes Connection cn = null;
   * Statement statement; ResultSet option1; try { statement =
   * cn.createStatement(); option1 = statement.executeQuery(
   * "SELECT nom_mat FROM materiel where id_mat = 1;" );
   * combo.addItem(option1); } catch (SQLException e) { // TODO
   * Auto-generated catch block e.printStackTrace(); }
   */
  combo.addItem("Imprimante");
  combo.addItem("Videoprojecteur");
  combo.addItem("Photocopieuse");
  combo.addItem("Ordinateur");
  // Ajout du listener
  combo.addItemListener(new ItemState());
  // combo.addActionListener(new BoutonListener());
  // combo.addActionListener(new Bouton2Listener());
  // Ce sont maintenant nos classes internes qui écoutent nos boutons
  bouton.addActionListener(new BoutonListener());
  bouton2.addActionListener(new Bouton2Listener());
  JPanel south = new JPanel();
  south.add(bouton);
  south.add(bouton2);
  container.add(south, BorderLayout.SOUTH);
  // Définition d'une police d'écriture
  Font police = new Font("Tahoma", Font.BOLD, 12);
  // On l'applique au JLabel
  label.setFont(police);
  // Changement de la couleur du texte
  label.setForeground(Color.blue);
  // On modifie l'alignement du texte grâce aux attributs statiques
  // de la classe JLabel
  JPanel top = new JPanel();
  top.add(label);
  top.add(combo);
  container.add(top, BorderLayout.NORTH);
  this.setContentPane(container);
  nom.setFont(police);
     nom.setPreferredSize(new Dimension(150, 30));
     nom.setForeground(Color.BLUE);
     prenom.setFont(police);
     prenom.setPreferredSize(new Dimension(150, 30));
     prenom.setForeground(Color.BLUE);
     JPanel mid = new JPanel();
     mid.add(nom);
     mid.add(prenom);
     container.add(mid, BorderLayout.CENTER);
  this.setVisible(true);
 }

 @Override
 public void actionPerformed(ActionEvent e) {
  // TODO Auto-generated method stub

 }

 // Classe écoutant notre premier bouton
 class BoutonListener implements ActionListener 
 {
  // Redéfinition de la méthode actionPerformed()
  public void actionPerformed(ActionEvent arg0) 
  {
   if (combo.getSelectedItem().equals("Imprimante")) 
   {
	   if (GestionPret.VerifQuantite(1) == 0)
	   {
		   JFrame fenetreB = new FenetreB("Nous n'avons plus d'imprimante !"); 
	   }
	   else
	   {
          GestionPret.Pret(1);
          Connexion.sauverEnBase(nom.getText(),prenom.getText());
          JFrame fenetreB = new FenetreB("Merci d'avoir effectué votre pret pour une imprimante");
	   }
   } 
   else if (combo.getSelectedItem().equals("Videoprojecteur")) 
   {
	   if (GestionPret.VerifQuantite(2) == 0)
	   {
		   JFrame fenetreB = new FenetreB("Nous n'avons plus de videoprojecteur !"); 
	   }
	   else
	   {
          GestionPret.Pret(2);
          Connexion.sauverEnBase(nom.getText(),prenom.getText());
          JFrame fenetreB = new FenetreB("Merci d'avoir effectué votre pret pour un videoprojecteur");
	   }
   }
   else if (combo.getSelectedItem().equals("Photocopieuse")) 
   {
	   if (GestionPret.VerifQuantite(3) == 0)
	   {
		   JFrame fenetreB = new FenetreB("Nous n'avons plus de photocopieuse !"); 
	   }
	   else
	   {
          GestionPret.Pret(3);
          Connexion.sauverEnBase(nom.getText(),prenom.getText());
          JFrame fenetreB = new FenetreB("Merci d'avoir effectué votre pret pour une photocopieuse");
	   }
   }
   else if (combo.getSelectedItem().equals("Ordinateur")) 
   {
	   if (GestionPret.VerifQuantite(4) == 0)
	   {
		   JFrame fenetreB = new FenetreB("Nous n'avons plus d'ordinateur !"); 
	   }
	   else
	   {
          GestionPret.Pret(4);
          Connexion.sauverEnBase(nom.getText(),prenom.getText());
          JFrame fenetreB = new FenetreB("Merci d'avoir effectué votre pret pour un ordinateur");
	   }
   }
  }
 }

 // Classe écoutant notre second bouton
 class Bouton2Listener implements ActionListener 
 {
  // Redéfinition de la méthode actionPerformed()
  public void actionPerformed(ActionEvent e) 
  {
   if (combo.getSelectedItem().equals("Imprimante")) 
   {
	   if (GestionPret.VerifQuantite(1) == 10)
	   {
		    JFrame fenetreB = new FenetreB("Vous n'avez rien emprunté !");
	   }
	   else
	   {
		    GestionPret.Retour(1);
		    JFrame fenetreB = new FenetreB("Merci de ce retour");   
	   }
   } 
   else if (combo.getSelectedItem().equals("Videoprojecteur")) 
   {
	   if (GestionPret.VerifQuantite(2) == 10)
	   {
		    JFrame fenetreB = new FenetreB("Vous n'avez rien emprunté !");
	   }
	   else
	   {
		    GestionPret.Retour(2);
		    JFrame fenetreB = new FenetreB("Merci de ce retour");   
	   }
   }
   else if (combo.getSelectedItem().equals("Photocopieuse")) 
   {
	   if (GestionPret.VerifQuantite(3) == 10)
	   {
		    JFrame fenetreB = new FenetreB("Vous n'avez rien emprunté !");
	   }
	   else
	   {
		    GestionPret.Retour(3);
		    JFrame fenetreB = new FenetreB("Merci de ce retour");   
	   }
   }
   else if (combo.getSelectedItem().equals("Ordinateur")) 
   {
	   if (GestionPret.VerifQuantite(4) == 10)
	   {
		    JFrame fenetreB = new FenetreB("Vous n'avez rien emprunté !");
	   }
	   else
	   {
		    GestionPret.Retour(4);
		    JFrame fenetreB = new FenetreB("Merci de ce retour");   
	   }
   }
  }
 }

 class ItemState implements ItemListener {
  public void itemStateChanged(ItemEvent e) {
   e.getItem();
  }
 }
 /*
  * class ItemAction implements ActionListener{ public void
  * actionPerformed(ActionEvent e) {
  * System.out.println(combo.getSelectedItem()); } }
  */
}