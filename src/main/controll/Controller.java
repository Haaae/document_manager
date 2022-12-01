package main.controll;

import main.domain.Repository;
import main.domain.SQLInteraction.SQLInteracter;

import java.util.List;

public class Controller {
    public static void main(String[] arg) {
        List<Repository> repositories = SQLInteracter.readRepositoryList();
        System.out.println(repositories);
    }

}
