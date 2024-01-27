package com.example.goodreads;

import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collection;

public class BookService implements BookRepo {

    private HashMap<Integer, Book> myBook = new HashMap<>();

    public BookService() {
        Book b1 = new Book(1, "hello", "/hello");
        Book b2 = new Book(2, "siri", "/love");
        myBook.put(b1.getId(), b1);
        myBook.put(b2.getId(), b2);
    }

    @Override
    public ArrayList<Book> getBooks() {
        Collection<Book> booksMap = myBook.values();
        ArrayList<Book> books = new ArrayList<>(booksMap);
        return books;
    }

    @Override

    public Book getBookById(int bookId) {
        Book getBook = myBook.get(bookId);
        if (getBook == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return getBook;
    }

    @Override
    public Book addBook(Book book) {
        Random random = new Random();
        int num = random.nextInt(10000);
        book.setId(num);
        myBook.put(book.getId(), book);
        return book;
    }

    @Override
    public void deleteBook(int bookId) {
        Book existingBook = myBook.get(bookId);
        if (existingBook == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            myBook.remove(bookId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
       
    }

    @Override
    public Book updateBook(int bookId, Book book) {
        Book existingBook = myBook.get(bookId);
        if (existingBook == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (book.getName() != null) {
            existingBook.setName(book.getName());
        }
        if (book.getImageURL() != null) {
            existingBook.setImageURL(book.getImageURL());
        }
        return book;
    }

}