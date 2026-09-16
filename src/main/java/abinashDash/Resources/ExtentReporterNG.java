package abinashDash.Resources;

import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	@BeforeTest
	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir") + "//reports//index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("Web Automation Result");
		report.config().setDocumentTitle("test Results");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Abinash Dash");
		return extent;

	}
}
