package com.example.priyanka.qrbarcodescanner;

/**
 * Created by TIBIWORLD on 19.01.2018.
 */

public class Product {
    private int id;
    private String name;
    private String tip;
    private  String valEnerget ;



    private  String grasimi;
    private  String glucide ;
    private  String proteine ;
    private  String sare ;
    private  String barcode;



    public Product(String name, String tip, String valEnerget, String grasimi, String glucide, String proteine, String sare, String barcode) {
        this.name = name;
        this.tip = tip;

        this.valEnerget = valEnerget;
        this.grasimi = grasimi;
        this.glucide = glucide;
        this.proteine = proteine;
        this.sare = sare;
        this.barcode = barcode;
    }

    public Product(int id, String name, String tip,String valEnerget,String grasimi,String glucide,String proteine,String sare,String barcode) {
        this.id = id;
        this.name = name;
        this.tip = tip;
        this.valEnerget = valEnerget;
        this.grasimi = grasimi;
        this.glucide = glucide;
        this.proteine = proteine;
        this.sare = sare;
        this.barcode = barcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTip() {
        return tip;
    }
    public String getGlucide() {
        return glucide;
    }

    public void setGlucide(String glucide) {
        this.glucide = glucide;
    }

    public String getProteine() {
        return proteine;
    }

    public void setProteine(String proteine) {
        this.proteine = proteine;
    }

    public String getSare() {
        return sare;
    }

    public void setSare(String sare) {
        this.sare = sare;
    }

    public String getGrasimi() {

        return grasimi;
    }

    public void setGrasimi(String grasimi) {
        this.grasimi = grasimi;
    }

    public String getValEnerget() {

        return valEnerget;
    }
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setValEnerget(String valEnerget) {
        this.valEnerget = valEnerget;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
