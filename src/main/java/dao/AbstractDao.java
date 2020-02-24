package dao;

import java.awt.Color;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import connection.ConnectionFactory;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 * @Source http://www.java-blog.com/mapping-javaobjects-database-reflection-generics
 */
public class AbstractDao<T> {
	protected static final Logger LOGGER = Logger.getLogger(AbstractDao.class.getName());

	public final  Class<T> type;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	}
	/**
	 * 
	 * @param listaobiecte
	 * @return JTable
	 * Adauga datele intr-un tabel pe care ulterior il va returna
	 */
    public JTable addtable(ArrayList<T>  listaobiecte)
    {
    	int nrcoloane=type.getDeclaredFields().length;
    	Object[][] date=new Object[listaobiecte.size()][nrcoloane];
    	Object[] captabel=new Object[nrcoloane]; 
	      int m=0;
	      for (Field field : listaobiecte.get(0).getClass().getDeclaredFields()) { 
		   captabel[m]=field.getName();
		   System.out.print(captabel[m]+"\n");
		   m++;		 
	   }
    	 for (int i=0;i<listaobiecte.size();i++)
    	 {
    		 int coloana=0;
    		 
    		  for (Field camp:listaobiecte.get(i).getClass().getDeclaredFields())
    		  {
    			  camp.setAccessible(true); //pentru ca am campuri private
    			  try {
					date[i][coloana]=camp.get(listaobiecte.get(i)); //imi returenaza un anumit camp dintr-un obiect
					coloana++;
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		  }
    	 }       	
    	 JTable newTable = new JTable(date,captabel);
    	return newTable;
    }
	


}