package ui;

import java.util.Scanner;
import model.Controladora;

public class Exe{
	// Atibutos
	private Scanner lector;
	// Relaciones
	private Controladora controller;
	
	/*
	Resumen: Este metodo se encarga de inicializar los arreglos
	@param: String[]	args
	pre: import de model.
	pos: Llama a metodo menú
	**/
	public static void main(String[] args){
		
		Exe ejecutable = new Exe();
		ejecutable.menu();
		
	}
	
	/*
	Resumen: este constructor inicializa dos variables miembro de la clase Exe: lector y controller. lector se inicializa como una nueva instancia de Scanner 
	pre: el constructor de la exe debe estar inicializadp
	pos: se inicializa el scanner y la controladora.
	**/
	public Exe(){
		lector = new Scanner (System.in);
		controller = new Controladora ();
	}
	
	/*
	Resumen: muestra un menú de opciones al usuario . Luego, lee la opción ingresada por el usuario 
	pre: El scanner debe estar inicializado
	pos: se llamaa los demás métodos relacionados con los 2 menús.
	**/
	public void menu (){
		boolean flag = true;
		do{
			
			System.out.println ("Bienvenido a la COP-16");
			System.out.println ("0) Salir");
			System.out.println ("1) Menú registros");
			System.out.println ("2) Menú consultas");
			
			
			int option = lector.nextInt ();
			
			switch (option){
				case 1:
					menuRegistros();
				break;
				
				case 2:
					menuConsultas ();
				break;
				
				case 0:
					flag = false;
					System.out.println ("Gracias por usar nuestros servicios");
				break;
				
				default:
				System.out.println ("Opcion invalida. Reintentar");
				break;
			}
		}while (flag);
	}
	
	/*
	Resumen: Este metodo se encarga de mostrar el menú de registos, permiteal usuarioseleccionar lo que quiere hacer
	pre: import de model.
	pos: Llama a los demás métodos relacionados a los registros.
	**/
	
	public void menuRegistros (){
		boolean flag = true;
		do{
			
			System.out.println ("0) Volver al menú principal");
			System.out.println ("1) registrar lugar");
			System.out.println ("2) registrar comunidad");	
			System.out.println ("3) registrar Especie");
			System.out.println ("4) registrar producto");
			System.out.println ("5) eliminar producto");
			System.out.println ("6) modificar especie");
			System.out.println ("7) crear casos de prueba");
			int option = lector.nextInt ();
			
			switch (option){
				case 1:
					registrarLugar();
				break;
				
				case 2:
					registrarComunidad();
				break;
				
				case 3:
					registrarEspecie();
				break;
				
				case 4:
					registrarProducto();
				break;
				
				case 5:
					eliminarProducto();
				break;
				
				case 6:
					modificarEspecie();
				break;
				
				case 7:
					crearCasosPrueba();
				break;
				
				case 0:
					menu();
				break;
				
				default:
				System.out.println ("Opcion invalida. Reintentar");
				break;
			}
		}while (flag);
	}
	
	/*
	Resumen: Este metodo se encarga de mostrar el menú de consultas, permite al usuarioseleccionar lo que quiere hacer
	pre: import de model.
	pos: Llama a los demás métodos relacionados a las consultas.
	**/
	
	public void menuConsultas (){
		boolean flag = true;
		do{
			
			System.out.println ("0) Volver al menú principal");
			System.out.println ("1) consultar lugar");
			System.out.println ("2) consultar comunidad");	
			System.out.println ("3) consultar Especie");
			System.out.println ("4) consultar producto");
			System.out.println ("5) consultar comunidades por departamento");
			System.out.println ("6) consultar 3 lugares con más área");
			System.out.println ("7) Consultar la información de las comunidades cuyos problemas son: que les falta un hospital o que les falta una escuela");
			System.out.println ("8) consultar ugares con más especies");
			int option = lector.nextInt ();
			
			switch (option){
				case 1:
					consultarLugar();
				break;
				
				case 2:
					consultarComunidad ();
				break;
				
				case 3:
					consultarEspecies();
				break;
				
				case 4:
					consultarProducto();
				break;
				
				case 5:
					consultarComunidadPorDepartamento();
				break;
				
				case 6:
					consultarTopTresLugares();
				break;
				
				case 7:
					consultarLugaresProblemas();
				break;
				
				case 8:
					consultarLugarMasEspecies();
				break;
				
				case 0:
					menu();
				break;
				
				default:
				System.out.println ("Opcion invalida. Reintentar");
				break;
			}
		}while (flag);
	}
	
	/*
	Resumen:  guía al usuario a través del proceso de ingreso de información para registrar un nuevo lugar.
	pre: El scanner debe estar inicializado, contoladora debe estar inicializada.
	pos: se llama a los demás métodos de la clase controladora, los datos recolectados de un lugar se guardan en un arreglo de lugares.
	**/
	
	public void registrarLugar(){
		lector.nextLine();
		System.out.println("Digite el nombre del lugar");
		String nombre = lector.nextLine();
		
		System.out.println("Digite el area del lugar");
		double area = lector.nextDouble();
		
		lector.nextLine();
		
		System.out.println("Digite el link a la imagen del lugar");
		String imagen = lector.nextLine();
		
		System.out.println("Cuanto invierte el lugar para sostenerse");
		double sostenimiento = lector.nextDouble();
		
		System.out.println("Seleccione el departamento \n 1) Valle \n 2) Cauca \n 3) Nariño \n 4) Choco ");
		int departamento = lector.nextInt();
		
		System.out.println("Seleccione el tipo de lugar \n 1) Area protegida \n 2)Parque nacional \n 3) Area Privada");
		int tipoLugar = lector.nextInt();
		
		lector.nextLine();
		System.out.println(controller.listarComunidad());
		System.out.println("Escriba el nombre de la comunidad que cuida del lugar");
		String comunidad = lector.nextLine();
		
		controller.registrarLugar(nombre, area, imagen, sostenimiento, departamento, tipoLugar, comunidad);
	}
	/*
	Resumen:  se encarga de registrar una nueva comunidad. 
	pre: El scanner debe estar inicializado, contoladora debe estar inicializada.
	pos: se llama a los demás métodos de la clase controladora, los datos recolectados de una comunidad se guardan en un arreglo de comunidades.
	**/
	
	public void registrarComunidad(){
		lector.nextLine();
		System.out.println("Digite el nombre de la comunidad ");
		String nombreC = lector.nextLine();
		
		System.out.println("Digite el nombre del lider");
		String nombreLider = lector.nextLine();
	
		
		System.out.println("Digite el numero de telefono del lugar");
		String celLider = lector.nextLine();
		
		System.out.println("Seleccione el tipo de comunidad \n 1) Afrocolombiana \n 2) Indigena \n 3) Raizal ");
		int comunidad = lector.nextInt();
		
		System.out.println("Seleccione el problema principal de la comunidad \n 1) falta de hospital \n 2) falta de escuela \n 3) falta de agua potable \n 4) falta de acceso a alimentación básica");
		int problema = lector.nextInt();
		
		controller.registrarComunidad(nombreC, nombreLider, celLider, comunidad, problema);
		
		
	}
	/*
	Resumen:  se encarga de registrar una nueva especie. 
	pre: El scanner debe estar inicializado, contoladora debe estar inicializada.
	pos: se llama a los demás métodos de la clase controladora, los datos recolectados de una comunidad se guardan en un arreglo de comunidades.
	**/
	public void registrarEspecie(){
		lector.nextLine();
		System.out.println("Digite el nombre de la especie ");
		String nombre = lector.nextLine();
		
		System.out.println("Digite \n 1) si es Fauna \n 2) si esflora");
		int faunaFlora = lector.nextInt();
	
		lector.nextLine();
		System.out.println("Digite el link de la imagen");
		String link = lector.nextLine();
		
		System.out.println("digite la cantidad de animales que hay en el lugar ");		
		int cantAnimales = lector.nextInt();
		
		lector.nextLine();
		System.out.println(controller.listarLugar());
		System.out.println("digite al lugar al que pertenece la especie");		
		String lugar = lector.nextLine();
		
		controller.registrarEspecieEnLugar(nombre,faunaFlora,link,cantAnimales,lugar);		
	}
	/*
	Resumen:  se encarga de registrar un nuevo producto. 
	pre: El scanner debe estar inicializado, contoladora debe estar inicializada.
	pos: se llama a los demás métodos de la clase controladora, los datos recolectados de una comunidad se guardan en un arreglo de comunidades.
	**/
	
	public void registrarProducto(){
		lector.nextLine();
		System.out.println("Digite el nombre del producto ");
		String nombre = lector.nextLine();
		
		System.out.println("Digite el porcentaje del producto que fue hecho a mano");
		double porcentajeNatural = lector.nextDouble();
		
		System.out.println("seleccione el tipo de producto. \n 1) alimento \n 2) artesania");
		int tipoProducto = lector.nextInt();
	
	
		System.out.println("Es Hecho a mano? \n 1) si \n 2) no ");
		int hechoAMano = lector.nextInt();
		

		lector.nextLine();		
		System.out.println(controller.listarComunidad());
		System.out.println("digite el nombre de la comunidad ");
		String nombreComunidad = lector.nextLine();
		controller.registrarProductoEnComunidad(nombre,porcentajeNatural, tipoProducto,hechoAMano, nombreComunidad );
	}
	
	public void eliminarProducto(){
		lector.nextLine();
		System.out.println(controller.listarComunidad());
		System.out.println("Digite el nombre de la comunidad ");
		String nombre = lector.nextLine();
		System.out.println(controller.listarProductos(nombre));
		System.out.println("Digite el nombre del producto ");
		String nombreProd = lector.nextLine();
		controller.eliminarProducto(nombre, nombreProd);
	}		
	/*
	Resumen:  se encarga de consultar la información de un lugar específico mediante su nombre.
	pre: El scanner debe estar inicializado, contoladora debe estar inicializada.
	pos: se llama a los demás métodos de la clase controladora, se buscan los datos de un lugar guardados en el arreglo de lugares.
	**/
	
	public void modificarEspecie(){
		lector.nextLine();
		System.out.println(controller.listarLugar());		
		System.out.println("digite el nombre del del lugar del cual quiera modificar la especies");
		String nombreLugar = lector.nextLine();
		
		System.out.println(controller.listarEspecies(nombreLugar));
		
		System.out.println("Digite el nombre de la especie ");
		String nombreOriginal = lector.nextLine();
		
		System.out.println("Digite el nuevo nombre de la especie ");
		String nuevoNombre = lector.nextLine();
		
		System.out.println("Digite \n 1) si es Fauna \n 2) si esflora");
		int faunaFlora = lector.nextInt();
	
		lector.nextLine();
		System.out.println("Digite el link de la imagen");
		String link = lector.nextLine();
		
		System.out.println("digite la cantidad de animales que hay en el lugar ");		
		int cantAnimales = lector.nextInt();
		
		lector.nextLine();
		System.out.println(controller.listarLugar());
		System.out.println("digite al lugar al que pertenece la especie");		
		String lugar = lector.nextLine();
		
		controller.cambiarAnimal(nombreLugar, nombreOriginal, nuevoNombre, faunaFlora, link, cantAnimales);
		
	}
	
	
	public void crearCasosPrueba(){
		controller.crearComunidadInicial();
		controller.crealLugarInicial();
		controller.crearEspecieInicial();
		controller.crearProductoInicial();
		System.out.println ("se han creado lugares, comunidades, especies y productos");
	}
	
	public void consultarLugar (){
		lector.nextLine();
		System.out.println(controller.listarLugar());
		System.out.println ("digite el nomre del lugar");
		String nombre = lector.nextLine();
		System.out.println (controller.mostrarLugar(nombre));
		
		
	}
	
	
	/*
	Resumen:  se encarga de consultar la información de una comunidad en específico mediante su nombre.
	pre: El scanner debe estar inicializado, contoladora debe estar inicializada.
	pos: se llama a los demás métodos de la clase controladora, se busca el en arreglo de comunidades y se despliega su información.
	**/
	
	public void  consultarComunidad (){
		lector.nextLine();
		System.out.println(controller.listarComunidad());
		System.out.println ("digite el nomre de la comunidad");
		String nombre = lector.nextLine();
		System.out.println (controller.mostrarComunidad(nombre));
		
		
	}
	
	/*
	Resumen:  se encarga de consultar la información de una especie específica mediante su nombre y el nombre del lugar en el cual se almacenó.
	pre: El scanner debe estar inicializado, contoladora debe estar inicializada.
	pos: se llama a los demás métodos de la clase controladora, se busca el en arreglo de lugares el lugar y en el lugarse busca la especiey se despliega su información.
	**/
	
	public void consultarEspecies (){
		lector.nextLine();
		System.out.println(controller.listarLugar());		
		System.out.println("digite el nombre del del cual quiera ver las especies");
		String nombre = lector.nextLine();
		System.out.println(controller.listarEspecies(nombre));
		System.out.println("digite el nombre de la especie que desa ver");
		String nombreEsp = lector.nextLine();
		System.out.println(controller.mostrarEspecie(nombre, nombreEsp));
	}
	
	/*
	Resumen:  se encarga de consultar la información de una especie específica mediante su nombre y el nombre del lugar en el cual se almacenó.
	pre: El scanner debe estar inicializado, contoladora debe estar inicializada.
	pos: se llama a los demás métodos de la clase controladora, se busca el en arreglo de lugares el lugar y en el lugarse busca la especiey se despliega su información.
	**/
	
	
	public void consultarProducto (){
		lector.nextLine();
		System.out.println(controller.listarComunidad());		
		System.out.println("digite el nombre de la comunidad de la cual va a ver los productos");
		String nombre = lector.nextLine();
		System.out.println(controller.listarProductos(nombre));
		System.out.println("digite el nombre del producto que quiere ver");
		String nombreProd = lector.nextLine();
		System.out.println(controller.mostrarProducto(nombre, nombreProd));		
	}
	
	/*
	Resumen:  se encarga de consultar las comunidades que pertenezcan a cierto departamento introducido por el usuario.
	pre: El scanner debe estar inicializado, contoladora debe estar inicializada.
	pos: se llama a los demás métodos de la clase controladora, se busca el en arreglo de lugares el departamento seleccionado y se despliegan los lugares que esten esos lugares.
	**/
	
	
	public void consultarComunidadPorDepartamento(){
		System.out.println("Seleccione el departamento del cual quiera ver las comunidades \n 1) Valle \n 2) Cauca \n 3) Nariño \n 4) Choco ");
		int departamento = lector.nextInt();
		System.out.println(controller.listarComunidadDepartamento(departamento));
		System.out.println ("digite el nomre de la comunidad");
		String nombre = lector.nextLine();
		System.out.println (controller.mostrarComunidad(nombre));
	}
	
	/*
	Resumen:  se encarga de consultar los tres lugares que mayor area tengan y listarlos
	pre: El scanner debe estar inicializado, contoladora debe estar inicializada.
	pos: se llama a los demás métodos de la clase controladora, se muestran los 3 lugares.
	**/
	
	
	public void consultarTopTresLugares (){
		System.out.println(controller.listarTopTresLugaresPorArea());
		
	}
	
	/*
	Resumen:  se encarga de consultar las comunidades que sufren de falta de hospital y de escuela.
	pre: El scanner debe estar inicializado, contoladora debe estar inicializada.
	pos: se llama a los demás métodos de la clase controladora, se muestran los lugares quecumplan con la condición anterior.
	**/
	
	public void consultarLugaresProblemas(){
		System.out.println(controller.ListarComunidadPorProblemas());
	}
	
	/*
	Resumen:  se encarga de consultar el lugar con más especies.
	pre: El scanner debe estar inicializado, contoladora debe estar inicializada.
	pos: se llama a los demás métodos de la clase controladora, se muestran los lugares quecumplan con la condición anterior.
	**/
	
	public void consultarLugarMasEspecies(){
		System.out.println(controller.lugarMasEspecies());
		
	}
}