package POJO;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(SinhviendangkihocphanPK.class)
public class Sinhviendangkihocphan {
    private String sinhvienIdSinhVien;
    private String lopDangKiHocPhanIdLopDangKiHopPhan;
    private Sinhvien sinhvienBySinhvienIdSinhVien;
    private Lopdangkihocphan lopdangkihocphanByLopDangKiHocPhanIdLopDangKiHopPhan;

    @Id
    @Column(name = "sinhvien_idSinhVien", nullable = false, length = 8)
    public String getSinhvienIdSinhVien() {
        return sinhvienIdSinhVien;
    }

    public void setSinhvienIdSinhVien(String sinhvienIdSinhVien) {
        this.sinhvienIdSinhVien = sinhvienIdSinhVien;
    }

    @Id
    @Column(name = "LopDangKiHocPhan_idLopDangKiHopPhan", nullable = false, length = 45)
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
        Sinhviendangkihocphan that = (Sinhviendangkihocphan) o;
        return Objects.equals(sinhvienIdSinhVien, that.sinhvienIdSinhVien) && Objects.equals(lopDangKiHocPhanIdLopDangKiHopPhan, that.lopDangKiHocPhanIdLopDangKiHopPhan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sinhvienIdSinhVien, lopDangKiHocPhanIdLopDangKiHopPhan);
    }

    @ManyToOne
    @JoinColumn(name = "sinhvien_idSinhVien", referencedColumnName = "idSinhVien", nullable = false)
    public Sinhvien getSinhvienBySinhvienIdSinhVien() {
        return sinhvienBySinhvienIdSinhVien;
    }

    public void setSinhvienBySinhvienIdSinhVien(Sinhvien sinhvienBySinhvienIdSinhVien) {
        this.sinhvienBySinhvienIdSinhVien = sinhvienBySinhvienIdSinhVien;
    }

    @ManyToOne
    @JoinColumn(name = "LopDangKiHocPhan_idLopDangKiHopPhan", referencedColumnName = "idLopDangKiHopPhan", nullable = false)
    public Lopdangkihocphan getLopdangkihocphanByLopDangKiHocPhanIdLopDangKiHopPhan() {
        return lopdangkihocphanByLopDangKiHocPhanIdLopDangKiHopPhan;
    }

    public void setLopdangkihocphanByLopDangKiHocPhanIdLopDangKiHopPhan(Lopdangkihocphan lopdangkihocphanByLopDangKiHocPhanIdLopDangKiHopPhan) {
        this.lopdangkihocphanByLopDangKiHocPhanIdLopDangKiHopPhan = lopdangkihocphanByLopDangKiHocPhanIdLopDangKiHopPhan;
    }
}
