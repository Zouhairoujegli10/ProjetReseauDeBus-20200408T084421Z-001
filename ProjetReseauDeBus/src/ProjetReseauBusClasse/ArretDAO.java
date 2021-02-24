package ProjetReseauBusClasse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ArretDAO extends DAO<arret>{

	public ArretDAO(Connection con) {
	  super(con);
	}
	
	@Override
	public ArrayList<arret> findAll() {
     
		ArrayList<arret> arrets = new ArrayList<arret>();
		try {
             
			requete="SELECT * FROM arret";
			
			
			state = (Statement) connect.createStatement();
			resultat = state.executeQuery(requete);
			
			
			arret art = null;
			while(resultat.next()) 
			{art = new arret(resultat.getString("NomArret"),resultat.getDouble("PositionX"), resultat.getDouble("PositionY"));
             arrets.add(art); 
			}
		state.close();
		resultat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return arrets;
	}
	
	
	@Override
	public boolean create(arret obj) {
            boolean ok=false;
		
		if(findById(obj.getNom()) == null)
		{
		
		try {
			state = (Statement) connect.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			requete="INSERT INTO arret (NomArret,PositionX,PositionY) VALUES (?,?,?)";
			requetePreparee= (PreparedStatement) connect.prepareStatement(requete);
			requetePreparee.setString(1,obj.getNom());
			requetePreparee.setDouble(2,obj.getPositionX());
			requetePreparee.setDouble(3,obj.getPositionY());
			if(requetePreparee.executeUpdate()!=0) 
			{ok=true;
			System.out.println("L'arret "+obj.getNom()+" est ajout� � la base de donn�es avec succ�s");
			}
			
			requetePreparee.close();
			state.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		}
		else {System.out.println("L'arret "+obj.getNom()+" existe d�j� dans la base de donn�es !!!");}
		return ok;
		
	}
	
	@Override
	public boolean delete(arret obj) {
		 			return false;
	}
	
@Override
public arret findById(String id) {

	arret art = null;
	try {
		state = (Statement) connect.createStatement();
		
		requete="SELECT * FROM arret WHERE NomArret = ?";
		
		requetePreparee= (PreparedStatement) connect.prepareStatement(requete);
	
		requetePreparee.setString(1,id);
		
		resultat=requetePreparee.executeQuery();

		if(resultat.first()) 
		{
			art = new arret(resultat.getString("NomArret"), resultat.getDouble("PositionX"),resultat.getDouble("PositionY"));
		}
		else {System.out.println("L'arret "+id+" n'existe pas dans la base de donn�es !!!! ");}
		
		requetePreparee.close();
		resultat.close();
		state.close();
	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return art;
}

	@Override
	public boolean update(arret obj) {
		
		return false;
	}
	
}
