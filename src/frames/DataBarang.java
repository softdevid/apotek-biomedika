package frames;

import config.MySQLConnection;
import config.TableColumnAdjuster;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import main.Main;

/**
 *
 * @author ZAFL
 */
public class DataBarang extends javax.swing.JInternalFrame {

  Connection conn = (Connection) MySQLConnection.connectDB();
  DefaultTableModel tableModel;

  /**
   * Creates new form DataBarang
   */
  public DataBarang() {
    initComponents();
    ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
    ((BasicInternalFrameUI) this.getUI()).setEastPane(null);
    ((BasicInternalFrameUI) this.getUI()).setSouthPane(null);
    ((BasicInternalFrameUI) this.getUI()).setWestPane(null);
    this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

    // init table
    initTable();
    // 3 kriteria
    barangDekatKadaluwarsa();
    barangDekatJatuhTempo();
    barangDekatStokHabis();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPopupMenu = new javax.swing.JPopupMenu();
    pelunasan = new javax.swing.JMenuItem();
    jPanel = new javax.swing.JPanel();
    jPanel2 = new javax.swing.JPanel();
    jLabel3 = new javax.swing.JLabel();
    jmlBarangKedaluwarsa = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jmlBarangJatuhTempo = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    jmlStokHampirHabis = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    comboFilterBarang = new javax.swing.JComboBox<>();
    jLabel4 = new javax.swing.JLabel();
    txtCariBarang = new javax.swing.JTextField();
    jScrollPane = new javax.swing.JScrollPane();
    tabelDataBarang = new javax.swing.JTable() {
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };

    pelunasan.setText("Pelunasan");
    pelunasan.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        pelunasanActionPerformed(evt);
      }
    });
    jPopupMenu.add(pelunasan);

    setMinimumSize(new java.awt.Dimension(960, 540));

    jPanel.setBackground(new java.awt.Color(208, 242, 255));

    jPanel2.setBackground(new java.awt.Color(255, 255, 255));

    jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
    jLabel3.setText("Barang dekat kedaluwarsa");

    jmlBarangKedaluwarsa.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
    jmlBarangKedaluwarsa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jmlBarangKedaluwarsa.setText("0");

    jLabel5.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
    jLabel5.setText("Barang dekat jatuh tempo");

    jmlBarangJatuhTempo.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
    jmlBarangJatuhTempo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jmlBarangJatuhTempo.setText("0");

    jLabel7.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
    jLabel7.setText("Stok hampir habis");

    jmlStokHampirHabis.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
    jmlStokHampirHabis.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jmlStokHampirHabis.setText("0");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        .addGap(56, 56, 56)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel3)
          .addComponent(jmlBarangKedaluwarsa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(25, 25, 25)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel5)
          .addComponent(jmlBarangJatuhTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(25, 25, 25)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jmlStokHampirHabis, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(56, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap(31, Short.MAX_VALUE)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(jLabel5)
          .addComponent(jLabel7))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jmlStokHampirHabis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jmlBarangKedaluwarsa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jmlBarangJatuhTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(32, Short.MAX_VALUE))
    );

    jLabel2.setText("Filter Data");

    comboFilterBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "Dekat kedaluwarsa", "Dekat jatuh tempo", "Stok hampir habis" }));
    comboFilterBarang.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(java.awt.event.ItemEvent evt) {
        comboFilterBarangItemStateChanged(evt);
      }
    });

    jLabel4.setText("Cari Barang");

    txtCariBarang.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        txtCariBarangKeyReleased(evt);
      }
    });

    javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
    jPanel.setLayout(jPanelLayout);
    jPanelLayout.setHorizontalGroup(
      jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
        .addGap(29, 29, 29)
        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel2)
          .addComponent(jLabel4))
        .addGap(18, 18, 18)
        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanelLayout.createSequentialGroup()
            .addComponent(comboFilterBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 280, Short.MAX_VALUE))
          .addComponent(txtCariBarang))
        .addGap(18, 18, 18)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    jPanelLayout.setVerticalGroup(
      jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(jPanelLayout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(comboFilterBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(21, 21, 21)
            .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(txtCariBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
              .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );

    tabelDataBarang.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
    tabelDataBarang.setModel(new javax.swing.table.DefaultTableModel(
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
    tabelDataBarang.getTableHeader().setReorderingAllowed(false);
    tabelDataBarang.setAutoCreateRowSorter(true);
    tabelDataBarang.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseReleased(java.awt.event.MouseEvent evt) {
        tabelDataBarangMouseReleased(evt);
      }
    });
    jScrollPane.setViewportView(tabelDataBarang);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jScrollPane))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void txtCariBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariBarangKeyReleased
    tableModel.setRowCount(0);
    String txtCari = txtCariBarang.getText();
    tableData("SELECT dtbrng.id, bli.tanggal_terima, pbf.nama, bli.no_faktur, bli.tanggal_faktur, dtbrng.nama_barang, dtbrng.tanggal_kedaluwarsa, dtbrng.batch, dtbrng.qty, dtbrng.harga_satuan, (dtbrng.qty * dtbrng.harga_satuan) as harga_total, dtbrng.harga_jual, bli.jatuh_tempo, bli.tanggal_lunas FROM data_barang dtbrng JOIN pembelian_detail blidt ON blidt.barang_id = dtbrng.id JOIN pembelian bli ON bli.no_faktur = blidt.no_faktur JOIN pbf_distributor pbf ON bli.pbf_id = pbf.id WHERE dtbrng.nama_barang LIKE '%" + txtCari + "%'");
  }//GEN-LAST:event_txtCariBarangKeyReleased

  private void comboFilterBarangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboFilterBarangItemStateChanged
    switch (comboFilterBarang.getSelectedIndex()) {
      case 1 ->
        tableData("SELECT dtbrng.id, bli.tanggal_terima, pbf.nama, bli.no_faktur, bli.tanggal_faktur, dtbrng.nama_barang, dtbrng.tanggal_kedaluwarsa, dtbrng.batch, dtbrng.qty, dtbrng.harga_satuan, (dtbrng.qty * dtbrng.harga_satuan) as harga_total, dtbrng.harga_jual, bli.jatuh_tempo, bli.tanggal_lunas FROM data_barang dtbrng JOIN pembelian_detail blidt ON blidt.barang_id = dtbrng.id JOIN pembelian bli ON bli.no_faktur = blidt.no_faktur JOIN pbf_distributor pbf ON bli.pbf_id = pbf.id WHERE dtbrng.tanggal_kedaluwarsa >= CURDATE() AND dtbrng.tanggal_kedaluwarsa <= DATE_ADD(CURDATE(), INTERVAL 2 MONTH)");
      case 2 ->
        tableData("SELECT dtbrng.id, bli.tanggal_terima, pbf.nama, bli.no_faktur, bli.tanggal_faktur, dtbrng.nama_barang, dtbrng.tanggal_kedaluwarsa, dtbrng.batch, dtbrng.qty, dtbrng.harga_satuan, (dtbrng.qty * dtbrng.harga_satuan) as harga_total, dtbrng.harga_jual, bli.jatuh_tempo, bli.tanggal_lunas FROM data_barang dtbrng JOIN pembelian_detail blidt ON blidt.barang_id = dtbrng.id JOIN pembelian bli ON bli.no_faktur = blidt.no_faktur JOIN pbf_distributor pbf ON bli.pbf_id = pbf.id WHERE bli.jatuh_tempo >= CURDATE() AND bli.jatuh_tempo <= DATE_ADD(CURDATE(), INTERVAL 1 MONTH) AND bli.tanggal_lunas IS NULL");
      case 3 ->
        tableData("SELECT dtbrng.id, bli.tanggal_terima, pbf.nama, bli.no_faktur, bli.tanggal_faktur, dtbrng.nama_barang, dtbrng.tanggal_kedaluwarsa, dtbrng.batch, dtbrng.qty, dtbrng.harga_satuan, (dtbrng.qty * dtbrng.harga_satuan) as harga_total, dtbrng.harga_jual, bli.jatuh_tempo, bli.tanggal_lunas FROM data_barang dtbrng JOIN pembelian_detail blidt ON blidt.barang_id = dtbrng.id JOIN pembelian bli ON bli.no_faktur = blidt.no_faktur JOIN pbf_distributor pbf ON bli.pbf_id = pbf.id GROUP BY dtbrng.id, dtbrng.nama_barang HAVING dtbrng.qty<= 10");
      default ->
        tableData("SELECT dtbrng.id, bli.tanggal_terima, pbf.nama, bli.no_faktur, bli.tanggal_faktur, dtbrng.nama_barang, dtbrng.tanggal_kedaluwarsa, dtbrng.batch, dtbrng.qty, dtbrng.harga_satuan, (dtbrng.qty * dtbrng.harga_satuan) as harga_total, dtbrng.harga_jual, bli.jatuh_tempo, bli.tanggal_lunas FROM data_barang dtbrng JOIN pembelian_detail blidt ON blidt.barang_id = dtbrng.id JOIN pembelian bli ON bli.no_faktur = blidt.no_faktur JOIN pbf_distributor pbf ON bli.pbf_id = pbf.id");
    }
  }//GEN-LAST:event_comboFilterBarangItemStateChanged

  private void tabelDataBarangMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDataBarangMouseReleased
    if (evt.isPopupTrigger()) {
      JTable source = (JTable) evt.getSource();
      int row = source.rowAtPoint(evt.getPoint());
      int column = source.columnAtPoint(evt.getPoint());

      if (!source.isRowSelected(row)) {
        source.changeSelection(row, column, false, false);
      }
      jPopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
    }
  }//GEN-LAST:event_tabelDataBarangMouseReleased

  private void pelunasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pelunasanActionPerformed
    int[] selectedRows = tabelDataBarang.getSelectedRows();

    StringBuilder barangId = getsBarangIdFromTable(selectedRows);
    String noFaktur = getsNoFakturFromTable(selectedRows);

    if (noFaktur.equals("")) {
      JOptionPane.showMessageDialog(null, "Nomor Faktur tidak sama!");
    } else {
      System.out.println(barangId);
      System.out.println(noFaktur);

      JDesktopPane desktopPane = getDesktopPane();
      Pembelian pembelian = new Pembelian(true, barangId.toString(), noFaktur);
      
      desktopPane.add(pembelian);
      try {
        pembelian.setMaximum(true);
      } catch (PropertyVetoException pve) {
        System.err.println(pve.getMessage());
      }
      pembelian.setVisible(true);
      pembelian.toFront();
      this.dispose();
    }
  }//GEN-LAST:event_pelunasanActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JComboBox<String> comboFilterBarang;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JPanel jPanel;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPopupMenu jPopupMenu;
  private javax.swing.JScrollPane jScrollPane;
  private javax.swing.JLabel jmlBarangJatuhTempo;
  private javax.swing.JLabel jmlBarangKedaluwarsa;
  private javax.swing.JLabel jmlStokHampirHabis;
  private javax.swing.JMenuItem pelunasan;
  private javax.swing.JTable tabelDataBarang;
  private javax.swing.JTextField txtCariBarang;
  // End of variables declaration//GEN-END:variables

  private void initTable() {
    tableModel = new DefaultTableModel();
    tableModel.addColumn("No");
    tableModel.addColumn("ID");
    tableModel.addColumn("Tanggal Terima");
    tableModel.addColumn("PBF Distributor");
    tableModel.addColumn("No Faktur");
    tableModel.addColumn("Tanggal Faktur");
    tableModel.addColumn("Nama Barang");
    tableModel.addColumn("Tanggal Kedaluwarsa");
    tableModel.addColumn("Batch");
    tableModel.addColumn("Qty");
    tableModel.addColumn("Harga Satuan");
    tableModel.addColumn("Harga Total");
    tableModel.addColumn("Harga Jual");
    tableModel.addColumn("Jatuh Tempo");
    tableModel.addColumn("Tanggal Lunas");

    tableData("SELECT dtbrng.id, bli.tanggal_terima, pbf.nama, bli.no_faktur, bli.tanggal_faktur, dtbrng.nama_barang, dtbrng.tanggal_kedaluwarsa, dtbrng.batch, dtbrng.qty, dtbrng.harga_satuan, (dtbrng.qty * dtbrng.harga_satuan) as harga_total, dtbrng.harga_jual, bli.jatuh_tempo, bli.tanggal_lunas FROM data_barang dtbrng JOIN pembelian_detail blidt ON blidt.barang_id = dtbrng.id JOIN pembelian bli ON bli.no_faktur = blidt.no_faktur JOIN pbf_distributor pbf ON bli.pbf_id = pbf.id");
  }

  private void barangDekatKadaluwarsa() {
    try {
      String query = "SELECT COUNT(nama_barang) AS jumlah_barang_dekat_kedaluwarsa FROM data_barang WHERE tanggal_kedaluwarsa >= CURDATE() AND tanggal_kedaluwarsa <= DATE_ADD(CURDATE(), INTERVAL 2 MONTH)";
      Statement stm = conn.createStatement();
      ResultSet rs = stm.executeQuery(query);
      if (rs.next()) {
        jmlBarangKedaluwarsa.setText(rs.getString("jumlah_barang_dekat_kedaluwarsa"));
      }
    } catch (SQLException e) {
      System.err.println("Error: " + e.getMessage());
      e.printStackTrace();
    }
  }

  private void barangDekatJatuhTempo() {
    try {
      String query = "SELECT COUNT(*) AS jumlah_barang_dekat_jatuh_tempo FROM ( SELECT dtbrng.id, dtbrng.nama_barang, bli.jatuh_tempo FROM data_barang dtbrng JOIN pembelian_detail blidt ON blidt.barang_id = dtbrng.id JOIN pembelian bli ON bli.no_faktur = blidt.no_faktur WHERE bli.jatuh_tempo >= CURDATE() AND bli.jatuh_tempo <= DATE_ADD(CURDATE(), INTERVAL 1 MONTH) AND bli.tanggal_lunas IS NULL ) AS subquery";
      Statement stm = conn.createStatement();
      ResultSet rs = stm.executeQuery(query);
      if (rs.next()) {
        jmlBarangJatuhTempo.setText(rs.getString("jumlah_barang_dekat_jatuh_tempo"));
      }
    } catch (SQLException e) {
      System.err.println("Error: " + e.getMessage());
      e.printStackTrace();
    }
  }

  private void barangDekatStokHabis() {
    try {
      String query = "SELECT COUNT(*) AS jumlah_barang_stok_kurang_atau_sama_dengan_10 FROM ( SELECT id, nama_barang, qty FROM data_barang dtbrng GROUP BY id, nama_barang HAVING qty<= 10 ) AS subquery";
      Statement stm = conn.createStatement();
      ResultSet rs = stm.executeQuery(query);
      if (rs.next()) {
        jmlStokHampirHabis.setText(rs.getString("jumlah_barang_stok_kurang_atau_sama_dengan_10"));
      }
    } catch (SQLException e) {
      System.err.println("Error: " + e.getMessage());
      e.printStackTrace();
    }
  }

  private void tableData(String query) {
    tableModel.setRowCount(0);
    try {
      Statement stm = conn.createStatement();
      ResultSet rs = stm.executeQuery(query);
      int no = 1;

      while (rs.next()) {
        Object[] obj = new Object[15];
        obj[0] = no++;
        obj[1] = rs.getString("id");
        obj[2] = rs.getString("tanggal_terima");
        obj[3] = rs.getString("nama");
        obj[4] = rs.getString("no_faktur");
        obj[5] = rs.getString("tanggal_faktur");
        obj[6] = rs.getString("nama_barang");
        obj[7] = rs.getString("tanggal_kedaluwarsa");
        obj[8] = rs.getString("batch");
        obj[9] = rs.getString("qty");
        obj[10] = rs.getString("harga_satuan");
        obj[11] = rs.getString("harga_total");
        obj[12] = rs.getString("harga_jual");
        obj[13] = rs.getString("jatuh_tempo");
        obj[14] = rs.getString("tanggal_lunas");
        tableModel.addRow(obj);
      }
      tabelDataBarang.setModel(tableModel);
      tabelDataBarang.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      tabelDataBarang.getColumnModel().getColumn(1).setMinWidth(0);
      tabelDataBarang.getColumnModel().getColumn(1).setMaxWidth(0);
      tabelDataBarang.getColumnModel().getColumn(1).setWidth(0);
      TableColumnAdjuster tca = new TableColumnAdjuster(tabelDataBarang);
      tca.adjustColumns();
      txtCariBarang.setText("");
    } catch (SQLException e) {
      System.err.println("Error: " + e.getMessage());
      e.printStackTrace();
    }
  }

  private StringBuilder getsBarangIdFromTable(int[] selectedRows) {
    StringBuilder barangId = new StringBuilder();
    for (int row : selectedRows) {
      Object value = tableModel.getValueAt(row, 1);
      barangId.append(value).append(",");
    }
    if (barangId.length() > 0) {
      barangId.deleteCharAt(barangId.length() - 1);
    }

    return barangId;
  }

  private String getsNoFakturFromTable(int[] selectedRows) {
    String noFaktur = "";
    HashSet<String> noFakturValues = new HashSet<>();
    for (int row : selectedRows) {
      Object value = tableModel.getValueAt(row, 4);
      if (value != null) {
        noFakturValues.add(value.toString());
      }
    }
    if (noFakturValues.size() == 1) {
      Iterator<String> iterator = noFakturValues.iterator();
      noFaktur = iterator.next();
    }

    return noFaktur;
  }

}
