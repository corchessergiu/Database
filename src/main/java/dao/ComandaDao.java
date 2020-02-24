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

import connection.ConnectionFactory;
import model.Comanda;
import model.Produs;

public class ComandaDao extends AbstractDao<Comanda>{
	/**
	 * Insereaza in tabela datele de la obiectul de tip Comanda primit ca parametru
	 * @param comanda
	 * @return Comanda
	 */
	public Comanda insert(Comanda comanda) {
		try {
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement insertcomanda=con.prepareStatement("insert into assigment3.comanda values(?,?,?,?)");
			insertcomanda.setInt(1,comanda.getIdComanda());
			insertcomanda.setInt(2,comanda.getCantitate());
			insertcomanda.setInt(3,comanda.getIdClient());
			insertcomanda.setInt(4,comanda.getIdProdsComanda());
			insertcomanda.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	return comanda;
	}
/**
 * Sterge datele de la comanda cu id id
 * @param id
 */
	public void delete(int id)
	{
		try {
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement deletecomanda=con.prepareStatement("delete from assigment3.comanda where id="+id);
			deletecomanda.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Insereaza datele in tabela comanda, datele fiind preluzate cu get-ere din obiectul de tip Comanda
	 * @param comanda
	 * @return Comanda
	 */
	public Comanda update(Comanda comanda) {
		try {
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement updatecom=con.prepareStatement("update assigment3.comanda  set cantitate=?,idclient=?,idprodus=? where id=?");
			updatecom.setInt(1,comanda.getCantitate());
			updatecom.setInt(2,comanda.getIdClient());
			updatecom.setInt(3,comanda.getIdProdsComanda());
			updatecom.setInt(4,comanda.getIdComanda());
			updatecom.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return comanda;
	}
	/**
	 * Returneaza o lista de comenzi, aceasta lista contine toate informatiile despre comenziile aflate in tabela Comanda
	 * @return ArrayList<Comana>
	 */
	public ArrayList<Comanda> getAllCom(){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		ArrayList<Comanda> allcomanda=new ArrayList<Comanda>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement("select * from assigment3.comanda");
			resultSet = statement.executeQuery();
		    while(resultSet.next()) {
		    	int id = resultSet.getInt("id");
		    	int cantitate= resultSet.getInt("cantitate");
		    	int idclient= resultSet.getInt("idclient");
		    	int idprodus=resultSet.getInt("idprodus");
		    	Comanda comanda = new Comanda(id,cantitate,idclient,idprodus);
		    	allcomanda.add(comanda);
		    }	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allcomanda;
	}
	/**
	 *  Returneaza datele pentru comanda de la id-ul specificat ca si parametru
	 * @param id
	 * @return Comanda
	 */
	  public Comanda findById(int id)
	  {
			Connection connection = null;
			PreparedStatement statement = null;
			ResultSet resultSet = null;
			try {
				connection = ConnectionFactory.getConnection();
				statement = connection.prepareStatement("select * from assigment3.comanda where id="+id);
				resultSet = statement.executeQuery();
			    while(resultSet.next()) {
			    	int idd= resultSet.getInt("id");
			    	int cantitate= resultSet.getInt("cantitate");
			    	int idclient= resultSet.getInt("idclient");
			    	int idprodus=resultSet.getInt("idprodus");
			    	Comanda comanda = new Comanda(idd,cantitate,idclient,idprodus);
			    return comanda;
			    }	
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	  }

}
