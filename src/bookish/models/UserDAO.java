package bookish.models;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.GenericJDBCException;

public class UserDAO {
	private static SessionFactory factory;
	
	private final byte[] salt = {32,5,23,4,22,23,35,42,3};
	private final int keyLength = 44;
	private final int iterations = 10;
	
	public UserDAO() throws Exception{
		try{
			factory = new Configuration().configure().buildSessionFactory();
		}catch(Exception e){
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public Integer addUser(String username, String password){
		Session session = factory.openSession();
		Transaction tx = null;
		Integer id = null;
		//salt the password and save
		try{
			tx = session.beginTransaction();
			String hashedPassword = hashPassword(password);
			User newuser = new User(username, hashedPassword, new Date());
			id = (Integer)session.save(newuser);
			tx.commit();
		}catch(HibernateException e){
			if(tx != null) tx.rollback();
			throw new RuntimeException("Username is already taken");
		}catch(Exception e){
			throw new RuntimeException("Could not hash password");
		}finally{
			session.close();
		}
		return id;
	}
	
	
	protected String hashPassword(String password) throws Exception{
		try {
	           SecretKeyFactory skf = SecretKeyFactory.getInstance( "PBKDF2WithHmacSHA512" );
	           PBEKeySpec spec = new PBEKeySpec( password.toCharArray(), this.salt, this.iterations, this.keyLength );
	           SecretKey key = skf.generateSecret( spec );
	           byte[] res = key.getEncoded( );
	           return Base64.encodeBase64String(res);
	 
	       } catch( NoSuchAlgorithmException | InvalidKeySpecException e ) {
	           throw new RuntimeException( "Could not secure your password!" );
	       }
	}
	
	
	
	
}
