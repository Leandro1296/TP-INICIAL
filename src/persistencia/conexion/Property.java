package persistencia.conexion;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Property 
{
	private String user;
	private String password;
	private FileOutputStream output;
	private Properties prop;
	private FileInputStream inStream;
	
	public Property()
	{
		prop = new Properties();
		this.user = "root";
		this.password = "Accenture";
	}
	
	public void createOutput(String fileName)
	{
		try {
			output = new FileOutputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setUser(String user)
	{
		prop.setProperty("user", user);
		System.out.println("Seteado user");
	}

	public void setPassword(String password)
	{
		prop.setProperty("password", password);
		System.out.println("Seteado pass");
	}
	
	public String getUser()
	{
		return prop.getProperty("user");
	}
	
	public String getPassword()
	{
		return prop.getProperty("password");
	}
	
	public void guardar()
	{
		try {
			prop.store(output, "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void load(String fileName)
	{
		{
			try {

				inStream = new FileInputStream(fileName);
				prop.load(inStream);
				System.out.println("Load input");
			} catch (IOException io) {
				io.printStackTrace();
			}
		}
	}
}
