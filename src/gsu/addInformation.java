package gsu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class addInformation {
    Connection connection;

    public addInformation(Connection connection){
        this.connection = connection;
    }

    public void fillTables() throws SQLException {

        Statement statement = connection.createStatement();

        try {
            statement.executeUpdate("insert into products(id, name, description, price) values (1, 'Карбонара', 'Бекон, сыры чеддер и пармезан, моцарелла,\n" +
                    "томаты черри, соус альфредо, красный лук, чеснок, итальянские травы', 12.90);");
            statement.executeUpdate("insert into products(id, name, description, price) values (2, 'Пепперони', 'Томатный соус, пикантная пепперони,\n" +
                    "моцарелла', 9.90);");
            statement.executeUpdate("insert into products(id, name, description, price) values (3, 'Мясная', 'Острая чоризо, томатный соус, цыпленок,\n" +
                    "пикантная пепперони, моцарелла, ветчина', 14.90);");
            statement.executeUpdate("insert into products(id, name, description, price) values (4, 'Классический молочный коктейль', 'Напиток из молока и\n" +
                    "мороженого', 5.40);");
            statement.executeUpdate("insert into products(id, name, description, price) values (5, 'Сок Я Яблоко', '0,97 л', 3.90);");
            statement.executeUpdate("insert into orders(id, date) VALUES (1, '2020-12-02');");
            statement.executeUpdate("insert into orders(id, date) VALUES (2, '2020-12-03');");
            statement.executeUpdate("insert into orders(id, date) VALUES (3, '2020-12-04');");
            statement.executeUpdate("insert into orders_products(order_id, product_id, count) VALUES (1, 1, 1);");
            statement.executeUpdate("insert into orders_products(order_id, product_id, count) VALUES (1, 2, 1);");
            statement.executeUpdate("insert into orders_products(order_id, product_id, count) VALUES (2, 3, 1);");
            statement.executeUpdate("insert into orders_products(order_id, product_id, count) VALUES (2, 4, 2);");
            statement.executeUpdate("insert into orders_products(order_id, product_id, count) VALUES (3, 1, 2);");
            statement.executeUpdate("insert into orders_products(order_id, product_id, count) VALUES (3, 4, 4);");
        } catch (Exception e) {
            System.out.println("");
        }

    }

}
