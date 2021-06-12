package BUS;

import CONST_CODE.Code;
import DAO.DAO_LopDangKiHocPhan;
import DAO.DAO_SinhVien;
import POJO.Lopdangkihocphan;
import POJO.Sinhvien;
import POJO.Sinhviendangkihocphan;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BUS_SinhVien {
    public List<Lopdangkihocphan> danhSachHocPhan = BUS_LopDangKiHocPhan.danhSachHocPhan();
    public String idSinhVien;
    public BUS_SinhVien(String idSinhVien)
    {
        this.idSinhVien = idSinhVien;
        capNhatDanhSachMonHoc();
    }
    public void capNhatDanhSachMonHoc()
    {
        danhSachHocPhan = BUS_LopDangKiHocPhan.danhSachHocPhan();
    }
    public int dangKiHocPhan(int index)
    {
        if(index<0||index>danhSachHocPhan.size())
        {
            return Code.THAT_BAI;
        }
        Date today = Date.valueOf(java.time.LocalDate.now());
        int state = DAO_SinhVien.createNewRegister(idSinhVien,
                danhSachHocPhan.get(index).getIdLopDangKiHocPhan(),today);
        if(state==Code.THANH_CONG)
        {
            capNhatDanhSachMonHoc();
        }
        return state;
    }
    public static Sinhvien loadSinhVienById(String id)
    {
        return DAO_SinhVien.getSinhVienById(id);
    }

}

