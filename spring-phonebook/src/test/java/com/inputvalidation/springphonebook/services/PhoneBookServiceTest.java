package com.inputvalidation.springphonebook.services;

import com.inputvalidation.springphonebook.model.PhoneBook;
import com.inputvalidation.springphonebook.repository.AuditLogRepository;
import com.inputvalidation.springphonebook.repository.PhoneBookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PhoneBookServiceTest {
     @Autowired
     private PhoneBookService phoneBookService;

     @MockBean
     private PhoneBookRepository phoneBookRepository;

     @MockBean
     private AuditLogRepository auditLogRepository;

    @Test
    void getAllPhoneBooks() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.setPhoneNumber("+1(703)111-2121");
        phoneBook.setName("Wellington Samuel");

        PhoneBook phoneBook2 = new PhoneBook();
        phoneBook2.setPhoneNumber("+1234 (201) 123-1234");
        phoneBook2.setName("Wellington Samuel");

        PhoneBook phoneBook3 = new PhoneBook();
        phoneBook3.setPhoneNumber("+1(703)111-2121");
        phoneBook3.setName("<Script>alert(“XSS”)</Script>l");



        List<PhoneBook> phonebookList = new ArrayList();
        phonebookList.add(phoneBook);

        Mockito.when(phoneBookRepository.findAll()).thenReturn(phonebookList);

        List<PhoneBook> result = phoneBookService.getAllPhoneBooks();

        //assert that result is not null
        assertFalse(result.isEmpty());
        //assert that result count is 1
        assertEquals(1, result.size());

        Mockito.when(phoneBookRepository.save(phoneBook2)).thenThrow(new RuntimeException("Provide a valid phone number"));

        assertThrows(RuntimeException.class, () -> phoneBookService.addPhoneBook(phoneBook2));

        Mockito.when(phoneBookRepository.save(phoneBook3)).thenThrow(new RuntimeException("Provide a valid name"));

        assertThrows(RuntimeException.class, () -> phoneBookService.addPhoneBook(phoneBook3));
    }

    @Test
    void addPhoneBook() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.setPhoneNumber("+1(703)111-2121");
        phoneBook.setName("Wellington Samuel");

        List<PhoneBook> phonebookList = new ArrayList();
        phonebookList.add(phoneBook);

        Mockito.when(phoneBookRepository.findAll()).thenReturn(phonebookList);

        List<PhoneBook> result = phoneBookService.getAllPhoneBooks();

        //assert that result is not null
        assertFalse(result.isEmpty());
        //assert that result count is 1
        assertEquals(1, result.size());
        assertEquals("Wellington Samuel",result.get(0).getName());
        assertEquals("+1(703)111-2121",result.get(0).getPhoneNumber());
    }

    @Test
    void deletePhoneBookByName() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.setPhoneNumber("+1(703)111-2121");
        phoneBook.setName("Wellington Samuel");

        List<PhoneBook> phonebookList = new ArrayList();
        phonebookList.add(phoneBook);

        Mockito.when(phoneBookRepository.findAll()).thenReturn(phonebookList);

        List<PhoneBook> result = phoneBookService.getAllPhoneBooks();


        //assert that result is not null
        assertFalse(result.isEmpty());
        //assert that result count is 1
        assertEquals(1, result.size());
        assertEquals("Wellington Samuel",result.get(0).getName());
        assertEquals("+1(703)111-2121",result.get(0).getPhoneNumber());

        Mockito.when(phoneBookRepository.findAll()).thenReturn(new ArrayList<>());

        phoneBookService.deletePhoneBookByName("Wellington Samuel");

        List<PhoneBook> resultAfterDelete = phoneBookService.getAllPhoneBooks();

        assertTrue(resultAfterDelete.isEmpty());
    }

    @Test
    void deletePhoneBookByPhoneNumber() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.setPhoneNumber("+1(703)111-2121");
        phoneBook.setName("Wellington Samuel");

        List<PhoneBook> phonebookList = new ArrayList();
        phonebookList.add(phoneBook);

        Mockito.when(phoneBookRepository.findAll()).thenReturn(phonebookList);

        List<PhoneBook> result = phoneBookService.getAllPhoneBooks();


        //assert that result is not null
        assertFalse(result.isEmpty());
        //assert that result count is 1
        assertEquals(1, result.size());
        assertEquals("Wellington Samuel",result.get(0).getName());
        assertEquals("+1(703)111-2121",result.get(0).getPhoneNumber());

        Mockito.when(phoneBookRepository.findAll()).thenReturn(new ArrayList<>());

        phoneBookService.deletePhoneBookByPhoneNumber("+1(703)111-2121");

        List<PhoneBook> resultAfterDelete = phoneBookService.getAllPhoneBooks();

        assertTrue(resultAfterDelete.isEmpty());
    }
}