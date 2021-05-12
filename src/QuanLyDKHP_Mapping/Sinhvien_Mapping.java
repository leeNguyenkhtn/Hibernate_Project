package QuanLyDKHP_Mapping;

import java.sql.Date;
import java.util.Objects;

public class Sinhvien_Mapping {
    private String idSinhVien;
    private String mssv;
    private String hoVaTen;
    private Date ngaySinh;
    private String gioiTinh;
    private String diaChi;
    private String soDienThoai;

    public String getIdSinhVien() {
        return idSinhVien;
    }

    public void setIdSinhVien(String idSinhVien) {
        this.idSinhVien = idSinhVien;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sinhvien_Mapping that = (Sinhvien_Mapping) o;
        return Objects.equals(idSinhVien, that.idSinhVien) && Objects.equals(mssv, that.mssv) && Objects.equals(hoVaTen, that.hoVaTen) && Objects.equals(ngaySinh, that.ngaySinh) && Objects.equals(gioiTinh, that.gioiTinh) && Objects.equals(diaChi, that.diaChi) && Objects.equals(soDienThoai, that.soDienThoai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSinhVien, mssv, hoVaTen, ngaySinh, gioiTinh, diaChi, soDienThoai);
    }
}
