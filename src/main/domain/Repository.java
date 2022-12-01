package main.domain;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private String name;
    private final List<Status> statuses;

    public Repository(String name) {
        this.name = name;
        statuses = new ArrayList<>();
    }
}
