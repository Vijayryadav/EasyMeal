package com.example.easymeal;

public class TiffinCenter {

    String name;
    String tcAddress;
    String pricing;
    int image;


    TiffinCenter(String name, String tcAddress, String pricing, int image){
        this.name=name;
        this.tcAddress= tcAddress;
        this.pricing = pricing;
        this.image= image;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTcAddress() {
        return tcAddress;
    }

    public void setTcAddress(String tcAddress) {
        this.tcAddress = tcAddress;
    }

    public String getPricing() {
        return pricing;
    }

    public void setPricing(String pricing) {
        this.pricing = pricing;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
