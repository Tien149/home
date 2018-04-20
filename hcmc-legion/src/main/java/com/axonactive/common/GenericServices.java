package com.axonactive.common;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericServices<E, B> {

    private final Class<E> entityClass;
    @PersistenceContext(name = "abc")
	protected
    EntityManager em;

    public GenericServices(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void save(E entity) {
        if (entity != null) {
             this.em.persist(entity);
        }
    }
    public void update(E entity){
    	  		this.em.merge(entity); 
    }

    public void flush() {
        this.em.flush();
    }

    public void removeEntity(E entity){
    	this.em.remove(entity);
    }
    
    public void remove(Integer id) {
        E entity = findById(id);
        if (entity != null) {
            em.remove(entity);
        }
    }
    
    public E findById(Integer id) {
        return em.find(entityClass, id);
    }

    public abstract E toEntity(B bom);

    public abstract B toBom(E entity);

    public List<E> toEntities(List<B> boms) {
        if (boms == null) {
            return null;
        }
        List<E> entities = new ArrayList<>();
        boms.stream().map((each) -> toEntity(each)).filter((entity) -> (entity != null)).forEach((entity) -> {
            entities.add(entity);
        });
        return entities;
    }

    public List<B> toBoms(List<E> entities) {
        if (entities == null) {
            return null;
        }
        List<B> boms = new ArrayList<>();
        entities.stream().map((each) -> toBom(each)).filter((bom) -> (bom != null)).forEach((bom) -> {
            boms.add(bom);
        });
        return boms;
    }

}
