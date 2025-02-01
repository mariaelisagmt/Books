package com.br.book.dto.response;

import java.math.BigDecimal;

public class BookResponseDTO {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private Integer publication_year;
    private Integer avaliable_copies;

    public BookResponseDTO(Long id, String title, String author, String isbn, Integer publication_year, Integer avaliable_copies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publication_year = publication_year;
        this.avaliable_copies = avaliable_copies;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getPublication_year() {
        return publication_year;
    }

    public Integer getAvaliable_copies() {
        return avaliable_copies;
    }
}
