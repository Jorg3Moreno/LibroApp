# APP

La siguiente aplicación fue construida con SprigBoot en el backend y Angular & Bootstrap en el Frontend.
Los directorios de Backend y Fronted se encuentran respectivamente en las siguientes ubicaciones:

`src/main/java`

`src/main/webapp`

El codigo con la lógica del negocio se encuentra en:

`src/main/webapp/app/entities`

## Requisitos

- Java 8
- Node JS > 12
- MSqlServer

## 1. Instalación de dependencias

- ### Backend

Nos situamos en la raíz del proyecto y ejecutamos el siguiente comando:

`./mvnw clean install`

- ### Frontend

Situarse en la raíz del proyecto y ejecutar el siguiente comando para instalar todas las dependencias:

`npm install`

## 2. Configuración

Para la ejecución del proyecto, es indispensable configurar la conexión a la base de datos. Por lo tanto, es
necesario como primer paso crear una base denominada `cobislibros`.

Como segundo paso, es necesario modificar el archivo de configuracion denominado `application-dev.yml`, el cuál
se encuentra en la siguiente ubicación:

`src/main/resources/config/application-dev.yml`

Los parámetros que se deben cambiar son:

- String de conexión: `jdbc:sqlserver://localhost:1433;database=cobislibros`
- usuario de la bdd: `username: SA`
- contraseña de la bdd: `password: yourStrong(!)Password`

**_Nota importante:_** No es necesario crear ninguna tabla o ejecutar ningún script en la base de datos, ya que el proyecto
se encuentra configurado con `Liquibase` y la librería `Faker` para hacer esas tareas por nosotros.

## 3. Ejecución

Para ejecutar el proyecto es necesario ejecutar el comando:

`./mvnw`

Y cuando termine la ejecución ir al navegador de Google Chrome y entrar a la url:

`http://localhost:8080`
