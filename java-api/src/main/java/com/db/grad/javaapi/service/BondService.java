package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BondService implements IBondService {

    @Autowired
    private BondsRepository bondsRepository;
    @Override
    public List<Bond> getAllBonds() {
        return bondsRepository.findAll();
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
