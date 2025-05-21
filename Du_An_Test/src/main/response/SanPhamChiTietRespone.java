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
public class SanPhamChiTietRespone {
    private int ID;
    private String maSPCT;
    private String tenSP;
    private String HangSX;
    private String NamSX;
    private String xuatXu;
    private String NongDo;
    private String PhanLoai;
    private String DungTich;
    private String NCC;
    private Double GiaNhap;
    private Double giaBan;
    private Integer soLuong;
    private boolean trangThai;
    
}
