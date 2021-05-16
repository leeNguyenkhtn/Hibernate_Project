package POJO;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Thongtingiaovu {
    private String idGiaoVu;
    private String hoVaTen;
    private Date ngaySinh;
    private String gioiTinh;
    private String soDienThoai;
    private String email;
    private Taikhoan taikhoanByIdGiaoVu;

    @Id
    @Column(name = "idGiaoVu", nullable = false, length = 12)
    public String getIdGiaoVu() {
        return idGiaoVu;
    }

    public void setIdGiaoVu(String idGiaoVu) {
        this.idGiaoVu = idGiaoVu;
    }

    @Basic
    @Column(name = "hoVaTen", nullable = false, length = 45)
    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    @Basic
    @Column(name = "ngaySinh", nullable = false)
    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    @Basic
    @Column(name = "gioiTinh", nullable = false, length = 3)
    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    @Basic
    @Column(name = "soDienThoai", nullable = true, length = 15)
    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Thongtingiaovu that = (Thongtingiaovu) o;
        return Objects.equals(idGiaoVu, that.idGiaoVu) && Objects.equals(hoVaTen, that.hoVaTen) && Objects.equals(ngaySinh, that.ngaySinh) && Objects.equals(gioiTinh, that.gioiTinh) && Objects.equals(soDienThoai, that.soDienThoai) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGiaoVu, hoVaTen, ngaySinh, gioiTinh, soDienThoai, email);
    }

    @OneToOne
    @JoinColumn(name = "idGiaoVu", referencedColumnName = "idTaiKhoan", nullable = false)
    public Taikhoan getTaikhoanByIdGiaoVu() {
        return taikhoanByIdGiaoVu;
    }

    public void setTaikhoanByIdGiaoVu(Taikhoan taikhoanByIdGiaoVu) {
        this.taikhoanByIdGiaoVu = taikhoanByIdGiaoVu;
    }
}
