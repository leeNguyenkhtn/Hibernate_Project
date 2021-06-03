package BUS;
import DAO.DAO_TaiKhoan;
import POJO.Taikhoan;

import java.util.List;

public class BUS_TaiKhoan {
    public static String check(String tenDangNhap, String matKhau)
    {
        if(matKhau.equals(""))
        {
            return "Không được để trống mật khẩu";
        }
        else if(tenDangNhap.equals(""))
        {
            return "Không được để trống tên đăng nhập";
        }
        if(matKhau.contains(" "))
        {
            return "Mật khẩu không được chứa khoảng trắng";
        }
        else if (tenDangNhap.contains(" "))
        {
            return "Tên đăng nhập không được chứa khoảng trắng";
        }
        Taikhoan tk = DAO_TaiKhoan.findTaiKhoanByUserName(tenDangNhap);
        if(tk==null)
        {
            return "Tài khoản hoặc mật khẩu không chính xác";
        }
        if(tk.getTenDangNhap().equals(tenDangNhap)&&tk.getMatKhau().equals(matKhau))
        {

            return tk.getDinhDanh();
        }
        else
        {
            return "Tài khoản hoặc mật khẩu không chính xác";
        }
    }
    public static String findIdByTenDangNhap(String tenDangNhap)
    {
        String result = null;
        result = DAO_TaiKhoan.findTaiKhoanByUserName(tenDangNhap).getIdTaiKhoan();
        return result;
    }
}
