package com.mybooks.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybooks.ds.BookDs;

/**
 * Provides persistence operations on Book objects
 * This version uses Hibernate session factory to manage database operations
 */
@Repository
public class BookRepositoryImpl implements BookRepository {

	@Autowired
	private SessionFactory sessionFactory;
	

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BookDs> getAll() {
		Criteria crit = getCurrentSession().createCriteria(BookDs.class);
		return crit.list();
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(BookDs bookDs) {
		getCurrentSession().save(bookDs);
		
	}
	
	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
}

