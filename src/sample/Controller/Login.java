package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Model.LoginModel;
import sample.Model.profileModel;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login{

    ResultSet rs = null;
    LoginModel login = new LoginModel();
    @FXML
    private TextField txtloginusername;

    @FXML
    private TextField txtloginpassword;



    public String getTxtloginusername() {
        return txtloginusername.getText();
    }

    public String getTxtloginpassword() {
        return txtloginpassword.getText();
    }


    @FXML
    void loginadmin(ActionEvent event)  {


        try {
            if (confirmUser().equals("success")){
                Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                stage.close();
                getHeader(stage);

            }
            else{
                txtloginusername.setText("");
                txtloginpassword.setText("");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
//alternative
        /*

        try {
            if (login.resultsetlogin(getTxtloginusername(), getTxtloginpassword(), "admin").equals("success")){
                Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                getHeader(stage);
            }
            else{
                alert(null, null, "Invalid login details");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        txtloginusername.setText("");
        txtloginpassword.setText("");
*/
    }
    public void alert(String title, String text, String context){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(text);
        alert.setContentText(context);
        alert.showAndWait();
    }
/*
    public String confirm(){

    }*/

    public String confirmUser() throws SQLException {
        rs = login.resultsetlogin(getTxtloginusername(),getTxtloginpassword(),"admin");

        if(!rs.next()) return "Error";
            return  "success";

    }

    public void getHeader(Stage stage) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/View/Profile.fxml"));
        Parent root = loader.load();

        profile controller = loader.getController();

        controller.setHeaderTxt(getTxtloginusername(), "admin");

        stage.setScene(new Scene(root));
        stage.show();
    }
}
