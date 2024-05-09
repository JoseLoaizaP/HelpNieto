package model;

public class Producto{
	
	private String nombre;
	private double porcentajeNatural;
	private TipoProducto tipoProducto;
	private boolean hechoAMano;
	private String NombreComunidad;
	
	/*
	Resumen: Constructor de la clase Producto.
	@param: String nombre, double porcentajeNatural, TipoProducto tipoProducto, boolean hechoAMano, String NombreComunidad.
	Pos: Se crea una instancia de la clase Producto con los atributos proporcionados.
	**/
	
	public Producto (String nombre, double porcentajeNatural, TipoProducto tipoProducto, boolean hechoAMano, String NombreComunidad){
		this.nombre = nombre;
		this.porcentajeNatural = porcentajeNatural;
		this.tipoProducto = tipoProducto;
		this.hechoAMano = hechoAMano;
		this.NombreComunidad = NombreComunidad;
		
	}
	
	/*
	Resumen: Devuelve el nombre del producto.
	@return: El nombre del producto.
	**/
	
	public String getNombre(){
		return this.nombre;	
		
	}
	
	/*
	Resumen: Devuelve una representación en cadena del producto.
	@return: Una cadena que contiene información sobre el producto.
	**/
	
	public String toString(){
		String msg = "";
		if (hechoAMano == true){
			msg += "nombre: " + nombre;
			msg += "\nEl porcentaje de naturaleza en el producto es: " +porcentajeNatural;
			msg += "\nEl tipo de producto es: " +tipoProducto;
			msg += "\nElproducto es hecho amano";
			msg += "\nEs de tipo: " + NombreComunidad;
		}
		else{
			msg += "nombre: " + nombre;
			msg += "\nEl porcentaje de naturaleza en el producto es: " +porcentajeNatural;
			msg += "\nEl tipo de producto es: " +tipoProducto;
			msg += "\nElproducto no es hecho amano";
			msg += "\nEs de tipo: " + NombreComunidad;
		}
		

		return msg;
	}
	
}