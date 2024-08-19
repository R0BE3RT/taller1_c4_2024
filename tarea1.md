A. Conceptos Fundamentales

I. ¿Qué es un servicio REST?

Un servicio REST (Representational State Transfer) es un estilo de arquitectura para la creación de servicios web que permite la comunicación entre sistemas a través de protocolos como HTTP.

REST es muy utilizado debido a su simplicidad y eficiencia.

II. ¿Cuáles son los principios del diseño RESTful?

Los principios del diseño RESTful son guías fundamentales que aseguran que una API adherida a la arquitectura REST sea eficiente, escalable y fácil de mantener, los principales principios son:

1. Identificación de Recursos: Cada recurso en un servicio RESTful se identifica de manera única mediante una URL (Uniform Resource Locator), los recursos son elementos clave que representan entidades en el sistema, como usuarios, productos, o pedidos. Por ejemplo, /usuarios/1 podría identificar al usuario con ID 1.

2. Uso de Métodos HTTP, RESTful se basa en los métodos estándar de HTTP para realizar operaciones sobre los recursos como:

GET: Para recuperar un recurso.

POST: Para crear un nuevo recurso.

PUT: Para actualizar un recurso existente.

DELETE: Para eliminar un recurso.

PATCH: Para actualizar parcialmente un recurso.

3. Representaciones de Recursos: Los recursos pueden tener diferentes representaciones (JSON, XML, HTML, etc.), el cliente y el servidor negocian el formato de representación de los datos mediante los encabezados HTTP (Accept y Content-Type).

4. Stateless (Sin Estado): Cada solicitud del cliente al servidor debe contener toda la información necesaria para comprender y procesar la solicitud, el servidor no debe almacenar el estado de la comunicación entre solicitudes. Esto significa que cada solicitud es independiente.

5. Interfaz Uniforme, RESTful promueve una interfaz uniforme que simplifica y desacopla la arquitectura, esto se logra mediante:

-Recursos bien definidos, cada recurso tiene una URL única.

-Métodos estándar de HTTP, el uso consistente de los métodos HTTP.

-Representación consistente, el recurso se representa de la misma manera a través de diferentes operaciones.

6. Cacheabilidad: Las respuestas deben ser explícitamente etiquetadas como cacheables o no, si una respuesta es cacheable, el cliente puede reutilizarla para solicitudes posteriores, lo que mejora el rendimiento y reduce la carga del servidor.

7. Sistemas en Capas: La arquitectura REST permite la implementación de la API en capas. Esto significa que un cliente no necesita saber si está comunicándose directamente con el servidor final o con un intermediario (como un proxy o un balanceador de carga), esta separación facilita la escalabilidad y la seguridad.

8. Código a Pedido (Opcional): REST permite la extensión de la funcionalidad en el cliente mediante la descarga de código ejecutable (como scripts JavaScript), este principio es menos común, pero puede ser útil en ciertos casos para la personalización dinámica del cliente.

III. ¿Qué es HTTP y cuáles son los métodos HTTP más comunes?

HTTP (Hypertext Transfer Protocol) es un protocolo de comunicación utilizado para la transferencia de información en la web. Es el protocolo subyacente de la World Wide Web y permite la comunicación entre los navegadores web (clientes) y los servidores web, HTTP define cómo se formatean y transmiten los mensajes, así como las acciones que deben tomar los servidores y navegadores en respuesta a varios comandos.

Los métodos HTTP son comandos que indican al servidor qué acción realizar con un recurso determinado, los métodos HTTP más comunes son:

1.GET

-Descripción: Solicita un recurso específico del servidor, este método se utiliza para recuperar datos sin alterar el estado del recurso en el servidor.

-Uso común: Obtener una página web, una imagen, o cualquier otro dato que no necesita ser modificado.

-Ejemplo: GET /usuarios/1 podría solicitar los detalles del usuario con ID 1.

2.POST

-Descripción: Envía datos al servidor para crear un nuevo recurso, los datos se incluyen en el cuerpo de la solicitud.

-Uso común: Crear un nuevo usuario, enviar un formulario de contacto.

-Ejemplo: POST /usuarios podría utilizarse para crear un nuevo usuario.

3.PUT

-Descripción: Actualiza un recurso existente o crea uno nuevo si no existe, el cliente envía los datos en el cuerpo de la solicitud, y          estos reemplazan los datos actuales del recurso.

-Uso común: Actualizar los detalles de un usuario, subir un archivo.

-Ejemplo: PUT /usuarios/1 podría actualizar los detalles del usuario con ID 1.

4.DELETE

-Descripción: Elimina un recurso específico del servidor.

-Uso común: Borrar un usuario, eliminar un archivo.

-Ejemplo: DELETE /usuarios/1 podría eliminar el usuario con ID 1.

5.PATCH

-Descripción: Realiza una actualización parcial de un recurso existente, a diferencia de PUT, PATCH solo modifica los campos especificados en lugar de reemplazar todo el recurso.

-Uso común: Modificar solo un campo de un registro, como el email de un usuario.

-Ejemplo: PATCH /usuarios/1 podría actualizar solo el email del usuario con ID 1.

6.HEAD

-Descripción: Similar a GET, pero solo solicita los encabezados de la respuesta sin el cuerpo, se utiliza para verificar la existencia de un recurso o para obtener metadatos.

-Uso común: Verificar si una página existe, comprobar la última fecha de modificación.

-Ejemplo: HEAD /usuarios/1 podría devolver los encabezados sin el cuerpo de la respuesta.

7.OPTIONS

-Descripción: Devuelve los métodos HTTP que el servidor permite para un recurso específico. Ayuda a saber qué operaciones son posibles.

-Uso común: Descubrir las capacidades de una API, especialmente en situaciones de CORS (Cross-Origin Resource Sharing).

-Ejemplo: OPTIONS /usuarios/1 podría devolver que se permiten los métodos GET, PUT y DELETE para ese recurso.

8.CONNECT

-Descripción: Establece un túnel de comunicación hacia un servidor mediante el protocolo HTTP, generalmente utilizado para conexiones  seguras (HTTPS) a través de proxies.

-Uso común: Conectar a un servidor a través de un proxy para establecer una conexión SSL.

-Ejemplo: CONNECT example.com:443 establecería una conexión SSL con el servidor en el puerto 443.

9.TRACE

-Descripción: Realiza un seguimiento de la ruta que sigue una solicitud a través de un servidor web. Devuelve el contenido de la solicitud tal como fue recibido en cada capa.

-Uso común: Diagnosticar problemas o realizar pruebas de diagnóstico en redes.

-Ejemplo: TRACE /usuarios/1 devolvería la solicitud original recibida por el servidor.

Funcionamiento Básico

En una comunicación HTTP, un cliente envía una solicitud al servidor utilizando uno de estos métodos, y el servidor responde con un código de estado y, opcionalmente, con el recurso solicitado. Los códigos de estado, como 200 OK, 404 Not Found, y 500 Internal Server Error, informan al cliente sobre el resultado de la solicitud.

IV. ¿Qué es un recurso en el contexto de un servicio REST?

En un servicio REST, un recurso es cualquier entidad o dato (como usuarios, productos, o pedidos) que puede ser accedido y manipulado a través de la API. Cada recurso tiene una URI única que lo identifica, y puede ser representado en diferentes formatos como JSON o XML.

Los recursos se gestionan utilizando métodos HTTP como:

GET: Recupera un recurso.

POST: Crea un nuevo recurso.

PUT: Actualiza un recurso existente.

DELETE: Elimina un recurso.

Además, los recursos pueden estar relacionados entre sí y tener estructuras anidadas, permitiendo una navegación clara a través de la API

V. ¿Qué es un endpoint?

Un endpoint es una URL específica en una API donde se puede acceder a un recurso o realizar una operación, se combina con un método HTTP (como GET, POST, PUT, DELETE) para definir la acción a realizar. Por ejemplo, GET /usuarios/1 es un endpoint que recupera los datos del usuario con ID 1.

B. Estructura de un Servicio REST

I. ¿Qué es un URI y cómo se define?

Un URI (Uniform Resource Identifier) es una dirección única que identifica un recurso en una red, como Internet, sería como la dirección postal de un documento, una imagen, un video o cualquier otro contenido en línea.

Definición: Un URI es una cadena de caracteres que sigue un formato específico y que permite localizar de manera precisa un recurso, esta cadena puede incluir:

-Esquema: Indica el protocolo a utilizar para acceder al recurso (por ejemplo, http:// para páginas web, ftp:// para transferencia de archivos).

-Autoridad: Identifica al servidor donde se encuentra el recurso (por ejemplo, www.ejemplo.com).

-Ruta: Especifica la ubicación exacta del recurso dentro del servidor.

-Fragmento: Señala una parte específica del recurso (por ejemplo, un ancla en una página web).

II. ¿Qué es una API RESTful?

Una API RESTful (o API de Transferencia de Estado Representacional) es un tipo específico de interfaz de programación de aplicaciones (API) que sigue los principios de la arquitectura REST. Estas APIs se han vuelto muy populares debido a su simplicidad y flexibilidad, y son ampliamente utilizadas en el desarrollo de aplicaciones web y móviles.

Es una forma sencilla y eficiente de permitir que diferentes aplicaciones se comuniquen entre sí. Su diseño basado en recursos y su uso de métodos HTTP estándar la convierten en una tecnología fundamental en el desarrollo de software moderno.

III. ¿Qué son los códigos de estado HTTP y cómo se usan en REST?

Los códigos de estado HTTP en una API REST indican el resultado de una solicitud, estos códigos ayudan a comunicar si la operación fue exitosa o si hubo un error, y cuál fue su causa.

1.2xx - Éxito:

200 OK: La solicitud fue exitosa.

201 Created: Se creó un nuevo recurso.

204 No Content: La solicitud fue exitosa, pero no hay contenido que devolver.

2.4xx - Error del Cliente:

400 Bad Request: La solicitud es inválida.

401 Unauthorized: No estás autenticado.

403 Forbidden: No tienes permiso para acceder.

404 Not Found: El recurso no se encontró.

3.5xx - Error del Servidor:

500 Internal Server Error: Ocurrió un error en el servidor.

IV. Agregar una tabla con los códigos HTTP de respuesta más comunes, y su significado

| Código HTTP | Nombre               | Significado                                                                                  |
|-------------|----------------------|----------------------------------------------------------------------------------------------|
| 200         | OK                   | La solicitud fue exitosa y se devolvió el recurso solicitado.                                 |
| 201         | Created              | Un nuevo recurso fue creado exitosamente.                                                     |
| 204         | No Content           | La solicitud fue exitosa, pero no hay contenido que devolver.                                 |
| 301         | Moved Permanently    | El recurso solicitado ha sido movido permanentemente a una nueva URL.                         |
| 302         | Found                | El recurso solicitado está temporalmente en una URL diferente.                                |
| 400         | Bad Request          | La solicitud es inválida o malformada.                                                        |
| 401         | Unauthorized         | El cliente no está autenticado; se requiere autenticación.                                    |
| 403         | Forbidden            | El cliente está autenticado, pero no tiene permiso para acceder al recurso.                   |
| 404         | Not Found            | El recurso solicitado no se encontró en el servidor.                                          |
| 409         | Conflict             | Existe un conflicto con el estado actual del recurso.                                         |
| 500         | Internal Server Error| Ocurrió un error inesperado en el servidor.                                                   |
| 502         | Bad Gateway          | El servidor, actuando como puerta de enlace, recibió una respuesta inválida del servidor    ascendente. |
| 503         | Service Unavailable  | El servidor no está disponible temporalmente, generalmente debido a mantenimiento.            |

V. ¿Qué es JSON y por qué se usa comúnmente en APIs REST?

JSON (JavaScript Object Notation) es un formato de texto ligero para el intercambio de datos, es fácil de leer y escribir para los humanos, y fácil de interpretar y generar para las máquinas. JSON está basado en la notación de objetos de JavaScript, pero es independiente del lenguaje, lo que lo convierte en un estándar ampliamente adoptado para la comunicación de datos en la web.

Se Usa Comúnmente en APIs REST por:

1.Interoperabilidad: JSON es un formato de datos estándar que puede ser interpretado por casi todos los lenguajes de programación, lo que lo hace ideal para la interoperabilidad entre sistemas diversos.

2.Facilidad de Uso: JSON es más simple y más fácil de trabajar en comparación con otros formatos de datos como XML. Esto facilita el desarrollo y el mantenimiento de APIs REST.

3.Eficiencia: JSON es más ligero que otros formatos de datos (como XML), lo que lo hace más eficiente en términos de ancho de banda y tiempo de procesamiento.

4.Legibilidad: JSON es fácilmente legible tanto por humanos como por máquinas, lo que facilita la depuración y el desarrollo.

5.Compatibilidad con JavaScript: JSON es nativamente compatible con JavaScript, lo que simplifica su uso en aplicaciones web que interactúan con APIs REST desde el navegador.