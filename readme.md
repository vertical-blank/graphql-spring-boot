
# Spring Boot / GraphQL / DOMA2

## 参考にしたもの

- https://www.graphql-java.com/tutorials/getting-started-with-spring-boot/

## DDL

```sql
create table book (
id serial,
name text,
page_count Int,
author_id int
);

create table author (
id serial,
first_name text,
last_name Int
);
```

```sql
insert into book values
    (default, 'Harry Potter and the Philosopher''s Stone', 223, 1),
    (default,'Moby Dick',635, 2),
    (default, 'Interview with the vampire', 371, 3);

insert into author values
    (default,'Joanne','Rowling'),
    (default,'Herman','Melville'),
    (default,'Anne','Rice');
```

## 起動

```sh
./gradlew bootrun
```

## クエリ

```sh
curl --request POST \
  --url http://localhost:8080/graphql \
  --header 'content-type: application/json' \
  --data '{"query":"{ bookById(id: 2) { id name pageCount author { firstName lastName } } }"}'
```

```json
{"data":{"bookById":{"id":2,"name":"Moby Dick","pageCount":635,"author":{"firstName":"Herman","lastName":"Melville"}}}}
```
