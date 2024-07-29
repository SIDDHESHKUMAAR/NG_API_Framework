package api.utitlites;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Setup implements ITestListener {
	  public static ExtentReports extentReports;
	  
	  public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	  
	  public void onStart(ITestContext context) {
	    String fileName = ExtentManager.getReportNameWithTimeStamp();
	    String fullReportPath = "C:\\Users\\ssasikumar\\eclipse-workspace\\NG_API_Framework\\reports";
	    extentReports = ExtentManager.createInstance(fullReportPath, "Test API Automation Report", "Test ExecutionReport");
	  }
	  
	  public void onFinish(ITestContext context) {
	    if (extentReports != null)
	      extentReports.flush(); 
	  }
	  
	  public void onTestStart(ITestResult result) {}
	  
	  public void onTestFailure(ITestResult result) {
	    try {
	    	ExtentManager.logFailureDetails(result.getThrowable().getMessage());
	      String stackTrace = Arrays.toString((Object[])result.getThrowable().getStackTrace());
	      stackTrace = stackTrace.replaceAll(",", "<br>");
	      String formmatedTrace = "<details>\n    <summary>Click Here To See Exception Logs</summary>\n    " + stackTrace + "\n</details>\n";
	      ExtentManager.logExceptionDetails(formmatedTrace);
	    } catch (Exception e) {
	      System.out.println("Raw inside Excel Should not be Null");
	    } 
	  }

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	}
	
