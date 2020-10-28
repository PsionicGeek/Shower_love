package com.ART.shower_love.ui.donatereceive;

public class uploadinfo {
    public String imageName;
    public String imageURL;
    public String  condition;
    public String recycle ;
    public String use;
    String category , Gender , PostalCode , Address;
    String Phone ,Name , email;
    public uploadinfo(){}

    public uploadinfo(String name, String url, String condition , String recycle , String use , String chatogory , String Gender,String PostalCode ,String Address , String Phone,String Name,String email) {
        this.imageName = name;
        this.imageURL = url;
        this.condition = condition;
        this.recycle = recycle;
        this.use = use;
        this.category =chatogory;
        this.Gender = Gender;
        this.PostalCode = PostalCode;
        this.Address = Address;
        this.Phone = Phone;
        this.Name=Name;
        this.email=email;
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




    public String getGender() {
        return Gender;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public String getAddress() {
        return Address;
    }

    public String getPhone() {
        return Phone;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return email;
    }
}


