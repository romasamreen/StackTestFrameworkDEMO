/**
 * 
 */
package framework.SD.RedBus.SeatSelect.Canvas;

import org.testng.annotations.Test;

import framework.modules.core.BaseClass;

/**
 * @author cdeyso
 *
 */
public class REDBUS_SeatSelect_Canvas_Page_Test extends BaseClass{

	@SuppressWarnings("static-access")
	@Test(description="Hakuna Matata")
	public void testCanvas() {
		
		try {
			
			REDBUS_SeatSelect_Canvas_Page_Action canvasPA = new REDBUS_SeatSelect_Canvas_Page_Action(driver, logger);
			canvasPA.enterDestinationDetails();
			canvasPA.selectAppropriyateSeats();
			
			
			getFinalReport(driver, logger, methodName ,	true);
		} catch (Exception e) {
			// TODO: handle exception
			getFinalReport(driver, logger, methodName ,	false);
		}
		
	}
}
