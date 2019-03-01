package com.spring.petclinic.services.map;

import com.spring.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbastractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T t) {

        if(t != null){
            if(t.getId() == null){
                t.setId(this.getNextId());
            }
            map.put(t.getId(), t);
        }

        return t;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T t) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(t));
    }

    private Long getNextId() {
        Long result = null;
        try{
            result = Collections.max(map.keySet())+1;
        } catch (NoSuchElementException e) {
            result = 1L;
        }
        return result;
    }
}
