package com.samgreen.bookClub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.samgreen.bookClub.models.Book;
import com.samgreen.bookClub.models.User;
import com.samgreen.bookClub.services.BookService;
import com.samgreen.bookClub.services.UserService;

@Controller

public class BookController {
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	
	
	
	
	
	
	//===============================================================BookController====================================s]
		@GetMapping("/newBook") 
		public String newBook(@ModelAttribute("book") Book book, Model model, HttpSession session) {
			User user = userService.findById((Long)session.getAttribute("userId"));
			
			model.addAttribute("user", user);
			return "newBook.jsp";
		}
		
		
		@PostMapping("/saveBook")
		public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
			if(result.hasErrors()) {
				return "newBook.jsp";
			}
			
			bookService.create(book);
			return "redirect:/dashboard";
		}
		
			
		 @GetMapping("/viewBook/{id}")
		 public String viewBook(@PathVariable("id") Long id, HttpSession session, Model model) {
		    	if(session.getAttribute("userId") == null) {
		    		return "redirect:/";
		    	}
		    	
		    	Book book = bookService.findById(id);
		    	model.addAttribute("book", book);
		    	model.addAttribute("user", userService.findById((Long)session.getAttribute("userId")));
		    	
		    	if(session.getAttribute("userId") != book.getUser().getId()) {
		    		return "/viewBook1.jsp";
		    	}
		    	return "/viewBook.jsp";
		    }
		    
			
		
		@GetMapping("/editBook/{id}")
		public String edit(@PathVariable("id") Long id, Model model) {
			
			
			model.addAttribute("book", bookService.findById(id));
			model.addAttribute("books", bookService.all());
			
			
			return "editBook.jsp";
		}
		
		@PutMapping("/editBook/{id}")
		public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
			if(result.hasErrors()) {
				return "editBook.jsp";
			}
			else {
			bookService.update(book);
			return "redirect:/dashboard";
			}
				
		}
		
			
		@DeleteMapping("/delete/{id}")
		public String delete(@PathVariable("id") Long id) {
			
			bookService.delete(id);
			return "redirect:/dashboard";
				
				
			
		}
		     

}
