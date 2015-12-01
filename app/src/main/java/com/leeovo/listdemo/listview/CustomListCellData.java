package com.leeovo.listdemo.listview;

/**
 * Created by leeovo on 2015/11/25.
 *
 */
public class CustomListCellData {

    public CustomListCellData(String name, String dec, int iconID, String paiming){

        this.name = name;
        this.dec = dec;
        this.iconID = iconID;
        this.paiming = paiming;


    }

    public String getPaiming() {

        return paiming;
    }

    public void setPaiming(String paiming) {
        this.paiming = paiming;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }

    public int getIconID() {
        return iconID;
    }

    public void setIconID(int iconID) {
        this.iconID = iconID;
    }

    private String name = "";
    private String dec = "";
    private int iconID = 0;
    private String paiming  ;

}
