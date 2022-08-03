package com.latelier.tall.tenisu.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstname;
    private String lastname;
    private String shortname;
    private String picture;
    private String sex;
    private int age;
    private int rank;
    private int height;
    private String last;
    @ManyToOne
    @JoinColumn(name = "country_code", nullable = false)
    private Country country;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getShortname() {
        return shortname;
    }
    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    private int points;
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    private int weight;
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public Collection<Integer> getLast() {
        Collection<String> collection = new ArrayList<String>(Arrays.asList(last.split(",")));
        return collection.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
    }
    public void setLast(Collection<Integer> last) {
        this.last = last.stream().map(n -> String.valueOf(n)).collect(Collectors.joining(","));
    }

    public Country getCountry() {
        return country;
    }
    public Player setCountry(Country country) {
        this.country = country;
        return this;
    }
}