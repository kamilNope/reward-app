package com.edge1.kamil.rewardapp.query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class RewardQueries {

    EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
    EntityManager entitymanager = emfactory.createEntityManager();

    //Between
    Query query = entitymanager.createQuery( "Select e " + "from Transaction e " + "where e.date " + "Between 30000 and 40000" );

}
