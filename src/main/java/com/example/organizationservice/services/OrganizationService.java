package com.example.organizationservice.services;

import com.example.organizationservice.model.Organization;
import com.example.organizationservice.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository orgRepository;

    public Organization getOrg(String organizationId) {

        Optional<Organization> organization = orgRepository.findById(organizationId);
        if (!organization.isPresent())
            throw new NullPointerException("organizationId-" + organizationId);
        return organization.get();
    }

    public void saveOrg(Organization org){
        org.setId( UUID.randomUUID().toString());

        orgRepository.save(org);

    }

    public void updateOrg(Organization org){
        orgRepository.save(org);
    }

    public void deleteOrg(Organization org){
        orgRepository.delete(org);
    }
}
