package QuanLyDKHP_Mapping;

import java.sql.Date;
import java.util.Objects;

public class Hocki_Mapping {
    private String idHocKi;
    private String tenHocKi;
    private int namHoc;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private int trangThai;

    public String getIdHocKi() {
        return idHocKi;
    }

    public void setIdHocKi(String idHocKi) {
        this.idHocKi = idHocKi;
    }

    public String getTenHocKi() {
        return tenHocKi;
    }

    public void setTenHocKi(String tenHocKi) {
        this.tenHocKi = tenHocKi;
    }

    public int getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(int namHoc) {
        this.namHoc = namHoc;
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hocki_Mapping that = (Hocki_Mapping) o;
        return namHoc == that.namHoc && trangThai == that.trangThai && Objects.equals(idHocKi, that.idHocKi) && Objects.equals(tenHocKi, that.tenHocKi) && Objects.equals(ngayBatDau, that.ngayBatDau) && Objects.equals(ngayKetThuc, that.ngayKetThuc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHocKi, tenHocKi, namHoc, ngayBatDau, ngayKetThuc, trangThai);
    }
}
