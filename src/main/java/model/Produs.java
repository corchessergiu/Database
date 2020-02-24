package model;

public class Produs {
private int id;
private String nume;
private double pret;
private int numarproduse;
/**
 * 
 * @param id
 * @param nume
 * @param pret
 */
public Produs(int id,String nume,double pret,int numarproduse)
{
	this.id=id;
	this.nume=nume;
	this.pret=pret;
	this.numarproduse=numarproduse;
}
/**
 * 
 * @return int
 */
public int getNrProduse()
{
	return this.numarproduse;
}
public void setNrprod(int nrprod)
{
	this.numarproduse=nrprod;
}
public int getIdProdus()
{
	return this.id;
}
/**
 * 
 * @return double
 */
public double getPret()
{
	return this.pret;
}
/**
 * 
 * @return String
 */
public String getNumeProdus()
{
	return this.nume;
}
/**
 * 
 * @param nume
 */
public void  setNumeProdus(String nume)
{
	 this.nume=nume;
}
/**
 * 
 * @param id
 */
public void  setId(int id)
{
	 this.id=id;
}
/**
 * 
 * @param pret
 */
public void  setpret(float pret)
{
	 this.pret=pret;
}
/**
 * @return String
 */
public String toString()
{
	return "Id produs:"+this.id+" nume produs:  "+this.nume+" pret: "+this.pret; 
}
}
