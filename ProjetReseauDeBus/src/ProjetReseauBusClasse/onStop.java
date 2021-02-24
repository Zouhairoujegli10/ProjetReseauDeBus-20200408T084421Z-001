package ProjetReseauBusClasse;

public class onStop extends etat{

	
	public onStop() {
		nom = "onStop";
	}
	
	@Override
	public void CharDech(String Nom, String arretActuel,String direction,String nomLigne) {
		System.out.println("\n**************************************************************************************");
		System.out.println("Ligne : "+nomLigne+" \n\t Bus : "+Nom+" \n\t Destination : "+direction+" \n\t\t Etat : en arret() \n\t\t Arret Actuel : "+arretActuel);
	}
	@Override
	public void Rouler(String Nom, String prochainArret, String direction,String nomLigne, int tempsArrivee) {
System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
System.out.println("Ligne : "+nomLigne+" \n\t Bus : "+Nom+" \n\t Destination : "+direction+" \n\t\t Etat : en arret() \n\t\t Info : il ne peut pas rouler !!!!");
	}
	
	
}
