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

public class  LogicTemperatureSensor extends TemperatureSensor  { 

	ITemperatureSensor objTemperatureSensor;
	Activity ui;
	public LogicTemperatureSensor obj = this;
	Device deviceInfo;	
	public String deviceType;
   
	public LogicTemperatureSensor(PubSubMiddleware pubSubM, final Device deviceInfo, final Object ui,Context myContext) {
		super(pubSubM, deviceInfo);
		
		deviceType = deviceInfo.getType();
		
		if (deviceType.equals(GlobalVariable.deviceAndroidType)) {		
		
		
		this.ui = (Activity) ui;
		   this.ui.runOnUiThread(new Runnable() {
				public void run() {
					objTemperatureSensor = TemperatureSensorFactory.getTemperatureSensor(deviceInfo.getType(), (Activity) ui, obj);
		
					if (objTemperatureSensor.isEventDriven()) {


												
													objTemperatureSensor.getTempMeasurement(TempMeasurementEvent);
												
											

					} else {
						
							
												
												objTemperatureSensor.getTempMeasurement(TempMeasurementEvent);

												
								
											   
											
					
					}
					
				}
			});
		}
		
		

	}	
	

		
	   

		

		
		
		
		ListenerTempMeasurement  TempMeasurementEvent = new ListenerTempMeasurement() {
			
			@Override
			public void onNewTempMeasurement(TempStruct response) {

				TempStruct sTempStruct = new TempStruct(
				response.gettempValue(), response.getunitOfMeasurement());
				setTempMeasurement(sTempStruct);
			}
			
			
		};
	   
	

}