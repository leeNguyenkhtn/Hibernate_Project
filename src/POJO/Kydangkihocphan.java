package POJO;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
@Entity
public class Kydangkihocphan {


    private String idKyDangKiHocPhan;
    private String idHocKi;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private List<Lopdangkihocphan> dsLopDangKiHocPhan;
    private Hocki hocKi;
    @Id
    @Column(name = "idKyDangKiHocPhan",nullable = false,length = 12)
    public String getIdKyDangKiHocPhan() {
        return idKyDangKiHocPhan;
    }
    public void setIdKyDangKiHocPhan(String idKyDangKiHocPhan) {
        this.idKyDangKiHocPhan = idKyDangKiHocPhan;
    }
    @Basic
    @Column(name = "idHocKi",length = 12)
    public String getIdHocKi() {
        return idHocKi;
    }
    public void setIdHocKi(String idHocKi) {
        this.idHocKi = idHocKi;
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
    public List<Lopdangkihocphan> getDsLopDangKiHocPhan() {
        return dsLopDangKiHocPhan;
    }
    public void setDsLopDangKiHocPhan(List<Lopdangkihocphan> dsLopDangKiHocPhan) {
        this.dsLopDangKiHocPhan = dsLopDangKiHocPhan;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kydangkihocphan)) return false;
        Kydangkihocphan that = (Kydangkihocphan) o;
        return getIdKyDangKiHocPhan().equals(that.getIdKyDangKiHocPhan()) && Objects.equals(getIdHocKi(), that.getIdHocKi()) && getNgayBatDau().equals(that.getNgayBatDau()) && getNgayKetThuc().equals(that.getNgayKetThuc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdKyDangKiHocPhan(), getIdHocKi(), getNgayBatDau(), getNgayKetThuc());
    }
}