package com.db.grad.javaapi.service;

import com.db.grad.javaapi.dtos.BondCardDataDto;
import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.repository.BondsRepository;
import com.db.grad.javaapi.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.db.grad.javaapi.constants.Constants.MATURITY_TIMEFRAME_IN_DAYS;
import static com.db.grad.javaapi.constants.Constants.WEEKEND_DAYS;

@Service
public class UserService implements IUserService{

    @Autowired
    private UsersRepository usersRepository;

    public Optional<List<String>> getBooksNamesforUserID(int user_id) {
        return usersRepository.findBooksNamesByUserID(user_id);
    }

    public Optional<List<Book>> getBooksforUserID(int user_id) {
        return usersRepository.findBooksByUserID(user_id);
    }

    public Optional<List<BondCardDataDto>> getBondsInEachBookForUser(int user_id, int book_id) {
        List<Book> books = getBooksforUserID(user_id).get();
        for (Book book:books){

        }
        return usersRepository.findBondsbyBookIDForUser(book_id);
    }
}
