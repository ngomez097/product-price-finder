# Product price finder

Este es un pequeño proyecto de ejemplo para la búsqueda de precio de un producto según la fecha, un
identificador de cadena y el identificador del producto utilizando arquitectura hexagonal.



## Autor

- [Gomez Nicolas](https://github.com/ngomez097)



## Ejecutar los test

Para ejecutar los test se debe correr en una terminal dentro
de la carpeta del proyecto el siguiente comando

```bash
./mvnw test # LINUX

mvnw.cmd test #Windows
```



## Dependencias

- Java 17



## Tecnologías

- [Spring Boot 3.1](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Flyway](https://flywaydb.org/)
- [H2 Database](https://www.h2database.com/html/main.html)



## Consideraciones

- Se establece que la moneda guardada en la base de datos en el campo `currency`
  de la tabla `price` respetará la nomenclatura [ISO 4217](https://es.wikipedia.org/wiki/ISO_4217)



## Decisiones

- Se usará TDD como metodología de desarrollo