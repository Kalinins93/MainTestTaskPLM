package ru.neoflex.model;

import ru.neoflex.model.type.Status;

import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Named
@Entity
@Table(name = "accounts" ,schema="public")
public class Account implements Serializable {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name="generator", sequenceName="account_id_seq")
    private int id;
    @Column(name = "balance")
    private int balance;
    @Column(name = "opendate") @Temporal(TemporalType.DATE)
    private Date openDate;
    @Column(name = "closedate") @Temporal(TemporalType.DATE)
    private Date closeDate;
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(fetch=FetchType.EAGER, mappedBy="id")
    private List<Client> client;
    public List<Client> getClient() {
        return this.client;
    }

    public void setCompany(List<Client> client) {
        this.client = client;
    }
    public Account() {
    }
    public Account( int balance, Date openDate, Date closeDate, Status status,List<Client> client) {
        this.balance = balance;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.status = status;
        this.client =client;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
