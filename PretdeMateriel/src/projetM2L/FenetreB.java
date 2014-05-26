package projetM2L;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetreB extends JFrame {
 private JLabel label2 = new JLabel("");
 private JPanel container = new JPanel();

 public FenetreB(String nb) {
  this.setTitle("GestionPret");
  this.setSize(600, 80);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setLocationRelativeTo(null);
  this.setVisible(true);
  label2.setText(nb);
  Font police = new Font("Tahoma", Font.BOLD, 16);
  label2.setFont(police);
  JPanel top = new JPanel();
  top.add(label2);
  container.add(top, BorderLayout.CENTER);
  this.setContentPane(container);
 }

}