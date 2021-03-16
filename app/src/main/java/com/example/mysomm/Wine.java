package com.example.mysomm;

public class Wine {
    private String Name;
    private String Type;
    private String Age;
    private String Taste;
    private String priceRange;
    private String imageUrl;

    public Wine(String name, String type, String age, String taste, String pricerange, String imageUrl)
    {
        Name = name;
        this.Type = type;
        this.Age = age;
        this.Taste = taste;
        this.priceRange = pricerange;
        this.imageUrl = imageUrl;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getTaste() {
        return Taste;
    }

    public void setTaste(String taste) {
        Taste = taste;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Wine{" +
                "Name='" + Name + '\'' +
                ", Type='" + Type + '\'' +
                ", Age='" + Age + '\'' +
                ", Taste='" + Taste + '\'' +
                ", priceRange='" + priceRange + '\'' +
                '}';
    }
}
