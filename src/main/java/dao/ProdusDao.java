package dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;

import connection.ConnectionFactory;
import model.Produs;

public class ProdusDao extends AbstractDao<Produs>{
	/**
	 * Insereaza datele de la obiectul produs trimis ca si parametru in tabela produs
	 * @param produs
	 * @return Produs
	 */
	public Produs insert(Produs produs) {		
		 try {
			 Connection con=ConnectionFactory.getConnection();
			 PreparedStatement insertprodus=con.prepareStatement("insert into assigment3.produs values(?,?,?,?)");
			 insertprodus.setInt(1,produs.getIdProdus());
			 insertprodus.setString(2,produs.getNumeProdus());
			 insertprodus.setDouble(3,produs.getPret());
			 insertprodus.setInt(4, produs.getNrProduse());
			 insertprodus.executeUpdate();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return produs;
	}
	/**
	 * Sterge produsul de la id-ul id
	 * @param id
	 */
   public void delete(int id)
   {
	   try {
		   Connection con=ConnectionFactory.getConnection();
		   PreparedStatement deleteprod=con.prepareStatement("delete from assigment3.produs where id="+id);
		   deleteprod.executeUpdate();
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
   }
   /**
    * Realizeaza modificarea datelor pentru produsul care are id-ul id
    * @param produs
    * @return
    */
	public Produs update(Produs produs) {
		try {
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement updateprod=con.prepareStatement("update assigment3.produs set nume=?,pret=?,numarproduse=? where id=?");
			updateprod.setString(1, produs.getNumeProdus());
			updateprod.setDouble(2,produs.getPret());
			updateprod.setInt(3, produs.getNrProduse());
			updateprod.setInt(4, produs.getIdProdus());
			updateprod.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return produs;
	}
	/**
	 * Returneaza un arraylist de produse,toate produsele din tabela produs
	 * @return ArrayList<Produs>
	 */
	public ArrayList<Produs> getAllProd(){
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	ArrayList<Produs> allprodus=new ArrayList<Produs>();
	try {
		connection = ConnectionFactory.getConnection();
		statement = connection.prepareStatement("select * from assigment3.produs");
		resultSet = statement.executeQuery();
	    while(resultSet.next()) {
	    	int id = resultSet.getInt("id");
	    	String nume = resultSet.getString("nume");
	    	int pret  = resultSet.getInt("pret");
	    	int nrprod=resultSet.getInt("numarproduse");
	    	Produs produs = new Produs(id, nume, pret,nrprod);
	    	allprodus.add(produs);
	    }	
	} catch (SQLException e) {
		e.printStackTrace();
	} 
	return allprodus;
}
	 public Produs findById(int id)
	 {
			Connection connection = null;
			PreparedStatement statement = null;
			ResultSet resultSet = null;
			try {
				connection = ConnectionFactory.getConnection();
				statement = connection.prepareStatement("select * from assigment3.produs where id="+id);
				resultSet = statement.executeQuery();
			    while(resultSet.next()) {
			    	int idd = resultSet.getInt("id");
			    	String nume = resultSet.getString("nume");
			    	int pret  = resultSet.getInt("pret");
			    	int nrprod=resultSet.getInt("numarproduse");
			    	Produs produs = new Produs(id, nume, pret,nrprod);
			    	return produs;
			    }	
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			return null; 
	 }
}
