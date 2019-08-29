package am.itspace.hibernatesearchexample.service;


import am.itspace.hibernatesearchexample.model.User;
import org.apache.lucene.search.Query;


import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserService {

    @PersistenceContext
    private EntityManager entityManager;


    public List<User> searchUserByName(String name) {

        Query keywordQuery = getQueryBuilder()
                .keyword()
                .onField("name")
                .matching(name)
                .createQuery();


        return getJpaQuery(keywordQuery).getResultList();
    }

    public List<User> searchUserBySurname(String surname) {

        Query keywordQuery = getQueryBuilder()
                .keyword()
                .onField("surname")
                .matching(surname)
                .createQuery();


        return getJpaQuery(keywordQuery).getResultList();
    }

    public List<User> searchUserByCharacteristics(String phrase) {

        Query phraseQuery = getQueryBuilder()
                .phrase()
                .withSlop(1)
                .onField("characteristic")
                .sentence("good boy")
                .createQuery();


        return getJpaQuery(phraseQuery).getResultList();
    }

    public List<User> searchUserByAge(int fromAge,int toAge) {

        Query rangeQuery =  getQueryBuilder()
                .range()
                .onField("age")
                .from(fromAge).to(toAge)
                .createQuery();


        return getJpaQuery(rangeQuery).getResultList();
    }

    private FullTextQuery getJpaQuery(Query luceneQuery) {

        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

        return fullTextEntityManager.createFullTextQuery(luceneQuery, User.class);
    }

    private QueryBuilder getQueryBuilder() {

        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

        return fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(User.class)
                .get();
    }

}
