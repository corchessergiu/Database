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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import connection.ConnectionFactory;
import model.Client;
import model.Produs;

public class ClientDao extends AbstractDao<Client> {
	/**
	 * 
	 * @param client
	 * @return Client
	 */
	public void insert(Client client) {		
		try {
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement insertclient=con.prepareStatement("INSERT into assigment3.client VALUES(?,?,?)");
			insertclient.setInt(1,client.getIdClient());
			insertclient.setString(2,client.getNumeClient());
			insertclient.setString(3,client.getPrenume());
			insertclient.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Sterge clientul de la id-ul id
	 * @param id
	 */
   public void delete(int id)
   {
		try {
			   Connection con=ConnectionFactory.getConnection();
			PreparedStatement delete=con.prepareStatement("delete from assigment3.client where id="+id); 
			delete.executeUpdate();
   }
		catch(Exception e) {
			e.printStackTrace();
		}
   }
   /**
    * 
    * @param client
    * @return Client
    */
	public Client update(Client client) {
		 try {
			 Connection con=ConnectionFactory.getConnection();
			 PreparedStatement update=con.prepareStatement("update assigment3.client  set nume=?, prenume=? where id=?");
			 update.setString(1,client.getNumeClient());
			 update.setString(2,client.getPrenume());
			 update.setInt(3,client.getIdClient());
			 update.executeUpdate();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return client;
	}
	/**
	 * 
	 * @return ArrayList<Client>
	 * Returneaza lista de clienti din tabela client
	 */
	public ArrayList<Client> getAllClienti(){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		ArrayList<Client> allclient=new ArrayList<Client>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement("select * from assigment3.client");
			resultSet = statement.executeQuery();
		    while(resultSet.next()) {
		    	int id = resultSet.getInt("id");
		    	String nume = resultSet.getString("nume");
		    	String prenume = resultSet.getString("prenume");
		    	Client client = new Client(id, nume,prenume);
		    	allclient.add(client);
		    }	
		} catch (SQLException e) {
		   e.printStackTrace();
		} 
		return  allclient; 
	}
	/**
	 * Returneaza datele clientului de la id id
	 * @param id
	 * @return Client
	 */
	public Client findById(int id)
	{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection=ConnectionFactory.getConnection();
			statement=connection.prepareStatement("select * from assigment3.client where id="+id);
			resultSet=statement.executeQuery();
			while (resultSet.next())
			{
				int idclient=resultSet.getInt("id");
				String numeclient=resultSet.getString("nume");
				String prenumeclient=resultSet.getString("prenume");
				Client client=new Client(id,numeclient,prenumeclient);
				return client;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
