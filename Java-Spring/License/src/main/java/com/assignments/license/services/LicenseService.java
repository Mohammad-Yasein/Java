package com.assignments.license.services;

import com.assignments.license.models.License;
import com.assignments.license.repositories.LicenseRepository;
import org.springframework.stereotype.Service;

@Service
public class LicenseService {
    private final LicenseRepository licenseRepository;

    public LicenseService(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    public void insertLicense(License license) {
        license.setNumber(generateLicenseNum());
        licenseRepository.save(license);
    }

    public int generateLicenseNum() {
        License license = licenseRepository.findTopByOrderByNumberDesc();
        if (license == null) {
            return 1;
        }
        return license.getNumber() + 1;
    }
}
