package com.example.search;

/**
 * Created by Fayzan on 15/04/2017.
 */

//@Repository
//@Transactional
//public class ItemSearch {
//    // ------------------------
//    // PRIVATE FIELDS
//    // ------------------------
//
//    // Spring will inject here the entity manager object
//    @PersistenceContext
//    private EntityManager entityManager;
//
//
//    // ------------------------
//    // PUBLIC METHODS
//    // ------------------------
//
//    /**
//     * A basic search for the entity User. The search is done by exact match per
//     * keywords on fields name, city and email.
//     *
//     * @param text The query text.
//     */
//    public List<Item> search(String text) {
//
//        // get the full text entity manager
//        FullTextEntityManager fullTextEntityManager =
//                org.hibernate.search.jpa.Search.
//                        getFullTextEntityManager(entityManager);
//
//        // create the query using Hibernate Search query DSL
//        QueryBuilder queryBuilder =
//                fullTextEntityManager.getSearchFactory()
//                        .buildQueryBuilder().forEntity(Item.class).get();
//
//        // a very basic query by keywords
//        org.apache.lucene.search.Query query =
//                queryBuilder
//                        .keyword()
//                        .onFields("name", "city", "email")
//                        .matching(text)
//                        .createQuery();
//
//        // wrap Lucene query in an Hibernate Query object
//        org.hibernate.search.jpa.FullTextQuery jpaQuery =
//                fullTextEntityManager.createFullTextQuery(query, Item.class);
//
//        // execute search and return results (sorted by relevance as default)
//        @SuppressWarnings("unchecked")
//        List<Item> results = jpaQuery.getResultList();
//
//        return results;
//    } // method search

//}
