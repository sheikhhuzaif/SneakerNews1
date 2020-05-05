package com.example.sneakernews;

import androidx.annotation.NonNull;

public class ReleaseEntry {
    private String releaseName;
    private String releaseDate;
    private String releaseImage;

//    public ReleaseEntry(String releaseName, String releaseDate, String releaseImage) {
//        this.releaseName = releaseName;
//        this.releaseDate = releaseDate;
//        this.releaseImage = releaseImage;
//    }

    public String getReleaseName() {
        return releaseName;
    }

    public void setReleaseName(String releaseName) {
        this.releaseName = releaseName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseImage() {
        return releaseImage;
    }

    public void setReleaseImage(String releaseImage) {
        this.releaseImage = releaseImage;
    }

    @NonNull
    @Override
    public String toString() {
        return "Name=" + releaseName + '\n' +
                "imageURL=" + releaseImage + '\n' +
                "Date=" + releaseDate + '\n';
    }
}
