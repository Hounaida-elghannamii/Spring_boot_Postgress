package com.example.postgre;

import java.util.List;
import java.util.Optional;

public interface Service {
    List<DeviseEntity> findAllEmployee();
    Optional<DeviseEntity> findById(Long id);
    DeviseEntity saveEmployee(DeviseEntity deviseEntity);
    DeviseEntity updateEmoloyee(DeviseEntity deviseEntity);

    void deleteEmployee(Long id);

}
