package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.CustomerData.CustomerData;
import sample.util.DbConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class app extends DbConnection {
   public ResultSet rs = null;
    public boolean Insert(String Name, String Password, String Username, String Email, String MobileNo, String table) throws SQLException {
       return !super.Insert(new String[]{"Name", "Password", "Username", "Email", "MobileNo"},new String[]{Name, Password, Username, Email, MobileNo}, table);
    }


public ResultSet SelectAll(String username, String Password, String table) throws SQLException {

     rs = super.SelectAll(username, Password, table);
    if (rs != null){
        return rs;
    }
       else{ return null;}
    }

    public ResultSet selectName(String username, String table) throws SQLException {
       rs =  super.selectName(username,table);
      if (rs != null) return rs;
      return null;
    }

    public boolean Insertcustomer(String Name, String Username, String Address, String phoneNo, String Email, String table ) throws SQLException {
        return !super.Insert(new String[]{"FullName","UserName","Address","PhoneNo","Email"},new String[]{Name,Username,Address,phoneNo,Email},table);

    }

   /* public boolean loadcustomer() throws SQLException {
        ObservableList<CustomerData> data;
        data = FXCollections.observableArrayList();
        super.loaddata("customer");
        while (rs.next()){
           return data.add(new CustomerData(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
        }
        return false;*/
    }



