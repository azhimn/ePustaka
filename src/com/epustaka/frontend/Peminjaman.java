/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.epustaka.frontend;

import com.epustaka.Main;
import com.epustaka.backend.Config;
import com.epustaka.backend.Validation;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author mazhn
 */
//class ComboBoxUtils {

//}

class ComboItem {
    private String text;
    private int value;

    public ComboItem(String text, int value) {
        this.text = text;
        this.value = value;
    }

    @Override
    public String toString() {
        return text;
    }

    public int getValue() {
        return value;
    }
}

public class Peminjaman extends javax.swing.JFrame {
    
    /**
     * Creates new form Peminjaman
     */
    
    private void load_table() {
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("ID Peminjaman");
        model.addColumn("Tanggal Peminjaman");
        model.addColumn("Tanggal Tenggat");
        model.addColumn("Sudah Dikembalikan");
        
        model.addColumn("ID Anggota");
        model.addColumn("Nama Anggota");
        model.addColumn("Email Anggota");
        
        model.addColumn("ID Buku");
        model.addColumn("Judul Buku");
        model.addColumn("ISBN Buku");
        
        try {
//            int no = 1;
            String sql = "SELECT peminjaman.id, peminjaman.mulai, peminjaman.tenggat, peminjaman.status, anggota.id, "
                    + "anggota.nama, anggota.email, buku.id, buku.judul, buku.isbn FROM peminjaman "
                    + "STRAIGHT_JOIN buku ON peminjaman.fk_buku = buku.id STRAIGHT_JOIN anggota ON peminjaman.fk_anggota = anggota.id; ";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while (res.next()) {
                String dikembalikan;
                if (res.getBoolean(4) == true) {
                    dikembalikan = "Ya";
                } else {
                    dikembalikan = "Tidak";
                }
                                       
                model.addRow(new Object[] {
                    res.getString(1), res.getString(2), res.getString(3), dikembalikan, res.getString(5),
                    res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10)
                });
            }
            tbPeminjaman.setModel(model);
        } catch (Exception e) {}
    }
    
    private int getComboBoxIndex(JComboBox<?> comboBox, String value) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            String itemValue = comboBox.getItemAt(i).toString();
            if (itemValue.contains(value)) {
                return i;
            }
        }
        return -1;
    }
    
    private void loadComboBox() {
        try {
            String sqlBuku = "SELECT * FROM buku";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet resBuku = stm.executeQuery(sqlBuku);
            
            while (resBuku.next()) {
                cbBuku.addItem(resBuku.getString(2) + " | " +  resBuku.getString(3) + " | " + resBuku.getString(1));
            }
        } catch (Exception e) {}
        
        try {
            String sqlAnggota = "SELECT * FROM anggota";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet resAnggota = stm.executeQuery(sqlAnggota);
            
            while (resAnggota.next()) {
                cbAnggota.addItem(resAnggota.getString(3) + " | " +  resAnggota.getString(2) + " | " + resAnggota.getString(1));
            }
        } catch (Exception e) {}
    }
    
    private String splitID(String value) {
        String[] parts = value.split("\\|");
        String result = parts[2].trim();
        
        return result;
    }
    
    private void bersihkan() {
        dtMulai.setDate(null);
        dtTenggat.setDate(null);
        cbDikembalikan.setSelectedIndex(0);
        cbAnggota.setSelectedIndex(0);
        cbBuku.setSelectedIndex(0);
        lbId.setText(null);
    }
    
    public Peminjaman() {
        initComponents();
        btMenuPeminjaman.setEnabled(false);
        load_table();
        loadComboBox();
        
        if (!Main.admin) {
            btMenuPustakawan.setVisible(false);
        }
        
        setLocationRelativeTo(null);
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
        jLabel1 = new javax.swing.JLabel();
        btMenuBuku = new javax.swing.JButton();
        btMenuPeminjaman = new javax.swing.JButton();
        btMenuAnggota = new javax.swing.JButton();
        btMenuPustakawan = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btClear = new javax.swing.JButton();
        btTambah = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        btHapus = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbId = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbDikembalikan = new javax.swing.JComboBox<>();
        dtMulai = new com.toedter.calendar.JDateChooser();
        dtTenggat = new com.toedter.calendar.JDateChooser();
        cbAnggota = new javax.swing.JComboBox<>();
        cbBuku = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPeminjaman = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ePerpus | Menu Peminjaman");
        setMinimumSize(new java.awt.Dimension(1293, 756));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 64));

        jLabel1.setFont(new java.awt.Font("Inter", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ePustaka");

        btMenuBuku.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        btMenuBuku.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        btMenuBuku.setForeground(new java.awt.Color(255, 255, 255));
        btMenuBuku.setText("Buku");
        btMenuBuku.setToolTipText("Menu Buku");
        btMenuBuku.setBorder(null);
        btMenuBuku.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btMenuBuku.setPreferredSize(new java.awt.Dimension(72, 64));
        btMenuBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMenuBukuActionPerformed(evt);
            }
        });

        btMenuPeminjaman.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        btMenuPeminjaman.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        btMenuPeminjaman.setForeground(new java.awt.Color(255, 255, 255));
        btMenuPeminjaman.setText("Peminjaman");
        btMenuPeminjaman.setToolTipText("Menu Peminjaman");
        btMenuPeminjaman.setBorder(null);
        btMenuPeminjaman.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btMenuPeminjaman.setPreferredSize(new java.awt.Dimension(72, 64));
        btMenuPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMenuPeminjamanActionPerformed(evt);
            }
        });

        btMenuAnggota.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        btMenuAnggota.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        btMenuAnggota.setForeground(new java.awt.Color(255, 255, 255));
        btMenuAnggota.setText("Anggota");
        btMenuAnggota.setToolTipText("Menu Anggota");
        btMenuAnggota.setBorder(null);
        btMenuAnggota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btMenuAnggota.setPreferredSize(new java.awt.Dimension(72, 64));
        btMenuAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMenuAnggotaActionPerformed(evt);
            }
        });

        btMenuPustakawan.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        btMenuPustakawan.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        btMenuPustakawan.setForeground(new java.awt.Color(255, 255, 255));
        btMenuPustakawan.setText("Pustakawan");
        btMenuPustakawan.setToolTipText("Menu Pustakawan");
        btMenuPustakawan.setBorder(null);
        btMenuPustakawan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btMenuPustakawan.setPreferredSize(new java.awt.Dimension(72, 64));
        btMenuPustakawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMenuPustakawanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btMenuBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btMenuPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btMenuAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btMenuPustakawan, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 608, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btMenuBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btMenuPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btMenuAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btMenuPustakawan, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(194, 194, 194), 1, true));

        jPanel3.setLayout(new java.awt.GridLayout(1, 0, 8, 8));

        btClear.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Yellow"));
        btClear.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        btClear.setForeground(new java.awt.Color(255, 255, 255));
        btClear.setText("Clear");
        btClear.setToolTipText("Menu Peminjaman");
        btClear.setBorder(null);
        btClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btClear.setPreferredSize(new java.awt.Dimension(72, 64));
        btClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearActionPerformed(evt);
            }
        });
        jPanel3.add(btClear);

        btTambah.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        btTambah.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        btTambah.setForeground(new java.awt.Color(255, 255, 255));
        btTambah.setText("Tambah");
        btTambah.setToolTipText("Menu Peminjaman");
        btTambah.setBorder(null);
        btTambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btTambah.setPreferredSize(new java.awt.Dimension(72, 64));
        btTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTambahActionPerformed(evt);
            }
        });
        jPanel3.add(btTambah);

        btEdit.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        btEdit.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        btEdit.setForeground(new java.awt.Color(255, 255, 255));
        btEdit.setText("Edit");
        btEdit.setToolTipText("Menu Peminjaman");
        btEdit.setBorder(null);
        btEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btEdit.setPreferredSize(new java.awt.Dimension(72, 64));
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });
        jPanel3.add(btEdit);

        btHapus.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        btHapus.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        btHapus.setForeground(new java.awt.Color(255, 255, 255));
        btHapus.setText("Hapus");
        btHapus.setToolTipText("Menu Peminjaman");
        btHapus.setBorder(null);
        btHapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btHapus.setPreferredSize(new java.awt.Dimension(72, 64));
        btHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHapusActionPerformed(evt);
            }
        });
        jPanel3.add(btHapus);

        jLabel2.setText("Tanggal Peminjaman Dimulai");

        jLabel3.setText("Tanggal Tenggat Peminjaman");

        jLabel4.setText("Sudah Dikembalikan");

        jLabel5.setText("Anggota");

        jLabel6.setText("ID Peminjaman =");

        lbId.setText(" ");

        jLabel7.setText("Buku");

        cbDikembalikan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tidak", "Ya" }));
        cbDikembalikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDikembalikanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                    .addComponent(cbDikembalikan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbAnggota, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbBuku, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dtMulai, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                .addComponent(dtTenggat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtMulai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtTenggat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbDikembalikan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, 530, 640));

        tbPeminjaman.setModel(new javax.swing.table.DefaultTableModel(
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
        tbPeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPeminjamanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPeminjaman);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 720, 570));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(194, 194, 194), 1, true));

        jLabel10.setText("Cari Peminjaman");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 720, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btMenuBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMenuBukuActionPerformed
        // TODO add your handling code here:
        Buku bukuFrame = new Buku();
        bukuFrame.show();
        dispose();
    }//GEN-LAST:event_btMenuBukuActionPerformed

    private void btMenuPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMenuPeminjamanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btMenuPeminjamanActionPerformed

    private void btMenuAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMenuAnggotaActionPerformed
        // TODO add your handling code here:
        Anggota anggotaFrame = new Anggota();
        anggotaFrame.show();
        dispose();
    }//GEN-LAST:event_btMenuAnggotaActionPerformed

    private void btMenuPustakawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMenuPustakawanActionPerformed
        // TODO add your handling code here:
        Pustakawan pustakawanFrame = new Pustakawan();
        pustakawanFrame.show();
        dispose();
    }//GEN-LAST:event_btMenuPustakawanActionPerformed

    private void btClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearActionPerformed
        // TODO add your handling code here:
        bersihkan();
    }//GEN-LAST:event_btClearActionPerformed

    private void btTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTambahActionPerformed
        // TODO add your handling code here:
        if (!Validation.validateGreaterDate(dtMulai.getDate(), dtTenggat.getDate())) {
            return;
        }
        
        Object anggota = cbAnggota.getSelectedItem();
        Object buku = cbBuku.getSelectedItem();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                
        try {
            String sql = "INSERT INTO peminjaman (fk_anggota, fk_buku, mulai, tenggat) VALUES('"
            + splitID(anggota.toString()) +
            "','" + splitID(buku.toString()) +
            "','" + dateFormat.format(dtMulai.getDate()) +
            "','" + dateFormat.format(dtTenggat.getDate()) +
            "')";

            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
            load_table();
            bersihkan();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btTambahActionPerformed

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        // TODO add your handling code here:
        if (!Validation.validateGreaterDate(dtMulai.getDate(), dtTenggat.getDate())) {
            return;
        }

        int konfirmasi = JOptionPane.showConfirmDialog(null, "Apakah anda yakin mengubah data ini?", "Pemberitahuan",  JOptionPane.YES_NO_OPTION);
        if(konfirmasi == 1 || konfirmasi == JOptionPane.CLOSED_OPTION) {
            return;
        }
        
        Object anggota = cbAnggota.getSelectedItem();
        Object buku = cbBuku.getSelectedItem();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            String sql = "UPDATE peminjaman SET fk_anggota = '"
            + splitID(anggota.toString()) +
            "', fk_buku = '" + splitID(buku.toString()) +
            "', mulai = '" + dateFormat.format(dtMulai.getDate()) +
            "', tenggat = '" + dateFormat.format(dtTenggat.getDate()) +
            "', status = '" + cbDikembalikan.getSelectedIndex() +
            "' WHERE id = '" + lbId.getText() + "'";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diperbaru");
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal" + e.getMessage());
        }

        load_table();
    }//GEN-LAST:event_btEditActionPerformed

    private void btHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHapusActionPerformed
        // TODO add your handling code here:
        int konfirmasi = JOptionPane.showConfirmDialog(null, "Apakah anda yakin menghapus data ini?", "Pemberitahuan",  JOptionPane.YES_NO_OPTION);
        if(konfirmasi == 1 || konfirmasi == JOptionPane.CLOSED_OPTION) {
            return;
        }
        
        try {
            String sql = "Delete FROM peminjaman WHERE id ='" + lbId.getText() + "'";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        load_table();
        bersihkan();
    }//GEN-LAST:event_btHapusActionPerformed

    private void tbPeminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPeminjamanMouseClicked
        // TODO add your handling code here:
        int baris = tbPeminjaman.rowAtPoint(evt.getPoint());

        String idPeminjaman = tbPeminjaman.getValueAt(baris, 0).toString();
        String mulai = tbPeminjaman.getValueAt(baris, 1).toString();
        String tenggat = tbPeminjaman.getValueAt(baris, 2).toString();
        String dikembalikan = tbPeminjaman.getValueAt(baris, 3).toString();
//        String idAnggota = tbPeminjaman.getValueAt(baris, 4).toString();
//        String nama = tbPeminjaman.getValueAt(baris, 5).toString();
        String email = tbPeminjaman.getValueAt(baris, 6).toString();
//        String idBuku = tbPeminjaman.getValueAt(baris, 7).toString();
//        String judul = tbPeminjaman.getValueAt(baris, 8).toString();
        String isbn = tbPeminjaman.getValueAt(baris, 9).toString();

        // Set JComboBoxes
        int indexBuku = getComboBoxIndex(cbBuku, isbn);
        int indexAnggota = getComboBoxIndex(cbAnggota, email);
        
        if("Tidak".equals(dikembalikan)) {
            cbDikembalikan.setSelectedIndex(0);
        } else {
            cbDikembalikan.setSelectedIndex(1);
        }
        cbAnggota.setSelectedIndex(indexAnggota);
        cbBuku.setSelectedIndex(indexBuku);

        // Set JCalendar Dates
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date mulaiDate = dateFormat.parse(mulai);
            Date tenggatDate = dateFormat.parse(tenggat);
            
            dtMulai.setDate(mulaiDate);
            dtTenggat.setDate(tenggatDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        // Set Label IDs
        lbId.setText(idPeminjaman);
    }//GEN-LAST:event_tbPeminjamanMouseClicked

    private void cbDikembalikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDikembalikanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDikembalikanActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        // TODO add your handling code here:
        String searchText = txtSearch.getText().trim();

        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tbPeminjaman.getModel());
        tbPeminjaman.setRowSorter(rowSorter);

        RowFilter<TableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchText);
        rowSorter.setRowFilter(rowFilter);
    }//GEN-LAST:event_txtSearchKeyTyped

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
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Peminjaman peminjamanFrame = new Peminjaman();
                peminjamanFrame.setLocationRelativeTo(null);
                peminjamanFrame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClear;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btHapus;
    private javax.swing.JButton btMenuAnggota;
    private javax.swing.JButton btMenuBuku;
    private javax.swing.JButton btMenuPeminjaman;
    private javax.swing.JButton btMenuPustakawan;
    private javax.swing.JButton btTambah;
    private javax.swing.JComboBox<String> cbAnggota;
    private javax.swing.JComboBox<String> cbBuku;
    private javax.swing.JComboBox<String> cbDikembalikan;
    private com.toedter.calendar.JDateChooser dtMulai;
    private com.toedter.calendar.JDateChooser dtTenggat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbId;
    private javax.swing.JTable tbPeminjaman;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
