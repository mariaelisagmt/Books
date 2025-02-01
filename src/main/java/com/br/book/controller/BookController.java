package com.br.book.controller;

import com.br.book.dto.request.BookRequestDTO;
import com.br.book.dto.response.BookResponseDTO;
import com.br.book.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> getAllBooks(){
        List<BookResponseDTO> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBookById(@PathVariable Long id){
        BookResponseDTO bookResponseDTO = bookService.getBookById(id);
        return ResponseEntity.ok(bookResponseDTO);
    }

    @Operation(
            summary = "Create a new book",
            description = "Creates a book ..."
    )
    @PostMapping
    public ResponseEntity<BookResponseDTO> createBook(@RequestBody BookRequestDTO bookRequestDTO){
        BookResponseDTO bookResponseDTO = bookService.createBook(bookRequestDTO);
        return ResponseEntity.ok(bookResponseDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDTO> updateBook(@PathVariable Long id, @RequestBody BookRequestDTO bookRequestDTO){
        BookResponseDTO bookResponseDTO = bookService.updateBook(id, bookRequestDTO);
        return ResponseEntity.ok(bookResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book with ID: " + id + "has been delected.");
    }

}