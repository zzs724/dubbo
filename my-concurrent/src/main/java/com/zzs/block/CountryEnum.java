package com.zzs.block;

public enum  CountryEnum {
    ONE(1,"齐"),
    TOW(2,"楚"),
    THREE(3,"燕"),
    FOUR(4,"赵"),
    FIVE(5,"韩"),
    SIX(6,"魏");

    private Integer recode;
    private String retMessage;

    public static CountryEnum forEach_CountryEnum(int index)
    {
        CountryEnum[] myArray = CountryEnum.values();
        for (CountryEnum element : myArray) {
            if (index == element.recode) {
                return element;
            }
        }
        return null;
    }

    CountryEnum(Integer recode, String retMessage) {
        this.recode = recode;
        this.retMessage = retMessage;
    }

    public Integer getRecode() {
        return recode;
    }

    public void setRecode(Integer recode) {
        this.recode = recode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    public void setRetMessage(String retMessage) {
        this.retMessage = retMessage;
    }
}
