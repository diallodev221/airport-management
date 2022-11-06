package com.saraya.EmployeeServicesRelationshipservice.proxies;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "employee-service", url = "http://localhost:8083/employees")
public interface EmployeeProxy {
}
