package hr.algebra.dal.sql;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import javax.sql.DataSource;

public class DataSourceSingleton {

    private static final String SERVER_NAME = "localhost";
    private static final String DATABASE_NAME = "STUDENTS";
    private static final String USER = "sa";
    private static final String PASSWORD = "Marvel247";

    private static DataSource createInstance() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setServerName(SERVER_NAME);
        dataSource.setDatabaseName(DATABASE_NAME);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

    private DataSourceSingleton() {
    }

    private static DataSource instance;

    public static DataSource getInstance() {
        if (instance == null) {
            instance = createInstance();
        }
        return instance;
    }
}
