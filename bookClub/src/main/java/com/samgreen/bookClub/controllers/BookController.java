//package com.samgreen.bookClub.controllers;
//
//import javax.servlet.http.HttpSession;
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.samgreen.bookClub.models.Book;
//import com.samgreen.bookClub.models.User;
//import com.samgreen.bookClub.services.BookService;
//import com.samgreen.bookClub.services.UserService;
//
//@Service
//
//public class BookController {
//	@Autowired
//	private UserService userService;
//	@Autowired
//	private BookService bookService;
//	
//	
//	
//	
//	
//	
//	@GetMapping("/newBook") 
//	public String newBook(@ModelAttribute("book") Book book, Model model, HttpSession session) {
//		User user = userService.findById((Long)session.getAttribute("userId"));
//		
//		model.addAttribute("user", user);
//		return "newBook.jsp";
//	}
//	
//	
//	 @GetMapping("/books/{id}/edit")
//	    public String editPage(Model model, @PathVariable("id") Long id, HttpSession session) {
//	    	
//	    	if(session.getAttribute("userId") == null) {
//	    		return "redirect:/";
//	    	}
//	    	
//	    	Book book = bookService.findById(id);
//	    	model.addAttribute("book", book);
//	    	
//	    	return "editPage.jsp";
//	    }
//	 
//	 
//	 @GetMapping("/viewBook/{id}")
//	 public String viewBook(@PathVariable("id") Long id, HttpSession session, Model model) {
//	    	if(session.getAttribute("userId") == null) {
//	    		return "redirect:/";
//	    	}
//	    	
//	    	Book book = bookService.findById(id);
//	    	model.addAttribute("book", book);
//	    	model.addAttribute("user", userService.findById((Long)session.getAttribute("userId")));
//	    	
//	    	return "/viewBook.jsp";
//	    }
//	 
//	 @PostMapping("/saveBook")
//		public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
//			if(result.hasErrors()) {
//				return "newBook.jsp";
//			}
//			
//			bookService.create(book);
//			return "redirect:/dashboard";
//		}
//		
//	 @PostMapping("/updateBook")
//		public String updateBook(@Valid @ModelAttribute("book") Book book, @PathVariable("id") Long id, BindingResult result) {
//			if(result.hasErrors()) {
//				return "/books/{id}/edit";
//			}
//			
//			bookService.update(book);
//			return "redirect:/dashboard";
//		}
//		
//	 
////	  @GetMapping("/books/{id}/edit")
////	    public String editPage(Model model, @PathVariable("id") Long id, HttpSession session) {
////	    	
////	    	if(session.getAttribute("userId") == null) {
////	    		return "redirect:/";
////	    	}
////	    	
////	    	Book book = bookService.findById(id);
////	    	model.addAttribute("book", book);
////	    	
////	    	return "editPage.jsp";
////	    }
//	
//	    
//	 
//	
//	 public UserService getUserService() {
//		return userService;
//	}
//
//
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}
//
//
//	public BookService getBookService() {
//		return bookService;
//	}
//
//
//	public void setBookService(BookService bookService) {
//		this.bookService = bookService;
//	}
//
//
//		 
//		 bookService.create(book);
//		 return "redirect:/dashboard";
//	 }
//	 
//
//}
