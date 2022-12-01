package main.controll;

import main.domain.SQLInteraction.SQLInteracter;

import java.util.List;

public class Controller {
    public static void main(String[] arg) {
        List<String> repositories = SQLInteracter.readRepositoryList();
        System.out.println(repositories);
    }

}
