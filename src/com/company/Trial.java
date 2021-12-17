package com.company;
import java.io.*;

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
    void readFile(){
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
    public static void main(String[] args) throws Exception{
        //Trial e1 =new Trial();
        //e1.createFile();
        FileReader fr=new FileReader("adarsh.txt");
        BufferedReader br=new BufferedReader(fr);

        int i;
        while((i=br.read())!=-1){
            System.out.print((char)i);
        }
        br.close();
        fr.close();
    }
        }
