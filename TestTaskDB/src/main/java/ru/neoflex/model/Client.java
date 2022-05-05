package ru.neoflex.model;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Named
@Entity
@Table(name = "Clients",schema="public")
public class Client implements Serializable {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name="generator", sequenceName="clients_id_seq")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "birth_date") @Temporal(TemporalType.DATE)
    private Date birth_date;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="account_id")
    private  Account account;

    public Client() {
    }
    public Client(String username, String password, Date birth_date, String name, String surname, Account account) {
        this.username = username;
        this.password = password;
        this.birth_date = birth_date;
        this.name = name;
        this.surname = surname;
        this.account = account;
    }
    public Account getAccount() {
        return this.account;
    }

    public void setAccounts(Account account) {
        this.account = account;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
