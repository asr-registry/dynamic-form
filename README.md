### Dynamic HTML Form Management and HTML Generation based on JSON schema


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
    "properties": {
      "email": {
        "type": "string",
        "description": "email",
        "format": "email"
      },
      "password": {
        "type": "string",
        "description": "Password"
      },
      "rememberMe": {
        "type": "boolean",
        "default": false,
        "description": "Remember me"
      },
        "operatingSystem": {
          "type": "string",
          "oneOf": [
            {
              "enum": [
                "linux"
              ],
              "description": "GNU/Linux"
            },
            {
              "enum": [
                "osx"
              ],
              "description": "OSX"
            },
            {
              "enum": [
                "windows"
              ],
              "description": "Windows"
            },
            {
              "enum": [
                "other"
              ],
              "description": "Other"
            }
          ],
          "default": "other"
        }
    },
    "required": ["email","password","rememberMe"],
     "buttons": [
           {
             "id": "reset",
             "label": "Reset"
           },
           {
             "id": "custom_b",
             "label": "My custom button",
             "widget": "my_custom_button" 
           }
         ]
  }
}
```


####  Documentation 
for more information refer to https://github.com/guillotinaweb/ngx-schema-form
