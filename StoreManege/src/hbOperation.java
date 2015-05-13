import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;


public class hbOperation 
{
	private Session session;
	private org.hibernate.Transaction tx;
	
	public hbOperation()
	{
		startSession();
	}
	public Session getSession() {
		return session;
	}


	public void setSession(Session session) {
		this.session = session;
	}


	public org.hibernate.Transaction getTx() {
		return tx;
	}


	public void setTx(org.hibernate.Transaction tx) {
		this.tx = tx;
	}


	public Session openSession()
	{

		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sf.openSession();
		return session;
	}
	public org.hibernate.Transaction getTransaction(Session s)
	{
		org.hibernate.Transaction t= s.beginTransaction();
		return t;
	}
	public void startSession()
	{
		setSession(openSession());
		setTx(getTransaction(getSession()));
	}
	
	public void endSession()
	{
		getTx().commit();
		getSession().close();
	}
	
	public void saveOperation(Object ob)
	{
		//try
		//{
			getSession().save(ob);
		//}catch(Exception e)
	}
	public void updateOperation(Object ob)
	{
		getSession().update(ob);
	}
	
	public void delateOperation(Object ob)
	{
		getSession().delete(ob);
	}
	
	public java.util.List findOperation(String hql)
	{
		
		org.hibernate.Query query=session.createQuery(hql); 
		java.util.List list=query.list(); 
		return list;
		
	}
}
