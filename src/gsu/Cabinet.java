package gsu;

import java.sql.*;
import java.util.ArrayList;

public class Cabinet extends Factory{

    private static Cabinet instance;

    public static Cabinet getInstance(){
        if (instance == null){
            instance = new Cabinet();
        }
        return instance;
    }

    @Override
    public void addData(String data) throws SQLException {
        String[] fields = data.split(";");
        if (fields.length != 5){
            System.out.println("Error! Please enter correct data in format 'id;name;floor;workplaces");
        } else {
            String query = "insert into cabinets(id, name, description, floor, workplaces) values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = super.connection.prepareStatement(query);
            for (int i = 1; i<6; i++){
                preparedStatement.setString(i, fields[i-1]);
            }
            try {
                preparedStatement.executeUpdate();
                System.out.println(data + " added in table cabinets");
            } catch (SQLException exception ){
                System.out.println(exception);
            }
        }
    }

    @Override
    public void deleteData(int id){
        try {
            PreparedStatement preparedStatement = super.connection
                    .prepareStatement("delete from cabinets where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Cabinet with ID " + id + " was deleted");
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    @Override
    public String getData() throws SQLException {
        String query_ = "select * from cabinets";
        PreparedStatement preparedStatement = super.connection.prepareStatement(query_);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<String> result = new ArrayList<>();
        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String description = resultSet.getString(3);
            String floor = resultSet.getString(4);
            String workplaces = resultSet.getString(5);

            result.add(id + "; " + name + "; " + description + "; " + floor + "; " + workplaces);
        }
        System.out.println(result);
        return result.toString();
    }

    @Override
    public void createTable() throws SQLException {
        Statement statement = super.connection.createStatement();
        statement.executeUpdate("create table if not exists cabinets(\n" +
                "    id int auto_increment,\n" +
                "    name varchar(20) not null,\n" +
                "    description varchar(255),\n" +
                "    floor int not null,\n" +
                "    workplaces int,\n" +
                "    primary key (id)\n" +
                ");");
        System.out.println("Table cabinets was created");
    }

}

