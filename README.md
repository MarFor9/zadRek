## Zadanie rekturacyjne.

W celu łatwego zaimplementowania posłużono się Dockerem.

Technologia:Java, Primefaces, JSF, PostgreSQL, Tomcat.


Opis: Przy użyciu powyższych technologii zaimplementuj prostą aplikację do obsługi pracowników. Aplikacja ma wyświetlać tabelę z danymi pracownika pobieranymi z bazy danych. Stwórz panel do dodawania nowego pracownika z danymi np. imię, nazwisko, adres, mail. Dodaj możliwość edycji i usuwania pracowników. Dodaj walidację wprowadzanych danych np. maila. Aplikacja powinna uruchamiać się na tomcacie w przeglądarce. Aplikację wyślij jako link do repozytorium na GitHubie. Dołącz krótką instrukcję uruchomienia oraz dokumentację.

Przed uruchomieniem aplikacji należy zainstalować Docker'a. 

### Aby uruchomić aplikację należy:
> 1. ~~Należy w terminalu wpisać komendę **docker-compose up -d**~~
> 1. Skopiować repozytorium
> 2. w terminalu wpisać komende: **docker run --name postgres -e POSTGRES_PASSWORD=root -e POSTGRES_DB=workers_db -d -p 5432:5432 postgres:alpine**
> 3. uruchomić aplikacę np. w Intellij [RUN]

Aplikacja jest dostępna w przeglądarce pod adresem:
> **http://localhost:8080/worker.xhtml**

Aplikacja daje możliwość:
> * dodawania,
> * edytowania,
> * usuwania
> * wyświetlenia wszystkich pracowników

Przy pomocy programu np. Postman można korzystająć z poniższych api:
> * pobrać listę pracowników - [GET] http://localhost:8080/api/v1/workers
> * pobrać jednego pracownika - [GET] http://localhost:8080/api/v1/workers/id   (gdzie id jest liczba całkowitą)
> * dodać nowego pracownika - [POST] http://localhost:8080/api/v1/workers

aby dodać nowego pracownika należy posłużyć się plikiem w formacie json:
```
{
        "firstName": "Jannn",
        "lastName": "Kowalskiiii",
        "address": "Gdynia",
        "mail": "jankowalski@gmail.com"
 }
 ```

 mail jest poddany walidacji, co znaczy, że nie można dodać błędnego formatu maila.
> * edytować pracownika - [PUT] http://localhost:8080/api/v1/workers/id   (gdzie id jest liczba całkowitą)
> * usunąć pracownika - [DELETE] http://localhost:8080/api/v1/workers/id  (gdzie id jest liczba całkowitą)



