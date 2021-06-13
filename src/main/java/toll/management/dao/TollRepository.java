package toll.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import toll.management.model.TollDetails;

@Repository
public interface TollRepository  extends JpaRepository<TollDetails, String>{

	@Query("select t from TollDetails t where t.vehicleNumber like %?1")
    TollDetails findByVehicleNumber(String chars);
}
