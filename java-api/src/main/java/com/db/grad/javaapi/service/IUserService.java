package com.db.grad.javaapi.service;

import com.db.grad.javaapi.dtos.BondCardDataDto;
import com.db.grad.javaapi.dtos.Credentials;
import com.db.grad.javaapi.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

     Optional<List<String>> getBooksNamesforUserID(int user_id);

    List<BondCardDataDto> getBondsInSpecificBookForUser(int user_id, String book_name);

    boolean isUserAlreadyRegistered(String email);

    User registerUser (Credentials userToSave);

    User loginUser (Credentials credentials);



}
