package com.example.demo.repository;


import com.example.demo.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IAddressRepository extends JpaRepository<Address, Integer> {


    List<Address> findAllByUserFk(Integer userFk);

    Optional<Address> findByUserFkAndStatusTrue(Integer userFk);


}