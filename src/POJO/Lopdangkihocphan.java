package POJO;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Lopdangkihocphan {
    private String idLopDangKiHocPhan;
    private String giaoVienLiThuyet;
    private String tenPhongHoc;
    private String buoiHoc;
    private String caHoc;
    private int siSo;
    private int soLuongDaDangKy;
    private Monhoc monHoc;
    private Lophoc lopHoc;
    private List<Sinhvien> danhSachSinhVienTrongLop;
    private Kydangkihocphan kyDangKiHocPhan;
    @Id
    @Column(name = "idLopDangKiHocPhan", nullable = false, length = 12)
    public String getIdLopDangKiHocPhan() {
        return idLopDangKiHocPhan;
    }

    public void setIdLopDangKiHocPhan(String idLopDangKiHopPhan) {
        this.idLopDangKiHocPhan = idLopDangKiHopPhan;
    }

    @Basic
    @Column(name = "giaoVienLiThuyet", nullable = false, length = 45)
    public String getGiaoVienLiThuyet() {
        return giaoVienLiThuyet;
    }

    public void setGiaoVienLiThuyet(String giaoVienLiThuyet) {
        this.giaoVienLiThuyet = giaoVienLiThuyet;
    }

    @Basic
    @Column(name = "tenPhongHoc", nullable = false, length = 5)
    public String getTenPhongHoc() {
        return tenPhongHoc;
    }

    public void setTenPhongHoc(String tenPhongHoc) {
        this.tenPhongHoc = tenPhongHoc;
    }

    @Basic
    @Column(name = "buoiHoc", nullable = false)
    public String getBuoiHoc() {
        return buoiHoc;
    }

    public void setBuoiHoc(String buoiHoc) {
        this.buoiHoc = buoiHoc;
    }

    @Basic
    @Column(name = "caHoc", nullable = false)
    public String getCaHoc() {
        return caHoc;
    }

    public void setCaHoc(String caHoc) {
        this.caHoc = caHoc;
    }

    @Basic
    @Column(name = "siSo", nullable = false)
    public int getSiSo() {
        return siSo;
    }

    public void setSiSo(int siSo) {
        this.siSo = siSo;
    }

    @Basic
    @Column(name = "soLuongDaDangKy", nullable = false)
    public int getSoLuongDaDangKy() {
        return soLuongDaDangKy;
    }

    public void setSoLuongDaDangKy(int soLuongDaDangKy) {
        this.soLuongDaDangKy = soLuongDaDangKy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lopdangkihocphan that = (Lopdangkihocphan) o;
        return siSo == that.siSo && soLuongDaDangKy == that.soLuongDaDangKy && Objects.equals(idLopDangKiHocPhan, that.idLopDangKiHocPhan) && Objects.equals(giaoVienLiThuyet, that.giaoVienLiThuyet) && Objects.equals(tenPhongHoc, that.tenPhongHoc) && Objects.equals(buoiHoc, that.buoiHoc) && Objects.equals(caHoc, that.caHoc);
    }
    @Override
    public int hashCode() {
        return Objects.hash(idLopDangKiHocPhan, giaoVienLiThuyet, tenPhongHoc, buoiHoc, caHoc, siSo, soLuongDaDangKy);
    }

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "danhSachDangKiHocPhan")
    public List<Sinhvien> getDanhSachSinhVienTrongLop() {
        return danhSachSinhVienTrongLop;
    }
    public void setDanhSachSinhVienTrongLop(List<Sinhvien> danhSachSinhVienTrongLop) {
        this.danhSachSinhVienTrongLop = danhSachSinhVienTrongLop;
    }
    @ManyToOne
    @JoinColumn(name="MonHoc_idMonHoc",referencedColumnName = "idMonHoc")
    public Monhoc getMonHoc(){ return monHoc;}
    public void setMonHoc(Monhoc idMonHoc){
        this.monHoc = idMonHoc;
    }
    @ManyToOne
    @JoinColumn(name = "LopHoc_idLopHoc",referencedColumnName = "idLopHoc")
    public Lophoc getLopHoc(){ return lopHoc;}
    public void setLopHoc(Lophoc idlopHoc) {
        this.lopHoc = idlopHoc;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="KyDangKiHocPhan_idKyDangKiHocPhan",referencedColumnName = "idKyDangKiHocPhan")
    public Kydangkihocphan getKyDangKiHocPhan() {
        return kyDangKiHocPhan;
    }
    public void setKyDangKiHocPhan(Kydangkihocphan kyDangKiHocPhan) {
        this.kyDangKiHocPhan = kyDangKiHocPhan;
    }
}
