package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Bond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface BondsRepository extends JpaRepository<Bond, Integer> {
    List<Bond> findBondsByIsActiveIsTrue();

    List<Bond> findBondsByIsActiveIsFalse();

    @Query(value = "SELECT * FROM Bonds WHERE bond_maturity_date > ?1 AND bond_maturity_date < ?2", nativeQuery = true)
    List<Bond> findBondsInMaturityTimeframe(LocalDate startDate, LocalDate endDate);

    @Query(value = "SELECT * FROM Bonds WHERE book_id = ?1", nativeQuery = true)
    List<Bond> findBondsbyBookIDForUser(int bookId);
}
