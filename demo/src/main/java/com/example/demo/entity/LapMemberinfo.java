package com.example.demo.entity;

import java.sql.Blob;

public class LapMemberinfo {

  private String uuid;
  private String memberid;
  private String name;
  private String age;
  private String sex;
  private java.sql.Date birthdate;
  private String address;
  private Blob img;
  private String marriage;
  private String enable;


  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }


  public String getMemberid() {
    return memberid;
  }

  public void setMemberid(String memberid) {
    this.memberid = memberid;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public java.sql.Date getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(java.sql.Date birthdate) {
    this.birthdate = birthdate;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public Blob getImg() {
    return img;
  }

  public void setImg(Blob img) {
    this.img = img;
  }

  public String getMarriage() {
    return marriage;
  }

  public void setMarriage(String img) {
    this.marriage = marriage;
  }

  public String getEnable() {
    return enable;
  }

  public void setEnable(String enable) {
    this.enable = enable;
  }

}
