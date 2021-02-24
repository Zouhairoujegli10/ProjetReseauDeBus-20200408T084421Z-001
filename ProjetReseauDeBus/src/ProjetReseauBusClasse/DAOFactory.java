package ProjetReseauBusClasse;

import java.sql.Connection;

public class DAOFactory {

	protected static final Connection con = Connexion.getConnection();
	
	public static BusDAO getbusDAO()
	{
		return new BusDAO(con);
	}
	
	public static LigneBusDAO getLigneBusDAO()
	{
		return new LigneBusDAO(con);
	}
	
	public static ArretDAO getArretDAO()
	{return new ArretDAO(con);}
	
}
