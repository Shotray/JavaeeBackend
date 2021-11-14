package com.xagd.javaeebackend.model;

import javax.persistence.*;

@Entity
@Table(name = "userreceiveinfo", schema = "db", catalog = "")
public class UserreceiveinfoEntity {
    private short receiveId;
    private short userId;
    private String address;
    private String phone;
    private String name;

    @Id
    @Column(name = "receive_id")
    public short getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(short receiveId) {
        this.receiveId = receiveId;
    }

    @Basic
    @Column(name = "user_id")
    public short getUserId() {
        return userId;
    }

    public void setUserId(short userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserreceiveinfoEntity that = (UserreceiveinfoEntity) o;

        if (receiveId != that.receiveId) return false;
        if (userId != that.userId) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) receiveId;
        result = 31 * result + (int) userId;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
