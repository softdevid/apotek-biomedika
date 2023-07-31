package frames;

import config.MySQLConnection;
import config.TableColumnAdjuster;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import utility.DataPencarian;
import utility.EventClick;
import utility.PanelPencarian;

/**
 *
 * @author ZAFL
 */
public class Penjualan extends javax.swing.JInternalFrame {

  private JPopupMenu menu;
  private PanelPencarian pnlPencarian;

  Connection conn = (Connection) MySQLConnection.connectDB();
  Date date = new Date();
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
  NumberFormat kurensiIndonesia = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));

  /**
   * Creates new form Penjualan
   */
  public Penjualan() {
    initComponents();
    ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
    ((BasicInternalFrameUI) this.getUI()).setEastPane(null);
    ((BasicInternalFrameUI) this.getUI()).setSouthPane(null);
    ((BasicInternalFrameUI) this.getUI()).setWestPane(null);
    this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

    menu = new JPopupMenu();
    pnlPencarian = new PanelPencarian();
    menu.add(pnlPencarian);
    menu.setFocusable(false);
    pnlPencarian.addEventClick(new EventClick() {
      @Override
      public void itemClick(DataPencarian data) {
        menu.setVisible(false);
        getDataBarang(data.getText());
        txtCariBarang.setText("");
      }
    });

    getNomorFaktur();
    totalHarga();
    loadTabelPenjualanDetail();
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
    lblCariBarang = new javax.swing.JLabel();
    txtCariBarang = new javax.swing.JTextField();
    lblNoFaktur = new javax.swing.JLabel();
    txtNoFaktur = new javax.swing.JTextField();
    jPanel2 = new javax.swing.JPanel();
    totalHarga = new javax.swing.JLabel();
    jPanel4 = new javax.swing.JPanel();
    lblNama = new javax.swing.JLabel();
    txtNama = new javax.swing.JTextField();
    lblBatch = new javax.swing.JLabel();
    txtBatch = new javax.swing.JTextField();
    lblQty = new javax.swing.JLabel();
    txtQty = new javax.swing.JTextField();
    lblHrgJual = new javax.swing.JLabel();
    txtHrgJual = new javax.swing.JFormattedTextField(NumberFormat.getInstance(Locale.GERMANY));
    lblTglKdlwrs = new javax.swing.JLabel();
    txtTglKdlwrs = new javax.swing.JTextField();
    jScrollPane1 = new javax.swing.JScrollPane();
    tablePenjualan = new javax.swing.JTable();
    jPanel5 = new javax.swing.JPanel();
    jLabel14 = new javax.swing.JLabel();
    jLabel15 = new javax.swing.JLabel();
    txtBayar = new javax.swing.JFormattedTextField(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
    txtKembali = new javax.swing.JFormattedTextField();

    setMinimumSize(new java.awt.Dimension(960, 540));
    setPreferredSize(new java.awt.Dimension(1280, 720));

    jPanel1.setBackground(new java.awt.Color(208, 242, 255));

    lblCariBarang.setText("Cari Barang");

    txtCariBarang.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        txtCariBarangMouseClicked(evt);
      }
    });
    txtCariBarang.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        txtCariBarangKeyReleased(evt);
      }
    });

    lblNoFaktur.setText("No Faktur");

    txtNoFaktur.setEditable(false);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap(14, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(lblCariBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(lblNoFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(31, 31, 31)))
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(txtNoFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(txtCariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(15, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lblCariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(txtCariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lblNoFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(txtNoFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(16, 16, 16))
    );

    jPanel2.setBackground(new java.awt.Color(208, 242, 255));

    totalHarga.setFont(new java.awt.Font("Roboto", 0, 48)); // NOI18N
    totalHarga.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    totalHarga.setText("0");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(totalHarga, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
        .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(totalHarga, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
        .addContainerGap())
    );

    jPanel4.setBackground(new java.awt.Color(208, 242, 255));

    lblNama.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
    lblNama.setText("Nama");

    txtNama.setEditable(false);

    lblBatch.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
    lblBatch.setText("Batch");

    txtBatch.setEditable(false);

    lblQty.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
    lblQty.setText("Qty");

    txtQty.setPreferredSize(new java.awt.Dimension(80, 22));
    txtQty.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        txtQtyKeyPressed(evt);
      }
    });

    lblHrgJual.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
    lblHrgJual.setText("Harga Jual");

    txtHrgJual.setEditable(false);

    lblTglKdlwrs.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
    lblTglKdlwrs.setText("Tanggal Kedaluwarsa");

    txtTglKdlwrs.setEditable(false);

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
        .addGap(25, 25, 25)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lblNama))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lblBatch)
          .addComponent(txtBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lblQty))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(txtHrgJual, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lblHrgJual))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lblTglKdlwrs)
          .addComponent(txtTglKdlwrs, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel4Layout.setVerticalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
        .addContainerGap(12, Short.MAX_VALUE)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(lblNama)
          .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(lblHrgJual)
            .addComponent(lblQty)
            .addComponent(lblTglKdlwrs))
          .addComponent(lblBatch))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(txtBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(txtHrgJual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(txtTglKdlwrs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(11, 11, 11))
    );

    tablePenjualan.setModel(new javax.swing.table.DefaultTableModel(
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
    jScrollPane1.setViewportView(tablePenjualan);

    jPanel5.setBackground(new java.awt.Color(208, 242, 255));

    jLabel14.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
    jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel14.setText("BAYAR");

    jLabel15.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
    jLabel15.setText("KEMBALI");

    txtBayar.addCaretListener(new javax.swing.event.CaretListener() {
      public void caretUpdate(javax.swing.event.CaretEvent evt) {
        txtBayarCaretUpdate(evt);
      }
    });
    txtBayar.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        txtBayarFocusGained(evt);
      }
    });
    txtBayar.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        txtBayarKeyPressed(evt);
      }
      public void keyReleased(java.awt.event.KeyEvent evt) {
        txtBayarKeyReleased(evt);
      }
    });

    txtKembali.setEditable(false);

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
        .addContainerGap(839, Short.MAX_VALUE)
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
        .addGap(26, 26, 26)
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(txtBayar)
          .addComponent(txtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(40, 40, 40))
    );
    jPanel5Layout.setVerticalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel5Layout.createSequentialGroup()
        .addContainerGap(23, Short.MAX_VALUE)
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(jPanel5Layout.createSequentialGroup()
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(18, 18, 18)
            .addComponent(jLabel15))
          .addGroup(jPanel5Layout.createSequentialGroup()
            .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(txtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(24, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addComponent(jScrollPane1)
          .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void txtCariBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCariBarangMouseClicked
    if (pnlPencarian.getItemSize() > 0) {
      menu.show(txtCariBarang, 0, txtCariBarang.getHeight());
    }
  }//GEN-LAST:event_txtCariBarangMouseClicked

  private void txtCariBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariBarangKeyReleased
    String text = txtCariBarang.getText().trim().toLowerCase();
    pnlPencarian.setData(pencarian(text));
    if (pnlPencarian.getItemSize() > 0) {
      menu.show(txtCariBarang, 0, txtCariBarang.getHeight());
      menu.setPopupSize(menu.getWidth(), (pnlPencarian.getItemSize() * 30) + 2);
    } else {
      menu.setVisible(false);
    }
  }//GEN-LAST:event_txtCariBarangKeyReleased

  private void txtBayarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtBayarCaretUpdate
    if (txtBayar.getText().length() != 0) {
      double value = 0;
      String total = totalHarga.getText();

      try {
        Number parsedNumber = kurensiIndonesia.parse(total);
        value = parsedNumber.doubleValue();
      } catch (ParseException e) {
        System.out.println("Kesalahan dalam parsing format mata uang.");
      }

      String bayar = txtBayar.getText().replace(".", "");
      double pembayaran = Double.parseDouble(bayar);
      System.out.println(pembayaran);

      if (!bayar.isEmpty()) {
        double kembalian = pembayaran - value;
        txtKembali.setText(kurensiIndonesia.format(kembalian));
      }
    }
  }//GEN-LAST:event_txtBayarCaretUpdate

  private void txtBayarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBayarFocusGained
    txtBayar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
  }//GEN-LAST:event_txtBayarFocusGained

  private void txtBayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBayarKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER && !txtBayar.getText().isEmpty()) {
      String noFaktur = txtNoFaktur.getText();
      double bayar = Double.parseDouble(txtBayar.getText().replace(".", ""));
      try {
        double valueTotal = 0;
        String total = totalHarga.getText();

        try {
          Number parsedNumber = kurensiIndonesia.parse(total);
          valueTotal = parsedNumber.doubleValue();
        } catch (ParseException e) {
          System.out.println("Kesalahan dalam parsing format mata uang.");
        }

        String query = "INSERT INTO `penjualan`(`tanggal_jual`, `no_faktur`, `total`, `bayar`) "
                + "VALUES (CURRENT_DATE(),'" + noFaktur + "','" + valueTotal + "','" + bayar + "')";
        PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
        ps.executeUpdate();

        getNomorFaktur();
        loadTabelPenjualanDetail();
        totalHarga.setText(kurensiIndonesia.format(Double.parseDouble("0")));
        resetField();
        txtBayar.setText("0");
        txtKembali.setText(kurensiIndonesia.format(Double.parseDouble("0")));
      } catch (SQLException ex) {
        System.err.println("Error: " + ex.getMessage());
      }
    }
  }//GEN-LAST:event_txtBayarKeyPressed

  private void txtBayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBayarKeyReleased
    if (txtBayar.getText().length() >= 1) {
      String text = txtBayar.getText().replace(",", "").replace(".", "");

      try {
        long number = Long.parseLong(text);
        String formattedText = String.format("%,d", number);
        txtBayar.setText(formattedText);
        int newCaretPosition = formattedText.length();
        txtBayar.setCaretPosition(newCaretPosition);
      } catch (NumberFormatException e) {
        System.err.println("Error: " + e.getMessage());
      }
    } else {
      txtBayar.setText("0");
      txtKembali.setText(kurensiIndonesia.format(Double.parseDouble("0")));
    }
  }//GEN-LAST:event_txtBayarKeyReleased

  private void txtQtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
      String noFaktur = txtNoFaktur.getText();
      String nama = txtNama.getText();
      String qty = txtQty.getText();
      String hrgJual = txtHrgJual.getText().replace(".", "");
      String tglKdlwrs = txtTglKdlwrs.getText();

      try {
        String query = "INSERT INTO `penjualan_detail`(`no_faktur`, `nama_barang`, `tanggal_kedaluwarsa`, `harga_jual`, `qty`) "
                + "VALUES ('" + noFaktur + "','" + nama + "','" + tglKdlwrs + "','" + hrgJual + "','" + qty + "')";
        PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
        ps.executeUpdate();

        loadTabelPenjualanDetail();
        totalHarga();
        resetField();
        txtCariBarang.requestFocus();
      } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());
      }
    }
  }//GEN-LAST:event_txtQtyKeyPressed

  private List<DataPencarian> pencarian(String pencarian) {
    List<DataPencarian> list = new ArrayList<>();
    try {
      PreparedStatement ps = conn.prepareStatement("SELECT dtbrg.id, dtbrg.nama_barang FROM data_barang dtbrg WHERE dtbrg.nama_barang LIKE ? ORDER BY dtbrg.nama_barang DESC LIMIT 7");
      ps.setString(1, "%" + pencarian + "%");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        String text = rs.getString(1) + " | " + rs.getString(2);
        list.add(new DataPencarian(text));
      }
      rs.close();
      ps.close();
    } catch (SQLException ex) {
      System.err.println(ex.getMessage());
    }

    return list;
  }


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jLabel14;
  private javax.swing.JLabel jLabel15;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JPanel jPanel5;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JLabel lblBatch;
  private javax.swing.JLabel lblCariBarang;
  private javax.swing.JLabel lblHrgJual;
  private javax.swing.JLabel lblNama;
  private javax.swing.JLabel lblNoFaktur;
  private javax.swing.JLabel lblQty;
  private javax.swing.JLabel lblTglKdlwrs;
  private javax.swing.JTable tablePenjualan;
  private javax.swing.JLabel totalHarga;
  private javax.swing.JTextField txtBatch;
  private javax.swing.JFormattedTextField txtBayar;
  private javax.swing.JTextField txtCariBarang;
  private javax.swing.JFormattedTextField txtHrgJual;
  private javax.swing.JFormattedTextField txtKembali;
  private javax.swing.JTextField txtNama;
  private javax.swing.JTextField txtNoFaktur;
  private javax.swing.JTextField txtQty;
  private javax.swing.JTextField txtTglKdlwrs;
  // End of variables declaration//GEN-END:variables

  private void getNomorFaktur() {
    SimpleDateFormat sdf2 = new SimpleDateFormat("ddMMyyyy");
    String tglSekarang = sdf2.format(date);

    String query = "SELECT `id` FROM `penjualan` ORDER BY `id` DESC";

    try {
      Statement stm = conn.createStatement();
      ResultSet rs = stm.executeQuery(query);

      if (rs.next()) {
        int no = Integer.parseInt(rs.getString("id")) + 1;
        txtNoFaktur.setText("SINV/" + tglSekarang + "/" + Integer.toString(no));
      } else {
        int no = 1;
        txtNoFaktur.setText("SINV/" + tglSekarang + "/" + Integer.toString(no));
      }
    } catch (NumberFormatException | SQLException e) {
      JOptionPane.showMessageDialog(null, e.getMessage());
    }
  }

  private void getDataBarang(String data) {
    int index = data.indexOf(" | ");
    String pembelian_id = (index != -1) ? data.substring(0, index) : data;
    String query = "SELECT id, nama_barang, batch, harga_jual, tanggal_kedaluwarsa FROM data_barang WHERE dtbrng.id = '" + pembelian_id + "'";
    try {
      Statement stm = conn.createStatement();
      ResultSet rs = stm.executeQuery(query);

      if (rs.next()) {
        txtNama.setText(rs.getString("nama_barang"));
        txtBatch.setText(rs.getString("batch"));
        txtHrgJual.setText(rs.getString("harga_jual"));
        txtTglKdlwrs.setText(rs.getString("tanggal_kedaluwarsa"));

        txtQty.requestFocus();
      }
    } catch (NumberFormatException | SQLException e) {
      JOptionPane.showMessageDialog(null, e.getMessage());
    }
  }

  private void loadTabelPenjualanDetail() {
    String noFaktur = txtNoFaktur.getText();

    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("No");
    model.addColumn("ID");
    model.addColumn("Nama Barang");
    model.addColumn("Tanggal Kedaluwarsa");
    model.addColumn("Harga Jual");
    model.addColumn("Qty");
    model.addColumn("Subtotal");

    try {
      int no = 1;
      String query = "SELECT `id`,`nama_barang`,`tanggal_kedaluwarsa`,`harga_jual`,`qty`, (`harga_jual`*`qty`) AS `subtotal` FROM `penjualan_detail` WHERE `no_faktur`='" + noFaktur + "'";
      Statement stm = conn.createStatement();
      ResultSet res = stm.executeQuery(query);

      while (res.next()) {
        double hrgJual = Double.parseDouble(res.getString("harga_jual"));
        double subtotal = Double.parseDouble(res.getString("subtotal"));

        Object[] o = new Object[7];
        o[0] = no++;
        o[1] = res.getString("id");
        o[2] = res.getString("nama_barang");
        o[3] = res.getString("tanggal_kedaluwarsa");
        o[4] = String.format("%,.2f", hrgJual);
        o[5] = res.getString("qty");
        o[6] = String.format("%,.2f", subtotal);

        model.addRow(o);
      }
      tablePenjualan.setModel(model);
      tablePenjualan.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      tablePenjualan.getColumnModel().getColumn(1).setMinWidth(0);
      tablePenjualan.getColumnModel().getColumn(1).setMaxWidth(0);
      tablePenjualan.getColumnModel().getColumn(1).setWidth(0);

      TableColumnAdjuster tca = new TableColumnAdjuster(tablePenjualan);
      tca.adjustColumns();
    } catch (NumberFormatException | SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  private void totalHarga() {
    String noFaktur = txtNoFaktur.getText();
    String query = "SELECT IFNULL( SUM(`harga_jual`*`qty`),0) AS `harga_total` FROM `penjualan_detail` WHERE `no_faktur`='" + noFaktur + "'";

    try {
      Statement stm = conn.createStatement();
      ResultSet res = stm.executeQuery(query);

      if (res.next()) {
        totalHarga.setText(kurensiIndonesia.format(Double.parseDouble(res.getString("harga_total"))));
      }
    } catch (NumberFormatException | SQLException e) {
      JOptionPane.showMessageDialog(null, e.getMessage());
    }
  }

  private void resetField() {
    txtNama.setText("");
    txtBatch.setText("");
    txtQty.setText("");
    txtHrgJual.setText("");
    txtTglKdlwrs.setText("");
  }
}