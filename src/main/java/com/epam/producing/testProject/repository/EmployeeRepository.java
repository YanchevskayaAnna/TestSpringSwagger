package com.epam.producing.testProject.repository;

import com.epam.producing.testProject.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//    Page<Employee> findByOfficeId(Long officeId, Pageable pageable); //TODO что такое Page?
//    Optional<Employee> findByIdAndOfficeId(Long id, Long officeId);//TODO зачем???
}
