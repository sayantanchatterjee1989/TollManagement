package toll.management.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import toll.management.beans.VehicleDetails;
import toll.management.dao.RateRepository;
import toll.management.dao.TollRepository;
import toll.management.model.Rates;
import toll.management.model.TollDetails;

@Service
public class TollManagementServiceImpl implements TollManagementService{
	
	@Autowired
	TollRepository tr;
	
	@Autowired
	RateRepository rr;

	public VehicleDetails getStatus(String vehicleNumber) {
		VehicleDetails vd = new VehicleDetails();
		TollDetails td= tr.findByVehicleNumber(vehicleNumber);
		LocalDate date =  LocalDate.now().plusDays(1);
		if(td == null || td.getExpiryDate().isBefore(LocalDate.now())) {
			vd.setVehicleNumber(vehicleNumber);;
			vd.setIsValid("No");
			vd = setRates(vd);
		}
		return vd;
	}
	
	private VehicleDetails setRates(VehicleDetails vd) {
		List<Rates> rates = rr.findAll();
		for(Rates rate : rates) {
			vd.setSingleWay(String.valueOf(rate.getSingle()));
			vd.setReturnJourney(String.valueOf(rate.getReturnTrip()));
		}
		return vd;
	}
	
	public VehicleDetails createPass(String journeyType, String vehicleNumber) {
		VehicleDetails vd = new VehicleDetails();
		TollDetails td= tr.findByVehicleNumber(vehicleNumber);
		if(td == null || td.getExpiryDate().isBefore(LocalDate.now())) {
			VehicleDetails passDetails = setRates(new VehicleDetails());
			if(journeyType.equalsIgnoreCase("single"))
				vd.setAmount(passDetails.getSingleWay());
			else
				vd.setAmount(passDetails.getReturnJourney());
			vd.setVehicleNumber(vehicleNumber);
			vd.setRoute(journeyType);
			
			TollDetails dataToBeSaved = (new TollManagementServiceImpl()).setData(vd);
			TollDetails dataSaved = tr.save(dataToBeSaved);
			System.out.println("Toll Details id : " + dataSaved.getTollDetailsId());
			vd.setId(String.valueOf(dataSaved.getTollDetailsId()));
			vd.setExpiryDate(dataSaved.getExpiryDate().toString());
			vd.setIsValid("YES");
		}
		else {
			vd.setVehicleNumber(vehicleNumber);;
			vd.setIsValid("YES");
			vd.setExpiryDate(td.getExpiryDate().toString());
		}
		return vd;
	}
	
	private TollDetails setData(VehicleDetails vd){
		TollDetails td = new TollDetails();
		td.setVehicleNumber(vd.getVehicleNumber());
		td.setAmount(Integer.parseInt(vd.getAmount()));
		td.setRoute(vd.getRoute());
		td.setExpiryDate(LocalDate.now().plusDays(2));
		return td;
	}
}
