package com.ART.shower_love.ui.donatereceive;

public class uploadinfo {
    public String imageName;
    public String imageURL;
    public String  condition;
    public String recycle ;
    public String use;
    public uploadinfo(){}

    public uploadinfo(String name, String url, String condition , String recycle , String use) {
        this.imageName = name;
        this.imageURL = url;
        this.condition = condition;
        this.recycle = recycle;
        this.use = use;
    }

    public String getImageName() {
        return imageName;
    }
    public String getImageURL() {
        return imageURL;
    }

    public String getCondition() {
        return condition;
    }

    public String getRecycle() {
        return recycle;
    }

    public String getUse() {
        return use;
    }
}


