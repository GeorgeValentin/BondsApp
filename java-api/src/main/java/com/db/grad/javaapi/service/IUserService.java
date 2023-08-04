package com.db.grad.javaapi.service;

import com.db.grad.javaapi.dtos.BondCardDataDto;

import java.util.List;
import java.util.Optional;

public interface IUserService {

     Optional<List<String>> getBooksNamesforUserID(int user_id);

    Optional<List<BondCardDataDto>> getBondsInEachBookForUser(int user_id, int book_id);


}
