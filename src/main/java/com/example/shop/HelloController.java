package com.example.shop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.w3c.dom.events.MouseEvent;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Label lblprintUser;

    @FXML
    private Label lblPrintUserType;

      //TABLEVIEW
      @FXML
    private TableView<Customers> customerTableview;

    @FXML
    private TableColumn<Customers, Integer> cusID;

    @FXML
    private TableColumn<Customers, String> cusNAME;

    @FXML
    private TableColumn<Customers, String> cusGENDER;

    @FXML
    private TableColumn<Customers, Integer> cusMOBILE;

    @FXML
    private TableColumn<Customers, String> cusADDRESS;

    @FXML
    private TableColumn<Customers, Date> DATE;
    ObservableList<Customers> list = FXCollections.observableArrayList();
    @FXML
    private TextField txtcusNAME;

    @FXML
    private TextField txtcusgender;

    @FXML
    private TextField txtsearch;

    @FXML
    private TextField txtcusmobile;

    @FXML
    private TextField txtcusaddress;

    @FXML
    private TextField txtdate;

    public HelloController() throws SQLException {
    }

    @FXML
    void btnclear(ActionEvent event) {

    }

    @FXML
    void btndelete(ActionEvent event) {
        try{
            int myIndex = customerTableview.getSelectionModel().getFocusedIndex();
            int id = Integer.parseInt(String.valueOf(customerTableview.getItems().get(myIndex).getId()));
            PreparedStatement ps = Connection.connection.prepareStatement("delete from customers where id = ?");
            ps.setInt(1,id);
            ps.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("SUCESSFULY Deleted !");
            alert.show();
            ClearData();
            BindTableView();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    void btnrefresh(ActionEvent event) {

    }

    @FXML
    void btnsave(ActionEvent event) throws SQLException {
        try{
            if(txtcusNAME.getText().isEmpty() || txtcusgender.getText().isEmpty() || txtcusmobile.getText().isEmpty() || txtcusaddress.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("field each of can`t blanks ! ");
                alert.show();
            }
            else {
                String fullname = txtcusNAME.getText();
                String gender = txtcusgender.getText();
                int mobile = Integer.parseInt(txtcusmobile.getText());
                String address = txtcusaddress.getText();
                PreparedStatement ps = Connection.connection.prepareStatement("insert into customers values (default , ? , ? ,? , default , ?)");
                ps.setString(1,fullname);
                ps.setString(2,gender);
                ps.setString(3,address);
                ps.setInt(4,mobile);
                ps.executeUpdate();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("SUCESSFULY SAVED!");
                alert.show();
                ClearData();
                BindTableView();
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    void btnsearch(ActionEvent event) {

    }

    @FXML
    void btnupdate(ActionEvent event) {
        try{
            if(txtcusNAME.getText().isEmpty() || txtcusgender.getText().isEmpty() || txtcusmobile.getText().isEmpty() || txtcusaddress.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("field each of can`t blanks ! ");
                alert.show();
            }
            else {
                int myIndex = customerTableview.getSelectionModel().getFocusedIndex();
                int id = Integer.parseInt(String.valueOf(customerTableview.getItems().get(myIndex).getId()));
                String fullname = txtcusNAME.getText();
                String Gender = txtdate.getText();
                int mobile = Integer.parseInt(txtcusmobile.getText());
                String address = txtcusaddress.getText();
                Date date = (Date) customerTableview.getItems().get(myIndex).getDate();
                PreparedStatement ps = Connection.connection.prepareStatement("update customers set cusname = ? , cusgender = ? , cusaddress = ? , date = ? , cusmobile = ?   where id = ? ");
                ps.setString(1,fullname);
                ps.setString(2,Gender);
                ps.setInt(3,mobile);
                ps.setString(4,address);
                ps.setInt(5,id);
                ps.setDate(6,date);
                ps.executeUpdate();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("SUCESSFULY Updated!");
                alert.show();
                ClearData();
                BindTableView();
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    void getDate(MouseEvent event) {

    }

    void BindTableView() throws SQLException {
        try{
            customerTableview.getItems().clear();
            customerTableview.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            cusID.setCellValueFactory(new PropertyValueFactory<Customers,Integer>("id"));
            cusNAME.setCellValueFactory(new PropertyValueFactory<Customers, String >("cusname"));
            cusGENDER.setCellValueFactory(new PropertyValueFactory<Customers, String >("cudgender"));
            cusADDRESS.setCellValueFactory(new PropertyValueFactory<Customers, String>("address"));
            DATE.setCellValueFactory(new PropertyValueFactory<Customers, Date>("date"));
            cusMOBILE.setCellValueFactory(new PropertyValueFactory<Customers, Integer>("mobile"));


            Connection connection = new Connection("select * from customers ");

            while (Connection.resultSet.next()){
                list.addAll(new Customers(Connection.resultSet.getInt("id"),
                        Connection.resultSet.getString("cusname"),
                        Connection.resultSet.getString("cusgender"),
                        Connection.resultSet.getString("cusaddress"),
                        Connection.resultSet.getDate("date"),
                        Connection.resultSet.getInt("cusmobile") ));

            }

            customerTableview.setItems(list);

    }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            BindTableView();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    void ClearData(){
        txtcusNAME.clear();
        txtcusgender.clear();
        txtcusmobile.clear();
        txtcusaddress.clear();
        txtsearch.clear();
    }
    @FXML
    void getdata(MouseEvent event) {

    }

    public void getdata(javafx.scene.input.MouseEvent mouseEvent) {

        Customers customers = customerTableview.getSelectionModel().getSelectedItem();
        txtcusNAME.setText(customers.getCusname());
        txtcusgender.setText(customers.getCudgender());
        txtcusaddress.setText(customers.getAddress());
        txtcusmobile.setText(String.valueOf(customers.getMobile()));
    }
}


