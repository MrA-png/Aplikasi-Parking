/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_parkir1;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;


/**
 *
 * @author Luxtrada R
 */
public class menu extends javax.swing.JFrame {

    /**
     * Creates new form menu
     */
    public menu() {
        initComponents();
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
        int x = layar.width / 2 - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;     
        this.setLocation(x, y);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPetugas = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jJurusan = new javax.swing.JLabel();
        jKendaraan = new javax.swing.JLabel();
        jMerk = new javax.swing.JLabel();
        jKelas = new javax.swing.JLabel();
        jSiswa = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setLayout(null);

        jPetugas.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luxtrada R\\Documents\\NetBeansProjects\\project_parkir1\\src\\project_parkir1\\images\\petugas1.png")); // NOI18N
        jPetugas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPetugasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPetugasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPetugasMouseExited(evt);
            }
        });
        jPanel2.add(jPetugas);
        jPetugas.setBounds(40, 0, 90, 40);

        close.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luxtrada R\\Documents\\NetBeansProjects\\project_parkir1\\src\\project_parkir1\\images\\close1.png")); // NOI18N
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeMouseExited(evt);
            }
        });
        jPanel2.add(close);
        close.setBounds(1280, 0, 60, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luxtrada R\\Documents\\NetBeansProjects\\project_parkir1\\src\\project_parkir1\\images\\logo-stm2.png")); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(-10, 0, 880, 620);

        jJurusan.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luxtrada R\\Documents\\NetBeansProjects\\project_parkir1\\src\\project_parkir1\\images\\jurusan1.png")); // NOI18N
        jJurusan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jJurusanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jJurusanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jJurusanMouseExited(evt);
            }
        });
        jPanel2.add(jJurusan);
        jJurusan.setBounds(220, 0, 90, 40);

        jKendaraan.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luxtrada R\\Documents\\NetBeansProjects\\project_parkir1\\src\\project_parkir1\\images\\kendaraan1.png")); // NOI18N
        jKendaraan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jKendaraanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jKendaraanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jKendaraanMouseExited(evt);
            }
        });
        jPanel2.add(jKendaraan);
        jKendaraan.setBounds(310, 0, 120, 40);

        jMerk.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luxtrada R\\Documents\\NetBeansProjects\\project_parkir1\\src\\project_parkir1\\images\\merk1.png")); // NOI18N
        jMerk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMerkMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMerkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMerkMouseExited(evt);
            }
        });
        jPanel2.add(jMerk);
        jMerk.setBounds(430, 0, 90, 40);

        jKelas.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luxtrada R\\Documents\\NetBeansProjects\\project_parkir1\\src\\project_parkir1\\images\\kelas1.png")); // NOI18N
        jKelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jKelasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jKelasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jKelasMouseExited(evt);
            }
        });
        jPanel2.add(jKelas);
        jKelas.setBounds(130, 0, 110, 40);

        jSiswa.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luxtrada R\\Documents\\NetBeansProjects\\project_parkir1\\src\\project_parkir1\\images\\siswa1.png")); // NOI18N
        jSiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSiswaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jSiswaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jSiswaMouseExited(evt);
            }
        });
        jPanel2.add(jSiswa);
        jSiswa.setBounds(520, 0, 90, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luxtrada R\\Documents\\NetBeansProjects\\project_parkir1\\src\\project_parkir1\\images\\bgDaata.png")); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, -10, 1370, 650);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSiswaMouseClicked
        siswa sis = new siswa();
        sis.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_jSiswaMouseClicked

    private void jSiswaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSiswaMouseEntered
        ImageIcon A = new ImageIcon(getClass().getResource("images/siswa.png"));
        jSiswa.setIcon(A);
// TODO add your handling code here:
    }//GEN-LAST:event_jSiswaMouseEntered

    private void jSiswaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSiswaMouseExited
        ImageIcon B = new ImageIcon(getClass().getResource("images/siswa1.png"));
        jSiswa.setIcon(B);
// TODO add your handling code here:
    }//GEN-LAST:event_jSiswaMouseExited

    private void jKelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jKelasMouseClicked
        Kelas kelas = new Kelas();
        kelas.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jKelasMouseClicked

    private void jKelasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jKelasMouseEntered
        ImageIcon A = new ImageIcon(getClass().getResource("images/kelas.png"));
        jKelas.setIcon(A);
        // TODO add your handling code here:
    }//GEN-LAST:event_jKelasMouseEntered

    private void jKelasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jKelasMouseExited
        ImageIcon B = new ImageIcon(getClass().getResource("images/kelas1.png"));
        jKelas.setIcon(B);
// TODO add your handling code here:
    }//GEN-LAST:event_jKelasMouseExited

    private void jJurusanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jJurusanMouseEntered
        ImageIcon A = new ImageIcon(getClass().getResource("images/jurusan.png"));
        jJurusan.setIcon(A);
        // TODO add your handling code here:
    }//GEN-LAST:event_jJurusanMouseEntered

    private void jJurusanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jJurusanMouseExited
        ImageIcon B = new ImageIcon(getClass().getResource("images/jurusan1.png"));
        jJurusan.setIcon(B);
// TODO add your handling code here:
    }//GEN-LAST:event_jJurusanMouseExited

    private void jKendaraanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jKendaraanMouseEntered
        ImageIcon A = new ImageIcon(getClass().getResource("images/kendaraan.png"));
        jKendaraan.setIcon(A);
        // TODO add your handling code here:
    }//GEN-LAST:event_jKendaraanMouseEntered

    private void jKendaraanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jKendaraanMouseExited
        ImageIcon B = new ImageIcon(getClass().getResource("images/kendaraan1.png"));
        jKendaraan.setIcon(B);
// TODO add your handling code here:
    }//GEN-LAST:event_jKendaraanMouseExited

    private void jMerkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMerkMouseEntered
        ImageIcon  A = new ImageIcon(getClass().getResource("images/merk.png"));
        jMerk.setIcon(A);
// TODO add your handling code here:
    }//GEN-LAST:event_jMerkMouseEntered

    private void jMerkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMerkMouseExited
        ImageIcon B = new ImageIcon(getClass().getResource("images/merk1.png"));
        jMerk.setIcon(B);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMerkMouseExited

    private void jMerkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMerkMouseClicked
        merk mrk = new merk();
        mrk.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_jMerkMouseClicked

    private void jJurusanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jJurusanMouseClicked
        jurusan jurusan = new jurusan();
        jurusan.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jJurusanMouseClicked

    private void jKendaraanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jKendaraanMouseClicked
        kendaraan kendaraan = new kendaraan();
        kendaraan.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jKendaraanMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_closeMouseClicked

    private void closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseEntered
        ImageIcon A = new ImageIcon(getClass().getResource("Images/close.png"));
        close.setIcon(A);
        // TODO add your handling code here:
    }//GEN-LAST:event_closeMouseEntered

    private void closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseExited
        ImageIcon B = new ImageIcon(getClass().getResource("Images/close1.png"));
        close.setIcon(B);
        // TODO add your handling code here:
    }//GEN-LAST:event_closeMouseExited

    private void jPetugasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPetugasMouseClicked
        petugas petugas = new petugas();
        petugas.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jPetugasMouseClicked

    private void jPetugasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPetugasMouseEntered
        ImageIcon A = new ImageIcon (getClass().getResource("Images/petugas.png"));
        jPetugas.setIcon(A);
// TODO add your handling code here:
    }//GEN-LAST:event_jPetugasMouseEntered

    private void jPetugasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPetugasMouseExited
        ImageIcon B = new ImageIcon (getClass().getResource("Images/petugas1.png"));
        jPetugas.setIcon(B);
        // TODO add your handling code here:
    }//GEN-LAST:event_jPetugasMouseExited

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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel close;
    private javax.swing.JLabel jJurusan;
    private javax.swing.JLabel jKelas;
    private javax.swing.JLabel jKendaraan;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jMerk;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jPetugas;
    private javax.swing.JLabel jSiswa;
    // End of variables declaration//GEN-END:variables
}
