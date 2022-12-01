package main.domain;

import java.util.List;

import main.domain.SQLInteraction.SQLInteracter;

public class RepositoryManager {

    private final List<String> repositories;

    public RepositoryManager() {
        repositories = SQLInteracter.readRepositoryList();
    }

    public void deleteRepository(String name) {

    }



    @Override public String toString() {
        return "";
    }


}
