package com.project.main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileCheck {

	public ArrayList<String[]> allData() {
		BufferedReader br = null;
        //list of string arrays
        ArrayList<String[]> rowList = new ArrayList<String[]>();
        try {
			br = new BufferedReader(new FileReader("/home/sapient/Documents/workspace-sts-3.9.2.RELEASE/CSV_FileReader/DbEngine/csv/ipl.csv"));
			String line;
			String[] arr;
	        //got the column names
			while ((line = br.readLine()) != null) {
				arr = line.split(",");
		        //everything stored in this list
				rowList.add(arr);
			}
			
									
		} catch (FileNotFoundException e) {
			System.out.println("Please type a valid path");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return rowList;
	}
	
}
