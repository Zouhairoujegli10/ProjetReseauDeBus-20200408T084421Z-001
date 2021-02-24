package ProjetReseauBusClasse;

import ProjetReseauBusInterface.InterfaceUtilisateur;
import java.util.ArrayList;
import java.util.HashMap;

public class reseauBus {
    private String nomReseauBus = "RATP";
    private ArrayList<bus> listeBus;
    private ArrayList<ligneBus> LignesBus;
    private HashMap<String, busLigneBus> Services;
    private BusDAO busD = DAOFactory.getbusDAO();
    private LigneBusDAO ligneBusD = DAOFactory.getLigneBusDAO();

    
    
    public reseauBus() {
      listeBus = new ArrayList<bus>();
      LignesBus = new ArrayList<ligneBus>();
      Services = new HashMap<>(); 
      ChargerInfoReseau();
      
    }
    
    private void ChargerInfoReseau()
    {listeBus = busD.findAll();
    LignesBus = ligneBusD.findAll();
    ligneBus lBs;
    busLigneBus bsLB;
    for(bus Bs:listeBus)
    {lBs = ligneBusD.findById(Bs.getLigneId());
    bsLB = new busLigneBus(Bs, lBs);
    Services.put(Bs.getNom(), bsLB);	
    }
   
    }
    
    
    
    public void addBus(bus B)
    {listeBus.add(B);
    busD.create(B);
    }
    
    public void removeBus(bus B)
    {
    	listeBus.remove(B);
    	busD.delete(B);
    }
    
    public void addLigneBus(ligneBus LB)
    {LignesBus.add(LB);
    ligneBusD.create(LB);
    }
    
    private boolean contientBus(bus B)
    {
    for(bus Bs:listeBus)
    {   if (B.getNom().equals(Bs.getNom()))
	{
            return true;
	}
	}
    
    return false;	
    }
    
    private boolean contientLigne(ligneBus lb)
    {
    	for(ligneBus lg:LignesBus)
    	{if(lb.getNom().equals(lg.getNom()))
    	{   return true;}
    	}
    	
    	return false;
    	
    }
   
    public void affecterBusLigne(bus LeBus, ligneBus LaLigne)
    {
    	if(this.contientBus(LeBus) && this.contientLigne(LaLigne))
    	{	
    		if(Services.get(LeBus.getNom()) != null)
    		{
                if(LeBus.getLigneId()!=null)    
    		Services.get(LeBus.getNom()).Arreter();	
    		Services.remove(LeBus.getNom());
    		}
    	
    	listeBus.remove(LeBus);
    	LeBus.setLigneId(LaLigne.getNom());
    	listeBus.add(LeBus);
    	busD.update(LeBus);
    	
    	busLigneBus Affect = new busLigneBus(LeBus, LaLigne);
    	Services.put(LeBus.getNom(), Affect);
    	
    	}
    	else {
    		System.out.println("Le bus OU/ET la Ligne n'existe pas dans le reseau !!!!!!!!!!!");
    		}
    }
	
    public void miseHorsService(bus LeBus)
    {
    	busLigneBus BL = Services.get(LeBus.getNom());
    	if(BL != null)
    	{BL.Arreter();
    	}
    }

    public void miseHorsServiceTous()
    {    	busLigneBus service;
    	for(bus bs:listeBus)
    	{service = Services.get(bs.getNom());
    	service.Arreter();
    	}
    	
    	System.out.println("Le reseau "+nomReseauBus+" est hors service");
    
    }
    
    public void miseEnService(bus LeBus)
    {
    busLigneBus service = Services.get(LeBus.getNom());
    if(service != null)
    {	
    Thread th = new Thread(service);
    th.start();
    return;
    }	

     System.out.println("Le Bus n'existe pas ou il n'est pas affecte !!!!!!");
    	
    }
    public void miseEnServiceTout()
    {
    	System.out.println("Le r�seau "+nomReseauBus+" est mis en service");
    	for(bus b:listeBus)
    	{
    	Thread th = new Thread(Services.get(b.getNom()));
    	th.start();
    	}
    	
    }
   
    public ArrayList<ligneBus> getLignesBus()
    {return LignesBus;}
}
