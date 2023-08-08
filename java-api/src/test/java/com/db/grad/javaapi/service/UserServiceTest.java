package com.db.grad.javaapi.service;

import com.db.grad.javaapi.dtos.BondCardDataDto;
import com.db.grad.javaapi.dtos.Credentials;
import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.BondsRepository;
import com.db.grad.javaapi.repository.BooksRepository;
import com.db.grad.javaapi.repository.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserServiceTest {

    private User user;
    private Book book;
    private Bond bond;

    private BondCardDataDto bondDto;

    private Credentials credentials;

    @InjectMocks
    public UserService userservice;

    @Mock
    private UsersRepository usersRepository;

    @Mock
    private BooksRepository booksRepository;

    @Mock
    private BondsRepository bondsRepository;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);

        user = new User(1,"user1@gmail.com");
        book = new Book(1,"trading_book_1", user);
        bond = new Bond(1,true, book);
        credentials = new Credentials("user1@gmail.com", "password");

    }

    @Test
    void getBooksNamesforUserID() {
        List<String> book_name = new ArrayList<>();
        book_name.add(book.getBookName());
        when(usersRepository.findBooksNamesByUserID(1)).thenReturn(Optional.of(book_name));

        Optional<List<String>> actualResult = userservice.getBooksNamesforUserID(1);

        assertEquals(actualResult.get().size(), book_name.size());
        assertEquals(actualResult.get().get(0), book_name.get(0));

    }

    @Test
    void getBooksForUserID() {
        List<Book> books = new ArrayList<>();
        books.add(book);
        when(booksRepository.findBooksByUserId(1)).thenReturn(books);

        List<Book> actualResult = userservice.getBooksForUserID(1);

        assertEquals(actualResult.get(0), books.get(0));
    }

    @Test
    void getBondsInSpecificBookForUser() {


    }

    @Test
    void registerUser() {
        User actualuser = userservice.registerUser(credentials);
        assertEquals(user.getUserEmail(), actualuser.getUserEmail());
    }

    @Test
    void loginUser() {
    }
    @Test
    void isUserAlreadyRegistered() {
        boolean actualResult = userservice.isUserAlreadyRegistered("user1@gmail.com");
        assertEquals(true, actualResult);
    }




}