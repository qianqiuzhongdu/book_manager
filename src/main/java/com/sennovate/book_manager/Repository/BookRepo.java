package com.sennovate.book_manager.Repository;

import java.util.List;

public interface BookRepo {
    List<Book> findAll();

    Book findById(long bookId);

    Book save(Book book);

    void deleteById(long bookId);
}
