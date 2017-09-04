package com.k2.dao;

import static com.k2.entity.HibernateUtil.getSessionFactory;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.k2.entity.Layer;
import com.k2.exception.ServiceException;

@Transactional
@Repository
public class LayerDaoImplementation implements LayerDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	private Session session;

	public void setSession(Session session){this.session = session;}


	@Override
	public void addLayerFile(Layer p) throws ServiceException {
		if (this.sessionFactory == null)
		{
			this.sessionFactory = getSessionFactory();
		}
		Session session = this.sessionFactory.getCurrentSession();
		try
		{
			session = sessionFactory.openSession();	
			session.beginTransaction();
			session.persist(p);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			throw new ServiceException(e);
		}
		finally
		{
			if(session !=null && session.isOpen())
			{
				session.close();
				session=null;
			}
		}		
	}

	@Override
	public void updateLayerFile(Layer p) throws ServiceException {

		if (this.sessionFactory == null)
		{
			this.sessionFactory = getSessionFactory();
		}
		Session session = this.sessionFactory.getCurrentSession();
		try
		{
			session = sessionFactory.openSession();	
			session.beginTransaction();
			session.update(p);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			throw new ServiceException(e);
		}
		finally
		{
			if(session !=null && session.isOpen())
			{
				session.close();
				session=null;
			}
		}		
	}

	@Override
	public List<Layer> getRegioni() throws ServiceException {

			if (this.sessionFactory == null)
			{
				this.sessionFactory = getSessionFactory();
			}
			Session session = this.sessionFactory.getCurrentSession();
			List<Layer> listLayer = null;
			try 
			{
				session = sessionFactory.openSession();
				listLayer = session.createNamedQuery("Layer.findRegioni", Layer.class).list();

			}catch(Exception e)
			{
				System.out.println(e.getMessage());
				throw new ServiceException(e);
			}
			finally
			{
				if(session !=null && session.isOpen())
				{
					session.close();
					session=null;
				}
			}
			return listLayer;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<Layer> listLayer() throws ServiceException {

		if (this.sessionFactory == null)
		{
			this.sessionFactory = getSessionFactory();
		}
		Session session = this.sessionFactory.getCurrentSession();
		List<Layer> listLayer = null;
		try 
		{
			session = sessionFactory.openSession();
			listLayer = session.createQuery(" from Layer").list();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			throw new ServiceException(e);
		}
		finally
		{
			if(session !=null && session.isOpen())
			{
				session.close();
				session=null;
			}
		}
		return listLayer;
	}

	@Override
	public Layer getLayerById(long id) throws ServiceException {
		if (this.sessionFactory == null)
		{
			this.sessionFactory = getSessionFactory();
		}
		Session session = this.sessionFactory.getCurrentSession();
		Layer d = null;
		try
		{
			session = sessionFactory.openSession();	
			d = (Layer) session.load(Layer.class, new Long(id));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			throw new ServiceException(e);
		}
		finally
		{
			if(session !=null && session.isOpen())
			{
				session.close();
				session=null;
			}
		}
		return d;
	}

	@Override
	public 	List<Layer> getLayersBycodice(String codice, int tipo)
			throws ServiceException {

		if (this.sessionFactory == null)
		{
			this.sessionFactory = getSessionFactory();
		}
		Session session = this.sessionFactory.getCurrentSession();
		List<Layer> listLayer = null;
		try 
		{
			session = sessionFactory.openSession();
			listLayer = session.createQuery(" from Layer where codice like '" + codice +"|%' and nome not like '% Asc %' and nome not like '% Ace %' and tipo="+tipo+" order by nome").list();


//			CriteriaBuilder builder = session.getCriteriaBuilder();
//			// Create CriteriaQuery
//			CriteriaQuery<Layer> cri = builder.createQuery(Layer.class);
//			Criterion c1 = Restrictions.like("stateName", "Virg", MatchMode.END);
//			
//			List<Layer> studentsNameList = session.createQuery(cri).getResultList();
//			((Criteria) cri).add(c1);
			
			
//			session = sessionFactory.openSession();
//			Criteria criteria = session.createCriteria(Layer.class);
//			//List<Device> devs = criteria.add(Restrictions.eq("udid", udid)).list();
//			List<Layer> listLayers2 = (List<Layer>) criteria.add(Restrictions.ilike("codice", codice, MatchMode.END)).list();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			throw new ServiceException(e);
		}
		finally
		{
			if(session !=null && session.isOpen())
			{
				session.close();
				session=null;
			}
		}
		return listLayer;
	}



	@Override
	public void removeLayer(long id) throws ServiceException {
		if (this.sessionFactory == null)
		{
			this.sessionFactory = getSessionFactory();
		}
		Session session = this.sessionFactory.getCurrentSession();
		try
		{
			session = sessionFactory.openSession();	
			session.beginTransaction();
			Layer d = (Layer) session.load(Layer.class, new Long(id));
			if(null != d){
				session.delete(d);
			}
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			throw new ServiceException(e);
		}
		finally
		{
			if(session !=null && session.isOpen())
			{
				session.close();
				session=null;
			}
		}
	}






}
