package org.zerock.demo.db.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QueryBean {
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    public QueryBean() {
        conn = null;
        stmt = null;
        rs = null;
    }

    public static void getConnection() {
        try {
            conn = DBConnection.getConnection(); // DB 연결 시도
            if (conn != null) {
                stmt = conn.createStatement();
            } else {
                System.err.println("Database connection failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<String> getUserInfo() throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append(" SELECT ");
        sb.append("     U_ID, U_NAME, U_PHONE, U_GRADE, WRITE_TIME ");
        sb.append(" FROM ");
        sb.append("     USER_INFO_SAMPLE ");
        sb.append(" ORDER BY ");
        sb.append("     WRITE_TIME ");

        ArrayList<String> res = new ArrayList<>();

        try {
            rs = stmt.executeQuery(sb.toString());

            while (rs.next()) {
                res.add(rs.getString("U_ID"));
                res.add(rs.getString("U_NAME"));
                res.add(rs.getString("U_PHONE"));
                res.add(rs.getString("U_GRADE"));
                res.add(rs.getString("WRITE_TIME"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        System.out.println(sb.toString());
        return res;
    }
}
