package QuanLyDKHP_Mapping;

import java.sql.Date;
import java.util.Objects;

public class Lopdangkihocphan_Mapping {
    private String idLopDangKiHopPhan;
    private String giaoVienLiThuyet;
    private String tenPhongHoc;
    private Object buoiHoc;
    private Object caHoc;
    private int siSo;
    private int soLuongDaDangKy;
    private Date ngayBatDau;
    private Date ngayKetThuc;

    public String getIdLopDangKiHopPhan() {
        return idLopDangKiHopPhan;
    }

    public void setIdLopDangKiHopPhan(String idLopDangKiHopPhan) {
        this.idLopDangKiHopPhan = idLopDangKiHopPhan;
    }

    public String getGiaoVienLiThuyet() {
        return giaoVienLiThuyet;
    }

    public void setGiaoVienLiThuyet(String giaoVienLiThuyet) {
        this.giaoVienLiThuyet = giaoVienLiThuyet;
    }

    public String getTenPhongHoc() {
        return tenPhongHoc;
    }

    public void setTenPhongHoc(String tenPhongHoc) {
        this.tenPhongHoc = tenPhongHoc;
    }

    public Object getBuoiHoc() {
        return buoiHoc;
    }

    public void setBuoiHoc(Object buoiHoc) {
        this.buoiHoc = buoiHoc;
    }

    public Object getCaHoc() {
        return caHoc;
    }

    public void setCaHoc(Object caHoc) {
        this.caHoc = caHoc;
    }

    public int getSiSo() {
        return siSo;
    }

    public void setSiSo(int siSo) {
        this.siSo = siSo;
    }

    public int getSoLuongDaDangKy() {
        return soLuongDaDangKy;
    }

    public void setSoLuongDaDangKy(int soLuongDaDangKy) {
        this.soLuongDaDangKy = soLuongDaDangKy;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lopdangkihocphan_Mapping that = (Lopdangkihocphan_Mapping) o;
        return siSo == that.siSo && soLuongDaDangKy == that.soLuongDaDangKy && Objects.equals(idLopDangKiHopPhan, that.idLopDangKiHopPhan) && Objects.equals(giaoVienLiThuyet, that.giaoVienLiThuyet) && Objects.equals(tenPhongHoc, that.tenPhongHoc) && Objects.equals(buoiHoc, that.buoiHoc) && Objects.equals(caHoc, that.caHoc) && Objects.equals(ngayBatDau, that.ngayBatDau) && Objects.equals(ngayKetThuc, that.ngayKetThuc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLopDangKiHopPhan, giaoVienLiThuyet, tenPhongHoc, buoiHoc, caHoc, siSo, soLuongDaDangKy, ngayBatDau, ngayKetThuc);
    }
}
