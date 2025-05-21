/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.entity;

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
@Builder
@Getter
@Setter
@ToString


public class SanPhamChiTiet {
    private Integer id;
    private String maSanPhamChiTiet;
    private Integer sanPhamID;
    private Integer hangSXID;
    private Integer NongDoID;
    private Integer NamSXID;
    private Integer XuatsuID;
    private Integer PhanLoaiID;
    private Integer DungTichID;
    private Integer NCCID;
    private Double giaNhap;
    private Double giaBan;
    private Integer soLuongTon;
    private boolean trangThai;
    
    
}
