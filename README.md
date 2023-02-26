# Kruger-challenge


1. Clonar proyecto desde el repositorio.
2. Crear una base de datos en postgresql localmente llamada **vaccine-kruger-db**.
3. Descargar las dependencias del build.gradle.
4. El proyecto fue desarrollado con flyway para la creacion de tablas y carga de datos iniciales, dentro de la ruta: /resources/db/migration/ se encuentran el script para creacion de tablas y carga de datos iniciales.

5. El proyecto se despliega en el puerto **8080** deacuerdo a la configuración en el archivo application.yml.

6. El contextPath de la app esta configurado con el valor /api.

7. Se carga datos del usuario clave. **Usuario: admin Clave: Admin2022**

8. Para el uso de los endpoints, se debe hacer primero la autenticación, para luego verificar la autorización. Se utiliza e implementa JWT para obtener el token de autenticación, esto es un POST, llamado login donde se obtiene el respectivo token.

![image](https://user-images.githubusercontent.com/62367756/221442652-91aab26f-11cb-4e53-9b0f-550881a6ba7f.png)
