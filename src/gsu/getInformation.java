package gsu;

import java.sql.*;
import java.util.ArrayList;


public class getInformation {
    Connection connection;
    Statement statement;

    public getInformation(Connection connection) throws SQLException {
        this.connection = connection;
        this.statement = connection.createStatement();
    }

    public String getDetailedInfo(int orderID) throws SQLException {
        String query = "select o.date,p.name, op.count, p.price\n" +
                "from orders o\n" +
                "inner join orders_products op on o.id = op.order_id\n" +
                "inner join products p on op.product_id = p.id\n" +
                "where o.id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(orderID));
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<String> result = new ArrayList<>();

        while (resultSet.next()){
            String date = resultSet.getString(1);
            String name = resultSet.getString(2);
            String count = resultSet.getString(3);
            String price = resultSet.getString(4);

            result.add(date + "; " + name + "; " + count + "; " + price);

        }

        return result.toString();
    }

    public String getIDWithMaxPriceAndCount(int maxPrice, int count) throws SQLException {
        String query = "select o.id\n" +
                "from orders o\n" +
                "inner join orders_products op on o.id = op.order_id\n" +
                "inner join products p on op.product_id = p.id\n" +
                "group by o.id\n" +
                "having sum(price) <= ? and sum(count) = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(maxPrice));
        preparedStatement.setString(2, String.valueOf(count));
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<String> result = new ArrayList<>();

        while (resultSet.next()){
            String id = resultSet.getString(1);

            result.add(id);

        }

        return result.toString();
    }

    public String getOrderIDContainsProductID(int productID) throws SQLException {
        String query = "select op.order_id\n" +
                "from orders_products op\n" +
                "where op.product_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(productID));
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<String> result = new ArrayList<>();

        while (resultSet.next()){
            String id = resultSet.getString(1);

            result.add(id);

        }

        return result.toString();
    }

    public String getOrderIDTodayAndNotContainsProductID(int productID) throws SQLException {
        String query = "select distinct o.id\n" +
                "from orders o\n" +
                "where o.id not in (select distinct op.order_id from orders_products op where product_id = ?)\n" +
                "and date = CURDATE()";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(productID));
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<String> result = new ArrayList<>();

        while (resultSet.next()){
            String id = resultSet.getString(1);

            result.add(id);

        }

        return result.toString();
    }

    public String getProductsOrderedToday() throws SQLException {
        String query = "select p.id, p.name, op.count\n" +
                "from products p\n" +
                "inner join orders_products op on p.id = op.product_id\n" +
                "inner join orders o on op.order_id = o.id\n" +
                "where o.date = CURDATE()";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<String> result = new ArrayList<>();

        while (resultSet.next()){
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String count = resultSet.getString(3);

            result.add(id + "; " + name + "; " + count);

        }

        return result.toString();
    }

    public String getOrderIDWithProductIDAndCountThisProduct(int productID, int count) throws SQLException {
        String query = "select o.id\n" +
                "from orders o\n" +
                "inner join orders_products op on o.id = op.order_id\n" +
                "inner join products p on op.product_id = p.id\n" +
                "where product_id = ? and count = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(productID));
        preparedStatement.setString(2, String.valueOf(count));
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<String> result = new ArrayList<>();

        while (resultSet.next()){
            String id = resultSet.getString(1);

            result.add(id);

        }

        return result.toString();
    }


}
