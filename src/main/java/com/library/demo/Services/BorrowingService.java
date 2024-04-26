package com.library.demo.Services;

import com.library.demo.Models.Book;
import com.library.demo.Models.Borrowing;
import com.library.demo.Models.BorrowingCompositeKey;
import com.library.demo.Models.Patron;
import com.library.demo.Repositories.BookRepository;
import com.library.demo.Repositories.BorrowingRepository;
import com.library.demo.Repositories.PatronRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BorrowingService {

    BorrowingRepository borrowingRepository;
    BookRepository bookRepository;
    PatronRepository patronRepository;
    BorrowingService(BorrowingRepository borrowingRepository , BookRepository bookRepository , PatronRepository patronRepository){
        this.borrowingRepository = borrowingRepository;
        this.patronRepository = patronRepository;
        this.bookRepository = bookRepository;
    }
    public Optional<String> addRecord(Long bookId, Long patronId) {
        if(!bookRepository.existsById(bookId)){
            return Optional.of("This book is not exists.");
        }
        if(!patronRepository.existsById(patronId)){
            return Optional.of("This patron is not exists.");
        }
        Book book = bookRepository.findById(bookId).get();
        Patron patron = patronRepository.findById(patronId).get();
        BorrowingCompositeKey compositeKey = new BorrowingCompositeKey();
        compositeKey.setBook_id(book);
        compositeKey.setPatron_id(patron);
        LocalDate now = LocalDate.now();
        if(borrowingRepository.existsById(compositeKey)){
            Borrowing borrowing = borrowingRepository.findById(compositeKey).get();
            if(borrowing.getReturn_date() != null){
                borrowing.setBorrowing_date(now);
                borrowing.setReturn_date(null);
                borrowingRepository.save(borrowing);
                return Optional.empty();
            }else{
                return Optional.of("You already borrow this book.");
            }
        }
        Borrowing record = new Borrowing();
        record.setId(compositeKey);
        record.setBorrowing_date(now);
        borrowingRepository.save(record);
        return Optional.empty();
    }
    public Optional<String> returnBook(Long bookId, Long patronId) {
        if(!bookRepository.existsById(bookId)){
            return Optional.of("This book is not exists.");
        }
        if(!patronRepository.existsById(patronId)){
            return Optional.of("This patron is not exists.");
        }
        Book book = bookRepository.findById(bookId).get();
        Patron patron = patronRepository.findById(patronId).get();
        BorrowingCompositeKey compositeKey = new BorrowingCompositeKey();
        compositeKey.setBook_id(book);
        compositeKey.setPatron_id(patron);
        LocalDate now = LocalDate.now();
        if(borrowingRepository.existsById(compositeKey)){
            Borrowing borrowing = borrowingRepository.findById(compositeKey).get();
            if(borrowing.getReturn_date() == null){
                borrowing.setReturn_date(now);
                borrowingRepository.save(borrowing);
                return Optional.empty();
            }else{
                return Optional.of("You don't have this book.");
            }
        }else{
            return Optional.of("You don't have this book.");
        }
    }
}
