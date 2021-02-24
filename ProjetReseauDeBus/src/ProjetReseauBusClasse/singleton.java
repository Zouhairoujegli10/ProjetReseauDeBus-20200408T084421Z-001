package ProjetReseauBusClasse;

public class singleton {

	private static reseauBus ResauDeBus;

	
	public static reseauBus getInstance(String nom)
	{
		if(ResauDeBus == null)
		{
			ResauDeBus = new reseauBus();
		}
		return ResauDeBus;
	}
	
}
