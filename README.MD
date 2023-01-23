#### Для поиска по `age` использовать 
`http://localhost:8080/persons/by-age?age=40`
#### Для поиска по `name` и `surname` использовать 
`http://localhost:8080/persons/by-name-surname?name=Igor&surname=Serov`
# Задача @Query

## Описание
Перепишем приложение из [первого задания](https://github.com/MslFox/ORM-Hibernate/tree/jpa_repository) на запросы с помощью аннотации `@Query`.

1. Вам необходимо переписать код из [первого задания](https://github.com/MslFox/ORM-Hibernate/tree/jpa_repository), чтобы он теперь работал не через методы-запросы, а через запросы в аннотации `@Query` и язык `JPQL`.

2. Написанные код выложите в тот же репозиторий, что и задача [DAO слой c Hibernate](https://github.com/MslFox/ORM-Hibernate.git) на гитхабe, только создайте под нее другую ветку `jpa-repository-query` и прикрепите ссылку на нее в домашнем задании.
