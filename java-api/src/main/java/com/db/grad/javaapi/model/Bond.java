package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bonds")
public class Bond {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bond_id")
    private int bondId;

    @Column(name = "cusip", nullable = false, length = 250)
    private String cusip;

    @Column(name = "isin", nullable = false, length = 250)
    private String isin;

    @Column(name = "face_value", nullable = false)
    private int faceValue;

    @Column(name = "bond_maturity_date", nullable = false)
    private Date bondMaturityDate;

    @Column(name = "coupon_percent", nullable = false)
    private float couponPercent;

    @Column(name = "bond_currency", nullable = false, length = 250)
    private String bondCurrency;

    @Column(name = "bond_type", nullable = false, length = 250)
    private String bondType;

    @Column(name = "redemption_status", nullable = false, length = 250)
    private String redemptionStatus;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "trade_settlement_date", nullable = false)
    private Date tradeSettlementDate;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    private Book book;

    public Bond(){}

    public Bond(int bondId, String cusip, String isin, int faceValue, Date bondMaturityDate, float couponPercent, String bondCurrency, String bondType, String redemptionStatus, boolean isActive, Date tradeSettlementDate) {
        this.bondId = bondId;
        this.cusip = cusip;
        this.isin = isin;
        this.faceValue = faceValue;
        this.bondMaturityDate = bondMaturityDate;
        this.couponPercent = couponPercent;
        this.bondCurrency = bondCurrency;
        this.bondType = bondType;
        this.redemptionStatus = redemptionStatus;
        this.isActive = isActive;
        this.tradeSettlementDate = tradeSettlementDate;
    }

    public int getBondId() {
        return bondId;
    }

    public void setBondId(int bondId) {
        this.bondId = bondId;
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

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }

    public Date getBondMaturityDate() {
        return bondMaturityDate;
    }

    public void setBondMaturityDate(Date bondMaturityDate) {
        this.bondMaturityDate = bondMaturityDate;
    }

    public float getCouponPercent() {
        return couponPercent;
    }

    public void setCouponPercent(float couponPercent) {
        this.couponPercent = couponPercent;
    }

    public String getBondCurrency() {
        return bondCurrency;
    }

    public void setBondCurrency(String bondCurrency) {
        this.bondCurrency = bondCurrency;
    }

    public String getBondType() {
        return bondType;
    }

    public void setBondType(String bondType) {
        this.bondType = bondType;
    }

    public String getRedemptionStatus() {
        return redemptionStatus;
    }

    public void setRedemptionStatus(String redemptionStatus) {
        this.redemptionStatus = redemptionStatus;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getTradeSettlementDate() {
        return tradeSettlementDate;
    }

    public void setTradeSettlementDate(Date tradeSettlementDate) {
        this.tradeSettlementDate = tradeSettlementDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Bond{" +
                "bondId=" + bondId +
                ", cusip='" + cusip + '\'' +
                ", isin='" + isin + '\'' +
                ", faceValue=" + faceValue +
                ", bondMaturityDate=" + bondMaturityDate +
                ", couponPercent=" + couponPercent +
                ", bondCurrency='" + bondCurrency + '\'' +
                ", bondType='" + bondType + '\'' +
                ", redemptionStatus='" + redemptionStatus + '\'' +
                ", isActive=" + isActive +
                ", tradeSettlementDate=" + tradeSettlementDate +
                '}';
    }
}

