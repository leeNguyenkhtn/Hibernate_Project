package BUS;

import CONST_CODE.Code;
import DAO.DAO_TaiKhoan;
import DAO.DAO_Thongtingiaovu;
import POJO.Taikhoan;
import POJO.Thongtingiaovu;
import java.sql.Date;
import java.util.List;

public class BUS_GiaoVu {
    public static String themGiaoVu(String tenDangNhap, String matKhau, String hoVaTen, Date ngaySinh,
                                            String gioiTinh,String soDienThoai,String email)
    {
        if(tenDangNhap.contains(" ")||matKhau.contains(" "))
        {
            return "NoSpace";
        }
        else if(tenDangNhap.equals("")||matKhau.equals(""))
        {
            return "NotNull";
        }
        String id = DAO_TaiKhoan.createRecord(tenDangNhap,matKhau,"giaovu");
        Thongtingiaovu giaoVu = new Thongtingiaovu();
        giaoVu.setIdGiaoVu(id);
        giaoVu.setHoVaTen(hoVaTen);
        giaoVu.setNgaySinh(ngaySinh);
        giaoVu.setGioiTinh(gioiTinh);
        giaoVu.setEmail(email);
        giaoVu.setSoDienThoai(soDienThoai);
        if(DAO_Thongtingiaovu.creatRecord(giaoVu))
        {
            return id;
        }
        else
        {
            return "Failed";
        }
    }
    public static List<Thongtingiaovu> danhSachGiaoVu()
    {
        return DAO_Thongtingiaovu.displayRecord();
    }
    public static boolean xoaGiaoVu(int i)
    {
        List<Thongtingiaovu> dsGiaoVu = danhSachGiaoVu();
        Thongtingiaovu giaoVu = dsGiaoVu.get(i);
        String id = giaoVu.getIdGiaoVu();
        DAO_Thongtingiaovu.deleteRecord(id);
        return DAO_TaiKhoan.deleteRecord(id);
    }
    public static boolean capNhatGiaoVu(int i, String hoVaTen,String ngaySinh,
                                        String gioiTinh, String soDienThoai,String email)
    {
        List<Thongtingiaovu> dsGiaoVu = danhSachGiaoVu();
        Thongtingiaovu thongTinMoi = dsGiaoVu.get(i);
        thongTinMoi.setHoVaTen(hoVaTen);
        Date ngaySinhDate = Date.valueOf(ngaySinh);
        thongTinMoi.setNgaySinh(ngaySinhDate);
        thongTinMoi.setGioiTinh(gioiTinh);
        thongTinMoi.setSoDienThoai(soDienThoai);
        thongTinMoi.setEmail(email);
        return DAO_Thongtingiaovu.updateRecord(thongTinMoi.getIdGiaoVu(),thongTinMoi);
    }
    public static String timIdBangTenDangNhap(String tenDangNhap)
    {
        Taikhoan taikhoan = DAO_TaiKhoan.findTaiKhoanByUserName(tenDangNhap);
        if(taikhoan==null)
        {
            return null;
        }
        return taikhoan.getIdTaiKhoan();
    }
    public static int resetMatKhau(String tenDangNhap)
    {
        Taikhoan taikhoan = DAO_TaiKhoan.findTaiKhoanByUserName(tenDangNhap);
        if(taikhoan==null)
        {
            return Code.TEN_DANG_NHAP_KHONG_TON_TAI;
        }
        String matKhauCu = taikhoan.getMatKhau();
        return DAO_TaiKhoan.updatePassword(tenDangNhap,taikhoan.getMatKhau(),tenDangNhap);
    }
}
