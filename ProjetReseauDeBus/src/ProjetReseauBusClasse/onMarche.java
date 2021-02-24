package ProjetReseauBusClasse;

public class onMarche extends etat{

	public onMarche() {
		nom = "onMarche";
	}
	@Override
	public void CharDech(String Nom, String arretActuel, String direction, String nomLigne) {
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("Linge : "+nomLigne+" \n\t Bus : "+Nom+" \n\t Etat : en marche() \n\t Destination : "+direction+" \n\t Info : il ne peut pas faire un arret !!!!");
	}
	@Override
	public void Rouler(String Nom, String prochainArret, String direction, String nomLigne, int tempsArrrivee) {
System.out.println("\n---------------------------------------------------------------------------");		
System.out.println("Ligne : "+nomLigne+" \n\t Bus : "+Nom+" \n\t Etat : en marche() \n\t Destination : "+direction+" \n\t\t Prochain arret : "+prochainArret+" \n\t\t Temps d'arrivee : "+(tempsArrrivee/10)+" minutes");
	}
	
}
