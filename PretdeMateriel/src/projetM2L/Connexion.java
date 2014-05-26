package projetM2L;

import java.sql.*;

public class Connexion {
	
	public static void sauverEnBase(String nom, String prenom)
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
			st = cn.createStatement();
			String sql = "INSERT INTO utilisateur (nom_utilisateur, prenom_utilisateur) VALUES ('"+nom+"','"+prenom+"')";
			st.executeUpdate(sql);
		}
		
		catch (ClassNotFoundException i)
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
	public static void main(String[] args) 
	{
		Fenetre f = new Fenetre();
	}
}
