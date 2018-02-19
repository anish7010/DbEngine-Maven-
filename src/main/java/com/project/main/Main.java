package com.project.main;
import java.util.*;

class Main {
    public static void main(String[] args) {
    	//to be input by the user
    	
        String user_query;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your query : ");
        user_query = scanner.nextLine();
        
        //object of QueryParameter class
        QueryParameter qp = new QueryParameter();

        //object for performing methods on file
        FileCheck fc = new FileCheck();
        ArrayList<String[]> al = new ArrayList<>();
        //contains all the data from the csv file in a 2d array format
        al = fc.allData();
        //contains the datatype of each column
        ArrayList<String> data = fc.getDatatype(al);
        
     /*   //fields to be displayed
        String[] fields = qp.fields(user_query);
        String pop = fields[0] ;
        System.out.println(fields[0]);
     */   
       /* //to display all
        if(fields[0].equals(" * ")) {
	    	for(String s[]: al)
	    		for(String s1 : s)
	    			System.out.println(s1);
        }*/
        
        for(String s : al.get(9))
        	System.out.println(s);
        	
        scanner.close();
    }
}