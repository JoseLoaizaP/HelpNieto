package model;
public class Especie{
	// Atributos (encapsulamiento)
	
	private String nombre;
	private String imagen;
	private int cantAnimales;
	private FaunaFlora faunaFlora;
	
	/*
	Resumen: Constructor de la clase Especie.
	@param: String nombre, FaunaFlora faunaFlora, String imagen, int cantAnimales.
	Pos: Se crea una instancia de la clase Especie con los atributos proporcionados.
	**/
	
	public Especie (String nombre, FaunaFlora faunaFlora, String imagen, int cantAnimales){
		
		this.nombre = nombre;
		this.faunaFlora = faunaFlora;
		this.imagen = imagen;
		this.cantAnimales = cantAnimales;
	}
	
	/*
	Resumen: Devuelve una representación en cadena de la especie.
	@return: String msg.
	**/
	
	public int getCantAnimales (){
		return this.cantAnimales;		
	}
	
	public String toString(){
		String msg = "";
		
		msg += "nombre: " +nombre;
		msg += "\nEs de tipo: " +faunaFlora;
		msg += "\nEl link de la imagen es: " +imagen;
		msg += "\nEs de tipo: " + cantAnimales;

		return msg;
	}
	
	/*
	Resumen: Obtiene el nombre de la especie.
	@return: El nombre de la especie.
	**/
	
	public String getNombre(){
		return this.nombre;
	}
	
	/*
	Resumen: Establece el nombre de la especie.
	@param: String nombre. El nuevo nombre de la especie.
	Pos: Se actualiza el nombre de la especie.
	@return: true si se actualizó correctamente, false en caso contrario.
	**/
	
	public boolean setNombre(String nombre){
		this.nombre = nombre;
		return true;
	}
	
	/*
	Resumen: Establece el tipo de especie (Fauna o Flora).
	@param: FaunaFlora faunaFlora. El nuevo tipo de especie.
	Pos: Se actualiza el tipo de especie.
	@return: true si se actualizó correctamente, false en caso contrario.
	**/

	
	public boolean setFaunaFlora(FaunaFlora faunaFlora){
		this.faunaFlora = faunaFlora;
		return true;
	}
	
	/*
	Resumen: Establece el enlace de la imagen asociada a la especie.
	@param: String imagen. El nuevo enlace de la imagen.
	Pos: Se actualiza el enlace de la imagen asociada a la especie.
	@return: true si se actualizó correctamente, false en caso contrario.
	**/
	
	public boolean setImagen(String imagen){
		this.imagen = imagen;
		return true;
	}
	
	/*
	Resumen: Establece la cantidad de animales de la especie.
	@param: int cantAnimales. La nueva cantidad de animales.
	Pos: Se actualiza la cantidad de animales de la especie.
	@return: true si se actualizó correctamente, false en caso contrario.
	**/
	
	public boolean setCantAnimales(int cantAnimales){
		this.cantAnimales = cantAnimales;
		return true;
	}
	
	public boolean cambiarAnimal(String nuevoNombre, FaunaFlora nuevaFaunaFlora, String nuevaImagen, int nuevaCantAnimales ){
		setNombre(nuevoNombre);
		setFaunaFlora(nuevaFaunaFlora);
		setImagen(nuevaImagen);
		setCantAnimales(nuevaCantAnimales);
		return true;
	}
	
	
}