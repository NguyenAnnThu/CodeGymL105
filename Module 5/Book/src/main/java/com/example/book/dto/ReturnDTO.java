package com.example.book.dto;

import jakarta.validation.constraints.NotNull;

public class ReturnDTO {
    @NotNull(message = "Borrow code can't be null")
    private int borrowCode;

    public int getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(int borrowCode) {
        this.borrowCode = borrowCode;
    }
}
