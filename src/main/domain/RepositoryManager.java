package main.domain;

import java.util.List;

import main.domain.SQLInteraction.SQLInteracter;
import main.constants.Message.Exception;

public class RepositoryManager {

    private final List<String> repositories;

    public RepositoryManager() {
        repositories = SQLInteracter.readRepositories();
    }

    public boolean contains(String name) {
        return repositories.contains(name);
    }

    public void deleteRepository(String name) {
        if (!repositories.contains(name)) {
            throw new IllegalArgumentException(Exception.NOT_FOUND_DELETE_REPOSITORY);
        }

        List<Status> statuses = SQLInteracter.readStatusesNoInRepository(name);

        for (Status status: statuses) {
            SQLInteracter.readDocumentNameInStatus(name, status.getNo()).forEach(Document::deleteDocument);
        }

        statuses.forEach(Status::deleteStatus);
        SQLInteracter.deleteRepository(name);
    }



    @Override public String toString() {
        return "";
    }
}
