package com.project.main;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryParameter {
	//query to be performed
	private String query;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	//getting the .csv files
	public ArrayList<String> getDb(String query) {
		Pattern p = Pattern.compile("[a-zA-Z0-9]+\\.csv");
        Matcher m = p.matcher(query);
        ArrayList<String> csv_files = new ArrayList<String>();
        
        while(m.find()) {
            csv_files.add(m.group());
        }
        return csv_files;
	}
	//the part before where
	public String before_where(String query) {
		String[] split_where = query.split(" where ");
		return split_where[0];
	}
	//the part after where
	public String after_where(String query) {
		String[] split_where = query.split(" where ");
		return split_where[1];
	}
	
	/*making a string array for all the conditions
	 * extra spaces before and after and so it doesnt split at bangalore/england*/
	public String[] conditions(String query) {
		String[] conditions = query.split("( and | or | not )");
		return conditions;
	}
	//for finding the columns that need to be returned
	public String[] fields(String query) {
		//look up and look ahead so it doesn't return select and from
		Pattern p = Pattern.compile("(?<=select)(.*)(?=from)");
        Matcher m = p.matcher(query);
        String fields = null;
        while(m.find()){
        	fields = m.group();
        }
        //stores the fields to be displayed
        return fields.split(",");
	}
	
}
