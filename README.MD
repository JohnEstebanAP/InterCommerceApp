# 🛒 InterCommerce App

Prueba técnica desarrollada para Inter Rapidísimo.

Aplicación Android nativa de E-commerce construida con Kotlin y Jetpack Compose, diseñada bajo principios de Clean Architecture, Offline First y escalabilidad para entornos de producción con conectividad inestable.

---

# 📱 Características Implementadas

## Catálogo de Productos

✅ Consumo de API DummyJSON

✅ Jetpack Compose

✅ Skeleton Loading / Shimmer

✅ Scroll Infinito (Lazy Loading)

✅ Paginación dinámica

✅ Gestión de estados de carga

✅ Manejo de errores

✅ Navegación de productos


---

## Detalle de Producto

✅ Pantalla de detalle

✅ Carga de imágenes con Coil

✅ Cache de imágenes

✅ Feedback háptico (vibración)

✅ Navegación entre pantallas

✅ Manejo de productos inexistentes


---

## Carrito de Compras

✅ Persistencia local mediante Room

✅ Estado reactivo con StateFlow

✅ Sobrevive al cierre de la aplicación

✅ Sobrevive a reinicios del sistema

✅ Agregar productos

✅ Cálculo de totales mediante Use Cases

✅ Arquitectura desacoplada


---

## Resiliencia Offline

✅ Estrategia Offline First

✅ Persistencia local de productos

✅ Fallback automático a Room

✅ Pantalla de falta de conectividad

✅ Experiencia degradada controlada


---

# 🏗 Arquitectura

El proyecto sigue una implementación basada en Clean Architecture.

```text
presentation/
│
├── screens
├── viewmodels
├── navigation
│
domain/
│
├── usecase
├── repository
├── product
│
data/
│
├── source
│   ├── remote
│   └── local
│
├── mapper
├── repository
│
di/
```

---

## Capas

### Presentation

- Jetpack Compose
- StateFlow
- ViewModels
- Navigation

### Domain

- Entities puras
- Casos de uso
- Reglas de negocio
- Interfaces de repositorio

### Data

- Room Database
- Ktor Client
- DTOs
- Repositories
- Mappers

---

# ⚙ Tecnologías Utilizadas

- Kotlin
- Jetpack Compose
- StateFlow
- Coroutines
- Hilt
- Ktor
- Room
- Coil
- Kotlin Serialization
- Clean Architecture
- Repository Pattern
- Offline First

---

# 🔄 Flujo de Datos

```text
UI
 ↓
ViewModel
 ↓
UseCase
 ↓
Repository
 ↓
Remote Data Source / Local Data Source
```

---

# 📶 Estrategia Offline First

La aplicación almacena los productos localmente mediante Room.

Cuando la API está disponible:

```text
API → Room → UI
```

Cuando no existe conectividad:

```text
Room → UI
```

De esta manera el usuario continúa teniendo acceso al catálogo incluso cuando la red falla.

---

# 🔎 Scroll Infinito

La carga incremental de productos se encuentra implementada mediante:

- LazyColumn
- LazyListState
- SnapshotFlow
- Paginación basada en limit/skip

Esto permite cargar información bajo demanda reduciendo consumo de memoria y mejorando rendimiento.

---

# 🧪 Testing

Pruebas unitarias implementadas mediante:

- JUnit
- MockK
- Coroutines Test

Casos probados:

✅ GetProductsUseCase

✅ GetProductByIdUseCase

✅ AddToCartUseCase

✅ CalculateCartTotalUseCase

✅ ProductViewModel

---
## Optimización de imágenes

Las imágenes son cargadas mediante Coil utilizando:

- Memory Cache
- Disk Cache
- Network Cache
- Crossfade Animations
- Placeholder
- Error Fallback

Esto mejora el rendimiento y la experiencia offline.

# 💡 Decisiones Técnicas

## ¿Por qué Clean Architecture?

Permite desacoplar completamente la lógica de negocio de la UI y la infraestructura.

La capa Domain depende únicamente de abstracciones, facilitando reemplazar tecnologías de persistencia o networking sin afectar Presentation.

---

## ¿Por qué Room?

Permite implementar una estrategia Offline First robusta y asegurar persistencia incluso después de:

- cierre completo de la app
- reinicio del dispositivo
- limpieza de memoria

---

## ¿Por qué StateFlow?

Proporciona un flujo reactivo, seguro y alineado con las recomendaciones oficiales de Android.

---

# 🚀 Funcionalidades Destacadas

- Offline First
- Persistencia con Room
- Scroll infinito
- Arquitectura limpia
- Inyección de dependencias con Hilt
- UI 100% Compose
- Carrito persistente
- Skeleton Loading
- Navegación entre pantallas
- Manejo de errores
- Testing unitario

---

# 👨‍💻 Autor

John Esteban Álvarez

Ingeniero en Desarrollo de Software

Android Native • Jetpack Compose • Kotlin
