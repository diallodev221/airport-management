package com.saraya.EmployeeServicesRelationshipservice.proxies;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "services-service", url = "http://localhost:8082/services")
public interface ServicesProxy {


}
