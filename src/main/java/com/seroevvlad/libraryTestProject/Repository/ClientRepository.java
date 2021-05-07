package com.seroevvlad.libraryTestProject.Repository;


import com.seroevvlad.libraryTestProject.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
