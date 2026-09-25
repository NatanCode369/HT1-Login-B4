# Flujo de la aplicación HT1-Login-B4

Este documento describe, de forma superficial, el flujo principal de la aplicación revisando únicamente los archivos Java y FXML dentro de `main/java`.

## 1. Punto de entrada

La aplicación inicia desde estos archivos:

- `main/java/org/aaguilar/system/Launcher.java`
- `main/java/org/aaguilar/system/Main.java`

El flujo es muy simple:

1. `Launcher.main()` invoca `Main.main()`.
2. `Main` extiende `Application` y ejecuta `start(Stage primaryStage)`.
3. En `start()`, se configura el `Stage` en `SceneManager` y luego se carga la vista inicial con `FactoryView.getInstancia().loginView();`.

Esto significa que la pantalla de inicio será el login.

## 2. Gestión de escenas

Los archivos clave para cambiar de pantalla son:

- `main/java/org/aaguilar/system/utils/SceneManager.java`
- `main/java/org/aaguilar/system/utils/FactoryView.java`

### `SceneManager`
Es un singleton que guarda el `Stage` principal y tiene el método `cambiarScene(Scene scene)`, que coloca una escena nueva en la ventana principal y la muestra.

### `FactoryView`
Es el responsable de cargar los archivos FXML. Tiene un método `loadScene(String fxmlname)` con casos para:

- `login`
- `registro`
- `menu`

Además, carga el archivo correcto con `FXMLLoader` y define el tamaño apropiado de cada ventana:

- Login: `400 x 550`
- Registro: `400 x 550`
- Menú principal: `900 x 700`

También se asignan iconos y títulos según la pantalla.

## 3. Flujo de login

Los archivos involucrados son:

- `main/java/org/aaguilar/system/view/LoginView.fxml`
- `main/java/org/aaguilar/system/controller/ControllerLogin.java`

### Vista de login
`LoginView.fxml` contiene:

- un campo para el nombre de usuario (`TextField`)
- un campo para la contraseña (`PasswordField`)
- un enlace para ir a registro (`Hyperlink`)
- un botón para ingresar

La vista está diseñada como una interfaz centrada con un GIF visual y estilo CSS.

### Controlador de login
`ControllerLogin` tiene dos métodos principales:

- `validacionesCampos()`
- `cambiarFormulario()`

#### `validacionesCampos()`
Verifica que el usuario y la contraseña no estén vacíos ni contengan espacios. Si faltan datos, muestra una alerta con `AlertInformation`.

#### `cambiarFormulario()`
Llama a `FactoryView.getInstancia().registroView();` para cambiar a la pantalla de registro.

En resumen, el usuario entra a la app, coloca sus credenciales, y el sistema valida que los campos no estén vacíos antes de continuar.

## 4. Flujo de registro

Los archivos involucrados son:

- `main/java/org/aaguilar/system/view/RegistroView.fxml`
- `main/java/org/aaguilar/system/controller/ControllerRegistro.java`
- `main/java/org/aaguilar/system/model/User.java`
- `main/java/org/aaguilar/system/repository/UserRepository.java`

### Vista de registro
`RegistroView.fxml` muestra los siguientes campos:

- Nombre
- Apellidos
- Correo
- Username
- Teléfono
- Contraseña
- Confirmar contraseña

También incluye un enlace para volver al login y un botón `Registrarse`.

### Controlador de registro
`ControllerRegistro` valida:

- campos obligatorios
- correo válido
- teléfono válido
- coincidencia de contraseñas

Si todo está correcto, crea un objeto `User` y lo envía al repositorio:

```java
User usuario = new User(
    textFieldNombre.getText(),
    textFieldCorreo.getText(),
    textFieldLastName.getText(),
    textFieldUsername.getText(),
    passwordFieldConfirmar.getText()
);
userRepository.create(usuario);
```

### Modelo `User`
`User.java` es un POJO (modelo de dominio) con propiedades:

- name
- lastName
- email
- userName
- password

Tiene getters y setters para cada uno.

### Repositorio
`UserRepository` implementa `UserInterface` y usa la conexión a base de datos para ejecutar procedimientos almacenados:

- `sp_create_users(?, ?, ?, ?, ?)` para registrar
- `sp_login_user(?, ?)` para iniciar sesión

La clase obtiene la conexión desde `ConexionDB.getInstanciaConexionDB()`.

## 5. Conexión a base de datos

Los archivos relevantes son:

- `main/java/org/aaguilar/system/config/ConexionDB.java`
- `main/java/org/aaguilar/system/config/Enviroment.java`

### `Enviroment`
Es un enum con la configuración de la base de datos:

- `LOCATION_SERVICE = localhost:3306`
- `DATABASE = auditoria_usuario_producto_in4am`
- `USER = IN4AM`
- `PASSWORD = shawn.exe.cr7`

### `ConexionDB`
Crea la conexión JDBC a MySQL usando:

```java
DriverManager.getConnection(
    "jdbc:mysql://" + Enviroment.LOCATION_SERVICE + "/" + Enviroment.DATABASE,
    String.valueOf(Enviroment.USER),
    String.valueOf(Enviroment.PASSWORD)
);
```

Es un patrón singleton para asegurar una sola instancia de conexión.

## 6. Menú principal

Los archivos involucrados son:

- `main/java/org/aaguilar/system/view/MainMenu.fxml`
- `main/java/org/aaguilar/system/controller/ControllerMainMenu.java`

### Vista del menú
El `MainMenu.fxml` se ve como un dashboard con:

- barra superior con logo y nombre de usuario
- menú lateral con opciones como Inicio, Perfil, Configuración y Cerrar Sesión
- área central vacía o de contenido

### Controlador del menú
`ControllerMainMenu` tiene el método `cerrarSesion()`, que:

1. muestra una confirmación con `AlertInformation`
2. llama a `FactoryView.getInstancia().loginView();`

Esto devuelve al usuario a la pantalla de inicio de sesión.

## 7. Validaciones y alertas

El archivo:

- `main/java/org/aaguilar/system/utils/Validations.java`
- `main/java/org/aaguilar/system/utils/AlertInformation.java`

Sirven para validar entradas y mostrar notificaciones.

### `Validations`
Tiene métodos para:

- validar teléfono
- validar correo
- comparar contraseñas

### `AlertInformation`
Centraliza las alertas del sistema con tipos:

- `ERROR`
- `WARNING`
- `CONFIRMATION`

Eso hace que toda la app tenga un estilo uniforme para notificar errores o confirmaciones.

## 8. Resumen del flujo general

La aplicación sigue este flujo básico:

1. `Main` lanza la aplicación.
2. `FactoryView` carga la vista de login.
3. El usuario ingresa username y contraseña.
4. Si desea registrarse, cambia a la pantalla de registro.
5. El formulario de registro valida datos y crea un `User`.
6. `UserRepository` guarda al usuario en la base de datos usando procedimientos almacenados.
7. Después, el sistema puede volver al login o entrar al menú principal.
8. Desde el menú, el usuario puede cerrar sesión y regresar al login.

## 9. Observaciones superficiales

A nivel de flujo, la aplicación está bien estructurada para una demo JavaFX con MVC ligero:

- `view` para las pantallas
- `controller` para la lógica de interacción
- `model` para el usuario
- `repository` para acceso a datos
- `utils` para navegación, validaciones y alertas

Sin embargo, a simple vista se detectan algunas condiciones que podrían necesitar revisión:

- `UserRepository.login()` usa `setString(1, usuario.getPassword());` dos veces en vez de usar el índice 2 para la contraseña.
- `validaciones.validarPassword()` devuelve `true` si las contraseñas coinciden, pero en `ControllerRegistro` se usa como si fuera un error cuando es `true`.
- El nombre del archivo `Enviroment.java` tiene una ortografía diferente a `Environment`.

No obstante, como flujo general, la app cumple con la idea de un sistema básico de autenticación y registro en JavaFX conectado a MySQL.

## 10. Conclusión

La aplicación es un sistema de autenticación básica con tres pantallas principales: login, registro y menú. La navegación se gestiona con `FactoryView` y `SceneManager`, mientras que el acceso a datos y la validación de formularios están separados en capas para facilitar el mantenimiento.

El patrón general es claro y bastante legible para una versión inicial o prototipo de software.
