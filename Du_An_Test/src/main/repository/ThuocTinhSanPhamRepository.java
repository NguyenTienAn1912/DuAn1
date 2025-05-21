/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.repository;
import DBConnect.DBConnect_An;
import main.entity.ThuocTinhSanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ThuocTinhSanPhamRepository {

    public ArrayList<ThuocTinhSanPham> getAll() {
        ArrayList<ThuocTinhSanPham> list = new ArrayList<>();
        String sql = "select id, ma_phan_loai AS ma, ten_phan_loai from PhanLoai where trang_thai = 1 UNION ALL\n" +
                    "select id, ma_xuat_su AS ma , xuat_su from XuatSu where trang_thai = 1 UNION ALL\n" +
                    "select id, ma_nam_san_xuat AS ma , nam_san_xuat from NamSanXuat where trang_thai = 1 UNION ALL\n" +
                    "select id, ma_hang_san_xuat AS ma , ten_hang_san_xuat from HangSanXuat where trang_thai = 1 UNION ALL\n" +
                    "select id, ma_nha_cung_cap AS ma , ten_nha_cung_cap from NhaCungCap where trang_thai = 1 UNION ALL\n" +
                    "select id, ma_nong_do AS ma , nong_do from NongDo where trang_thai = 1 UNION ALL\n" +
                    "select id, ma_dung_tich AS ma , Dung_tich from DungTich where trang_thai = 1 ";

        try (Connection conn = DBConnect_An.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThuocTinhSanPham(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public boolean insertHangSX(ThuocTinhSanPham ttsp){
         int check = 0;
         String sql = "insert into HangSanXuat(ten_hang_san_xuat)\n"
                + "values(?)";
         try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ttsp.getTenThuocTinhSanPham());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    public boolean insertNamSX(ThuocTinhSanPham ttsp){
         int check = 0;
         String sql = "insert into NamSanXuat(nam_san_xuat)\n"
                + "values(?)";
         try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ttsp.getTenThuocTinhSanPham());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    public boolean insertXuatXu(ThuocTinhSanPham ttsp){
         int check = 0;
         String sql = "insert into XuatSu(xuat_su)\n"
                + "values(?)";
         try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ttsp.getTenThuocTinhSanPham());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    public boolean insertNongDo(ThuocTinhSanPham ttsp){
         int check = 0;
         String sql = "insert into NongDo(nong_do)\n"
                + "values(?)";
         try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ttsp.getTenThuocTinhSanPham());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    public boolean insertLoaiSP(ThuocTinhSanPham ttsp){
         int check = 0;
         String sql = "insert into Phanloai(ten_phan_loai)\n"
                + "values(?)";
         try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ttsp.getTenThuocTinhSanPham());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    public boolean insertDungTich(ThuocTinhSanPham ttsp){
         int check = 0;
         String sql = "insert into DungTich(Dung_tich)\n"
                + "values(?)";
         try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ttsp.getTenThuocTinhSanPham());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    public boolean insertNCC(ThuocTinhSanPham ttsp){
         int check = 0;
         String sql = "insert into NhaCungCap(ten_nha_cung_cap)\n"
                + "values(?)";
         try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ttsp.getTenThuocTinhSanPham());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    public ArrayList<ThuocTinhSanPham> getHangSX() {
        ArrayList<ThuocTinhSanPham> list = new ArrayList<>();
        String sql = "SELECT id,ma_hang_san_xuat,ten_hang_san_xuat FROM HangSanXuat where trang_thai = 1";
        try (Connection conn = DBConnect_An.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThuocTinhSanPham(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }
     public ArrayList<ThuocTinhSanPham> getNongDo() {
        ArrayList<ThuocTinhSanPham> list = new ArrayList<>();
        String sql = "SELECT id,ma_nong_do,nong_do FROM NongDo where trang_thai = 1";
        try (Connection conn = DBConnect_An.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThuocTinhSanPham(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }
      public ArrayList<ThuocTinhSanPham> getNamSX() {
        ArrayList<ThuocTinhSanPham> list = new ArrayList<>();
        String sql = "SELECT id,ma_nam_san_xuat,nam_san_xuat FROM NamSanXuat where trang_thai = 1";
        try (Connection conn = DBConnect_An.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThuocTinhSanPham(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }
     public ArrayList<ThuocTinhSanPham> getXuatXu() {
        ArrayList<ThuocTinhSanPham> list = new ArrayList<>();
        String sql = "SELECT id,ma_xuat_su,xuat_su FROM XuatSu where trang_thai = 1";
        try (Connection conn = DBConnect_An.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThuocTinhSanPham(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }
      public ArrayList<ThuocTinhSanPham> getPhanLoai() {
        ArrayList<ThuocTinhSanPham> list = new ArrayList<>();
        String sql = "SELECT id,ma_phan_loai,ten_phan_loai FROM PhanLoai where trang_thai = 1";
        try (Connection conn = DBConnect_An.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThuocTinhSanPham(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }
       public ArrayList<ThuocTinhSanPham> getDungTich() {
        ArrayList<ThuocTinhSanPham> list = new ArrayList<>();
        String sql = "SELECT id,ma_dung_tich,Dung_tich FROM DungTich where trang_thai = 1";
        try (Connection conn = DBConnect_An.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThuocTinhSanPham(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }
        public ArrayList<ThuocTinhSanPham> getNCC() {
        ArrayList<ThuocTinhSanPham> list = new ArrayList<>();
        String sql = "SELECT id,ma_nha_cung_cap,ten_nha_cung_cap FROM NhaCungCap where trang_thai = 1";
        try (Connection conn = DBConnect_An.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThuocTinhSanPham(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }
        public boolean updateHangSX(ThuocTinhSanPham ttsp, Integer id) {
        int check = 0;
        String sql = "update HangSanXuat\n"
                + "set ten_hang_san_xuat=?\n"
                + "where id=?";
        try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ttsp.getTenThuocTinhSanPham());
            ps.setObject(2, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
        public boolean updateNamSX(ThuocTinhSanPham ttsp, Integer id) {
        int check = 0;
        String sql = "update NamSanXuat\n"
                + "set nam_san_xuat=?\n"
                + "where id=?";
        try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ttsp.getTenThuocTinhSanPham());
            ps.setObject(2, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
        public boolean updateXuatSu(ThuocTinhSanPham ttsp, Integer id) {
        int check = 0;
        String sql = "update XuatSu\n"
                + "set xuat_su=?\n"
                + "where id=?";
        try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ttsp.getTenThuocTinhSanPham());
            ps.setObject(2, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
        public boolean updateLoaiRuou(ThuocTinhSanPham ttsp, Integer id) {
        int check = 0;
        String sql = "update PhanLoai\n"
                + "set ten_phan_loai=?\n"
                + "where id=?";
        try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ttsp.getTenThuocTinhSanPham());
            ps.setObject(2, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
        public boolean updateNongDo(ThuocTinhSanPham ttsp, Integer id) {
        int check = 0;
        String sql = "update NongDo\n"
                + "set nong_do=?\n"
                + "where id=?";
        try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ttsp.getTenThuocTinhSanPham());
            ps.setObject(2, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
        public boolean updateDungTich(ThuocTinhSanPham ttsp, Integer id) {
        int check = 0;
        String sql = "update DungTich\n"
                + "set Dung_tich=?\n"
                + "where id=?";
        try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ttsp.getTenThuocTinhSanPham());
            ps.setObject(2, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
        public boolean updateNCC(ThuocTinhSanPham ttsp, Integer id) {
        int check = 0;
        String sql = "update NhaCungCap\n"
                + "set ten_nha_cung_cap=?\n"
                + "where id=?";
        try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ttsp.getTenThuocTinhSanPham());
            ps.setObject(2, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
        public boolean removeHangSX(Integer id) {
        int check = 0;
        String sql = "update HangSanXuat set trang_thai=0 where id=?";
        try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
        public boolean removeNamSX(Integer id) {
        int check = 0;
        String sql = "update NamSanXuat set trang_thai=0 where id=?";
        try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
        public boolean removeLoaiRuou(Integer id) {
        int check = 0;
        String sql = "update PhanLoai set trang_thai=0 where id=?";
        try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
        public boolean removeXuatSu(Integer id) {
        int check = 0;
        String sql = "update XuatSu set trang_thai=0 where id=?";
        try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
        public boolean removeNCC(Integer id) {
        int check = 0;
        String sql = "update NhaCungCap set trang_thai=0 where id=?";
        try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
        public boolean removeNongDo(Integer id) {
        int check = 0;
        String sql = "update NongDo set trang_thai=0 where id=?";
        try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
        public boolean removeDungTich(Integer id) {
        int check = 0;
        String sql = "update DungTich set trang_thai=0 where id=?";
        try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
