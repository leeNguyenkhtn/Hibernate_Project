package QuanLyDKHP_Mapping;

import java.util.Objects;

public class Taikhoan_Mapping {
    private String idTaiKhoan;
    private String tenDangNhap;
    private String matKhau;

    public String getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(String idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taikhoan_Mapping that = (Taikhoan_Mapping) o;
        return Objects.equals(idTaiKhoan, that.idTaiKhoan) && Objects.equals(tenDangNhap, that.tenDangNhap) && Objects.equals(matKhau, that.matKhau);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTaiKhoan, tenDangNhap, matKhau);
    }
}
