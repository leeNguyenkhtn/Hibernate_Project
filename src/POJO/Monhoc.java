package POJO;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Monhoc {
    private String idMonHoc;
    private String maMonHoc;
    private String tenMonHoc;
    private int soTinChi;

    @Id
    @Column(name = "idMonHoc", nullable = false, length = 12)
    public String getIdMonHoc() {
        return idMonHoc;
    }

    public void setIdMonHoc(String idMonHoc) {
        this.idMonHoc = idMonHoc;
    }

    @Basic
    @Column(name = "maMonHoc", nullable = false, length = 8)
    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    @Basic
    @Column(name = "tenMonHoc", nullable = false, length = 80)
    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    @Basic
    @Column(name = "soTinChi", nullable = false)
    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monhoc monhoc = (Monhoc) o;
        return soTinChi == monhoc.soTinChi && Objects.equals(idMonHoc, monhoc.idMonHoc) && Objects.equals(maMonHoc, monhoc.maMonHoc) && Objects.equals(tenMonHoc, monhoc.tenMonHoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMonHoc, maMonHoc, tenMonHoc, soTinChi);
    }
}
