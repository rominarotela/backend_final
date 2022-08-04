# Sistema Médico - Observaciones
1) Tecnología: JEE
2) Para la implementación puede utilizar el IDE de su elección (Eclipse, Netbeans, IntelliJ IDEA).
3) Como servidor de aplicación deben utilizar Wildfly (versión elección).
4) La base de datos debe ser Postgres (versión 9.x para facilitar la compatibilidad).
5) El gestor de proyecto DEBE ser MAVEN.
6) Tiene que cumplir el stack tecnológico JEE:
a. Modelo: JPA (con Hibernate, o algún otro ORM que sea una implementación de JPA)
b. Capa de negocios: EJB3
c. Capa de exposición: JAX-RS (Restful)
7) La estructura del proyecto puede ser una sola (como lo vimos en laboratorio) o pueden investigar más
sobre MAVEN y crear diferentes submódulos (proyecto padre, sub proyecto de modelo, sub proyecto de
capa de negocios, sub proyecto de capa de exposición)
8) Para el día de la entrega y defensa del TP deben estar presentes TODOS los integrantes del grupo, y el
que no esté presente lleva ausente.
9) Para los procesos que deben ejecutarse planificadamente cada cierto tiempo, pueden investigar acerca de
los session bean @Singleton y de los timer en ejb3 (@Schedule).
10) Para los puntos 3 y 4 se debe realizar un frontend en la tecnología que quieran [obligatorio]
Enunciado: Sistema médico de registro de pacientes, médicos y
ficha clínica de consulta
Se requiere la implementación de un módulo de gestión de consumo para ser asignado a
las mesas.
Los módulos a desarrollar son los siguientes:
1) Administración de pacientes (CRUD: POST, PUT, DELETE, GET)
Este módulo contempla la administración de pacientes.
Los datos a almacenar serán los siguientes: id, nombre, apellido, cedula, email, teléfono,
fecha de nacimiento
2) Administración de datos de los médicos (CRUD: POST, PUT, DELETE, GET)
Este módulo contempla la administración de pacientes.
Los datos a almacenar serán los siguientes: id, nombre, apellido, cedula, email, teléfono,
fecha de nacimiento, especialidad [tipo cadena, pueden almacenar como constantes:
Pediatra, Dermatologo, Clinico, etc], además de un nombre de usuario y un password para
ingresar a la aplicación.
Para este módulo pueden reutilizar lo realizado en el punto 1 ya que la estructura base es la
misma. Pero tengan en cuenta que el sistema debe poder diferenciar entre médicos y
pacientes.
3) Gestión de fichas de los pacientes
Gestiona la creación de fichas clínicas para una consulta del paciente con un médico dado.
El médico ingresa a la pantalla de registro de ficha para completar los datos:
- fecha (por defecto se auto completa con la fecha del dia)
- selecciona el paciente (buscador en un popup por nombre, apellido)
- detalles de la consulta (puede consultar por mas de un motivo)
- texto del motivo de consulta (texto)
- diagnostico (texto)
- tratamiento (texto)
4) Historial de consultas de los pacientes:
Listado de los detalles de la consulta pudiendo filtrar por textos en los campos de los
detalles, especialidad del médico, médico, paciente, fecha de la ficha

