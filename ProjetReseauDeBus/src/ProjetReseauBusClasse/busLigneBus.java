package ProjetReseauBusClasse;

public class busLigneBus extends sujet implements Runnable{
    
	private boolean marche;
	private bus BusCourant;
	private ligneBus LigneBusCorant;
	private BusDAO busD = DAOFactory.getbusDAO();
public busLigneBus(bus Bus, ligneBus lgnBus) {
BusCourant = Bus;LigneBusCorant = lgnBus;marche = false;
observers.add(Bus);
}
	
	@Override
	public void notifier(etat et) {
		for(Observateur ob:observers)
		{
			ob.miseAjour(et);
		}
	}
	
	private void Demarrer()
	{
	int i = 0;
	String prochainArret, arretActuel;
    int tempsRestant;
		marche = true;
		int sense = 1;
		BusCourant.setEtat(new onMarche());
                busD.update(BusCourant);
		int nbreArret = LigneBusCorant.getNbreArret();
	    	
		while (marche)
		{
	if(BusCourant.getEtat() == "onMarche")
	{
		
		if(sense == 1) {
		prochainArret = LigneBusCorant.getArret(i+1).getNom();}
		else {prochainArret = LigneBusCorant.getArret(i-1).getNom();}
		int tmpEntreArrets = BusCourant.getConditionsBus().getTempsDeuxArrets();
		BusCourant.Rouler(prochainArret, LigneBusCorant.getDestination(sense),LigneBusCorant.getNom(), tmpEntreArrets);
	 for(tempsRestant = tmpEntreArrets; tempsRestant>=0; tempsRestant -=5)
	 {
	  try {
		Thread.sleep(100);
	} catch (Exception e) {
		
	}	 
	 }
	
	 notifier(new onStop());
	 if(sense == 1)
	 {
	 i++;}
	 else {i--;}
	 if(i >= nbreArret - 1) {sense = 0;i=nbreArret-1;}
	 if(i <= 0) {sense = 1;i=0;}
	}
	else {
		int tmpDechCh = BusCourant.getConditionsBus().getTempsChDch();
		arretActuel = LigneBusCorant.getArret(i).getNom();
		BusCourant.CharDech(arretActuel, LigneBusCorant.getDestination(sense),LigneBusCorant.getNom());
		 for(tempsRestant = tmpDechCh; tempsRestant>=0; tempsRestant --)
		 {
		  try {
			Thread.sleep(100);
		} catch (Exception e) {
			
		}	 
		 }
		 notifier(new onMarche());
	}
	
	}
	
	
	}

	public void Arreter() {
		marche = false;
                BusCourant.setEtat(new onStop());
                busD.update(BusCourant);
                System.out.println("Ligne : "+LigneBusCorant.getNom()+"\n\t Bus : "+BusCourant.getNom()+" Hors Service !!!!");
	}
	
	@Override
	public void run() {
	System.out.println("Ligne : "+LigneBusCorant.getNom()+"\n\t Bus : "+BusCourant.getNom()+" En Service ... ");	
	Demarrer();
	}
	
	public String getBus()
	{return BusCourant.getNom();}
	public String getLigne()
	{return LigneBusCorant.getNom();}

	
}
