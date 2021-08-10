package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.CustomerData.AdminData;
import sample.CustomerData.CustomerData;
import sample.app;

import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ReviewCustomer extends app implements Initializable {

    @FXML
    private TableView<AdminData> admintable;

    @FXML
    private TableView<CustomerData> customerTable;

    @FXML
    private TableColumn<CustomerData, Integer> usercolumnID;

    @FXML
    private TableColumn<CustomerData, String> usercolumnname;

    @FXML
    private TableColumn<CustomerData, String> usercolumnusername;

    @FXML
    private TableColumn<CustomerData, String> usercolumnaddress;

    @FXML
    private TableColumn<CustomerData, String> usercolumnphone;

    @FXML
    private TableColumn<CustomerData, String> usercolumnemail;

    @FXML
    private TableColumn<CustomerData, String> usercolumnreg;

    @FXML
    private TableColumn<AdminData, Integer> admincolumnID;

    @FXML
    private TableColumn<AdminData, String> admincolumnname;

    @FXML
    private TableColumn<AdminData, String> admincolumnusername;

    @FXML
    private TableColumn<AdminData, String> admincolumnemail;

    @FXML
    private TableColumn<AdminData, String> admincolumnphone;

    @FXML
    private TableColumn<AdminData, String> admincolumnreg;

    @FXML
    void LoadAdmin(MouseEvent event) {
        try{
            ObservableList<CustomerData> data;
            data = FXCollections.observableArrayList();
            rs = super.SelectEVERY("customer");
            while (rs.next()){
                data.add(new CustomerData(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
            }

            customerTable.setItems(data);
            System.out.println("hello");
        }
        catch (Exception err){
            System.out.println(Arrays.toString(err.getStackTrace()));
        }


    }

    @FXML
    void loadCustomer(MouseEvent event) throws SQLException {
        ObservableList<AdminData> data;
        data = FXCollections.observableArrayList();
        rs = super.SelectEVERY("admin");
        while(rs.next()){
            data.add(new AdminData(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
        }
        admintable.setItems(data);
        System.out.println("hello");

    }
    @FXML
    void closereview(MouseEvent event){
        Stage stage = (Stage)((Node)(event).getSource()).getScene().getWindow();
        stage.close();

       /* Main.profile();*/



       /* profile controller = loader.getController();

        controller.setHeaderTxt(login.getTxtloginusername(), "admin");

        stage.setScene(new Scene(root));
        stage.show();*/



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usercolumnID.setCellValueFactory(new PropertyValueFactory<CustomerData,Integer>("id"));
        usercolumnname.setCellValueFactory(new PropertyValueFactory<CustomerData, String>("fullname"));
        usercolumnusername.setCellValueFactory(new PropertyValueFactory<CustomerData, String>("username"));
        usercolumnaddress.setCellValueFactory(new PropertyValueFactory<CustomerData, String>("address"));
        usercolumnphone.setCellValueFactory(new PropertyValueFactory<CustomerData,String>("phoneNo"));
        usercolumnemail.setCellValueFactory(new PropertyValueFactory<CustomerData,String>("email"));
        admincolumnID.setCellValueFactory(new PropertyValueFactory<AdminData,Integer>("id"));
        admincolumnname.setCellValueFactory(new PropertyValueFactory<AdminData,String>("name"));
        admincolumnusername.setCellValueFactory(new PropertyValueFactory<AdminData,String>("username"));
        admincolumnemail.setCellValueFactory(new PropertyValueFactory<AdminData,String>("email"));
        admincolumnphone.setCellValueFactory(new PropertyValueFactory<AdminData,String>("mobileNo"));
        admincolumnreg.setCellValueFactory(new PropertyValueFactory<AdminData,String>("datereg"));

    }
}