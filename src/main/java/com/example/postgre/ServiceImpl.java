package com.example.postgre;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    private final ExempleResposibility exempleResposibility;
    public ServiceImpl(ExempleResposibility exempleResposibility){
        this.exempleResposibility=exempleResposibility;
    }
    @Override
    public List<DeviseEntity> findAllEmployee() {
        return exempleResposibility.findAll();
    }
    @Override
    public Optional<DeviseEntity> findById(Long id) {
        return exempleResposibility.findById(id);
    }
    @Override
    public DeviseEntity saveEmployee(DeviseEntity deviseEntity) {
        return exempleResposibility.save(deviseEntity);
    }
    @Override
    public DeviseEntity updateEmoloyee(DeviseEntity deviseEntity) {
        return exempleResposibility.save(deviseEntity);
    }
    @Override
    public void deleteEmployee(Long id) {
exempleResposibility.deleteById(id);
    }
}
