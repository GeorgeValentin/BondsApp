package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.dtos.BondCardDataDto;
import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT book_name FROM Books WHERE user_id = ?1", nativeQuery = true)
    Optional<List<String>> findBooksNamesByUserID(int userId);

    @Query(value = "SELECT * FROM Books WHERE user_id = ?1", nativeQuery = true)
    Optional<List<Book>> findBooksByUserID(int userId);

    @Query(value = "SELECT * FROM Bonds WHERE book_id = ?2 FROM Books WHERE user_id = ?1", nativeQuery = true)
    Optional<List<BondCardDataDto>> findBondsbyBookIDForUser(userId, bookId);

}
