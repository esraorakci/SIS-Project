package com.neotech.utils;

public class Constants {

	public static final String CONFIGURATION_FILPATH = System.getProperty("user.dir")
			.concat("/src/test/resources/configs/configuration.properties");

	public static final int IMPLICIT_WAIT_TIME = 5;

	public static final int EXPLICIT_WAIT_TIME = 5;

	public static final String REPORT_FILEPATH = System.getProperty("user.dir") + "/target/html-report/HRM.html";

	public static final String SCREENSHOT_FILEPATH = System.getProperty("user.dir") + "/screenshots/";

	public static final String DATA_FILEPATH = System.getProperty("user.dir") + "/src/test/resources/testdata/";

	public static final String UPLOAD_PHOTO_FILEPATH = "C:/Users/JFei/Desktop/Jordan's Downloads/Pics/Avatar/ImprovedElderSign.jpg";

	public static final String NEW_STUDENT_FILPATH = System.getProperty("user.dir")
			.concat("/src/test/resources/testdata/testStudent.properties");

	public static final String NEW_TEACHER_FILPATH = System.getProperty("user.dir")
			.concat("/src/test/resources/testdata/testTeacher.properties");

	public static final boolean TAKE_SCREENSHOT = false;

}
