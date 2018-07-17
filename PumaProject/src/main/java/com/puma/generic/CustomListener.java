package com.puma.generic;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListener implements ITestListener {
	ExtentTest logger;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		try {
		Robot r=new Robot();
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRect=new Rectangle(d);
		BufferedImage image= r.createScreenCapture(screenRect);
		String imagePath="D://abc.png";
		
			ImageIO.write(image,"png",new File(imagePath));
		
		logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
	 	logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
	 	logger.log(LogStatus.FAIL,logger.addScreenCapture(imagePath));
		System.out.println(imagePath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	

}
