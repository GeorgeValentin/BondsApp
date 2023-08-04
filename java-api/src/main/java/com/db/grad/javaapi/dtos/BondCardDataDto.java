package com.db.grad.javaapi.dtos;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Client;
import com.db.grad.javaapi.model.Issuer;

public class BondCardDataDto {
    private String cusip;
    private String isin;
    private String issuerName;
    private String clientName;

    public BondCardDataDto(Bond bond) {
        this.cusip = bond.getCusip();
        this.isin = bond.getIsin();

        Client client = bond.getClient();
        if(client != null) {
            this.clientName = client.getBondHolder();
        }

        Issuer issuer = client.getIssuer();

        if(issuer != null) {
            this.issuerName = issuer.getIssuerName();
        }
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
