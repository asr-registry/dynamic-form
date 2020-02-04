### Dynamic HTML Form Management for HTML Generation based on JSON schema


#### Guide

```xml

		<dependency>
                       <groupId>af.asr</groupId>
                        <artifactId>dynamic-form</artifactId>
			<version>${project.version}</version>
		</dependency>

```

add following properties dependencies to your `application.properties`

```properties
## Spring DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
spring.datasource.url=jdbc:postgresql://localhost:5432/test
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.username= 
spring.datasource.password= 

## serialization of lazyloaded relationship causes to error when objects not loaded
spring.jackson.serialization.fail-on-empty-beans=false

# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQL82Dialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto = update
spring.jpa.show-sql=true

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true

```
#### Features

- Generate a form from a single json schema object
- Generate a form from a default set of html constructs
- Allow initialization from previous values
- Validation handled by z-schema
- Allow injection of custom validators
- Allow declaration of custom widgets
- Allow injection of custom bindings (new!)


#### JSON Schema Sample 

```json
{
  "title": "Otherschema",
  "fieldsets": [
    {
      "fields": [
        "title",
        "description"
      ],
      "id": "default",
      "title": "Default"
    },
    {
      "fields": [
        "author",
        "language"
      ],
      "id": "settings",
      "title": "Settings"
    }
  ],
  "properties": {
    "description": {
      "description": "Short description",
      "minLength": 0,
      "title": "Summary",
      "type": "string",
      "widget": {
        "id": "textarea"
      }
    },
    "title": {
      "description": "",
      "title": "Title",
      "type": "string",
      "widget": {
        "id": "string"
      }
    },
    "author": {
      "description": "",
      "title": "Author",
      "type": "string",
      "widget": {
        "id": "string"
      }
    },
    "language": {
      "description": "",
      "oneOf": [
        {
          "enum": [
            "es"
          ],
          "description": "Spanish"
        },
        {
          "enum": [
            "fr"
          ],
          "description": "French"
        }
      ],
      "title": "Language",
      "type": "string",
      "widget": {
        "id": "select"
      }
    }
  },
  "required": [
    "title"
  ],
  "type": "object",
  "widget": {
    "id": "object"
  }
}

```


####  Documentation 
for more information refer to https://github.com/guillotinaweb/ngx-schema-form
