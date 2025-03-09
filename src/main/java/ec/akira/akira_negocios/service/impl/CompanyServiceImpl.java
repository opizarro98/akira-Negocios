package ec.akira.akira_negocios.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.akira.akira_negocios.model.entity.Company;
import ec.akira.akira_negocios.repository.CompanyRepo;
import ec.akira.akira_negocios.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepo companyRepo;

    @Override
    public Company createCompany(Company company) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCompany'");
    }

}
