package main.constants;

import javax.print.attribute.standard.MediaSize.NA;

public final class SQL {
    private static final String SELECT      = "SELECT";
    private static final String DELETE      = "DELETE";
    private static final String FROM        = "FROM";
    private static final String WHERE       = "WHERE";
    private static final String REPOSITORY  = "Repository";
    private static final String NAME        = "NAME";
    private static final String EQUAL       = "=";
    private static final String SPACE       = " ";

    private  SQL() {}

    public static final class Info {
        public static final String JDBC_URL = "jdbc:mysql://192.168.56.103:3308/document_manager";
        public static final String SQL_ID = "mkim";
        public static final String SQL_PASSWORD = "5557";

        private Info() {}
    }

    public static final class Query {
        public static final String READING_REPOSITORY_LIST =
                SELECT + SPACE + "name" + SPACE + FROM + SPACE + REPOSITORY;
        public static final String DELETE_REPOSITORY_WITHOUT_NAME =
                DELETE + SPACE + FROM + SPACE + REPOSITORY + SPACE + WHERE + SPACE + NAME + SPACE + EQUAL + SPACE;
    }
}
