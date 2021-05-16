package POJO;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Lopdangkihocphan {
    private String idLopDangKiHopPhan;
    private String giaoVienLiThuyet;
    private String tenPhongHoc;
    private Object buoiHoc;
    private Object caHoc;
    private int siSo;
    private int soLuongDaDangKy;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private Hocki hockiByHocKiIdHocKi;

    @Id
    @Column(name = "idLopDangKiHopPhan", nullable = false, length = 12)
    public String getIdLopDangKiHopPhan() {
        return idLopDangKiHopPhan;
    }

    public void setIdLopDangKiHopPhan(String idLopDangKiHopPhan) {
        this.idLopDangKiHopPhan = idLopDangKiHopPhan;
    }

    @Basic
    @Column(name = "giaoVienLiThuyet", nullable = false, length = 45)
    public String getGiaoVienLiThuyet() {
        return giaoVienLiThuyet;
    }

    public void setGiaoVienLiThuyet(String giaoVienLiThuyet) {
        this.giaoVienLiThuyet = giaoVienLiThuyet;
    }

    @Basic
    @Column(name = "tenPhongHoc", nullable = false, length = 5)
    public String getTenPhongHoc() {
        return tenPhongHoc;
    }

    public void setTenPhongHoc(String tenPhongHoc) {
        this.tenPhongHoc = tenPhongHoc;
    }

    @Basic
    @Column(name = "buoiHoc", nullable = false)
    public Object getBuoiHoc() {
        return buoiHoc;
    }

    public void setBuoiHoc(Object buoiHoc) {
        this.buoiHoc = buoiHoc;
    }

    @Basic
    @Column(name = "caHoc", nullable = false)
    public Object getCaHoc() {
        return caHoc;
    }

    public void setCaHoc(Object caHoc) {
        this.caHoc = caHoc;
    }

    @Basic
    @Column(name = "siSo", nullable = false)
    public int getSiSo() {
        return siSo;
    }

    public void setSiSo(int siSo) {
        this.siSo = siSo;
    }

    @Basic
    @Column(name = "soLuongDaDangKy", nullable = false)
    public int getSoLuongDaDangKy() {
        return soLuongDaDangKy;
    }

    public void setSoLuongDaDangKy(int soLuongDaDangKy) {
        this.soLuongDaDangKy = soLuongDaDangKy;
    }

    @Basic
    @Column(name = "ngayBatDau", nullable = false)
    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    @Basic
    @Column(name = "ngayKetThuc", nullable = false)
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
        Lopdangkihocphan that = (Lopdangkihocphan) o;
        return siSo == that.siSo && soLuongDaDangKy == that.soLuongDaDangKy && Objects.equals(idLopDangKiHopPhan, that.idLopDangKiHopPhan) && Objects.equals(giaoVienLiThuyet, that.giaoVienLiThuyet) && Objects.equals(tenPhongHoc, that.tenPhongHoc) && Objects.equals(buoiHoc, that.buoiHoc) && Objects.equals(caHoc, that.caHoc) && Objects.equals(ngayBatDau, that.ngayBatDau) && Objects.equals(ngayKetThuc, that.ngayKetThuc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLopDangKiHopPhan, giaoVienLiThuyet, tenPhongHoc, buoiHoc, caHoc, siSo, soLuongDaDangKy, ngayBatDau, ngayKetThuc);
    }

    @ManyToOne
    @JoinColumn(name = "HocKi_idHocKi", referencedColumnName = "idHocKi", nullable = false)
    public Hocki getHockiByHocKiIdHocKi() {
        return hockiByHocKiIdHocKi;
    }

    public void setHockiByHocKiIdHocKi(Hocki hockiByHocKiIdHocKi) {
        this.hockiByHocKiIdHocKi = hockiByHocKiIdHocKi;
    }
}
