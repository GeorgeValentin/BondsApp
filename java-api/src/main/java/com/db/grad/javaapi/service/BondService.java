package com.db.grad.javaapi.service;

import com.db.grad.javaapi.dtos.ActiveBondDataDto;
import com.db.grad.javaapi.dtos.BondCardDataDto;
import com.db.grad.javaapi.exception.UserDoesNotExistException;
import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.repository.BondsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.db.grad.javaapi.constants.Constants.MATURITY_TIMEFRAME_IN_DAYS;
import static com.db.grad.javaapi.constants.Constants.WEEKEND_DAYS;

@Service
public class BondService implements IBondService {

    @Autowired
    private BondsRepository bondsRepository;

    @Autowired
    UserService userService;

    @Override
    public List<BondCardDataDto> getAllBonds() {
        List<Bond> allBonds = bondsRepository.findAll();

        List<BondCardDataDto> bondsToReturn = allBonds.stream()
                .map(elem -> new BondCardDataDto(elem))
                .collect(Collectors.toList());

        return bondsToReturn;
    }

    @Override
    public List<ActiveBondDataDto> getActiveBonds(int userId) {

        if (!userService.existsUserById(userId)) {
            throw new UserDoesNotExistException("The user does not exist");
        }

        List<Bond> allBonds = new ArrayList<>();

        List<Book> booksForUserId = userService.getBooksForUserID(userId);
        for (Book book : booksForUserId) {
            allBonds.addAll(book.getBonds().stream().filter(Bond::isActive).collect(Collectors.toList()));
        }

        return allBonds.stream()
                .map(elem -> new ActiveBondDataDto(elem, elem.isActive()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Bond> getInactiveBonds() {
        return bondsRepository.findBondsByIsActiveIsFalse();
    }

    public List<BondCardDataDto> getBondsInMaturityTimeframe(Integer userId) {
        if (!userService.existsUserById(userId)) {
            throw new UserDoesNotExistException("The user does not exist");
        }

        LocalDate today = LocalDate.now();

        LocalDate lowerBound = today.minusDays(MATURITY_TIMEFRAME_IN_DAYS + WEEKEND_DAYS);
        LocalDate upperBound = today.plusDays(MATURITY_TIMEFRAME_IN_DAYS + WEEKEND_DAYS);

        List<Bond> bonds = bondsRepository.findBondsInMaturityTimeframe(userId, lowerBound, upperBound);

        return bonds.stream()
                .map(BondCardDataDto::new)
                .collect(Collectors.toList());
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
    public Optional<Bond> getBondsById(int userId, int bondId) {

        if (!userService.existsUserById(userId)) {
            throw new UserDoesNotExistException("The user does not exist");
        }

        return bondsRepository.findBondByBondIdAndUserId(userId, bondId);

    }

}
