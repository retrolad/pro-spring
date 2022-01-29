package com.retrolad.ch08.services;

import com.retrolad.ch08.entities.DeveloperAudit;
import java.util.List;

public interface DeveloperAuditService {
    List<DeveloperAudit> findAll();
    DeveloperAudit findById(Long id);
    DeveloperAudit save(DeveloperAudit developerAudit);
    // Retrieves DeveloperAudit history record by the revision number
    DeveloperAudit findAuditByRevision(Long id, int revision);
}
