package toll.management.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TOLL_DETAILS")
public class TollDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tollDetailsId;
	
	@Column(name="VEHICLE_NUMBER")
	private String vehicleNumber;
	
	@Column(name="ROUTE")
	private String route;
	
	@Column(name="AMOUNT")
	private int amount;
	
	@Column(name="EXPIRY_DATE")
	private LocalDate expiryDate;
	
	public int getTollDetailsId() {
		return tollDetailsId;
	}
	public void setTollDetailsId(int tollDetailsId) {
		this.tollDetailsId = tollDetailsId;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	
}
