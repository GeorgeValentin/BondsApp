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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    // Constructors, getters, setters, and other methods (if required) go here.

    // You may add additional annotations or constraints as needed for your application.
}

