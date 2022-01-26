package com.retrolad.ch07.dao;

import com.retrolad.ch07.entities.Developer;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Repository("developerDao")
public class DeveloperDaoImpl implements DeveloperDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public List<Developer> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Developer").list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Developer> findAllWithGame() {
        return sessionFactory.getCurrentSession()
                .getNamedQuery("Developer.findAllWithGame")
                .list();
    }

    @Override
    @Transactional(readOnly = true)
    public Developer findById(Long id) {
        return (Developer) sessionFactory.getCurrentSession()
                .getNamedQuery("Developer.findById")
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public Developer save(Developer developer) {
        return null;
    }

    @Override
    public void delete(Developer developer) {

    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
