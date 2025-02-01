package com.br.book.dto.request;

import java.math.BigDecimal;

public class BookRequestDTO {
    private String title;
    private String author;
    private String isbn;
    private Integer publication_year;
    private Integer avaliable_copies;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(Integer publication_year) {
        this.publication_year = publication_year;
    }

    public Integer getAvaliable_copies() {
        return avaliable_copies;
    }

    public void setAvaliable_copies(Integer avaliable_copies) {
        this.avaliable_copies = avaliable_copies;
    }
}
