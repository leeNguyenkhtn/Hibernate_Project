package POJO;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class SinhviendangkihocphanPK implements Serializable {
    private String sinhvienIdSinhVien;
    private String lopDangKiHocPhanIdLopDangKiHopPhan;

    public String getSinhvienIdSinhVien() {
        return sinhvienIdSinhVien;
    }

    public void setSinhvienIdSinhVien(String sinhvienIdSinhVien) {
        this.sinhvienIdSinhVien = sinhvienIdSinhVien;
    }

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
