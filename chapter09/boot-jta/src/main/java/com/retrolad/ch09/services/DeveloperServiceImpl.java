package com.retrolad.ch09.services;

import com.retrolad.ch09.entities.Developer;
import com.retrolad.ch09.ex.AsyncXAResourcesException;
import com.retrolad.ch09.repos.DeveloperRepository;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("developerService")
@Transactional
public class DeveloperServiceImpl implements DeveloperService {

    private DeveloperRepository developerRepository;
    private JmsTemplate jmsTemplate;

    public DeveloperServiceImpl(DeveloperRepository developerRepository, JmsTemplate jmsTemplate) {
        this.developerRepository = developerRepository;
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public Developer save(Developer developer) {
        jmsTemplate.convertAndSend("developers", "Just saved:" + developer);

        if (developer == null) {
            throw new AsyncXAResourcesException("Simulation of something going wrong");
        }
        developerRepository.save(developer);
        return developer;
    }

    @Override
    public long count() {
        return developerRepository.count();
    }
}
