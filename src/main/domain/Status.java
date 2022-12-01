package main.domain;

import java.util.ArrayList;
import java.util.List;

public class Status {
    private int no;
    private String message;
    private final List<Document> documents;

    public Status() {
        documents = new ArrayList<>();
    }
}
