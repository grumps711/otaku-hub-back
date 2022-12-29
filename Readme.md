# Notas 28 dic
* Lista de anime o guardar la lista de histórico de los anime
* Incluir variable visto/no visto en los objetos de anime
* Vemos qel buscador de la api de gogo no es tan malo como vimos ayer. Al tener más info y mas ordenado, decimidmos usar la api gogo
* Bug: en la entity @Anime la lista de genres peta. Posibles soluciones:
  * https://www.logicbig.com/examples/jpa/jpa-entity-examples/jpa-simple-array-mapping.html
  * https://www.baeldung.com/java-hibernate-map-postgresql-array
  * https://stackoverflow.com/questions/287201/how-to-persist-a-property-of-type-liststring-in-jpa

---
# Notas 27 dic

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
https://github.com/J9-PT-IRONHACK-JAVA/Team6-Otaku-Hub.git

