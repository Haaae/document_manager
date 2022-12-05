package main.domain;

import main.domain.SQLInteraction.SQLInteracter;

public class Document {
    private final String name;
    private final String repositoryName;
    private final int statusNo;
    private final String contents;

    public Document(String repositoryName, int statusNo, String name, String contents) {
        this.name = name;
        this.repositoryName = repositoryName;
        this.statusNo = statusNo;
        this.contents = contents;
    }

    public String getName() {
        return name;
    }

    public java.lang.String getContents() {
        return contents;
    }

    public void deleteDocument() {
        SQLInteracter.deleteDocument(name, repositoryName, statusNo);
    }

}
