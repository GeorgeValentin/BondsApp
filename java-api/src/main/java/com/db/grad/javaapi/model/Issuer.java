package com.db.grad.javaapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "issuers")
public class Issuer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issuer_id")
    private int issuerId;

    @Column(name = "issuer_name")
    private String issuerName;

    @OneToMany(mappedBy = "issuer")
    @JsonIgnore
    private Set<Client> clients = new HashSet<>();

    public Issuer() {
    }

    public Issuer(int issuerId, String issuerName) {
        this.issuerId = issuerId;
        this.issuerName = issuerName;
    }

    @Override
    public String toString() {
        return "Issuer{" +
                "issuerId=" + issuerId +
                ", issuerName='" + issuerName + '\'' +
                ", clients=" + clients +
                '}';
    }

    public int getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(int issuerId) {
        this.issuerId = issuerId;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
}



