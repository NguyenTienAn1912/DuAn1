/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.repository;

import DBConnect.DBConnect_An;
import main.entity.LoaiRuou;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class PhanLoaiRepository {

    public ArrayList<LoaiRuou> getAll() {
        ArrayList<LoaiRuou> list = new ArrayList<>();
        String sql = "SELECT id, ma_phan_loai, ten_phan_loai\n"
                + "FROM PhanLoai\n"
                + "WHERE trang_thai = 1\n"
                + "ORDER BY id DESC";
        try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new LoaiRuou(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public LoaiRuou getPhanLoaiByTen(String ma1) {
        String query = "select id,ma_phan_loai, ten_phan_loai from PhanLoai\n"
                + "where ten_phan_loai = ?";
        try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            // Set gia tri cho dau hoi cham 
            ps.setObject(1, ma1);
            ResultSet rs = ps.executeQuery(); // Lay ket qua

            while (rs.next()) {
                LoaiRuou cv = new LoaiRuou(rs.getInt(1), rs.getString(2), rs.getString(3));
                return cv;
            }
        } catch (Exception e) {
            // loi => nhay vao catch
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean isDungTichExist(String ten) {
        String sql = "SELECT COUNT(*) FROM PhanLoai WHERE ten_phan_loai=?";
        try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ten);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
