/**
 * 
 */
package DATEPICKER_Page_Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author cdeyso
 *
 */
public class DatePickerPage {
	
	 	@Drone
	    private WebDriver driver;

	    @InFrame(index = 0)
	    @FindBy(id = "datepicker")
	    private WebElement dateField;

	    @InFrame(index = 0)
	    @FindBy(id = "ui-datepicker-div")
	    private DatePicker datePicker;

	    public void goTo() {
	        driver.get("https://jqueryui.com/datepicker/");
	    }

	    public DatePicker getDatePicker() {
	        dateField.click();
	        return datePicker;
	    }

	    public String getSelectedDate() {
	        return this.dateField.getAttribute("value");
	    }


}
