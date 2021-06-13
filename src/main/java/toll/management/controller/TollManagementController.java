package toll.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import toll.management.beans.VehicleDetails;
import toll.management.model.TollDetails;
import toll.management.service.TollManagementService;

@RestController
@RequestMapping("/vehicle")
public class TollManagementController {
	
	@Autowired
	TollManagementService tms;

	@GetMapping
	@RequestMapping("/status")
	public VehicleDetails getStatus(@RequestParam String vehicleNumber) {
		System.out.println("Vehicle Number : "+vehicleNumber);
		
		
		return tms.getStatus(vehicleNumber);
	}
	
	@GetMapping
	@RequestMapping("/{route}")
	public VehicleDetails createPass(@RequestParam String vehicleNumber, @PathVariable String route) {
		System.out.println("Vehicle Number : "+vehicleNumber);
		
		
		return tms.createPass(route, vehicleNumber);
	}
	
	
}
