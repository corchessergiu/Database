package bll;

import javax.swing.JTable;

import com.mysql.cj.xdevapi.Table;

import dao.ClientDao;
import model.Client;

public class ClientBLL {
	ClientDao client;
	/**
	 * 
	 * @param client- obiect de tip ClientDao
	 * 
	 */
   public ClientBLL(ClientDao client)
   {
	this.client=client;   
   }
   /**
    * 
    * @param id-in functie de acest id se va sterge din tabela
    * @return void
    */
   public void delete(int id)
   {
	   client.delete(id);
   }
   /**
    * Se va insera un nou client cu campurile id,nume,prenume
    * @param id
    * @param nume
    * @param prenume
    * @return void
    */
   public void insert(int id,String nume,String prenume)
   {
	   Client cli=new Client(id,nume,prenume);
	   client.insert(cli);
   }
   /**
    * Parametrii nume si prenume se vor modifica la Clientul cu id-ul introdus 
    * @param id
    * @param nume
    * @param prenume
    * @return void
    */
   public void update(int id,String nume,String prenume)
   {
	   Client cli=new Client(id,nume,prenume);
	   client.update(cli);
   }
   /**
    *  Metoda returneaza un tabel care contine datele returnate de metoda din clasa ClientDao
    * @return JTable
    */
  public JTable getall()
  {
	  return  client.addtable(client.getAllClienti());
  }
}
