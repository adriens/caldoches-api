# caldoches-api
API de gestion des expressions caldoches à nous les mecs du caillou

## Démarrer le service

`mvn spring-boot:run`

## Endpoints

`/auteurs` : La liste de tous les auteurs

`/auteurs/{id}` : L'auteur d'identifiant {id}

`/auteurs/key/{id}` : L'auteur d'identifiant {cleAuteur}


`/types` : La liste de tous les types de média

`/types/{id}` : Le type de média d'identifiant {id}


`/medias` : La liste de tous les médias

`/medias/{id}` : Le média d'identifiant {id}

`/medias/auteur/{cleAuteur}` : La liste de tous les médias de l'auteur {cleAuteur}

`/medias/auteur/{cleAuteur}/{id}` : Le média d'identifiant {id} de l'auteur {cleAuteur}

`/medias/auteur/{cleAuteur}/random` : Un média au hasard de l'auteur {cleAuteur}


`/tags` : La liste de tous les tags

`/tags/{id}` : Le tag d'identifiant {id}

`/tags/key/{id}` : Le tags d'identifiant {cleTag}


`/expressions` : La liste de toutes les expressions

`/expressions/{id}` : L'expression d'identifiant {id}

`/expressions/tag/{cleTag}` : La liste de toutes les expressions ayant pour tag {cleTag}

`/expressions/tag/{cleTag}/{id}` : L'expression d'identifiant {id} ayant pour tag {cleTag}

`/expressions/tag/{cleTag}/random` : Un expression au hasard ayant pour tag {cleTag}


## Exemples d'appels

`/auteurs`
`/auteurs/3`
`/auteurs/key/ollivaud`

`/types` 
`/types/2`

`/medias`
`/medias/11`
`/medias/auteur/kingtaz`
`/medias/auteur/kingtaz/8`
`/medias/auteur/kingtaz/random`

`/tags`
`/tags/3`
`/tags/key/bonjour`

`/expressions`
`/expressions/11`
`/expressions/tag/joie`
`/expressions/tag/joie/113`
`/expressions/tag/joie/random`