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
public class HoaDonChiTietReponse {
    
    private Integer id;

    private String maSPCT;
    
    private String TenSP;
    
    private String hangSX;
    
    private String namSX;

    private String XuatSU;
   
    private String nongdo;
    
    private String PhanLoai;
    
    private String dungTich;

    private String nhaCungCap;
    
    private Double giaNhap;
    
    private Double giaBan;
    
    private Integer soLuong;
    
    private boolean trangThai;
    
    private Double thanhTien;
    
    private Integer idHoaDon;
    
    private Integer idSpct;
    

    
}
