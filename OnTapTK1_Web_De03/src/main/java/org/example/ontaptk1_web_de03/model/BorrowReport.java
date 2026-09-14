package org.example.ontaptk1_web_de03.model;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Named("borrowReport")
@SessionScoped
public class BorrowReport implements Serializable {
    private int studentId;
    private String studentName;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private List<String> bookTypes;
    private long borrowDays;

    public BorrowReport(int studentId, String studentName, LocalDate borrowDate, LocalDate returnDate, List<String> bookTypes, long borrowDays) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.bookTypes = bookTypes;
        this.borrowDays = borrowDays;
    }

    public BorrowReport() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public List<String> getBookTypes() {
        return bookTypes;
    }

    public void setBookTypes(List<String> bookTypes) {
        this.bookTypes = bookTypes;
    }

    public long getBorrowDays() {
        return borrowDays;
    }

    public void setBorrowDays(long borrowDays) {
        this.borrowDays = borrowDays;
    }
}
