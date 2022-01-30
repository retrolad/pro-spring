package com.retrolad.ch09.services;

import com.retrolad.ch09.entities.Developer;
import com.retrolad.ch09.ex.AsyncXAResourceException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.List;

@Service("developerService")
@Repository
@Transactional
public class DeveloperServiceImpl implements DeveloperService {

    @PersistenceContext(unitName = "emfA")
    private EntityManager emA;

    @PersistenceContext(unitName = "emfB")
    private EntityManager emB;

    @Override
    @Transactional(readOnly = true)
    public List<Developer> findAll() {
        List<Developer> developersFromA = findAllInA();
        List<Developer> developersFromB = findAllInB();

        if(developersFromA.size() != developersFromB.size()) {
            throw new AsyncXAResourceException("XA resources do not contain the same expected data");
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Developer findById(Long id) {
        return null;
    }

    @Override
    public Developer save(Developer developer) {
        Developer developerB = new Developer();
        developerB.setName(developer.getName());
        developerB.setFounded(developer.getFounded());
        if(developer.getId() == null) {
            emA.persist(developer);
            if(true) {
                // Simulating exception to test transaction rollback
                throw new JpaSystemException(new PersistenceException("Simulation of something going wrong"));
            }
            emB.persist(developerB);
        } else {
            emA.merge(developer);
            emB.merge(developer);
        }

        return developer;
    }

    @Override
    public int countAll() {
        return 0;
    }

    private List<Developer> findAllInA() {
        return emA.createQuery("select d from Developer d").getResultList();
    }

    private List<Developer> findAllInB() {
        return emB.createQuery("select d from Developer d").getResultList();
    }
}
