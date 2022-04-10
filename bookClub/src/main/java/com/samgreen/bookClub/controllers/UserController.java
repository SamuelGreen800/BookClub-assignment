package com.samgreen.bookClub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.samgreen.bookClub.models.Book;
import com.samgreen.bookClub.models.LoginUser;
import com.samgreen.bookClub.models.User;
import com.samgreen.bookClub.services.BookService;
import com.samgreen.bookClub.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public String index() {
		return "redirect:/login";
	}
	
	
	@GetMapping("/login")
	public String signIn(Model model) {
	    model.addAttribute("newUser", new User());
	    model.addAttribute("newLogin", new LoginUser());
	    return "login.jsp";
	    
	}
	    
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		model.addAttribute("books", bookService.all());
    	model.addAttribute("user", userService.findById((Long)session.getAttribute("userId")));
		return "dashboard.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
	     
		User user = userService.register(newUser, result);
		
	    if(result.hasErrors()) {
	        model.addAttribute("newLogin", new LoginUser());
	        return "login.jsp";
	    }
	    
	    session.setAttribute("userId", user.getId());
	 
	    return "redirect:/dashboard";
	}
	 
	    
	@PostMapping("/auth")
	public String auth(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
	     
		User user = userService.login(newLogin, result);
	 
	    if(result.hasErrors()) {
	        model.addAttribute("newUser", new User());
	        return "login.jsp";
	    }
	    
	    session.setAttribute("userId", user.getId());
	    return "redirect:/dashboard";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userId", null);
	     
	    return "redirect:/";
	}
	
	
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
	     
	//==================================================
	
	public UserService getUserService() {
		return userService;
	}
	 
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
}





