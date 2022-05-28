package com.devsuperior.bds01.services;

import com.devsuperior.bds01.dto.EmployeeDto;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.entities.Employee;
import com.devsuperior.bds01.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Transactional(readOnly = true)
    public Page<EmployeeDto> findAll(Pageable pageable) {
        Page<Employee> page = repository.findAll(pageable);
        return page.map(EmployeeDto::new);
    }

    @Transactional
    public EmployeeDto insert(EmployeeDto dto) {
        Employee entity = new Employee();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setDepartment(new Department(dto.getDepartmentId(), null));
        entity = repository.save(entity);
        return new EmployeeDto(entity);
    }
}
