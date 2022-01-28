package com.retrolad.ch08.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
import java.util.List;

@Service("developerSummaryUntype")
@Repository
@Transactional
public class DeveloperSummaryUntypeImpl {

    @PersistenceContext
    private EntityManager em;

    public void displayAllDeveloperSummary() {
        List result = em.createQuery(
                "select d.name, g.title, g.releaseDate " +
                        "from Developer d left join d.games g " +
                        "where g.releaseDate=(select max(g2.releaseDate) " +
                        "from Game g2 where g2.developer.id = d.id)"
        ).getResultList();
        int count = 0;
        for(Iterator i = result.iterator(); i.hasNext();) {
            Object[] values = (Object[])i.next();
            System.out.println(++count + ": " + values[0] + ", "
                               + values[1] + ", " + values[2]);
        }
    }
}
