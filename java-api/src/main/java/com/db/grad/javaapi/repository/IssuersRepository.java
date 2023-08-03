package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Issuer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssuersRepository extends JpaRepository<Issuer, Integer> {
}
