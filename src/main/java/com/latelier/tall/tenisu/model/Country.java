package com.latelier.tall.tenisu.model;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    private String code;
    private String picture;

    public Country() {
    }

    public Country(String code, String picture) {
        this.code = code;
        this.picture = picture;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
}