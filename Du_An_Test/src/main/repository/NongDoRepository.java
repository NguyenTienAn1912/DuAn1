/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.repository;

import DBConnect.DBConnect_An;
import main.entity.NongDo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class NongDoRepository {

    public ArrayList<NongDo> getAll() {
        ArrayList<NongDo> list = new ArrayList<>();
        String sql = "SELECT id, ma_nong_do, nong_do\n"
                + "FROM NongDo\n"
                + "WHERE trang_thai = 1\n"
                + "ORDER BY id DESC";
        try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new NongDo(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public NongDo getNongDoByTen(String ma1) {
        String query = "select id,ma_nong_do,nong_do from NongDo\n"
                + "where nong_do=?";
        try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            // Set gia tri cho dau hoi cham 
            ps.setObject(1, ma1);
            ResultSet rs = ps.executeQuery(); // Lay ket qua

            while (rs.next()) {
                NongDo cv = new NongDo(rs.getInt(1), rs.getString(2), rs.getString(3));
                return cv;
            }
        } catch (Exception e) {
            // loi => nhay vao catch
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean isNongDoExist(String ten) {
        String sql = "SELECT COUNT(*) FROM NongDo WHERE nong_do=?";
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
