package POJO;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Lophoc {
    private String idLopHoc;
    private String tenLopHoc;
    private int tongSoSv;
    private int tongSoNam;
    private int tongSoNu;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "Lophoc")
    private List<Sinhvien> dsSinhVien;

    @Id
    @Column(name = "idLopHoc", nullable = false, length = 12)
    public String getIdLopHoc() {
        return idLopHoc;
    }

    public void setIdLopHoc(String idLopHoc) {
        this.idLopHoc = idLopHoc;
    }

    @Basic
    @Column(name = "tenLopHoc", nullable = false, length = 15)
    public String getTenLopHoc() {
        return tenLopHoc;
    }

    public void setTenLopHoc(String tenLopHoc) {
        this.tenLopHoc = tenLopHoc;
    }

    @Basic
    @Column(name = "tongSoSV", nullable = false)
    public int getTongSoSv() {
        return tongSoSv;
    }

    public void setTongSoSv(int tongSoSv) {
        this.tongSoSv = tongSoSv;
    }

    @Basic
    @Column(name = "tongSoNam", nullable = false)
    public int getTongSoNam() {
        return tongSoNam;
    }

    public void setTongSoNam(int tongSoNam) {
        this.tongSoNam = tongSoNam;
    }

    @Basic
    @Column(name = "tongSoNu", nullable = false)
    public int getTongSoNu() {
        return tongSoNu;
    }

    public void setTongSoNu(int tongSoNu) {
        this.tongSoNu = tongSoNu;
    }

    public List<Sinhvien> getDsSinhVien(){
        return dsSinhVien;
    }
    public void setDsSinhVien(List<Sinhvien> dsSinhVien)
    {
        this.dsSinhVien = dsSinhVien;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lophoc lophoc = (Lophoc) o;
        return tongSoSv == lophoc.tongSoSv && tongSoNam == lophoc.tongSoNam && tongSoNu == lophoc.tongSoNu && Objects.equals(idLopHoc, lophoc.idLopHoc) && Objects.equals(tenLopHoc, lophoc.tenLopHoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLopHoc, tenLopHoc, tongSoSv, tongSoNam, tongSoNu);
    }
}
