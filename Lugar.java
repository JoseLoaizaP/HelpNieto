package model;
public class Lugar{
	// Atributos (encapsulamiento)
	
	private String nombre;
	private double area;
	private String imagen;
	private double sostenimiento;
	private Departamento departamento;
	private TipoLugar tipoLugar;
	private Especie[] especies;
	private Comunidad comunidad;
	
	/*
	Resumen: Constructor de la clase Lugar.
	@param: String nombre, double area, String imagen, double sostenimiento, Departamento departamento, TipoLugar tipoLugar, Comunidad comunidad.
	Pos: Se crea una instancia de la clase Lugar con los atributos proporcionados, se inicia el arreglo de especies.
	**/
	public Lugar (String nombre, double area, String imagen, double sostenimiento, Departamento departamento, TipoLugar tipoLugar,Comunidad comunidad){
		especies = new Especie[50];
		this.nombre = nombre;
		this.area = area;
		this.imagen = imagen;
		this.sostenimiento = sostenimiento;
		this.departamento = departamento;
		this.tipoLugar = tipoLugar;
		this.comunidad = comunidad; 
	} 
	
	/*
	Resumen: Obtiene todas las especies asociadas al lugar.
	@return: Objeto Especie.
	**/
	
	public Especie[] getEspecie() {
        return especies;
    }	
	
	/*
	Resumen: Agrega una nueva especie al lugar.
	@param: Especie nuevaEspecie. 
	Pos: Se agrega la especie al arreglo de especies asociadas al lugar.
	@return: boolean.
	**/
	
	public boolean agregarEspecie(Especie nuevaEspecie) {

		for(int i=0;i<especies.length;i++){
			
			if(especies[i]==null){
				especies[i]=nuevaEspecie;
				return true;
				}
			}
        return false;
    }

	/*
	Resumen: Obtiene el nombre del lugar.
	@return: El nombre del lugar.
	**/
	
	public String getNombre(){
		return this.nombre;
	}
	
	/*
	Resumen: Obtiene el área del lugar.
	@return: El área del lugar.
	**/
	
	public double getArea(){
		return this.area;
	}
	
	/*
	Resumen: Obtiene la comunidad asociada al lugar.
	@return: La comunidad asociada al lugar.
	**/
	
	public Comunidad getComunidad(){
		return this.comunidad;		
	}
	
	/*
	Resumen: Obtiene el departamento al que pertenece el lugar.
	@return: El departamento al que pertenece el lugar.
	**/
	
	public Departamento getDepartamento(){
		return this.departamento;		
	}
	
	/*
	Resumen: Devuelve una representación en cadena del lugar.
	@return: String msg.
	**/
	
	public String toString(){
		String msg = "";
		
		msg += "nombre: " +nombre;
		msg += "\nEl aerea es: " +area;
		msg += "\nEl link de la imagen es: " +imagen;
		msg += "\nPara sostenerse necesita: " +sostenimiento;
		msg += "\nPertenece al: " + departamento;
		msg += "\nEs de tipo: " + tipoLugar;
		msg += "\nLo proteje la comunidad: " + comunidad.getNombre();
		return msg;
	}
	
	/*
	Resumen: Lista todas las especies asociadas al lugar.
	@return: String lista.
	**/
	
	public String listarEspecie(){
		String lista = "";
		for(int i = 0; i<especies.length; i++){
			if(especies[i]!=null){
				lista +="\n "+ (i + 1) + "-" +especies[i].getNombre();
			}
		}
		return lista;
	}
	
	
	
/*
	Resumen: Busca una especie por su nombre.
	@param: String nombre.
	@return: Especie temp, o null si no se encuentra ninguna.
	**/
	
	public Especie buscarEspecie(String nombre){
		
		for(int i=0;i<especies.length;i++){
			
			Especie temp=especies[i];
			
			if(especies[i]!=null){
				if(nombre.equals(temp.getNombre())){
					return temp;
				}
			}
			
		}
		return null;
	}
	public int lugarMasEspecies(){
		int cantEspecies = 0;
		for (int i = 0; i < especies.length; i ++){
			if(especies[i] != null){
				cantEspecies++;
			}
		}
		return cantEspecies;
	}
	
	
}