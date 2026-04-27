# DOCUMENTACION de CDI Scopes en Quarkus
---
## @ApplicationScoped
Se crea una sola instancia para toda la aplicación. El estado se comparte entre todos los usuarios y componentes.
1.- Contador de Visitas: Para rastrear cuántas veces se ha ejecutado un proceso desde que arrancó el sistema.
2.- Gestor de Configuración: Un bean que lee el archivo application.properties y reparte los valores a toda la app.
3.- Caché de Productos: Para guardar en memoria la lista de precios y no consultar la base de datos a cada rato.
4.- Estado del Carrito Global: En apps pequeñas, para manejar estadísticas de ventas del día.
5.- Controlador de Conexión a API Externa: Para mantener una única sesión activa con un servicio de terceros (ej. pasarela de pagos).
6.- Gestor de Inventario: Para asegurar que todos los hilos de la aplicación vean la misma cantidad de stock disponible.
7.- Autenticador de Usuarios: Para manejar la lógica de validación de tokens de forma centralizada.
---

## @Dependent
Se crea una instancia nueva cada vez que se inyecta. Es el scope por defecto.
1.-Calculadora de Impuestos: Cada servicio necesita su propia lógica de cálculo sin interferir con otros.
2.-Generador de Reportes PDF: Cada vez que un usuario pide un reporte, se crea un objeto nuevo para procesar esa descarga única.
3.-Validador de Formularios: Para limpiar y validar datos de entrada de manera aislada en cada petición.
4.-Convertidor de Unidades: Una herramienta auxiliar que se usa y luego el recolector de basura la elimina.
5.-Procesador de Imágenes: Para aplicar filtros o redimensionar una foto específica de forma independiente.
6.-Formateador de Fechas: Para adaptar la salida de texto según el idioma requerido en ese momento específico.
7.-Simulador de Precios: Para realizar cálculos de "qué pasaría si..." sin afectar los datos reales del sistema.
---

## @Singleton
Similar a ApplicationScoped, pero sin "proxies". Es una única instancia real en memoria desde el inicio.
Logger del Sistema: Para escribir en la consola o archivos de texto de manera centralizada y secuencial.
Reloj del Sistema: Un componente que proporciona la hora exacta y sincronizada para toda la aplicación.
Pool de Conexiones: Para administrar cuántas conexiones a la base de datos están abiertas simultáneamente.
Manejador de Errores Global: Una clase que captura cualquier excepción no controlada en el software.
Cargador de Diccionarios: Para mantener en memoria palabras prohibidas o traducciones fijas que nunca cambian.
Gestor de Licencia: Para verificar que la aplicación esté autorizada para correr en ese servidor.
Registro de Componentes: Un índice que sabe qué servicios están activos dentro de la arquitectura.

