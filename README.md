# Kruger-challenge


1. Clonar proyecto desde el repositorio.
2. Crear una base de datos en postgresql localmente llamada **vaccine-kruger-db**.
3. Descargar las dependencias del build.gradle.
4. El proyecto fue desarrollado con flyway para la creacion de tablas y carga de datos iniciales, dentro de la ruta: /resources/db/migration/ se encuentran el script para creacion de tablas y carga de datos iniciales.

5. El proyecto se despliega en el puerto **8080** deacuerdo a la configuración en el archivo application.yml.

6. El contextPath de la app esta configurado con el valor /api.

7. Se carga datos del usuario clave. **Usuario: admin Clave: Admin2022**

8. Para el uso de los endpoints, se debe hacer primero la autenticación, Se utiliza e implementa JWT y spring security para obtener el token de autenticación,el end point es **localhost:8080/api/public/login** 

![image](https://user-images.githubusercontent.com/62367756/221442652-91aab26f-11cb-4e53-9b0f-550881a6ba7f.png)

1. Ejemplo de Criterio de aceptación.
1.1 Crear empleado con los datos basicos.

![image](https://user-images.githubusercontent.com/62367756/221443555-4df17380-1e82-477d-9c19-cd249f58bfdc.png)

1.2 Verificacion  de los datos 
![image](https://user-images.githubusercontent.com/62367756/221443765-62e9eced-aad7-4600-994e-d713d0f08670.png)


El proyecto tiene implementado swagger para la documentacion y test de end points, para ingresar apuntar la siguiente ruta: **http://localhost:8080/api/swagger-ui/index.html#/** , el cual tambien se peude verificad con las credenciales del administrador **Usuario: admin Clave: Admin2022** aqui se podra revisar el respectivo manejo de cada endpoint.

![image](https://user-images.githubusercontent.com/62367756/221477772-3c1129d0-b71e-4580-812c-611adc817ec4.png)


Proyecto desarrollado por Diego Acosta ©
