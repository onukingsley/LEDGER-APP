package sample.Model;

import sample.Controller.Login;
import sample.app;

import java.sql.SQLException;

public class customerModel extends app {
    private String fullname;
    private String username;
    private String address;
    private String phoneNo;
    private String email;

    public customerModel(){}

    public String getFullname() {
        return fullname;
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public boolean insertcustomer(String fullname, String username, String Address, String phoneNo, String Email) throws SQLException {
        rs = super.selectName(username,"customer");

        while(rs.next()){
            if (username.equals(rs.getString("UserName"))){
                System.out.println("please try another username");
                Login.alert("null","null", "please  try another username");
                return false;
            }

        }return !super.Insertcustomer(fullname,username,Address,phoneNo,Email,"customer");


    }

}
