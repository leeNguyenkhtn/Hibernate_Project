package QuanLyDKHP_Mapping;

import java.util.Objects;

public class Lophoc_Mapping {
    private String idLopHoc;
    private String tenLopHoc;
    private int tongSoSv;
    private int tongSoNam;
    private int tongSoNu;

    public String getIdLopHoc() {
        return idLopHoc;
    }

    public void setIdLopHoc(String idLopHoc) {
        this.idLopHoc = idLopHoc;
    }

    public String getTenLopHoc() {
        return tenLopHoc;
    }

    public void setTenLopHoc(String tenLopHoc) {
        this.tenLopHoc = tenLopHoc;
    }

    public int getTongSoSv() {
        return tongSoSv;
    }

    public void setTongSoSv(int tongSoSv) {
        this.tongSoSv = tongSoSv;
    }

    public int getTongSoNam() {
        return tongSoNam;
    }

    public void setTongSoNam(int tongSoNam) {
        this.tongSoNam = tongSoNam;
    }

    public int getTongSoNu() {
        return tongSoNu;
    }

    public void setTongSoNu(int tongSoNu) {
        this.tongSoNu = tongSoNu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lophoc_Mapping that = (Lophoc_Mapping) o;
        return tongSoSv == that.tongSoSv && tongSoNam == that.tongSoNam && tongSoNu == that.tongSoNu && Objects.equals(idLopHoc, that.idLopHoc) && Objects.equals(tenLopHoc, that.tenLopHoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLopHoc, tenLopHoc, tongSoSv, tongSoNam, tongSoNu);
    }
}
