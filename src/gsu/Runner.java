package gsu;


import java.io.IOException;
import java.sql.*;

public class Runner {

    public static void main(String[] args) throws SQLException, IOException {

        String query = "select * from products";

        Connection conn = new DBConnection().get_connection();
        Statement statement = conn.createStatement();

        // create tables
        statement.executeUpdate("create table if not exists orders(\n" +
                "    id int auto_increment,\n" +
                "    date date not null,\n" +
                "    primary key (id)\n" +
                "\n" +
                ");");
        statement.executeUpdate("create table if not exists products(\n" +
                "    id int auto_increment,\n" +
                "    name varchar(60) not null,\n" +
                "    description varchar(250) not null,\n" +
                "    price float(9, 2) not null,\n" +
                "    primary key (id)\n" +
                ");");
        statement.executeUpdate("create table if not exists orders_products(\n" +
                "    order_id int,\n" +
                "    product_id int,\n" +
                "    count int,\n" +
                "    primary key (order_id, product_id),\n" +
                "    foreign key (order_id) references orders(id),\n" +
                "    foreign key (product_id) references products(id)\n" +
                ");");

        // fill tables
        addInformation addInfo = new addInformation(conn);
        addInfo.fillTables();

        // queries
        getInformation getInfo = new getInformation(conn);

        System.out.println(getInfo.getDetailedInfo(1));
        System.out.println(getInfo.getIDWithMaxPriceAndCount(21, 3));
        System.out.println(getInfo.getOrderIDContainsProductID(1));
        System.out.println(getInfo.getOrderIDTodayAndNotContainsProductID(3));
        System.out.println(getInfo.getProductsOrderedToday());
        System.out.println(getInfo.getOrderIDWithProductIDAndCountThisProduct(4, 4));

        // write data to html

        createHTML html = new createHTML();
        html.createHtmlReport(getInfo.getDetailedInfo(2));



    }
}
