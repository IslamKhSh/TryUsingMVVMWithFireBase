package com.example.android.forsale.models;

public class ItemData {
    private String itemId;
    private String imageUrl;
    private String arName;
    private String enName;
    private String weight;
    private Double price;
    private Boolean availability;
    private int countFavourites;
    private int countLikes;
    private int countDisLikes;
    private int countComments;
    private float rate;

    public ItemData() {
        //needed
    }

    public ItemData(String itemId, String imageUrl, String arName, String enName, String weight, Double price, Boolean availability,
                    int countFavourites, int countLikes, int countDisLikes, int countComments, float rate) {
        this.itemId = itemId;
        this.imageUrl = imageUrl;
        this.arName = arName;
        this.enName = enName;
        this.weight = weight;
        this.price = price;
        this.availability = availability;
        this.countFavourites = countFavourites;
        this.countLikes = countLikes;
        this.countDisLikes = countDisLikes;
        this.countComments = countComments;
        this.rate = rate;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getArName() {
        return arName;
    }

    public void setArName(String arName) {
        this.arName = arName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public int getCountFavourites() {
        return countFavourites;
    }

    public void setCountFavourites(int countFavourites) {
        this.countFavourites = countFavourites;
    }

    public int getCountLikes() {
        return countLikes;
    }

    public void setCountLikes(int countLikes) {
        this.countLikes = countLikes;
    }

    public int getCountDisLikes() {
        return countDisLikes;
    }

    public void setCountDisLikes(int countDisLikes) {
        this.countDisLikes = countDisLikes;
    }

    public int getCountComments() {
        return countComments;
    }

    public void setCountComments(int countComments) {
        this.countComments = countComments;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
