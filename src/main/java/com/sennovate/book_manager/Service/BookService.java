package com.sennovate.book_manager.Service;

import com.sennovate.book_manager.DTO.BookDTO;
import com.sennovate.book_manager.Repository.*;

import java.util.List;
import java.util.ArrayList;

public class BookService {
    private BookRepo bookRepo;

    public BookService() {
        this.bookRepo = new BookRepository();
    }

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    private Book dtoToBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setBookName(bookDTO.getBookName());
        book.setAuthor(bookDTO.getAuthor());
        book.setPrice(bookDTO.getPrice());
        return book;
    }

    private BookDTO bookToDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setBookName(book.getBookName());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setPrice(book.getPrice());
        return bookDTO;
    }

    public BookDTO findById(long bookId) {
        Book book = bookRepo.findById(bookId);
        return bookToDTO(book);
    }

    public List<BookDTO> findAll() {
        List<Book> bookList = bookRepo.findAll();
        List<BookDTO> bookDTOList = new ArrayList<BookDTO>();
        for(Book book : bookList) {
            bookDTOList.add(bookToDTO(book));
        }
        return bookDTOList;
    }

    public BookDTO save(BookDTO bookDTO) {
        Book book = dtoToBook(bookDTO);
        bookRepo.save(book);
        return bookDTO;
    }

    public void deleteById(long bookId) {
        bookRepo.deleteById(bookId);
    }
}
