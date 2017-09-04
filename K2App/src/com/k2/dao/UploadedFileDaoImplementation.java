package com.k2.dao;

import java.util.List;


import static com.k2.entity.HibernateUtil.getSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.k2.entity.UploadedFile;
import com.k2.exception.ServiceException;

@Transactional
@Repository
public class UploadedFileDaoImplementation implements UploadedFileDao{

	private static final Logger logger = Logger.getLogger(UploadedFileDaoImplementation.class);

	@Autowired//Messo dentro il Controller
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	private Session session;

	public void setSession(Session session){this.session = session;}


	@Override
	public void addUploadedFile(UploadedFile p) throws ServiceException {
		/*Senza @Autowired setSessionFactory non viene invocato qiuindi this.sessionFactory è nullo, 
	in questo caso lo valorizziamo con HibernateUtil.getSessionFactory()*/

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
	public void updateUploadedFile(UploadedFile p) throws ServiceException {

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
			logger.info("File updated successfully, Device Details="+p);
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
	public List<UploadedFile> listUploadedFile() throws ServiceException {

		if (this.sessionFactory == null)
		{
			this.sessionFactory = getSessionFactory();
		}
		Session session = this.sessionFactory.getCurrentSession();
		List<UploadedFile> UploadedFilesList = null;
		try 
		{
			session = sessionFactory.openSession();
			UploadedFilesList = session.createQuery(" from UploadedFile").list();
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
		return UploadedFilesList;
	}


	@Override
	public UploadedFile getUploadedFileById(long id) throws ServiceException {

		if (this.sessionFactory == null)
		{
			this.sessionFactory = getSessionFactory();
		}
		Session session = this.sessionFactory.getCurrentSession();
		UploadedFile d = null;
		try
		{
			session = sessionFactory.openSession();	
			d = (UploadedFile) session.load(UploadedFile.class, new Long(id));
			logger.info("Device loaded successfully, Device details="+d);
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
	public void removeUploadedFile(long id) throws ServiceException {

		if (this.sessionFactory == null)
		{
			this.sessionFactory = getSessionFactory();
		}
		Session session = this.sessionFactory.getCurrentSession();
		try
		{
			session = sessionFactory.openSession();	
			session.beginTransaction();
			UploadedFile d = (UploadedFile) session.load(UploadedFile.class, new Long(id));
			if(null != d){
				session.delete(d);
			}
			session.getTransaction().commit();
			logger.info("Device deleted successfully, device details="+d);
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
