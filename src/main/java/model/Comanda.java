package model;

public class Comanda {
private int id;
private int cantitate;
private int idclient;
private int idprodus;
/**
 * 
 * @param id
 * @param cantitate
 * @param idclient
 * @param idprodus
 */
public Comanda(int id,int cantitate,int idclient,int idprodus)
{
	this.id=id;
	this.cantitate=cantitate;
	this.idclient=idclient;
	this.idprodus=idprodus;
}
/**
 * 
 * @return int 
 */
public int getIdComanda()
{
	return this.id;
}
/**
 * 
 * @return int 
 */
public int getCantitate()
{
	return this.cantitate;
}
/**
 * 
 * @return int 
 */
public int getIdClient()
{
	return this.idclient;
}
/**
 * 
 * @return int 
 */
public int getIdProdsComanda()
{
	return this.idprodus;
}
/**
 * 
 * @param id
 */
public void setIdComanda(int id)
{
	this.id=id;
}
/**
 * 
 * @param cantitate
 */
public void setCantitate(int cantitate)
{
	this.cantitate=cantitate;
}
/**
 * 
 * @param idclient
 */
public void setidclient(int idclient)
{
	this.idclient=idclient;
}
/**
 * 
 * @param idprodus
 */
public void setidprodus(int idprodus)
{
	this.idprodus=idprodus;
}
/**
 * @return String
 */
public String toString()
{
	return "Id comanda: "+this.id+" cantitate: "+this.cantitate+" id client: "+this.idclient+" id produs: "+this.idprodus;
}
}
