package sample.Model;

import sample.app;

import java.sql.SQLException;

public class adminModel extends app {
    private String txtName;
    private String txtPassword;
    private String txtuserName;
    private String txtemail;
    private String txtmobile;

    public adminModel(){}

    public adminModel(String txtName, String txtPassword, String txtuserName, String txtemail, String txtmobile) {
        this.txtName = txtName;
        this.txtPassword = txtPassword;
        this.txtuserName = txtuserName;
        this.txtemail = txtemail;
        this.txtmobile = txtmobile;
    }

    public String getTxtName() {
        return txtName;
    }

    public String getTxtPassword() {
        return txtPassword;
    }

    public String getTxtuserName() {
        return txtuserName;
    }

    public String getTxtemail() {
        return txtemail;
    }

    public String getTxtmobile() {
        return txtmobile;
    }

    public void InsertUser(String Name, String Password, String Username, String Email, String MobileNo, String table){
        try {
            super.Insert(Name, Password, Username, Email, MobileNo, table);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
