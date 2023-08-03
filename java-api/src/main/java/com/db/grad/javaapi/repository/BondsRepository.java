package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Bond;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BondsRepository extends JpaRepository<Bond, Integer> {
    List<Bond> findBondsByIsActiveIsTrue();

    List<Bond> findBondsByIsActiveIsFalse();
}
