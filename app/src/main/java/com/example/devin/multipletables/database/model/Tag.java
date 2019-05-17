package com.example.devin.multipletables.database.model;

public class Tag {

    int id;
    String tagName;

    public Tag() {

    }

    public Tag(String tagName) {
        this.tagName = tagName;
    }

   public Tag(int id, String tagName) {
        this.id = id;
        this.tagName = tagName;
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tag_name) {
        this.tagName = tag_name;
    }
}
