package com.tps.user.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;


import com.tps.user.models.BookItem;
import com.tps.user.repository.BookItemRepository;
@Controller 
@RequestMapping(path = "/book")
public class BookItemController {

    @Autowired
    private BookItemRepository bookItemRepository;

    @GetMapping(path = "/add")
    public @ResponseBody String addNewBookItem(@RequestParam String bookname){
        BookItem bItem = new BookItem();
        bItem.setBookname(bookname);
        bookItemRepository.save(bItem);
        return "BookItem Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<BookItem> getAllBooks(){
        return bookItemRepository.findAll();
    }
}