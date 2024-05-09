package model;

public class Controladora{
	// relación
	private Lugar[] almacenamientoLugar;
	private Comunidad[] almacenamientoComunidad;
	
	/*
	Resumen: inicializa varios arreglos para almacenar información relacionada con lugares y comunidades.
	pos: Después de que se crea una instancia de la clase Controladora utilizando este constructor, los arreglos almacenamiento, comunidadAlmacenada, departamentos y tipoLugar están listos para ser utilizados en otros métodos de la clase Controladora
	**/
	
	public Controladora(){
		almacenamientoLugar =new Lugar[200];	
		almacenamientoComunidad = new Comunidad[50];
		
	}
	
	/*
	Resumen: se encarga de almacenar un nuevo lugar en el arreglo.
	@param: String nombre, double area, String imagen, double sostenimiento, int departamento, int tipoLugar, String comunidad.
	pre: El arreglo de lugares y de comunidades deben estar inicializado.
	pos: Se almacena un nuevo lugar al arreglo de lugares.
	@return: boolean.
	**/	
	
	public boolean registrarLugar(String nombre, double area, String imagen, double sostenimiento, int departamento, int tipoLugar, String comunidad){
		Departamento nuevoLugar = Departamento.Valle;
		switch (departamento){
			case 1:
				nuevoLugar = Departamento.Valle;
			break;
			case 2:
				nuevoLugar = Departamento.Cauca;
			break;
			case 3:
				nuevoLugar = Departamento.Nariño;
			break;
			case 4:
				nuevoLugar = Departamento.Choco;
			break;
		}
		
		
		TipoLugar nuevoTipoLugar = TipoLugar.Área_protegida;
		switch (tipoLugar){
			case 1:
				nuevoTipoLugar = TipoLugar.Área_protegida;
			break;
			case 2:
				nuevoTipoLugar = TipoLugar.Parque_nacional;
			break;
			case 3:
				nuevoTipoLugar = TipoLugar.Área_privada;
			break;
		}
		
		Comunidad nuevaComunidad = buscarComunidad(comunidad);
		
		Lugar lugar = new Lugar(nombre,area,imagen,sostenimiento,nuevoLugar, nuevoTipoLugar, nuevaComunidad );
		for (int i = 0; i<almacenamientoLugar.length; i++){
			if (almacenamientoLugar[i] == null){
				almacenamientoLugar[i] = lugar;
				return true;
			}
			else if (almacenamientoLugar[i].getNombre().equals(nombre)) {
				return false;
			}

		}
		return false;		
	}
	
	/*
	Resumen: se encarga de almacenar una nueva comunidad en el arreglo.
	@param: String nombre,String nombreLider, String celLider, int comunidad, int problema.
	pre: El arreglo de comunidades debe estar inicializado.
	pos: Se almacena un nuevo lugar al arreglo de lugares.
	@return: boolean.
	**/	
	
	
	public boolean registrarComunidad(String nombre,String nombreLider, String celLider, int comunidad, int problema ){
		TipoComunidad nuevoTipoComunidad = TipoComunidad.Afrocolombiana;
		switch (comunidad){
			case 1:
				nuevoTipoComunidad = TipoComunidad.Afrocolombiana;
			break;
			case 2:
				nuevoTipoComunidad = TipoComunidad.Indigena;
			break;
			case 3:
				nuevoTipoComunidad = TipoComunidad.Raizal;
			break;
		}
		
		ProblemasComunidad nuevoProblema = ProblemasComunidad.falta_de_hospital;
		switch (problema){
			case 1:
				nuevoProblema = ProblemasComunidad.falta_de_hospital;
			break;
			case 2:
				nuevoProblema = ProblemasComunidad.falta_de_escuela;
			break;
			case 3:
				nuevoProblema = ProblemasComunidad.falta_de_agua_potable;
			break;
			case 4:
				nuevoProblema = ProblemasComunidad.falta_de_acceso_a_alimentación_básica;
			break;
		}
		
		Comunidad nuevaComunidad = new Comunidad(nombre,nombreLider, celLider, nuevoTipoComunidad,nuevoProblema );
		for (int i = 0; i<almacenamientoComunidad.length; i++){
			if (almacenamientoComunidad[i] == null){
				almacenamientoComunidad[i] = nuevaComunidad;
				return true;
			}
			else if (almacenamientoComunidad[i].getNombre().equals(nombre)) {
				return false;
			}
			
		}
		return false;
	}
	
	/*
	Resumen: Busca una comunidad por su nombre.
	@param: String comunidad. El nombre de la comunidad que se desea buscar.
	Pre: El arreglo de comunidades debe estar inicializado.
	Pos: Se devuelve la comunidad encontrada con el nombre especificado, o null si no se encuentra ninguna.
	@return: Comunidad Temp / null.
	**/
	
	public Comunidad buscarComunidad(String comunidad){
		
		for(int i=0;i<almacenamientoComunidad.length;i++){
			
			Comunidad temp=almacenamientoComunidad[i];
			
			if(almacenamientoComunidad[i]!=null){
				if(comunidad.equals(temp.getNombre())){
					return temp;
				}
			}
			
		}
		return null;
	}
	
	/*
	Resumen: Registra una especie en un lugar específico.
	@param: String nombre, int faunaFlora, String imagen, int cantAnimales, String lugar.
	Pre: El arreglo de lugares debe estar inicializado.
	Pos: Se registra la especie en el lugar especificado.
	@return: boolean
	**/
	
	public boolean registrarEspecieEnLugar(String nombre, int faunaFlora, String imagen, int cantAnimales, String lugar) {
		
		FaunaFlora nuevaFaunaFlora = FaunaFlora.Fauna;
		switch(faunaFlora){
			case 1:
				nuevaFaunaFlora=FaunaFlora.Fauna;
			break;
			case 2:
				nuevaFaunaFlora=FaunaFlora.Flora;
			break;
		}
		
		
		Especie nuevaEspecie =new Especie(nombre,nuevaFaunaFlora,imagen,cantAnimales);
		
		if(buscarLugar(lugar).agregarEspecie(nuevaEspecie)){
			return true;
		}
        return false;
    }
	

	
	/*
	Resumen: Este método buscarLugar de la clase Controladora se encarga de buscar un lugar por su nombre en el arreglo
	@param: String nombre.
	pre: El arreglo de lugares debe estar inicializado.
	@return: Lugar temp.
	**/
	
	public Lugar buscarLugar(String nombre){
		
		for(int i=0;i<almacenamientoLugar.length;i++){
			
			Lugar temp=almacenamientoLugar[i];
			
			if(almacenamientoLugar[i]!=null){
				if(nombre.equals(temp.getNombre())){
					return temp;
				}
			}
			
		}
		return null;
	}
	
	/*
	Resumen: Genera una lista de nombres de comunidades almacenadas.
	Pre: El arreglo de comunidades debe estar inicializado.
	@return: lista.
	**/

	
	public String listarComunidad(){
		String lista = "";
		for(int i = 0; i<almacenamientoComunidad.length; i++){
			if(almacenamientoComunidad[i]!=null){
				lista +="\n nombre de la comunidad " +almacenamientoComunidad[i].getNombre();
			}
		}
		return lista;
	}
	
	/*
	Resumen: Genera una lista de nombres de lugares almacenados.
	Pre: El arreglo de lugares debe estar inicializado.
	@return: lista.
	**/

	
	public String listarLugar(){
		String lista = "";
		for(int i = 0; i<almacenamientoLugar.length; i++){
			if(almacenamientoLugar[i]!=null){
				lista +="\n nombre del lugar " +almacenamientoLugar[i].getNombre();
			}
		}
		return lista;
	}
	
	/*
	Resumen:  se encarga de mostrar la información detallada de un lugar específico
	@param: String nombre.
	pre: El arreglo de lugares debe estar inicializado.
	@return: String.
	**/
	
	public String mostrarLugar (String nombre){
		Lugar temporal = buscarLugar(nombre);
		if (temporal == null){
			return "El producto no se encuentra";
		}
		return temporal.toString ();
	}
	
	/*
	Resumen: Registra un nuevo producto en una comunidad especificada.
	@param: String nombre, double porcentajeNatural, int tipoProducto, int hechoAMano, String nombreComunidad.
	Pre: El arreglo de comunidades debe estar inicializado.
	Pos: Se registra un nuevo producto en la comunidad especificada.
	@return: boolean.
	**/

	
	public boolean registrarProductoEnComunidad(String nombre, double porcentajeNatural, int tipoProducto, int hechoAMano, String nombreComunidad) {
		TipoProducto nuevoTipoProducto = TipoProducto.Alimento;
		switch(tipoProducto){
			case 1:
				nuevoTipoProducto=TipoProducto.Alimento;
			break;
			case 2:
				nuevoTipoProducto=TipoProducto.Artesania;
			break;
		}
		
		boolean nuevoHechoAMano = true;
		switch(hechoAMano){
			case 1:
				nuevoHechoAMano=true;
			break;
			case 2:
				nuevoHechoAMano=false;
			break;
		}
		
		
		Producto nuevoProducto =new Producto(nombre,porcentajeNatural, nuevoTipoProducto, nuevoHechoAMano, nombreComunidad );
		
		if(buscarComunidad(nombreComunidad).agregarProducto(nuevoProducto)){
			return true;
		}
        return false;
    }
	


	

	/*
	Resumen: Muestra la información de una comunidad específica.
	@param: String nombre.
	Pre: El arreglo de comunidades debe estar inicializado.
	Pos: Se muestra la información de la comunidad especificada.
	@return: Una cadena que contiene la información de la comunidad o un mensaje indicando que la comunidad no se encontró.
	**/
	
	public String mostrarComunidad (String nombre){
		Comunidad temporal = buscarComunidad(nombre);
		if (temporal == null){
			return "La comunidad no se encuentra";
		}
		return temporal.toString ();
	}
	
	/*
	Resumen: Crea comunidades iniciales con la información proporcionada.
	Pre: El arreglo de comunidades debe estar inicializado.
	Pos: Se registran las comunidades iniciales en el sistema.
	**/
	
	public void crearComunidadInicial(){
		registrarComunidad("Chicha", "Carlos", "3174572724", 1, 2);
		registrarComunidad("Pichincha", "Alberto", "3004732904", 2, 3);
	}
	
	
	/*
	Resumen: Crea lugares iniciales con la información proporcionada.
	Pre: Los arreglos de lugares y de comunidades deben estar inicializados.
	Pos: Se registran los lugares iniciales en el sistema.
	**/
	
	public void crealLugarInicial(){
		registrarLugar("Juanchito", 123231, "123esw2qwsxde", 1232533, 3, 2, "Chicha");
		registrarLugar("Cerrito", 3212443, "34432wsggrrf", 4532533, 2, 3, "Pichincha");
	}
	
	
	public void crearEspecieInicial(){
		registrarEspecieEnLugar("Perro de pradera", 1 , "erfgb342sxde", 533, "Juanchito");
		registrarEspecieEnLugar("Orquidea mariposa", 2, "3jkukuytdc", 56, "Cerrito");
	}
	
	
	public void crearProductoInicial(){
		registrarProductoEnComunidad("Chicharron de tití", 34, 1 , 1, "Chicha");
		registrarProductoEnComunidad("Máscara rupestre", 100, 2, 2, "Pichincha");
	}
	
	/*
	Resumen: Lista las especies de un lugar específico.
	@param: String nombre. 
	Pre: El arreglo de lugares debe estar inicializado.
	Pos: Se lista las especies del lugar especificado.
	@return: String lista.
	**/
	
	public String listarEspecies (String nombre){
		String lista = "";
		for(int i = 0; i<almacenamientoLugar.length; i++){
			if(almacenamientoLugar[i]==buscarLugar(nombre)){
				lista +="\n " + buscarLugar(nombre).listarEspecie();;	
			}
		}
		return lista;		
	}
	
	/*
	Resumen: Lista los productos de una comunidad específica.
	@param: String nombre. 
	Pre: El arreglo de comunidades debe estar inicializado.
	Pos: Se lista los productos de la comunidad especificada.
	@return: String lista.
	**/
	
	public String listarProductos (String nombre){
		String lista = "";
		for(int i = 0; i<almacenamientoComunidad.length; i++){
			if(almacenamientoComunidad[i]==buscarComunidad(nombre)){
				lista +="\n " + buscarComunidad(nombre).listarProducto();;	
			}
		}
		return lista;		
	}
	
	/*
	Resumen: Muestra la información de una especie específica en un lugar dado.
	@param: String nombre, String nombreEsp. 
	Pre: El arreglo de lugares debe estar inicializado.
	Pos: Se muestra la información de la especie especificada.
	@return: Una cadena que contiene la información de la especie encontrada.
	**/
	
	public String mostrarEspecie (String nombre, String nombreEsp){
		return buscarLugar(nombre).buscarEspecie(nombreEsp).toString();
	}
	

	
	/*
	Resumen: Muestra la información de un producto específico en una comunidad dada.
	@param: String nombre, String nombreProd. 
	Pre: El arreglo de comunidades debe estar inicializado.
	Pos: Se muestra la información del producto especificado.
	@return: Una cadena que contiene la información del producto encontrado.
	**/
	
	public String mostrarProducto (String nombre, String nombreProd){
		return buscarComunidad(nombre).buscarProducto(nombreProd).toString();
	}
	
	public Lugar buscarLugarPorDept(Departamento departamento){
		
		for(int i=0;i<almacenamientoLugar.length;i++){
			
			Lugar temp=almacenamientoLugar[i];
			
			if(almacenamientoLugar[i]!=null){
				if(departamento.equals(temp.getDepartamento())){
					return temp;
				}
			}
			
		}
		return null;
	}
	
	/*
	Resumen: Busca un lugar por departamento.
	@param: Departamento departamento. El departamento por el cual se desea buscar un lugar.
	Pre: El arreglo de lugares debe estar inicializado.
	Pos: Se devuelve el primer lugar encontrado que coincida con el departamento especificado, o null si no se encuentra ningún lugar.
	@return: El primer lugar encontrado que coincida con el departamento especificado, o null si no se encuentra ningún lugar.
	**/
	
	public String listarComunidadDepartamento(int departamento){
		Departamento nuevoLugar = Departamento.Valle;
		switch (departamento){
			case 1:
				nuevoLugar = Departamento.Valle;
			break;
			case 2:
				nuevoLugar = Departamento.Cauca;
			break;
			case 3:
				nuevoLugar = Departamento.Nariño;
			break;
			case 4:
				nuevoLugar = Departamento.Choco;
			break;
		}
		String lista = "";
		
		Lugar temporal = buscarLugarPorDept(nuevoLugar);

		if (temporal != null){
			for (int i = 0; i < almacenamientoLugar.length; i++) {
				Lugar temp = almacenamientoLugar[i];
				if (temp != null){
					if (buscarLugarPorDept(nuevoLugar) != null) {
						if (temp.getDepartamento().equals(nuevoLugar)){
							lista += "\n " + buscarLugarPorDept(nuevoLugar).getComunidad().getNombre();
						}
					}
				}
			}
		}
		return lista;	
	}
	
	/*
	Resumen: Lista los tres lugares con mayor área.
	Pre: El arreglo de lugares debe estar inicializado.
	Pos: Se devuelve una lista que contiene los tres lugares con mayor área.
	@return: String Lista
	**/
	
    public String listarTopTresLugaresPorArea() {
        
        Lugar[] lugaresCopia = new Lugar[almacenamientoLugar.length];
        for (int i = 0; i < almacenamientoLugar.length; i++) {
			if (almacenamientoLugar[i] != null) {
				lugaresCopia[i] = almacenamientoLugar[i];
			}
        }

        
        for (int i = 0; i < lugaresCopia.length - 1; i++) {
            for (int j = 0; j < lugaresCopia.length - 1 - i; j++) {
                if (lugaresCopia[j] != null && lugaresCopia[j + 1] != null && lugaresCopia[j].getArea() < lugaresCopia[j + 1].getArea()) {
                    Lugar temp = lugaresCopia[j];
                    lugaresCopia[j] = lugaresCopia[j + 1];
                    lugaresCopia[j + 1] = temp;
                }
            }
        }

        
        StringBuilder lista = new StringBuilder();
        lista.append("Los tres lugares con mayor área son:\n");
        int count = 0;
        for (Lugar lugar : lugaresCopia) {
            if (lugar != null && count < 3 ) {
                lista.append(count + 1).append(". ").append(lugar.getNombre()).append(" - ").append(lugar.getArea()/1000).append(" Km²\n");
                count++;
            }
        }

        return lista.toString();
    }
	
	/*
	Resumen: Lista las comunidades que tienen problemas específicos.
	Pre: El arreglo de comunidades debe estar inicializado.
	Pos: Se devuelve una lista que contiene las comunidades que tienen problemas específicos.
	@return: String msg.
	**/
	
	public String ListarComunidadPorProblemas (){
		String msg = "";
		
		for (int i = 0; i<almacenamientoComunidad.length; i++){
			if(almacenamientoComunidad[i]!= null){
				if (almacenamientoComunidad[i].getProblema().equals(ProblemasComunidad.falta_de_escuela) || almacenamientoComunidad[i].getProblema().equals(ProblemasComunidad.falta_de_escuela)){
					msg += ("\n" + almacenamientoComunidad[i].getNombre());
				}
			}
		}
		return msg;
	}
	
	/*
	Resumen: Lista las comunidades que tienen problemas específicos.
	Pre: El arreglo de comunidades debe estar inicializado.
	Pos: Se devuelve una lista que contiene las comunidades que tienen problemas específicos.
	@return: String msg.
	**/
	
	public Lugar mostrarLugarMasEspecies(){
		for (int i = 0; i<almacenamientoLugar.length; i++){
			
			if (almacenamientoLugar != null){
				Lugar nuevoLugar = almacenamientoLugar[i];
				return nuevoLugar;
			}			
			
		}
		return null;
	}
	
	/*
	Resumen: Elimina un producto.
	Pre: El arreglo de comunidades debe estar inicializado.
	Pos: se libera un espacio en el almacenamiento de productos.
	@return: boolean.
	**/
	
	public boolean eliminarProducto(String nombre, String nombreProd){
		if (buscarComunidad(nombre).eliminarProducto(nombreProd)){
			return true;
		}
		else{
			return false;
		}
	}
	
/*
	Resumen: Devuelve el nombre y la cantidad de especies del lugar con más especies.
	@return: Una cadena que contiene el nombre del lugar con más especies y la cantidad de especies.
	**/
	
	public String lugarMasEspecies(){
		String msg = "";
		int maximo = 0;
		int indice = 0;
		for (int i = 0; i < almacenamientoLugar.length; i++){
			if (almacenamientoLugar[i] != null){
				if (almacenamientoLugar[i].lugarMasEspecies() > maximo){
					maximo = almacenamientoLugar[i].lugarMasEspecies();
					indice = i;
				}
			}
			
		}
		return "El lugar con más especies es: " + almacenamientoLugar[indice] + " y la cantidad de especies es: " + maximo;
	}
	
	/*
	Resumen: Cambia los atributos de una especie.
	@param: String nombreLugar, String nombreOriginal, String nuevoNombre, int faunaFlora, String nuevaImagen, int nuevaCantAnimales.
	Pos: Se cambian los atributos de la especie especificada.
	@return: true si se cambió correctamente.
	**/
	
	public boolean cambiarAnimal(String nombreLugar, String nombreOriginal, String nuevoNombre, int faunaFlora, String nuevaImagen, int nuevaCantAnimales){
		FaunaFlora nuevaFaunaFlora = FaunaFlora.Fauna;
		switch(faunaFlora){
			case 1:
				nuevaFaunaFlora=FaunaFlora.Fauna;
			break;
			case 2:
				nuevaFaunaFlora=FaunaFlora.Flora;
			break;
		}
		buscarLugar(nombreLugar).buscarEspecie(nombreOriginal).cambiarAnimal(nuevoNombre,nuevaFaunaFlora ,nuevaImagen, nuevaCantAnimales);
		return true;
	}
	
	
}