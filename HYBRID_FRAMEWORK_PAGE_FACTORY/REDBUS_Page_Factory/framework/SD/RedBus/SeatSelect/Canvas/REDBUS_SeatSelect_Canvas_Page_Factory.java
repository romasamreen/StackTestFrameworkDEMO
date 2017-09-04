/**
 * 
 */
package framework.SD.RedBus.SeatSelect.Canvas;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import commons.Web.WebElementCommon;

/**
 * @author cdeyso
 *
 */

public class REDBUS_SeatSelect_Canvas_Page_Factory {
	
	private WebDriver driver=null;
	private ExtentTest logger=null;
	
	private WebElementCommon webElementCommon = null;
	
	public REDBUS_SeatSelect_Canvas_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
		PageFactory.initElements(driver, this);
		webElementCommon = new WebElementCommon(driver, logger);
	}
	
	//RedBus Home Page -- From TextBox
	@FindBy(xpath = "//input[@type='text'][@id='src']")
	private WebElement redbus_FromTextBox;

	public WebElement get_redbus_FromTextBox() {
		if (webElementCommon.waitForElementPresent(driver, redbus_FromTextBox, logger)) {
			return redbus_FromTextBox;
		} else
			return null;
	}
	
	//RedBus Home Page -- From TextBox -- Search Results
	@FindBy(xpath = "//input[@type='text'][@id='src']//parent::div//ul//li")
	private List<WebElement> redbus_FromTextBox_Search;

	public List<WebElement> get_redbus_FromTextBox_Search() {
		//if (webElementCommon.waitForElementPresent(driver, redbus_FromTextBox_Search, logger)) {
			return redbus_FromTextBox_Search;
		//} else
		//	return null;
	}
	
	//RedBus Home Page -- To TextBox
	@FindBy(xpath = "//input[@type='text'][@id='dest']")
	private WebElement redbus_ToTextBox;

	public WebElement get_redbus_ToTextBox() {
		if (webElementCommon.waitForElementPresent(driver, redbus_ToTextBox, logger)) {
			return redbus_ToTextBox;
		} else
			return null;
	}
	
	//RedBus Home Page -- To TextBox -- Search Results
	@FindBy(xpath = "//input[@type='text'][@id='dest']//parent::div//ul//li")
	private List<WebElement> redbus_ToTextBox_Search;

	public List<WebElement> get_redbus_ToTextBox_Search() {
		//if (webElementCommon.waitForElementPresent(driver, redbus_FromTextBox_Search, logger)) {
			return redbus_ToTextBox_Search;
		//} else
		//	return null;
	}
	
	
	//Datepicker -- -----------------------------------  START  ----------------------------------------------
	
	// Calender -- Return Date Selection
	@FindBy(css = "#rb-calendar_onward_cal td.prev")
	private WebElement calPrevButton;
	
	public WebElement get_redbus_calPrevButton() {
		if (webElementCommon.waitForElementPresent(driver, calPrevButton, logger)) {
			return calPrevButton;
		} else
			return null;
	}
	
	// Calender -- Return Date Selection
	@FindBy(css = "#rb-calendar_onward_cal td.next")
	private WebElement calNextButton;
	
	public WebElement get_redbus_calNextButton() {
		if (webElementCommon.waitForElementPresent(driver, calNextButton, logger)) {
			return calNextButton;
		} else
			return null;
	}
	
	// Calender -- Current Date Selection
	@FindBy(css = "#rb-calendar_onward_cal  td.current.day")
	private WebElement calCurrentDate;
	
	public WebElement get_redbus_calCurrentDate() {
		if (webElementCommon.waitForElementPresent(driver, calCurrentDate, logger)) {
			return calCurrentDate;
		} else
			return null;
	}
	
	
	//Calender -- Onward Date Selection
	@FindBy(css = "div[id='rb-calendar_onward_cal']")
	private WebElement calOnwardCalender;
	
	public WebElement get_redbus_calOnwardCalender() {
		if (webElementCommon.waitForElementPresent(driver, calOnwardCalender, logger)) {
			return calOnwardCalender;
		} else
			return null;
	}
	
	// Calender -- Return Date Selection
	@FindBy(css = "div[id='rb-calendar_return_cal']")
	private WebElement calReturnCalender;
	
	public WebElement get_redbus_calReturnCalender() {
		if (webElementCommon.waitForElementPresent(driver, calReturnCalender, logger)) {
			return calReturnCalender;
		} else
			return null;
	}
	
	//Calender -- Return List<WebElement> all the Rows of the Calender 
	@FindBy(css = "#rb-calendar_onward_cal tr")
	private List<WebElement> calRowsList;
	
	public List<WebElement> get_redbus_calRowsList() {
		//if (webElementCommon.waitForElementPresent(driver, calPrevButton, logger)) {
			return calRowsList;
		//
	}
	
	//TEMP -- Select the current Date  #rb-calendar_onward_cal td.current.day
	@FindBy(css = "#rb-calendar_onward_cal td.current.day")
	private WebElement calCurrentDate_Temp;
	
	public WebElement get_redbus_calCurrentDate_Temp() {
		if (webElementCommon.waitForElementPresent(driver, calCurrentDate_Temp, logger)) {
			return calCurrentDate_Temp;
		} else
			return null;
	}
	

	//Datepicker -- -------------------------------- END -------------------------------------------------
	
	//RedBus -- Search Buses Button
	@FindBy(css = "button#search_btn")
	private WebElement redbus_searchBusesBtn;
	
	public WebElement get_redbus_searchBusesBtn() {
		if (webElementCommon.waitForElementPresent(driver, redbus_searchBusesBtn, logger)) {
			return redbus_searchBusesBtn;
		} else
			return null;
	}
	
	
	//RedBus -- Search Results Page ---------------------------------------------- START --------------------------------------------
	
	//RedBus -- View Seats Button
	@FindBy(css = "li:nth-child(2) div.view-seats-container>button")
	private WebElement redbus_searcResult_ViewSeats;
	
	public WebElement get_redbus_searcResult_ViewSeats() {
		if (webElementCommon.waitForElementPresent(driver, redbus_searcResult_ViewSeats, logger)) {
			return redbus_searcResult_ViewSeats;
		} else
			return null;
	}
	
	//RedBus -- deck Seat
	@FindBy(css = "div.seat-layout.clearfix > div.lower-canvas.canvas-wrapper > canvas")
	private WebElement redbus_searcResult_CheckSeats;
	
	public WebElement get_redbus_searcResult_CheckSeats() {
		if (webElementCommon.waitForElementPresent(driver, redbus_searcResult_CheckSeats, logger)) {
			return redbus_searcResult_CheckSeats;
		} else
			return null;
	}
	
	
	//RedBus -- ToolTip Data
	@FindBy(css = "div[id='abs'][class='abs']")
	private WebElement redbus_searcResult_ToolTipData;
	
	public WebElement get_redbus_searcResult_ToolTipData() {
		if (webElementCommon.waitForElementPresent(driver, redbus_searcResult_ToolTipData, logger)) {
			return redbus_searcResult_ToolTipData;
		} else
			return null;
	}
}
