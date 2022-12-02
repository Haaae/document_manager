package main.constants;

import javax.print.attribute.standard.MediaSize.NA;

public final class SQL {
    private static final String SELECT              = "SELECT";
    private static final String DELETE              = "DELETE";
    private static final String FROM                = "FROM";
    private static final String WHERE               = "WHERE";
    private static final String REPOSITORY          = "Repository";
    private static final String REPOSITORY_STATUS   = "Repository_status";
    private static final String DOCUMENT            = "Document";
    private static final String REPOSITORY_NAME     = "repository_name";
    private static final String NAME                = "name";
    private static final String NO                  = "no";
    private static final String EQUAL               = "=";
    private static final String SPACE               = " ";
    private static final String ALL                 = "*";

    private  SQL() {}

    public static final class Info {
        public static final String JDBC_URL = "jdbc:mysql://192.168.56.103:3308/document_manager";
        public static final String SQL_ID = "mkim";
        public static final String SQL_PASSWORD = "5557";

        private Info() {}
    }

    public static final class Query {
        public static final String READING_REPOSITORY_LIST =
                SELECT + SPACE + ALL + SPACE + FROM + SPACE + REPOSITORY;
        public static final String DELETE_REPOSITORY_WITHOUT_NAME =
                DELETE + SPACE + FROM + SPACE + REPOSITORY + SPACE + WHERE + SPACE + NAME + SPACE + EQUAL + SPACE;
        public static final String READING_STATUSES_IN_REPOSITORY_WITHOUT_NAME =
                SELECT + SPACE + ALL + SPACE + FROM + REPOSITORY_STATUS + WHERE + SPACE + REPOSITORY_NAME + SPACE + EQUAL + SPACE;
        public static final String READING_DOCUMENT_IN_REPOSITORY_STATUS =
                SELECT + SPACE + ALL + SPACE + FROM + DOCUMENT + WHERE + SPACE + REPOSITORY_NAME + SPACE + EQUAL + SPACE;
    }

    public static final class ColumnIndex {
        public static final int DOCUMENT_CONTENTS = 1;
        public static final int DOCUMENT_NAME = 2;
        public static final int DOCUMENT_REPOSITORY_NAME = 3;
        public static final int DOCUMENT_STATUS_NO = 4;
        public static final int STATUS_NO = 1;
        public static final int STATUS_MESSAGE = 2;
        public static final int STATUS_REPOSITORY_NAME = 3;
        public static final int REPOSITORY_NAME = 1;
    }
}
