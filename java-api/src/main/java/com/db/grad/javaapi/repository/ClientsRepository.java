package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Client, Integer> {
}
