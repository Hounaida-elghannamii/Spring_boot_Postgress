package com.example.postgre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExempleResposibility  extends JpaRepository<DeviseEntity,Long> {
}
