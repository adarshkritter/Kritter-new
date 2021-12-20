package com.company;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Trial {
    void createFile() {
        try {
            File myObj = new File("abc.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                FileWriter myWriter = new FileWriter("abc.txt");
                myWriter.write("adarsh");
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void readFile() {
        File myObj = new File("abc.txt");
        if (myObj.exists()) {
            System.out.println("File name: " + myObj.getName());
            System.out.println("Absolute path: " + myObj.getAbsolutePath());
            System.out.println("Writeable: " + myObj.canWrite());
            System.out.println("Readable " + myObj.canRead());
            System.out.println("File size in bytes " + myObj.length());
        } else {
            System.out.println("The file does not exist.");
        }
    }
    void showFile() throws Exception {
        FileReader fr = new FileReader("adarsh.txt");
        BufferedReader br = new BufferedReader(fr);

        int i;
        while ((i = br.read()) != -1) {
            System.out.print((char) i);
        }
        br.close();
        fr.close();
    }
    void mysqlReader() throws SQLException {
        String MySQLURL = "jdbc:mysql://localhost:3306/kritter?useSSL=false";
        String databseUserName = "root";
        String databasePassword = "Ad@8129405010";
        Connection con = null;
        try {
            con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);
            if (con != null) {
                System.out.println("Database connection is successful !!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        con.close();
    }

    void addValuestoMysql() throws SQLException {
        String MySQLURL = "jdbc:mysql://localhost:3306/kritter?useSSL=false";
        String databseUserName = "root";
        String databasePassword = "Ad@8129405010";
        Connection con = null;
        try {
            con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);
            if (con != null) {
                String sql = "INSERT INTO bank VALUES (101, 'Adarsh Suresh', 22, 'M', 8129405010)";

                PreparedStatement statement = con.prepareStatement(sql);
                /*
                statement.setInt(1, 101);
                statement.setString(2, "Adarsh Suresh");
                statement.setInt(3, 22);
                statement.setString(4, "M");
                statement.setInt(5, 8129405010);
*/
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new user was inserted successfully!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Trial e1 =new Trial();
        e1.mysqlReader();
        e1.addValuestoMysql();

    }
}
