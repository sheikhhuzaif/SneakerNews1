package com.example.sneakernews;

import androidx.annotation.NonNull;

public class NewReleases {
    private String RName;
    private String RImage;
    private String RDate;
    private String RPrice;

    public String getRName() {
        return RName;
    }

    public void setRName(String RName) {
        this.RName = RName;
    }

    public String getRImage() {
        return RImage;
    }

    public void setRImage(String RImage) {
        this.RImage = RImage;
    }

    public String getRDate() {
        return RDate;
    }

    public void setRDate(String RDate) {
        this.RDate = RDate;
    }

    public String getRPrice() {
        return RPrice;
    }

    public void setRPrice(String RPrice) {
        this.RPrice = RPrice;
    }

    @NonNull
    @Override
    public String toString() {
        return "Name:" + RName + '\n' +
                "Image URL:" + RImage + '\n' +
                "Release Date:" + RDate + '\n' +
                "Retail Price:" + RPrice + '\n';
    }
}
