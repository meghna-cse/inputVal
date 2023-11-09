package com.inputvalidation.springphonebook.repository;

import com.inputvalidation.springphonebook.model.PhoneBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneBookRepository extends JpaRepository<PhoneBook, Long> {
    //retrieve all phone books
    List<PhoneBook> findAll();
    List<PhoneBook> findByName(String name);
    List<PhoneBook> findByPhoneNumber(String phoneNumber);

    //delete phone book by name
    void deleteByName(String name);

    //delete phone book by phone number
    void deleteByPhoneNumber(String phoneNumber);
}
