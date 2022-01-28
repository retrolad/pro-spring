package com.retrolad.ch08;

import com.google.common.collect.Lists;
import com.retrolad.ch08.entities.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("springJpaDeveloperService")
@Transactional
public class DeveloperServiceImpl implements DeveloperService{

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
    public List<Developer> findByNameAndFound(String name, Date data) {
        return developerRepository.findByNameAndFounded(name, data);
    }
}
