package bll;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JTable;

import com.mysql.cj.xdevapi.Table;

import dao.ClientDao;
import dao.ComandaDao;
import dao.ProdusDao;
import model.Client;
import model.Comanda;
import model.Produs;

public class ComandaBLL {
ComandaDao comanda;

/**
 * 
 * @param comanda 
 * Constructorul clasei care are ca si parametru un obiect de tip ComandaDao
 */
 public ComandaBLL(ComandaDao comanda)
 {
	 this.comanda=comanda;
 }
 /**
  * Parametrii in functie de care se va realiza insert-ul
  * @param id
  * @param cantitate
  * @param idclient
  * @param idprodus
  */
  public void insert(int id,int cantitate,int idclient,int idprodus)
  {
	  Comanda com=new Comanda(id,cantitate,idclient,idprodus);
	  comanda.insert(com);
  }
  /**
   * ID-ul persoanei care va fi stearsa
   * @param id
   */
  public void delete(int id)
  {
	  comanda.delete(id);
  }
  /**
   * Datele in functie de care se va dace update
   * @param id
   * @param cantitate
   * @param idclient
   * @param idprodus
   */
  public void update(int id,int cantitate,int idclient,int idprodus)
  {
	  Comanda com=new Comanda(id,cantitate,idclient,idprodus);
	  comanda.update(com);
  }
  /**
   * Metoda returneaza un tabel care contine toate datele din tabele comeni
   * @return JTable
   */
  public JTable findall()
  {   
	  return comanda.addtable(comanda.getAllCom());
  }
  
  /**
   * Metoda realizeaza o chitanta care va fi afisata intr-un text file. Aceasta chitanta va contine informatii
   * despre produsul de la idprodus si despre clientul de la idclient
   * @param id
   * @param cantitate
   * @param idclient
   * @param idprodus
   */
  public boolean chitatnta(int id,int cantitate,int idclient,int idprodus)
  {
	 boolean ok=false;
	  String fileName="Chitanta.txt";
	  try {
		PrintWriter output=new PrintWriter(fileName);
		ProdusDao prod=new ProdusDao();
		Produs produs=prod.findById(idprodus);
		ClientDao cli=new ClientDao();
		Client client=cli.findById(idclient);
		Comanda com=comanda.findById(id);
		if (produs.getNrProduse()>=com.getCantitate()) {
	    int produseramase=produs.getNrProduse()-com.getCantitate();
		produs.setNrprod(produseramase);
		output.println("Id-ul comenzii dumeneavoastra este:\n"+com.getIdComanda());
		output.println("Date client:\n");
		output.println("Nume:\n"+client.getNumeClient());
		output.println("Prenume:\n"+client.getPrenume());
		output.println("Date produs:\n");
		output.println("Nume produs:\n"+produs.getNumeProdus());
		output.println("Pret:\n"+produs.getPret());
		output.close();
		ok=true;
		return ok;
		}
		else
		{
			output.print("Comanda nu s-a putut efectua!");
			output.close();
		return ok;	
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return ok;
  }
}
