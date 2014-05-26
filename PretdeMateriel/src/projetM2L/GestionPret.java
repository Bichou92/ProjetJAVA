package projetM2L;

import java.sql.*;

public class GestionPret {
	
	public static void Retour(int nb)
	{
		String url = "jdbc:mysql://localhost/pdm";
		String user = "root";
		String password = "";
		Connection cn = null;
		Statement st = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, user, password);
		    String requete = "UPDATE materiel SET qte_mat = qte_mat + 1 WHERE id_mat ='"+nb+"'";
		    st = cn.createStatement();
		    st.executeUpdate(requete);
		    
		} catch (ClassNotFoundException i)
		  {
			i.printStackTrace();
		  }
		
		  catch (SQLException e)
		  {
				e.printStackTrace();
		  }
		
		finally 
		{
			try 
			{
				cn.close();
				st.close();
			}
			catch (SQLException f)
			{
				f.printStackTrace();
			}
		}
	}
	
	public static void Pret(int nb)
	{
		String url = "jdbc:mysql://localhost/pdm";
		String user = "root";
		String password = "";
		Connection cn = null;
		Statement st = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, user, password);
		    String requete = "UPDATE materiel SET qte_mat = qte_mat - 1 WHERE id_mat = '"+nb+"'";
		    st = cn.createStatement();
		    st.executeUpdate(requete);
		    
		} catch (ClassNotFoundException i)
		  {
			i.printStackTrace();
		  }
		
		  catch (SQLException e)
		  {
				e.printStackTrace();
		  }
		
		finally 
		{
			try 
			{
				cn.close();
				st.close();
			}
			catch (SQLException f)
			{
				f.printStackTrace();
			}
		}	
	}
		public static int VerifQuantite(int qte)
		{
			String url = "jdbc:mysql://localhost/pdm";
			String user = "root";
			String password = "";
			Connection cn = null;
			Statement st = null;
			int qteMat = 0;
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				cn = DriverManager.getConnection(url, user, password);
			    String requete = "SELECT qte_mat FROM materiel WHERE id_mat = '"+qte+"'";
			    st = cn.createStatement();
			    ResultSet resultat = st.executeQuery(requete);
			    
			    while (resultat.next()) 
			    {
			        qteMat = resultat.getInt("qte_mat");
			    }

			} catch (ClassNotFoundException i)
			  {
				i.printStackTrace();
			  }
			
			  catch (SQLException e)
			  {
					e.printStackTrace();
			  }
			
			finally 
			{
				try 
				{
					cn.close();
					st.close();
				}
				catch (SQLException f)
				{
					f.printStackTrace();
				}
			}
			
		return qteMat;
		}

}
