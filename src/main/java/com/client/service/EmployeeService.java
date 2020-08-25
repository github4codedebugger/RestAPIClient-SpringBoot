package com.client.service;

import com.client.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeService {

    private RestTemplate restTemplate;

    @Autowired
    public EmployeeService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String saveEmp(Employee employee) {
        HttpEntity<Employee> entity = new HttpEntity<>(employee);
        return restTemplate.exchange("http://localhost:8080/employee", HttpMethod.POST, entity, String.class).getBody();
    }

    public List<Employee> getEmp() {
        return restTemplate.exchange("http://localhost:8080/employee", HttpMethod.GET, null, List.class).getBody();
    }
}
