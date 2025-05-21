/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.repository;

import DBConnect.DBConnect_An;
import main.entity.HangSX;
import main.entity.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class HangSXRepository {
private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    public ArrayList<HangSX> getAll() {
        ArrayList<HangSX> list = new ArrayList<>();
        String sql = "SELECT id, ma_hang_san_xuat, ten_hang_san_xuat\n"
                + "FROM HangSanXuat\n"
                + "WHERE trang_thai = 1\n"
                + "ORDER BY id DESC;";
        try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HangSX(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public HangSX getHangSXByTen(String ma1) {
        String query = "select id,ma_hang_san_xuat, ten_hang_san_xuat from HangSanXuat\n"
                + "where ten_hang_san_xuat=?";
        try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            // Set gia tri cho dau hoi cham 
            ps.setObject(1, ma1);
            ResultSet rs = ps.executeQuery(); // Lay ket qua

            while (rs.next()) {
                HangSX cv = new HangSX(rs.getInt(1), rs.getString(2), rs.getString(3));
                return cv;
            }
        } catch (Exception e) {
            // loi => nhay vao catch
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean isHangSanXuatExist(String TenHangSanXuat) {
        String sql = "SELECT COUNT(*) FROM HangSanXuat  WHERE ten_hang_san_xuat = ?";
        try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, TenHangSanXuat);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
       public int add(HangSX add){
         sql = "INSERT INTO HangSanXuat(ten_hang_san_xuat) VALUES(?)";
        
        try{
            con = DBConnect_An.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, add.getTen());
            return ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
