package BUS;

import CONST_CODE.Code;
import DAO.DAO_LopHoc;
import DAO.DAO_SinhVien;
import POJO.Lophoc;
import POJO.Sinhvien;

import java.util.List;

public class BUS_LopHoc {
    public static List<Lophoc> danhSachLopHoc = DAO_LopHoc.displayRecord();
    private static void capNhatDanhSachLopHoc()
    {
        danhSachLopHoc = DAO_LopHoc.displayRecord();
    }
    public static int themSinhVienVaoLopHoc(String maSoSV,String idLopHoc)
    {
        if(idLopHoc == null||maSoSV==null)
        {
            return Code.KHONG_DUOC_BO_TRONG;
        }
        String idSinhVien = DAO_SinhVien.getIdSinhVienByMSSV(maSoSV);
        if(idSinhVien!=null)
        {
            return DAO_SinhVien.setLopHoc(idSinhVien,idLopHoc);
        }
        return Code.DOI_TUONG_KHONG_TON_TAI;
    }
    public static int themLopHoc(String tenLopHoc)
    {
        if(tenLopHoc==null)
        {
            return Code.KHONG_DUOC_BO_TRONG;
        }
        for(Lophoc lh:danhSachLopHoc)
        {
            if(lh.getTenLopHoc().equals(tenLopHoc))
            {
                return Code.BI_TRUNG;
            }
        }
        Lophoc lophoc = new Lophoc();
        lophoc.setIdLopHoc(utils.GenerateIdUtil.RandomId());
        lophoc.setTenLopHoc(tenLopHoc);
        lophoc.setTongSoNu(0);
        lophoc.setTongSoSv(0);
        lophoc.setTongSoNam(0);
        int state = DAO_LopHoc.createRecord(lophoc);
        if(state==Code.THANH_CONG)
        {
            capNhatDanhSachLopHoc();
        }
        return state;
    }
    public static int xoaLopHoc(int index)
    {
        if(index<0||index>danhSachLopHoc.size())
        {
            return Code.CHI_SO_KHONG_HOP_LE;
        }
        String idLopHoc = danhSachLopHoc.get(index).getIdLopHoc();
        int state = DAO_LopHoc.deleteRecord(idLopHoc);
        if(state==Code.THANH_CONG)
        {
            capNhatDanhSachLopHoc();
        }
        return  state;
    }
    public static List<Sinhvien> danhSachSinhVien(String idLopHoc)
    {
        if(idLopHoc==null)
        {
            return null;
        }
        return DAO_LopHoc.getListSinhVien(idLopHoc);
    }
}
