package com.inputvalidation.springphonebook.services;

import com.inputvalidation.springphonebook.auditing.Auditable;
import com.inputvalidation.springphonebook.model.PhoneBook;
import com.inputvalidation.springphonebook.repository.PhoneBookRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneBookService {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private PhoneBookRepository phoneBookRepository;

    //get all phonebooks
    @Auditable
    public List<PhoneBook> getAllPhoneBooks(){
        //retrieve all phone books
        List<PhoneBook> phoneBooks = phoneBookRepository.findAll();
        return phoneBooks;
    }

    //add phone book
    @Transactional
    @Auditable
    public PhoneBook addPhoneBook(PhoneBook phoneBook){
        //validate the phone book
        if(phoneBook.getName() == null || phoneBook.getName().isEmpty()){
            throw new RuntimeException("Name is required");
        }

        if(phoneBook.getPhoneNumber() == null || phoneBook.getPhoneNumber().isEmpty()){
            throw new RuntimeException("Phone number is required");
        }

        String fullnameRegex = "^(?i)(?:(?:[a-z'-]+(?:\\s+[a-z'-]+)*),?\\s+[a-z'-]+(?:\\s+[a-z'-]+)*(?:\\s+[a-z'-]+)?)|(?:(?:[a-z'-]+(?:\\s+[a-z'-]+)*),?\\s*[a-z'-]+(?:\\s*[a-z'-]+)*['’]?[a-z'-]*(?:\\s+[a-z'-]+)?)$\n";
        String phoneNumberRegex = "^(?:\\+?\\d{1,3}\\s*)?(?:\\(\\d{3}\\)|\\d{3})[-.\\s]?\\d{3}[-.\\s]?\\d{4}$";

        if (!phoneBook.getPhoneNumber().matches(phoneNumberRegex)) {
            throw new RuntimeException("Provide a valid phone number");
        }

        if (!phoneBook.getName().matches(fullnameRegex)) {
            throw new RuntimeException("Provide a valid name");
        }

        phoneBookRepository.save(phoneBook);
        return phoneBook;
    }

    @Transactional
    @Auditable
    public int deletePhoneBookByName(String name){
        //check if the name is valid
        if(name == null || name.isEmpty()){
            throw new RuntimeException("Name is required");
        }

        phoneBookRepository.deleteByName(name);
        return 1;
    }

    @Transactional
    @Auditable
    public int deletePhoneBookByPhoneNumber(String phoneNumber){
        //check if the phone number is valid
        if(phoneNumber == null || phoneNumber.isEmpty()){
            throw new RuntimeException("Phone number is required");
        }

        phoneBookRepository.deleteByPhoneNumber(phoneNumber);
        return 1;
    }
}
