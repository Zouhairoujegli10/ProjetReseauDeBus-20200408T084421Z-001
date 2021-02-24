 package ProjetReseauBusClasse;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
            
		
		ArretDAO arretD = DAOFactory.getArretDAO();
                BusDAO busD = DAOFactory.getbusDAO();
                LigneBusDAO ligneD = DAOFactory.getLigneBusDAO();
                ArrayList<arret> arrets = arretD.findAll();
                ArrayList<bus> bus = busD.findAll();
                ArrayList<ligneBus> LigneBus = ligneD.findAll();
                
                for(arret a:arrets){
                    System.out.println("arret : "+a.getNom()+" position X : "+a.getPositionX()+" position y : "+a.getPositionY());
                }
                
                for(bus b:bus){
                    System.out.println("NomBus : "+b.getNom()+" etat : "+b.getEtat()+" ligne : "+b.getLigneId());
                }
               
                
                for(ligneBus l:LigneBus){
                    System.out.println("nomLigneBus : "+l.getNom());
                        for(int i = 0;i<l.getNbreArret();i++){
                        System.out.println("arret : "+l.getArret(i).getNom());
                    }
                }
               
            /* 
                arret art1 = new arret("Art01", 0, 0);
                arret art2 = new arret("Art02", 0, 2);
                arret art3 = new arret("Art03", 0, 4);
                arret art4 = new arret("Art04", 0, 6);
        
                ligneBus lb01 = new ligneBus("A1");
                ligneBus lb02 = new ligneBus("B2");
                
                lb01.addArret(art1);
                lb01.addArret(art3);
		lb02.addArret(art2);
                lb02.addArret(art4);
                
                bus b1 = new bus("b1", "A1");
                bus b2 = new bus("b2", "B2");
                
                busD.create(b1);
                busD.create(b2);
                
                lignD.create(lb01);
                lignD.create(lb02);
                
                */
	}

}
