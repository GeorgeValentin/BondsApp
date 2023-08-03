package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Book;

import java.util.List;

public interface IBookService {
    public List<Book> getAllBooks();

    public Book addBooks(Book book);

    public long getNoOfBooks();
}
