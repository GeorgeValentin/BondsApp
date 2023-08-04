package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {
    @Query(nativeQuery = true, value = "select * from books b \n" +
            "join users u\n" +
            "where\n" +
            "u.user_id = ?1 and b.user_id = ?1")
    List<Book> findBooksByUserId (int userId);
}
