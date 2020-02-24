package model;

public class Client {
private int id;
private String nume;
private String prenume;
public Client() {}
/**
 * 
 * @param id
 * @param nume
 * @param prenume
 */
 public Client(int id,String nume,String prenume)
 {
	 this.id=id;
	 this.nume=nume;
	 this.prenume=prenume;
 }
 /**
  * 
  * @return int 
  */
 public int getIdClient()
 {
	 return this.id;
 }
 /**
  * 
  * @return String 
  */
 public String getNumeClient()
 {
	 return this.nume;
 }
 /**
  * 
  * @return String 
  */
 public String getPrenume()
 {
	 return this.prenume;
 }
 /**
  * 
  * @param id
  */
 public void setID(int id)
 {
	 this.id=id;
 }
 /**
  * 
  * @param nume
  */
 public void setNume(String nume)
 {
	 this.nume=nume;
 }
 /**
  * 
  * @param prenume
  */
 public void setPrenume(String prenume)
 {
	 this.prenume=prenume;
 }
 /**
  * @return String
  */
 public String toString()
 {
	 return "Client id:"+this.id+" nume:"+this.nume+" eami"+this.prenume;
 }
}
