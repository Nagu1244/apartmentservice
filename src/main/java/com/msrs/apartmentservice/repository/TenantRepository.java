package com.msrs.apartmentservice.repository;

import com.msrs.apartmentservice.dtos.TenantDtoResponse;
import com.msrs.apartmentservice.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Integer> {
    /**Note Table and column names must match with DB not Entity class name and fields in native Query*/
    /** For JPQL we should use Table name as Entity name and fields as entity fields*/

    //@Query(value = "select * from tenant t JOIN apartment a ON t.member_id=a.id WHERE a.flat_number = :flatNumber", nativeQuery = true)
    @Query(value = "SELECT t FROM Tenant t JOIN t.apartment a WHERE a.flatNumber = :flatNumber")
    Tenant findByFlatNumber(@Param("flatNumber") String flatNumber);
}
