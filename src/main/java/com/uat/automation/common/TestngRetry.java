package com.uat.automation.common;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
 * @Author Paul.Wang
 * @Date 2018/7/24
 */
public class TestngRetry implements IRetryAnalyzer {

	private Logger logger = Logger.getLogger(TestngRetry.class);
	private int retryCount = 1;
	private int maxRetryCount=2;
//	static {
//
//	//外围文件配置最大运行次数
//	config = new ConfigReader(TestngListener.CONFIG);
//	maxRetryCount = config.getMaxRunCount();
//	logger.info(“maxRunCount=” + (maxRetryCount));
//	}
	
	@Override
	public boolean retry(ITestResult result) {
		if (retryCount <= maxRetryCount) {
			String message = "running retry for" + result.getName()
					+ " on class" +
					this.getClass().getName() + "Retrying " + retryCount
					+ " times";
			logger.info(message);
			Reporter.setCurrentTestResult(result);
			Reporter.log("RunCount=" + retryCount );
			retryCount++;
			return true;
		}
		return false;
	}

}
