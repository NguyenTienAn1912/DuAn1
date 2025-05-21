/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframe;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import main.entity.HangSX;
import main.entity.ThuocTinhSanPham;
import main.repository.DungTichRepository;
import main.repository.HangSXRepository;
import main.repository.ThuocTinhSanPhamRepository;
/**
 *
 * @author ADMIN
 */
public class ThemHangSX extends javax.swing.JFrame {
    private DefaultTableModel dtmThuocTinhSanPham;
    private ThuocTinhSanPhamRepository thuocTinhSanPhamRepository = new ThuocTinhSanPhamRepository();
    private HangSXRepository  repoHangSX = new HangSXRepository();
    /**
     * Creates new form ThemTenSP
     */
    public ThemHangSX() {
        initComponents();
        setTitle("Thêm Hãng Sản Xuất");
        setLocationRelativeTo(null);
    }
    private ThuocTinhSanPham getFormdataThuocTinhSP(){
        String tenHangSX = txt_tenhangSX.getText().trim();
        tenHangSX = tenHangSX.split(" ") [0];
        if(txt_tenhangSX.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập tên thuộc tính", "Lỗi Nhập Liệu", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        if (!tenHangSX.matches("^[\\p{L}\\s\\d]+$")) {
            JOptionPane.showMessageDialog(null, "Tên thuộc tính không được chứa ký tự đặc biệt", "Lỗi Nhập Liệu", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        if (tenHangSX.length() > 50) {
            JOptionPane.showMessageDialog(null, "Tên thuộc tính không được vượt quá 50 ký tự", "Lỗi Nhập Liệu", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        if (repoHangSX.isHangSanXuatExist(tenHangSX)) {
            JOptionPane.showMessageDialog(null, "Tên thuộc tính đã tồn tại", "Lỗi Nhập Liệu", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        ThuocTinhSanPham ttsp = new ThuocTinhSanPham();
        ttsp.setMaThuocTinhSanPham(txt_maHangSX.getText());
        ttsp.setTenThuocTinhSanPham(txt_tenhangSX.getText());
        return ttsp;
    }
    private void showTableThuocTinhSanPham(ArrayList<ThuocTinhSanPham> lists){
            dtmThuocTinhSanPham.setRowCount(0);
            AtomicInteger index = new AtomicInteger(1);
            lists.forEach(s -> dtmThuocTinhSanPham.addRow(new Object[]{
            index.getAndIncrement(), s.getMaThuocTinhSanPham(), s.getTenThuocTinhSanPham(),}));
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneBorder1 = new View.swing.PaneBorder();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_maHangSX = new javax.swing.JTextField();
        btn_Thêm1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_tenhangSX = new javax.swing.JTextField();
        btn_Huy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        paneBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("THÊM HÃNG SẢN XUẤT");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tên Hãng SX:");

        txt_maHangSX.setBackground(new java.awt.Color(204, 204, 204));
        txt_maHangSX.setEnabled(false);
        txt_maHangSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maHangSXActionPerformed(evt);
            }
        });

        btn_Thêm1.setBackground(new java.awt.Color(102, 102, 255));
        btn_Thêm1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Thêm1.setForeground(new java.awt.Color(255, 255, 255));
        btn_Thêm1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/ADD.png"))); // NOI18N
        btn_Thêm1.setText("THÊM MỚI");
        btn_Thêm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Thêm1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Mã Hãng SX:");

        txt_tenhangSX.setBackground(new java.awt.Color(204, 204, 204));
        txt_tenhangSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenhangSXActionPerformed(evt);
            }
        });

        btn_Huy.setBackground(new java.awt.Color(102, 102, 255));
        btn_Huy.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Huy.setForeground(new java.awt.Color(255, 255, 255));
        btn_Huy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/RESET.png"))); // NOI18N
        btn_Huy.setText("Hủy");
        btn_Huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneBorder1Layout = new javax.swing.GroupLayout(paneBorder1);
        paneBorder1.setLayout(paneBorder1Layout);
        paneBorder1Layout.setHorizontalGroup(
            paneBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneBorder1Layout.createSequentialGroup()
                .addGroup(paneBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneBorder1Layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_tenhangSX, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txt_maHangSX, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneBorder1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(btn_Thêm1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Huy)
                .addGap(63, 63, 63))
        );
        paneBorder1Layout.setVerticalGroup(
            paneBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneBorder1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(paneBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_maHangSX, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paneBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_tenhangSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(paneBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Thêm1)
                    .addComponent(btn_Huy))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_Thêm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Thêm1ActionPerformed
        // TODO add your handling code here:
          ThuocTinhSanPham ttsp = getFormdataThuocTinhSP();
            if(ttsp !=null){
                if(thuocTinhSanPhamRepository.insertHangSX(ttsp)){
                    JOptionPane.showMessageDialog(null, "Thêm thuộc tính sản phẩm thành công");
                this.dispose();
                }else{
                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
                this.dispose();
                }
            }
                    
    }//GEN-LAST:event_btn_Thêm1ActionPerformed

    private void txt_tenhangSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenhangSXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenhangSXActionPerformed

    private void txt_maHangSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maHangSXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maHangSXActionPerformed

    private void btn_HuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HuyActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btn_HuyActionPerformed

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
            java.util.logging.Logger.getLogger(ThemHangSX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemHangSX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemHangSX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemHangSX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemHangSX().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Huy;
    private javax.swing.JButton btn_Thêm1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private View.swing.PaneBorder paneBorder1;
    private javax.swing.JTextField txt_maHangSX;
    private javax.swing.JTextField txt_tenhangSX;
    // End of variables declaration//GEN-END:variables
}
