package org.zerock.demo.db.beans;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() throws Exception {
        System.out.println("DB 연결 시도");
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##madang", "c##madang");
    }

    public static Connection getConnection(String ip, int port, String db, String user, String password) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection("jdbc:oracle:thin:@"+ ip + ":" + port + ":" + db + user +password);
    }
}
