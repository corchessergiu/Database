package presentation;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import com.mysql.cj.xdevapi.Table;

public class View {
public JFrame frame1;
public JLabel mesaj1=new JLabel("Alegeti tabela asupra careia doriti sa efectuati operatii:");
public JButton produs=new JButton("PRODUS");
public JButton client=new JButton("CLIENTI");
public JButton comanda=new JButton("COMANDA");
public JFrame frame2;
public JLabel mesaj=new JLabel("Introduceti datele pentru insert:");
public JLabel idprodus=new JLabel("Introduceti id-ul:");
public JTextArea idprod=new JTextArea();
public JLabel numeprodus=new JLabel("Introduceti nume:");
public JTextArea numeprod=new JTextArea();
public JLabel pretprodus=new JLabel("Introduceti pret:");
public JTextArea pretprod=new JTextArea();
public JLabel delete=new JLabel("Introduceti id-ul produsului pe care doriti sa il stergeti:");
public JTextArea iddelete=new JTextArea();
public JButton addprod=new JButton("Adaugare produs");
public JButton deleteprod=new JButton("Stergere produs");
public JLabel idupdate=new JLabel("Introduceti id-ul pentru produsul care va fi modificat:");
public JTextArea idup=new JTextArea();
public JLabel numeupdate=new JLabel("Introduceti noul nume pentru produs:");
public JTextArea numup=new JTextArea();
public JLabel pretupdate=new JLabel("Introduceti noul pret pentru produs:");
public JTextArea pretup=new JTextArea();
public JButton updateprod=new JButton("Update produs");
public JButton vizualizaredateprodus=new JButton("Vizualizati datele din tabela");
public JButton backprod=new JButton("Back");
public JFrame frame3;
public JLabel mesajclient=new JLabel("Introduceti datele pentru insert:");
public JLabel idclient=new JLabel("Introduceti id-ul:");
public JTextArea idcli=new JTextArea();
public JLabel numeclient=new JLabel("Introduceti nume:");
public JTextArea numecli=new JTextArea();
public JLabel prenumeclient=new JLabel("Introduceti prenume:");
public JTextArea prenumecli=new JTextArea();
public JButton inserareclient=new JButton("Adaugare client");
public JLabel deleteclient=new JLabel("Introduceti id-ul pentru clientul care urmeaza sa fie sters: ");
public JTextArea idclisters=new JTextArea();
public JButton deleteclientbuton=new JButton("Stergere client");
public JLabel mesajupdate=new JLabel("Introduceti id-ul pentru clientul care va fi modificat:");
public JTextArea idupdatecli=new JTextArea();
public JLabel mesajnume=new JLabel("Introduceti noul nume:");
public JTextArea numeupdatecli=new JTextArea();
public JLabel mesajprenume=new JLabel("Introduceti noul prenume:");
public JTextArea prenumeupdatecli=new JTextArea();
public JButton updateclient=new JButton("Update client");
public JButton vizualizaredateclient=new JButton("Vizualizati datele din tabela");
public JButton backcli=new JButton("Back");
public JFrame frame4;
public JLabel mesajcomanda=new JLabel("Introduceti datele pentru insert:");
public JLabel idcom=new JLabel("Introduceti id-ul comenzii:");
public JTextArea idcomfild=new JTextArea();
public JLabel cantitate=new JLabel("Introduceti cantitatea:");
public JTextArea cantitatefild=new JTextArea();
public JLabel idprodcomanda=new JLabel("Introduceti id-ul produsului:");
public JTextArea idprodcomfild=new JTextArea();
public JLabel idclientcomanda=new JLabel("Introduceti id-ul clientului:");
public JTextArea idclientcomfild=new JTextArea();
public JButton adaugarecomanda=new JButton("Adauga comanda");
public JLabel deletecomanda=new JLabel("Introduceti id-ul pentru comanda care urmeaza sa fie stersa: ");
public JTextArea idcomandadelete=new JTextArea();
public JButton stergecomanda=new JButton("Sterge comanda");
public JLabel mesajupdatecomanda=new JLabel("Introduceti id-ul pentru comanda care va fi modificata:");
public JTextArea idcommodif=new JTextArea();
public JLabel mesajprodus=new JLabel("Introduceti noul id al produsului:");
public JTextArea idnouprodus=new JTextArea();
public JLabel mesajclientcomanda=new JLabel("Introduceti noul id al clientului:");
public JTextArea idnouclient=new JTextArea();
public JLabel mesajcantitate=new JLabel("Introduceti noua cantitate:");
public JTextArea cantitatenoua=new JTextArea();
public JButton updatecomanda=new JButton("Update comanda");
public JButton vizualizaredatecomanda=new JButton("Vizualizati datele din tabela");
public JButton backcomanda=new JButton("Back");
public JFrame tableprodus;
public JFrame tableclient;
public JFrame tablecomanda;
public JTable table=new JTable();
public JButton obtinechitanta=new JButton("OBTINE CHITANTA");
public JLabel numarproduse=new JLabel("Numar produse:");
public JTextArea nrprod=new JTextArea();
public JLabel numarproduseupdate=new JLabel("Introduceti noul numar de produse:");
public JTextArea nrprodupdate=new JTextArea();
public JTextArea starechitanta=new JTextArea();
public View()
{
	frame1=new JFrame("Meniu");
	frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame1.setSize(700,300);
	frame1.setVisible(true);
	JPanel panel=new JPanel();
	panel.setLayout(null);
	mesaj1.setBounds(150,20,400,20);
	panel.add(mesaj1);
	produs.setBounds(40,90,150,60);
	panel.add(produs);
	client.setBounds(250,90,150,60);
	panel.add(client);
	comanda.setBounds(470,90,150,60);
	panel.add(comanda);
	frame1.add(panel);
}

public void InitializareFrameProdusButoane()
{
	frame2=new JFrame();
	frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame2.setSize(700,600);
	JPanel panel2=new JPanel();
	panel2.setLayout(null);
	mesaj.setBounds(20,0,200,20);
	panel2.add(mesaj);
	idprodus.setBounds(20,20,100,20);
	panel2.add(idprodus);
	numeprodus.setBounds(20,50,100,20);
	panel2.add(numeprodus);
	pretprodus.setBounds(20,80,100,20);
	panel2.add(pretprodus);
	idprod.setBounds(130,20,60,20);
	panel2.add(idprod);
	numeprod.setBounds(130,50,60,20);
	panel2.add(numeprod);
	pretprod.setBounds(130,80,60,20);
	panel2.add(pretprod);
	addprod.setBounds(20,140,180,60);
	panel2.add(addprod);
	delete.setBounds(250,5,320,20);
	panel2.add(delete);
	iddelete.setBounds(560,5,100,20);
	panel2.add(iddelete);
	deleteprod.setBounds(360,40,150,60);
	panel2.add(deleteprod);
	idupdate.setBounds(20,210,350,20);
	panel2.add(idupdate);
	idup.setBounds(320, 210, 100, 20);
	panel2.add(idup);
	numeupdate.setBounds(20,240,350,20);
	panel2.add(numeupdate);
	numup.setBounds(240,240,100,20);
	panel2.add(numup);
	pretupdate.setBounds(20, 270,350, 20);
	panel2.add(pretupdate);
	pretup.setBounds(240, 270, 100,20);
	panel2.add(pretup);
	updateprod.setBounds(110, 320,150, 60);
	panel2.add(updateprod);
	vizualizaredateprodus.setBounds(240,420,200,60);
	panel2.add(vizualizaredateprodus);
	backprod.setBounds(240,500,200,60);
	panel2.add(backprod);
	numarproduse.setBounds(20,110,100,20);
    panel2.add(numarproduse);
    nrprod.setBounds(130,110,60,20);
    panel2.add(nrprod);
    numarproduseupdate.setBounds(20, 295,200, 20);
    panel2.add(numarproduseupdate);
    nrprodupdate.setBounds(240, 295, 100, 20);
    panel2.add(nrprodupdate);
	frame2.add(panel2);
	frame2.setVisible(true);
}
public void initializareFrameComandaButoane() {
	frame4=new JFrame();
	frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame4.setSize(700,630);
	JPanel panel4=new JPanel();
	panel4.setLayout(null);
	mesajcomanda.setBounds(20,0,200,20);
	panel4.add(mesajcomanda);
	idcom.setBounds(20,20,150,20);
	panel4.add(idcom);
	idcomfild.setBounds(170,20,80,20);
	panel4.add(idcomfild);
	idclientcomanda.setBounds(20,45,160,20);
	panel4.add(idclientcomanda);
	idclientcomfild.setBounds(170,45, 80,20);
	panel4.add(idclientcomfild);
	idprodcomanda.setBounds(20, 70, 160,20);
	panel4.add(idprodcomanda);
	idprodcomfild.setBounds(180,70, 80, 20);
	panel4.add(idprodcomfild);
	cantitate.setBounds(20,95,130,20);
	panel4.add(cantitate);
	cantitatefild.setBounds(170,95,80,20);
	panel4.add(cantitatefild);
	adaugarecomanda.setBounds(45,125,150,60);
	panel4.add(adaugarecomanda);
	deletecomanda.setBounds(260,5,350, 20);
	panel4.add(deletecomanda);
	idcomandadelete.setBounds(610,5,50,20);
	panel4.add(idcomandadelete);
	stergecomanda.setBounds(520,40,150,60);
	panel4.add(stergecomanda);
	mesajupdatecomanda.setBounds(20,200,350,20);
	panel4.add(mesajupdatecomanda);
	idcommodif.setBounds(340, 200,80, 20);
	panel4.add(idcommodif);
	mesajprodus.setBounds(20,230,350,20);
	panel4.add(mesajprodus);
	idnouprodus.setBounds(210, 230,80, 20);
	panel4.add(idnouprodus);
	mesajclientcomanda.setBounds(20,260,350,20);
	panel4.add(mesajclientcomanda);
	idnouclient.setBounds(210, 260,80, 20);
	panel4.add(idnouclient);
	mesajcantitate.setBounds(20,290,350,20);
	panel4.add(mesajcantitate);
	cantitatenoua.setBounds(180,290,80, 20);
	panel4.add(cantitatenoua);
	updatecomanda.setBounds(45,325,150,60);
	panel4.add(updatecomanda);
	vizualizaredatecomanda.setBounds(240,430,200,60);
	panel4.add(vizualizaredatecomanda);
	backcomanda.setBounds(240,530,200,60);
	panel4.add(backcomanda);
	obtinechitanta.setBounds(260,125,150,60);
	panel4.add(obtinechitanta);
	starechitanta.setBounds(450,140,200,30);
	panel4.add(starechitanta);
	frame4.add(panel4);
	frame4.setVisible(true);
}
public void initializareFrameClientButoane() {
	frame3=new JFrame();
	frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame3.setSize(700,600);
	JPanel panel3=new JPanel();
	panel3.setLayout(null);
	mesajclient.setBounds(20,0,200,20);
	panel3.add(mesajclient);
	idclient.setBounds(20,20,100,20);
	panel3.add(idclient);
	idcli.setBounds(140,20,100,20);
	panel3.add(idcli);
	numeclient.setBounds(20,45,100,20);
	panel3.add(numeclient);
	numecli.setBounds(140,45,100,20);
	panel3.add(numecli);
	prenumeclient.setBounds(20,70,120,20);
	panel3.add(prenumeclient);
	prenumecli.setBounds(140,70,100,20);
	panel3.add(prenumecli);
	inserareclient.setBounds(50,110, 150,60);
	panel3.add(inserareclient);
	deleteclient.setBounds(255, 5,350, 20);
	panel3.add(deleteclient);
	idclisters.setBounds(585,5,80,20);
	panel3.add(idclisters);
	deleteclientbuton.setBounds(410,40,150,60);
	panel3.add(deleteclientbuton);
	mesajupdate.setBounds(20,180,320,20);
	panel3.add(mesajupdate);
	idupdatecli.setBounds(310,180,80,20);
	panel3.add(idupdatecli);
	mesajnume.setBounds(20,210,150,20);
	panel3.add(mesajnume);
	numeupdatecli.setBounds(180,210,80, 20);
	panel3.add(numeupdatecli);
	mesajprenume.setBounds(20,240,150,20);
	panel3.add(mesajprenume);
	prenumeupdatecli.setBounds(180,240,80,20);
	panel3.add(prenumeupdatecli);
	updateclient.setBounds(45,280,150,60);
	panel3.add(updateclient);
	vizualizaredateclient.setBounds(240,400,200,60);
	panel3.add(vizualizaredateclient);
	backcli.setBounds(240,500,200,60);
	panel3.add(backcli);
	frame3.add(panel3);
	frame3.setVisible(true);
}
public void listenerchitanta(ActionListener e)
{
	obtinechitanta.addActionListener(e);
}
public void initializareFrameComanada() {
	tablecomanda=new JFrame();
	tablecomanda.setSize(600,400);
	JPanel comanda=new JPanel();
	comanda.setLayout(null);
	tablecomanda.add(comanda);
	tablecomanda.add(new JScrollPane(this.table));	
	tablecomanda.setVisible(true);
}
public void initializareFrameClient() {
	tableclient=new JFrame();
	tableclient.setSize(600,300);
	JPanel client=new JPanel();
	client.setLayout(null);
	tableclient.add(client);
	tableclient.add(new JScrollPane(this.table));	
	tableclient.setVisible(true);
}
public void initializareFrameProdus()
{
	tableprodus=new JFrame();
	tableprodus.setSize(600,300);
	JPanel produs=new JPanel();
	produs.setLayout(null);
	tableprodus.add(produs);
	tableprodus.add(new JScrollPane(this.table));
	tableprodus.setVisible(true);
}
public void vizdatecli(ActionListener e)
{
	vizualizaredateclient.addActionListener(e);
}
public void vizdatecom(ActionListener e)
{
	vizualizaredatecomanda.addActionListener(e);
}
public void vizdateprod(ActionListener e)
{
	vizualizaredateprodus.addActionListener(e);
}
  public void produsActionListener(ActionListener e)
  {
	  produs.addActionListener(e);
  }
  public void clientActionListener(ActionListener e)
  {
	  client.addActionListener(e);
  }
  public void comandaActionListener(ActionListener e)
  {
	  comanda.addActionListener(e);
  }
  public void backprod(ActionListener e)
  {
	  backprod.addActionListener(e);
  }
  public void backcli(ActionListener e)
  {
	  backcli.addActionListener(e);
  }
  public void backcomanda(ActionListener e)
  {
	  backcomanda.addActionListener(e);
  }
  public void addprod(ActionListener e)
  {
	  addprod.addActionListener(e);
  }
  public void inserareclient(ActionListener e)
  {
	  inserareclient.addActionListener(e);
  }
  public void deleteclient(ActionListener e)
  {
	  deleteclientbuton.addActionListener(e);
  }
  public void deleteprod(ActionListener e)
  {
	  deleteprod.addActionListener(e);
  }
  public void adaugarecomanda(ActionListener e)
  {
	  adaugarecomanda.addActionListener(e);
  }
  public void stergerecomanda(ActionListener e)
  {
	  stergecomanda.addActionListener(e);
  }
  public void updateclient(ActionListener e)
  {
	  updateclient.addActionListener(e);
  }
  public void updateprod(ActionListener e)
  {
	  updateprod.addActionListener(e);
  }
  public void updatecom(ActionListener e)
  {
	  updatecomanda.addActionListener(e);
  }
  public void vizualizaredateprodus(ActionListener e)
  {
	  vizualizaredateprodus.addActionListener(e);
  }
  public void setTable(JTable table)
  {
	  this.table= table;
	  
  }
}
