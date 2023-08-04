package com.db.grad.javaapi.dtos;

import com.db.grad.javaapi.model.Bond;

import java.util.Date;

public class ActiveBondDataDto extends BondCardDataDto {

    private boolean isActive;

    public ActiveBondDataDto(Bond bond, boolean isActive) {
        super(bond);
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
