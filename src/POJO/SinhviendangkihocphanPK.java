package POJO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SinhviendangkihocphanPK implements Serializable {
    private String idSinhVien;
    private String idHocPhan;

    public String getIdSinhVien() {
        return idSinhVien;
    }

    public void setIdSinhVien(String idSinhVien) {
        this.idSinhVien = idSinhVien;
    }

    public String getIdHocPhan() {
        return idHocPhan;
    }

    public void setIdHocPhan(String idHocPhan) {
        this.idHocPhan = idHocPhan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SinhviendangkihocphanPK)) return false;
        SinhviendangkihocphanPK that = (SinhviendangkihocphanPK) o;
        return Objects.equals(getIdSinhVien(), that.getIdSinhVien()) && Objects.equals(getIdHocPhan(), that.getIdHocPhan());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdSinhVien(), getIdHocPhan());
    }
}
