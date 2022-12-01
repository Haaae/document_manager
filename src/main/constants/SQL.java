package main.constants;

public final class SQL {

    private  SQL() {}

    public static final class Info {
        public static final String JDBC_URL = "jdbc:mysql://192.168.56.103:3308/document_manager";
        public static final String SQL_ID = "mkim";
        public static final String SQL_PASSWORD = "5557";

        private Info() {}
    }

    public static final class Query {
        public static final String READING_REPOSITORY_LIST = "SELECT name FROM Repository";
    }
}