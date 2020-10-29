package com.ART.shower_love.ui.donatereceive;

public class BloodDonoruploadinfo {
    public String medication;
    public String bleedingdisorder;
    public String disease;
    public String allergi;
    private String BloodGroup;
    String Cardiac, Gender , PostalCode , Address;
    String Phone ,Name , email;
    public BloodDonoruploadinfo(){}

    public BloodDonoruploadinfo(String medication, String bleedingdisorder, String disease , String allergi, String BloodGroup, String Cardiac , String Gender, String PostalCode , String Address , String Phone, String Name, String email) {
        this.medication = medication;
        this.bleedingdisorder = bleedingdisorder;
        this.disease = disease;
        this.allergi = allergi;
        this.BloodGroup = BloodGroup;
        this.Cardiac =Cardiac;
        this.Gender = Gender;
        this.PostalCode = PostalCode;
        this.Address = Address;
        this.Phone = Phone;
        this.Name=Name;
        this.email=email;
    }

    public String getMedication() {
        return medication;
    }
    public String getBleedingdisorder() {
        return bleedingdisorder;
    }

    public String getDisease() {
        return disease;
    }

    public String getAllergi() {
        return allergi;
    }

    public String getBloodGroup() {
        return BloodGroup;
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

    public String getCardiac() {
        return Cardiac;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return email;
    }
}
