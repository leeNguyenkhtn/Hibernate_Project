package POJO;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
@Entity
public class Kydangkihocphan {


    private String idKyDangKiHocPhan;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private List<Lopdangkihocphan> danhSachHocPhan;
    private Hocki hocKi;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idHocKi",referencedColumnName = "idHocKi")
    public Hocki getHocKi() {
        return hocKi;
    }

    public void setHocKi(Hocki hocKi) {
        this.hocKi = hocKi;
    }

    @Id
    @Column(name = "idKyDangKiHocPhan",nullable = false,length = 12)
    public String getIdKyDangKiHocPhan() {
        return idKyDangKiHocPhan;
    }
    public void setIdKyDangKiHocPhan(String idKyDangKiHocPhan) {
        this.idKyDangKiHocPhan = idKyDangKiHocPhan;
    }
    @Basic
    @Column(name="ngayBatDau",nullable = false)
    public Date getNgayBatDau() {
        return ngayBatDau;
    }
    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }
    @Basic
    @Column(name="ngayKetThuc",nullable = false)
    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }
    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
    @OneToMany(targetEntity = Lopdangkihocphan.class,fetch = FetchType.LAZY,mappedBy = "kyDangKiHocPhan")
    public List<Lopdangkihocphan> getDanhSachHocPhan() {
        return danhSachHocPhan;
    }
    public void setDanhSachHocPhan(List<Lopdangkihocphan> dsLopDangKiHocPhan) {
        this.danhSachHocPhan = dsLopDangKiHocPhan;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kydangkihocphan)) return false;
        Kydangkihocphan that = (Kydangkihocphan) o;
        return getIdKyDangKiHocPhan().equals(that.getIdKyDangKiHocPhan())  && getNgayBatDau().equals(that.getNgayBatDau()) && getNgayKetThuc().equals(that.getNgayKetThuc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdKyDangKiHocPhan(), getNgayBatDau(), getNgayKetThuc());
    }
}
