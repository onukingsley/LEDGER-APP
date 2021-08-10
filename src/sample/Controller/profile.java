package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Main;
import sample.Model.profileModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class profile implements Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources) {
       /* try {
            setTxtnameheader("ADMIN");
            firstletter.setText("A");
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

    }

profileModel Pro = new profileModel();


    @FXML
    private Label firstletter;

    @FXML
    Label txtnameheader;



    public void setHeaderTxt(String username, String table) throws SQLException {
        profileModel profileModel = new profileModel();

        profileModel.displayName(username, table,txtnameheader, firstletter);
    }


    @FXML
    void showname(MouseEvent event)  {
        /*setTxtnameheader(log.username)*/

    }

    @FXML
    void Update(MouseEvent event) {


    }

    @FXML
    void add(MouseEvent event) throws IOException {
        Main.addcostumer();
    }

    @FXML
    void closeprofile(MouseEvent event) throws IOException {
        Stage stage = (Stage)((Node)(event.getSource())).getScene().getWindow();
        Main.home(stage);

    }

    @FXML
    void review(MouseEvent event) throws IOException {
        Stage stage = (Stage)((Node)(event.getSource())).getScene().getWindow();
        System.out.println(stage);
        Main.review();
    }


}

