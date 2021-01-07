package com.sennovate.book_manager.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {
    private long id;
    private String bookName;
    private String author;

    private double price;
}
