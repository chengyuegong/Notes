# AJAX
Asynchronous Javascript anx XML.
The notes are based on [AJAX and JSON](https://classes.engineering.wustl.edu/cse330/index.php?title=AJAX_and_JSON).  

**Contents**
* [XMLHttpRequest](#xmlhttprequest)
* [Events](#events)
* [Document Object Model](#document-object-model)


## XMTHttpRequest

### Fetch API
GET Data: include GET variables - '/path/to/php/file?x='hi'
```js
fetch('/path/to/php/file', {
    method: "GET"
})
```

POST Data
```js
const data = { x: 'hi', y: 'hello' };
fetch('/path/to/php/file', {
    method: "POST",
    body: JSON.stringify(data)
})
```

Listening for a response
```js
const pathToPhpFile = 'test.php';
const data = { x: 'hi', y: 'hello' };
fetch(pathToPhpFile, {
    method: "POST",
    body: JSON.stringify(data)
  })
  .then(res => res.json())
  .then(response => console.log('Success:', JSON.stringify(response)))
  .catch(error => console.error('Error:',error))
```

### Response Formats
XML: close to HTML
```xml
<?xml version="1.0" standalone="yes" ?>
<note>
  <date year="2013" month="02" day="14" />
  <to>Sally</to>
  <message>Happy Valentine's Day!</message>
  <from>Your Secret Admirer</from>
</note>
```
If you make an AJAX request to a script generating an XML document, the root XML node is accessible in the responseXML property.
```js
function ajaxCallback(event){
  var xmlDocument = event.target.responseXML;
  alert(xmlDocument.getElementsByTagName("to")[0].textContent);  // Sally (in the case of the example XML above)
}
```
JSON: JavaScript Object Notation
```json
{
   "apple": {
      "color": "red",
      "flavor": "sweet"
   },
   "lemon": {
      "color": "yellow",
      "flavor": "sour"
   }
}
```
Convert a JSON string to an object using **JSON.parse()** and use it in conjunction with AJAX response callback:
```js
function ajaxCallback(event){
	var jsonData = JSON.parse(event.target.responseText);
  alert(jsonData.lemon.flavor);  // sour (in the case of the example JSON above)
}
```

