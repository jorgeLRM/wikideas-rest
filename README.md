# wikideas-rest  
  
### Introduction  
Wikideas-rest is a REST API that represents a encyclopedia that allows the collection, storage and transmission of information in a structured way  
  
### Wikideas REST API Features  
* Create new topic  
* Update topic  
* List all topics by title and category name  
* Find topic by id  
* List all categories  
  
## API Endpoints  
<details>  
 <summary><code>POST</code> <code><b>/topics</b></code> <code>(Save topic)</code></summary>  
  
##### Parameters  
> None  
  
##### Responses  
  
> | http code | content-type               | response  |  
> |-----------|----------------------------|-----------|  
> | `201`     | `text/plain;charset=UTF-8` | `Created` |

##### Example cURL  
> ```javascript  
>  curl -X POST -H "Content-Type: application/json" --data @post.json http://localhost:8080/topics  
> ```  
</details>

------------------------------------------------------------------------------------------
<details>
 <summary><code>GET</code> <code><b>/topics?title=[titleTopic]&categoryName=[categoryName]&page=[page]&size=[size]</b></code> <code>(Find all topics by title and category name)</code></summary>

##### Parameters

> None

##### String Parameters

> | name      |  type     | data type               | description                                                           |
> |-----------|-----------|-------------------------|-----------------------------------------------------------------------|
> | titleTopic      |  optional | text   | Title topic. Default value is ""  |
> | categoryName | optional | text | Name of category. Default value is "" |
> | page | optional | number | Current page. Default value is 0 |
> | size | optional | number | Size page. Default value is 5 |

##### Responses

> | http code     | content-type                      | response                                                            |
> |---------------|-----------------------------------|---------------------------------------------------------------------|
> | `200`         | `text/plain;charset=UTF-8`        | `Ok`                                                      |
> 
##### Example cURL

> ```javascript
>  curl -X GET -H "Content-Type: application/json" http://localhost:8080/topics?title=soccer&categoryName=sport&page=2&size=5
> ```

</details>

------------------------------------------------------------------------------------------

<details>
 <summary><code>GET</code> <code><b>/topics/{id}</b></code> <code>(Find topic by id)</code></summary>

##### Parameters

> | name      |  type     | data type               | description                                                           |
> |-----------|-----------|-------------------------|-----------------------------------------------------------------------|
> | id      |  required | number   | Id of topic to search  |


##### Responses

> | http code     | content-type                      | response                                                            |
> |---------------|-----------------------------------|---------------------------------------------------------------------|
> | `200`         | `text/plain;charset=UTF-8`        | `OK`                                |
> | `404`         | `application/json`                | `Id not found {id}`                            |

##### Example cURL

> ```javascript
>  curl -X GET -H "Content-Type: application/json" http://localhost:8080/topics/2
> ```

</details>

------------------------------------------------------------------------------------------

<details>  
 <summary><code>POST</code> <code><b>/categories</b></code> <code>(Save new category)</code></summary>  
  
##### Parameters  
> None  
  
##### Responses  
  
> | http code | content-type               | response  |  
> |-----------|----------------------------|-----------|  
> | `201`     | `text/plain;charset=UTF-8` | `Created` |

##### Example cURL  
> ```javascript  
>  curl -X POST -H "Content-Type: application/json" --data @post.json http://localhost:8080/categories  
> ```  
</details>

------------------------------------------------------------------------------------------

<details>
 <summary><code>GET</code> <code><b>/categories</b></code> <code>(Find all categories)</code></summary>

##### Parameters

> None

##### Responses

> | http code     | content-type                      | response                                                            |
> |---------------|-----------------------------------|---------------------------------------------------------------------|
> | `200`         | `text/plain;charset=UTF-8`        | `Ok`                                                       |

##### Example cURL

> ```javascript
>  curl -X GET -H "Content-Type: application/json" http://localhost:8889/categories
> ```

</details>
