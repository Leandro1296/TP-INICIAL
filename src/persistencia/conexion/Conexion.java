package persistencia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion 
{
	public static Conexion instancia;
	private Connection connection;
	private ArchivoConfiguracion configuracion;
	
	private Conexion()
	{
		try
		{
			this.configuracion = new ArchivoConfiguracion();
			String ip = configuracion.getProperty(ArchivoConfiguracion.HOSTNAME);
			String puerto = configuracion.getProperty(ArchivoConfiguracion.PUERTO);
			String usuario = configuracion.getProperty(ArchivoConfiguracion.USUARIO);
			String password = configuracion.getProperty(ArchivoConfiguracion.PASSWORD);
			this.connection = DriverManager.getConnection("jdbc:mysql://" + ip + ":"+ puerto + "/agenda", usuario, password);
			System.out.println("Conexion exitosa");
		}
		catch(Exception e)
		{
			System.out.println("Conexion fallida");
		}
	}
	
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() 
	{
		return this.connection;
	}
	
	public void cerrarConexion()
	{
		try 
		{
			this.connection.close();
			System.out.println("Conexion cerrada");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		instancia = null;
	}
}
