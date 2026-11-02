
package com.workmanager;

import com.workmanager.application.service.UserService;
import com.workmanager.domain.model.User;

public class Main {

    public static void main(String[] args) {

        UserService userService = new UserService();

        try{
            User user = userService.createUser(
                    "Isaac",
                    "ouattara",
                    "isaac@example.com",
                    "empreinte_securisee"
            );

            System.out.println("Utilisateur crée !");
            System.out.println("Prénom :"+ user.getFirstName());
            System.out.println("Nom :"+ user.getLastName());
            System.out.println("Email :"+ user.getEmail());

        } catch (IllegalArgumentException e) {
            System.out.println("Erreur :"+ e.getMessage());
        }

    }
}
