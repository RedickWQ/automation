package com.uat.automation.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @Author Paul.Wang
 * @Date 2018/7/26
 * Robot类
 * 用于操作按键和鼠标
 */

public class RobotUtils {
	public static Robot robot = null;
	
	/**
	 * 模拟键盘操作--单一键操作
	 * @author wq
	 */
	
	public static void pressTAB(){
		try{
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
		}catch(AWTException e){
			e.printStackTrace();
		}
	}
	
	public static void pressSpace(){
		try{
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_SPACE);
			robot.keyRelease(KeyEvent.VK_SPACE);
		}catch(AWTException e){
			e.printStackTrace();
		}
	}
	public static void pressEnter(){
		try{
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}catch(AWTException e){
			e.printStackTrace();
		}
	}
	
	public static void pressDown(){
		try{
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
		}catch(AWTException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 模拟键盘操作--组合键操作
	 * @author wq
	 */
	
	/**
	 * 用于关闭浏览器的tab页
	 */
	public static void pressCtrl_W(){
		try{
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_W);
			robot.keyRelease(KeyEvent.VK_W);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			
		}catch(AWTException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取屏幕快照
	 * 仅供Capture调用
	 * @param methodName  调用Capture的方法名
	 * @author wq
	 */
	
	//屏幕快照
	public static void screenShot(String methodName){
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		// 格式化当前时间，例如20121231-165210
		String time = sdf.format(new Date());

		try {
			// 拷贝屏幕到一个BufferedImage对象screenshot
			BufferedImage screenshot = (new Robot())
					.createScreenCapture(new Rectangle(0, 0,
							(int) d.getWidth(), (int) d.getHeight()));
			// serialNum++;
			// 根据文件前缀变量和文件格式变量，自动生成文件名
			String name = "C:\\auto_img"+ File.separator + time + "_" + methodName
					  + ".png";
			File f = new File(name);
			// 将screenshot对象写入图像文件
			ImageIO.write(screenshot, "png", f);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 一般截屏方法
	 * @author wq
	 */
	public static void screenShot(){
		
//		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
//
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
//		// 格式化当前时间，例如20121231-165210
//		String time = sdf.format(new Date());
//
//		try {
//			// 拷贝屏幕到一个BufferedImage对象screenshot
//			BufferedImage screenshot = (new Robot())
//					.createScreenCapture(new Rectangle(0, 0,
//							(int) d.getWidth(), (int) d.getHeight()));
//			// serialNum++;
//			// 根据文件前缀变量和文件格式变量，自动生成文件名
//			String name = PropertyFileUtil.get("imgfilePath") +File.separator+time + "."
//					+ "png";
//			File f = new File(name);
//			// 将screenshot对象写入图像文件
//			ImageIO.write(screenshot, "png", f);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
	}
	
	
	/**
	 * 复制粘贴
	 * @param string
	 * @author wq
	 */
	  public static void setAndctrlVClipboardData(String string){
		  //声明一个StingSelection 对象，并使用String的参数完成实例化；
		  Transferable stringSelection = new StringSelection(string);
		  //使用Toolkit对象的setContents将字符串放到粘贴板中 ；
		  Robot robot = null ;
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		  try{
		      robot = new Robot();
		  }catch(AWTException e){
		  	  System.out.println(e.getStackTrace());
		  }
		//按下crtl v键 ；
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_V);
		//释放crtl v 键
		  robot.keyRelease(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_CONTROL);
	  }
	  
	 
}
	