package toll.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RATES")
public class Rates {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="SINGLE")
	private int single;
	
	@Column(name="RETURN_TRIP")
	private int returnTrip;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSingle() {
		return single;
	}

	public void setSingle(int single) {
		this.single = single;
	}

	public int getReturnTrip() {
		return returnTrip;
	}

	public void setReturnTrip(int returnTrip) {
		this.returnTrip = returnTrip;
	}
	
	

}
