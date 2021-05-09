package hibernate_pojo;

import java.util.Objects;

public class Sinhvien_POJO {
    private String idSinhVien;
    private String hoVaTen;
    private Double diem;

    public String getIdSinhVien() {
        return idSinhVien;
    }

    public void setIdSinhVien(String idSinhVien) {
        this.idSinhVien = idSinhVien;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public Double getDiem() {
        return diem;
    }

    public void setDiem(Double diem) {
        this.diem = diem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sinhvien_POJO that = (Sinhvien_POJO) o;
        return Objects.equals(idSinhVien, that.idSinhVien) && Objects.equals(hoVaTen, that.hoVaTen) && Objects.equals(diem, that.diem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSinhVien, hoVaTen, diem);
    }
}
