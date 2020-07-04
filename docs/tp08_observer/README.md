# TP08 - Observer

## 2. Publicaciones

![Publicaciones](uml-02-publicaciones.png)

- Se utilizó el patrón _Observer_ para modelar la interacción entre el `Sistema` y cada `Suscriptor`. Y, además, el patrón _Composite_ para modelar el `Criterio` de notificación que se debe revisar antes de enviar una notificación a un `Sucriptor` de parte del `Sistema`. El almacenar la asociación entre cada suscriptor y sus criterios de notificación nos ayuda a enviar solamente noticaciones de sumo interés para el suscriptor.

  - Roles patrón Observer:

    - Subject: se decidió por no implementar una abstracción del mismo
    - Observer: `Suscriptor`
    - ConcreteSubject: `Sistema`
    - ConcreteObserver: `Investigador`

  - Roles patrón Composite:
    - Component: `Criterio`
    - Leafs:
      - `CriterioTitulo`
      - `CriterioAutor`
      - `CriterioFiliacion`
      - `CriterioTipo`
      - `CriterioLugarPublicacion`
      - `CriterioPalabrasClave`
    - Composite: `CriterioCompuesto`

- Ver implementación Java en `SistemaTest` para ejemplos de funcionamiento.

## 3. Encuentros Deportivos

![Encuentros Deportivos](uml-03-encuentros-deportivos.png)

- Se utilizó el patrón _Observer_ para modelar la interacción entre el `Sistema` y cada `Suscriptor`. Y, además, el patrón _Composite_ para modelar el `Aspecto` sobre el cual un `Sucriptor` quiere ser notificado por el `Sistema`, sin importar la complejidad de los mismos. El almacenar la asociación entre cada suscriptor y sus aspectos de interés en el sistema nos ayuda a minimizar la cantidad de mensajes enviados a cada uno de ellos y solo enviarles notificaciones que realmente les sean de interés.

  - Roles patrón Observer:

    - Subject: se decidió por no implementar una abstracción del mismo
    - Observer: `Suscriptor`
    - ConcreteSubject: `Sistema`
    - ConcreteObserver:
      - `AplicacionMovil`
      - `Servidor`

  - Roles patrón Composite:
    - Component: `Aspecto`
    - Leafs:
      - `AspectoDeporte`
      - `AspectoContrincantes`
    - Composite: `AspectoCompuesto`

- Ver implementación Java en `SistemaTest` para ejemplos de funcionamiento.
