package com.db.grad.javaapi.service;

import com.db.grad.javaapi.dtos.BondCardDataDto;
import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.repository.BondsRepository;
import com.db.grad.javaapi.repository.BooksRepository;
import com.db.grad.javaapi.repository.UsersRepository;
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
public class UserService implements IUserService{

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private BondsRepository bondsRepository;

    public Optional<List<String>> getBooksNamesforUserID(int user_id) {
        return usersRepository.findBooksNamesByUserID(user_id);
    }

    public List<Book> getBooksForUserID(int user_id) {
        return booksRepository.findBooksByUserId(user_id);
    }

    public List<BondCardDataDto> getBondsInSpecificBookForUser(int user_id, String book_name) {
        List<Book> books = getBooksForUserID(user_id);
        List<Bond> bonds = new ArrayList<Bond>();
        for (Book book:books){
            if (book.getBookName().equals(book_name)){
                bonds = bondsRepository.findBondsbyBookIDForUser(book.getBookId());
                break;
            }
        }
        List<BondCardDataDto> bondsToReturn = bonds.stream()
                .map(BondCardDataDto::new)
                .collect(Collectors.toList());

        return bondsToReturn;
    }
}
