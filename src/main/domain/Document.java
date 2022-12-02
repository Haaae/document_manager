package main.domain;

public class Document {
    private final String name;
    private final String repositoryName;
    private final int statusNo;
    private String contents;

    public Document(String repositoryName, int statusNo, String name) {
        this.name = name;
        this.repositoryName = repositoryName;
        this.statusNo = statusNo;
    }

    public void deleteDocument() {

    }

}
