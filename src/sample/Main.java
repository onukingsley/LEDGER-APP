package sample;
import java.sql.ResultSet;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Controller.Login;
import sample.Controller.profile;
import sample.util.Db;

import java.io.IOException;
import java.sql.SQLException;


public class Main extends Application {

    private static BorderPane mainlayout;

    private static Stage primaryStage;

    @Override
    public void start(Stage PrimaryStage) throws Exception {

        primaryStage = PrimaryStage;
        primaryStage.setTitle("XEND LEDGER");
        primaryStage.getIcons().add(new Image("/sample/Images/xing_200px.png"));
        home(PrimaryStage);


    }

    /*load home view*/
    public static void home(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("View/Home.fxml"));
        mainlayout = loader.load();
        Scene scene = new Scene(mainlayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /*load sign up*/
    public static void signup() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("View/RegisterAdmin.fxml"));
        mainlayout.setCenter(loader.load());

    }

    public static void login() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("View/Login.fxml"));
        mainlayout.setCenter(loader.load());

    }
    /*Admin profile*/
    public static void profile() throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("View/Profile.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.show();



    }

    /*add costumer1*/
    public static void addcostumer() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("View/AddCustomer.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initOwner(primaryStage);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.showAndWait();

    }
    public static void review() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("View/Review customer.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initOwner(primaryStage);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.showAndWait();

    }
    public static void main(String[] args) {
        launch(args);
    }

}