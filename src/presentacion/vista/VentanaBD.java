package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import presentacion.controlador.Controlador;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaBD extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static VentanaBD instancia;
	private Controlador controlador;
	private JTextField txtHostname;
	private JTextField txtPuerto;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private JButton btnActualizar;
	private JButton btnCancelar;

	public static VentanaBD getVentana(Controlador controlador){
		if (instancia == null)
			return new VentanaBD(controlador);
		else
			return instancia;
	}
	
	private VentanaBD(Controlador controlador) {
		super();
		setTitle("Configuraci\u00F3n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.controlador = controlador;
		inicializar();
	}

	public void inicializar() {
		setBounds(100, 100, 383, 223);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConfiguraElAcceso = new JLabel("Configura el acceso a la base de datos:");
		lblConfiguraElAcceso.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		lblConfiguraElAcceso.setBounds(56, 11, 249, 17);
		contentPane.add(lblConfiguraElAcceso);
		
		JLabel lblHostnameActual = new JLabel("Nombre del host:");
		lblHostnameActual.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		lblHostnameActual.setBounds(56, 39, 100, 14);
		contentPane.add(lblHostnameActual);
		
		JLabel lblPuertoActual = new JLabel("Puerto:");
		lblPuertoActual.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		lblPuertoActual.setBounds(56, 64, 100, 14);
		contentPane.add(lblPuertoActual);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		lblUsuario.setBounds(56, 92, 87, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a:");
		lblPassword.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		lblPassword.setBounds(56, 117, 100, 14);
		contentPane.add(lblPassword);
		
		txtHostname = new JTextField();
		txtHostname.setBounds(173, 36, 132, 20);
		contentPane.add(txtHostname);
		txtHostname.setColumns(10);
		
		txtPuerto = new JTextField();
		txtPuerto.setBounds(173, 61, 132, 20);
		contentPane.add(txtPuerto);
		txtPuerto.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(173, 89, 132, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(173, 114, 132, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(67, 152, 89, 23);
		btnCancelar.addActionListener(controlador);
		contentPane.add(btnCancelar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(216, 152, 89, 23);
		btnActualizar.addActionListener(controlador);
		contentPane.add(btnActualizar);
		
		this.setVisible(true);
	}

	public JButton getbtnActualizar()
	{
		return this.btnActualizar;
	}
	
	public JButton getbtnCancelar()
	{
		return this.btnCancelar;
	}
	
	public JTextField getCurrentHostname()
	{
		return this.txtHostname;
	}
	
	public JTextField getCurrentPuerto()
	{
		return this.txtPuerto;
	}
	
	public JTextField getCurrentUsuario()
	{
		return this.txtUsuario;
	}
	
	public JPasswordField getCurrentPassword()
	{
		return this.txtPassword;
	}
}