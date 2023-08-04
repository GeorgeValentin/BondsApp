package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.dtos.BondCardDataDto;
import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {

    boolean existsByUserEmail(String userEmail);

    User getUserByUserEmail(String email);

    @Query(value = "SELECT book_name FROM Books WHERE user_id = ?1", nativeQuery = true)
    Optional<List<String>> findBooksNamesByUserID(int userId);

    @Query(value = "SELECT * FROM Books b WHERE b.user_id = ?1", nativeQuery = true)
    List<Book> findBooksByUserID(int userId);

}
