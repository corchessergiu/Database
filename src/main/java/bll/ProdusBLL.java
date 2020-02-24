package bll;

import java.sql.ResultSet;

import javax.swing.JTable;

import com.mysql.cj.xdevapi.Table;

import dao.ProdusDao;
import model.Produs;

public class ProdusBLL {
public ProdusDao produs;
/**
 * Contructorul clasei care are ca si parametru un obiect de tip ProdusDao
 * @param produs
 */
 public ProdusBLL(ProdusDao produs) {
	 this.produs=produs;
}
 /**
  * Parametrul id reprezinta variabila in functie de care se va realiza stergerea din tabela 
  * @param id
  */
    public void delete(int id)
    {
    	produs.delete(id);
    }
    /**
     * Parametrii in  functie de care se va realiza insert-ul
     * @param id
     * @param nume
     * @param pret
     */
    public void insert(int id,String nume,double pret,int nrprod)
    {
    	Produs prod=new Produs(id,nume,pret,nrprod);
    	produs.insert(prod);
    }
    /**
     * Se vor modifica datele pentru produsul de la id-ul id 
     * @param id
     * @param nume
     * @param pret
     */
    public void update(int id,String nume,double pret,int nrprod)
    {
    	Produs prod=new Produs(id,nume,pret,nrprod);
    	produs.update(prod);
    }
    /**
     * Se va returna un tabel care va contine datele despre produsele din tabela 
     * @return JTable
     */
    public JTable findall()
    {
  	   return  produs.addtable(produs.getAllProd());
    }
}
