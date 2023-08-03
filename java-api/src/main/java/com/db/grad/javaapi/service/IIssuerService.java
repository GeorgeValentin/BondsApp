package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Client;
import com.db.grad.javaapi.model.Issuer;

import java.util.List;

public interface IIssuerService {
    public List<Issuer> getAllIssuers();

    public Issuer addIssuer(Issuer issuer);

    public long getNoOfIssuers();
}
