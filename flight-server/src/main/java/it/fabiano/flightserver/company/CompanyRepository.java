package it.fabiano.flightserver.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Gaetano Fabiano
 *
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{

}
