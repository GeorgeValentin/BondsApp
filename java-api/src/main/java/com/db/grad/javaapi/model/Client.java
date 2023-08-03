package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "bond_holder", nullable = false, length = 250)
    private String bondHolder;

    @ManyToOne
    @JoinColumn(name = "issuer_id", referencedColumnName = "issuer_id")
    private Issuer issuer;

    @OneToMany(mappedBy = "client")
    public List<Bond> bonds = new ArrayList<>();

    public Client() {

    }
    public Client(Long clientId, String bondHolder, Issuer issuer) {
        this.clientId = clientId;
        this.bondHolder = bondHolder;
        this.issuer = issuer;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getBondHolder() {
        return bondHolder;
    }

    public void setBondHolder(String bondHolder) {
        this.bondHolder = bondHolder;
    }

    public Issuer getIssuer() {
        return issuer;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }
}
