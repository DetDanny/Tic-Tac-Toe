/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tic.tac.toe;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author daniel
 */
public class gui extends javax.swing.JFrame {

    private String currentPlayer = "X";
    private String lastWinner = "";
    private int playerXScore = 0;
    private int playerOScore = 0;

    /**
     * Creates new form gui
     */
    public gui() {
        initComponents();

        buttonTic1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        buttonTic1.setBackground(new Color(230, 230, 230));
        buttonTic1.setContentAreaFilled(false);
        buttonTic1.setOpaque(true);
        
        buttonTic2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        buttonTic2.setBackground(new Color(230, 230, 230));
        buttonTic2.setContentAreaFilled(false);
        buttonTic2.setOpaque(true);
        
        buttonTic3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        buttonTic3.setBackground(new Color(230, 230, 230));
        buttonTic3.setContentAreaFilled(false);
        buttonTic3.setOpaque(true);
        
        buttonTic4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        buttonTic4.setBackground(new Color(230, 230, 230));
        buttonTic4.setContentAreaFilled(false);
        buttonTic4.setOpaque(true);
        
        buttonTic5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        buttonTic5.setBackground(new Color(230, 230, 230));
        buttonTic5.setContentAreaFilled(false);
        buttonTic5.setOpaque(true);
        
        buttonTic6.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        buttonTic6.setBackground(new Color(230, 230, 230));
        buttonTic6.setContentAreaFilled(false);
        buttonTic6.setOpaque(true);
        
        buttonTic7.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        buttonTic7.setBackground(new Color(230, 230, 230));
        buttonTic7.setContentAreaFilled(false);
        buttonTic7.setOpaque(true);
        
        buttonTic8.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        buttonTic8.setBackground(new Color(230, 230, 230));
        buttonTic8.setContentAreaFilled(false);
        buttonTic8.setOpaque(true);
        
        buttonTic9.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        buttonTic9.setBackground(new Color(230, 230, 230));
        buttonTic9.setContentAreaFilled(false);
        buttonTic9.setOpaque(true);
        
        buttonNewGame.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        buttonNewGame.setBackground(new Color(230, 230, 230));
        buttonNewGame.setContentAreaFilled(false);
        buttonNewGame.setOpaque(true);
        
        buttonReset.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        buttonReset.setBackground(new Color(230, 230, 230));
        buttonReset.setContentAreaFilled(false);
        buttonReset.setOpaque(true);
        
        buttonExit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        buttonExit.setBackground(new Color(230, 230, 230));
        buttonExit.setContentAreaFilled(false);
        buttonExit.setOpaque(true);
        
        buttonNewGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonNewGame.setBackground(new Color(210, 210, 210));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonNewGame.setBackground(new Color(230, 230, 230));
            }
        });
        
        buttonReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonReset.setBackground(new Color(210, 210, 210));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonReset.setBackground(new Color(230, 230, 230));
            }
        });
        
        buttonExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonExit.setBackground(new Color(210, 210, 210));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonExit.setBackground(new Color(230, 230, 230));
            }
        });
        
    }
    

    private void switchPlayer() {
        if (currentPlayer.equals("X")) {
            currentPlayer = "O";
        } else {
            currentPlayer = "X";
        }
    }

    private void disableAllButtons() {
        buttonTic1.setEnabled(false);
        buttonTic2.setEnabled(false);
        buttonTic3.setEnabled(false);
        buttonTic4.setEnabled(false);
        buttonTic5.setEnabled(false);
        buttonTic6.setEnabled(false);
        buttonTic7.setEnabled(false);
        buttonTic8.setEnabled(false);
        buttonTic9.setEnabled(false);
    }

    private void buttonClicked(javax.swing.JButton button) {
        if (button.getText().equals("")) {
            button.setText(currentPlayer);
            button.setEnabled(false);

            // Überprüfen, ob es einen Gewinner gibt
            if (checkWin()) {
                lastWinner = currentPlayer;

                // Punktestand aktualisieren
                if (currentPlayer.equals("X")) {
                    playerXScore++;
                    labelPointsPlayerX.setText(String.valueOf(playerXScore));
                } else {
                    playerOScore++;
                    labelPointsPlayerO.setText(String.valueOf(playerOScore));
                }

                // Benachrichtigung anzeigen, dass jemand gewonnen hat
                labelMessage.setText("Spieler " + currentPlayer + " hat gewonnen!");

                // Alle Schaltflächen deaktivieren
                disableAllButtons();
            } else if (isBoardFull()) {
                labelMessage.setText("Unentschieden!");
            } else {
                switchPlayer();
                labelMessage.setText("Spieler " + currentPlayer + " ist an der Reihe.");
            }
        }
    }

    private boolean checkWin() {
        // Überprüfung der horizontalen Linien
        if (checkLine(buttonTic1, buttonTic2, buttonTic3)) {
            return true;
        }
        if (checkLine(buttonTic4, buttonTic5, buttonTic6)) {
            return true;
        }
        if (checkLine(buttonTic7, buttonTic8, buttonTic9)) {
            return true;
        }

        // Überprüfung der vertikalen Linien
        if (checkLine(buttonTic1, buttonTic4, buttonTic7)) {
            return true;
        }
        if (checkLine(buttonTic2, buttonTic5, buttonTic8)) {
            return true;
        }
        if (checkLine(buttonTic3, buttonTic6, buttonTic9)) {
            return true;
        }

        // Überprüfung der diagonalen Linien
        if (checkLine(buttonTic1, buttonTic5, buttonTic9)) {
            return true;
        }
        if (checkLine(buttonTic3, buttonTic5, buttonTic7)) {
            return true;
        }

        return false;
    }

    private boolean checkLine(javax.swing.JButton b1, javax.swing.JButton b2, javax.swing.JButton b3) {
        if (!b1.getText().equals("") && b1.getText().equals(b2.getText()) && b2.getText().equals(b3.getText())) {
            b1.setBackground(new Color(0, 210, 0));
            b2.setBackground(new Color(0, 210, 0));
            b3.setBackground(new Color(0, 210, 0));
            return true;
        }
        return false;
    }

    private boolean isBoardFull() {
        return !buttonTic1.getText().equals("") && !buttonTic2.getText().equals("")
                && !buttonTic3.getText().equals("") && !buttonTic4.getText().equals("")
                && !buttonTic5.getText().equals("") && !buttonTic6.getText().equals("")
                && !buttonTic7.getText().equals("") && !buttonTic8.getText().equals("")
                && !buttonTic9.getText().equals("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buttonTic3 = new javax.swing.JButton();
        buttonTic1 = new javax.swing.JButton();
        buttonTic2 = new javax.swing.JButton();
        buttonTic6 = new javax.swing.JButton();
        buttonTic4 = new javax.swing.JButton();
        buttonTic5 = new javax.swing.JButton();
        buttonTic9 = new javax.swing.JButton();
        buttonTic7 = new javax.swing.JButton();
        buttonTic8 = new javax.swing.JButton();
        buttonNewGame = new javax.swing.JButton();
        buttonReset = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        labelTextPlayerX = new javax.swing.JLabel();
        labelTextPlayerO = new javax.swing.JLabel();
        labelPointsPlayerX = new javax.swing.JLabel();
        labelPointsPlayerO = new javax.swing.JLabel();
        labelMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tic Tac Toe");

        buttonTic3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        buttonTic3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTic3(evt);
            }
        });

        buttonTic1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        buttonTic1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTic1(evt);
            }
        });

        buttonTic2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        buttonTic2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTic2(evt);
            }
        });

        buttonTic6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        buttonTic6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTic6(evt);
            }
        });

        buttonTic4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        buttonTic4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTic4(evt);
            }
        });

        buttonTic5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        buttonTic5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTic5(evt);
            }
        });

        buttonTic9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        buttonTic9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTic9(evt);
            }
        });

        buttonTic7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        buttonTic7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTic7(evt);
            }
        });

        buttonTic8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        buttonTic8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTic8(evt);
            }
        });

        buttonNewGame.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonNewGame.setText("New Game");
        buttonNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewGame(evt);
            }
        });

        buttonReset.setText("Reset");
        buttonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReset(evt);
            }
        });

        buttonExit.setText("Exit");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExit(evt);
            }
        });

        labelTextPlayerX.setText("Player X:");

        labelTextPlayerO.setText("Player O:");

        labelPointsPlayerX.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelPointsPlayerX.setText("0");

        labelPointsPlayerO.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelPointsPlayerO.setText("0");

        labelMessage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMessage.setText("Spieler X beginnt!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(buttonTic7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(buttonTic8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(buttonTic9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(buttonNewGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(buttonTic1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(buttonTic2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(buttonTic3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(labelPointsPlayerX, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(labelTextPlayerX, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(38, 38, 38)
                                                .addComponent(labelTextPlayerO, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(labelPointsPlayerO, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buttonTic4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonTic5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonTic6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonTic7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonTic8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonTic9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonTic5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonTic6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonTic4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonTic1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonTic2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonTic3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(labelMessage)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelTextPlayerO)
                        .addComponent(labelPointsPlayerO))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelTextPlayerX)
                        .addComponent(labelPointsPlayerX)))
                .addGap(12, 12, 12)
                .addComponent(buttonNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonReset)
                    .addComponent(buttonExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonNewGame(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewGame
        buttonTic1.setEnabled(true);
        buttonTic2.setEnabled(true);
        buttonTic3.setEnabled(true);
        buttonTic4.setEnabled(true);
        buttonTic5.setEnabled(true);
        buttonTic6.setEnabled(true);
        buttonTic7.setEnabled(true);
        buttonTic8.setEnabled(true);
        buttonTic9.setEnabled(true);

        buttonTic1.setText("");
        buttonTic2.setText("");
        buttonTic3.setText("");
        buttonTic4.setText("");
        buttonTic5.setText("");
        buttonTic6.setText("");
        buttonTic7.setText("");
        buttonTic8.setText("");
        buttonTic9.setText("");

        buttonTic1.setBackground(new Color(225, 225, 225));
        buttonTic2.setBackground(new Color(225, 225, 225));
        buttonTic3.setBackground(new Color(225, 225, 225));
        buttonTic4.setBackground(new Color(225, 225, 225));
        buttonTic5.setBackground(new Color(225, 225, 225));
        buttonTic6.setBackground(new Color(225, 225, 225));
        buttonTic7.setBackground(new Color(225, 225, 225));
        buttonTic8.setBackground(new Color(225, 225, 225));
        buttonTic9.setBackground(new Color(225, 225, 225));

        if (lastWinner.equals("X")) {
            currentPlayer = "O";
            labelMessage.setText("Spieler O ist an der Reihe.");
        } else {
            currentPlayer = "X";
            labelMessage.setText("Spieler X ist an der Reihe.");
        }
    }//GEN-LAST:event_buttonNewGame

    private void buttonTic1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTic1
        buttonClicked(buttonTic1);
    }//GEN-LAST:event_buttonTic1

    private void buttonTic2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTic2
        buttonClicked(buttonTic2);
    }//GEN-LAST:event_buttonTic2

    private void buttonTic3(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTic3
        buttonClicked(buttonTic3);
    }//GEN-LAST:event_buttonTic3

    private void buttonTic4(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTic4
        buttonClicked(buttonTic4);
    }//GEN-LAST:event_buttonTic4

    private void buttonTic5(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTic5
        buttonClicked(buttonTic5);
    }//GEN-LAST:event_buttonTic5

    private void buttonTic6(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTic6
        buttonClicked(buttonTic6);
    }//GEN-LAST:event_buttonTic6

    private void buttonTic7(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTic7
        buttonClicked(buttonTic7);
    }//GEN-LAST:event_buttonTic7

    private void buttonTic8(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTic8
        buttonClicked(buttonTic8);
    }//GEN-LAST:event_buttonTic8

    private void buttonTic9(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTic9
        buttonClicked(buttonTic9);
    }//GEN-LAST:event_buttonTic9

    private void buttonReset(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReset
        buttonTic1.setEnabled(true);
        buttonTic2.setEnabled(true);
        buttonTic3.setEnabled(true);
        buttonTic4.setEnabled(true);
        buttonTic5.setEnabled(true);
        buttonTic6.setEnabled(true);
        buttonTic7.setEnabled(true);
        buttonTic8.setEnabled(true);
        buttonTic9.setEnabled(true);

        buttonTic1.setText("");
        buttonTic2.setText("");
        buttonTic3.setText("");
        buttonTic4.setText("");
        buttonTic5.setText("");
        buttonTic6.setText("");
        buttonTic7.setText("");
        buttonTic8.setText("");
        buttonTic9.setText("");

        buttonTic1.setBackground(new Color(225, 225, 225));
        buttonTic2.setBackground(new Color(225, 225, 225));
        buttonTic3.setBackground(new Color(225, 225, 225));
        buttonTic4.setBackground(new Color(225, 225, 225));
        buttonTic5.setBackground(new Color(225, 225, 225));
        buttonTic6.setBackground(new Color(225, 225, 225));
        buttonTic7.setBackground(new Color(225, 225, 225));
        buttonTic8.setBackground(new Color(225, 225, 225));
        buttonTic9.setBackground(new Color(225, 225, 225));

        labelPointsPlayerX.setText("0");
        labelPointsPlayerO.setText("0");
    }//GEN-LAST:event_buttonReset

    private void buttonExit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExit
        int response = JOptionPane.showConfirmDialog(this, "Möchten Sie das Programm wirklich beenden?", "Tic Tac Toe", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_buttonExit

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonNewGame;
    private javax.swing.JButton buttonReset;
    private javax.swing.JButton buttonTic1;
    private javax.swing.JButton buttonTic2;
    private javax.swing.JButton buttonTic3;
    private javax.swing.JButton buttonTic4;
    private javax.swing.JButton buttonTic5;
    private javax.swing.JButton buttonTic6;
    private javax.swing.JButton buttonTic7;
    private javax.swing.JButton buttonTic8;
    private javax.swing.JButton buttonTic9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelMessage;
    private javax.swing.JLabel labelPointsPlayerO;
    private javax.swing.JLabel labelPointsPlayerX;
    private javax.swing.JLabel labelTextPlayerO;
    private javax.swing.JLabel labelTextPlayerX;
    // End of variables declaration//GEN-END:variables

    public class RoundedBorder implements Border {

        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }
}
