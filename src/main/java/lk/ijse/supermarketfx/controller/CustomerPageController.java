package lk.ijse.supermarketfx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.supermarketfx.dto.CustomerDTO;
import lk.ijse.supermarketfx.model.CustomerModel;

import java.net.URL;
import java.util.ResourceBundle;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // C001
        lblId.setText("C001");
    }

    public void btnCustomerSaveOnAction(ActionEvent actionEvent) {
        String name = txtName.getText();
        String nic = txtNic.getText();
        String email = txtEmail.getText();
        String phone = txtPhone.getText();
        String customerId = lblId.getText();

        // DTO - Data transfer object
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.

        // Create dto object wrap data to single unit

//        CustomerModel.saveCustomer();
        CustomerModel customerModel = new CustomerModel();
        customerModel.saveCustomer(name,customerId,nic,email,phone);
    }

}
