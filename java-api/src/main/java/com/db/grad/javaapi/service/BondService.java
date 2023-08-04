package com.db.grad.javaapi.service;

import com.db.grad.javaapi.dtos.ActiveBondDataDto;
import com.db.grad.javaapi.dtos.BondCardDataDto;
import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.db.grad.javaapi.constants.Constants.MATURITY_TIMEFRAME_IN_DAYS;
import static com.db.grad.javaapi.constants.Constants.WEEKEND_DAYS;

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
    public List<ActiveBondDataDto> getActiveBonds() {
        List<Bond> allBonds = bondsRepository.findBondsByIsActiveIsTrue();

        List<ActiveBondDataDto> bondsToReturn = allBonds.stream()
                .map(elem -> new ActiveBondDataDto(elem, elem.isActive()))
                .collect(Collectors.toList());

        return bondsToReturn;
    }

    @Override
    public List<Bond> getInactiveBonds() {
        return bondsRepository.findBondsByIsActiveIsFalse();
    }

    public List<BondCardDataDto> getBondsInMaturityTimeframe() {
        LocalDate today = LocalDate.now();

        LocalDate lowerBound = today.minusDays(MATURITY_TIMEFRAME_IN_DAYS + WEEKEND_DAYS);
        LocalDate upperBound = today.plusDays(MATURITY_TIMEFRAME_IN_DAYS + WEEKEND_DAYS);

        List<Bond> bonds = bondsRepository.findBondsInMaturityTimeframe(lowerBound, upperBound);

        List<BondCardDataDto> bondsToReturn = bonds.stream()
                .map(BondCardDataDto::new)
                .collect(Collectors.toList());

        return bondsToReturn;

    }

    @Override
    public Bond addBond(Bond bond) {
        return null;
    }

    @Override
    public long getNoOfBonds() {
        return 0;
    }

    @Override
    public Optional<Bond> getBondsById(int uniqueId) {
        return bondsRepository.findById(uniqueId);
    }

}
