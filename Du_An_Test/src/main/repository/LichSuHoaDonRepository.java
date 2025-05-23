/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import DBConnect.DBConnect_An;
//import main.response.HoaDonResponse;
import main.response.LichSuHoaDonResponse;

/**
 *
 * @author ADMIN
 */
public class LichSuHoaDonRepository {
    public ArrayList<LichSuHoaDonResponse> getAll() {
        String sql = "SELECT  dbo.NhanVien.id, dbo.NhanVien.ma_nhan_vien, dbo.HoaDon.ngay_cap_nhat, dbo.HoaDon.trang_thai\n"
                + "FROM      dbo.NhanVien INNER JOIN\n"
                + "                 dbo.HoaDon ON dbo.NhanVien.id = dbo.HoaDon.id_nhan_vien";

        try (Connection con = DBConnect_An.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            ArrayList<LichSuHoaDonResponse> lists = new ArrayList<>();
            while (rs.next()) {
                LichSuHoaDonResponse response
                        = LichSuHoaDonResponse.builder()
                                .id(rs.getInt(1))
                                .maNV(rs.getString(2))
                                .ngayCapNhap(rs.getString(3))
                                .trangThai(rs.getInt(4))
                                .build();
                lists.add(response);
            }
            return lists;
        } catch (Exception e) {
            // loi => nhay vao catch
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public ArrayList<LichSuHoaDonResponse> getByIdLSHoaDon(Integer idHD) {
        String sql = "SELECT \n"
                + "    nv.id, \n"
                + "    nv.ma_nhan_vien, \n"
                + "    hd.ngay_cap_nhat, \n"
                + "    hd.trang_thai\n"
                + "FROM \n"
                + "    NhanVien nv\n"
                + "INNER JOIN \n"
                + "    HoaDon hd ON nv.id = hd.id_nhan_vien\n"
                + "WHERE \n"
                + "    hd.id = ?";

        try (Connection con = DBConnect_An.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, idHD);// l?
            ResultSet rs = ps.executeQuery();

            ArrayList<LichSuHoaDonResponse> lists = new ArrayList<>();
            while (rs.next()) {
                LichSuHoaDonResponse response
                        = LichSuHoaDonResponse.builder()
                                .id(rs.getInt(1))
                                .maNV(rs.getString(2))
                                .ngayCapNhap(rs.getString(3))
                                .trangThai(rs.getInt(4))
                                .build();
                lists.add(response);
            }
            return lists;
        } catch (Exception e) {
            // loi => nhay vao catch
            e.printStackTrace(System.out);
        }
        return null;
    }

    public ArrayList<LichSuHoaDonResponse> ByIDHoaDon() {
        String sql = "SELECT dbo.NhanVien.id, \n" +
"       dbo.NhanVien.ma_nhan_vien, \n" +
"       dbo.HoaDon.ngay_cap_nhat, \n" +
"       dbo.HoaDon.trang_thai\n" +
"FROM dbo.NhanVien\n" +
"INNER JOIN dbo.HoaDon \n" +
"    ON dbo.NhanVien.id = dbo.HoaDon.id_nhan_vien\n" +
"	where dbo.HoaDon.id = ?";

        try (Connection con = DBConnect_An.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            ArrayList<LichSuHoaDonResponse> lists = new ArrayList<>();
            while (rs.next()) {
                LichSuHoaDonResponse response
                        = LichSuHoaDonResponse.builder()
                                .id(rs.getInt(1))
                                .maNV(rs.getString(2))
                                .ngayCapNhap(rs.getString(3))
                                .trangThai(rs.getInt(4))
                                .build();
                lists.add(response);
            }
            return lists;
        } catch (Exception e) {
            // loi => nhay vao catch
            e.printStackTrace(System.out);
        }
        return null;
    }
}
