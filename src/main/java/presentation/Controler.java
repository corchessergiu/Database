package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Action;
import javax.swing.JTable;

import bll.ClientBLL;
import bll.ComandaBLL;
import bll.ProdusBLL;
import connection.ConnectionFactory;
import dao.ClientDao;
import dao.ProdusDao;
import model.Client;
import model.Produs;
import net.proteanit.sql.DbUtils;

public class Controler {
public View view;
public ClientBLL client;
public ProdusBLL produs;
public ComandaBLL comanda;
/**
 * 
 * @param view
 * @param client
 * @param produs
 * @param comanda
 */
public Controler(View view,ClientBLL client,ProdusBLL produs,ComandaBLL comanda)
{
	this.comanda=comanda;
	this.produs=produs;
	this.client=client;
	this.view=view;
	view.produsActionListener(new ListenerProdus());
	view.clientActionListener(new ActionClient());
	view.comandaActionListener(new ListenerComanda());
	view.backcli(new BackCli());
	view.backprod(new BackProd());
	view.backcomanda(new BackComanda());
	view.vizdateprod(new VizualizareDateProdus());
	view.vizdatecli(new VizualizareDateClient());
	view.vizdatecom(new VizualizareDateComanda());
	view.inserareclient(new AdaugareClient());
	view.deleteclient(new DeleteClient());
	view.addprod(new AdaugareProdus());
	view.deleteprod(new StergereProdus());
	view.adaugarecomanda(new AdaugareComanda());
	view.stergerecomanda(new StergeComanda());
	view.updateclient(new UpdateClient());
	view.updateprod(new UpdateProdus());
	view.updatecom(new UpdateComanda());
	view.listenerchitanta(new ListenerChitanta());
}
/**
 * 
 * @author Sergiu
 *
 */
class ListenerChitanta implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		int idcomanda=Integer.parseInt(view.idcomfild.getText());
		int idclient=Integer.parseInt(view.idclientcomfild.getText());
		int idprodus=Integer.parseInt(view.idprodcomfild.getText());
		int cantitate=Integer.parseInt(view.cantitatefild.getText());
		comanda.chitatnta(idcomanda,cantitate,idclient,idprodus);	
		if (comanda.chitatnta(idcomanda, cantitate, idclient, idprodus)==true)
			view.starechitanta.setText("Comanda a fost efecutata cu succes!");
		else
			view.starechitanta.setText("Comanda nu s-a putut efectua!");
	}
}
/**
 * 
 * @author Sergiu
 *
 */
class UpdateComanda implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		int idcomanda=Integer.parseInt(view.idcommodif.getText());
		int idprodus=Integer.parseInt(view.idnouprodus.getText());
		int idclient=Integer.parseInt(view.idnouclient.getText());
		int cantitate=Integer.parseInt(view.cantitatenoua.getText());
		comanda.update(idcomanda, cantitate, idclient, idprodus);
	}	
}
/**
 * 
 * @author Sergiu
 *
 */
class UpdateProdus implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		int id=Integer.parseInt(view.idup.getText());
		String nume=view.numup.getText();
		double pret=Double.parseDouble(view.pretup.getText());
		int nrprod=Integer.parseInt(view.nrprodupdate.getText());
		produs.update(id, nume, pret,nrprod);	
	}
}
/**
 * 
 * @author Sergiu
 *
 */
class UpdateClient implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		int id=Integer.parseInt(view.idupdatecli.getText());
		String nume=view.numeupdatecli.getText();
		String prenume=view.prenumeupdatecli.getText();
		client.update(id, nume, prenume);		
	}	
}
/**
 * 
 * @author Sergiu
 *
 */
class StergeComanda implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		comanda.delete(Integer.parseInt(view.idcomandadelete.getText()));		
	}
}
/**
 * 
 * @author Sergiu
 *
 */
class AdaugareComanda implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		int idcomanda=Integer.parseInt(view.idcomfild.getText());
		int idclient=Integer.parseInt(view.idclientcomfild.getText());
		int idprodus=Integer.parseInt(view.idprodcomfild.getText());
		int cantitate=Integer.parseInt(view.cantitatefild.getText());
		comanda.insert(idcomanda, cantitate, idclient, idprodus);
	}	
}
/**
 * 
 * @author Sergiu
 *
 */
class StergereProdus implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		produs.delete(Integer.parseInt(view.iddelete.getText()));	
	}
}
/**
 * 
 * @author Sergiu
 *
 */
class DeleteClient implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		int id=Integer.parseInt(view.idclisters.getText());
		client.delete(id);		
	}
}
/**
 * 
 * @author Sergiu
 *
 */
class AdaugareClient implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		int id=Integer.parseInt(view.idcli.getText());
		String nume=view.numecli.getText();
		String prenume=view.prenumecli.getText();
		client.insert(id,nume,prenume);
	}
}
/**
 * 
 * @author Sergiu
 *
 */
class AdaugareProdus implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		int id=Integer.parseInt(view.idprod.getText());
		String num=view.numeprod.getText();
		double pret=Double.parseDouble(view.pretprod.getText());
		int nrprod=Integer.parseInt(view.nrprod.getText());
		produs.insert(id,num,pret,nrprod);
	}
}
/**
 * 
 * @author Sergiu
 *
 */
class VizualizareDateComanda implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		view.setTable(comanda.findall());
		view.initializareFrameComanada();
	}
}
/**
 * 
 * @author Sergiu
 *
 */
class VizualizareDateClient implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		view.setTable(client.getall());
		view.initializareFrameClient();
	}
}
/**
 * 
 * @author Sergiu
 *
 */
class VizualizareDateProdus implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		view.setTable(produs.findall());
		view.initializareFrameProdus();
	}
}
/**
 * 
 * @author Sergiu
 *
 */
class ListenerComanda implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		view.frame1.setVisible(false);
		view.initializareFrameComandaButoane();
	}	
}
/**
 * 
 * @author Sergiu
 *
 */
 class ListenerProdus implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		view.frame1.setVisible(false);
		view.InitializareFrameProdusButoane();
	} 
 }
 /**
  * 
  * @author Sergiu
  *
  */
  class ActionClient implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		view.frame1.setVisible(false);
		view.initializareFrameClientButoane();
	}	
	}
  /**
   * 
   * @author Sergiu
   *
   */
	 class BackProd implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			view.frame2.setVisible(false);
			view.frame1.setVisible(true);		
		}	 
	 }
	 /**
	  * 
	  * @author Sergiu
	  *
	  */
	 class BackCli implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				view.frame3.setVisible(false);
				view.frame1.setVisible(true);		
			}	 
		 }
	 /**
	  * 
	  * @author Sergiu
	  *
	  */
	 class BackComanda implements ActionListener{

		public void actionPerformed(ActionEvent e) {
		view.frame4.setVisible(false);
		view.frame1.setVisible(true);		
		}	 
	 }
}

