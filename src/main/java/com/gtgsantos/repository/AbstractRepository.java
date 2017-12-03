package com.gtgsantos.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.gtgsantos.repository.util.JpaUtil;

public abstract class AbstractRepository<T> {
    
    private EntityManager manager = JpaUtil.getEntityManager();
    
    public void save(T entity) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(entity);
        transaction.commit();
        manager.close();
        JpaUtil.close();        }
}
