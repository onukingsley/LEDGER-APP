package sample.util;

import java.sql.*;


public class Db {

    private  static Connection con = null;
    private static PreparedStatement prepStmt = null;
    private static ResultSet rs =null;
    private String sql = "";



    static
    {
        String db = "ddl_app";
        String url = "jdbc:mysql://localhost/" + db + "?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String pass = "";
        try {
            con = DriverManager.getConnection(url, user, pass);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return con;

    }
    public boolean insert(String[] fieldArry,String[] valueArry,String table) throws SQLException {
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

        prepStmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        System.out.println("Statement");
        for(int i =0; i< valueArry.length; i++){
            int c = 1+i;
            prepStmt.setString(c,valueArry[i]);
        }
        return true;
    }

    public boolean update(String[] fieldArry, String[] valueArry,String table) throws SQLException {
        String field = "";
        String valueString = "";
        for(int i=0; i< fieldArry.length; i++){
            field = field +  "," + fieldArry[i];
        }
        field = field.replaceFirst(","," ");
        field = field.trim();

       sql = "UPDATE " + table + " set " + field +" WHERE id =?";

       prepStmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
               ResultSet.CONCUR_READ_ONLY);

        for(int i =0; i< valueArry.length; i++){
            int c = 1+i;
            if(i == valueArry.length-1){
                int id = Integer.parseInt(valueArry[i]);
                prepStmt.setInt(c,id);
            }
            prepStmt.setString(c,valueArry[i]);
        }
        prepStmt.executeUpdate();
      return true;

    }

    public  ResultSet selectAll(String table) throws SQLException {
         sql = "SELECT * FROM " + table;
         prepStmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
                 ResultSet.CONCUR_READ_ONLY);
         rs = prepStmt.executeQuery();
         return rs;
    }

    public  ResultSet selectAll(String table, int id) throws SQLException {
        sql = "SELECT * FROM " + table + " WHERE id=?";
        prepStmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        prepStmt.setInt(1,id);
        rs = prepStmt.executeQuery();
        return rs;
    }

    public static ResultSet selectFields(String table, String[] fields,
                                        int id) throws SQLException {
        StringBuffer cond = new StringBuffer();
        for(int i=0; i<fields.length; i++){
            cond.append(fields[i] + ",");
        }
       cond.deleteCharAt(cond.length() - 1);

        String sql = "SELECT " + cond + " FROM " + table + " WHERE id=?";
        prepStmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        prepStmt.setInt(1,id);
        rs = prepStmt.executeQuery();

        return rs;

    }


}
