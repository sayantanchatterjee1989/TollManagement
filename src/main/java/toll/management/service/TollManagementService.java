package toll.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import toll.management.beans.VehicleDetails;
import toll.management.model.Rates;
import toll.management.model.TollDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class TollManagementService {

    @Autowired
    Rates rate;
    static Map<String, List<Integer>> vehicleDetails = new HashMap<>();
    static Map<Integer, TollDetails> tollDetails = new HashMap<>();
    static int id;
    public Map<String, String> createPass(String route, String vehicleNumber){
        List<Integer> tollId = vehicleDetails.get(vehicleNumber);
        if(tollId != null ){
            Integer lastTollId = tollId.get(tollId.size()-1);
            LocalDate localDate = LocalDate.now();
            if(tollDetails.get(lastTollId).getExpiryDate().isAfter(localDate))
            return buildResponse(route, vehicleNumber, true, lastTollId);
        }
        return buildResponse(route, vehicleNumber, false, null);
    }

    public Map<String, String> buildResponse(String route, String vehicleNumber, boolean isValidPassExist, Integer tollId){
        Map<String, String> response = new HashMap<>();

            if(isValidPassExist){
                response.put("tollId", String.valueOf(tollId));
                response.put("Vehicle Number", vehicleNumber);
                response.put("Is Valid", "true");
            } else{
                TollDetails tollDetail = new TollDetails();
                tollDetail.setTollDetailsId(++id);
                response.put("tollId", String.valueOf(id));

                tollDetail.setVehicleNumber(vehicleNumber);
                response.put("Vehicle Number", vehicleNumber);

                if(route.equalsIgnoreCase("single")){
                    tollDetail.setAmount(rate.getSingle());
                    response.put("Amount", String.valueOf(rate.getSingle()));

                    tollDetail.setRoute("single");
                    response.put("Route", "Single");
                } else {
                    tollDetail.setAmount(rate.getBack());
                    response.put("Amount", String.valueOf(rate.getBack()));

                    tollDetail.setRoute("Return");
                    response.put("Route", "Return");

                    LocalDate expiryDate = LocalDate.now().plusDays(2);
                    tollDetail.setExpiryDate(expiryDate);
                    response.put("Expiry Date", expiryDate.toString());
                }
                tollDetails.put(id, tollDetail);
                List<Integer> tollIdList = vehicleDetails.get(vehicleNumber);
                if(tollIdList != null)
                    tollIdList.add(id);
                else{
                    List<Integer> tollIdToBeAdded = new ArrayList<>();
                    tollIdToBeAdded.add(id);
                    vehicleDetails.put(vehicleNumber, tollIdToBeAdded);
                }

            }

        return response;
    }
}
