package com.saraya.EmployeeServicesRelationshipservice.service;

import com.saraya.EmployeeServicesRelationshipservice.dto.EmployeeServicesDto;
import com.saraya.EmployeeServicesRelationshipservice.bean.Employee;
import com.saraya.EmployeeServicesRelationshipservice.bean.Services;
import com.saraya.EmployeeServicesRelationshipservice.model.EmployeeServices;
import com.saraya.EmployeeServicesRelationshipservice.proxies.EmployeeProxy;
import com.saraya.EmployeeServicesRelationshipservice.proxies.ServicesProxy;
import com.saraya.EmployeeServicesRelationshipservice.repository.EmployeeServicesRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class EmployeeServicesService {

    private final EmployeeServicesRepo repo;
    private final ModelMapper modelMapper;

    private final EmployeeProxy employeeProxy;
    private final ServicesProxy servicesProxy;


    public void createEmpIdAndServiceId(EmployeeServicesDto dto) {
        EmployeeServices employeeServices = modelMapper.map(dto, EmployeeServices.class);
        repo.save(employeeServices);
    }

    /*public List<EmployeeDto> getAllEmployeesInService(Long service_id) {
        List<EmployeeDto> employees = new ArrayList<>();
        for (EmployeeDto dto : employees) {
            if (dto.getEmployee_id() )
        }

    }*/


 /*   public void getEmployeeIdAndServicesId(EmployeeServicesDto dto) {
        Map<String, Long> values = new HashMap<>();
        values.put("services_id", dto.getServices_id());
        Services services = new RestTemplate().getForEntity(
                "http://localhost:8082/services/{services_id}", Services.class, values
        ).getBody();
        EmployeeServices employeeServices = mapToEntity(dto);
        if (services != null) {
            System.out.println(services.toString());
            employeeServices.setEmp_service_id(dto.getEmp_service_id());
        }

        values.put("employee_id", dto.getEmployee_id());
        Employee employee = new RestTemplate().getForEntity(
                "http://localhost:8083/employees/{employee_id}", Employee.class, values
        ).getBody();
        if (employee != null) {
            System.out.println(employee.toString());
            employeeServices.setEmployee_id(employee.getEmployee_id());
        }
    }*/


    public EmployeeServices mapToEntity(EmployeeServicesDto dto) {
        EmployeeServices employeeServices = new EmployeeServices();
        employeeServices.setEmp_service_id(dto.getEmp_service_id());
        employeeServices.setEmployee_id(dto.getEmployee_id());
        employeeServices.setServices_id(dto.getServices_id());
        return employeeServices;
    }

    public EmployeeServicesDto mapToDto(EmployeeServices employeeServices) {
        EmployeeServicesDto dto = new EmployeeServicesDto();
        dto.setEmp_service_id(employeeServices.getEmp_service_id());
        dto.setServices_id(employeeServices.getServices_id());
        dto.setEmployee_id(employeeServices.getEmployee_id());
        return dto;
    }
}
