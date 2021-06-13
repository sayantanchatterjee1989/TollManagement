package toll.management.service;

import toll.management.beans.VehicleDetails;
import toll.management.model.TollDetails;

public interface TollManagementService {

	public VehicleDetails getStatus(String vehicleNumber);
	
	public VehicleDetails createPass(String journeyType, String vehicleNumber);
}
