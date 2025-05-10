package lk.ijse.supermarketfx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.supermarketfx.dto.CustomerDTO;
import lk.ijse.supermarketfx.dto.tm.CustomerTM;
import lk.ijse.supermarketfx.model.CustomerModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

/**
 * --------------------------------------------
 * Author: Shamodha Sahan
 * GitHub: https://github.com/shamodhas
 * Website: https://shamodha.com
 * --------------------------------------------
 * Created: 4/3/2025 10:29 AM
 * Project: SupermarketFX
 * --------------------------------------------
 **/

public class CustomerPageController implements Initializable {
    public Label lblId;
    public TextField txtName;
    public TextField txtNic;
    public TextField txtEmail;
    public TextField txtPhone;

    private final CustomerModel customerModel = new CustomerModel();

    // TM - table model Ex: CustomerTM
    public TableView<CustomerTM> tblCustomer;

    public TableColumn<CustomerTM, String> colId;
    public TableColumn<CustomerTM, String> colName;
    public TableColumn<CustomerTM, String> colNic;
    public TableColumn<CustomerTM, String> colEmail;
    public TableColumn<CustomerTM, String> colPhone;

    private final String namePattern = "^[A-Za-z ]+$";
    private final String nicPattern = "^[0-9]{9}[vVxX]||[0-9]{12}$";
    private final String emailPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private final String phonePattern = "^(\\d+)||((\\d+\\.)(\\d){2})$";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // table column and tm class properties link
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        // C001
//        lblId.setText("C001");
        try {
            loadNextId();
            loadTableData();
        } catch (Exception e) {
            new Alert(
                    Alert.AlertType.ERROR, "Fail to load data..!"
            ).show();
        }
    }

    private void loadTableData() throws SQLException {
        // 1. Long code

        // Fetch data from DB
//        ArrayList<CustomerDTO> customerDTOArrayList = customerModel.getAllCustomer();
//
//        ObservableList<CustomerTM> list = FXCollections.observableArrayList();
//        for (CustomerDTO customerDTO : customerDTOArrayList){
//            CustomerTM customerTM = new CustomerTM(
//                    customerDTO.getCustomerId(),
//                    customerDTO.getName(),
//                    customerDTO.getNic(),
//                    customerDTO.getEmail(),
//                    customerDTO.getPhone()
//            );
//
//            list.add(customerTM);
//        }
//        tblCustomer.setItems(list);


        // 2. Short code

        // dto list -> tm list
//        List<CustomerTM> list = customerModel.getAllCustomer().stream().map(
//                customerDTO -> new CustomerTM(
//                        customerDTO.getCustomerId(),
//
//                        )
//        ).toList();

        tblCustomer.setItems(FXCollections.observableArrayList(
                customerModel.getAllCustomer().stream().map(customerDTO ->
                        new CustomerTM(
                                customerDTO.getCustomerId(),
                                customerDTO.getName(),
                                customerDTO.getNic(),
                                customerDTO.getEmail(),
                                customerDTO.getPhone()
                        )).toList()
        ));

    }

    private void loadNextId() throws SQLException {
        String nextId = customerModel.getNextId();
        lblId.setText(nextId);
    }

    public void btnCustomerSaveOnAction(ActionEvent actionEvent) {
        String name = txtName.getText();
        String nic = txtNic.getText();
        String email = txtEmail.getText();
        String phone = txtPhone.getText();
        String customerId = lblId.getText();

        // Shamodha sahan
//        String namePattern = "^[A-Za-z ]+$";
        // 1. Using Pattern object java.util.regex
//        Pattern compiledNamePattern = Pattern.compile(namePattern);
//        boolean isValidName = compiledNamePattern.matcher(name).matches();
//        System.out.println(name + " is valid:(1) " + isValidName);

        // 2. Using String class matches() method
//        boolean matches = name.matches(namePattern);
//        System.out.println(name + " is valid:(2) " + matches);


        // DTO - Data transfer object
        // Create dto object wrap data to single unit
        CustomerDTO customerDTO = new CustomerDTO(
                customerId,
                name,
                nic,
                email,
                phone
        );

        // setter method customerDTO.setNic("");

        // Call CustomerModel inside saveCustomer method
        // controller to model parse data using dto
//        CustomerModel customerModel = new CustomerModel();
//        try {
//            boolean isSave = customerModel.saveCustomer(customerDTO);
//            if (isSave) {
//                loadNextId();
//                loadTableData();
//
//                txtName.setText("");
//                txtNic.setText("");
//                txtEmail.setText("");
//                txtPhone.setText("");
//
//                new Alert(
//                        Alert.AlertType.INFORMATION, "Customer saved successfully..!"
//                ).show();
//            } else {
//                new Alert(
//                        Alert.AlertType.ERROR, "Fail to save customer..!"
//                ).show();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            new Alert(
//                    Alert.AlertType.ERROR, "Fail to save customer..!"
//            ).show();
//        }
//       Static method call using classname CustomerModel.saveCustomer();
    }

}
