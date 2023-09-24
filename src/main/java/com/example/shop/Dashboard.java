package com.example.shop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Dashboard implements Initializable {
    @FXML
    private BorderPane fxborderPane;
    public static String user_name ;
    public static String roll_Type ;
    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnCustomer;

    @FXML
    private Button btnProducts;

    @FXML
    private Button btnOrder;

    @FXML
    private Button btnPayment;

    @FXML
    private Button btnLogout;

    @FXML
    private Label lblprintUser;

    @FXML
    private Label lblPrintUserType;

    @FXML
    void OnCustomer(ActionEvent event) {
        System.out.println("you Clicked me! ");
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("hello-view");
        fxborderPane.setCenter(view);

    }

    @FXML
    void OnDashboard() {
        System.out.println("you Clicked me! ");
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("Home");
        fxborderPane.setCenter(view);
    }

    @FXML
    void OnLogout(ActionEvent event) {
        System.exit(1);
    }

    @FXML
    void OnOrder(ActionEvent event) {

    }

    @FXML
    void OnPayment(ActionEvent event) {

    }

    @FXML
    void OnProduct(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            getUserAuth();
            OnDashboard();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    void getUserAuth(){
        lblprintUser.setText(user_name);
        lblPrintUserType.setText(roll_Type);
    }
}

