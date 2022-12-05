package main.controll;

import main.domain.Document;
import main.domain.SQLInteraction.SQLInteracter;
import main.domain.Status;
import main.view.View;

import java.util.List;

public class Controller {
    public static void main(String[] arg) {
        serviceRepository();
        }

        private static void serviceRepository() {
            int menuInput = 0;
            while (menuInput != 5) {
                menuInput = View.printRepositoryMenu();

                if (menuInput == 1) {
                    View.printRepositoryList(SQLInteracter.readRepositories());
                }
                if (menuInput == 2) {
                    serviceStatus();
                }
                if (menuInput == 3) {
                    String repositoryName = View.printInsertStatus();
                    SQLInteracter.insertRepository(repositoryName);
                }
                if (menuInput == 4) {
                    String repositoryName = View.printDeleteRepository();
                    SQLInteracter.deleteRepository(repositoryName);
                }
        }
    }

    private static void serviceStatus() {
        String selectedRepository = View.printSelectRepository();
        int statusMenuInput = 1;
        do {
            statusMenuInput = View.printStatusMenu();
            if (statusMenuInput == 1) {
                List<Status> statuses = SQLInteracter.readStatusesNoInRepository(selectedRepository);
                View.printStatusList(statuses);
            }
            if (statusMenuInput == 2) {
                serviceDocument(selectedRepository);
            }
            if (statusMenuInput == 3) {
                String statusMessage = View.printInsertStatus();
                SQLInteracter.insertStatus(selectedRepository, statusMessage);
            }
            if (statusMenuInput == 4) {
                int statusInt = View.printDeleteStatus();
                SQLInteracter.deleteStatus(statusInt, selectedRepository);
            }
            if (statusMenuInput == 5) {
                break;
            }
        } while (0 < statusMenuInput && statusMenuInput < 6);
    }

    private static void serviceDocument(String repository) {
        int status = View.printSelectStatus();
        int documentMenuInput = 1;
        do {
            documentMenuInput = View.printDocumentMenu();
            if (documentMenuInput == 1) {
                SQLInteracter.readDocumentNameInStatus(repository, status);
            }
            if (documentMenuInput == 2) {
                printDocumentContents(repository, status);
            }
            if (documentMenuInput == 3) {
                List<String> nameAndContents = View.printInsertDocument();
                SQLInteracter.insertDocument(repository,
                        nameAndContents.get(1), nameAndContents.get(0), status);
            }
            if (documentMenuInput == 4) {
                String document = View.printDeleteDocument();
                SQLInteracter.deleteDocument(document, repository,status);
            }
            if (documentMenuInput == 5) {
                break;
            }
        } while (0 < documentMenuInput && documentMenuInput < 4);
    }

    private static void printDocumentContents(String repository, int status) {
        String documentName = View.printSelectDocument();
        List<Document> documents = SQLInteracter.readDocumentNameInStatus(repository, status);
        for (Document document : documents ) {
            if (document.getName().equals(documentName)) {
                View.printDocument(document.getContents());
            }
        }
    }
}
