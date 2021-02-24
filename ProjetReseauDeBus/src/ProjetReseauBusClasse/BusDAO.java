package ProjetReseauBusClasse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BusDAO extends DAO<bus>{

	public BusDAO(Connection con) {
	super(con);
	}
	
	@Override
	public ArrayList<bus> findAll() {
		ArrayList<bus> buss = new ArrayList<bus> ();
		try {
                            requete = "SELECT * FROM bus";
			state = (Statement) connect.createStatement();
			resultat = state.executeQuery(requete);
			
			
			bus bss = null;
			while(resultat.next()) 
			{
			bss = new bus(resultat.getString("NomBus"));
			if(resultat.getString("NomLigne") != null)
			{bss.setLigneId(resultat.getString("NomLigne"));}
			buss.add(bss); 
			}
		state.close();
		resultat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return buss;
	}
	
        public ArrayList<bus> findByEtat(int option) {
		ArrayList<bus> buss = new ArrayList<bus> ();
		try {
                        switch(option)
                        {case 0 :
			requete="SELECT * FROM bus WHERE Etat = 'onStop'";break;
                        case 1 :
                            requete="SELECT * FROM bus WHERE Etat = 'onMarche'";break;
                        default:
                            requete = "SELECT * FROM bus";break;
                        }
			
			state = (Statement) connect.createStatement();
			resultat = state.executeQuery(requete);
			
			
			bus bss = null;
			while(resultat.next()) 
			{
			bss = new bus(resultat.getString("NomBus"));
			if(resultat.getString("NomLigne") != null)
			{bss.setLigneId(resultat.getString("NomLigne"));}
			buss.add(bss); 
			}
		state.close();
		resultat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return buss;
	}
@Override
public bus findById(String id) {
	bus bss= null;
	try {
		state = (Statement) connect.createStatement();
		
		requete="SELECT * FROM bus WHERE  NomBus = ?";
		
		requetePreparee= (PreparedStatement) connect.prepareStatement(requete);
	
		requetePreparee.setString(1,id);
		
		resultat=requetePreparee.executeQuery();

		if(resultat.first()) 
		{
			bss = new bus(resultat.getString("NomBus"), resultat.getString("NomLigne"));
		}
		else {System.out.println("Le Bus "+id+" n'existe pas dans la base de donn�es !!!! ");}
		
		requetePreparee.close();
		resultat.close();
		state.close();
	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return bss;
}

	@Override
	public boolean create(bus obj) {
		 boolean ok=false;
			
			if(findById(obj.getNom()) == null)
			{
			
			try {
				state = (Statement) connect.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
				requete="INSERT INTO bus (NomBus,NomLigne) VALUES (?,?)";
				requetePreparee= (PreparedStatement) connect.prepareStatement(requete);
				requetePreparee.setString(1,obj.getNom());
				requetePreparee.setString(2,obj.getLigneId());
				if(requetePreparee.executeUpdate()!=0) 
				{ok=true;
				System.out.println("Le bus "+obj.getNom()+" est ajout� � la base de donn�es avec succ�s");
				} 
				
				requetePreparee.close();
				state.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			}
			else {System.out.println("Le bus "+obj.getNom()+" existe d�j� dans la base de donn�es !!!");}
			return ok;
	}

	@Override
	public boolean update(bus obj) {
 
		boolean ok = false;
		
		if(findById(obj.getNom()) != null)
		{
		
		try {
			state = (Statement) connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			requete="UPDATE  bus SET NomLigne = ?, Etat = ? WHERE NomBus = ?";
			requetePreparee= (PreparedStatement) connect.prepareStatement(requete);
			requetePreparee.setString(1,obj.getLigneId());
                        requetePreparee.setString(2,obj.getEtat());
			requetePreparee.setString(3,obj.getNom());
			
			if(requetePreparee.executeUpdate()!=0) 
			{ok=true;
			System.out.println("Le bus "+obj.getNom()+" est mis � jour avec succ�s");
			} 
			
			requetePreparee.close();
			state.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		}
		else {System.out.println("Le bus "+obj.getNom()+" n'existe pas dans la base de donn�es !!!");}
		return ok;
	}

	@Override
	public boolean delete(bus obj) {
		
		return false;
	}

	
}
