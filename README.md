# Product price finder

Este es un pequeño proyecto de ejemplo para la búsqueda de precio de un producto según la fecha, un
identificador de cadena y el identificador del producto utilizando arquitectura hexagonal.


## Autor

- [Gomez Nicolas](https://github.com/ngomez097)



## Indice
* [Product price finder](#product-price-finder)
  * [Ejecutar los test](#ejecutar-los-test)
  * [Levantar el servidor](#levantar-el-servidor)
  * [Dependencias](#dependencias)
  * [Tecnologías](#tecnologías)
  * [Herramientas](#herramientas)
  * [Consideraciones](#consideraciones)
  * [Decisiones](#decisiones)



## Ejecutar los test

Para ejecutar los test se debe correr en una terminal dentro de la carpeta del proyecto el 
siguiente comando

**Linux**
```bash
./mvnw test 
```

**Windows**
```bash
mvnw.cmd test
```


## Levantar el servidor

Para levantar el servidor se puede hacer uso del siguiente commando en una terminal

**Linux**
```bash
./mvnw spring-boot:run
```

**Windows**
```bash
mvnw.cmd spring-boot:run
```


## Dependencias

- Java 17



## Tecnologías

- [Spring Boot 3.1](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Flyway](https://flywaydb.org/)
- [H2 Database](https://www.h2database.com/html/main.html)
- [Lombok](https://projectlombok.org/)
- [Mockito](https://site.mockito.org/)
- [JUnit 5](https://junit.org/junit5/)
- [MapStruct](https://mapstruct.org/)
- [Maven](https://maven.apache.org/)

## Herramientas

- [IntelliJ](https://www.jetbrains.com/es-es/idea/)
- [OpenApi Generator](https://openapi-generator.tech/)



## Swagger

El proyecto cuenta con **Swagger UI**, este mismo se puede acceder a través del enlace
[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) 
una vez que el [servidor esté corriendo](#levantar-el-servidor)



## Consideraciones

- Se establece que la moneda guardada en la base de datos en el campo `currency`
  de la tabla `price` respetará la nomenclatura [ISO 4217](https://es.wikipedia.org/wiki/ISO_4217)
- Se considera que todos los parámetros de la request son requeridos



## Decisiones

- Se usará TDD como metodología de desarrollo
- Se optó por usar `Lombok` en los modelos de dominio para mejorar la legibilidad
- Se optó por usar la etiqueta `@Query` de JPA con `JPQL` para evitar tener un **Query Method** 
  muy extenso con parámetros repetidos
- Se utilizó **OpenApi Generator** para crear el endpoint a partir de un YAML de especificación OpenAPI