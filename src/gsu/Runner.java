package gsu;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {

        //create tables
        Cabinet cabinets = Cabinet.getInstance();
        Program programs = Program.getInstance();
        Computer computers = Computer.getInstance();

        cabinets.createTable();
        programs.createTable();
        computers.createTable();
        computers.createLinkTableToCabinets();
        computers.createLinkTableToPrograms();

        // add information
        cabinets.addData("1;3-29;description;3;11");
        cabinets.addData("2;3-28;description;3;12");
        cabinets.addData("3;4-14;description;4;16");

        programs.addData("4;Windows 10;description;444-111-333;2020-12-01;366");
        programs.addData("5;Windows 10;description;111-444-333;2020-12-01;366");
        programs.addData("6;Windows 10;description;111-111-444;2020-12-01;366");
        programs.addData("7;Windows 10;description;555-111-333;2020-12-02;366");
        programs.addData("8;Windows 10;description;111-555-333;2020-12-02;366");
        programs.addData("9;Windows 10;description;111-111-555;2020-12-02;366");
        programs.addData("10;Windows 10;description;666-111-333;2020-12-03;366");
        programs.addData("11;Windows 10;description;111-666-333;2020-12-03;366");
        programs.addData("12;Windows 10;description;111-111-666;2020-12-03;366");
        programs.addData("13;AutoCad;description;999-999-111;2020-12-4;180");
        programs.addData("14;AutoCad;description;999-999-222;2020-12-4;180");
        programs.addData("15;AutoCad;description;999-333-111;2020-12-4;180");

        computers.addData("1;5-3-29-1;description;Intel Core i3; Nvidia gtx 650;4");
        computers.addData("2;5-3-29-2;description;Intel Core i3; Nvidia gtx 650;4");
        computers.addData("3;5-3-29-3;description;Intel Core i3; Nvidia gtx 650;4");
        computers.addData("4;5-3-28-1;description;Intel Core i5; Nvidia gtx 660;6");
        computers.addData("5;5-3-28-2;description;Intel Core i5; Nvidia gtx 660;6");
        computers.addData("6;5-3-28-3;description;Intel Core i5; Nvidia gtx 660;6");
        computers.addData("7;5-4-14-1;description;Intel Core i7; Nvidia gtx 750;8");
        computers.addData("8;5-4-14-2;description;Intel Core i7; Nvidia gtx 750;8");
        computers.addData("9;5-4-14-3;description;Intel Core i7; Nvidia gtx 750;8");

        computers.addInCabinet("1;1");
        computers.addInCabinet("2;1");
        computers.addInCabinet("3;1");
        computers.addInCabinet("4;2");
        computers.addInCabinet("5;2");
        computers.addInCabinet("6;2");
        computers.addInCabinet("7;3");
        computers.addInCabinet("8;3");
        computers.addInCabinet("9;3");

        computers.installProgram("1;4");
        computers.installProgram("2;5");
        computers.installProgram("3;6");
        computers.installProgram("4;7");
        computers.installProgram("5;8");
        computers.installProgram("6;9");
        computers.installProgram("7;10");
        computers.installProgram("8;11");
        computers.installProgram("9;12");
        computers.installProgram("1;13");
        computers.installProgram("2;14");
        computers.installProgram("3;15");

        // add subscribers
        Log subscribers = computers.log;
        subscribers.addSubscriber("Server");
        subscribers.addSubscriber("LocalStorage");


        cabinets.addData("4;5-28;radio;5;15");
        computers.addData("10;comp_528;new computer;Intel Core i9; Nvidia gtx 2080; 32");
        programs.addData("16;Windows 10;description;111-897-666;2020-12-9;366");

        // delete subscriber
        subscribers.deleteSubscriber("Server");

        // change data
        cabinets.editData(4, "4;5-28;electronic;5;15");
        computers.editData(10, "10;5-5-28-1;new computer;Intel Core i9; Nvidia gtx 2080; 32");
        programs.editData(16,"16;Windows 10;description;111-897-666;2020-12-10;366");
        computers.addInCabinet("10;4");
        computers.installProgram("10;16");

        // show data
        computers.getData();

        // delete data
        programs.addData("25;AutoCad;text text text;999-333-898;2020-12-25;180");
        programs.deleteData(25);


    }
}
