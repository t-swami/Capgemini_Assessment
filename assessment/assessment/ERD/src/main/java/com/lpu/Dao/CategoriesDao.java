package com.lpu.Dao;

//package com.lpu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.Categories;

//import com.lpu.entities.Categories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@Component
public class CategoriesDao {

    @Autowired
    private EntityManagerFactory emf;

    public void saveCategory(Categories c) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(c);
        et.commit();
        em.close();
    }

    public Categories findCategoryById(int id) {
        EntityManager em = emf.createEntityManager();
        Categories c = em.find(Categories.class, id);
        em.close();
        return c;
    }

    public void updateCategoryName(int id, String newName) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Categories c = em.find(Categories.class, id);
        c.setCategory_name(newName);

        et.begin();
        em.merge(c);
        et.commit();
        em.close();
    }

    public void deleteCategoryById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Categories c = em.find(Categories.class, id);

        et.begin();
        em.remove(c);
        et.commit();
        em.close();
    }
}
