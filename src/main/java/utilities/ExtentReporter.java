package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentReporter {
	
	public static ExtentReports getExtenntReports()
	{
		String extentReportPath = System.getProperty("user.dir")+"\\reports\\extentreports.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(extentReportPath);
		String timestamp = CommonUtilFunction.getTimeStamp();
		
		//String extentReportPath = System.getProperty("user.dir")+"\\reports\\extentreports.html";
		//ExtentSparkReporter reporter=new ExtentSparkReporter(extentReportPath);
		
		reporter.config().setReportName("Testing login name using selenium");
		reporter.config().setDocumentTitle("Test Result");
		
		ExtentReports extentreport = new ExtentReports();
		extentreport.attachReporter(reporter);
		extentreport.setSystemInfo("Operation System", "Window 11");
		extentreport.setSystemInfo("Tester", "Rahul Kumar");
		extentreport.setSystemInfo("Automation tool", "Selenium with java");
		
		return extentreport;
		
	}

}
