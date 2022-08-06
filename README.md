# Projet Tenisu - L'Atelier
C'est une API REST de statistiques des joueurs de tenis.
Elle est developpée avec **Spring Boot** et les donnees sont stockée dans **PostgreSQL**.
## Demarrage
L'application est conteneurisée avec **Docker**\
Elle peut etre demarrée en local avec **docker build/docker run**.\
Pour notre cas nous l'avons deploy dans **Amazon ECS**, l'url est:\
**http://ec2-54-229-16-168.eu-west-1.compute.amazonaws.com:8080/api/players**
## Utilisation
Les methodes WS disponibles sont:
- **POST /api/countries**
Ajouter un **Country** avec les deux champs **code** et **picture**.\
EX: 
```json
{
    "picture": "https://data.latelier.co/training/tennis_stats/resources/Serbie.png",
    "code": "SRB"
}
```
- **POST /api/players** \
Ex:
```json
{
    "firstname": "Novak",
    "lastname": "Djokovic",
    "shortname": "N.DJO",
    "sex": "M",
    "countryCode": "SRB",
    "picture": "https://data.latelier.co/training/tennis_stats/resources/Djokovic.png",
    "rank": 2,
    "points": 2542,
    "weight": 80000,
    "height": 188,
    "age": 31,
    "last": [
        1,
        1,
        1,
        1,
        1
    ]
}
```
- **GET /api/players**
```json
[
    {
        "id": 1,
        "firstname": "ff",
        "lastname": "qqqq",
        "shortname": "N.DJO",
        "picture": "https://data.latelier.co/training/tennis_stats/resources/Djokovic.png",
        "sex": "M",
        "age": 31,
        "rank": 0,
        "height": 188,
        "last": [
            1,
            1,
            1,
            1,
            1
        ],
        "country": {
            "code": "SRB",
            "picture": "https://data.latelier.co/training/tennis_stats/resources/Serbie.png"
        },
        "points": 0,
        "weight": 0
    },
    {
        "id": 2,
        "firstname": "sss",
        "lastname": "qqqq",
        "shortname": "N.DJO",
        "picture": "https://data.latelier.co/training/tennis_stats/resources/Djokovic.png",
        "sex": "M",
        "age": 31,
        "rank": 2,
        "height": 188,
        "last": [
            1,
            1,
            1,
            1,
            1
        ],
        "country": {
            "code": "SRB",
            "picture": "https://data.latelier.co/training/tennis_stats/resources/Serbie.png"
        },
        "points": 0,
        "weight": 0
    }
]
```
- **GET /api/players/{id}**
- **GET /api/players/avg-imc**
