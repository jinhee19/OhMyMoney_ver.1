package com.example.restapitest;

public class Data {

    private String category;
    private String title;
    private String tag;
    private String address;
    private String phone;
    private String homepage;
    private String sum_info;
    private String detail_info;

    public Data(String title){
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getTag() {
        return tag;
    }

    public String getAddress(){
        return address;
    }

    public String getPhone(){
        return phone;
    }

    public String getHomepage(){
        return homepage;
    }

    public String getSum_info(){
        return sum_info;
    }

    public String getDetail_info(){
        return detail_info;
    }

}
