package api.utitlites;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.restassured.http.Header;

public class ExtentManager {
	

	public static ExtentReports extentReports = new ExtentReports();
	  
	  public static ExtentReports createInstance(String fileName, String reportName, String documentTitle) {
	    ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(fileName);
	    extentSparkReporter.config().setCss("css-string");
	    extentSparkReporter.config().setEncoding("utf-8");
	    extentSparkReporter.config().setJs("js-string");
	    extentSparkReporter.config().setProtocol(Protocol.HTTPS);
	    extentSparkReporter.config().setReportName("build name");
	    extentSparkReporter.config().setTheme(Theme.DARK);
	    extentSparkReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
	    extentSparkReporter.config().setReportName(reportName);
	    extentSparkReporter.config().setDocumentTitle(documentTitle);
	    extentSparkReporter.config().setTheme(Theme.DARK);
	    extentSparkReporter.config().setEncoding("utf-8");
	    extentReports.attachReporter(new ExtentObserver[] { (ExtentObserver)extentSparkReporter });
	    return extentReports;
	  }
	  
	  public static String getReportNameWithTimeStamp() {
	    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
	    LocalDateTime localDateTime = LocalDateTime.now();
	    String formattedTime = dateTimeFormatter.format(localDateTime);
	    String reportName = "TestReport" + formattedTime + ".html";
	    return reportName;
	  }
	  
	  public static void logPassDetails(String log) {
	    ((ExtentTest)Setup.extentTest.get()).pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
	  }
	  
	  public static void logFailureDetails(String log) {
	    ((ExtentTest)Setup.extentTest.get()).fail(MarkupHelper.createLabel(log, ExtentColor.RED));
	  }
	  
	  public static void logExceptionDetails(String log) {
	    ((ExtentTest)Setup.extentTest.get()).fail(log);
	  }
	  
	  public static void logInfoDetails(String log) {
	    ((ExtentTest)Setup.extentTest.get()).info(MarkupHelper.createLabel(log, ExtentColor.GREY));
	  }
	  
	  public static void logWarningDetails(String log) {
	    ((ExtentTest)Setup.extentTest.get()).warning(MarkupHelper.createLabel(log, ExtentColor.YELLOW));
	  }
	  
	  public static void logJson(String json) {
	    ((ExtentTest)Setup.extentTest.get()).info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
	  }
	  
	  public static void logHeaders(List<Header> headersList) {
	    String[][] arrayHeaders = (String[][])headersList.stream().map(header -> new String[] { header.getName(), header.getValue() }).toArray(x$0 -> new String[x$0][]);
	    ((ExtentTest)Setup.extentTest.get()).info(MarkupHelper.createTable(arrayHeaders));
	  }	

}
