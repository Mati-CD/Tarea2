-Marco Enrique Liguempi Bozzano

-Matias Sebastian Cuello Diban

-Joaquín Alonso Reyes Tecas

UML: ![image](https://github.com/user-attachments/assets/cb640d1d-4d70-4e18-96f3-f49aef95b384)

Los cambios que hicimos en el UML fueron pocos pero se ven representados en las clases Reunion, Asistencia, Departamento, Nota e Invitacion, pues su enfoque nos requeria añadir metodos y atributos extras para un correcto funcionamiento del codigo.

En la clase Reunion añadimos los atributos: Asistentes, Ausentes e Invitados como ArrayList para guardar los empleados que son invitados a las reuniones y para poder guardar si es que asisten o no.
En conjunto a eso tambien añadimos los atributos registrarInvitados() y registrarAsistencia() para poder guardar los datos sobre los empleados que asisten a las reuniones manualmente

En la clase Asistencia añadimos los atributos empleado, presente, tarde y llegada, para registrar la asistencia de los empleados y su situacion dado la llegada, con esto nos referimos a si llega tarde, o si es que no se presenta.

En la clase Departamento solo añadimos el atributo de empleados como un ArrayList, para guardar todos los empleados de un departamento.

En la clase Nota solo añadimos el atributo de fechaCreacion, para poder registrar cuando una nota es creada.

Por ultimo en la clase Invitacion añadimos el metodo de enviarInvitacion() para poder enviar invitaciones a los empleados.
