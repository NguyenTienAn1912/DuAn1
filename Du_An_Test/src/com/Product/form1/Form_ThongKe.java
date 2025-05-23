/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.Product.form1;

import Repository.Repository_Thongke;
import View.Model.Model_Card;
import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ADMIN
 */
public class Form_ThongKe extends javax.swing.JPanel {
    ArrayList<Model.Model_Thongke> lst;
    Repository_Thongke repo;
    private Component rootPane;
    /**
     * Creates new form Form_ThongKe
     */
    public Form_ThongKe() throws SQLException {
        initComponents();
        
        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/TuiTien1.png")), "Doanh Thu Tháng","VNĐ: ", "Thành Công:", "Đã Hủy:","","","",""));
        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/TuiTien.png")), "Doanh Thu Năm","VNĐ: ", "Thành Công:", "Đã Hủy:","","","",""));
        lst = new ArrayList();
        repo = new Repository_Thongke();
        getdata();
        loaddata();
    }
    
    public void getdata() throws SQLException {
        lst = repo.getdata();
    }
   
    public void loaddata() {
        
        String[] header = {"Tháng","Năm","Tổng sản phẩm","Tổng doanh thu trước GG","Tổng Giảm Giá ","Tổng doanh thu sau GG"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        tbl_DoanhThu.setModel(model);
        // Lấy ngày hiện tại
        LocalDate currentDate = LocalDate.now();
        
        // Lấy tháng và năm
        int currentMonth = currentDate.getMonthValue(); // Tháng hiện tại (1-12)
        int currentYear = currentDate.getYear(); 
        double tong =0 ;
        int tongSp = 0;
        double tongGG = 0;
        
        for (Model.Model_Thongke tk : lst) {
            
            Object[] row = {tk.getThang(),
                tk.getNam(),
                tk.getTongSP(),
                String.format("%,.3f VNĐ", tk.getTongDTTGG()),
                String.format("%,.3f VNĐ ", tk.getTongGG()), 
                String.format("%,.3f VNĐ ", tk.getTongDTSGG())};
            model.addRow(row);
            tong += tk.getTongDTSGG();
            tongSp += tk.getTongSP();
            tongGG += tk.getTongGG();
               
        }
        
        Model.Model_Thongke sp = lst.get(lst.size()-1);
        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/TuiTien1.png")),
                "Doanh Thu Tháng :",
                "Tổng Doanh Thu : ", 
                "Tổng Sản Phẩm :",
                "Tổng Giảm Giá :",
                String.valueOf(sp.getThang()),
                String.valueOf(String.format("%,.3f VNĐ", sp.getTongDTSGG())) ,
                String.valueOf( sp.getTongSP()),
                String.valueOf(String.format("%,.3f VNĐ", sp.getTongGG())) )
        );
        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/TuiTien.png")), 
                "Doanh Thu Năm :",
                "Tổng Doanh Thu: ",
                "Tổng Sản Phẩm :",
                "Tổng Giảm Giá",
                String.valueOf(sp.getNam()),
                String.valueOf(String.format("%,.3f VNĐ", tong)),
                String.valueOf(tongSp),
                String.valueOf(String.format("%,.3f VNĐ", tongGG)))
        );
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        card1 = new com.Product.compoment.Card();
        card2 = new com.Product.compoment.Card();
        paneBorder1 = new View.swing.PaneBorder();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_DoanhThu = new View.swing.Table();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_TimKiem = new javax.swing.JButton();
        btn_TimKiem1 = new javax.swing.JButton();
        ngayBatDau = new com.toedter.calendar.JDateChooser();
        ngayKetThuc = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("THỐNG KÊ");

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setForeground(new java.awt.Color(255, 255, 255));
        panel.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        card1.setBackground(new java.awt.Color(255, 255, 102));
        card1.setForeground(new java.awt.Color(255, 204, 51));
        card1.setColor1(new java.awt.Color(102, 102, 255));
        card1.setColor2(new java.awt.Color(0, 153, 204));
        panel.add(card1);

        card2.setBackground(new java.awt.Color(255, 51, 51));
        card2.setForeground(new java.awt.Color(255, 51, 51));
        card2.setColor1(new java.awt.Color(255, 51, 51));
        card2.setColor2(new java.awt.Color(255, 102, 51));
        panel.add(card2);

        paneBorder1.setBackground(new java.awt.Color(255, 255, 255));
        paneBorder1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(127, 127, 127));
        jLabel2.setText("Tra cứu thông tin");

        tbl_DoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Tháng", "Năm", "Tổng Sản Phẩm Bán", "Tổng Doanh Thu Trước Giảm Giá", "Tổng Giá Giảm", "Tổng Doanh Thu Sau Giảm Giá"
            }
        ));
        tbl_DoanhThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DoanhThuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_DoanhThu);
        if (tbl_DoanhThu.getColumnModel().getColumnCount() > 0) {
            tbl_DoanhThu.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        jTabbedPane1.addTab("Doanh Thu", jScrollPane1);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(127, 127, 127));
        jLabel4.setText("Ngày bắt đầu:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(127, 127, 127));
        jLabel5.setText("Ngày kết thúc: ");

        btn_TimKiem.setBackground(new java.awt.Color(102, 102, 255));
        btn_TimKiem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_TimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btn_TimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Timkiem.png"))); // NOI18N
        btn_TimKiem.setText("TÌM KIẾM");
        btn_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimKiemActionPerformed(evt);
            }
        });

        btn_TimKiem1.setBackground(new java.awt.Color(102, 102, 255));
        btn_TimKiem1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_TimKiem1.setForeground(new java.awt.Color(255, 255, 255));
        btn_TimKiem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/BaoCao.png"))); // NOI18N
        btn_TimKiem1.setText("BÁO CÁO DOANH THU");
        btn_TimKiem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimKiem1ActionPerformed(evt);
            }
        });

        ngayBatDau.setDateFormatString("yyyy-MM-dd");

        ngayKetThuc.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout paneBorder1Layout = new javax.swing.GroupLayout(paneBorder1);
        paneBorder1.setLayout(paneBorder1Layout);
        paneBorder1Layout.setHorizontalGroup(
            paneBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneBorder1Layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1069, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(paneBorder1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ngayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ngayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(paneBorder1Layout.createSequentialGroup()
                        .addGroup(paneBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(btn_TimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        paneBorder1Layout.setVerticalGroup(
            paneBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneBorder1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(paneBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(paneBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(btn_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ngayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ngayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(btn_TimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(480, 480, 480)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
                    .addComponent(paneBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimKiemActionPerformed
            String dateBD =  new SimpleDateFormat("yyyy-MM-dd").format(ngayBatDau.getDate());
            java.sql.Date dateBD2 = java.sql.Date.valueOf(dateBD);
                  
                      
            String dateKT =  new SimpleDateFormat("yyyy-MM-dd").format(ngayKetThuc.getDate());
            java.sql.Date dateKT2 = java.sql.Date.valueOf(dateKT);
            
            boolean check = true;
            System.out.print(dateBD);
            if(ngayBatDau.getDate() == null ){
                JOptionPane.showMessageDialog(rootPane, "Ngày bắt đầu không được để trống");
                ngayBatDau.requestFocus();
                check = false;
            }
            else if(ngayKetThuc.getDate() == null){
                JOptionPane.showMessageDialog(rootPane, "Ngày kết thúc không được để trống");
                ngayKetThuc.requestFocus();
                check = false;
            }else if(ngayKetThuc.getDate().before(ngayBatDau.getDate())){
                JOptionPane.showMessageDialog(rootPane, "Không thể tìm kiếm ngày kết thúc trước ngày bắt đầu ");
                ngayKetThuc.requestFocus();
                check = false;
            }
            if(check == true){
                try {
        if(repo.timKiem(dateBD2,dateKT2).isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Không tìm thấy kết quả ");
            getdata();
            loaddata();
        }
        else{
            lst = repo.timKiem(dateBD2,dateKT2);
            loaddata();
        }
    } catch (SQLException ex) {
        Logger.getLogger(Form_KhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
    }
            }
    }//GEN-LAST:event_btn_TimKiemActionPerformed

    private void btn_TimKiem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimKiem1ActionPerformed
        try
        {
        XSSFWorkbook wordkbook = new XSSFWorkbook();
        XSSFSheet sheet=wordkbook.createSheet("ThongKe");
        XSSFRow row = null;
        Cell cell= null;
        row=sheet.createRow(2);
        cell=row.createCell(0,CellType.STRING);
        cell.setCellValue("DANH SÁCH THỐNG KÊ ");
        
        row=sheet.createRow(5);
        cell=row.createCell(0,CellType.STRING);
        cell.setCellValue("THÁNG ");
        
        cell=row.createCell(1,CellType.STRING);
        cell.setCellValue("NĂM");
        
        cell=row.createCell(2,CellType.STRING);
        cell.setCellValue("TỔNG SẢN PHẨM ");
        
        cell=row.createCell(3,CellType.STRING);
        cell.setCellValue("TỔNG DOANH THU TRƯỚC GIẢM GIÁ ");
        
        cell=row.createCell(4,CellType.STRING);
        cell.setCellValue("TỔNG GIẢM GIÁ");
        
        cell=row.createCell(5,CellType.STRING);
        cell.setCellValue("TỔNG DOANH THU SAU GIẢM GIÁ ");
        
        for(int i=0; i<lst.size(); i++)
        {
            //Modelbook book =arr.get(i);
            row=sheet.createRow(6+i);
           
            cell=row.createCell(0,CellType.NUMERIC);
            cell.setCellValue(i+1);
            
            cell=row.createCell(1,CellType.NUMERIC);
            cell.setCellValue(lst.get(i).getThang());
            
            
            cell=row.createCell(2,CellType.NUMERIC);
            cell.setCellValue(lst.get(i).getNam());
            
            cell=row.createCell(3,CellType.NUMERIC);
            cell.setCellValue(lst.get(i).getTongSP());
            
            cell=row.createCell(4,CellType.NUMERIC);
            cell.setCellValue(lst.get(i).getTongDTTGG());
            
            cell=row.createCell(5,CellType.NUMERIC);
            cell.setCellValue(lst.get(i).getTongGG());
            
            cell=row.createCell(6,CellType.NUMERIC);
            cell.setCellValue(lst.get(i).getTongDTSGG());
                                  
        }
        
        File f = new File("D:\\ThongKe.xlsx");
        try 
        {
            FileOutputStream fis = new FileOutputStream(f);
            wordkbook.write(fis);
            fis.close();
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
       
        }
        catch (IOException ex)
        {
          ex.printStackTrace();
        }
        
        
        JOptionPane.showMessageDialog(this, "IN THÀNH CÔNG D:\\DANHSACHTHONGKE");
        
        }
        
        
        catch(Exception ex)
        {
            ex.printStackTrace();
              JOptionPane.showMessageDialog(this, "Lỗi mở file");
        }
    }//GEN-LAST:event_btn_TimKiem1ActionPerformed

    private void tbl_DoanhThuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DoanhThuMouseClicked
        int selectedRow = tbl_DoanhThu.getSelectedRow();
        if(selectedRow >= 0){
           Model.Model_Thongke sp = lst.get(selectedRow);
            card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/TuiTien1.png")),
                "Doanh Thu Tháng :",
                "Tổng Doanh Thu : ", 
                "Tổng Hoá Đơn :",
                "Tổng Giảm Giá :",
                String.valueOf(sp.getThang()),
                String.valueOf(String.format("%,.3f VNĐ", sp.getTongDTSGG())) ,
                String.valueOf( sp.getTongSP()),
                String.valueOf(String.format("%,.3f VNĐ", sp.getTongGG())) )
        );           
        }
        tbl_DoanhThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DoanhThuMouseClicked(evt);
            }
        }
        );
        
    }//GEN-LAST:event_tbl_DoanhThuMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.JButton btn_TimKiem1;
    private com.Product.compoment.Card card1;
    private com.Product.compoment.Card card2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JDateChooser ngayBatDau;
    private com.toedter.calendar.JDateChooser ngayKetThuc;
    private View.swing.PaneBorder paneBorder1;
    private javax.swing.JPanel panel;
    private View.swing.Table tbl_DoanhThu;
    // End of variables declaration//GEN-END:variables
}
