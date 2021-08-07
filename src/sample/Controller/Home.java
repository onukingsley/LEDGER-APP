package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import sample.Main;

import java.io.IOException;

public class Home {
    @FXML
    void cancel(MouseEvent event) {

    }

    @FXML
    void login(MouseEvent event) throws IOException {
        Main.login();
    }

    @FXML
    void signup(MouseEvent event) throws IOException {
        Main.signup();
    }
}
