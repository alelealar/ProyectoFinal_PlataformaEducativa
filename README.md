# Sistema de Inscripción y Selección de Carga Académica Universitaria

Para este proyecto se pretende realizar un sistema para una universidad enfocado principalmente en la inscripción y selección de carga académica. El desarrollo cuenta con un enfoque amigable al usuario, priorizando el diseño y estrategias de UX/UI para que tanto maestros como alumnos puedan familiarizarse fácilmente con la plataforma y utilizarla de manera intuitiva desde el primer momento.

El sistema está pensado para resolver la gestión del historial escolar, control de cupos en grupos, asignación de la oferta académica por periodo, validación de materias seriadas (prerrequisitos) y el seguimiento de los pagos para permitir la carga de materias.

## Reglas de Negocio y Modelo del Sistema

1. **Usuarios:** Usamos una clase base `Usuario` para manejar de forma limpia a los `Alumno` y `Maestro`.
2. **Planes de Estudio:** Manejamos la relación entre carreras, materias y sus planes mediante `PlanEstudio` y `PlanMateria`.
3. **Prerrequisitos:** La clase `Materia` tiene una relación consigo misma para revisar que el alumno ya haya aprobado la materia previa antes de dejarlo inscribir.
4. **Horarios y Empalmes:** Usamos `HorarioClase` para definir los bloques de tiempo de cada grupo y evitar que al alumno se le crucen las materias.
5. **Control de Cupos:** Manejamos `cupoMaximo` y `cupoDisponible` en cada `Clase` para controlar el límite de estudiantes.
6. **Inscripción e Historial:** Guardamos el registro de materias inscritas, calificaciones y estados a través de `Inscripcion`.
7. **Pagos:** Revisamos el estado de pago del periodo para validar que el alumno esté al corriente antes de confirmar su carga.