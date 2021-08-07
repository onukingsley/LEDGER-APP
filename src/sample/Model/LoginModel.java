package sample.Model;

import sample.app;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel extends app {
    private String txtusername;
    private String txtpassword;


    public LoginModel(){}

    public String getTxtusername() {
        return txtusername;
    }

    public void setTxtusername(String txtusername) {
        this.txtusername = txtusername;
    }

    public String getTxtpassword() {
        return txtpassword;
    }

    public void setTxtpassword(String txtpassword) {
        this.txtpassword = txtpassword;
    }

    public ResultSet resultsetlogin(String Username, String Password, String table) throws SQLException {
        ResultSet rs;
        rs = super.SelectAll(Username,Password,table);

        return rs;
    }

    /*public String resultsetlogin(String Username, String Password, String table) throws SQLException {
        rs = super.SelectAll(Username,Password,table);
        if(!rs.next()) return "error";
        return "success";

    }*/
}



