package com.example.demo.Jl.personDao;

public class scenicSpots {
    private int scenicSpots;
    private  String SpotsName;
    private  String SpotsJS;
    private String SpotsMP;
    private int SpotsPrice;
    private double SpotsPF;
    private String SpotsPhoto;

    @Override
    public String toString() {
        return "scenicSpots{" +
                "scenicSpots=" + scenicSpots +
                ", SpotsName='" + SpotsName + '\'' +
                ", SpotsJS='" + SpotsJS + '\'' +
                ", SpotsMP='" + SpotsMP + '\'' +
                ", SpotsPrice=" + SpotsPrice +
                ", SpotsPF=" + SpotsPF +
                ", SpotsPhoto='" + SpotsPhoto + '\'' +
                '}';
    }

    public int getScenicSpots() {
        return scenicSpots;
    }

    public void setScenicSpots(int scenicSpots) {
        this.scenicSpots = scenicSpots;
    }

    public String getSpotsName() {
        return SpotsName;
    }

    public void setSpotsName(String spotsName) {
        SpotsName = spotsName;
    }

    public String getSpotsJS() {
        return SpotsJS;
    }

    public void setSpotsJS(String spotsJS) {
        SpotsJS = spotsJS;
    }

    public String getSpotsMP() {
        return SpotsMP;
    }

    public void setSpotsMP(String spotsMP) {
        SpotsMP = spotsMP;
    }

    public int getSpotsPrice() {
        return SpotsPrice;
    }

    public void setSpotsPrice(int spotsPrice) {
        SpotsPrice = spotsPrice;
    }

    public double getSpotsPF() {
        return SpotsPF;
    }

    public void setSpotsPF(double spotsPF) {
        SpotsPF = spotsPF;
    }

    public String getSpotsPhoto() {
        return SpotsPhoto;
    }

    public void setSpotsPhoto(String spotsPhoto) {
        SpotsPhoto = spotsPhoto;
    }
}
