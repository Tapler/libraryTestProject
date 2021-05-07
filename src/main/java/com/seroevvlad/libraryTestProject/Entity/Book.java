package com.seroevvlad.libraryTestProject.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String title;
    @Column(name = "publishing_year")
    private Integer publishingYear;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @Column
    private String author;
    @Column
    private String genre;
    @Column(name = "publishing_house")
    private String publishingHouse;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_of_issue")
    private LocalDate dateOfIssue;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_of_delivery")
    private LocalDate dateOfDelivery;

    public Book(Long id, String title, Integer publishingYear, Client client, String genre,
                String publishingHouse, LocalDate dateOfIssue) {
        this.id = id;
        this.title = title;
        this.publishingYear = publishingYear;
        this.client = client;
        this.genre = genre;
        this.publishingHouse = publishingHouse;
        this.dateOfIssue = dateOfIssue;
    }
}
