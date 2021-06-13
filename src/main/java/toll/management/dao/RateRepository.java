package toll.management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import toll.management.model.Rates;

@Repository
public interface RateRepository extends JpaRepository<Rates, Integer>{


}
