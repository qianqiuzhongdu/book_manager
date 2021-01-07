package com.sennovate.book_manager.API;

import com.sennovate.book_manager.DTO.BookDTO;
import com.sennovate.book_manager.Repository.*;
import com.sennovate.book_manager.Service.BookService;
import com.sennovate.book_manager.Utils.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.ArrayList;


@RestController
@RequestMapping("/book")
public class BookAPI {
    private BookService bookService;

    public BookAPI() {this.bookService = new BookService(); }

    public BookAPI(BookService bookService) {
        this.bookService = bookService;
    }

    @ApiOperation(value="Get ID", notes="Get information of a book according to the id of url")
    @ApiImplicitParam(name = "id", value = "Book ID", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public BookDTO getbookById (@PathVariable(value = "id") long id){
        BookDTO bookDTO = bookService.findById(id);
        return bookDTO;
    }

    /**
     * Get book list
     * @return
     */
    @ApiOperation(value="Get List", notes="Get book list")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<BookDTO> getbookList (){
        return bookService.findAll();
    }

    /**
     * Add the information of a book
     * @param bookDTO
     * @return
     */
    @ApiOperation(value="Add", notes="Add the information of a book")
    @ApiImplicitParam(name = "book", value = "book entity", required = true, dataType = "book")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public BookDTO add (@RequestBody BookDTO bookDTO){
        return bookService.save(bookDTO);
    }

    /**
     * Delete book according to the id
     * @param id
     * @return
     */
    @ApiOperation(value="Delete", notes="Delete book according to the id of url")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable(value = "id") long id){
        bookService.deleteById(id);
    }

    /**
     * pdate the information of book according to the id
     * @param bookDTO
     * @return
     */
    @ApiOperation(value="Update", notes="Update the information of book according to the id of url")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "Book ID", required = true, dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "book", value = "book entity", required = true, dataType = "book")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public BookDTO update (@PathVariable("id") long id, @RequestBody BookDTO bookDTO){
        return bookService.save(bookDTO);
    }
}
