package com.saraya.Employeeservice.service;

import com.saraya.Employeeservice.dto.EmployeeDto;
import com.saraya.Employeeservice.model.Employee;
import com.saraya.Employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    private final ModelMapper modelMapper;


    public List<EmployeeDto> getAllEmployees() {
        return repository.findAll().stream()
                .map(employee -> modelMapper.map(employee, EmployeeDto.class)).toList();
    }

    public EmployeeDto getEmployee(Long employeeId) {
        Employee employee = repository.findById(employeeId)
                .orElseThrow(()-> new IllegalArgumentException("Employee id "+employeeId+" not found"));
        return modelMapper.map(employee, EmployeeDto.class);
    }

    public Employee saveEmployee(EmployeeDto dto) {
        return repository.save(modelMapper.map(dto, Employee.class));
    }

    public Employee updateEmployee(EmployeeDto dto) {
        return repository.save(modelMapper.map(dto, Employee.class));
    }

    public void deleteEmployee(Long employeeId){
        repository.deleteById(employeeId);
    }

    public EmployeeDto getEmployeeByEmail(String email) {
        return modelMapper.map(repository.findEmployeeByEmail(email), EmployeeDto.class);
    }


}
