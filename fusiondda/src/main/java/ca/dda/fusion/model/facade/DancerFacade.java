package ca.dda.fusion.model.facade;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ca.dda.fusion.model.entity.Dancer;

@Stateless
public class DancerFacade {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	public DancerFacade() {

	}

	public List<Dancer> findAllDancersByName() {
		System.out.println("Entity Manager " + em);
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Dancer> criteria = cb.createQuery(Dancer.class);
		Root<Dancer> dancer = criteria.from(Dancer.class);
		// Swap criteria statements if you would like to try out type-safe
		// criteria queries, a new
		// feature in JPA 2.0
		// criteria.select(dancer).orderBy(cb.asc(dancer.get(dancer_.name)));
		criteria.select(dancer).orderBy(cb.asc(dancer.get("lastName")))
				.orderBy(cb.asc(dancer.get("firstName")));
		return em.createQuery(criteria).getResultList();
	}

	public List<Dancer> findAllDancersByName(String letter) {
		System.out.println("Entity Manager " + em);

		Query query = em
				.createQuery("select o from Dancer o where UPPER(o.lastName) like UPPER(:lname) ");
		query.setParameter("lname", letter + "%");

		return query.getResultList();
	}

	public void saveEntity(Dancer entity) {
		// Dancer retrunEntity;
		if (entity.getDancerId() == 0) {
			em.persist(entity);
		} else {
			em.merge(entity);
		}
		// return entity;

	}
}
