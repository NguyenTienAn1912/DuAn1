 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author ADMIN
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class HoaDonResponse1 {
    private Integer id;  
    
    private Integer idKH;
    
    private Integer idNV;
    
    private Integer id_vouCher;
    
    private Integer trangThai;
    
    private Double tongTien;
   
    private String maHoaDon;
    
    private String tenKhachHang;
    
    private String maNhanVien;

    private String hoTen;
    
    private String ngayTao;
    
    private String maKH;

   private Double tienGiam;

//    public HoaDonResponse1() {
//    }
//
//    public HoaDonResponse1(Integer idKH, Integer idNV, Integer id_vouCher, boolean trangThai, Double tongTien, String maHoaDon, String tenKhachHang, String maNhanVien, String hoTen, String ngayTao, String maKH, Double tienGiam) {
//        this.idKH = idKH;
//        this.idNV = idNV;
//        this.id_vouCher = id_vouCher;
//        this.trangThai = trangThai;
//        this.tongTien = tongTien;
//        this.maHoaDon = maHoaDon;
//        this.tenKhachHang = tenKhachHang;
//        this.maNhanVien = maNhanVien;
//        this.hoTen = hoTen;
//        this.ngayTao = ngayTao;
//        this.maKH = maKH;
//        this.tienGiam = tienGiam;
//    }
//
//    public HoaDonResponse1(Double tongTien, Double tienGiam) {
//        this.tongTien = tongTien;
//        this.tienGiam = tienGiam;
//    }
//
//    public HoaDonResponse1(Integer id, Integer idKH, Integer idNV, Integer id_vouCher, boolean trangThai, Double tongTien, String maHoaDon, String tenKhachHang, String maNhanVien, String hoTen, String ngayTao, String maKH, Double tienGiam) {
//        this.id = id;
//        this.idKH = idKH;
//        this.idNV = idNV;
//        this.id_vouCher = id_vouCher;
//        this.trangThai = trangThai;
//        this.tongTien = tongTien;
//        this.maHoaDon = maHoaDon;
//        this.tenKhachHang = tenKhachHang;
//        this.maNhanVien = maNhanVien;
//        this.hoTen = hoTen;
//        this.ngayTao = ngayTao;
//        this.maKH = maKH;
//        this.tienGiam = tienGiam;
//    }
//
//    public HoaDonResponse1(Integer id, Integer idKH, Integer idNV, boolean trangThai,Double tongTien, String maHoaDon, String tenKhachHang, String maNhanVien, String hoTen, String ngayTao, String maKH) {
//        this.id = id;
//        this.idKH = idKH;
//        this.idNV = idNV;
//        this.trangThai = trangThai;
//        this.tongTien = tongTien;
//        this.maHoaDon = maHoaDon;
//        this.tenKhachHang = tenKhachHang;
//        this.maNhanVien = maNhanVien;
//        this.hoTen = hoTen;
//        this.ngayTao = ngayTao;
//        this.maKH = maKH;
//    }
//
//    public HoaDonResponse1(Integer id, boolean trangThai, Double tongTien, String maHoaDon, String maNhanVien, String ngayTao) {
//        this.id = id;
//        this.trangThai = trangThai;
//        this.tongTien = tongTien;
//        this.maHoaDon = maHoaDon;
//        this.maNhanVien = maNhanVien;
//        this.ngayTao = ngayTao;
//    }
//    
//    
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getIdKH() {
//        return idKH;
//    }
//
//    public void setIdKH(Integer idKH) {
//        this.idKH = idKH;
//    }
//
//    public Integer getIdNV() {
//        return idNV;
//    }
//
//    public void setIdNV(Integer idNV) {
//        this.idNV = idNV;
//    }
//
//    public Integer getId_vouCher() {
//        return id_vouCher;
//    }
//
//    public void setId_vouCher(Integer id_vouCher) {
//        this.id_vouCher = id_vouCher;
//    }
//
//    public boolean getTrangThai() {
//        return trangThai;
//    }
//
//    public void setTrangThai(boolean trangThai) {
//        this.trangThai = trangThai;
//    }
//
//    public double getTongTien() {
//        return tongTien;
//    }
//
//    public void setTongTien(double tongTien) {
//        this.tongTien = tongTien;
//    }
//
//    public String getMaHoaDon() {
//        return maHoaDon;
//    }
//
//    public void setMaHoaDon(String maHoaDon) {
//        this.maHoaDon = maHoaDon;
//    }
//
//    public String getTenKhachHang() {
//        return tenKhachHang;
//    }
//
//    public void setTenKhachHang(String tenKhachHang) {
//        this.tenKhachHang = tenKhachHang;
//    }
//
//    public String getMaNhanVien() {
//        return maNhanVien;
//    }
//
//    public void setMaNhanVien(String maNhanVien) {
//        this.maNhanVien = maNhanVien;
//    }
//
//    public String getHoTen() {
//        return hoTen;
//    }
//
//    public void setHoTen(String hoTen) {
//        this.hoTen = hoTen;
//    }
//
//    public String getNgayTao() {
//        return ngayTao;
//    }
//
//    public void setNgayTao(String ngayTao) {
//        this.ngayTao = ngayTao;
//    }
//
//    public String getMaKH() {
//        return maKH;
//    }
//
//    public void setMaKH(String maKH) {
//        this.maKH = maKH;
//    }
//
//    public Double getTienGiam() {
//        return tienGiam;
//    }
//
//    public void setTienGiam(Double tienGiam) {
//        this.tienGiam = tienGiam;
//    }
//   
//   public Object[] toDataHoaDon(){
//        return new Object[]{this.getId(),this.getMaHoaDon(),this.getNgayTao(),this.getMaNhanVien(),this.getTongTien(),this.getTrangThai()?"Đã Thanh Toán":"Chờ Thanh Toán"};
//    }
}
