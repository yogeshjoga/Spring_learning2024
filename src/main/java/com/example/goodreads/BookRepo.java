package com.example.goodreads;

import java.util.ArrayList;

public interface BookRepo {
    ArrayList<Book> getBooks();

    Book getBookById(int bookId);

    Book addBook(Book book);

    void deleteBook(int bookId);

    Book updateBook(int bookId, Book book);
}