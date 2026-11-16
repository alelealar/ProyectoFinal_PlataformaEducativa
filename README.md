# Portal Nexus — Plataforma Educativa

Sistema web universitario compuesto por un **Panel Administrativo** (construido con Spring Boot y Thymeleaf) y un **Portal del Alumno** (interfaz web que consume una API REST asegurada con tokens JWT).

---

## Tecnologías utilizadas

* **Backend y API REST:** Java 21, Spring Boot, Spring Security, JWT (JJWT), Spring Data JPA, Bean Validation.
* **Base de datos:** MySQL 8.
* **Frontend:** HTML5, CSS3, JavaScript (Fetch API) y Thymeleaf.
* **Pruebas de API:** Postman.

---

## Requisitos e instalación

Para ejecutar el proyecto de manera local es necesario contar con las siguientes herramientas instaladas:

1. **Java Development Kit (JDK 21):** [Descargar Eclipse Temurin JDK 21](https://adoptium.net/temurin/releases/?version=21)
2. **MySQL Server y MySQL Workbench:** [Descargar MySQL Installer](https://dev.mysql.com/downloads/installer/)
3. **IDE para Java (recomendado IntelliJ IDEA):** [Descargar IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
4. **Editor para el frontend (recomendado Visual Studio Code con la extensión Live Server):** [Descargar VS Code](https://code.visualstudio.com/)
5. **Cliente API (Postman):** [Descargar Postman](https://www.postman.com/downloads/)

---

## Pasos de configuración

### 1. Configuración del Backend (`panel_administrativo`)
1. Asegúrate de tener el servicio de **MySQL Server** activo en tu computadora.
2. Abre **IntelliJ IDEA**, selecciona **Open** y elige la carpeta `panel_administrativo`.
3. Espera a que Maven descargue las dependencias del archivo `pom.xml`.
4. Dado que `application.properties` está excluido del repositorio por seguridad (`.gitignore`), crea el archivo `application.properties` dentro de `panel_administrativo/src/main/resources/` con el siguiente contenido y reemplaza `tu_contraseña_mysql` por tu contraseña local:

```properties
spring.application.name=panel_administrativo

# Conexión a MySQL (crea la base de datos automáticamente si no existe)
spring.datasource.url=jdbc:mysql://localhost:3306/portal_nexus?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=tu_contraseña_mysql

# Hibernate / JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

# Configuración JWT
jwt.secret=ClaveSuperHiperMegaSecretaQueDebeContenerMinimo32Caracteres
jwt.expiration=86400000