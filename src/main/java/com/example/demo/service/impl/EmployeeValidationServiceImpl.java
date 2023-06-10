package com.example.demo.service.impl;

import com.example.demo.exceptions.InvalidInputException;
import com.example.demo.service.EmployeeValidationService;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.StringUtils.isAlpha;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
public class EmployeeValidationServiceImpl implements EmployeeValidationService {
    @Override
    public void validate(String firstName, String lastName){
        validateName(firstName);
        validateName(lastName);
    }

    private void validateName(String name) {
        if (isBlank(name) || !isAlpha(name)) {
            throw new InvalidInputException("Symbols used are not allowed: " + name);
        }
    }
}
