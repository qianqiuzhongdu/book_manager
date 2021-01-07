package com.sennovate.book_manager.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BookRepository implements BookRepo {
    @Autowired
    private MongoTemplate template;

    @Override
    public List<Book> findAll() {
        return template.findAll(Book.class);
    }

    @Override
    public Book findById(long bookId) {
        return template.findById(bookId,Book.class);
    }

    @Override
    public Book save(Book book) {
        return template.save(book);
    }

    @Override
    public void deleteById(long bookId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("bookId").is(bookId));
        template.remove(query, Book.class);
    }
}
