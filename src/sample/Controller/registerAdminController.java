package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.Model.adminModel;

import java.sql.SQLException;

public class registerAdminController {
    adminModel signup = new adminModel() ;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtusername;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtphone;

    @FXML
    private TextField txtpassword;

    public String getTxtname() {
        return txtname.getText();
    }

    public String getTxtusername() {
        return txtusername.getText();
    }

    public String getTxtemail() {
        return txtemail.getText();
    }

    public String getTxtphone() {
        return txtphone.getText();
    }

    public String getTxtpassword() {
        return txtpassword.getText();
    }

    @FXML
    void register(MouseEvent event) throws SQLException {
        System.out.println(getTxtemail());
        signup.InsertUser(getTxtname(),getTxtpassword(),getTxtusername(),getTxtemail(),getTxtphone(),"admin");
        txtemail.setText(""); txtname.setText(""); txtpassword.setText(""); txtphone.setText(""); txtusername.setText("");
    }
    @FXML
    void gotologin(MouseEvent event) {

    }



}
