package ProjetReseauBusClasse;

import java.util.ArrayList;

public abstract class sujet {

	protected ArrayList<Observateur> observers = new ArrayList<Observateur>() ;
	public void addObservateur(Observateur obs) {
		observers.add(obs);
	};
	public void removeObservateur(Observateur obs) {
		observers.remove(obs);
	}
	public abstract void notifier(etat et);
		
	}

