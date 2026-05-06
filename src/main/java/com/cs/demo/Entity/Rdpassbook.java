package com.cs.demo.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rdpassbook")
public class Rdpassbook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid")
    private int pid;

    @Column(name = "famt")
    private Integer famt;

    @Column(name = "flag")
    private Integer flag;

    @Column(name = "lday")
    private Integer lday;

    @Column(name = "rdamt")
    private Integer rdamt;

    @Column(name = "ddate")
    @Temporal(TemporalType.DATE)
    private Date ddate;

    @Column(name = "rid")
    private Integer rid;

    // Default Constructor
    public Rdpassbook() {
    }

    // Getters and Setters

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Integer getFamt() {
        return famt;
    }

    public void setFamt(Integer famt) {
        this.famt = famt;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getLday() {
        return lday;
    }

    public void setLday(Integer lday) {
        this.lday = lday;
    }

    public Integer getRdamt() {
        return rdamt;
    }

    public void setRdamt(Integer rdamt) {
        this.rdamt = rdamt;
    }

    public Date getDdate() {
        return ddate;
    }

    public void setDdate(Date ddate) {
        this.ddate = ddate;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}