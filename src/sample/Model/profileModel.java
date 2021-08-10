package sample.Model;

import javafx.scene.control.Label;
import sample.app;


import java.sql.SQLException;

public class profileModel extends app {

    public void displayName(String username, String table, Label header ,Label firstletter) throws SQLException {
        rs = super.selectName(username, table);
        while (rs.next()){
            header.setText("WELCOME "+rs.getString("Name").toUpperCase());
            firstletter.setText(String.valueOf(rs.getString("Name").charAt(0)).toUpperCase());
        }
    }

}
