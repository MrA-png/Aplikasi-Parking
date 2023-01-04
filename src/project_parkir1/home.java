package project_parkir1;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Luxtrada R
 */
public class home extends javax.swing.JFrame {
    ResultSet rs;
    Statement stm;
    koneksi koneksi;
    JasperReport JasRep;
    JasperPrint JasPri;
    Map param = new HashMap();
    JasperDesign JasDes;
    public home() {
        initComponents();
        koneksi=new koneksi();
        load_data();
        petugas();
        this.setLocationRelativeTo(null);
        new Thread(){
            public void run(){
                while(true){
                    Calendar kal = new GregorianCalendar();
                    int tahun = kal.get(Calendar.YEAR);
                    int bulan = kal.get(Calendar.MONTH)+1;
                    int hari = kal.get(Calendar.DAY_OF_MONTH);
                    int jam = kal.get(Calendar.HOUR_OF_DAY);
                    int menit = kal.get(Calendar.MINUTE);
                    int detik = kal.get(Calendar.SECOND);
                    String tanggal = tahun+"-"+bulan+"-"+hari;
                    String waktu = jam+":"+menit+":"+detik;
                    tgl.setText(tanggal);
//                    jTanggal.setText(tanggal);
                    jWaktu.setText(waktu);
//                    jWaktu.setText(waktu1);
                }
            }
       }.start();      
    }
   public void load_data(){
       Object header[]={"Nis","Nama","Kelas","Jurusan","No polisi","Nama kendaraan","Status","waktu","Tanggal","Petugas"};
       DefaultTableModel d = new DefaultTableModel(null,header);
       Data.setModel(d);
       String sql = "select siswa.nis,siswa.nama,kelas,jurusan,nopol,namken,status,master.waktu,master.tanggal,petugas.nama_petugas from siswa,kelas,kendaraan,master,jurusan,petugas where kendaraan.IDjurusan=jurusan.IDjurusan and kendaraan.IDkelas=kelas.IDkelas and kendaraan.nis=siswa.nis and master.nis=siswa.nis and master.IDpetugas=petugas.IDpetugas";
       try{
           stm= koneksi.con.createStatement();
           rs=stm.executeQuery(sql);
           while(rs.next()){
               String k1 = rs.getString(1);
               String k2 = rs.getString(2);
               String k3 = rs.getString(3);
               String k4 = rs.getString(4);
               String k5 = rs.getString(5);
               String k6 = rs.getString(6);
               String k7 = rs.getString(7);
               String k8 = rs.getString(8);
               String k9 = rs.getString(9);
               String k10 = rs.getString(10);
               String k[]={k1,k2,k3,k4,k5,k6,k7,k8,k9,k10};
               d.addRow(k);
           }
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"EROOR DI LOAD DATA "+e);
       }
    } 
   
   
   
   public void petugas(){
       try{
           stm=koneksi.con.createStatement();
           String query="SELECT * FROM petugas";
           rs=stm.executeQuery(query);
           while(rs.next()){
               jPetugas.addItem(rs.getString("nama_petugas"));
           }
           rs.close();
       }catch(SQLException e){
       JOptionPane.showMessageDialog(null,"ERROR dipetugas"+e);
       }
   }
   
   public void input_data(){
       try{
           String status="";
           if(masuk.isSelected()){
               status = masuk.getText();
           }else{
               status = keluar.getText();
           }
           stm=koneksi.con.createStatement();
           String id="";
//           String sts="";
           String query="SELECT IDpetugas FROM petugas WHERE nama_petugas='"+jPetugas.getSelectedItem()+"'";
           rs=stm.executeQuery(query);
           if(rs.next()){
               id=rs.getString("IDpetugas");
           }
           String sql="INSERT INTO master values('"+jNis.getText()+"','"
                   +id+"','"
                   +status+"','"
                   +jWaktu.getText()+"','"
                   +tgl.getText()+"')";
           stm.execute(sql);
           JOptionPane.showMessageDialog(null,"Data berhasil dimasukkan");
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Input Data ERROR"+e);
       }
   }
   
   private void reset_form(){
       load_data();
       jNis.setText("");
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngStatus = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        cetak = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        jPetugas = new javax.swing.JComboBox<>();
        masuk = new javax.swing.JRadioButton();
        keluar = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tgl = new javax.swing.JTextField();
        jNis = new javax.swing.JTextField();
        jWaktu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        data = new javax.swing.JScrollPane();
        Data = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jClose = new javax.swing.JLabel();
        jMini = new javax.swing.JLabel();
        jBeranda = new javax.swing.JLabel();
        jData = new javax.swing.JLabel();
        jForm = new javax.swing.JLabel();
        Jhome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setLayout(null);

        jCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCariActionPerformed(evt);
            }
        });
        jPanel2.add(jCari);
        jCari.setBounds(100, 210, 170, 30);

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });
        jPanel2.add(btnCari);
        btnCari.setBounds(280, 210, 51, 30);

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel2.add(btnReset);
        btnReset.setBounds(340, 210, 61, 30);

        cetak.setText("Cetak data");
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });
        jPanel2.add(cetak);
        cetak.setBounds(480, 710, 470, 23);

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel2.add(btnSimpan);
        btnSimpan.setBounds(1287, 210, 80, 23);

        jPetugas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-PILIH-" }));
        jPetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPetugasActionPerformed(evt);
            }
        });
        jPanel2.add(jPetugas);
        jPetugas.setBounds(1160, 160, 130, 30);

        btngStatus.add(masuk);
        masuk.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        masuk.setForeground(new java.awt.Color(240, 240, 240));
        masuk.setText("MASUK");
        masuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masukActionPerformed(evt);
            }
        });
        jPanel2.add(masuk);
        masuk.setBounds(990, 150, 63, 21);

        btngStatus.add(keluar);
        keluar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        keluar.setForeground(new java.awt.Color(240, 240, 240));
        keluar.setText("KELUAR");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });
        jPanel2.add(keluar);
        keluar.setBounds(990, 170, 63, 23);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Petugas");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(1100, 160, 70, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Status");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(910, 160, 50, 30);

        tgl.setEditable(false);
        tgl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tgl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglActionPerformed(evt);
            }
        });
        jPanel2.add(tgl);
        tgl.setBounds(1160, 200, 130, 30);

        jNis.setFont(new java.awt.Font("Tahoma", 2, 20)); // NOI18N
        jNis.setForeground(new java.awt.Color(153, 153, 153));
        jNis.setText("           Scan disini");
        jNis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNisActionPerformed(evt);
            }
        });
        jPanel2.add(jNis);
        jNis.setBounds(990, 100, 300, 40);

        jWaktu.setEditable(false);
        jWaktu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(jWaktu);
        jWaktu.setBounds(990, 200, 140, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("NIS");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(910, 100, 50, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Waktu/Tanggal");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(870, 200, 110, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luxtrada R\\Documents\\NetBeansProjects\\project_parkir1\\src\\project_parkir1\\images\\logo-stm2.png")); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 100, 690, 640);

        data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataMouseClicked(evt);
            }
        });

        Data.setModel(new javax.swing.table.DefaultTableModel(
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
        Data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataMouseClicked(evt);
            }
        });
        data.setViewportView(Data);

        jPanel2.add(data);
        data.setBounds(20, 250, 1330, 460);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luxtrada R\\Documents\\NetBeansProjects\\project_parkir1\\src\\project_parkir1\\images\\Rectangle 7.png")); // NOI18N
        jLabel2.setText(" ");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 700, 1400, 100);

        jClose.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luxtrada R\\Documents\\NetBeansProjects\\project_parkir1\\src\\project_parkir1\\images\\close.png")); // NOI18N
        jClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jCloseMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCloseMousePressed(evt);
            }
        });
        jPanel2.add(jClose);
        jClose.setBounds(1300, 0, 59, 40);

        jMini.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luxtrada R\\Documents\\NetBeansProjects\\project_parkir1\\src\\project_parkir1\\images\\mini.png")); // NOI18N
        jMini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMiniMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMiniMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMiniMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMiniMousePressed(evt);
            }
        });
        jPanel2.add(jMini);
        jMini.setBounds(1240, 0, 60, 40);

        jBeranda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBeranda.setForeground(new java.awt.Color(240, 240, 240));
        jBeranda.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luxtrada R\\Documents\\NetBeansProjects\\project_parkir1\\src\\project_parkir1\\images\\Hom.png")); // NOI18N
        jBeranda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBerandaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBerandaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBerandaMouseExited(evt);
            }
        });
        jPanel2.add(jBeranda);
        jBeranda.setBounds(264, 20, 60, 20);

        jData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jData.setForeground(new java.awt.Color(240, 240, 240));
        jData.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luxtrada R\\Documents\\NetBeansProjects\\project_parkir1\\src\\project_parkir1\\images\\data.png")); // NOI18N
        jData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDataMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jDataMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jDataMouseExited(evt);
            }
        });
        jPanel2.add(jData);
        jData.setBounds(340, 20, 60, 20);

        jForm.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jForm.setForeground(new java.awt.Color(240, 240, 240));
        jForm.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luxtrada R\\Documents\\NetBeansProjects\\project_parkir1\\src\\project_parkir1\\images\\form1.png")); // NOI18N
        jForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFormMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jFormMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jFormMouseExited(evt);
            }
        });
        jPanel2.add(jForm);
        jForm.setBounds(410, 20, 60, 20);

        Jhome.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luxtrada R\\Documents\\NetBeansProjects\\project_parkir1\\src\\project_parkir1\\images\\templ.png")); // NOI18N
        Jhome.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                JhomeMouseDragged(evt);
            }
        });
        Jhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JhomeMousePressed(evt);
            }
        });
        jPanel2.add(Jhome);
        Jhome.setBounds(0, 0, 1420, 780);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1399, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCloseMouseClicked
//         dispose();
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jCloseMouseClicked

    private void jCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCloseMouseEntered
        ImageIcon A = new ImageIcon(getClass().getResource("images/close1.png"));
        jClose.setIcon(A);
        // TODO add your handling code here:
    }//GEN-LAST:event_jCloseMouseEntered

    private void jCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCloseMouseExited
        ImageIcon B = new ImageIcon(getClass().getResource("images/close.png"));
        jClose.setIcon(B);
        // TODO add your handling code here:
    }//GEN-LAST:event_jCloseMouseExited

    private void jCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCloseMousePressed
//        ImageIcon A = new ImageIcon(getClass().getResource("images/close.png"));
//        jClose.setIcon(A);
//            // TODO add your handling code here:
    }//GEN-LAST:event_jCloseMousePressed

    private void jMiniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMiniMouseClicked
        this.setState(home.ICONIFIED);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMiniMouseClicked

    private void jMiniMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMiniMouseEntered
        ImageIcon S = new ImageIcon(getClass().getResource("images/mini2.png"));
        jMini.setIcon(S);
// TODO add your handling code here:
    }//GEN-LAST:event_jMiniMouseEntered

    private void jMiniMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMiniMouseExited
        ImageIcon P = new ImageIcon(getClass().getResource("images/mini.png"));
        jMini.setIcon(P);
// TODO add your handling code here:
    }//GEN-LAST:event_jMiniMouseExited

    private void jMiniMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMiniMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMiniMousePressed

    private void JhomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JhomeMousePressed
//        xmouse = evt.getX();
//        ymouse = evt.getY();
        // TODO add your handling code here:
    }//GEN-LAST:event_JhomeMousePressed

    private void JhomeMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JhomeMouseDragged
//        int x = evt.getXOnScreen();
//        int y = evt.getYOnScreen();
//        //
//        this.setLocation(x - xmouse, y - ymouse);
//        System.out.println(x+","+y);
        // TODO add your handling code here:
    }//GEN-LAST:event_JhomeMouseDragged

    private void jBerandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBerandaMouseClicked
//        home home = new home();
//        home.setVisible(true);
//        this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jBerandaMouseClicked

    private void jBerandaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBerandaMouseEntered
        ImageIcon A = new ImageIcon(getClass().getResource("images/Hom1.png"));
        jBeranda.setIcon(A);
// TODO add your handling code here:
    }//GEN-LAST:event_jBerandaMouseEntered

    private void jBerandaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBerandaMouseExited
        ImageIcon B = new ImageIcon(getClass().getResource("images/Hom.png"));
        jBeranda.setIcon(B);
// TODO add your handling code here:
    }//GEN-LAST:event_jBerandaMouseExited

    private void jDataMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDataMouseEntered
        ImageIcon A = new ImageIcon(getClass().getResource("images/data1.png"));
        jData.setIcon(A);
// TODO add your handling code here:
    }//GEN-LAST:event_jDataMouseEntered

    private void jDataMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDataMouseExited
       ImageIcon B = new ImageIcon(getClass().getResource("images/data.png"));
        jData.setIcon(B);
        // TODO add your handling code here:
    }//GEN-LAST:event_jDataMouseExited

    private void jFormMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFormMouseEntered
        ImageIcon A = new ImageIcon(getClass().getResource("images/form.png"));
        jForm.setIcon(A);
// TODO add your handling code here:
    }//GEN-LAST:event_jFormMouseEntered

    private void jFormMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFormMouseExited
        ImageIcon A = new ImageIcon(getClass().getResource("images/form1.png"));
        jForm.setIcon(A);
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormMouseExited

    private void jFormMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFormMouseClicked
        form from = new form();
        from.setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormMouseClicked

    private void jDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDataMouseClicked
        menu menu = new menu();
        menu.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_jDataMouseClicked

    private void tglActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tglActionPerformed

    private void jNisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNisActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jNisActionPerformed

    private void DataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataMouseClicked
//        
        // TODO add your handling code here:
    }//GEN-LAST:event_DataMouseClicked

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        int opsi = JOptionPane.showConfirmDialog(null,"Simpan data?","konfirmasi",JOptionPane.YES_NO_OPTION);
        if (opsi == JOptionPane.YES_OPTION){
            input_data();
            load_data();
            reset_form();
        }else{
            JOptionPane.showConfirmDialog(null,"Data tidak tersimpan","informasi",JOptionPane.ERROR_MESSAGE);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataMouseClicked

    }//GEN-LAST:event_dataMouseClicked

    private void jPetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPetugasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPetugasActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keluarActionPerformed

    private void masukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_masukActionPerformed

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
        try{
            File reprt = new File("src/project_parkir1/reportKendaraan.jrxml");
            JasDes = JRXmlLoader.load(reprt);
            param.clear();
            JasRep = JasperCompileManager.compileReport(JasDes);
            JasPri = JasperFillManager.fillReport(JasRep,param,koneksi.con);
            JasperViewer.viewReport(JasPri,false);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
//            JOptionPane.showMessageDialog(null,"gagal membuka laporan","Cetak Laporan",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cetakActionPerformed

    private void jCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCariActionPerformed
       
// TODO add your handling code here:
    }//GEN-LAST:event_jCariActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
       Object header[]={"Nis","Petugas","Status","waktu","Tanggal"};
       DefaultTableModel d = new DefaultTableModel(null,header);
       Data.setModel(d);
//       String sql = "select siswa.nis,siswa.nama,kelas,jurusan,nopol,namken,status,master.waktu,master.tanggal,petugas.nama_petugas from siswa,kelas,kendaraan,master,jurusan,petugas where kendaraan.IDjurusan=jurusan.IDjurusan and kendaraan.IDkelas=kelas.IDkelas and kendaraan.nis=siswa.nis and master.nis=siswa.nis and master.IDpetugas=petugas.IDpetugas";
       try{
           stm= koneksi.con.createStatement();
           String sql = "select* from master where nis like'%"+jCari.getText()+"%'"+"or tanggal like'%"+jCari.getText()+"%'";
//       String sql = "select siswa.nis,siswa.nama,kelas,jurusan,nopol,namken,status,master.waktu,master.tanggal,petugas.nama_petugas from siswa,kelas,kendaraan,master,jurusan,petugas where kendaraan.IDjurusan=jurusan.IDjurusan and kendaraan.IDkelas=kelas.IDkelas and kendaraan.nis=siswa.nis and master.nis=siswa.nis and master.IDpetugas=petugas.IDpetugas"+"and where nis like '%"+jCari.getText()+"%'";

                rs = stm.executeQuery(sql);
           while(rs.next()){
               String k1 = rs.getString(1);
               String k2 = rs.getString(2);
               String k3 = rs.getString(3);
               String k4 = rs.getString(4);
               String k5 = rs.getString(5);
//               String k6 = rs.getString(6);
//               String k7 = rs.getString(7);
//               String k8 = rs.getString(8);
//               String k9 = rs.getString(9);
//               String k10 = rs.getString(10);
               String k[]={k1,k2,k3,k4,k5};
               d.addRow(k);
           }
       }catch(SQLException e){
//           JOptionPane.showMessageDialog(null,"Gagal mencari data ","WARNING",JOptionPane.ERROR_MESSAGE);
JOptionPane.showMessageDialog(null, e);
       }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        load_data();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetActionPerformed

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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Data;
    private javax.swing.JLabel Jhome;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.ButtonGroup btngStatus;
    private javax.swing.JButton cetak;
    private javax.swing.JScrollPane data;
    private javax.swing.JLabel jBeranda;
    private javax.swing.JTextField jCari;
    private javax.swing.JLabel jClose;
    private javax.swing.JLabel jData;
    private javax.swing.JLabel jForm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jMini;
    private javax.swing.JTextField jNis;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> jPetugas;
    private javax.swing.JTextField jWaktu;
    private javax.swing.JRadioButton keluar;
    private javax.swing.JRadioButton masuk;
    private javax.swing.JTextField tgl;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
