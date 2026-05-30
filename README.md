**Nombres:** Katherin Juliana Moreno Carvajal, Mariana Salas Gutiérrez

# Parcial Final: Parte 1

## 1. Video

[https://canva.link/dui2kxa9b3shc5w](https://canva.link/dui2kxa9b3shc5w)

## 2. Introducción

Este proyecto implementa una solución basada en arquitectura de microservicios utilizando Spring Boot y el patrón arquitectónico Circuit Breaker. El objetivo es garantizar la continuidad del servicio de notificaciones ante fallos del proveedor principal de SMS. Para ello se utilizan dos proveedores simulados:

* Aldeamo (proveedor principal)
* Twilio (proveedor de respaldo)

Cuando el proveedor principal presenta fallos repetitivos, el sistema detecta la situación mediante un Circuit Breaker implementado con Resilience4J, evitando realizar llamadas innecesarias a un servicio que se encuentra indisponible.

Una vez transcurrido el tiempo de espera configurado, el sistema intenta nuevamente utilizar el proveedor principal y, si este se ha recuperado, restablece la operación normal.

## 3. Objetivos

* Implementar una arquitectura basada en microservicios.
* Aplicar el patrón Circuit Breaker.
* Garantizar tolerancia a fallos.
* Implementar mecanismos de recuperación automática.
* Utilizar API Gateway para centralizar el acceso a los servicios.
* Persistir información en PostgreSQL.
  
## 4. Microservicios

* **pago-service**
  * **Puerto:** 8080
  * **Responsabilidades:**
    * Procesar pagos.
    * Registrar pagos en la base de datos.
    * Invocar el servicio de notificaciones.
    * Gestionar el Circuit Breaker.
  * **Endpoint:** POST /pagar
    
* **aldeamo-service**
  * **Puerto:** 8081
  * **Responsabilidades:**
    * Simular el proveedor principal de SMS.
    * Registrar notificaciones enviadas.
  * **Endpoint:** POST /notificar
    
* **twilio-service**
  * **Puerto:** 8082
  * **Responsabilidades:**
    * Simular el proveedor alternativo de SMS.
    * Recibir tráfico cuando Aldeamo falla.
  * **Endpoint:** POST /notificar

## 5. Tecnologías Utilizadas

* Java 17
* Spring Boot 3.5
* Spring Web
* Spring Data JPA
* OpenFeign
* Resilience4J
* PostgreSQL 16
* Docker
* Kong API Gateway
* Nginx
* Maven
* Postman

## 6. ¿Cómo probarlo?

**1. Levantar Infraestructura**

Desde la raíz del proyecto:

docker compose up -d

Verificar:

docker ps

Deben aparecer:

postgres-parcial

pgadmin-parcial

nginx-parcial

kong-parcial

**2. Ejecutar Aldeamo Service**
   
cd aldeamo-service

mvn spring-boot:run

**3. Ejecutar Twilio Service**
   
cd twilio-service

mvn spring-boot:run

**4. Ejecutar Pago Service**
   
cd pago-service

mvn spring-boot:run
