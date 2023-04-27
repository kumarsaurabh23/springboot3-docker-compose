package com.example.dc.service;

import com.example.dc.dao.BookRepository;
import com.example.dc.dto.BookDto;
import com.example.dc.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookDto> getAllBooks() {
        return bookRepository.findAll()
                                .stream()
                                .map(b-> new BookDto(b.getId(), b.getName(), b.getAuthor()))
                                .collect(Collectors.toList());
    }

    public void saveBook(BookDto dto) {
        bookRepository.save(new Book(null, dto.name(), dto.author()));
    }
}
