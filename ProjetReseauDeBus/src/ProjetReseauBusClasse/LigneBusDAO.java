package ProjetReseauBusClasse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LigneBusDAO extends DAO<ligneBus>{
        protected ResultSet resultat1=null;
	private ArretDAO arretD = DAOFactory.getArretDAO();
	public LigneBusDAO(Connection con) {
	super(con);
	}
	
	@Override
	public ArrayList<ligneBus> findAll() {
		ArrayList<ligneBus> lignes = new ArrayList<ligneBus> ();
		try {
             
			requete="SELECT * FROM ligne";
			
			
			state = (Statement) connect.createStatement();
			resultat = state.executeQuery(requete);
			
			
			ligneBus lgnbs = null;
			while(resultat.next()) 
			{lgnbs = new ligneBus(resultat.getString("NomLigne"));
			requete="SELECT * FROM  lignearret WHERE lignearret.NomLigne = ?";

			requetePreparee= (PreparedStatement) connect.prepareStatement(requete);
		
			requetePreparee.setString(1,lgnbs.getNom());
			
			resultat1=requetePreparee.executeQuery();
            while(resultat1.next())
            {lgnbs.addArret(arretD.findById(resultat1.getString("NomArret")));
            }
			lignes.add(lgnbs); 
			}
		state.close();
		requetePreparee.close();
		resultat.close();
                resultat1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lignes;
	}
	
	@Override
	public boolean create(ligneBus obj) {
		 boolean ok=false;
			
                 
			if(findById(obj.getNom()) == null)
			{
			
			try {
				state = (Statement) connect.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
				requete="INSERT INTO ligne (NomLigne) VALUES (?)";
				requetePreparee= (PreparedStatement) connect.prepareStatement(requete);
				requetePreparee.setString(1,obj.getNom());
				if(requetePreparee.executeUpdate()!=0) 
				{ok=true;
				System.out.println("La ligne "+obj.getNom()+" est ajout� � la base de donn�es avec succ�s");
				} 
				
				for(int i=0; i<obj.getNbreArret();i++)
				{
                                        arretD.create(obj.getArret(i));
					requete="INSERT INTO lignearret (NomLigne, NomArret) VALUES (?,?)";
					requetePreparee= (PreparedStatement) connect.prepareStatement(requete);
					requetePreparee.setString(1,obj.getNom());
					requetePreparee.setString(2,obj.getArret(i).getNom());
                                if(requetePreparee.executeUpdate()!=0) 
				{ok=true;
				System.out.println("L'arret "+obj.getNom()+" est ajout� � la base de donn�es avec succ�s");
				} 
                                else {System.out.println("l'arret" +obj.getNom()+ "n'est pas ajouté");}
				}
				
				
				requetePreparee.close();
				state.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			}
			else {System.out.println("La ligne "+obj.getNom()+" existe d�j� dans la base de donn�es !!!");}
			return ok;
	}
	
	@Override
	public boolean delete(ligneBus obj) {

		return false;
	}
	
@Override
public ligneBus findById(String id) {

	ligneBus lgn = null;
	try {
                
            requete="SELECT * FROM  ligne WHERE NomLigne = ?";
            requetePreparee= (PreparedStatement) connect.prepareStatement(requete);
		requetePreparee.setString(1,id);
		resultat=requetePreparee.executeQuery();
                
            if(resultat.first())
                 {lgn = new ligneBus(id);
                 
            
		requete="SELECT * FROM  lignearret WHERE lignearret.NomLigne = ?";

		requetePreparee= (PreparedStatement) connect.prepareStatement(requete);
	
		requetePreparee.setString(1,id);
		resultat=requetePreparee.executeQuery();
	 
        while(resultat.next())
        {lgn.addArret(arretD.findById(resultat.getString("NomArret")));
        }
        }
        else {System.out.println("La ligne "+id+" n'existe pas dans la base de données");}
        
		requetePreparee.close();
		resultat.close();
	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return lgn;
}
	
	@Override
	public boolean update(ligneBus obj) {
		
		return false;
	}
	
	
}
