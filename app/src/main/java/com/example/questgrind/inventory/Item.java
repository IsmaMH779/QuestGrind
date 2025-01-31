package com.example.questgrind.inventory;

public class Item {
    private String name;
    private int image;
    private String rank;
    private String attribute;
    private String passive;

    public Item(String name, int image, String rank, String attribute, String passive) {
        this.name = name;
        this.image = image;
        this.rank = rank;
        this.attribute = attribute;
        this.passive = passive;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getRank() {
        return rank;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getPassive() {
        return passive;
    }
}
