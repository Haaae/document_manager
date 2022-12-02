package main.domain;

public class Document {
    private String name;
    private String contents;
    private final String repositoryName;
    private final String status_no;

    public Document(String repositoryName, String status_no) {
        this.repositoryName = repositoryName;
        this.status_no = status_no;
    }

    public void deleteDocument() {

    }

}
