# Kalolo-api
API de gestion des expressions caldoches à nous les mecs du caillou

## Démarrer le service
`mvn spring-boot:run`

## Endpoints

`/` : Documentation Swagger

`/auteurs` : La liste de tous les auteurs

`/auteurs/random` : Un auteur au hasard

`/auteurs/auteur/{idAuteur}` : L'auteur d'identifiant {idAuteur}

`/auteurs/{cleAuteur}` : L'auteur d'identifiant {cleAuteur}

`/types` : La liste de tous les types de média

`/types/type/{idType}` : Le type de média d'identifiant {idType}

`/medias` : La liste de tous les médias

`/medias/media/{idMedia}` : Le média d'identifiant {idMedia}

`/medias/random` : Un média au hasard

`/medias/auteur/{cleAuteur}` : La liste de tous les médias de l'auteur {cleAuteur}

`/medias/auteur/{cleAuteur}/media/{idMedia}` : Le média d'identifiant {idMedia} de l'auteur {cleAuteur}

`/medias/auteur/{cleAuteur}/random` : Un média au hasard de l'auteur {cleAuteur}

`/tags` : La liste de tous les tags

`/tags/tag/{idTag}` : Le tag d'identifiant {idTag}

`/tags/{cleTag}` : Le tag d'identifiant {cleTag}

`/expressions` : La liste de toutes les expressions

`/expressions/expression/{idExpression}` : L'expression d'identifiant {idExpression}

`/expressions/random` : Une expression au hasard

`/expressions/tag/{cleTag}` : La liste de toutes les expressions ayant pour tag {cleTag}

`/expressions/tag/{cleTag}/expression/{idExpression}` : L'expression d'identifiant {idExpression} ayant pour tag {cleTag}

`/expressions/tag/{cleTag}/random` : Un expression au hasard ayant pour tag {cleTag}


## Exemples d'appels

`/auteurs`
`/auteurs/random`
`/auteurs/auteur/3`
`/auteurs/ollivaud`

`/types` 
`/types/type/2`

`/medias`
`/medias/random`
`/medias/media/11`
`/medias/auteur/kingtaz`
`/medias/auteur/kingtaz/media/8`
`/medias/auteur/kingtaz/random`

`/tags`
`/tags/tag/3`
`/tags/bonjour`

`/expressions`
`/expressions/random`
`/expressions/expression/11`
`/expressions/tag/joie`
`/expressions/tag/joie/expression/113`
`/expressions/tag/joie/random`