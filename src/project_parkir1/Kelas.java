/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_parkir1;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luxtrada R
 */
public class Kelas extends javax.swing.JFrame {
    public static Connection con;
    public static Statement stm;
    public static ResultSet rs;
    
    public Kelas() {
        initComponents();
        koneksi();
        Data();
        IDotomatis();
        
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
        int x = layar.width / 2 - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;     
        this.setLocation(x, y);
    }

    public void koneksi(){
        try{
            String url ="jdbc:mysql://localhost/parking";
            String user="root";
            String pas= "";
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection)DriverManager.getConnection(url,user,pas);
            stm=(Statement)con.createStatement();
        }catch(Exception e){
            System.out.println("koneksi gagal"+e.getMessage());
        }
    }
    
    public void Data(){
        Object header[]={"ID Kelas","Kelas"};
        DefaultTableModel  kelas = new DefaultTableModel(null,header);
        jKelas.setModel(kelas);
        String sql="select * from kelas;";
        try{
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while(rs.next()){
                String k1 = rs.getString(1);
                String k2 = rs.getString(2);
                String k[]={k1,k2};
                kelas.addRow(k);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    private void IDotomatis(){
        try{
            stm=con.createStatement();
            String sql = "select * from kelas order by IDkelas desc";
            rs=stm.executeQuery(sql);
            if(rs.next()){
                String ID = rs.getString("IDkelas").substring(3);
                String NO=""+(Integer.parseInt(ID)+1);
                String No1="";
                
                if(NO.length()==1){
                    No1="00";
                }else if(NO.length()==2){
                    No1="0";
                }else if(NO.length()==3){
                    No1="";
                }
                jId.setText("KEL"+ No1 + NO);  
            }else{
                jId.setText("KEL001");
            }
        }catch(SQLException e ){
            JOptionPane.showMessageDialog(null,"ID otomatis error "+e);
        }
    }
    
    public void Tambah_Data(){
        try{
            stm=con.createStatement();
            String sql = "insert into kelas values('"+jId.getText()+"','"+kelas.getText()+"')";
            stm.execute(sql);
            JOptionPane.showMessageDialog(null,"Data berhasil Dimasukkan");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void hapus(){
        try{
            stm=con.createStatement();
            String sql = "DELETE FROM kelas WHERE IDkelas='"+jId.getText()+"'";
            stm.execute(sql);
            JOptionPane.showMessageDialog(null,"Data berhasil dihapus");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR DIHAPUS "+e);
        }
    }
    
    private void edit(){
        try{
            stm=con.createStatement();
            String sql="update kelas set kelas='"+kelas.getText()+"'where IDkelas='"+jId.getText()+"'";
            stm.execute(sql);
            JOptionPane.showMessageDialog(null,"Data berhasil di edit");
            Data();
            reset_form();
            btnSimpan.setEnabled(true);
        }catch(SQLException e ){
            JOptionPane.showMessageDialog(null,"Data Disimpan\n"+e);
        }
    }
    
    private void reset_form(){
        Data();
        IDotomatis();
//        jId.setText("");
        kelas.setText("");
    }
    
    public void filterhurufbesar(KeyEvent a){
        if(Character.isLowerCase(a.getKeyChar())){
            a.consume();
            JOptionPane.showMessageDialog(null,"Masukkan Hanya Huruf Besar","Informasi",JOptionPane.ERROR_MESSAGE);
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

        jPanel1 = new javax.swing.JPanel();
        close = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jId = new javax.swing.JTextField();
        kelas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnHapus = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jKelas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(null);

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
        jPanel1.add(close);
        close.setBounds(650, 0, 60, 40);

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimpan);
        btnSimpan.setBounds(120, 220, 90, 23);

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tambah Data ");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(70, 80, 110, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Kelas");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 160, 34, 14);

        jId.setEditable(false);
        jPanel1.add(jId);
        jId.setBounds(100, 120, 130, 30);

        kelas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kelasKeyTyped(evt);
            }
        });
        jPanel1.add(kelas);
        kelas.setBounds(100, 160, 130, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID kelas");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 120, 60, 15);

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Data Kelas");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(420, 10, 110, 25);

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnHapus);
        btnHapus.setBounds(80, 260, 80, 23);

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit);
        btnEdit.setBounds(20, 260, 51, 23);

        jKelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jKelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jKelasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jKelas);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(250, 80, 450, 402);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luxtrada R\\Documents\\NetBeansProjects\\project_parkir1\\src\\project_parkir1\\images\\bgDaata.png")); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 80, 230, 210);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luxtrada R\\Documents\\NetBeansProjects\\project_parkir1\\src\\project_parkir1\\images\\bg.png")); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-18, -2, 740, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if(jId.getText().equals("")){
            JOptionPane.showMessageDialog(null,"ID kelas harus diisi","informasi",JOptionPane.ERROR_MESSAGE);
        }else if(kelas.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Kelas harus diisi","informasi",JOptionPane.ERROR_MESSAGE);
        }else{
            int opsi = JOptionPane.showConfirmDialog(null,"simpan data?","Komfirmasi",JOptionPane.YES_NO_OPTION);
            if(opsi == JOptionPane.YES_OPTION){
                Tambah_Data();
                reset_form();
                Data();
                IDotomatis();
            }else{
                JOptionPane.showMessageDialog(null,"Data tidak tersimpan","Informasi",JOptionPane.ERROR_MESSAGE);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int opsi = JOptionPane.showConfirmDialog(null,"Hapus Data ini?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if(opsi == 0){
            hapus();
            reset_form();
            Data();
            btnSimpan.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null,"Pilih data yang akan dihapus");
        }
// TODO add your handling code here:
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int opsi=JOptionPane.showConfirmDialog(null,"Edit data ini?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if(opsi==0){
            edit();
            Data();
            btnSimpan.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null,"pilih data yang akan di edit");
        }

// TODO add your handling code here:
    }//GEN-LAST:event_btnEditActionPerformed

    private void jKelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jKelasMouseClicked
        int bar = jKelas.getSelectedRow();
        String a = jKelas.getValueAt(bar, 0).toString();
        String b = jKelas.getValueAt(bar, 1).toString();
        jId.setText(a);
        kelas.setText(b);
        btnSimpan.setEnabled(false);
        btnHapus.setEnabled(true);
        btnEdit.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jKelasMouseClicked

    private void kelasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kelasKeyTyped
        filterhurufbesar(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_kelasKeyTyped

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_closeMouseClicked

    private void closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseEntered
        ImageIcon A = new ImageIcon (getClass().getResource("Images/close.png"));
        close.setIcon(A);
// TODO add your handling code here:
    }//GEN-LAST:event_closeMouseEntered

    private void closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseExited
        ImageIcon B = new ImageIcon (getClass().getResource("Images/close1.png"));
        close.setIcon(B);
// TODO add your handling code here:
    }//GEN-LAST:event_closeMouseExited

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
            java.util.logging.Logger.getLogger(Kelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kelas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel close;
    private javax.swing.JTextField jId;
    private javax.swing.JTable jKelas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kelas;
    // End of variables declaration//GEN-END:variables
}