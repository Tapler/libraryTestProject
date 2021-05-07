package com.seroevvlad.libraryTestProject.Controller;

import com.seroevvlad.libraryTestProject.Entity.Book;
import com.seroevvlad.libraryTestProject.Entity.Client;
import com.seroevvlad.libraryTestProject.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collection;

@Controller
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public String findAll(Model model) {
        Collection<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        model.addAttribute("new_client", new Client());
        return "client-list";
    }

    @PostMapping("/clients/new_client")
    public String addClient(@ModelAttribute("client") Client client) {
        clientService.saveClient(client);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/client-delete/{id}")
    public RedirectView deleteClient(@PathVariable Long id) {
        if (!clientService.findById(id).getBookList()
                .stream().anyMatch(s -> s.getDateOfDelivery() == null)) {
            clientService.deleteById(id);
        }
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/clients");
        return redirectView;
    }

    @GetMapping("/client-update/{id}")
    public String updateClientForm(@PathVariable("id") Long id, Model model) {
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        return "client-update";
    }

    @PostMapping("/client-update")
    public String updateClient(Client client) {
        clientService.saveClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/clients/{id}")
    public String viewClient(@PathVariable Long id, Model model) {
        Client client = clientService.findById(id);
        model.addAttribute(client);
        model.addAttribute("book", new Book());
        return "book-list";
    }
}
