# TP07 - Test y Test Doubles

## 1. TDD y Test de Unidad

- Mantener en forma exhaustiva una suite de tests:

  - Protege ante defectos y regresiones que pudieran ser introducidos al intentar realizar cambios en el sistema
  - Asegura que el código cumple con las reglas de negocio programadas

- No deben utilizarse para testear otros objetos del dominio:

  - Ya que en caso de presentarse una falla dificultaría la localización del error al tener más de un objeto implicado

- Comunicar la intención del test:

  - A través de la utilización de nombres legibles y descriptibles facilita el mantenimiento y el entendimiento de los mismos
  - Ayuda a documentar el comportamiento del SUT

## 2. Póquer

- Escenarios:

  1. _Cuatro cartas mismo valor, una diferente_\
     **Dado** una mano de 5 cartas\
     **Cuando** 4 cartas son de igual valor\
     **Y** 1 es diferente\
     **Entonces** la mano es identificada como _poker_\
     **Y** `PokerStatus::verificar` retorna `true`

  2. _Todas cartas diferentes_\
     **Dado** una mano de 5 cartas\
     **Cuando** todas las cartas son de diferente valor\
     **Entonces** la mano no es identificada como _poker_\
     **Y** `PokerStatus::verificar` retorna `false`

  3. _Tres cartas de igual valor, dos diferentes_\
     **Dado** una mano de 5 cartas\
     **Cuando** 3 cartas son de igual valor\
     **Y** 2 son diferentes\
     **Entonces** la mano no es identificada como _poker_\
     **Y** `PokerStatus::verificar` retorna `false`

## 3. Póquer Continuación

- Escenarios Poker:

  1. _Cuatro cartas mismo valor, una diferente_\
     **Dado** una mano de 5 cartas\
     **Cuando** 4 cartas son de igual valor\
     **Y** 1 es diferente\
     **Entonces** la mano es identificada como _poker_\
     **Y** `PokerStatus::verificar` retorna `Poker`

- Escenarios Color:

  1. _Todas las cartas del mismo palo_\
     **Dado** una mano de 5 cartas\
     **Cuando** 5 cartas son del mismo palo\
     **Entonces** la mano es identificada como _color_\
     **Y** `PokerStatus::verificar` retorna `Color`

- Escenarios Trío:

  1. _Tres cartas del mismo valor, dos diferentes_\
     **Dado** una mano de 5 cartas\
     **Cuando** 3 cartas tienen el mismo valor\
     **Entonces** la mano es identificada como _trío_\
     **Y** `PokerStatus::verificar` retorna `Trío`

- Escenario Vacío

  1. _Todas cartas diferentes en valor y palo_\
     **Dado** una mano de 5 cartas\
     **Cuando** todas las cartas son de diferente palo\
     **Entonces** la mano no es identificada como _color_\
     **Y** `PokerStatus::verificar` retorna un `String` vacío

  1. _Dos cartas del mismo valor, otras dos cartas del mismo valor, una diferente_\
     **Dado** una mano de 5 cartas\
     **Cuando** 2 cartas tienen el mismo valor\
     **Y** otras 2 cartas tienen el mismo valor pero diferente al primer grupo\
     **Y** 1 última carta tiene un valor diferente a los dos grupos anteriores\
     **Entonces** la mano no es identificada como una jugada\
     **Y** `PokerStatus::verificar` retorna un `String` vacío

## 4. Cartas de Póquer

Ver implementación en Java

## 5. Mockito

- Ver implementación en Java

- ¿Cómo se indica en mockito que el objeto mock debe recibir un secuencia de mensajes particular en un orden preestablecido?

  - Se puede lograr mediante el uso de la clase `InOrder` de la siguiente manera:

  ```java
  // Inicializa el test double
  List unMock = mock(List.class);

  unMock.add("Se agregó primero");
  unMock.add("Se agregó segundo");

  // Crea un verificador InOrder para nuestro mock
  InOrder inOrder = inOrder(unMock);

  // Verifica que unMock.add fue llamado primero con el argumento "Se agregó primero" y luego con "Se agregó Segundo"
  inOrder.verify(unMock).add("Se agregó primero");
  inOrder.verify(unMock).add("Se agregó segundo");
  ```

- ¿Cómo hacer para que un objeto mock este preparado para recibir algunos mensajes sin importar el orden o la obligatoriedad de recibirlos?

  - Se puede lograr mediante la combinación encadenada de `when` y `thenReturn` de la siguiente manera:

  ```java
  // Inicializa el test double
  List unMock = mock(List.class);

  // Prepara el test double para que cuando reciba el mensaje `get`, éste se comporte de la manera especificada
  // Cuando reciba el mensaje `get(0)` retornará "Primero"
  when(unMock.get(0)).thenReturn("Primero");
  // Cuando reciba el mensaje `size()` retornará 50
  when(unMock.size()).thenReturn(50);
  ```

- ¿Es posible anidar envío de mensajes con mockito? Si es posible, ¿cómo se hace?

  - El anidamiento de mensajes puede lograrse mediate el uso del enumerativo `Mockito.RETURNS_DEEP_STUBS` al momento de configuración del mock de la siguiente manera:

  ```java
  // Inicializa el mock
  ClaseAsombrosa unMock = Mockito.mock(ClaseAsombrosa.class, Mockito.RETURNS_DEEP_STUBS);

  // Prepara el test double para una cadena de llamados anidada
  when(unMock.metodoUno().metodoDos().metodoTres()).thenReturn("Valor anidado");
  ```

- ¿Como es la forma de verificación con mockito?

  - Se puede lograr mediante el uso de `verify` de la siguiente manera:

  ```java
  // Inicializa el test double
  List unMock = mock(List.class);

  // Se hace uso del test double
  unMock.add("Primero");
  unMock.clear();

  // Verifica que se le hayan enviado los mensajes `add("Primero")` y `clear()`
  verify(unMock).add("Primero");
  verify(unMock).clear();
  ```

## 7. Test Doubles

- ¿Qué son los test doubles?

  - Son objetos o componentes que se utilizan en lugar de los reales para asistir en la ejecución de tests.

- Enumere los tipos de test doubles y de ejemplos concretos de uso. Indique como usaría, cuando es posible,
  `mockito` para emular los diferentes tipos de tipos de test doubles.

  - Un _Dummy Object_ es un objeto que se pasa al SUT como argumento (o como atributo de un argumento) en lugar de otro pero que nunca será utilizado. Como particularidad no precisan ser instalados ni configurados previo uso y de ellos solo se espera que existan.

    - El siguiente ejemplo demuestra cómo utilizar un Dummy Object:

    ```java
    // Instanciación del objeto `dummy` con Mockito
    Impresora impresora = mock(Impresora.class);

    // Ejecuta el SUT
    impresoras.add(impresora);

    // Verificamos que el la ejecución de `add` haya incrementado el total de elementos de la lista
    assertEquals(1, impresora.size());
    ```

  - Un _Test Stub_ es un objeto que actúa como un punto de control para brindarle las entradas indirectas al SUT cuando los métodos del Test Stub son invocados. Su uso nos permite ejecutar ramas del código sin evaluar que de otra forma serían imposibles de alcanzar durante un test. Un _Responder_ es un Test Stub básico que se usa para inyectarle al SUT entradas indirectas válidas e inválidas a través de las invocaciones normales de sus métodos. Un _Saboteur_ es un caso especial de Test Stub que lanza excepciones o errores para inyectarle entradas indirectas anormales al SUT.

    - El siguiente ejemplo demuestra cómo un Test Stub puede afectar el comportamiento del SUT al momento de ejecución del test:

    ```java
    // Instanciación del objeto `dummy` con Mockito
    Cartucho cartucho = mock(Cartucho.class);
    // El `dummy` se convierte en un `stub`
    when(cartucho.getNivelTinta()).thenReturn(50);

    // Instalación del Test Stub
    Impresora impresora = new Impresora(cartucho);

    // SUT
    // Consulta si el nivel de tinta del cartucho es mayor a 0 y determina si puede imprimir
    Boolean puedeImprimir = impresora.puedeImprimir();

    // Verificamos que el resultado sea el esperado
    assertTrue(puedeImprimir);
    ```

  - Un _Test Spy_ es un objeto que actúa como punto de observación de las salidas indirectas del SUT. Es una forma más avanzada del Test Stub, al cual se le agrega la capacidad de registrar todas las llamadas hechas a sus métodos por el SUT, las cuales luego pueden ser verificadas mediante una serie de aseveraciones.

    - El siguiente ejemplo demuestra cómo pueden verificarse las salidas indirectas del SUT mediante el uso de Mockito:

    ```java
    // Instanciación del objecto Documento y transformamción en `spy` por Mockito
    Documento spyDocumento = spy(Documento("Contenido del documento"));
    Impresora impresora = new Impresora();

    // SUT
    // Le pide el contenido a un documento y lo imprime
    impresora.imprimir(spyDocumento);

    // Verificamos que se le haya enviado un mensaje al Documento para obtener su contenido
    verify(spyDocumento).getContenido();
    ```

  - Un _Mock Object_ es un objeto que también puede actuar como punto de observación de las salidas indirectas del SUT. Al igual que un Test Stub, puede necesitar retornar información como respuesta al llamado de sus métodos (respuestas pre-programadas). Y al igual que un Test Spy, registra todas las llamadas hechas a sus métodos por el SUT para luego verificarse.

    - El siguiente ejemplo demuestra cómo pueden alterarse las entradas indirectas y verificarse las salidas indirectas del SUT mediante el uso de Mockito:

    ```java
        // Configuración de los mocks de Cartucho y Documento
        Cartucho cartucho = mock(Cartucho.class);
        when(cartucho.getNivelTinta()).thenReturn(50);
        Documento documento = mock(Documento.class);
        when(documento.getContenido()).thenReturn("Contenido del documento");

        // Instalación del mock Cartucho
        Impresora impresora = new Impresora(cartucho);

        // SUT
        // Consulta si el nivel de tinta del cartucho es mayor a 0 y determina si puede imprimir
        // Le pide el contenido a un documento y lo imprime
        impresora.imprimir(documento);

        // Verificamos que se hayan enviado una sola vez los mensajes correctos
        verify(documento, times(1)).getContenido()
        verify(cartucho, times(1)).reducirNivelTinta(1);
    ```

  - Un _Fake Object_ es un objeto que reemplaza la funcionalidad del DOC real con una implementación alternativa de la misma funcionalidad o un subconjunto de ella. A diferencia de un Test Stub o un Mock Object no es controlado ni observado por test. Una de las razones más comunes para su utilización es cuando el DOC real todavía no fue creado.

    - Un ejemplo común para el uso de un Fake Object es la implementación de una falsa base de datos (en memoria o archivo).

## Glosario

- Depended-on component (_DOC_): Una clase individual o un gran componente en el cual el SUT depende. El DOC es de principal interes durante el test debido a que se puede observar y/o controlar sus interacciones con el SUT para conseguir una mayor cobertura.

- System Under Test (_SUT_): Lo que sea que se esté testeando. El SUT siempre está definido desde la perspectiva del test. Cuando se escriben tests unitarios, el SUT es la clase, objeto o método que se está evaluando.

## Bibliografía

- Lasse Koskela. _Effective Unit Testing_. Manning, 2013.
- Gerard Meszaros. _xUnit Test Patterns: Refactoring Test Code_. Addison-Wesley Professional, 2007.

## Links

- [Mockito](https://javadoc.io/static/org.mockito/mockito-core/3.3.3/org/mockito/Mockito.html)
