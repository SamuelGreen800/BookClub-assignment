package com.samgreen.bookClub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samgreen.bookClub.models.Book;
import com.samgreen.bookClub.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository repo;
	
//	public BookService(BookRepository repo) {
//		this.repo = repo;


	
	public List<Book> all() {
		return repo.findAll();
	}
	


	public Book create(Book book) {
		return repo.save(book);
	}
	
	public Book update(Book book) {
		return repo.save(book);
	}

	public Book findById(Long id) {
		Optional<Book> optionalBook = repo.findById(id);
		if(optionalBook.isPresent() ) {
			return optionalBook.get();
		}
		else {
			return null;
		}
	}
	public void delete(Long id) {
		repo.deleteById(id);
	}

	public BookRepository getRepo() {
		return repo;
	}
	
	



}
