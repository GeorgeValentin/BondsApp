package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "issuers")
public class Issuer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int issuer_id;

    private String issuer_name;

    @OneToMany(mappedBy = "issuers")
    private Set<Client> clients = new HashSet<>();

    public Issuer() {
    }
    public Issuer(int issuer_id, String issuer_name) {
        this.issuer_id = issuer_id;
        this.issuer_name = issuer_name;
    }

    public Issuer(int issuer_id, String issuer_name, Set<Client> clients) {
        this.issuer_id = issuer_id;
        this.issuer_name = issuer_name;
        this.clients = clients;
    }

    public int getIssuer_id() {
        return issuer_id;
    }

    public void setIssuer_id(int issuer_id) {
        this.issuer_id = issuer_id;
    }

    public String getIssuer_name() {
        return issuer_name;
    }

    public void setIssuer_name(String issuer_name) {
        this.issuer_name = issuer_name;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Issuer{" +
                "issuer_id=" + issuer_id +
                ", issuer_name='" + issuer_name + '\'' +
                ", clients=" + clients +
                '}';
    }
}



