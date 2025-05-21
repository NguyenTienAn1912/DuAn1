package Model_HoaDon;

import java.math.BigDecimal;
import java.util.Date;

public class Model_HoaDon1 {

    private int id; // id
    private int idKhachHang; // id_khach_hang
    private int idNhanVien; // id_nhan_vien
    private int idVoucher; // id_voucher
    private String maHoaDon; // ma_hoa_don
    private String tenNhanVien; // ten_nhan_vien
    private String TenKhachhang;
    private String SDT;
    private String maVoucher; // ma_voucher
    private int tongTien; // tong_tien
    private int tongTienSauKhiGiam; // tong_tien_sau_khi_giam
    private boolean trangThai; // trang_thai
    private String GhiChu;
    private Date ngayTao; // ngay_tao
    private Date ngayCapNhat; // ngay_cap_nhat

    // Constructor

    public Model_HoaDon1() {
    }

    public Model_HoaDon1(int idKhachHang, int idNhanVien, int idVoucher, String maHoaDon, String tenNhanVien, String TenKhachhang, String SDT, String maVoucher, int tongTien, int tongTienSauKhiGiam, boolean trangThai, String GhiChu, Date ngayTao, Date ngayCapNhat) {
        this.idKhachHang = idKhachHang;
        this.idNhanVien = idNhanVien;
        this.idVoucher = idVoucher;
        this.maHoaDon = maHoaDon;
        this.tenNhanVien = tenNhanVien;
        this.TenKhachhang = TenKhachhang;
        this.SDT = SDT;
        this.maVoucher = maVoucher;
        this.tongTien = tongTien;
        this.tongTienSauKhiGiam = tongTienSauKhiGiam;
        this.trangThai = trangThai;
        this.GhiChu = GhiChu;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
    }

    public Model_HoaDon1(int id, int idKhachHang, int idNhanVien, int idVoucher, String maHoaDon, String tenNhanVien, String TenKhachhang, String SDT, String maVoucher, int tongTien, int tongTienSauKhiGiam, boolean trangThai, String GhiChu, Date ngayTao, Date ngayCapNhat) {
        this.id = id;
        this.idKhachHang = idKhachHang;
        this.idNhanVien = idNhanVien;
        this.idVoucher = idVoucher;
        this.maHoaDon = maHoaDon;
        this.tenNhanVien = tenNhanVien;
        this.TenKhachhang = TenKhachhang;
        this.SDT = SDT;
        this.maVoucher = maVoucher;
        this.tongTien = tongTien;
        this.tongTienSauKhiGiam = tongTienSauKhiGiam;
        this.trangThai = trangThai;
        this.GhiChu = GhiChu;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

   

    
    public String getTenKhachhang() {
        return TenKhachhang;
    }

    // Getters and Setters
    public void setTenKhachhang(String TenKhachhang) {    
        this.TenKhachhang = TenKhachhang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public int getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(int idVoucher) {
        this.idVoucher = idVoucher;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getMaVoucher() {
        return maVoucher;
    }

    public void setMaVoucher(String maVoucher) {
        this.maVoucher = maVoucher;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public int getTongTienSauKhiGiam() {
        return tongTienSauKhiGiam;
    }

    public void setTongTienSauKhiGiam(int tongTienSauKhiGiam) {
        this.tongTienSauKhiGiam = tongTienSauKhiGiam;
    }

    

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(Date ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }
}
