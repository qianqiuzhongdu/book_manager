package com.sennovate.book_manager.Repository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private long id;
    private String bookName;
    private String author;

    private double price;
}



