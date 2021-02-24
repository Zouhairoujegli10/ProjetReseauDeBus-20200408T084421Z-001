package ProjetReseauBusClasse;

import java.util.ArrayList;

public class ligneBus {
private String nomLigneBus;
private ArrayList<arret> Arrets;
private ArretDAO arretD = DAOFactory.getArretDAO(); 

public ligneBus(String nom) {
nomLigneBus = nom;
Arrets = new ArrayList<arret>();
}

public void addArret(arret art)
{Arrets.add(art);
	}

public arret getArret(int i)
{	return Arrets.get(i);}

public ArrayList<arret> getArrets()
{return Arrets;}

public int getNbreArret()
{return Arrets.size();}

public String getDestination(int sense)
{if(sense == 1)
	return Arrets.get(Arrets.size() - 1).getNom();
return Arrets.get(0).getNom(); 
	}

public String getNom()
{return nomLigneBus;}
}
