package POJO;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Hocki {
    private String idHocKi;
    private String tenHocKi;
    private String namHoc;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private int trangThai;
    private List<Kydangkihocphan> dsKyDangKiHocPhan;
    @Id
    @Column(name = "idHocKi", nullable = false, length = 12)
    public String getIdHocKi() {
        return idHocKi;
    }

    public void setIdHocKi(String idHocKi) {
        this.idHocKi = idHocKi;
    }

    @Basic
    @Column(name = "tenHocKi", nullable = false, length = 3)
    public String getTenHocKi() {
        return tenHocKi;
    }

    public void setTenHocKi(String tenHocKi) {
        this.tenHocKi = tenHocKi;
    }

    @Basic
    @Column(name = "namHoc", nullable = false)
    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
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

    @Basic
    @Column(name = "trangThai", nullable = false)
    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @OneToMany(mappedBy = "hocKi")
    public List<Kydangkihocphan> getDsKyDangKiHocPhan()
    {
        return dsKyDangKiHocPhan;
    }
    public  void setDsKyDangKiHocPhan(List<Kydangkihocphan> dsLopDangKiHocPhan)
    {
        this.dsKyDangKiHocPhan = dsLopDangKiHocPhan;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hocki hocki = (Hocki) o;
        return namHoc == hocki.namHoc && trangThai == hocki.trangThai && Objects.equals(idHocKi, hocki.idHocKi) && Objects.equals(tenHocKi, hocki.tenHocKi) && Objects.equals(ngayBatDau, hocki.ngayBatDau) && Objects.equals(ngayKetThuc, hocki.ngayKetThuc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHocKi, tenHocKi, namHoc, ngayBatDau, ngayKetThuc, trangThai);
    }

    private Collection<Kydangkihocphan> dsLopDangKiHocPhan;

    public void setDsLopDangKiHocPhan(Collection<Kydangkihocphan> dsLopDangKiHocPhan) {
        this.dsLopDangKiHocPhan = dsLopDangKiHocPhan;
    }
}
