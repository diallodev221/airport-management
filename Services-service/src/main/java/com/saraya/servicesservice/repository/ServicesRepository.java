package com.saraya.servicesservice.repository;

import com.saraya.servicesservice.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Long> {

    @Query("SELECT s FROM Services  s WHERE s.servicesName= ?1")
    Services getServiceByServicesName(String name);
}
