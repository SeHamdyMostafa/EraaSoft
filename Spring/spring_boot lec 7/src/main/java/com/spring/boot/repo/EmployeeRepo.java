package com.spring.boot.repo;

import com.spring.boot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    Optional<Employee> findByName(String name);

    // 1- Function Name
    List<Employee> findByNameStartingWith(String name);

    // 2- JPQL (NonNative)
    @Query("SELECT e FROM Employee e WHERE e.name LIKE CONCAT(:name,'%')")
    List<Employee> searchByNameJPQL(@Param("name") String name);

    // 3- Native Query
    @Query(value = "SELECT * FROM EMPLOYEE WHERE NAME LIKE :name || '%'", nativeQuery = true)
    List<Employee> searchByNameNative(@Param("name") String name);

}