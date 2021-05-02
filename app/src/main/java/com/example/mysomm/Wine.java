// Wine.java
// Nicholas Fontenot wrote lines 23-30, 74-78, 89
// Srinath Subramanian wrote the remaining lines


package com.example.mysomm;

public class Wine {
    private String Name;
    private String Type;
    private String Taste;
    private String Description;
    private String imageURL;
    private String Link;

    public Wine(String name, String type, String taste, String description)
    {
        Name = name;
        this.Type = type;
        this.Taste = taste;
        this.Description = description;
    }

    public Wine(String name, String type, String taste, String description, String imageURL, String link)
    {
        Name = name;
        this.Type = type;
        this.Taste = taste;
        this.Description = description;
        this.imageURL = imageURL;
        this.Link = link;
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

    public String getTaste() {
        return Taste;
    }

    public void setTaste(String taste) {
        Taste = taste;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        this.Link = link;
    }

    @Override
    public String toString() {
        return "Wine{" +
                "Name='" + Name + '\'' +
                ", Type='" + Type + '\'' +
                ", Taste='" + Taste + '\'' +
                ", Description='" + Description + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", Link='" + Link + '\'' +
                '}';
    }
}
