package BUS;

import DAO.DAO_SinhVien;
import POJO.Sinhvien;

public class BUS_SinhVien {
    public static Sinhvien loadSinhVienById(String id)
    {
        Sinhvien sinhvien =DAO_SinhVien.getSinhVienById(id);
        return sinhvien;
    }
}

