/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.repository;

import DBConnect.DBConnect_An;
import Model.Model_Khach_Hang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import main.entity.KhachHang;

/**
 *
 * @author ADMIN
 */
public class ThemThongTinKhachHangRepository {
    public ArrayList<KhachHang> getAll() {
        // B1: Tao cau SQL 
        String sql = "select id,ma_khach_hang,ho_ten,so_dien_thoai,gioi_tinh,ngay_sinh,email,dia_chi,ngay_tao from KhachHang\n"
                + "where trang_thai = 1";

        ArrayList<KhachHang> lists = new ArrayList<>();
        // B2: Mo cong ket noi 
        // try...with..resource => Tu dong cong ket noi sql
        try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            // table => ResultSet
            ResultSet rs = ps.executeQuery();
            // Doi vs cac cau SQL
            // su dung excuteQuery => tra ve 1 bang(resultset)

            while (rs.next()) {
                lists.add(new KhachHang(
                        rs.getInt("id"),
                        rs.getString("ma_khach_hang"),
                        rs.getString("ho_ten"),
                        rs.getString("so_dien_thoai"),
                        rs.getBoolean("gioi_tinh"),
                        rs.getString("ngay_sinh"),
                        rs.getString("email"),
                        rs.getString("dia_chi"),
                        rs.getString("ngay_tao")));
            }

        } catch (Exception e) {
            // loi => nhay vao catch
            e.printStackTrace(System.out);
        }
        return lists;
    }
    public boolean add(KhachHang kh) {
        int check = 0;
        String sql = "insert into KhachHang(ho_ten,so_dien_thoai,gioi_tinh,ngay_sinh,dia_chi,email)\n"
                + "values(?,?,?,?,?,?)";

        try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, kh.getHoTen());
            ps.setObject(2, kh.getSoDienThoai());
            ps.setObject(3, kh.isGioiTinh());
            ps.setObject(4, kh.getNgaySinh());
            ps.setObject(5, kh.getDiaChi());
            ps.setObject(6, kh.getEmail());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    public KhachHang getKhachHangById(int id) {
    String sql = "SELECT id, ma_khach_hang, ho_ten, so_dien_thoai, gioi_tinh, ngay_sinh, email, dia_chi, ngay_tao " +
                 "FROM KhachHang WHERE trang_thai = 1 AND id = ?";
    
    try (Connection con = DBConnect_An.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        // Gán giá trị cho tham số
        ps.setInt(1, id);

        // Thực thi câu lệnh truy vấn
        ResultSet rs = ps.executeQuery();

        // Xử lý kết quả
        if (rs.next()) {
            return new KhachHang(
                rs.getInt("id"),
                rs.getString("ma_khach_hang"),
                rs.getString("ho_ten"),
                rs.getString("so_dien_thoai"),
                rs.getBoolean("gioi_tinh"),
                rs.getString("ngay_sinh"),
                rs.getString("email"),
                rs.getString("dia_chi"),
                rs.getString("ngay_tao")
            );
        }
    } catch (Exception e) {
        e.printStackTrace(System.out);
    }
    return null;
}
    public ArrayList<KhachHang> timSDT(String SDTcantim){
        
       String sql = "select id,ma_khach_hang,ho_ten,ngay_sinh,gioi_tinh,email,so_dien_thoai,dia_chi,ngay_tao from KhachHang where so_dien_thoai like ? ";
        
       ArrayList<KhachHang> lists = new ArrayList<>();
       try (
        Connection con = DBConnect_An.getConnection();
        PreparedStatement ps = con.prepareStatement(sql))
       {
        
        // Gán giá trị cho tham số
        ps.setString(1,"%"+SDTcantim+"%");

        // Thực thi câu lệnh truy vấn
        ResultSet rs = ps.executeQuery();

        // Xử lý kết quả
        while (rs.next()) {
                lists.add(new KhachHang(
                        rs.getInt("id"),
                        rs.getString("ma_khach_hang"),
                        rs.getString("ho_ten"),
                        rs.getString("so_dien_thoai"),
                        rs.getBoolean("gioi_tinh"),
                        rs.getString("ngay_sinh"),
                        rs.getString("email"),
                        rs.getString("dia_chi"),
                        rs.getString("ngay_tao")));
            }
        return lists;
    } catch (Exception e) {
        e.printStackTrace(System.out);
    }
    return null;

    }
    public int updateKhachHang(int id_sua, KhachHang ml){
      // cần biết id, đối tượng mới đọc từ form để sửa
       String sql = "UPDATE KhachHang \n" +
"SET \n" +

"    ho_ten = ?, \n" +
"    ngay_sinh = ?, \n" +
"    gioi_tinh = ?, \n" +
"    email = ?, \n" +
"    so_dien_thoai = ?, \n" +
"    dia_chi = ? \n" +
"WHERE id = ?; " 
                 ;
      try {
        Connection con= DBConnect_An.getConnection();
        PreparedStatement ps=con.prepareStatement(sql);
        // nếu có ? trong sql thì bắt buộc phải set
        ps.setObject(1, ml.getHoTen());
        ps.setObject(2, ml.getNgaySinh());
        ps.setObject(3, ml.isGioiTinh());
        ps.setObject(4, ml.getEmail());
        ps.setObject(5, ml.getSoDienThoai());
        ps.setObject(6, ml.getDiaChi());
        ps.setObject(7, id_sua);
        
        return ps.executeUpdate();//thêm/sửa/xóa: executeUpdate();
    } catch (Exception e) {// k xóa được
        e.printStackTrace();
        return 0;
    }
   
     }
}
