package BUS;
import CONST_CODE.Code;
import DAO.DAO_LopDangKiHocPhan;
import DAO.DAO_LopHoc;
import DAO.DAO_MonHoc;
import POJO.*;
import utils.GenerateIdUtil;

import DAO.DAO_KyDangKiHocPhan;

import java.util.List;
import java.util.Set;

public class BUS_LopDangKiHocPhan {
    public static List<Lopdangkihocphan> danhSachHocPhan = danhSachHocPhan();
    public static List<Lopdangkihocphan> danhSachHocPhan()
    {
        if(BUS_KyDangKiHocPhan.kyDangKyHocPhanHienTai !=null)
        {
            return DAO_KyDangKiHocPhan.getListHocPhan(BUS_KyDangKiHocPhan.kyDangKyHocPhanHienTai.getIdKyDangKiHocPhan());
        }
        return null;
    }
    public static void capNhatDanhSachHocPhan()
    {
        danhSachHocPhan = danhSachHocPhan();
    }
    public static int themHocPhanMoi(String idMonHoc,String idLopHoc,String giaoVienLiTuyet,
                                     String tenPhongHoc, String buoiHoc, String caHoc,int siSo)
    {
        if(idMonHoc!=null&&idLopHoc!=null&&giaoVienLiTuyet!=null&&tenPhongHoc!=null
            && buoiHoc!=null&&caHoc!=null&&siSo>0)
        {
            Lopdangkihocphan hocPhan = new Lopdangkihocphan();
            Lophoc lophoc = DAO_LopHoc.getLopHocById(idLopHoc);
            Monhoc monhoc = DAO_MonHoc.getMonHocById(idMonHoc);
            hocPhan.setIdLopDangKiHocPhan(GenerateIdUtil.RandomId());
            if(monhoc!=null)
            {
                hocPhan.setMonHoc(monhoc);
            }
            else
            {
                return Code.MON_HOC_KHONG_HOP_LE;
            }
            if(lophoc!=null)
            {
                hocPhan.setLopHoc(lophoc);
            }
            else
            {
                return Code.LOP_HOC_KHONG_HOP_LE;
            }
            if(BUS_KyDangKiHocPhan.kyDangKyHocPhanHienTai !=null)
            {
                hocPhan.setKyDangKiHocPhan(BUS_KyDangKiHocPhan.kyDangKyHocPhanHienTai);
            }
            else
            {
                return Code.CHUA_CO_KY_DANG_KI_HOC_PHAN;
            }
            hocPhan.setGiaoVienLiThuyet(giaoVienLiTuyet);
            hocPhan.setTenPhongHoc(tenPhongHoc);
            hocPhan.setBuoiHoc(buoiHoc);
            hocPhan.setCaHoc(caHoc);
            hocPhan.setSiSo(siSo);
            if(DAO_LopDangKiHocPhan.createRecord(hocPhan)==Code.THANH_CONG)
            {
                capNhatDanhSachHocPhan();
                return Code.THANH_CONG;
            }
        }
        return Code.THAT_BAI;
    }
    public static List<Sinhviendangkihocphan> layDanhSachSinhVienDangKy(String idHocPhan)
    {
        if(idHocPhan!=null)
        {

            return DAO_LopDangKiHocPhan.listSinhVienInHocPhan(idHocPhan);
        }
        return null;
    }
    public static int xoaHocPhan(int index)
    {

        if(index>=0&&index<danhSachHocPhan.size())
        {
            String idHocPhan = danhSachHocPhan.get(index).getIdLopDangKiHocPhan();
            if(DAO_LopDangKiHocPhan.deleteRecord(idHocPhan)==Code.THANH_CONG)
            {
                capNhatDanhSachHocPhan();
                return Code.THANH_CONG;
            }
            return Code.THAT_BAI;
        }
        return Code.CHI_SO_KHONG_HOP_LE;
    }
    public static List<Sinhviendangkihocphan> danhSachSinhVienDangKi(String idHocPhan)
    {
        if(idHocPhan!=null)
        {
            return DAO_LopDangKiHocPhan.listSinhVienInHocPhan(idHocPhan);
        }
        return null;
    }
}
