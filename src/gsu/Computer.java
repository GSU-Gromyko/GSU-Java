package gsu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Computer extends Factory{

    private static Computer instance;
    protected Log log = new Log();

    public static Computer getInstance(){
        if (instance == null){
            instance = new Computer();
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
            String query = "insert into computers(id, name, description, CPU, GPU, RAM) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = super.connection.prepareStatement(query);
            for (int i = 1; i<7; i++){
                preparedStatement.setString(i, fields[i-1]);
            }
            try {
                preparedStatement.executeUpdate();
                System.out.println(data + " added in table computer");
                log.writeAction("ADD " + data);
            } catch (SQLException exception ){
                System.out.println(exception);
            }
        }
    }

    @Override
    public void deleteData(int id) {
        try {
            PreparedStatement preparedStatement = super.connection
                    .prepareStatement("delete from computers where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Computer with ID " + id + " was deleted");
            log.writeAction("DELETE " + id);
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    @Override
    public String getData() throws SQLException {
        String query_ = "select cabinets.name, cabinets.workplaces, c.name, CPU, GPU, RAM, p.name, activation_date\n" +
                "from cabinets\n" +
                "inner join computers_cabinets cc on cabinets.id = cc.id_cabinet\n" +
                "inner join computers c on cc.id_computer = c.id\n" +
                "inner join computers_programs cp on c.id = cp.id_computer\n" +
                "inner join programs p on cp.id_program = p.id";
        PreparedStatement preparedStatement = super.connection.prepareStatement(query_);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<String> result = new ArrayList<>();
        while (resultSet.next()) {
            String cabinetName = resultSet.getString(1);
            String workplaces = resultSet.getString(2);
            String computerName = resultSet.getString(3);
            String cpu = resultSet.getString(4);
            String gpu = resultSet.getString(5);
            String ram = resultSet.getString(6);
            String programName = resultSet.getString(7);
            String activationDate = resultSet.getString(8);


            result.add(cabinetName + "; " + workplaces + "; " + computerName + "; " + cpu + "; " + gpu + "; " + ram +
                    "; " + programName + "; " + activationDate);
        }
        System.out.println(result);
        log.writeAction("GET computers info");
        return result.toString();
    }

    @Override
    public void createTable() throws SQLException {
        Statement statement = super.connection.createStatement();
        statement.executeUpdate("create table if not exists computers(\n" +
                "    id int auto_increment,\n" +
                "    name varchar(30) not null unique ,\n" +
                "    description varchar(255),\n" +
                "    CPU varchar(255),\n" +
                "    GPU varchar(255),\n" +
                "    RAM varchar(255),\n" +
                "    primary key (id)\n" +
                ");");
        System.out.println("Table programs was created");
    }

    public void createLinkTableToCabinets() throws SQLException {
        Statement statement = super.connection.createStatement();
        statement.executeUpdate("create table if not exists computers_cabinets(\n" +
                "    id_computer int,\n" +
                "    id_cabinet int,\n" +
                "    primary key (id_computer, id_cabinet),\n" +
                "    foreign key (id_computer) references computers(id),\n" +
                "    foreign key (id_cabinet) references cabinets(id)\n" +
                ");");
        System.out.println("Table computers_cabinets was created");
    }

    public void createLinkTableToPrograms() throws SQLException {
        Statement statement = super.connection.createStatement();
        statement.executeUpdate("create table if not exists computers_programs(\n" +
                "  id_computer int,\n" +
                "  id_program int,\n" +
                "  primary key (id_computer, id_program),\n" +
                "  foreign key (id_computer) references computers(id),\n" +
                "  foreign key (id_program) references programs(id)\n" +
                ");");
        System.out.println("Table computers_programs was created");
    }

    public void addInCabinet(String data) throws SQLException {
        String[] fields = data.split(";");
        if (fields.length != 2){
            System.out.println("Error! Please enter correct data in format 'computer_id, cabinet_id'");
        } else {
            String query = "insert into computers_cabinets(id_computer, id_cabinet) values (?, ?)";
            PreparedStatement preparedStatement = super.connection.prepareStatement(query);
            for (int i = 1; i<=2; i++){
                preparedStatement.setString(i, fields[i-1]);
            }
            try {
                preparedStatement.executeUpdate();
                System.out.println(data + " added in table computer_cabinets");
            } catch (SQLException exception ){
                System.out.println(exception);
            }
        }
    }

    public void installProgram(String data) throws SQLException {
        String[] fields = data.split(";");
        if (fields.length != 2){
            System.out.println("Error! Please enter correct data in format 'computer_id, program_id'");
        } else {
            String query = "insert into computers_programs(id_computer, id_program) values (?, ?)";
            PreparedStatement preparedStatement = super.connection.prepareStatement(query);
            for (int i = 1; i<=2; i++){
                preparedStatement.setString(i, fields[i-1]);
            }
            try {
                preparedStatement.executeUpdate();
                System.out.println(data + " added in table computer_programs");
            } catch (SQLException exception ){
                System.out.println(exception);
            }
        }
    }

}
