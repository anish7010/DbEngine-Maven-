package com.project.CsvReader;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.project.main.FileCheck;
import com.project.main.QueryParameter;

@RunWith(JUnitPlatform.class)
public class TestFileCheck {
	FileCheck fc;
	
	@BeforeAll
	static void init() {
		System.out.println("we start here");
	}
	
	@BeforeEach
	void beforeEach() {
		fc = new FileCheck();
	}
	
	
	@AfterEach
	void afterEach() {
		fc = null;
	}
}
