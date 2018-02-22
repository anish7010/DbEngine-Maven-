package com.project.CsvReader;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.project.main.*;

@RunWith(JUnitPlatform.class)
public class TestQueryParameter {
		QueryParameter qp;
		
		@BeforeAll
		static void init() {
			System.out.println("we start here");
		}
		
		@BeforeEach
		void beforeEach() {
			qp = new QueryParameter();
		}
		
		@Test
		public void fieldsTest() {
			String query = "select name,city,wickets from everything";
			String[] expected = {"name","city","wickets"};
			String[] result = qp.fields(query);
			Assert.assertArrayEquals( expected, result);
		}
		
		@Test
		public void beforeWhereTest() {
			String query = "select * from csv where this = 3";
			String expected = "select * from csv";
			String result = qp.before_where(query);
			Assert.assertEquals(expected, result);
		}
		
		@Test
		public void afterWhereTest() {
			String query = "select * from csv where this = 3";
			String expected = "this = 3";
			String result = qp.after_where(query);
			Assert.assertEquals(expected, result);
		}
		
		@Test
		public void conditionsTest() {
			String query = "name = 'anish' and age = 22 or color = 'blue'";
			String[] expected = {"name = 'anish'","age = 22","color = 'blue'"};
			String[] result = qp.conditions(query);
			Assert.assertArrayEquals(expected, result);
		}
		
		@AfterEach
		void afterEach() {
			qp = null;
		}
		
		@AfterAll
		static void end() {
			System.out.println("This is the end");
		}
}
