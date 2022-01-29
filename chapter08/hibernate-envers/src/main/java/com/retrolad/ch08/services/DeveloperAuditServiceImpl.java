package com.retrolad.ch08.services;

import com.google.common.collect.Lists;
import com.retrolad.ch08.entities.DeveloperAudit;
import com.retrolad.ch08.repos.DeveloperAuditRepository;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("developerAuditService")
@Transactional
public class DeveloperAuditServiceImpl implements DeveloperAuditService {

    @Autowired
    private DeveloperAuditRepository developerAuditRepository;

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<DeveloperAudit> findAll() {
        return Lists.newArrayList(developerAuditRepository.findAll());
    }

    @Override
    public DeveloperAudit findById(Long id) {
        return developerAuditRepository.findById(id).get();
    }

    @Override
    public DeveloperAudit save(DeveloperAudit developerAudit) {

        return developerAuditRepository.save(developerAudit);
    }

    @Override
    public DeveloperAudit findAuditByRevision(Long id, int revision) {
        AuditReader auditReader = AuditReaderFactory.get(em);
        return auditReader.find(DeveloperAudit.class, id, revision);
    }
}
