package main.domain;

import java.util.List;

import main.domain.SQLInteraction.SQLInteracter;
import main.constants.Message.Exception;

public class RepositoryManager {

    private final List<String> repositories;

    public RepositoryManager() {
        repositories = SQLInteracter.readRepositoryList();
    }

    public void deleteRepository(String name) {
        if (!repositories.contains(name)) {
            throw new IllegalArgumentException(Exception.NOT_FOUND_DELETE_REPOSITORY);
        }
        // 해당 저장소의 상태를 DB에서 불러들인다.
        List<Status> statuses = SQLInteracter.findStatusesNoInRepository(name);
        // 해당 저장소의 상태에 소속된 문서를 DB에서 불러들이고 삭제한다.
        for (Status status: statuses) {
            SQLInteracter.findDocumentNameInStatus(name, status.getNo()).forEach(Document::deleteDocument);
        }
        // 해당 저장소의 모든 상태를 DB에서 삭제한다.
        statuses.forEach(Status::deleteStatus);
        // 해당 저장소를 DB에서 삭제한다.
    }



    @Override public String toString() {
        return "";
    }
}
