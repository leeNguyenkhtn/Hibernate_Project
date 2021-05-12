package QuanLyDKHP_Mapping;

import java.util.Objects;

public class Monhoc_Mapping {
    private String idMonHoc;
    private String maMonHoc;
    private String tenMonHoc;
    private int soTinChi;

    public String getIdMonHoc() {
        return idMonHoc;
    }

    public void setIdMonHoc(String idMonHoc) {
        this.idMonHoc = idMonHoc;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

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
        Monhoc_Mapping that = (Monhoc_Mapping) o;
        return soTinChi == that.soTinChi && Objects.equals(idMonHoc, that.idMonHoc) && Objects.equals(maMonHoc, that.maMonHoc) && Objects.equals(tenMonHoc, that.tenMonHoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMonHoc, maMonHoc, tenMonHoc, soTinChi);
    }
}
