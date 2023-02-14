# TG3Grupo1
## Introducción
    
    #CAMBIAR CONTENIDO DE README
    # Estructuras de aplicacion

        La aplicacion se divide en diversas carpetas donde cada uno representa una funcion diferente al resto
        cada packete contiene sus clases correspondiente y estas se dividen en Codigo y Interfaz,
        cada participante del grupo tiene asignado o Codigo o Interfaz como su prncipal tarea

        Adapters {
            SerieAdapter : Esta clse genera los metodos necesarios para poder viisualizar en la 
            aplicacion la informacion de la base de datos
        }

        BBDD {
            Aqui se encuentran todas las clases que conectan con la base de datos y interactuan de alguna manera con esta
            DownloadJson : Permite la descarga del JSON para poder trabajar sobre esta
            ModeloAdo : En esta clase se generan los metodos para para poder interactuar con la base de datos 
            ModeloHelper : Crea la base de datos 
        }

        Fragments {
            ContenidoGeneral : 
            Descripcion : 
        }

        Vista {
            Inicio: Aqui se muestra el inicio de la aplicacion el cual muestra los datos de la tabla
            Splash : La presentacion de la aplicacion antes de la inicializacion de esta 
            
        }

        

    #Estructuras de proyecto
        #Actividades
            #(Nicolas Del Amo / Codigo - Jefe de Proyecto)
                Se encarga principalmente de organizar y tomar las decisiones del equipo
                    Recursos / Programación / BBDD

            #(Daniel Alvaro del Rio / Codigo)
                Se encargará principalmente de la programacion y estructurar las actividades
                    Fragments / Correccion de errores / JSON

            #(Christian Martinez / Interfaz)
                Se encargará de la interfaz y las decisiones de diseño
                    Interfaz / Creacion de Diseño

            #(Miguel Lizaranzu / Interfaz)
                Se encargará de ayudar al deseño de las interfazes
                    Diseño / Alert dialogs

        # Controles:
            - Tres botones de menu de fragments que despliegan diferentes aletrs dialog

        # Lógica de negocio
            - La aplicacion mantendra un registro de toda la base de datos

    #Descripción del proyecto
        #Descripción general
            Nuestra aplicacion consiste en una base de datos con diseño de Cyberpunk 2077 la cual
            guarda registros de paradas de taxi para ello guarda una id que identifica el registro,
            la calle donde se detiene, el dia de la ultima actualizacion, las cordenadas y si se 
            desea un icono o foto representativo
            
        #Descripción detallada de cada uno
            (Nicolas del amo)
            [Se ocupó de liderar el grupo, crear el adapter y los modelos de las consultas ]

            (Daniel del rio)
            [Se ocupó completamente de todo el JSON y de arreglar los errores que venina con este]

            (Christian martinez)
            [Se ocupó de la interfaz principalemnte de como seria la tematica]

            (Miguel Lizaranzu)
            [Se ocupó de Asistir en el diseño y los alert dialog]
