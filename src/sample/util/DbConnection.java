package sample.util;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.CustomerData.CustomerData;

import java.sql.*;

public class DbConnection {
    private static String sql = null;
    private ResultSet rs = null;
    private static PreparedStatement prepStmt= null;
    private static final String url = "jdbc:mysql://localhost/ledger app";
    private static final String username = "root";
    private static final String password = "";
    private static Connection conn = null;



    static {
        try {
            conn = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        return conn;
    }

    public boolean Insert(String[] fieldArry,String[] valueArry,String table) throws SQLException {
        String field = "";
        String valueString = "";
        for(int i=0; i< fieldArry.length; i++){
            field = field +  "," + fieldArry[i];
            valueString = valueString + "," + "?";
        }
        field = field.replaceFirst(","," ");
        valueString = valueString.replaceFirst(","," ");
        field = field.trim();
        valueString = valueString.trim();
      /*  System.out.println(field);
        System.out.println(valueString);*/

        sql = "INSERT INTO " + table + "(" + field +")" + " values(" + valueString +")";

        prepStmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        System.out.println("Statement");
        for(int i =0; i< valueArry.length; i++){
            int c = 1+i;
            prepStmt.setString(c,valueArry[i]);
        }
        prepStmt.executeUpdate();
        return true;
    }


/*    public boolean Insert(String[] fieldArray, String[] valueArray, String table ) throws SQLException {
        String field = "";
        String value = "";

        for (String i : fieldArray){
            field = field + ","+ i;
            value = value + "," + "?";
        }
        field = field.replaceFirst(","," ");
        value = value.replaceFirst(",", " ");

       field =  field.trim();
        value = value.trim();

        sql = "INSERT INTO " + table + "(" + field +")" + " values(" + value +")";

        prepStmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        for (int i = 0 ; i< valueArray.length; i++){
           int j = i+1;
            prepStmt.setString(j,fieldArray[i]);
        }
        prepStmt.executeUpdate();
        return false;
    }*/


    public  ResultSet SelectAll (String username, String password, String table) throws SQLException {
        sql= "SELECT * FROM "+ table + " WHERE Username=? and Password=? ";

        prepStmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        prepStmt.setString(1,username);
        prepStmt.setString(2,password);

        rs = prepStmt.executeQuery();

        return rs;
    }

    public ResultSet selectName(String username , String table) throws SQLException {
        sql = "SELECT * FROM "+ table+ " WHERE Username=?";
        prepStmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        prepStmt.setString(1, username);
        rs = prepStmt.executeQuery();
        return rs;
    }

    public ResultSet SelectEVERY(String table) throws SQLException {
        sql = "SELECT * FROM "+table;
        return rs = conn.prepareStatement(sql).executeQuery();

    }
}
