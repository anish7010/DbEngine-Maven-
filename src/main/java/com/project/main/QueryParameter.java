package com.project.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.print.attribute.HashAttributeSet;

public class QueryParameter {
	// query to be performed
	private String query;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	// getting the .csv files
	public ArrayList<String> getDb(String query) {
		Pattern p = Pattern.compile("[a-zA-Z0-9]+\\.csv");
		Matcher m = p.matcher(query);
		ArrayList<String> csv_files = new ArrayList<String>();

		while (m.find()) {
			csv_files.add(m.group());
		}
		return csv_files;
	}

	// the part before where
	public String before_where(String query) {
		String[] split_where = query.split(" where ");
		return split_where[0];
	}

	// the part after where
	public String after_where(String query) {
		String[] split_where = query.split(" where ");
		return split_where[1];
	}

	/*
	 * making a string array for all the conditions extra spaces before and after
	 * and so it doesnt split at bangalore/england
	 */
	public String[] conditions(String query) {
		String[] conditions = query.split("( and | or | not )");
		return conditions;
	}

	// for finding the columns that need to be returned
	public String[] fields(String query) {
		// splitting to get the desired output
		String[] a = query.split("select ");
		String[] b = a[1].split(" from");
		String[] c = b[0].split(",");

		return c;
	}

	public ArrayList<String> getDatatype(ArrayList<String[]> rowList) {
		// contains the first row
		String[] columns = rowList.get(1);
		// for integers and date
		Pattern number = Pattern.compile("[0-9]+");
		Pattern date = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");
		Matcher m;

		ArrayList<String> datatype = new ArrayList<>();
		for (String s : columns) {
			m = date.matcher(s);
			if (m.find()) {
				datatype.add("Date");
			} else {
				m = number.matcher(s);
				if (m.find())
					datatype.add("Integer");
				else
					datatype.add("String");
			}
		}
		return datatype;
	}

	// getting datatypes
	public HashMap<String, String> hashedGetDatatype(ArrayList<String[]> rowList) {
		// contains the first row
		String[] keys = rowList.get(0);
		HashMap<String, String> mappedData = new HashMap<>();

		// for integers and date
		Pattern number = Pattern.compile("[0-9]+");
		Pattern date = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");
		Matcher m;

		// for checking out the values
		String[] columns = rowList.get(1);

		ArrayList<String> datatype = new ArrayList<>();
		for (String s : columns) {
			m = date.matcher(s);
			if (m.find()) {
				datatype.add("Date");
			} else {
				m = number.matcher(s);
				if (m.find())
					datatype.add("Integer");
				else
					datatype.add("String");
			}
		}

		for (int i = 0; i < columns.length; i++) {
			mappedData.put(keys[i], datatype.get(i));
		}

		return mappedData;
	}

	public void FireQuery(String query, ArrayList<String[]> allData) {
		// contains where
		if (query.contains("where")) {
			if (query.contains("*")) {
				// contains star but no where
				String a = this.after_where(query);
				String[] b = this.conditions(a);
					
				}
					
				}
					
		// doesn't contains where
		else {
			// doesn't contain where and a * is there
			// contains * and no where
			if (query.contains("*")) {
				// to display all
				for (String s[] : allData) {
					System.out.println();
					for (String s1 : s) {
						System.out.print(s1 + "\t\t");
					}
				}

			}
			// contains no star and no where
			else {
				String[] fields = this.fields(query);
				String[] columns = allData.get(0);
				ArrayList<Integer> match = new ArrayList<>();
				for (int i = 0; i < fields.length; i++) {
					for (int j = 0; j < columns.length; j++) {
						// getting the index of the matching fields
						if (fields[i].equals(columns[j]))
							match.add(j);
					}
				}

				for (String[] s : allData) {
					System.out.println();
					for (int i = 0; i < s.length; i++) {
						if (match.contains(i))
							System.out.print(s[i] + "\t");
					}
				}

			}
		}

	}

}
