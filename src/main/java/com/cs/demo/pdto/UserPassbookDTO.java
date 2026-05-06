package com.cs.demo.pdto;

import java.util.Date;

public class UserPassbookDTO {

    private String name;
    private String acno;
    private int rdamt;
    private Date ddate;

    // ✅ Default Constructor (REQUIRED)
    public UserPassbookDTO() {
    }

    // ✅ Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcno() {
        return acno;
    }

    public void setAcno(String acno) {
        this.acno = acno;
    }

    public int getRdamt() {
        return rdamt;
    }

    public void setRdamt(int rdamt) {
        this.rdamt = rdamt;
    }

    public Date getDdate() {
        return ddate;
    }

    public void setDdate(Date ddate) {
        this.ddate = ddate;
    }
}