package QuanLyDKHP_Mapping;

import java.sql.Date;
import java.util.Objects;

public class Thongtingiaovu_Mapping {
    private String idGiaoVu;
    private String hoVaTen;
    private Date ngaySinh;
    private String gioiTinh;
    private String soDienThoai;
    private String email;

    public String getIdGiaoVu() {
        return idGiaoVu;
    }

    public void setIdGiaoVu(String idGiaoVu) {
        this.idGiaoVu = idGiaoVu;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

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
        Thongtingiaovu_Mapping that = (Thongtingiaovu_Mapping) o;
        return Objects.equals(idGiaoVu, that.idGiaoVu) && Objects.equals(hoVaTen, that.hoVaTen) && Objects.equals(ngaySinh, that.ngaySinh) && Objects.equals(gioiTinh, that.gioiTinh) && Objects.equals(soDienThoai, that.soDienThoai) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGiaoVu, hoVaTen, ngaySinh, gioiTinh, soDienThoai, email);
    }
}
