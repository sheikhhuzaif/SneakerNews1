package com.example.sneakernews;

public class FeedEntry {

    private String title;
    private String pubDate;
    private String creator;
    private String description;
    private String articleURL;
    private String imageURL;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArticleURL() {
        return articleURL;
    }

    public void setArticleURL(String articleURL) {
        this.articleURL = articleURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "title=" + title + '\n' +
                "pubDate=" + pubDate + '\n' +
                "creator=" + creator + '\n' +
                "description=" + description + '\n' +
                "articleURL=" + articleURL + '\n' +
                "imageURL=" + imageURL + '\n';
    }
}
