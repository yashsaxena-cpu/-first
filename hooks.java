package stepdefs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Runner.ExtentReportListener;
import Runner.Runner;
import base.BaseTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.TestNGCucumberRunner;
import reports.Reports;

public class Hooks extends Reports  {
	   static String featureName;
	   static Set<String> featureList=new HashSet<String>();
	   static Map<String,ExtentTest> scenarioList = new HashMap<String,ExtentTest>();

	    @After
	    public void qu(Scenario scenario) {
	    	   int before = featureList.size();
	    	   String rawFeatureName = scenario.getId().split(";")[0].replace("-"," ");
	    	   String featureName = rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);
	    	   featureList.add(featureName);
	    	   if(before != featureList.size()) {
	    	    ExtentTest feature = extent.createTest(Feature.class, featureName);
	    	    scenarioList.put(featureName, feature);
	    	    if(scenario.isFailed()) {
	    		feature.createNode(com.aventstack.extentreports.gherkin.model.Scenario.class,scenario.getName(),"Fail");
	    		feature.log(Status.FAIL,scenario.getName()+" is failed .");
	    	    }
	    	    else {
	    		feature.createNode(com.aventstack.extentreports.gherkin.model.Scenario.class,scenario.getName(),"Pass");
	    		feature.log(Status.PASS,scenario.getName()+" is passed successfully.");
	    	    }
	          }
	    	   else{
	    		   if(scenario.isFailed()) {
	    			   scenarioList.get(featureName).createNode(com.aventstack.extentreports.gherkin.model.Scenario.class,scenario.getName(),"Fail");
	    			   scenarioList.get(featureName).log(Status.FAIL,scenario.getName()+" is failed ."); 
	    		   }
	   	    	    else {
	   	    	    	scenarioList.get(featureName).createNode(com.aventstack.extentreports.gherkin.model.Scenario.class,scenario.getName(),"Pass");
	   	    	    	scenarioList.get(featureName).log(Status.PASS,scenario.getName()+" is passed successfully."); 
	   	    	    }
	    	   }
	    }

	
	    
	    
	

}
