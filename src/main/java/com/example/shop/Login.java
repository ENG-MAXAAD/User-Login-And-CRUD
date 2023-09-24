package com.example.shop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.TransferMode;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.*;

public class Login {


    @FXML
    private TextField txtusername;

    @FXML
    private Label lblOutput;

    @FXML
    private PasswordField txtpassword;


    @FXML
    void loginHandller(ActionEvent event) throws SQLException, IOException {
        if (txtusername.getText().equals("")|| txtpassword.getText().equals("")){
            lblOutput.setText("Please Fill empty Blanks");
        }
        else {
            String userr = txtusername.getText();
            String pass = txtpassword.getText();

            Connection connection = new Connection("select * from user where username = '"+userr+"' and userPassword = '"+pass+"'  ");

//            ResultSet rs = st.executeQuery("select * from user where username = '"+userr+"' and userPassword = '"+pass+"'  ");

            if (Connection.resultSet.next()){
                Dashboard.user_name = Connection.resultSet.getString("username");
                Dashboard.roll_Type = Connection.resultSet.getString("userTpye");
//                Pane root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage LoginStage = new Stage();
                LoginStage.setScene(scene);
                LoginStage.setTitle("Mini Shop!");
                LoginStage.initStyle(StageStyle.TRANSPARENT);
                LoginStage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();

            }else {
                lblOutput.setText("invalid username or password!");
            }


        }

    }

}
