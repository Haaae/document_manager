package main.domain;

import java.util.List;

import main.domain.SQLInteraction.SQLInteracter;
import main.constants.Message.Exception;

public class RepositoryManager {

    private final List<String> repositories;

    public RepositoryManager() {
        repositories = SQLInteracter.readRepositories();
    }

    @Override public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;

        for (String repository : repositories) {
            stringBuilder.append(count++).append(repository).append("\n");
        }

        return stringBuilder.toString();
    }

    public boolean contains(String name) {
        return repositories.contains(name);
    }

    public void deleteRepository(String name) {
        deletionValidate(name);

        List<Status> statuses = SQLInteracter.readStatusesNoInRepository(name);

        for (Status status: statuses) {
            SQLInteracter.readDocumentNameInStatus(name, status.getNo()).forEach(Document::deleteDocument);
        }

        statuses.forEach(Status::deleteStatus);
        SQLInteracter.deleteRepository(name);
    }

    public void insertRepository(String name) {
        insertionValidate(name);
        SQLInteracter.insertRepository(name);
        repositories.add(name);
    }

    private void deletionValidate(String name) {
        if (!repositories.contains(name)) {
            throw new IllegalArgumentException(Exception.NOT_FOUND_DELETE_REPOSITORY);
        }
    }

    private void insertionValidate(String name) {
        if (repositories.contains(name)) {
            throw new IllegalArgumentException(Exception.ALREADY_EXIST_REPOSITORY);
        }
    }
}
