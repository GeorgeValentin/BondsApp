package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Bond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BondsRepository extends JpaRepository<Bond, Integer> {
    List<Bond> findBondsByIsActiveIsTrue();

    List<Bond> findBondsByIsActiveIsFalse();



    @Query(value = "select * from bonds b\n" +
            "join books c\n" +
            "on b.book_id = c.book_id\n" +
            "join users u\n" +
            "on u.user_id = c.user_id\n" +
            "where u.user_id = ?1 and\n" +
            "b.bond_maturity_date > ?2 AND b.bond_maturity_date < ?3", nativeQuery = true)
    List<Bond> findBondsInMaturityTimeframe(int userId, LocalDate startDate, LocalDate endDate);

    @Query(value = "SELECT * FROM Bonds WHERE book_id = ?1", nativeQuery = true)
    List<Bond> findBondsbyBookIDForUser(int bookId);

    @Query(value = "select * from bonds b\n" +
            "join books c\n" +
            "on b.book_id = c.book_id\n" +
            "join users u\n" +
            "on u.user_id = c.user_id\n" +
            "where b.bond_id=?2 and u.user_id = ?1", nativeQuery = true)
    Optional<Bond> findBondByBondIdAndUserId(int userId, int bondId);
}
