package main.domain.SQLInteraction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import main.constants.SQL.ColumnIndex;
import main.constants.SQL.Info;
import main.constants.SQL.Query;
import main.domain.Document;
import main.domain.Status;

public class SQLInteracter {

    private SQLInteracter() {}

    public static List<String> readRepositories() {
        List<String> repositories = new ArrayList<>();

        String query = Query.READING_REPOSITORY_LIST;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Info.JDBC_URL, Info.SQL_ID, Info.SQL_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()) {
                repositories.add(rs.getString(ColumnIndex.REPOSITORY_NAME));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return repositories;
    }

    public static List<Status> readStatusesNoInRepository(String repositoryName) {
        List<Status> statuses = new ArrayList<>();

        String query = Query.READING_STATUSES_IN_REPOSITORY_WITHOUT_NAME + repositoryName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Info.JDBC_URL, Info.SQL_ID, Info.SQL_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()) {
                statuses.add(new Status(repositoryName, rs.getInt(ColumnIndex.STATUS_NO)));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return statuses;
    }

    public static List<Document> readDocumentNameInStatus(String repositoryName, int statusNo) {
        List<Document> documents = new ArrayList<>();

        String query = "SELECT * FROM Document WHERE repository_name = " + repositoryName + " status_no = " + statusNo;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Info.JDBC_URL, Info.SQL_ID, Info.SQL_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()) {
                documents.add(new Document(repositoryName, statusNo, rs.getString(ColumnIndex.DOCUMENT_NAME), rs.getString(ColumnIndex.DOCUMENT_CONTENTS)));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return Collections.unmodifiableList(documents);
    }

    public static void deleteRepository(String name) {
        String query = Query.DELETE_REPOSITORY_WITHOUT_NAME + "'" + name + "'";
        executeQuery(query);
    }

    public static void deleteStatus(int no, String repositoryName) {
        String query = "DELETE FROM Repository_status WHERE no = '" + no + "'"
                + ", repository_name = " + repositoryName + "'";
        executeQuery(query);
    }

    public static void deleteDocument(String name, String repositoryName, int statusNo) {
        String query = "DELETE FROM Document WHERE name = " + name + ", repository_name = '" + repositoryName + "'"
                + ", status_no = '" + statusNo + "'";
        executeQuery(query);

    }

    public static void insertRepository(String name) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Info.JDBC_URL, Info.SQL_ID, Info.SQL_PASSWORD);

            String query = "INSERT INTO Repository VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);

            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertStatus(String repositoryName, String message, int no) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Info.JDBC_URL, Info.SQL_ID, Info.SQL_PASSWORD);

            int statusCount = countStatuses(repositoryName);

            String query = "INSERT INTO Repository_status VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, statusCount++);
            preparedStatement.setString(2, message);
            preparedStatement.setString(3, repositoryName);

            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertDocument(String repositoryName, String contents, String name, int no) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Info.JDBC_URL, Info.SQL_ID, Info.SQL_PASSWORD);


            String query = "INSERT INTO Document VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, contents);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, repositoryName);
            preparedStatement.setInt(4, no);

            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static int countStatuses(String repositoryName) {
        String statusCountQuery = "SELECT count(*) FROM Repository_status WHERE repository_name = " + repositoryName;
        int statusCount = -1;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Info.JDBC_URL, Info.SQL_ID, Info.SQL_PASSWORD);
            Statement statement = connection.createStatement();
            statusCount = statement.executeQuery(statusCountQuery).getInt(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return statusCount;
    }

    private static void executeQuery(String query) {
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
}
