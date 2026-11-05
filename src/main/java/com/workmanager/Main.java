
package com.workmanager;

import com.workmanager.application.service.UserService;
import com.workmanager.domain.model.User;
import com.workmanager.infrastructure.persistence.memory.MemoryUserRepository;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        // Création du repository
        MemoryUserRepository repository = new MemoryUserRepository();

        // Injection du repertoire dans UserService
        UserService userService = new UserService(repository);

        // Création et enregistrement d'un utilisateur
            User user = userService.createUser(
                    "Isaac",
                    "ouattara",
                    "isaac@example.com",
                    "empreinte_securisee"
            );

            System.out.println("Utilisateur crée et enregistré !");
            System.out.println("Prénom :"+ user.getFirstName());
            System.out.println("Nom :"+ user.getLastName());
            System.out.println("Email :"+ user.getEmail());


        // Recherche par identifiant
        Optional<User> result = userService.findUserById(user.getId());

        if (result.isPresent()){
            System.out.println("Utilisateur retrouvé par ID !");
        }

        //Recherche par email
        Optional<User> resultEmail = userService.findUserByEmail(user.getEmail());

        if (result.isPresent()){
            System.out.println("Utilisateur retrouvé par email !");
        }

    }
}
