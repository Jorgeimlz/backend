# Backend de NutriSync

Este proyecto es el backend de la aplicación NutriSync, una plataforma de alimentación personalizada que permite la gestión de usuarios, ingredientes, recetas, categorías, dietas y planes alimenticios. Este backend está construido con Django y Django REST Framework, y está desplegado en Render. También se utiliza JWT para autenticación y Swagger para documentación de la API.

## Tecnologías Utilizadas

- **Django**: Framework de Python para desarrollo web.
- **Django REST Framework**: Herramienta para crear APIs robustas con Django.
- **PostgreSQL**: Base de datos relacional utilizada en Render.
- **djangorestframework-simplejwt**: Autenticación basada en JSON Web Tokens (JWT).
- **drf-yasg**: Generador de documentación Swagger y ReDoc para la API.
- **django-cors-headers**: Middleware para manejar CORS y permitir peticiones desde otros dominios.
- **gunicorn**: Servidor HTTP para ejecutar la aplicación en producción.

## Instalación

### Requisitos

- Python 3.8 o superior.
- PostgreSQL como base de datos.
- Un entorno virtual para aislar dependencias (recomendado).

### Configuración

1. **Clonar el repositorio y acceder al directorio del proyecto.**

2. **Crear un entorno virtual e instalar las dependencias** listadas en `requirements.txt`.

3. **Configurar las variables de entorno**:
   - Configurar las credenciales de la base de datos en `settings.py` o a través de variables de entorno, incluyendo:
     - `DATABASE_URL`: URL de la base de datos PostgreSQL proporcionada por Render.
     - `SECRET_KEY`: Llave secreta de Django.
     - `DEBUG`: Definir como `False` en producción.
   
4. **Realizar las migraciones** para configurar la base de datos.

5. **Crear un superusuario o admin (staff)** para acceder al panel de administración de Django.

6. **Correr el servidor de desarrollo** para probar la aplicación.

## Estructura de Carpetas

- **NutriSync**: Directorio principal de configuración de Django, que contiene archivos esenciales como `settings.py`, `urls.py` y `wsgi.py`.
- **apps**:
  - **users**: Gestión de usuarios y autenticación.
  - **ingredientes**: CRUD de ingredientes.
  - **categorias**: Gestión de categorías de alimentos.
  - **recetas**: CRUD de recetas y recomendaciones personalizadas.
  - **dieta**: Módulo para gestión de dietas.
  - **planes_alimenticios**: Creación y manejo de planes alimenticios personalizados.

## Configuración de la Base de Datos

La base de datos está configurada para utilizar PostgreSQL en Render. La configuración básica en `settings.py` se ve así:
"PARA CONFIGURAR LA BASE DE DATOS ES NECESARIO CREAR UNA BDD POSTGRESQL EN RENDER"

```python
DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.postgresql',
        'NAME': 'nutrisyncbdd',
        'USER': 'nutrisyncbdd_user',
        'PASSWORD': 'contraseña_proporcionada',
        'HOST': 'host_de_render',
        'PORT': '5432',
    }
}

