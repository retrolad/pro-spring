package com.retrolad.ch12.services;

import com.google.common.collect.Lists;
import com.retrolad.ch12.entities.Developer;
import com.retrolad.ch12.repos.DeveloperRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeveloperServiceImpl implements DeveloperService {

    private static final Logger logger = LoggerFactory.getLogger(DeveloperServiceImpl.class);

    @Autowired
    private DeveloperRepository developerRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Developer> findAll() {
        return Lists.newArrayList(developerRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Developer> findByName(String name) {
        return developerRepository.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Developer findById(Long id) {
        return developerRepository.findById(id).get();
    }

    @Override
    public Developer save(Developer developer) {
        return developerRepository.save(developer);
    }

    @Override
    public void delete(Developer developer) {
        developerRepository.delete(developer);
    }
}
