package POJO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Taikhoan implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idTaiKhoan;
    private String tenDangNhap;
    private String matKhau;
    private String dinhDanh;

    @Id
    @Column(name = "idTaiKhoan", nullable = false, length = 12)
    public String getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(String idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    @Basic
    @Column(name = "tenDangNhap", nullable = false, length = 45)
    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    @Basic
    @Column(name = "matKhau", nullable = false, length = 45)
    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Basic
    @Column(name = "dinhDanh", nullable = false)
    public String getDinhDanh() {
        return dinhDanh;
    }
    public void setDinhDanh(String dinhDanh) {
        this.dinhDanh = dinhDanh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taikhoan taikhoan = (Taikhoan) o;
        return Objects.equals(idTaiKhoan, taikhoan.idTaiKhoan) && Objects.equals(tenDangNhap, taikhoan.tenDangNhap) && Objects.equals(matKhau, taikhoan.matKhau) && Objects.equals(dinhDanh, taikhoan.dinhDanh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTaiKhoan, tenDangNhap, matKhau, dinhDanh);
    }


    @Override
    public String toString() {
        return "Taikhoan{" +
                "idTaiKhoan='" + idTaiKhoan + '\'' +
                ", tenDangNhap='" + tenDangNhap + '\'' +
                ", matKhau='" + matKhau + '\'' +
                ", dinhDanh='" + dinhDanh + '\'' +
                '}';
    }
}
