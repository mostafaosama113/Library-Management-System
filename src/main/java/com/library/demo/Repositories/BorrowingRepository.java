package com.library.demo.Repositories;

import com.library.demo.Models.BorrowingCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.library.demo.Models.Borrowing;
@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing, BorrowingCompositeKey> {

}
