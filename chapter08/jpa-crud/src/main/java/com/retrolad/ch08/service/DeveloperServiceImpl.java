package com.retrolad.ch08.service;

import com.retrolad.ch08.entities.Developer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service("jpaDeveloperService")
@Repository
@Transactional
public class DeveloperServiceImpl implements DeveloperService {

    final static String ALL_DEVELOPER_NATIVE_QUERY = "select id, name, founded, version " +
            "from developer";

    private static final Logger logger = LoggerFactory.getLogger(DeveloperServiceImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Developer> findAll() {
        return em.createNamedQuery(Developer.FIND_ALL, Developer.class).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Developer> findAllWithAlbum() {
        return em.createNamedQuery(Developer.FIND_ALL_WITH_GAME, Developer.class).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Developer findById(Long id) {
        TypedQuery<Developer> query = em.createNamedQuery(Developer.FIND_BY_ID, Developer.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Developer save(Developer developer) {
        if(developer.getId() == null) {
            logger.info("Inserting new developer");
            em.persist(developer);
        } else {
            em.merge(developer);
            logger.info("Updating existing developer");
        }
        logger.info("Developer saved with id: " + developer.getId());
        return developer;
    }

    @Override
    public void delete(Developer developer) {
        // Merge the state of the given entity into
        // the current persistence context
        Developer mergedDeveloper = em.merge(developer);
        em.remove(mergedDeveloper);

        logger.info("Developer with id: " + developer.getId()
                    + " deleted successfully");
    }

    @Transactional(readOnly = true)
    @Override
    public List<Developer> findAllByNativeQuery() {
        return em.createNativeQuery(ALL_DEVELOPER_NATIVE_QUERY, "singerResult").getResultList();
//        return em.createNativeQuery(ALL_DEVELOPER_NATIVE_QUERY, Developer.class).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Developer> findByCriteriaQuery() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Developer> criteriaQuery = cb.createQuery(Developer.class);
        Root<Developer> developerRoot = criteriaQuery.from(Developer.class);
//        developerRoot.fetch(Developer_.games, JoinType.LEFT);
        return new ArrayList<>();
    }
}
