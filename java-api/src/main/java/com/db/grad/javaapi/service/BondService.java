package com.db.grad.javaapi.service;

import com.db.grad.javaapi.dtos.BondCardDataDto;
import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BondService implements IBondService {
    @Autowired
    private BondsRepository bondsRepository;

    @Override
    public List<BondCardDataDto> getAllBonds() {
        List<Bond> allBonds = bondsRepository.findAll();

        List<BondCardDataDto> bondsToReturn = allBonds.stream()
                .map(elem -> new BondCardDataDto(elem))
                .collect(Collectors.toList());

        return bondsToReturn;
    }

    @Override
    public List<Bond> getActiveBonds() {
        return bondsRepository.findBondsByIsActiveIsTrue();
    }

    @Override
    public List<Bond> getInactiveBonds() {
        return bondsRepository.findBondsByIsActiveIsFalse();
    }

    @Override
    public Bond addBond(Bond bond) {
        return null;
    }

    @Override
    public long getNoOfBonds() {
        return 0;
    }
}
