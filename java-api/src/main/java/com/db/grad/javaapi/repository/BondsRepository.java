package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Bond;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BondsRepository extends JpaRepository<Bond, Integer> {
}
