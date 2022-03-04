package sistemaWebTest;

import java.util.ArrayList;

import org.junit.Test;

import com.ilinesolution.sistema.controlador.ClienteControlador;
import com.ilinesolution.sistema.controlador.impl.ClienteControladorImpl;
import com.ilinesolution.sistema.modelo.entidades.Cliente;

public class SistemaTest {

		private ClienteControlador clienteControlador;
		ArrayList<Cliente> encontrado;
		@Test
		public void test() {
			System.out.println(" Inicio Prueba");	
			
			try {
				clienteControlador = new ClienteControladorImpl();	
				Cliente encontrado = clienteControlador.buscarClienteEmail("jcoswaldo@gmail.com");
				System.out.println(encontrado);
			
			} catch (Exception e) {
				System.out.println(" Error"+e.getMessage());
				System.out.println(" Fin Prueba");
				
			}
			
			
		}

}
