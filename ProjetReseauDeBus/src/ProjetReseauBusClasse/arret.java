package ProjetReseauBusClasse;

public class arret {
private String nomArret;
private double positionX, positionY;

public arret(String nomAr, double posX, double posY) {
nomArret = nomAr; positionX= posX;positionY = posY;
}

public String getNom()
{return nomArret;}

public double getPositionX()
{
	return positionX; }


public double getPositionY()
{
	return positionY; }
}
