package com.epam.producing.testProject.repository;

import com.epam.producing.testProject.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("from Address a where (select e from Employee e where e.id = ?1) member of a.employees")
    List<Address> findByEmployeeId(Long employeeId);

    //Optional<Address> findByIdAndEmployeeId(Long id, Long employeeId);
}
