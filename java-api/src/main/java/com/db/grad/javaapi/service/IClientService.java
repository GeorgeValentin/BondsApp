package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Client;

import java.util.List;

public interface IClientService {
    public List<Client> getAllClients();

    public Client addClient(Client client);

    public long getNoOfClients();
}
