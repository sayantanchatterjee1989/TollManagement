package toll.management.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@ConfigurationProperties("toll")
public class Rates {
	private int single;
	private int back;

	public int getSingle() {
		return single;
	}

	public void setSingle(int single) {
		this.single = single;
	}

	public int getBack() {
		return back;
	}

	public void setBack(int back) {
		this.back = back;
	}


	
	

}
