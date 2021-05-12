package QuanLyDKHP_Mapping;

import java.io.Serializable;
import java.util.Objects;

public class Sinhviendangkihocphan_MappingPK implements Serializable {
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
        Sinhviendangkihocphan_MappingPK that = (Sinhviendangkihocphan_MappingPK) o;
        return Objects.equals(sinhvienIdSinhVien, that.sinhvienIdSinhVien) && Objects.equals(lopDangKiHocPhanIdLopDangKiHopPhan, that.lopDangKiHocPhanIdLopDangKiHopPhan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sinhvienIdSinhVien, lopDangKiHocPhanIdLopDangKiHopPhan);
    }
}
