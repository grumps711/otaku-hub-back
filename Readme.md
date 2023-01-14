```
![text-1673644554952](https://user-images.githubusercontent.com/83793367/212465114-6a8d1f32-410c-4d35-bbd3-735ff91d14d9.png
        
```

# Introduction

API: Search, store, watch and play to our Trivial... Anime Everywhere.

# Endpoints

## Anime

GET http://localhost:80/anime/anime-details

GET http://localhost:80/anime/popular

GET http://localhost:80/anime/sceneImage

GET http://localhost:80/anime/search

GET http://localhost:80/anime/search/byGenre

GET http://localhost:80/anime/search/byScene

GET http://localhost:80/anime/watch

## Trivial

GET http://localhost:80/trivial/quote

GET http://localhost:80/trivial/sceneImage

## Quote

GET http://localhost:80/quote/quotes

GET http://localhost:80/quote/quotes/anime

GET http://localhost:80/quote/quotes/character

GET http://localhost:80/quote/random

GET http://localhost:80/quote/random/anime

GET http://localhost:80/quote/random/character

## Users

PATCH http://localhost:80/users/addanime/{{username}}

PATCH http://localhost:80/users/addpoints/{{username}}

PATCH http://localhost:80/users/admin/updateUserByAdmin/{{username}}

GET http://localhost:80/users/checkuser/{{username}}

POST http://localhost:80/users/create

DELETE http://localhost:80/users/delete/{{username}}

GET http://localhost:80/users/getAll

GET http://localhost:80/users/getByUsername

PATCH http://localhost:80/users/updateByUser/{{username}}


<hr>

_Developed by:_

![imagen](https://user-images.githubusercontent.com/83793367/212431897-31723c4c-6160-464c-a01e-aeefc93d6b93.png)





























# Notas 9 Enero

* Para comprobar si el username está en la base de datos, usaremos Supabase (base de datos de front).
* Demo:
    * empezar sin usuarios en las basede datos de supabase y back end
    * desde la pagina de login, crearemos un usuario en la página de Sign up
    * Una vez creado se crea el usuario en la base de datos de Supabase y en el 
    
* Security
  * crear un metodo "create user": en la securityConfig hay que indicar que el endoPoint no requiere
  * SecurityConfig: linea 31-32
    * requestMatchers("/public/**").permitAll() --> las rutas con "public" no será necesario autentificación
    * .requestMatchers(HttpMethod.GET, "/top-secret/ultra").hasRole("ADMIN") --> para acceder a los endpoints con las rutas con "/top-secrete/ultra" es necesario tener el role "ADMIN
    ![image](https://user-images.githubusercontent.com/115550667/211384308-32edc338-9d27-48ac-97f6-3440371f1c58.png)


* endPonit createUser --> pendiente de defnir como recibir en el endpoint: como objeto o como Username + password

* limite de busqueda de imagenes en https://trace.moe. --> probar:
  * si usando Postman se llega al limite

---
# Notas 8 Enero.  

* Crear una página para login: username & password
   * endopoint : recibe jugador y suma puntos --> dentro del Trivialler Controller (GoodAnswer)
   * endopoint : para comprobar si el usuario loggeado está crear una página para login en la base de datos (confirmar con Euge la viabilidad de hacerlo en Front)
* añadir en la configuración de la seguridad: que endpoints puede user el admin y el resto de user


---
# Notas 7 enero. 

* Lisa se mirará como enlazar IntelliJ con VSCode
* Trivial:
  * Las preguntas irán alternando entre una quote y una imagen de escena
  * Se darán tres posibles respuestas (titulos de anime): 
       * x1 correcta que la cogemos de la API que genera la Quote o la imagen
       * x2 erróneas que las cogemos de la API gogoanime/popular
* endopoint "trivialQuote"
  *  Pablo crear un objeto QuoteTRivial para darselo al Front
* Trivial de imagenes: Andres ha creado una base de datos de imagenes. El plan es guardar imagenes en una base de datos creado por nosotros
  *  package demo --> metodo loadAnumeSceneImages()
  *  Ejemplos de anime: boku no hero, haikyyu, run with the wind, kaiji, inazuma eleven, aku no hana, flcl, death note, jojo's bizarre adventure, hajime no ippo, my hero academia, naruto, neon genesis evangelion


* Como copiar la url de la imagen:
  * buscar en google la imagen
  * clic derecho en la imagen
  * seleccionar "click enlace lde la imagen"
  * comprobar en https://trace.moe

---
# Notas 28 dic. 

* Lista de anime o guardar la lista de histórico de los anime
* Incluir variable visto/no visto en los objetos de anime
* Vemos qel buscador de la api de gogo no es tan malo como vimos ayer. Al tener más info y mas ordenado, decimidmos usar la api gogo
* Bug: en la entity @Anime la lista de genres peta. Posibles soluciones:
  * https://www.logicbig.com/examples/jpa/jpa-entity-examples/jpa-simple-array-mapping.html
  * https://www.baeldung.com/java-hibernate-map-postgresql-array
  * https://stackoverflow.com/questions/287201/how-to-persist-a-property-of-type-liststring-in-jpa

---
# Notas 27 dic. 

## Funciones de la app

* **search specific anime given NPL search (obtain specifications, score and reviews)**

* **animeList: save anime, delete anime, add comments**
    - Buscador definitivo que usamos --> https://kitsu.docs.apiary.io/#introduction/json:api/filtering-and-search
    - Descartamos este buscador:https://gogoanime.consumet.org/anime-details/naruto
      - Usar el end point **Anime details**
      - Buscar por genero
      - Espacios se imputan por guion medio
      - se necesita imputar el nombre exacto. No pilla erratas

* **recover episode from scene image**
  - https://github.com/riimuru/gogoanime-api#get-episode-thread
    - Realizar un trivial para retar a los usuarios
    - Tricky: buscar una base de datos de imágenes para mostrar al usuario
    - Debería haber una base de datos o url
    - dos modos de juego: empezamos con modo 1 Player (opcional hacerlo con 2 players)
      - Idea: ir ganando estrellas que te den categorías: oro,plata, bronce
      - 
* **look for the streaming episode to watch it**
  - usuario busca anime por nombre (o por genero <--WANT)
  - Se muestra la lista de episodios completa
  - usuario elige un capítulo 
  - usuario clic en el capítulo
  - app envía a la url del episodio
  - Incluir esta opción en la opción de Anime

## Front End (Euge)
* Keep it simple
* Dos botones
  * **Search** Anime: 
    * Watch
    * Rate
    * Add to list
  * **Trivial** anime

## Back End (Andres, Pablo)
* Crear modelo
* Crear Open Feigne
* Conectarlo API kitsu
* Comprobar si podemos guardar el objeto 

## Nombre de la app
- Otaku hub 

## Repositorio

[//]: # (https://github.com/J9-PT-IRONHACK-JAVA/Team6-Otaku-Hub.git)

#� �T�e�a�m�6�-�O�t�a�k�u�H�u�b�
�
�#� �T�e�a�m�6�-�O�t�a�k�u�H�u�b�
�
�#� �T�e�a�m�6�-�O�t�a�k�u�H�u�b�
�
�#� �T�e�a�m�6�-�O�t�a�k�u�H�u�b�
�
�#� �T�e�a�m�6�-�O�t�a�k�u�-�H�u�b�
�
�
