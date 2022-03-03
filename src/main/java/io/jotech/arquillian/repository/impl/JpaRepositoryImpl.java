package io.jotech.arquillian.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import io.jotech.arquillian.repository.JpaRepository;

@Transactional(Transactional.TxType.SUPPORTS)
public class JpaRepositoryImpl<T, ID> implements JpaRepository<T, ID> {
    Class<T> entityClass;

    public JpaRepositoryImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @PersistenceContext
    protected EntityManager em;

    @Transactional(Transactional.TxType.REQUIRED)
    @Override
    public T save(T t) {
         em.persist(t);
         return t;
    }

    @Override
    public T find(ID id) {
        return em.find(entityClass,id);
    }
    @Transactional(Transactional.TxType.REQUIRED)
    @Override
    public T update(T t) {
        return em.merge(t);
    }
    @Transactional(Transactional.TxType.REQUIRED)
    @Override
    public boolean delete(T t) {
         em.remove(em.merge(t));
        return true;
    }
    @Transactional(Transactional.TxType.REQUIRED)
    @Override
    public boolean deleteById(ID id) {
        var obj= find(id);
        if(obj!=null){
            em.remove(em.merge(obj));
            return true;
        }
        return false;
    }
}
