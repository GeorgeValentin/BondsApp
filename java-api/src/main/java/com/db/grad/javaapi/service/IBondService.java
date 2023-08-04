package com.db.grad.javaapi.service;

import com.db.grad.javaapi.dtos.ActiveBondDataDto;
import com.db.grad.javaapi.dtos.BondCardDataDto;
import com.db.grad.javaapi.model.Bond;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IBondService {

    public List<BondCardDataDto> getAllBonds();

    public List<ActiveBondDataDto> getActiveBonds();

    List<Bond> getInactiveBonds();

    List<BondCardDataDto> getBondsInMaturityTimeframe();

    public Bond addBond(Bond bond);

    public long getNoOfBonds();

    public Optional getBondsById(int uniqueId);

//    public boolean removeBond(long uniqueId);
//
//    public Bond getBondById(long uniqueId);
//
//    public Bond getBondByName(String bondName);
//
//    public Bond updateBondDetails(Bond bondToUpdate);
}
