# caldoches-api
API de gestion des expressions caldoches à nous les mecs du caillou

## Démarrer le service

`mvn spring-boot:run`

## Endpoints

`/auteurs` : tous les auteurs
`/auteurs/{id}` : un auteur par son id
`/types` : tous les types de média
`/types/{id}` : un type de média par son id
`/medias` : tous les médias
`/medias/{id}` : un média par son id
`/medias/auteur/{cleAuteur}` : tous les médias d'un auteur
`/medias/auteur/{cleAuteur}/{id}` : un média par son id d'un auteur
`/medias/auteur/{cleAuteur}/random` : un média au hasard d'un auteur

## Exemples d'appels

`/auteurs`
`/auteurs/3`
`/types` 
`/types/2`
`/medias`
`/medias/11`
`/medias/auteur/kingtaz`
`/medias/auteur/kingtaz/8`
`/medias/auteur/kingtaz/random`