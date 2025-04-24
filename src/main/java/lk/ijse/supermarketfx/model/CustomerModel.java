package lk.ijse.supermarketfx.model;

import lk.ijse.supermarketfx.db.DBConnection;
import lk.ijse.supermarketfx.dto.CustomerDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * --------------------------------------------
 * Author: Shamodha Sahan
 * GitHub: https://github.com/shamodhas
 * Website: https://shamodha.com
 * --------------------------------------------
 * Created: 4/24/2025 9:31 AM
 * Project: SupermarketFX
 * --------------------------------------------
 **/

public class CustomerModel {
    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
// insert into customer values ('C001','Bob','1111111111111','bob@gmail.com','077777777')
// insert into customer values (?,?,?,?,?)
// set ? marks for column count Ex: 4 col -> (?,?,?,?)
        String sql = "insert into customer values (?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(sql);

// set values for ? marks
        pst.setString(1, customerDTO.getCustomerId());
        pst.setString(2, customerDTO.getName());
        pst.setString(3, customerDTO.getNic());
        pst.setString(4, customerDTO.getEmail());
        pst.setString(5, customerDTO.getPhone());

        int i = pst.executeUpdate();
        boolean isSave = i > 0;
        return isSave;
    }
}
