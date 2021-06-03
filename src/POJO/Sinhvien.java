package POJO;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "sinhvien")
public class Sinhvien {
    private String idSinhVien;
    private String mssv;
    private String hoVaTen;
    private Date ngaySinh;
    private String gioiTinh;
    private String diaChi;
    private String soDienThoai;
    private Taikhoan taiKhoan;
    private Lophoc lopHoc;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LopHoc_idLopHoc")
    public Lophoc getLopHoc() {
        return lopHoc;
    }

    public void setLopHoc(Lophoc lopHoc) {
        this.lopHoc = lopHoc;
    }

    @Id
    @Column(name = "idSinhVien", nullable = false, length = 12)
    public String getIdSinhVien() {
        return idSinhVien;
    }

    public void setIdSinhVien(String idSinhVien) {
        this.idSinhVien = idSinhVien;
    }

    @Basic
    @Column(name = "MSSV", nullable = false, length = 8)
    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    @Basic
    @Column(name = "hoVaTen", nullable = false, length = 45)
    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    @Basic
    @Column(name = "ngaySinh", nullable = false)
    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    @Basic
    @Column(name = "gioiTinh", nullable = false, length = 3)
    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    @Basic
    @Column(name = "diaChi", nullable = true, length = 80)
    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Basic
    @Column(name = "soDienThoai", nullable = true, length = 15)
    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setTaiKhoan(Taikhoan taikhoanByIdSinhVien) {
        this.taiKhoan = taikhoanByIdSinhVien;
    }
    @OneToOne
    @JoinColumn(name = "idSinhVien", referencedColumnName = "idTaiKhoan", nullable = false)
    public  Taikhoan getTaiKhoan(){
        return taiKhoan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sinhvien sinhvien = (Sinhvien) o;
        return Objects.equals(idSinhVien, sinhvien.idSinhVien) && Objects.equals(mssv, sinhvien.mssv) && Objects.equals(hoVaTen, sinhvien.hoVaTen) && Objects.equals(ngaySinh, sinhvien.ngaySinh) && Objects.equals(gioiTinh, sinhvien.gioiTinh) && Objects.equals(diaChi, sinhvien.diaChi) && Objects.equals(soDienThoai, sinhvien.soDienThoai) && Objects.equals(lopHoc,sinhvien.lopHoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSinhVien, mssv, hoVaTen, ngaySinh, gioiTinh, diaChi, soDienThoai);
    }
}
