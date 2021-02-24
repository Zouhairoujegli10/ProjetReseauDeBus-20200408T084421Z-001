package ProjetReseauBusClasse;

public class bus extends sujet implements Observateur {

	private etat Etat;
	private String ligneId;
	private String nomBus;
	private condition conditionsBus;
	
	
	public bus(String nom) {
		nomBus = nom;
		ligneId = null;
		Etat = new onStop();
		conditionsBus = new condition();
		observers.add(conditionsBus);
		notifier(Etat);
	}
	
	public bus(String nom, String ligne) {
		nomBus = nom;
		ligneId = ligne;
		Etat = new onStop();
		conditionsBus = new condition();
		observers.add(conditionsBus);
		notifier(Etat);
	}
	
        public bus(String nom, String ligne, String et)
        {	nomBus = nom;
		ligneId = ligne;
                if(et.equals("onStop"))
                {Etat = new onStop();}
                else {
                Etat = new onMarche();
                }
		conditionsBus = new condition();
		observers.add(conditionsBus);
		notifier(Etat);
        }
        
	@Override
	public void miseAjour(etat et) {
		setEtat(et);
	}

	public void setEtat(etat et)
	{
		Etat = et;
		notifier(et);
	}
	
	public void CharDech(String arretActuel, String direction, String nomLigne)
	{Etat.CharDech(nomBus, arretActuel, direction, nomLigne);}
	
	public void Rouler(String prochainArret, String direction,String nomLigne, int tempsArrivee)
	{Etat.Rouler(nomBus, prochainArret, direction, nomLigne, tempsArrivee);}

	@Override
	public void notifier(etat et) {
		for(Observateur ob:observers)
		{ob.miseAjour(et);
			
		}
	}
	
	public condition getConditionsBus()
	{return conditionsBus;}
	
	public String getEtat()
	{return Etat.getNom();
	}
	
	public String getNom()
	{return nomBus;}
	
	public String getLigneId() {
		return ligneId;
	}
	
	public void setLigneId(String ligneId) {
		this.ligneId = ligneId;
	}
}
