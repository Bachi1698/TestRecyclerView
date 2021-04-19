package com.example.testrecyclerview;


public class Donnee {
    private String principal;
    private String auxiliaire;
    int image;

    Donnee (String text1, String text2,int image){
        principal = text1;
        auxiliaire = text2;
        image = image;
    }

    public int getImage() {
        return image;
    }

    public String getPrincipal() {
        return principal;
    }

    public String getAuxiliaire() {
        return auxiliaire;
    }

}


