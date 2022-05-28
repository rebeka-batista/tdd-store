package com.devsuperior.bds01.services;

import com.devsuperior.bds01.dto.DepartmentDto;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public List<DepartmentDto> findAll() {
        List<Department> list = repository.findAll(Sort.by("name"));
        return list.stream().map(DepartmentDto::new).collect(Collectors.toList());
    }

}
