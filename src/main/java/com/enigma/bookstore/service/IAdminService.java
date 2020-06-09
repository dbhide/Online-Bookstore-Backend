package com.enigma.bookstore.service;

import com.enigma.bookstore.dto.BookDTO;
import org.springframework.web.multipart.MultipartFile;

public interface IAdminService {
    String addBook(BookDTO bookDTO);

    String uploadImage(MultipartFile file);

    String updateBook(BookDTO bookDTO, Integer bookId);

    String deleteBook(Integer bookId);
}
