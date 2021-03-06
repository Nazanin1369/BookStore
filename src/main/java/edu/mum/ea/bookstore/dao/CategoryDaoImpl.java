/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.ea.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import edu.mum.ea.bookstore.domain.Category;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Hibernate based {@link CategoryRepository} implementation.
 *
 * @author Nazanin
 *
 */
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

    //@Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> findAll() {
        String hql = "select c from Category c order by c.name";
        Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
        query.setCacheable(true);
        return query.list();
    }

    @Override
    public Category findById(long id) {
        return (Category) this.sessionFactory.getCurrentSession().get(Category.class, id);
    }

    @Override
    public void storeCategory(Category category) {
        this.sessionFactory.getCurrentSession().save(category);
    }
}
