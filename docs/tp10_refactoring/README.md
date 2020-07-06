# TP10 - Refactoring

## 1. Cuentas

- Bad smells:

  - Duplicated Code: `CajaDeAhorro::extraer` y `CuentaCorriente::extraer` sufren de éste _bad smell_. Esto puede solucionarse aplicando el refactoring _Pull Up Method_ para mover el código duplicado un nivel hacia arriba en la jerarquía de clases seguido de _Extract Method_ para extraer la funcionalidad que hace más difícil de leer el código (condición para extraer) y luego _Push Down Method_ al ver que dicha funcionalidad puede variar dependiendo de la subclase.

## 2. Registro Automotor

- Bad smells:

  - Comments: `RegistroAutomotor::debeRealizarVtv` sufre de éste _bad smell_ al tener una lógica de negocio difícil de comprender la cual forzó al programador original a escribir un comentario para que la próxima persona en leerlo pueda entender qué acción realiza el fragmento de código comentado. Esto puede solucionarse aplicando el refactoring _Extract Method_ y aplicándole un nombre descriptivo a el o los métodos método extraidos.
  - Feature Envy: `RegistroAutomotor::debeRealizarVtv` solicita varios atributos de la clase `Vehiculo`. Esto es un indicio de que cierta funcionalidad o funcionalidades deberían estar localizadas en la clase a la cual se le piden tantos detalles. Este _bad smell_ puede solucionarse aplicando el refactoring _Move Function_ para reubicar la o las funcionalidades "envidiosa".
