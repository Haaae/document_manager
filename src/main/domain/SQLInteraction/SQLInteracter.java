package main.domain.SQLInteraction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import main.constants.SQL.Info;
import main.constants.SQL.Query;

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
}
