package ProjetReseauBusClasse;

public class condition implements Observateur{

	private int tempsCharDech, tempsDeuxArrets;
	
	public int getTempsChDch()
	{return tempsCharDech;}
   
	public int getTempsDeuxArrets() {
		return tempsDeuxArrets;
	}
	
	@Override
	public void miseAjour(etat et) {
		if(et.getClass().toString() == "OnStop")
		{tempsCharDech = (int) (Math.random() * ((100 - 40) + 1));
		}
		else { tempsDeuxArrets = (int) (Math.random() * ((1000 - 300) + 1));
			
		}
		
	}
	


}
