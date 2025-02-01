package com.br.book.service;

import com.br.book.dto.request.BookRequestDTO;
import com.br.book.dto.response.BookResponseDTO;
import com.br.book.entity.Book;
import com.br.book.exception.BookNotFoundException;
import com.br.book.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookResponseDTO> getAllBooks(){
        logger.info("Iniciando o método de busca de books");
        List<Book> books = bookRepository.findAll();

        logger.info("Finalizando a buca de todas as books");
        return books.stream()
                .map(book -> new BookResponseDTO(
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getIsbn(),
                        book.getPublication_year(),
                        book.getAvaliable_copies()))
                .collect(Collectors.toList());
    }

    public BookResponseDTO getBookById(Long id){
        logger.info("Iniciando o método de busca de book");
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with ID: " + id));
        logger.info("Finalizando o método de busca de book");
        return new BookResponseDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getPublication_year(),
                book.getAvaliable_copies());
    }

    public BookResponseDTO createBook(BookRequestDTO bookRequestDTO){
        logger.info("Iniciando o método de criação de books");
        Book book = new Book(bookRequestDTO.getTitle(),
                bookRequestDTO.getAuthor(),
                bookRequestDTO.getIsbn(),
                bookRequestDTO.getPublication_year(),
                bookRequestDTO.getAvaliable_copies());
        Book savedBook = bookRepository.save(book);
        logger.info("Finalizando o método de criação de books");
        return new BookResponseDTO(savedBook.getId(),
                savedBook.getTitle(),
                savedBook.getAuthor(),
                savedBook.getIsbn(),
                savedBook.getPublication_year(),
                savedBook.getAvaliable_copies());
    }

    public BookResponseDTO updateBook(Long id, BookRequestDTO bookRequestDTO){
        logger.info("Iniciando o método de atualização de book");
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with ID: " + id));

        book.setTitle(bookRequestDTO.getTitle());
        book.setAuthor(bookRequestDTO.getAuthor());
        book.setIsbn(bookRequestDTO.getIsbn());
        book.setPublication_year(bookRequestDTO.getPublication_year());
        book.setAvaliable_copies(bookRequestDTO.getAvaliable_copies());

        Book updatedBook = bookRepository.save(book);

        logger.info("Finalizando o método de atualização de book");

        return new BookResponseDTO(
                updatedBook.getId(),
                updatedBook.getTitle(),
                updatedBook.getAuthor(),
                updatedBook.getIsbn(),
                updatedBook.getPublication_year(),
                updatedBook.getAvaliable_copies());

    }

    public void deleteBook(Long id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with ID: " + id));

        bookRepository.delete(book);
    }





}
