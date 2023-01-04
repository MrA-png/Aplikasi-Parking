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
public class jurusan extends javax.swing.JFrame {
    public static Connection con;
    public static Statement stm;
    public static ResultSet rs;

    public jurusan() {
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
            String pass="";
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url,user,pass);
            stm=(Statement)con.createStatement();
        }catch(Exception e){
            System.out.println("Koneksi gagal"+e.getMessage());
        }
    }
    
    public void Data(){
        Object header[]={"ID Jurusan","Jurusan"};
        DefaultTableModel jurusan = new DefaultTableModel(null,header);
        jJurusan.setModel(jurusan);
        String sql="select * from jurusan;";
        try{
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while(rs.next()){
                String k1 = rs.getString(1);
                String k2 = rs.getString(2);
                String k[]={k1,k2};
                jurusan.addRow(k);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    private void IDotomatis(){
        try{
            stm=con.createStatement();
            String sql = "select * from jurusan order by IDjurusan desc";
            rs=stm.executeQuery(sql);
            if(rs.next()){
                String ID = rs.getString("IDjurusan").substring(3);
                String NO=""+(Integer.parseInt(ID)+1);
                String No1="";
                
                if(NO.length()==1){
                    No1="00";
                }else if(NO.length()==2){
                    No1="0";
                }else if(NO.length()==3){
                    No1="";
                }
                id.setText("JUR"+ No1 + NO);  
            }else{
                id.setText("JUR001");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public void Tambah_Data(){
        try{
            stm=con.createStatement();
            String sql="insert into jurusan values('"+id.getText()+"','"+jurusan.getText()+"')";
            stm.execute(sql);
            JOptionPane.showMessageDialog(null,"Data Berhasil Dimasukkan");
        }
        catch(SQLException e ){
        JOptionPane.showMessageDialog(null,e);
        }
    }
    
    private void hapus(){
        try{
            stm=con.createStatement();
            String sql = "delete form jurusan where IDjurusan='"+id.getText()+"'";
            stm.execute(sql);
            JOptionPane.showMessageDialog(null,"Data berhasil dihapus");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    private void edit(){
        try{
            stm=con.createStatement();
            String sql = "update jurusan set jurusan='"+jurusan.getText()+"'where IDjurusan='"+id.getText()+"'";
            stm.execute(sql);
            JOptionPane.showMessageDialog(null,"Data berhasil diedit");
            Data();
            reset_form();
            btnSimpan.setEnabled(true);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Data Disimpan\n"+e);
        }
    }
    
    private void reset_form(){
        Data();
        IDotomatis();
//        id.setText("");
        jurusan.setText("");
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
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        jurusan = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jJurusan = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
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
        close.setBounds(570, 0, 60, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Jurusan");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 180, 60, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID Jurusan");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 140, 70, 15);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tambah Data");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 90, 120, 30);

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimpan);
        btnSimpan.setBounds(190, 230, 80, 23);

        jurusan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jurusanKeyTyped(evt);
            }
        });
        jPanel1.add(jurusan);
        jurusan.setBounds(110, 170, 150, 30);
        jPanel1.add(id);
        id.setBounds(110, 130, 150, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Data Jurusan");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(360, 10, 140, 20);

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit);
        btnEdit.setBounds(110, 230, 51, 23);

        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        jPanel1.add(hapus);
        hapus.setBounds(20, 230, 80, 23);

        jJurusan.setModel(new javax.swing.table.DefaultTableModel(
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
        jJurusan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jJurusanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jJurusan);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(290, 90, 320, 402);

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luxtrada R\\Documents\\NetBeansProjects\\project_parkir1\\src\\project_parkir1\\images\\bgDaata.png")); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 90, 270, 180);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luxtrada R\\Documents\\NetBeansProjects\\project_parkir1\\src\\project_parkir1\\images\\bg.png")); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, -10, 640, 520);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        int opsi = JOptionPane.showConfirmDialog(null,"Hapus Data ini?","konfirmasi",JOptionPane.YES_NO_OPTION);
        if(opsi==0){
            hapus();
            reset_form();
            Data();
            btnSimpan.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null,"pilih data yang akan dihapus");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_hapusActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if(id.getText().equals("")){
           JOptionPane.showMessageDialog(null,"ID Kelas harus diisi","informasi",JOptionPane.ERROR_MESSAGE);
       }else if(jurusan.getText().equals("")){
           JOptionPane.showMessageDialog(null,"Jurusan harus diisi","informasi",JOptionPane.ERROR_MESSAGE);
       }else{
           int opsi = JOptionPane.showConfirmDialog(null,"simpan data?","konfirmasi",JOptionPane.YES_NO_OPTION);
       
           if(opsi == JOptionPane.YES_OPTION){
               Tambah_Data();
               reset_form();
               Data();
               IDotomatis();
           }else{
               JOptionPane.showMessageDialog(null,"Data tidak tersimpan","informasi",JOptionPane.ERROR_MESSAGE);
           }
       } 
// TODO add your handling code here:
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void jJurusanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jJurusanMouseClicked
        int bar = jJurusan.getSelectedRow();
        String a = jJurusan.getValueAt(bar,0).toString();
        String b = jJurusan.getValueAt(bar,1).toString();
        id.setText(a);
        jurusan.setText(b);
        btnSimpan.setEnabled(false);
        hapus.setEnabled(true);
        btnEdit.setEnabled(true);
        // TODJO add your handling code here:
    }//GEN-LAST:event_jJurusanMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int opsi =JOptionPane.showConfirmDialog(null,"edit data ini?","konfirmasi",JOptionPane.YES_NO_OPTION);
        if(opsi == 0){
            edit();
            Data();
            btnSimpan.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null,"pilih data yang akan di edit");
        }
// TODO add your handling code here:
    }//GEN-LAST:event_btnEditActionPerformed

    private void jurusanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jurusanKeyTyped
       filterhurufbesar(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jurusanKeyTyped

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
        ImageIcon B = new ImageIcon(getClass().getResource("Images/close1.png"));
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
            java.util.logging.Logger.getLogger(jurusan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jurusan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jurusan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jurusan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jurusan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel close;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField id;
    private javax.swing.JTable jJurusan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jurusan;
    // End of variables declaration//GEN-END:variables
}
