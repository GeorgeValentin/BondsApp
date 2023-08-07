package com.db.grad.javaapi.service;

import com.db.grad.javaapi.dtos.BondCardDataDto;
import com.db.grad.javaapi.dtos.Credentials;
import com.db.grad.javaapi.exception.InvalidUserException;
import com.db.grad.javaapi.exception.UserAlreadyExistsException;
import com.db.grad.javaapi.exception.UserDoesNotExistException;
import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.BondsRepository;
import com.db.grad.javaapi.repository.BooksRepository;
import com.db.grad.javaapi.repository.UsersRepository;
import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private BondsRepository bondsRepository;

    public boolean existsUserById (int userId) {
        return usersRepository.existsById(userId);
    }

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
      
     public boolean isUserAlreadyRegistered(String email) {
        return usersRepository.existsByUserEmail(email);
     }

    private boolean isUserDataInvalid(Credentials userToSave) {
        return userToSave == null || StringUtils.isNullOrEmpty(userToSave.getEmail())
                || StringUtils.isNullOrEmpty(userToSave.getPassword());
    }

    public User registerUser (Credentials userToSave) {
        // check if a user with that email already exists
        if (isUserAlreadyRegistered(userToSave.getEmail())) {
            throw new UserAlreadyExistsException("User with this email already exists");
        }

        if (isUserDataInvalid(userToSave)) {
            throw new InvalidUserException("User email or/and password cannot be empty.");
        }

        User savedUser = new User(userToSave.getEmail(), userToSave.getPassword());
        usersRepository.save(savedUser);

        return savedUser;
    }

    public User loginUser (Credentials credentials) {
        // check if a user with that email already exists
        if (!isUserAlreadyRegistered(credentials.getEmail())) {
            throw new UserDoesNotExistException("Register first.");
        }

        User existingUser = usersRepository.getUserByUserEmail(credentials.getEmail());

        if (existingUser.getPassword().equals(credentials.getPassword())) {
            return existingUser;
        } else {
            throw new InvalidUserException("Password is incorrect.");
        }
    }
}