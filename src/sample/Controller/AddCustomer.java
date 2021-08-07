package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.Model.customerModel;

import java.sql.SQLException;

public class AddCustomer {
    customerModel cm = new customerModel();

    @FXML
    private TextField txtfullname;

    @FXML
    private TextField txtusername;

    @FXML
    private TextArea txtaddress;

    @FXML
    private TextField txtphoneno;

    @FXML
    private TextField txtemail;

    public String getTxtfullname() {
        return txtfullname.getText();
    }

    public String getTxtusername() {
        return txtusername.getText();
    }

    String getTxtaddress() {
        return txtaddress.getText();
    }

    public String getTxtphoneno() {
        return txtphoneno.getText();
    }

    public String getTxtemail() {
        return txtemail.getText();
    }

    @FXML
    void resistercostumer(MouseEvent event) throws SQLException {
        cm.insertcustomer(getTxtfullname(),getTxtusername(),getTxtaddress(),getTxtphoneno(),getTxtemail());
        txtfullname.setText("");txtaddress.setText("");txtusername.setText("");txtemail.setText("");txtphoneno.setText("");
    }
}
