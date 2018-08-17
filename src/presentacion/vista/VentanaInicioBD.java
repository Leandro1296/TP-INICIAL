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

public class VentanaInicioBD extends JFrame {

	private static final long serialVersionUID = 1L;
	private static VentanaInicioBD instancia;
	private JPanel contentPane;
	private JTextField txtHostname;
	private JTextField txtPuerto;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private Controlador controlador;
	private JButton btnIniciar;
	private JButton btnCerrar;
	

	public static VentanaInicioBD getVentana(Controlador controlador){
		if (instancia == null)
			return new VentanaInicioBD(controlador);
		else
			return instancia;
	}
	
	public VentanaInicioBD(Controlador controlador)
	{
		super();
		setTitle("Configuraci\u00F3n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.controlador = controlador;
		inicializar();
	}
	
	public void inicializar() {
		setTitle("Agenda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenidoALa = new JLabel("Bienvenido a la aplicaci\u00F3n Agenda");
		lblBienvenidoALa.setFont(new Font("Microsoft Tai Le", Font.BOLD, 14));
		lblBienvenidoALa.setBounds(65, 11, 237, 14);
		contentPane.add(lblBienvenidoALa);
		
		JLabel lblAntesDeIniciar = new JLabel("Antes de iniciar la aplicaci\u00F3n por primera vez...");
		lblAntesDeIniciar.setBounds(65, 36, 254, 14);
		contentPane.add(lblAntesDeIniciar);
		
		JLabel lblDebesConfigurarEl = new JLabel("Debes configurar el acceso a la base de datos:");
		lblDebesConfigurarEl.setBounds(40, 61, 237, 14);
		contentPane.add(lblDebesConfigurarEl);
		
		JLabel lblHostname = new JLabel("Nombre del host:");
		lblHostname.setBounds(40, 86, 99, 14);
		contentPane.add(lblHostname);
		
		JLabel lblPuerto = new JLabel("Puerto:");
		lblPuerto.setBounds(40, 111, 74, 14);
		contentPane.add(lblPuerto);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(40, 139, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Contrse\u00F1a:");
		lblPassword.setBounds(40, 164, 74, 14);
		contentPane.add(lblPassword);
		
		txtHostname = new JTextField();
		txtHostname.setBounds(149, 86, 185, 20);
		contentPane.add(txtHostname);
		txtHostname.setColumns(10);
		
		txtPuerto = new JTextField();
		txtPuerto.setBounds(149, 111, 185, 20);
		contentPane.add(txtPuerto);
		txtPuerto.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(149, 139, 185, 20);
		contentPane.add(txtUsuario);
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(149, 164, 185, 20);
		contentPane.add(txtPassword);
		
		btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(controlador);
		btnIniciar.setBounds(245, 212, 89, 23);
		contentPane.add(btnIniciar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(controlador);
		btnCerrar.setBounds(149, 212, 89, 23);
		contentPane.add(btnCerrar);
		
		this.setVisible(true);
	}
	
	public JButton getBtnIniciar()
	{
		return this.btnIniciar;
	}
	
	public JButton getBtnCerrar()
	{
		return this.btnCerrar;
	}
	
	public JTextField getTxtHostname()
	{
		return this.txtHostname;
	}
	
	public JTextField getTxtPuerto()
	{
		return this.txtPuerto;
	}
	
	public JTextField getTxtUsuario()
	{
		return this.txtUsuario;
	}
	
	public JPasswordField getTxtPassword()
	{
		return this.txtPassword;
	}
}
