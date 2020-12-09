package gsu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Program extends Factory{

    private static Program instance;

    public static Program getInstance(){
        if (instance == null){
            instance = new Program();
        }
        return instance;
    }

    @Override
    public void addData(String data) throws SQLException {
        String[] fields = data.split(";");
        if (fields.length != 6){
            System.out.println("Error! Please enter correct data in format 'id;name;description;activation_key;" +
                    "activation_date;license_duration_days");
        } else {
            String query = "insert into programs(id, name, description, activation_key, activation_date, " +
                    "license_duration_days) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = super.connection.prepareStatement(query);
            for (int i = 1; i<7; i++){
                preparedStatement.setString(i, fields[i-1]);
            }
            try {
                preparedStatement.executeUpdate();
                System.out.println(data + " added in table program");
            } catch (SQLException exception ){
                System.out.println(exception);
            }
        }
    }

    @Override
    public void deleteData(int id) {
        try {
            PreparedStatement preparedStatement = super.connection
                    .prepareStatement("delete from programs where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Program with ID " + id + " was deleted");
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    @Override
    public String getData() throws SQLException {
        String query_ = "select * from programs";
        PreparedStatement preparedStatement = super.connection.prepareStatement(query_);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<String> result = new ArrayList<>();
        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String description = resultSet.getString(3);
            String activation_key = resultSet.getString(4);
            String activation_date = resultSet.getString(5);
            String license_duration_days = resultSet.getString(6);

            result.add(id + "; " + name + "; " + description + "; " + activation_key + "; " + activation_date + ";"
                    + license_duration_days);
        }
        System.out.println(result);
        return result.toString();
    }

    @Override
    public void createTable() throws SQLException {
        Statement statement = super.connection.createStatement();
        statement.executeUpdate("create table if not exists programs(\n" +
                "    id int auto_increment,\n" +
                "    name varchar(255) not null,\n" +
                "    description varchar(255),\n" +
                "    activation_key varchar(100) not null,\n" +
                "    activation_date date default null,\n" +
                "    license_duration_days int not null,\n" +
                "    primary key (id)\n" +
                ");");
        System.out.println("Table programs was created");
    }
}
