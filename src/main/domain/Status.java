package main.domain;

import java.util.ArrayList;
import java.util.List;
import main.domain.SQLInteraction.SQLInteracter;

public class Status {
    private final String repositoryName;
    private final int no;
    private String message;

    public Status(String repositoryName, int no) {
        this.repositoryName = repositoryName;
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void deleteStatus() {
        SQLInteracter.deleteStatus(no, repositoryName);
    }

}
