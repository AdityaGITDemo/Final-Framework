package resources;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
static ExtentReports extent;
	
	public static ExtentReports getReportObject()
	{
		
		String path =System.getProperty("user.dir")+"\\reports\\FinalFramework_execution_"+Base.getDate()+".html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester:", "Aditya");
		return extent;
		
	}
	
//	public static String getDate()
//    {
//        DateFormat dformat = new SimpleDateFormat("dd_MM_yy_HH_mm_ss");
//        Date date= new Date();
//        return dformat.format(date);   
//    }
	
}
