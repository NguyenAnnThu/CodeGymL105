package com.example.book.repository;

import com.example.book.entity.Borrow;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IBorrowRepositry extends JpaRepository<Borrow, Integer> {
    Optional<Borrow> findByBorrowCodeAndReturnedFalse(int borrowCode);
    List<Borrow> findByBook_Id(int bookId);
}
