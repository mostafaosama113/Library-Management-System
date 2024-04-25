package com.library.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.library.demo.Models.Record;
@Repository
public interface RecordRepository extends JpaRepository<Record , Long> {

}
