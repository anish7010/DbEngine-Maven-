package com.project.main;
import java.util.*;

class Main {
    public static void main(String[] args) {
    	
    	//taking it hard coded values because of jenkins
        String user_query = "select * from ipl.csv";
        //user_query = scanner.nextLine();
        
        //object of QueryParameter class
        QueryParameter qp = new QueryParameter();

        //object for performing methods on file
        FileCheck fc = new FileCheck();
        ArrayList<String[]> allData = new ArrayList<>();
        //contains all the data from the csv file in a 2d array format
        allData = fc.allData();
        
       qp.FireQuery(user_query, allData);
         
        //System.out.println(qp.getDatatype(allData));
       
    }
}