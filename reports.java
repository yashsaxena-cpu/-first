package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseTest;

public class Reports {
	
	protected static ExtentReports extent;
	
	public static  ExtentReports createReports() {
		  if(extent==null) {
		 ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/extent.html");
	        htmlReporter.config().setDocumentTitle("ExtentReports - Created by TestNG Listener");
	        htmlReporter.config().setReportName("ExtentReports - Created by TestNG Listener");
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
	        htmlReporter.config().setTheme(Theme.STANDARD);
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
			extent.setSystemInfo("Environment", "Automation Testing");
			extent.setSystemInfo("User Name", "Rajkumar SM");
		  }
		return extent;
	}

	
	
	public static void closeReports() {
		// TODO Auto-generated method stub
		extent.flush();
	}
	
}
