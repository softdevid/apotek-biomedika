package frames;

import config.MySQLConnection;
import config.TableColumnAdjuster;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ZAFL
 */
public class PBFDistributor extends javax.swing.JInternalFrame {

  Connection conn = (Connection) MySQLConnection.connectDB();

  /**
   * Creates new form PBFDistributor
   */
  public PBFDistributor() {
    initComponents();
    ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
    ((BasicInternalFrameUI) this.getUI()).setEastPane(null);
    ((BasicInternalFrameUI) this.getUI()).setSouthPane(null);
    ((BasicInternalFrameUI) this.getUI()).setWestPane(null);
    this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

    // init table
    initTable();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    dialogTambah = new javax.swing.JDialog();
    jLabel3 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    txtNama = new javax.swing.JTextField();
    jLabel6 = new javax.swing.JLabel();
    txtTelp = new javax.swing.JTextField();
    jLabel7 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    txtAlamat = new javax.swing.JTextArea();
    btnTambah = new javax.swing.JButton();
    btnClear = new javax.swing.JButton();
    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    btnTambahBarang = new javax.swing.JButton();
    jLabel4 = new javax.swing.JLabel();
    txtCariBarang = new javax.swing.JTextField();
    jScrollPane = new javax.swing.JScrollPane();
    tabelDataBarang = new javax.swing.JTable() {
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };

    dialogTambah.setTitle("Form Tambah");
    dialogTambah.setMinimumSize(new java.awt.Dimension(475, 530));

    jLabel3.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
    jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel3.setText("Form Tambah");

    jLabel5.setText("Nama");

    jLabel6.setText("No Telepon");

    jLabel7.setText("Alamat");

    txtAlamat.setColumns(20);
    txtAlamat.setRows(5);
    jScrollPane1.setViewportView(txtAlamat);

    btnTambah.setText("Tambah");
    btnTambah.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnTambahActionPerformed(evt);
      }
    });

    btnClear.setText("Clear");
    btnClear.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnClearActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout dialogTambahLayout = new javax.swing.GroupLayout(dialogTambah.getContentPane());
    dialogTambah.getContentPane().setLayout(dialogTambahLayout);
    dialogTambahLayout.setHorizontalGroup(
      dialogTambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(dialogTambahLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(dialogTambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(dialogTambahLayout.createSequentialGroup()
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(dialogTambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(dialogTambahLayout.createSequentialGroup()
                .addComponent(btnTambah)
                .addGap(18, 18, 18)
                .addComponent(btnClear))
              .addGroup(dialogTambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jLabel7)
                .addComponent(jLabel6)
                .addComponent(jLabel5)
                .addComponent(txtNama)
                .addComponent(txtTelp)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(0, 107, Short.MAX_VALUE)))
        .addContainerGap())
    );
    dialogTambahLayout.setVerticalGroup(
      dialogTambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(dialogTambahLayout.createSequentialGroup()
        .addGap(26, 26, 26)
        .addComponent(jLabel3)
        .addGap(40, 40, 40)
        .addComponent(jLabel5)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jLabel6)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(txtTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jLabel7)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(40, 40, 40)
        .addGroup(dialogTambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnTambah)
          .addComponent(btnClear))
        .addContainerGap(116, Short.MAX_VALUE))
    );

    setMinimumSize(new java.awt.Dimension(960, 540));

    jPanel1.setBackground(new java.awt.Color(208, 242, 255));

    jLabel1.setText("Tambah Distributor");

    btnTambahBarang.setText("Tambah");
    btnTambahBarang.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnTambahBarangActionPerformed(evt);
      }
    });

    jLabel4.setText("Cari");

    txtCariBarang.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        txtCariBarangKeyReleased(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addGap(34, 34, 34)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel1)
          .addComponent(jLabel4))
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(txtCariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnTambahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(902, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(20, 20, 20)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(btnTambahBarang))
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel4)
          .addComponent(txtCariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(20, Short.MAX_VALUE))
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
    jScrollPane.setViewportView(tabelDataBarang);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jScrollPane))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnTambahBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahBarangActionPerformed
    dialogTambah.setLocationRelativeTo(null);
    dialogTambah.setVisible(true);
  }//GEN-LAST:event_btnTambahBarangActionPerformed

  private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
    String nama = txtNama.getText();
    String noTelp = txtTelp.getText();
    String alamat = txtAlamat.getText();

    if (nama.isEmpty()) {
      JOptionPane.showMessageDialog(null, "Masukkan nama");
    } else if (noTelp.isEmpty()) {
      JOptionPane.showMessageDialog(null, "Masukkan nomor telepon");
    } else if (alamat.isEmpty()) {
      JOptionPane.showMessageDialog(null, "Masukkan alamat");
    } else {
      String query = "INSERT INTO `pbf_distributor` (`nama`, `no_telp`, `alamat`) VALUES  ('" + nama + "', '" + noTelp + "', '" + alamat + "')";

      try {
        PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
      } catch (HeadlessException | SQLException e) {
        System.err.println("Error: " + e.getMessage());
      }
    }
  }//GEN-LAST:event_btnTambahActionPerformed

  private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
    txtNama.setText("");
    txtTelp.setText("");
    txtAlamat.setText("");
  }//GEN-LAST:event_btnClearActionPerformed

  private void txtCariBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariBarangKeyReleased
    String keyword = txtCariBarang.getText();

    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("No");
    model.addColumn("Nama Distributor");
    model.addColumn("Nomor Telepon");
    model.addColumn("Alamat");

    try {
      String query = "SELECT id, nama, no_telp, alamat FROM pbf_distributor WHERE nama LIKE '%" + keyword + "%'";
      Statement stm = conn.createStatement();
      ResultSet rs = stm.executeQuery(query);

      while (rs.next()) {
        Object[] obj = new Object[4];
        obj[0] = rs.getString("id");
        obj[1] = rs.getString("nama");
        obj[2] = rs.getString("no_telp");
        obj[3] = rs.getString("alamat");
        model.addRow(obj);
      }
      tabelDataBarang.setAutoCreateRowSorter(true);
      tabelDataBarang.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      tabelDataBarang.setModel(model);
      TableColumnAdjuster tca = new TableColumnAdjuster(tabelDataBarang);
      tca.adjustColumns();
    } catch (SQLException e) {
      System.err.println("Error: " + e.getMessage());
    }
  }//GEN-LAST:event_txtCariBarangKeyReleased


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnClear;
  private javax.swing.JButton btnTambah;
  private javax.swing.JButton btnTambahBarang;
  private javax.swing.JDialog dialogTambah;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable tabelDataBarang;
  private javax.swing.JTextArea txtAlamat;
  private javax.swing.JTextField txtCariBarang;
  private javax.swing.JTextField txtNama;
  private javax.swing.JTextField txtTelp;
  // End of variables declaration//GEN-END:variables

  private void initTable() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("No");
    model.addColumn("Nama Distributor");
    model.addColumn("Nomor Telepon");
    model.addColumn("Alamat");

    try {
      String query = "SELECT id, nama, no_telp, alamat FROM pbf_distributor";
      Statement stm = conn.createStatement();
      ResultSet rs = stm.executeQuery(query);

      while (rs.next()) {
        Object[] obj = new Object[4];
        obj[0] = rs.getString("id");
        obj[1] = rs.getString("nama");
        obj[2] = rs.getString("no_telp");
        obj[3] = rs.getString("alamat");
        model.addRow(obj);
      }
      tabelDataBarang.setAutoCreateRowSorter(true);
      tabelDataBarang.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      tabelDataBarang.setModel(model);
      TableColumnAdjuster tca = new TableColumnAdjuster(tabelDataBarang);
      tca.adjustColumns();
    } catch (SQLException e) {
      System.err.println("Error: " + e.getMessage());
    }
  }
}
