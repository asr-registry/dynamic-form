### Dynamic HTML Form Management and HTML Generation based on JSON schema


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
