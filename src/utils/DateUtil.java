package utils;

import CONST_CODE.Code;

import java.sql.Date;

public class DateUtil {
    public static int CompareTwoDate(Date date1,Date date2)
    {
        int compare = date1.compareTo(date2);
        if(compare<0)
        {
            return Code.NGAY_TRUOC_BE_HON_NGAY_SAU;
        }
        else
        {
            return Code.NGAY_TRUOC_LON_HON_NGAY_SAU;
        }
    }
    public static int CompareToToday(Date date)
    {
        Date today = Date.valueOf(java.time.LocalDate.now());
        int compare = date.compareTo(today);
        if(compare<0)
        {
            return Code.TRUOC_NGAY_HIEN_TAI;
        }
        else
        {
            return Code.SAU_NGAY_HIEN_TAI;
        }
    }

}
