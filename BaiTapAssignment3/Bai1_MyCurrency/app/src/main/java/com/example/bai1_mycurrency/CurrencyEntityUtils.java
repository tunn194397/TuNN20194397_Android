package com.example.bai1_mycurrency;

public class CurrencyEntityUtils {
    public static CurrencyEntity[] getCurrency()  {
        CurrencyEntity ce1 = new CurrencyEntity("VND", "đ","Việt Nam",  1);
        CurrencyEntity ce2 = new CurrencyEntity("USD", "$","Mĩ", 23177);
        CurrencyEntity ce3 = new CurrencyEntity("Yên", "¥", "Nhật", 172);
        CurrencyEntity ce4 = new CurrencyEntity("Yuan", "¥", "Trung Quốc", 3455);
        CurrencyEntity ce5 = new CurrencyEntity("Bảng", "£", "Anh" ,28550);
        CurrencyEntity ce6 = new CurrencyEntity("Euro", "€", "Châu Âu", 24379);
        return new CurrencyEntity[] {ce1, ce2, ce3, ce4, ce5, ce6};
    }
}
