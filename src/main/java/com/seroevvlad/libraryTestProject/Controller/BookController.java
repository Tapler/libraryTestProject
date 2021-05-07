package com.seroevvlad.libraryTestProject.Controller;

import com.seroevvlad.libraryTestProject.Entity.Book;
import com.seroevvlad.libraryTestProject.Entity.Client;
import com.seroevvlad.libraryTestProject.Service.BookService;
import com.seroevvlad.libraryTestProject.Service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class BookController {
    final BookService bookService;
    final ClientService clientService;

    public BookController(BookService bookService, ClientService clientService) {
        this.bookService = bookService;
        this.clientService = clientService;
    }

    @PostMapping("/clients/{clientId}/new_book")
    public String addBook(@ModelAttribute("book") Book book,
                          @PathVariable Long clientId) {
        Client client = clientService.findById(clientId);
        book.setClient(client);
        bookService.saveBook(book);
        return "redirect:/clients/" + book.getClient().getId();
    }

    @GetMapping("/book-update/{id}")
    public String updateBookForm(@PathVariable Long id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "book-update";
    }

    @PostMapping("/book-update")
    public String updateBook(Book book) {
        bookService.saveBook(book);
        return "redirect:/clients/" + book.getClient().getId();
    }

    @RequestMapping("/clients/{id}/book={bookId}/delete")
    public RedirectView deleteBook(@PathVariable Long id,
                                   @PathVariable Long bookId) {
        if (bookService.findById(bookId).getDateOfDelivery() != null) {
            bookService.deleteById(bookId);
        }
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/clients/" + id);
        return redirectView;
    }
}
