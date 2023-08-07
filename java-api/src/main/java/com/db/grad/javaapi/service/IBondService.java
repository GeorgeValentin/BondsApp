package com.db.grad.javaapi.service;

import com.db.grad.javaapi.dtos.ActiveBondDataDto;
import com.db.grad.javaapi.dtos.BondCardDataDto;
import com.db.grad.javaapi.model.Bond;

import java.util.List;
import java.util.Optional;

public interface IBondService {

    List<BondCardDataDto> getAllBonds();

    List<ActiveBondDataDto> getActiveBonds(int userId);

    Optional<Bond> getBondsById(int userId, int bondId);

    List<Bond> getInactiveBonds();

    List<BondCardDataDto> getBondsInMaturityTimeframe(Integer userId);

    public Bond addBond(Bond bond);

    public long getNoOfBonds();

//    public boolean removeBond(long uniqueId);
//
//    public Bond getBondById(long uniqueId);
//
//    public Bond getBondByName(String bondName);
//
//    public Bond updateBondDetails(Bond bondToUpdate);
}
