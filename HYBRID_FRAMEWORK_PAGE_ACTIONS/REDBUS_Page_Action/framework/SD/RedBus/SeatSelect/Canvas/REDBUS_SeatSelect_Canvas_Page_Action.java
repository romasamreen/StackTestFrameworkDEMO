/**
 * 
 */
package framework.SD.RedBus.SeatSelect.Canvas;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commons.Web.MouseOperation;

/**
 * @author cdeyso
 *
 */
public class REDBUS_SeatSelect_Canvas_Page_Action {
	
	private static WebDriver driver = null;
	private static ExtentTest logger = null;

	
	private static REDBUS_SeatSelect_Canvas_Page_Factory RBcanvasPageFactory = null;
	
	public REDBUS_SeatSelect_Canvas_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		RBcanvasPageFactory = new REDBUS_SeatSelect_Canvas_Page_Factory(driver, logger);
	}
	
	public static void enterDestinationDetails() 
			throws InterruptedException {
		
		Thread.sleep(7000);
		enterFromDetails();
		enterToDetails();
		calDatePicker_Temp();
		clickSearchBusesButton();
	}
	
	public static void selectAppropriateSeats() 
			throws InterruptedException, AWTException {
		
		Thread.sleep(7000);
		viewBusSeats();
		Thread.sleep(7000);
		selectBusSeatsFromDeck();
		Thread.sleep(7000);
	}
	
	public static void enterFromDetails() 
			throws InterruptedException {
		
		WebElement fromElement = RBcanvasPageFactory.get_redbus_FromTextBox();
		if(fromElement!=null && fromElement.isDisplayed()){
			fromElement.sendKeys("Pune");
			logger.log(LogStatus.PASS, "From Place Entered.");
			Thread.sleep(2000);
			List<WebElement> fromSearchList = RBcanvasPageFactory.get_redbus_FromTextBox_Search();
			if(fromSearchList.size()>0){
				int listSize = fromSearchList.size();
				System.out.println("listSize "+listSize);
				WebElement listElementOne = fromSearchList.get(0);
				listElementOne.click();
				logger.log(LogStatus.PASS, "Selected From Place!");
			}
		}
	}
	
	public static void enterToDetails() 
			throws InterruptedException {
		
		WebElement fromElement = RBcanvasPageFactory.get_redbus_ToTextBox();
		if(fromElement!=null && fromElement.isDisplayed()){
			fromElement.sendKeys("Nagpur");
			logger.log(LogStatus.PASS, "To Place Entered.");
			Thread.sleep(2000);
			List<WebElement> fromSearchList = RBcanvasPageFactory.get_redbus_ToTextBox_Search();
			if(fromSearchList.size()>0){
				int listSize = fromSearchList.size();
				System.out.println("listSize "+listSize);
				WebElement listElementOne = fromSearchList.get(0);
				listElementOne.click();
				logger.log(LogStatus.PASS, "Selected To Place!");
			}
		}
	}
	
	public static void calDatePicker_Temp() {
		
		WebElement currentDate = RBcanvasPageFactory.get_redbus_calCurrentDate_Temp();
				if(currentDate!=null){
					currentDate.click();
					logger.log(LogStatus.PASS, "Current Date Selected!");
				}
	}
	
	public static void clickSearchBusesButton() {
		
		WebElement searchBusesEle = RBcanvasPageFactory.get_redbus_searchBusesBtn();
		if(searchBusesEle!=null){
			searchBusesEle.click();
			logger.log(LogStatus.PASS, "Search button clicked!");
		}
	}
	
	
	
	public static void viewBusSeats() {
		
		WebElement viewSeatsEle = RBcanvasPageFactory.get_redbus_searcResult_ViewSeats();
		if(viewSeatsEle!=null && viewSeatsEle.isDisplayed()){
			/*Actions action = new Actions(driver);
			action.click(viewSeatsEle);*/
			viewSeatsEle.click();
			logger.log(LogStatus.PASS, "Checking available seats!");
		}
	}
	
	public static void selectBusSeatsFromDeck() 
			throws InterruptedException, AWTException {
		
		
		WebElement deckSeatElement = RBcanvasPageFactory.get_redbus_searcResult_CheckSeats();
		if(deckSeatElement!=null){
			System.out.println(deckSeatElement.getSize());
			Point deckSeatElementLoc = deckSeatElement.getLocation();
			int loc_x = deckSeatElementLoc.getX();
			int loc_y = deckSeatElementLoc.getY();
			System.out.println("X- "+loc_x+" Y- "+loc_y);
			int x_revised = loc_x+180;
			int y_revised = loc_y-30;
			 Robot robot = new Robot();
			 robot.mouseMove(x_revised,y_revised);
			 getToolTipData();
			 robot.mousePress(InputEvent.BUTTON1_MASK);
			 robot.mouseRelease(InputEvent.BUTTON1_MASK);
			   
			//Actions action = new Actions(driver);
			//canvasJSExecutor(deckSeatElement);
			//action.click().build().perform();;
			//deckSeatElement.click();
			//if(deckSeatElement.get)
			String canvasWidth = deckSeatElement.getAttribute("width");
			int xOffset = Integer.parseInt(canvasWidth);
			String canvasHeight = deckSeatElement.getAttribute("height");
			int yOffset = Integer.parseInt(canvasHeight);
			System.out.println("canvasWidth - "+canvasWidth+" canvasHeight - "+canvasHeight);
			//robot.mouseMove(xOffset,yOffset+10);
			
			MouseOperation.hoverMouseToElement(driver, logger, deckSeatElement);
			Thread.sleep(3000);
			//action.moveToElement(deckSeatElement, xOffset, yOffset).click().build().perform();
			logger.log(LogStatus.PASS, "One Seat Clicked!");
		}
	}
	
	public static void canvasJSExecutor(WebElement canvasElement) {
		
		
		JavascriptExecutor canvasJSE = (JavascriptExecutor)driver;
		canvasJSE.executeScript("var ctx = arguments[0].getContext('2d');ctx.stroke();", canvasElement);
	}
	
	public static void getToolTipData() 
			throws InterruptedException {
		
		Thread.sleep(3000);
		WebElement toolTipData = RBcanvasPageFactory.get_redbus_searcResult_ToolTipData();
		if(toolTipData!=null && toolTipData.isDisplayed()){
			String toolTipData_text = toolTipData.getText();
			System.out.println("toolTipData_text - "+toolTipData_text);
			logger.log(LogStatus.INFO, "ToolTip Data Recorded : "+toolTipData_text);
		}
	}
}
