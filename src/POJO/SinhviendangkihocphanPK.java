package POJO;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SinhviendangkihocphanPK implements Serializable {
    private String sinhvienIdSinhVien;
    private String lopDangKiHocPhanIdLopDangKiHopPhan;

    @Column(name = "sinhvien_idSinhVien", nullable = false, length = 8)
    @Id
    public String getSinhvienIdSinhVien() {
        return sinhvienIdSinhVien;
    }

    public void setSinhvienIdSinhVien(String sinhvienIdSinhVien) {
        this.sinhvienIdSinhVien = sinhvienIdSinhVien;
    }

    @Column(name = "LopDangKiHocPhan_idLopDangKiHopPhan", nullable = false, length = 45)
    @Id
    public String getLopDangKiHocPhanIdLopDangKiHopPhan() {
        return lopDangKiHocPhanIdLopDangKiHopPhan;
    }

    public void setLopDangKiHocPhanIdLopDangKiHopPhan(String lopDangKiHocPhanIdLopDangKiHopPhan) {
        this.lopDangKiHocPhanIdLopDangKiHopPhan = lopDangKiHocPhanIdLopDangKiHopPhan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinhviendangkihocphanPK that = (SinhviendangkihocphanPK) o;
        return Objects.equals(sinhvienIdSinhVien, that.sinhvienIdSinhVien) && Objects.equals(lopDangKiHocPhanIdLopDangKiHopPhan, that.lopDangKiHocPhanIdLopDangKiHopPhan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sinhvienIdSinhVien, lopDangKiHocPhanIdLopDangKiHopPhan);
    }
}
