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

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<String> NewHashPasswordAndSalt(String password){
        SecureRandom random = new SecureRandom();
        String salt = "1";
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 128);
        SecretKeyFactory f = null;
        byte[] hash;
        try {
            f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            hash = f.generateSecret(spec).getEncoded();
            Base64.Encoder enc = Base64.getEncoder();

            List<String> encryptedData = new ArrayList<String>();
            encryptedData.add(enc.encodeToString(hash));
            //encryptedData.add(enc.encodeToString(salt.getBytes()));

            return encryptedData;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }

    }

    public String HashPasswordSecurityCheck(String password, String salt){
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 128);
        SecretKeyFactory f = null;
        byte[] hash;
        try {
            f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            hash = f.generateSecret(spec).getEncoded();
            Base64.Encoder enc = Base64.getEncoder();
            String hashedPassword = enc.encodeToString(hash);
            return hashedPassword;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }

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

        List<String> encryptedData =  NewHashPasswordAndSalt(userToSave.getPassword());
        User savedUser = new User(userToSave.getEmail(), encryptedData.get(0), "1");
        usersRepository.save(savedUser);

        return savedUser;
    }

    public User loginUser (Credentials credentials) {
        // check if a user with that email already exists
        if (!isUserAlreadyRegistered(credentials.getEmail())) {
            throw new UserDoesNotExistException("Register first.");
        }

        User existingUser = usersRepository.getUserByUserEmail(credentials.getEmail());
        String passwordHash = existingUser.getUserPasswordHash();
        //String passwordSalt = existingUser.getUserPasswordSalt();

        String SCHashedPassword = HashPasswordSecurityCheck(credentials.getPassword(), "1");

        if (passwordHash.equals(SCHashedPassword)) {
            return existingUser;
        } else {
            throw new InvalidUserException("Password is incorrect.");
        }
    }
}