package com.epam.producing.testProject.web;

import com.epam.producing.testProject.exceptions.addressExceptions.AddressNotFoundException;
import com.epam.producing.testProject.exceptions.employeeExceptions.EmployeeNotFoundException;
import com.epam.producing.testProject.model.Address;
import com.epam.producing.testProject.model.Employee;
import com.epam.producing.testProject.repository.AddressRepository;
import com.epam.producing.testProject.repository.EmployeeRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @ApiOperation(value = "get all addresses by employee id")
    @GetMapping("/{employeeId}/addresses")
    public List<Address> getAllAddressesByEmployeeId(@PathVariable (value = "employeeId") Long employeeId) {
        return addressRepository.findByEmployeeId(employeeId);
    }

    @ApiOperation(value = "create new address")
    @PostMapping("/{employeeId}/addresses")
    public Address createAddress(@PathVariable (value = "employeeId") Long employeeId,
                                  @Valid @RequestBody Address address) {

         return employeeRepository.findById(employeeId).map(employee -> {
            address.getEmployees().add(employee);
            employee.getAddresses().add(address);
            return addressRepository.save(address);
            //return employeeRepository.save(employee);
        }).orElseThrow(() -> new EmployeeNotFoundException(employeeId));
    }

//    @PutMapping("/employees/{employeeId}/addresses/{addressId}")
//    public Address updateAddress(@PathVariable (value = "employeeId") Long employeeId,
//                                 @PathVariable (value = "addressId") Long addressId,
//                                 @Valid @RequestBody Address addressRequest) {
//        if(!employeeRepository.existsById(employeeId)) {
//            throw new EmployeeNotFoundException(employeeId);
//        }
//
//        return addressRepository.findById(addressId).map(address -> {
//            address.setCity(addressRequest.getCity());
//            address.setStreet(addressRequest.getStreet());
//            address.setHouse_number(addressRequest.getHouse_number());
//            address.setFlat_number(addressRequest.getFlat_number());
//
//            return addressRepository.save(address);
//        }).orElseThrow(() -> new AddressNotFoundException(addressId));
//    }
//
//    @DeleteMapping("/employees/{employeeId}/addresses/{addressId}")
//    public ResponseEntity<?> deleteAddress(@PathVariable (value = "employeeId") Long employeeId,
//                                           @PathVariable (value = "addressId") Long addressId) {
//        return addressRepository.findByIdAndEmployeeId(addressId, employeeId).map(address -> {
//            addressRepository.delete(address);
//            return ResponseEntity.ok().build();
//        }).orElseThrow(() -> new AddressNotFoundException(addressId));
//    }


}
