# Bishop Prototype

**Bishop Prototype** — REST-сервис-эмулятор синтетика, демонстрирующий возможности стартера `synthetic-human-core-starter`, созданного по заданию Weyland-Yutani.
Служит верификацией архитектурных решений и иллюстрирует работу всех ключевых компонентов:

* Прием и исполнение команд
* Очередь задач
* Аудит действий синтетика
* Метрики занятости
* Обработка ошибок

---

## Функциональность

🔹 **Отправка команд:**

* POST `/commands` — отправить команду в систему

  ```bash
  POST /command?authorType=SCIENTIST_WEYLAND&commandType=CHECK_ENERGY
  ```

* Команды с приоритетом:

  * `CRITICAL` — выполняются немедленно
  * `COMMON` — помещаются в очередь

🔹 **Очередь:**

* Обрабатывается в фоновом потоке
* Максимальная длина ограничена
* При переполнении возвращается ошибка `503`

🔹 **Аудит:**

* Методы, помеченные `@WeylandWatchingYou`, логируют:

  * Название метода
  * Аргументы
  * Результат
  * Timestamp
* Поддерживаются два режима:

  * Вывод в консоль (по умолчанию)
  * Отправка в Kafka (настраивается)

🔹 **Метрики (через Spring Actuator):**

* `GET /actuator/metrics/bishop.command.queue.size` — размер очереди
* `GET /actuator/metrics/bishop.commands.per.author` — число команд на автора

🔹 **Единый формат ошибок:**

```json
{
  "status": "VALIDATION_ERROR",
  "message": "Field 'time' must match ISO 8601",
  "details": {
    "time": "должно соответствовать \"^\\d{4}-...\""
  }
}
```

---

## Запуск

1. Убедитесь, что `starter` собран и доступен в локальном Maven-репозитории:

   ```bash
   cd ../bishop-starter
   mvn clean install
   ```

2. Запустите прототип:

   ```bash
   cd ../bishop-prototype
   mvn spring-boot:run
   ```

3. Отправьте тестовую команду


---

## Стек технологий

* Java 17
* Spring Boot 3
* Maven
* Micrometer / Actuator
* AOP

---


## Конфигурация

`application.yml`:

```properties
audit.mode=CONSOLE # или KAFKA
kafka.topic=audit-log
kafka.bootstrap-servers=localhost:9092
```
