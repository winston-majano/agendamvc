# 📒 Agenda de Contactos con Spring Boot + JDBC + MySQL + Thymeleaf, Bootstrap

Este proyecto es una aplicación CRUD (Crear, Leer, Actualizar, Eliminar) de una **agenda de contactos**. Utiliza **Spring Boot**, **JDBC Template**, **Thymeleaf** para el frontend, y **MySQL** como base de datos.

---

## 🚀 Tecnologías usadas

- ✅ Spring Boot
- ✅ Spring Web (MVC)
- ✅ Spring JDBC
- ✅ Thymeleaf
- ✅ MySQL
- ✅ Maven
- ✅ Lombok

---

## 🧱 Estructura del proyecto

```
src/
├── main/
│   ├── java/com/ejemplo/agenda/
│   │   ├── controller/ContactoController.java
│   │   ├── model/Contacto.java
│   │   ├── repository/ContactoRepository.java
│   │   └── AgendaApplication.java
│   └── resources/
│       ├── templates/
│       │   ├── lista.html
│       │   └── formulario.html
│       └── application.properties
```

---

## 🛠️ Requisitos previos

- Java 17 o superior
- Maven
- MySQL instalado y corriendo

---

## 🗄️ Configuración de la base de datos

1. Crear base de datos:

```sql
CREATE DATABASE agenda;
```

2. Crear tabla:

```sql
USE agenda;

CREATE TABLE contactos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100),
  telefono VARCHAR(20),
  email VARCHAR(100)
);
```

3. Configura tu conexión en `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/agenda
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

---

## ⚙️ Cómo ejecutar el proyecto

1. Clona el repositorio:
```bash
git clone https://github.com/tu-usuario/agenda-spring-jdbc.git
cd agenda-spring-jdbc
```

2. Compila el proyecto:
```bash
mvn clean install
```

3. Ejecuta la aplicación:
```bash
mvn spring-boot:run
```

4. Abre tu navegador:
```
http://localhost:8080/contactos
```

---

## 📷 Funcionalidades

- 📋 Ver todos los contactos
- ➕ Agregar nuevo contacto
- ✏️ Editar un contacto
- ❌ Eliminar contacto

---

## 📁 Recursos HTML (Thymeleaf)

- `lista.html`: muestra la lista de contactos.
- `formulario.html`: formulario para crear o editar contactos.

---

## 🔧 Dependencias (pom.xml)

Si usaste Spring Initializr, asegúrate de tener estas dependencias:

```xml
<dependencies>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
  </dependency>
  <dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
  </dependency>
</dependencies>
```

---

## 🧑‍💻 Autor

- Tu Nombre ([@winston-majano](https://github.com/winston-majano))

---

## 📝 Licencia

Este proyecto está licenciado bajo la MIT License.
