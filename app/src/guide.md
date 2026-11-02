lo que yo copie sera en el idioma de español y espero que tus respuestas tambien me las des en español.

Proyecto: InterCommerce App (Android Nativo)
1. Descripción del Producto
   El candidato debe desarrollar un MVP de una aplicación móvil de E-commerce robusta,
   optimizada para rendimiento nativo en Android utilizando Kotlin y diseñada bajo principios de
   ingeniería de software que permitan su escalabilidad, mantenibilidad y máxima resiliencia en
   entornos de producción con conectividad inestable.
   Módulos y Funcionalidades

   • Módulo A: Catálogo Móvil (Discovery)
   o Visualización: Lista o Grid optimizado utilizando Jetpack Compose
   (LazyVerticalGrid o LazyColumn).
   o Carga Progresiva: Implementación obligatoria de Shimmer/Skeletons con
   animaciones fluidas durante el fetching de datos.
   o Scroll Infinito: Paginación fluida (Lazy Loading) gestionando correctamente
   los estados del scroll mediante Paging 3 o lógica personalizada con
   corrutinas.
   o Modo Offline (Resiliencia de Datos): Los productos cargados desde la red
   deben persistir localmente de forma estructurada. Si el dispositivo pierde
   conexión o falla la API, la aplicación debe ser capaz de degradar su
   funcionalidad de manera elegante, exponiendo inmediatamente los datos
   almacenados en la base de datos local al usuario.


   • Módulo B: Detalle de Producto (Conversion)
   o Navegación: Implementación del sistema oficial de Compose Navigation
   (basado en tipos / Type-Safe Navigation).
   o Gestión de Imágenes: Uso de librerías de carga eficiente (ej. Coil)
   configurando de manera estricta el almacenamiento en caché en disco, caché
   en memoria y placeholders en caso de error.
   o Interacción: Feedback visual e integración de vibración táctil nativa al
   interactuar con el botón "Agregar al carrito".


   • Módulo C: Carrito de Compras (Persistence & Logic)
   o Gestión de Estado: Arquitectura reactiva utilizando StateFlow/SharedFlow y
   componentes de ciclo de vida (ViewModel).
   o Persistencia Local Obligatoria: El carrito y los datos cacheados deben
   sobrevivir al cierre completo de la aplicación, reinicios del sistema o purgas
   de memoria del S.O. Para garantizar esto, el candidato debe implementar el
   almacenamiento utilizando SQLite (a través de Room Database) o
   ObjectBox. (No se aceptarán soluciones basadas exclusivamente en
   SharedPreferences simples o clave-valor como DataStore para el volumen
   transaccional del catálogo).
   o Lógica de Negocio: El cálculo de totales, impuestos y descuentos debe
   residir estrictamente en la capa de Domain (Usecases o Entities puras en
   Kotlin, completamente aisladas de los frameworks de persistencia o vistas).


2. Requerimientos de Ingeniería (Criterios de Evaluación)
   Arquitectura de Software
   • Clean Architecture: Separación clara y obligatoria en capas:
   o Data: Repositorios, fuentes de datos remotas (API) e internas (DAOs de
   SQLite/Room o ObjectBox), y mappers de transformación de datos (Data
   Transfer Objects a Domain Entities).
   o Domain: Entidades puras de negocio (Kotlin Data Classes inmutables) y
   Casos de Uso (Usecases / Interactors).
   o Presentation: UI Declarativa con Jetpack Compose y ViewModels encargados
   del estado operacional de la vista.
   • Inyección de Dependencias (DI): Uso obligatorio de Hilt o Koin para desacoplar las
   instancias de las bases de datos locales, clientes de red y repositorios, facilitando la
   modularización y el testing.
   Networking y Resiliencia
   • Cliente de Red: Uso de Retrofit o Ktor Client configurado con interceptores de logs y
   cabeceras.
   • Manejo de Errores y Excepciones: Gestión centralizada de excepciones para
   escenarios críticos (Timeouts, errores HTTP 404/500, fallos de deserialización y
   pérdida abrupta de conectividad). La capa de datos debe interceptar estos errores y
   decidir cuándo servir la información desde la persistencia local en SQLite/ObjectBox
   de forma transparente para la UI.
   • Modelado: Uso de la inmutabilidad nativa de Kotlin (val) y serialización segura con
   Kotlinx Serialization o Moshi.
   Calidad y Testing
   • Testing: Pruebas unitarias obligatorias utilizando JUnit 5/4 y MockK (o Mockito-Kotlin)
   sobre la lógica de los Casos de Uso o ViewModels.
   • Performance: Uso adecuado de composables estables, reducción de
   recomposiciones innecesarias y correcta delegación de hilos pesados de
   entrada/salida a los hilos de fondo mediante Kotlin Coroutines (using
   Dispatchers.IO).

 
6. Instrucciones de Entrega
 
   • Se evaluará la limpieza del código, el apego a las guías oficiales de Kotlin (Kotlin
   Coding Conventions) y la organización por paquetes orientada a características
   (package-by-feature).
 


Tareas ya completadas del proyecto 
1. ya se crearon 2 splahscreen adicional a otra pantalla cuando no se tiene conecion a internet
2. se creo el home consumiendo las apis implementadas, permitiendo mostrar el skeleton de carga
3. se implemento el cliente de red ktor 
4. se crearon los modelos nesesarios.
5. se creo la pantallade home y detalle de producto
6. Implementar vibración al agregar carrito.
7. Arquitectura basada en Clean Architecture.
8. se creo la pantalla de cart 
9. ya estan los casos de uso para cart
10. se agregaron 4 test para los casos de uso y 1 test para el view model
- se creo el dto de cart el entyp 
- se creo el repository de cart
- Patrón Repository.
- Offline First mediante Room.
- Inyección de Dependencias con Hilt.
- UI declarativa con Jetpack Compose.
- Estado reactivo mediante StateFlow.
- Networking con Ktor.
- Serialización con Kotlinx Serialization.

archivos creados
C:\Users\john\AndroidStudioProjects\InterCommerceApp\app\src\main\java\com\inter_rapidisimo\intercommerceapp\application\KtorClient\KtorClient.kt.
C:\Users\john\AndroidStudioProjects\InterCommerceApp\app\src\main\java\com\inter_rapidisimo\intercommerceapp\data\source\remote\api\ApiRoutes.kt
C:\Users\john\AndroidStudioProjects\InterCommerceApp\app\src\main\java\com\inter_rapidisimo\intercommerceapp\di\AppModule.kt
C:\Users\john\AndroidStudioProjects\InterCommerceApp\app\src\main\java\com\inter_rapidisimo\intercommerceapp\domain\product\Product.kt
C:\Users\john\AndroidStudioProjects\InterCommerceApp\app\src\main\java\com\inter_rapidisimo\intercommerceapp\domain\product\ProductList.kt
C:\Users\john\AndroidStudioProjects\InterCommerceApp\app\src\main\java\com\inter_rapidisimo\intercommerceapp\domain\product\Review.kt
C:\Users\john\AndroidStudioProjects\InterCommerceApp\app\src\main\java\com\inter_rapidisimo\intercommerceapp\presentation\common\widgets\IsometricBoxIcon.kt
C:\Users\john\AndroidStudioProjects\InterCommerceApp\app\src\main\java\com\inter_rapidisimo\intercommerceapp\presentation\common\widgets\LoadingArcIcon.kt
C:\Users\john\AndroidStudioProjects\InterCommerceApp\app\src\main\java\com\inter_rapidisimo\intercommerceapp\presentation\home\utils\Modifiers.kt
C:\Users\john\AndroidStudioProjects\InterCommerceApp\app\src\main\java\com\inter_rapidisimo\intercommerceapp\presentation\home\utils\Utils.kt
C:\Users\john\AndroidStudioProjects\InterCommerceApp\app\src\main\java\com\inter_rapidisimo\intercommerceapp\presentation\home\widget\ApiProductGridCard.kt
C:\Users\john\AndroidStudioProjects\InterCommerceApp\app\src\main\java\com\inter_rapidisimo\intercommerceapp\presentation\home\widget\BestSellersSection.kt
C:\Users\john\AndroidStudioProjects\InterCommerceApp\app\src\main\java\com\inter_rapidisimo\intercommerceapp\presentation\home\widget\CategoryShortcutItem.kt
C:\Users\john\AndroidStudioProjects\InterCommerceApp\app\src\main\java\com\inter_rapidisimo\intercommerceapp\presentation\home\widget\FastShippingInfoCard.kt
C:\Users\john\AndroidStudioProjects\InterCommerceApp\app\src\main\java\com\inter_rapidisimo\intercommerceapp\presentation\home\widget\FeaturedProductsSection.kt
C:\Users\john\AndroidStudioProjects\InterCommerceApp\app\src\main\java\com\inter_rapidisimo\intercommerceapp\presentation\home\widget\HomeBottomNavigationBar.kt
C:\Users\john\AndroidStudioProjects\InterCommerceApp\app\src\main\java\com\inter_rapidisimo\intercommerceapp\presentation\home\widget\HomeCategoryShortcuts.kt
C:\Users\john\AndroidStudioProjects\InterCommerceApp\app\src\main\java\com\inter_rapidisimo\intercommerceapp\presentation\home\widget\HomeHeaderSection.kt
C:\Users\john\AndroidStudioProjects\InterCommerceApp\app\src\main\java\com\inter_rapidisimo\intercommerceapp\presentation\home\widget\HomePromoBanner.kt
C:\Users\john\AndroidStudioProjects\InterCommerceApp\app\src\main\java\com\inter_rapidisimo\intercommerceapp\presentation\home\widget\ProductGridCard.kt
C:\Users\john\AndroidStudioProjects\InterCommerceApp\app\src\main\java\com\inter_rapidisimo\intercommerceapp\presentation\home\HomeScreen.kt
C:\Users\john\AndroidStudioProjects\InterCommerceApp\app\src\main\java\com\inter_rapidisimo\intercommerceapp\presentation\product\ProductScreen.kt
C:\Users\john\AndroidStudioProjects\InterCommerceApp\app\src\main\java\com\inter_rapidisimo\intercommerceapp\presentation\product\ProductViewModel.kt
C:\Users\john\AndroidStudioProjects\InterCommerceApp\app\src\main\java\com\inter_rapidisimo\intercommerceapp\presentation\splash\OfflineSplashScreen.kt
C:\Users\john\AndroidStudioProjects\InterCommerceApp\app\src\main\java\com\inter_rapidisimo\intercommerceapp\presentation\splash\SplashScreen.kt