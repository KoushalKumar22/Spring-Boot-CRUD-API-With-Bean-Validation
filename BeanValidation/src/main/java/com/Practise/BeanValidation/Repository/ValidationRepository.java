package com.Practise.BeanValidation.Repository;

import com.Practise.BeanValidation.Services.Validation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidationRepository extends JpaRepository<Validation,Integer> {
}
