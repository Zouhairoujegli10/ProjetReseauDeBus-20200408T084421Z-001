package ProjetReseauBusClasse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public abstract class DAO<T> {

	protected Connection connect;
	protected Statement state =null;
	protected ResultSet resultat=null;		
	protected PreparedStatement requetePreparee=null;
	protected String requete;
	
	public DAO(Connection con)
	{this.connect = con;}
	
	public abstract T findById(String id);
	public abstract ArrayList<T> findAll();
    public abstract boolean create(T obj);
    public abstract boolean update(T obj);
    public abstract boolean delete(T obj); 
	
}
