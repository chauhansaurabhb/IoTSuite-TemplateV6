package logic;

import iotsuite.pubsubmiddleware.*;
import iotsuite.common.GlobalVariable;
import android.content.Context;
import iotsuite.semanticmodel.*;
import android.app.Activity;
import android.app.Dialog;
import framework.*;
import factory.*;

import framework.*;

public class  LogicBadgeReader extends BadgeReader  { 

	IBadgeReader objBadgeReader;
	Activity ui;
	public LogicBadgeReader obj = this;
	Device deviceInfo;	
	public String deviceType;
   
	public LogicBadgeReader(PubSubMiddleware pubSubM, final Device deviceInfo, final Object ui,Context myContext) {
		super(pubSubM, deviceInfo);
		
		deviceType = deviceInfo.getType();
		
		if (deviceType.equals(GlobalVariable.deviceAndroidType)) {		
		
		
		this.ui = (Activity) ui;
		   this.ui.runOnUiThread(new Runnable() {
				public void run() {
					objBadgeReader = BadgeReaderFactory.getBadgeReader(deviceInfo.getType(), (Activity) ui, obj);
		
					if (objBadgeReader.isEventDriven()) {


												
													objBadgeReader.getBadgeDetected(BadgeDetectedEvent);
												
											

												
													objBadgeReader.getBadgeDisappeared(BadgeDisappearedEvent);
												
											

					} else {
						
							
												
												objBadgeReader.getBadgeDetected(BadgeDetectedEvent);

												
								
											   
											
							
												
												objBadgeReader.getBadgeDisappeared(BadgeDisappearedEvent);

												
								
											   
											
					
					}
					
				}
			});
		}
		
		

	}	
	

		
	   


		
	   

		

		
		
		
		ListenerBadgeDetected  BadgeDetectedEvent = new ListenerBadgeDetected() {
			
			@Override
			public void onNewBadgeDetected(BadgeStruct response) {

				BadgeStruct sBadgeStruct = new BadgeStruct(
				response.getbadgeID(), response.getbadgeEvent());
				setBadgeDetected(sBadgeStruct);
			}
			
			
		};
	   

		
		
		
		ListenerBadgeDisappeared  BadgeDisappearedEvent = new ListenerBadgeDisappeared() {
			
			@Override
			public void onNewBadgeDisappeared(BadgeStruct response) {

				BadgeStruct sBadgeStruct = new BadgeStruct(
				response.getbadgeID(), response.getbadgeEvent());
				setBadgeDisappeared(sBadgeStruct);
			}
			
			
		};
	   
	

}