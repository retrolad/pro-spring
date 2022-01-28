package com.retrolad.ch08.service;

import com.retrolad.ch08.view.DeveloperSummary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("developerSummaryService")
@Repository
@Transactional
public class DeveloperSummaryServiceImpl implements DeveloperSummaryService {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<DeveloperSummary> findAll() {
        return em.createQuery(
                "select new com.retrolad.ch08.view" +
                        ".DeveloperSummary(d.name, g.title, g.releaseDate) " +
                        "from Developer d left join d.games g " +
                        "where g.releaseDate=(select max(g2.releaseDate) " +
                        "from Game g2 where g2.developer.id = d.id)",
                DeveloperSummary.class
        ).getResultList();
    }
}
