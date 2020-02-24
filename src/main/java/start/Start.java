package start;

import java.sql.Connection;

import bll.ClientBLL;
import bll.ComandaBLL;
import bll.ProdusBLL;
import connection.ConnectionFactory;
import dao.AbstractDao;
import dao.ClientDao;
import dao.ComandaDao;
import dao.ProdusDao;
import model.Client;
import model.Comanda;
import model.Produs;
import presentation.Controler;
import presentation.View;

public class Start {

	public static void main(String[] args) {
		ConnectionFactory connection=new ConnectionFactory();
		View view=new View();	
		ClientDao cli=new ClientDao();
		ClientBLL client=new ClientBLL(cli);
		ProdusDao prodd=new ProdusDao();
		ProdusBLL prod=new ProdusBLL(prodd);
		ComandaDao com=new ComandaDao();
		ComandaBLL comanda=new ComandaBLL(com);
		Controler controler=new Controler(view,client,prod,comanda);
		
	
	}

}
