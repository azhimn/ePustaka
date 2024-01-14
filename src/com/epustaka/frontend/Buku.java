/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.epustaka.frontend;

import com.epustaka.Main;
import com.epustaka.backend.Config;
import com.epustaka.backend.Validation;
import com.formdev.flatlaf.FlatLightLaf;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author mazhn
 */
public class Buku extends javax.swing.JFrame {

    private void load_table() {
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("ID");
        model.addColumn("Judul");
        model.addColumn("ISBN");
        model.addColumn("Penulis");
        model.addColumn("Penerbit");
        model.addColumn("Tahun Terbit");
        model.addColumn("Kategori");
        model.addColumn("Lokasi");

        
        try {
//            int no = 1;
            String sql = "select * from buku";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while (res.next()) {
                model.addRow(new Object[] {
                    res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getDate(6).toLocalDate().getYear(), res.getString(7), res.getString(8)
                });
            }
            tbBuku.setModel(model);
        } catch (Exception e) {}
    }
    
    private void bersihkan() {
        txtJudul.setText(null);
        txtIsbn.setText(null);
        txtPenulis.setText(null);
        txtPenerbit.setText(null);
        dtTahun.setYear(2024);
        cbKategori.setSelectedIndex(0);
        txtLokasi.setText(null);
        txtJudul.requestFocus();
        lbId.setText(null);
    }
    
    /**
     * Creates new form Buku
     */
    public Buku() {
        initComponents();
        btMenuBuku.setEnabled(false);
        load_table();
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBuku = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btClear = new javax.swing.JButton();
        btTambah = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        btHapus = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtJudul = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIsbn = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPenulis = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPenerbit = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtLokasi = new javax.swing.JTextField();
        cbKategori = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        lbId = new javax.swing.JLabel();
        dtTahun = new com.toedter.calendar.JYearChooser();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ePustaka | Menu Buku");
        setBackground(new java.awt.Color(238, 238, 238));
        setMinimumSize(new java.awt.Dimension(1293, 756));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
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

        tbBuku.setModel(new javax.swing.table.DefaultTableModel(
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
        tbBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbBuku);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 720, 570));

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

        jLabel2.setText("Judul Buku");

        txtJudul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJudulActionPerformed(evt);
            }
        });

        jLabel3.setText("ISBN");

        txtIsbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIsbnActionPerformed(evt);
            }
        });

        jLabel4.setText("Penulis");

        txtPenulis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPenulisActionPerformed(evt);
            }
        });

        jLabel5.setText("Penerbit");

        txtPenerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPenerbitActionPerformed(evt);
            }
        });

        jLabel6.setText("Tahun Terbit");

        jLabel7.setText("Kategori / Genre");

        jLabel8.setText("Lokasi Penyimpanan");

        txtLokasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLokasiActionPerformed(evt);
            }
        });

        cbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fiksi", "Non-fiksi" }));

        jLabel9.setText("ID =");

        lbId.setText(" ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                    .addComponent(txtJudul)
                    .addComponent(txtIsbn)
                    .addComponent(txtPenulis)
                    .addComponent(txtPenerbit)
                    .addComponent(txtLokasi)
                    .addComponent(cbKategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbId, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPenulis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLokasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lbId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, 530, 640));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(194, 194, 194), 1, true));

        jLabel10.setText("Cari Buku");

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
                    .addComponent(txtSearch)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 636, Short.MAX_VALUE)))
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

    private void btMenuPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMenuPeminjamanActionPerformed
        // TODO add your handling code here:
        Peminjaman peminjamanFrame = new Peminjaman();
        peminjamanFrame.show();
        dispose();
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

    private void btHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHapusActionPerformed
        // TODO add your handling code here:
        int konfirmasi = JOptionPane.showConfirmDialog(null, "Apakah anda yakin menghapus buku '" + txtJudul.getText() + "'?", "Pemberitahuan",  JOptionPane.YES_NO_OPTION);
        if(konfirmasi == 1 || konfirmasi == JOptionPane.CLOSED_OPTION) {
            return;
        }
        
        try {
            String sql = "Delete FROM buku WHERE id ='" + lbId.getText() + "'";
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

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        // TODO add your handling code here:
        if (!Validation.validateISBN(txtIsbn.getText())) {
            return;
        }
        
        int konfirmasi = JOptionPane.showConfirmDialog(null, "Apakah anda yakin mengubah data buku '" + txtJudul.getText() + "'?", "Pemberitahuan",  JOptionPane.YES_NO_OPTION);
        if(konfirmasi == 1 || konfirmasi == JOptionPane.CLOSED_OPTION) {
            return;
        }
        
        try {
            String sql = "UPDATE buku SET judul = '"
                    + txtJudul.getText() +
                    "', isbn = '" + txtIsbn.getText() +
                    "', penulis = '" + txtPenulis.getText() +
                    "', penerbit = '" + txtPenerbit.getText() +
                    "', tahun = '" + dtTahun.getYear() +
                    "', kategori = '" + cbKategori.getSelectedItem() +
                    "', lokasi = '" + txtLokasi.getText() +
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

    private void btTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTambahActionPerformed
        // TODO add your handling code here:
        if (!Validation.validateISBN(txtIsbn.getText())) {
            return;
        }
        
        try {
            String sql = "INSERT INTO buku (judul, isbn, penulis, penerbit, tahun, kategori, lokasi) VALUES('"
                    + txtJudul.getText() +
                    "','" + txtIsbn.getText() +
                    "','" + txtPenulis.getText() +
                    "','" + txtPenerbit.getText() +
                    "','" + dtTahun.getYear() +
                    "','" + cbKategori.getSelectedItem() +
                    "','" + txtLokasi.getText() +
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

    private void txtJudulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJudulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJudulActionPerformed

    private void txtIsbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIsbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIsbnActionPerformed

    private void txtPenulisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPenulisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPenulisActionPerformed

    private void txtPenerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPenerbitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPenerbitActionPerformed

    private void txtLokasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLokasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLokasiActionPerformed

    private void btClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearActionPerformed
        // TODO add your handling code here:
        bersihkan();
    }//GEN-LAST:event_btClearActionPerformed

    private void tbBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBukuMouseClicked
        // TODO add your handling code here:
        int baris = tbBuku.rowAtPoint(evt.getPoint());
        
        String id = tbBuku.getValueAt(baris, 0).toString();
        String judul = tbBuku.getValueAt(baris, 1).toString();
        String isbn = tbBuku.getValueAt(baris, 2).toString();
        String penulis = tbBuku.getValueAt(baris, 3).toString();
        String penerbit = tbBuku.getValueAt(baris, 4).toString();
        String tahun = tbBuku.getValueAt(baris, 5).toString();
        String kategori = tbBuku.getValueAt(baris, 6).toString();
        String lokasi = tbBuku.getValueAt(baris, 7).toString();
        
        lbId.setText(id);
        txtJudul.setText(judul);
        txtIsbn.setText(isbn);
        txtPenulis.setText(penulis);
        txtPenerbit.setText(penerbit);
        dtTahun.setYear(Integer.parseInt(tahun));
        
        if("Fiksi".equals(kategori)) {
            cbKategori.setSelectedIndex(0);
        } else {
            cbKategori.setSelectedIndex(1);
        }
        txtLokasi.setText(lokasi);

    }//GEN-LAST:event_tbBukuMouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        // TODO add your handling code here:
        String searchText = txtSearch.getText().trim();

        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tbBuku.getModel());
        tbBuku.setRowSorter(rowSorter);

        RowFilter<TableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchText);
        rowSorter.setRowFilter(rowFilter);
    }//GEN-LAST:event_txtSearchKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Buku bukuFrame = new Buku();
                bukuFrame.setLocationRelativeTo(null);
                bukuFrame.setVisible(true);
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
    private javax.swing.JComboBox<String> cbKategori;
    private com.toedter.calendar.JYearChooser dtTahun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbId;
    private javax.swing.JTable tbBuku;
    private javax.swing.JTextField txtIsbn;
    private javax.swing.JTextField txtJudul;
    private javax.swing.JTextField txtLokasi;
    private javax.swing.JTextField txtPenerbit;
    private javax.swing.JTextField txtPenulis;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
