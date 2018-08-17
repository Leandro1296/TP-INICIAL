package persistencia.conexion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class ArchivoConfiguracion {
	
	public static final String CONFIGURACION = System.getProperty("user.home") + "\\Archivo.properties";
	public static final String HOSTNAME = "jdbc.hostname";
	public static final String PUERTO = "jdbc.puerto";
	public static final String USUARIO = "jdbc.usuario";
	public static final String PASSWORD = "jdbc.password";
	
	public void crear (String hostname,String puerto, String usuario, String password){
		FileWriter archivoConfig = null;
        FileInputStream fileConfig = null;
        Properties propConfig = new Properties();
		try 
		{
			//Se crea el archivo en disco
            archivoConfig = new FileWriter(CONFIGURACION);
            //Se carga el archivo a un File para poder usar el método Load
            fileConfig = new FileInputStream(CONFIGURACION);
            //Con el método load cargamos el objeto properties
            propConfig.load(fileConfig);
            //Ahora agregamos información al properties mediante un Hashmap
            propConfig.putAll(getConfig(hostname, puerto, usuario, password));
            //Salvamos los datos en el properties y listo
            propConfig.store(new FileOutputStream(CONFIGURACION),"Config");
            archivoConfig.close();
		} 
		catch(IOException e) 
		{
			System.out.println(e.toString());
		}
	} 
	
	public void modificar (String hostname,String puerto, String usuario, String password)
	{
        FileOutputStream archivoConfig = null;
        Properties propConfig = new Properties();
		try 
		{
			//Leemos el archivo
			archivoConfig = new FileOutputStream(CONFIGURACION);
            propConfig.setProperty(HOSTNAME, hostname);
            propConfig.setProperty(PUERTO, puerto);
            propConfig.setProperty(USUARIO, usuario);
            propConfig.setProperty(PASSWORD, password);
			//Salvamos los datos en el properties y listo
            propConfig.store(archivoConfig,null);
            archivoConfig.close();
		} 
		catch(IOException e) 
		{
			System.out.println(e.toString());
		}
	} 
	public HashMap <String,String> getConfig(String hostname,String puerto, String usuario, String password)
	{
        HashMap <String,String> map = new HashMap <String,String>();
        map.put(HOSTNAME, hostname);
        map.put(PUERTO,	puerto );
        map.put(USUARIO, usuario );
        map.put(PASSWORD, password);
        return map;
    }
	
	public String getProperty(String key)
	{
		String valor = null;
		FileInputStream archivoConfig = null;
        Properties propConfig = new Properties();
        try 
        {
        	//Leemos el archivo	
        	archivoConfig = new FileInputStream(CONFIGURACION);
        	//Con el método load cargamos el objeto properties
        	propConfig.load(archivoConfig);
        	//Obtenemos el valor de la propiedad
        	valor = propConfig.get(key).toString();
        	//Cerramos el archivo
        	archivoConfig.close();
        } 
        catch(IOException e) 
        {
        	System.out.println(e.toString());
        }
        return valor;
	}
	
	public boolean existeArchivoConfiguracion()
	{
		File archivo = new File(CONFIGURACION);
		return archivo.exists();
	}
	
	

	public static void main(String[] args) {
		ArchivoConfiguracion  jdbc = new ArchivoConfiguracion();
		//jdbc.crear("jdbc","3306","root","root");
		//jdbc.modificar("jdbc","3306","root","admin");
		String valor = jdbc.getProperty(ArchivoConfiguracion.HOSTNAME);
		System.out.println(valor);
	}

}
