# TP01

## 1. Evaluación de protocolos de una clase

Opción #2 ya que se mantiene el estado interno encapsulado, en cambio, con la opción #1 puede lograrse un estado interno inconsistente.

## 2. Delegación

Opción #2 ya que el **Jefe** contiene una referencia al **Secretario**, por ende el **Jefe** delega la implementación de estrategia de búsqueda sobre un **Fichero** al **Secretario**.

## 3. Polimorfismo

- Opción #1: La implementación de `extraer(unMonto)` acopla ambas definiciones de cuentas. Trata de simular _despacho simple (single dispatch)_ al invocar `self.class()` para separar comportamientso cuando debería aprovechar armar una jerarquía para generar dos classes que hereden de una sola definición de **CuentaBancaria** y así aprovechar _single dispatch_ al redefinir su respectivos métodos `extraer(unMonto)`.

- Opción #2: La implementación de `extraer(unMonto)` se ve afectada por el mismo tipo de error que la opción #1 sólo que en vez de utilizar el tipo de la clase para separar comportamiento lo hace con un atributo de la instancia.

- Opción #3: Las implementaciones de `extraer(unMonto)` realizan más de una operación resultando poco descriptivas. Una mejora que se podría realizar es extraer a un método el proceso de verificar las condiciones previo a realizar una extracción y así delegar una responsabilidad a otro método definido en cada clase.

- Opción #4:

## Actividad de lectura #1

1. El **acceso directo** a las variables es utilizar las variables de instancia cuando se las necesite sin un intermediario como lo son los _getters_ y _setters_.
   Por ejemplo: `unaBrujula.orientacion = 'Norte'`

2. El **acceso indirecto** a las variables es utilizar un mensaje cada vez que uno quiera acceder o cambiar el valor de dicha variable de instancia.
   Por ejemplo: `unaBrujula.setOrientacion('Norte')`

3. El **acceso directo** facilita la lectura de código pero rompe el encapsulamiento del estado de un objeto al permitir que agentes externos modifiquen el valor de las variables de instancia. En cambio, el **acceso indirecto** a las variables nos permite controlar la forma de tomar o editar el valor de una variable manteniendo intacto el encapsulamiento pero nos obliga a mantener el protocolo de mensajes una vez implementado.

## Actividad de lectura #2

El **creation paramether method** conviene usarse cuando es necesario realizar inicialización explícita, es decir, cuando la inicialización es parte de la creación de una instancia nueva.

## Actividad de lectura #3

Las collecciones deben accederse indirectamente e implementando uno o varios **collection accessor methods** para proporcionar acceso seguro a los elementos de una colleción y así evitar que agentes externos afecten el contenido de la misma.

## Actividad de lectura #4

Son necesarios dos métodos para cambiar el estado de una propiedad booleana para encapsular la representación del estado de dicha variable. Además incrementa la comunicación del código resultante.
