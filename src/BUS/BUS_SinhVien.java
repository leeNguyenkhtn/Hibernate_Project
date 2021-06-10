package BUS;

import DAO.DAO_SinhVien;
import POJO.Sinhvien;

public class BUS_SinhVien {
    public static Sinhvien loadSinhVienById(String id)
    {
        return DAO_SinhVien.getSinhVienById(id);
    }
}

