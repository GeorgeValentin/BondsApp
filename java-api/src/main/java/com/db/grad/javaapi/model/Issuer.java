package com.db.grad.javaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "issuers")
public class Issuer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int issuer_id;

    private String issuer_name;

    public Issuer(int issuer_id, String issuer_name) {
        this.issuer_id = issuer_id;
        this.issuer_name = issuer_name;
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

    @Override
    public String toString() {
        return "Issuer{" +
                "issuer_id=" + issuer_id +
                ", issuer_name='" + issuer_name + '\'' +
                '}';
    }
}



