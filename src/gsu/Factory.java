package gsu;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class Factory {

    protected Connection connection = new ConnectionDB().get_connection();

    public void addData(String data) throws SQLException {

    }

    public void editData(int id, String data) throws SQLException {
        deleteData(id);
        addData(data);
    }

    public void deleteData(int id) throws SQLException {

    }

    public String getData() throws SQLException {
        return "";
    }

    public void createTable() throws SQLException {

    }

}
