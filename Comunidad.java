package model;
public class Comunidad{
	// Atributos (encapsulamiento)
	
	private String nombre;
	private TipoComunidad comunidad;
	private String nombreLider;
	private String celLider;
	private Producto[] almacenamientoProducto;
	private ProblemasComunidad problemas;
	
	
	/*
	Resumen: Constructor de la clase Comunidad.
	@param: String nombre, String nombreLider, String celLider, TipoComunidad comunidad, ProblemasComunidad problemas.
	Pos: Se crea una instancia de la clase Comunidad con los atributos proporcionados, se inicializa el arreglo de productos.
	**/

	public Comunidad (String nombre,String nombreLider, String celLider, TipoComunidad comunidad, ProblemasComunidad problemas){
		almacenamientoProducto = new Producto[20];
		this.nombre = nombre;
		this.nombreLider = nombreLider;
		this.celLider = celLider;
		this.comunidad = comunidad;
		this.problemas = problemas;
	}
	
	/*
	Resumen: Obtiene el nombre de la comunidad.
	@return: El nombre de la comunidad.
	**/
	
	public String getNombre(){
		return this.nombre;
	}
	
	/*
	Resumen: Obtiene el problema principal de la comunidad.
	@return: El problema principal de la comunidad.
	**/
	
	public ProblemasComunidad getProblema(){
		return this.problemas;
	}
	
	/*
	Resumen: Agrega un nuevo producto al almacenamiento de la comunidad.
	@param: Producto nuevoProducto.
	Pos: Se agrega el producto al almacenamiento de la comunidad.
	@return: boolean.
	**/
	
	public boolean agregarProducto(Producto nuevoProducto) {

		for(int i=0;i<almacenamientoProducto.length;i++){
			
			if(almacenamientoProducto[i]==null){
				almacenamientoProducto[i]=nuevoProducto;
				return true;
				}
			}
        return false;
    }
	
	/*
	Resumen: Devuelve una representación en cadena de la comunidad.
	@return: String msg.
	**/
	
	public String toString(){
		String msg = "";
		
		msg += "nombre: " +nombre;
		msg += "\nEl nombre del lider es: " +nombreLider;
		msg += "\nEl numero del telefono del lider es: " +celLider;
		msg += "\nEs de tipo: " + comunidad;
		msg += "\nEl problema principal de la comunidad es: " + problemas;
		return msg;
	}
	
	
	/*
	Resumen: Lista todos los productos almacenados en la comunidad.
	pre: el arreglo de productos debe estar iniciallizado.
	@return: String lista.
	**/

	
	public String listarProducto(){
		String lista = "";
		for(int i = 0; i<almacenamientoProducto.length; i++){
			if(almacenamientoProducto[i]!=null){
				lista +="\n "+ (i + 1) +"-"+almacenamientoProducto[i].getNombre();
			}
		}
		return lista;
	}
	
	/*
	Resumen: Busca un producto por su nombre.
	@param: String nombre.
	@return: El producto encontrado con el nombre especificado, o null si no se encuentra ninguno.
	**/

	
	public Producto buscarProducto(String nombre){
		
		for(int i=0;i<almacenamientoProducto.length;i++){
			
			Producto temp=almacenamientoProducto[i];
			
			if(almacenamientoProducto[i]!=null){
				if(nombre.equals(temp.getNombre())){
					return temp;
				}
			}
			
		}
		return null;
	}
	
	public boolean eliminarProducto (String nombre){
		for (int i = 0; i < almacenamientoProducto.length; i++){
			if (almacenamientoProducto[i] != null){
				Producto temp = almacenamientoProducto[i];
				if (temp.getNombre().equals(nombre)){
					temp = null;
					almacenamientoProducto[i] = null;
					return true;
				}
			}
		}
		return false;
	}
	
	
}