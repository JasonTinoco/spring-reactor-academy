# Spring Reactor Academy API

## Introduction

Bienvenido a la documentación de la API de Academy. Esta API permite llevar el control de registros de matrícula de los estudiantes.

## Autentication

Para acceder a los endpoints de la API, necesitarás un token de autenticación. Asegúrate de incluir el siguiente encabezado en todas tus solicitudes:

## Endpoints

A continuación se presentan los diferentes endpoints disponibles en la API.

### 1. Authentication

- **Método**: POST
- **Endpoint**: `/login`
- **Descripción**: Autentica a un usuario y devuelve un token de sesión.

#### Cuerpo de la Solicitud

El cuerpo de la solicitud debe contener un objeto JSON con los siguientes parámetros:

| Nombre     | Tipo   | Descripción                           |
|------------|--------|---------------------------------------|
| `username` | string | El nombre de usuario del usuario.     |
| `password` | string | La contraseña del usuario.            |

#### Ejemplo de Solicitud cURL

```bash
curl --location 'http://localhost:8080/login' \
--header 'Content-Type: application/json' \
--data '{
    "username": "code",
    "password": "123"
}'
```

```json
{
    "username": "code",
    "password": "123"
}
```

## 2. Students
### 2.1 Save Students

- **Método**: POST
- **Endpoint**: `/students` o `/v2/students`
- **Descripción**: Crea un nuevo estudiante en el sistema.

#### Cuerpo de la Solicitud

El cuerpo de la solicitud debe contener un objeto JSON con los siguientes parámetros:

| Nombre      | Tipo   | Descripción                           |
|-------------|--------|---------------------------------------|
| `names`     | string | Los nombres del estudiante.           |
| `lastNames` | string | Los apellidos del estudiante.         |
| `dni`       | string | El número de documento de identidad del estudiante. |
| `age`       | integer| La edad del estudiante.               |

#### Ejemplo de Solicitud cURL

```bash
curl --location 'http://localhost:8080/students' \
--header 'Content-Type: application/json' \
--data '{
    "names": "Andre",
    "lastNames": "Carrillo",
    "dni": "01254859",
    "age": 38
}'
```

### 2.2 Get All Students

- **Método**: POST
- **Endpoint**: `/students` o `/v2/students`
- **Descripción**: Obtiene todos los estudiantes registrados en el sistema.

#### Ejemplo de Solicitud cURL

```bash
curl --location 'localhost:8080/students' \
--header 'Authorization: Bearer *****'
```

### 2.3 List Students Sorted

- **Método**: POST
- **Endpoint**: `/students-sort` o `/v2/students-sort`
- **Descripción**: Obtiene todos los estudiantes registrados en el sistema
  y los ordena según el parametro enviado.

#### Ejemplo de Solicitud cURL

```bash
curl --location 'localhost:8080/v2/students-sort?order=desc' \
--header 'Authorization: Bearer *****'
```

> Documentation in progress...

## Dependencies
1. Java 21.
2. MongoDB.
3. Postman

## Developer
- Github: [@JasonTinoco](https://github.com/JasonTinoco)
- LinkedIn: [@Jason-Tinoco](https://www.linkedin.com/in/jason-tinoco/)
- Project: Final Project to Spring WebFlux Course - Mitocode
