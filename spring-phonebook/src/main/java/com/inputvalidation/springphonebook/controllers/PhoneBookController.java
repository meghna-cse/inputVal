package com.inputvalidation.springphonebook.controllers;

import com.inputvalidation.springphonebook.model.PhoneBook;
import com.inputvalidation.springphonebook.repository.PhoneBookRepository;
import com.inputvalidation.springphonebook.services.PhoneBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Controller
public class PhoneBookController {
    @Autowired
    private PhoneBookService phoneBookService;

    @Autowired
    private PhoneBookRepository phoneBookRepository;

    @PostMapping("/Phonebook/add")
    public ResponseEntity<Object> createPhoneBook(PhoneBook phoneBook){
        try {
            PhoneBook phoneBook1 = phoneBookService.addPhoneBook(phoneBook);
            return ResponseEntity.ok().body(phoneBook1);
        }catch (RuntimeException e){
            var responseMessage = e.getMessage();
            
            //create json response
            return ResponseEntity.badRequest().body(responseMessage);
        }
    }

    //display the save phonebooks
    @GetMapping("/PhoneBook/list")
    public List<PhoneBook> getAllPhoneBooks(){
        return phoneBookService.getAllPhoneBooks();
    }

    @PutMapping("/PhoneBook/deleteByName")
    public ResponseEntity<Object> deletePhoneBookByName(String name){
        try {
            int deleteResponseCode = phoneBookService.deletePhoneBookByName(name);
            if (deleteResponseCode == 1) {
                return ResponseEntity.ok().body("Phone book deleted successfully");
            } else {
                return ResponseEntity.badRequest().body("Phone book not found");
            }
        }catch (RuntimeException e) {
            //return the response as a json response
            var responseMessage = e.getMessage();

            //create json response
            return ResponseEntity.badRequest().body(responseMessage);
        }
    }

    @PutMapping("/PhoneBook/deleteByNumber")
    public ResponseEntity<Object> deletePhoneBookByNumber(String phoneNumber){
        try {
            int deleteResponseCode = phoneBookService.deletePhoneBookByPhoneNumber(phoneNumber);
            if (deleteResponseCode == 1) {
                return ResponseEntity.ok().body("Phone book deleted successfully");
            } else {
                return ResponseEntity.badRequest().body("Phone book not found");
            }
        }catch (RuntimeException e) {
            //return the response as a json response
            var responseMessage = e.getMessage();

            //create json response
            return ResponseEntity.badRequest().body(responseMessage);
        }
    }
}
