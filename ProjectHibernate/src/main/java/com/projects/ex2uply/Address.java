package com.projects.ex2uply;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "student_Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressID;
    @Column(length = 50)
    private String  street;
    @Column(length = 100)
    private String city;
    private boolean isOpen;
    @Transient
    private double x;
    @Column(name = "address_date")
    @Temporal(TemporalType.DATE)
    private Date addedDate;
    @Lob
    private byte[] image;

    public Address() {
        super();
    }

    public Address(Date addedDate, int addressID, String city, byte[] image, boolean isOpen, String street, double x) {
        this.addedDate = addedDate;
        this.addressID = addressID;
        this.city = city;
        this.image = image;
        this.isOpen = isOpen;
        this.street = street;
        this.x = x;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }
}
