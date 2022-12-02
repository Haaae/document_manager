package main.domain.SQLInteraction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import main.constants.SQL.Info;
import main.constants.SQL.Query;
import main.domain.Document;
import main.domain.Status;

public class SQLInteracter {

    private SQLInteracter() {}

    public static List<String> readRepositoryList() {
        List<String> repositories = new ArrayList<>();

        String query = Query.READING_REPOSITORY_LIST;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Info.JDBC_URL, Info.SQL_ID, Info.SQL_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()) {
                repositories.add(rs.getString(1));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return repositories;
    }

    public static void deleteRepository(String name) {
        String query = Query.DELETE_REPOSITORY_WITHOUT_NAME + name;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Info.JDBC_URL, Info.SQL_ID, Info.SQL_PASSWORD);
            Statement statement = connection.createStatement();
            statement.executeQuery(query);
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Status> findStatusesNoInRepository(String repositoryName) {
        List<Status> statuses = new ArrayList<>();
        return statuses;
    }

    public static List<Document> findDocumentNameInStatus(String repositoryName, int statusNo) {
        List<Document> documents = new ArrayList<>();
        return Collections.unmodifiableList(documents);
    }
}
