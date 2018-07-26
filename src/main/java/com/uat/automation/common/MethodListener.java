package com.uat.automation.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.util.*;

/**
 * @Author Paul.Wang
 * @Date 2018/7/24
 */
public class MethodListener extends TestListenerAdapter {

	private static Logger logger = LoggerFactory.getLogger(MethodListener.class);

	@Override
	public void onTestSuccess(ITestResult tr) {

		super.onTestSuccess(tr);
		System.out.println("======================congratulations,your test is pass======================");
	}

	/**
	 * 测试执行失败时截图
	 */
	@Override
	public void onTestFailure(ITestResult tr) {

		super.onTestFailure(tr);
		System.out.println("======================fail to run "+tr.getName()+"======================");
//		RobotUtil.screenShot(tr.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult tr) {

		super.onTestSkipped(tr);
		System.out.println("======================skip this test,please check your case======================");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {

		super.onTestFailedButWithinSuccessPercentage(tr);
	}

	@Override
	protected ITestNGMethod[] getAllTestMethods() {

		return super.getAllTestMethods();
	}

	@Override
	public void onStart(ITestContext testContext) {

		super.onStart(testContext);
	}

	@Override
	public void onFinish(ITestContext testContext) {

		super.onFinish(testContext);
		// List of test results which we will delete later
		ArrayList<ITestResult> testsToBeRemoved = new ArrayList<ITestResult>();
		// collect all id's from passed test
		Set<Integer> passedTestIds = new HashSet<Integer>();
		for (ITestResult passedTest : testContext.getPassedTests().getAllResults()) {
			logger.info("PassedTests = " + passedTest.getName());
			passedTestIds.add(getId(passedTest));
		}

		Set<Integer> failedTestIds = new HashSet<Integer>();
		for (ITestResult failedTest : testContext.getFailedTests().getAllResults()) {
			logger.info("failedTest = " + failedTest.getName());
		// id = class + method + dataprovider
			int failedTestId = getId(failedTest);

		// if we saw this test as a failed test before we mark as to be deleted
		// or delete this failed test if there is at least one passed version
			if (failedTestIds.contains(failedTestId) || passedTestIds.contains(failedTestId)) {
				testsToBeRemoved.add(failedTest);
			} else {
				failedTestIds.add(failedTestId);
			}
		}

		// finally delete all tests that are marked
		for (Iterator<ITestResult> iterator = testContext.getFailedTests().getAllResults().iterator(); iterator.hasNext();) {
			ITestResult testResult = iterator.next();
			if (testsToBeRemoved.contains(testResult)) {
				logger.info("Remove repeat Fail Test: " + testResult.getName());
				iterator.remove();
			}
		}

	}

	private int getId(ITestResult result) {
		int id = result.getTestClass().getName().hashCode();
		id = id + result.getMethod().getMethodName().hashCode();
		id = id + (result.getParameters() != null ? Arrays.hashCode(result.getParameters()) : 0);
		return id;
	}


	@Override
	public List<ITestResult> getFailedButWithinSuccessPercentageTests() {

		return super.getFailedButWithinSuccessPercentageTests();
	}

	@Override
	public List<ITestResult> getFailedTests() {

		return super.getFailedTests();
	}

	@Override
	public List<ITestResult> getPassedTests() {

		return super.getPassedTests();
	}

	@Override
	public List<ITestResult> getSkippedTests() {

		return super.getSkippedTests();
	}

	@Override
	public void setAllTestMethods(List<ITestNGMethod> allTestMethods) {

		super.setAllTestMethods(allTestMethods);
	}

	@Override
	public void setFailedButWithinSuccessPercentageTests(
			List<ITestResult> failedButWithinSuccessPercentageTests) {

		super.setFailedButWithinSuccessPercentageTests(failedButWithinSuccessPercentageTests);
	}

	@Override
	public void setFailedTests(List<ITestResult> failedTests) {

		super.setFailedTests(failedTests);
	}

	@Override
	public void setPassedTests(List<ITestResult> passedTests) {

		super.setPassedTests(passedTests);
	}

	@Override
	public void setSkippedTests(List<ITestResult> skippedTests) {

		super.setSkippedTests(skippedTests);
	}

	@Override
	public void onTestStart(ITestResult result) {

		super.onTestStart(result);
	}

	@Override
	public List<ITestContext> getTestContexts() {

		return super.getTestContexts();
	}

	@Override
	public List<ITestResult> getConfigurationFailures() {

		return super.getConfigurationFailures();
	}

	@Override
	public void onConfigurationFailure(ITestResult itr) {

		super.onConfigurationFailure(itr);
	}

	@Override
	public List<ITestResult> getConfigurationSkips() {

		return super.getConfigurationSkips();
	}

	@Override
	public void beforeConfiguration(ITestResult tr) {

		super.beforeConfiguration(tr);
	}

	@Override
	public void onConfigurationSkip(ITestResult itr) {

		super.onConfigurationSkip(itr);
	}

	@Override
	public void onConfigurationSuccess(ITestResult itr) {

		super.onConfigurationSuccess(itr);
	}

	@Override
	public String toString() {

		return super.toString();
	}

	@Override
	public int hashCode() {

		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {

		return super.clone();
	}

	@Override
	protected void finalize() throws Throwable {

		super.finalize();
	}
	

}
