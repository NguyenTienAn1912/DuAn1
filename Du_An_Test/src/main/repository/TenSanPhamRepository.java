/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.repository;

import DBConnect.DBConnect_An;
import main.entity.DungTich;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class TenSanPhamRepository {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    public ArrayList<DungTich> getAll() {
        ArrayList<DungTich> list = new ArrayList<>();
        String sql = "SELECT id, ma_dung_tich, dung_tich\n"
                + "FROM DungTich\n"
                + "WHERE trang_thai = 1\n"
                + "ORDER BY id DESC";
        try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DungTich(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public DungTich getDungTichByTen(String ma1) {
        String query = "select id,ma_dung_tich, dung_tich from DungTich\n"
                + "where dung_tich = ?";
        try (Connection con = DBConnect_An.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            // Set gia tri cho dau hoi cham 
            ps.setObject(1, ma1);
            ResultSet rs = ps.executeQuery(); // Lay ket qua

            while (rs.next()) {
                DungTich cv = new DungTich(rs.getInt(1), rs.getString(2), rs.getString(3));
                return cv;
            }
        } catch (Exception e) {
            // loi => nhay vao catch
            e.printStackTrace(System.out);
        }
        return null;
    }

    
    public boolean isDungTichExist(String ten) {
        String sql = "SELECT COUNT(*) FROM DungTich WHERE dung_tich=?";
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
    
    public int addDungTich(DungTich dt){
         sql = "INSERT INTO DungTich(Dung_tich) VALUES(?)";
        
        try{
            con = DBConnect_An.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, dt.getTen());
            return ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
