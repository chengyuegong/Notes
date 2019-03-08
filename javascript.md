# JavaScript
JavaScript is the most widely used scripting language for both client-side and server-side applications. 
The notes are based on [JavaScript](https://classes.engineering.wustl.edu/cse330/index.php?title=JavaScript).  

**Contents**
* [Components](#components)
* [Events](#events)
* [Document Object Model](#document-object-model)


## Components

### Variables and Scope
Define a variable: **let**
```js
let foo = "bar";
```

Define a constant: **const**
```js
const foo = "bar";
```

Scope: When you reference a variable, JavaScript will look up through the "function tree" until it finds the variable you asked for.


### Object Literals
```js
const apple = {
	color: "red",
	flavor: "sweet",
	season: "autumn"
}
alert(apple.color);  // red
```

### Functions
Define a function: **function**
```js
function sayHello(){
	alert("Hello World");
}
sayHello(); // call the function
```

Pass an argument:
```js
function sayHello(name){
	alert("Hello, "+name);
}
sayHello("Todd"); // call the function and pass an argument
```

### Arrow Functions
General syntax:
```js
(param1, param2, ... , paramN) => { statements }

//removing the brackets around { statements } is equivalent to
{ return statements; }

//No parameters should be 2 empty parentheses as such: 
() => { statements }
```

Example:
```js
const sayHello = (name) => alert("Hello, "+name);
sayHello("Todd");
```

```js
let arr = [1,2,3,4,5];
let newArr = arr.map(number => number*5); //newArr is an array containing [5,10,15,20,25]
```

### Functions are Objects
```js
const sayHello = function(){
	alert("Hello World");
}
sayHello(); // call the function
```

### Closures
A closure is a way to separate a certain snippet of JavaScript code from the global scope.
```js
const a = "hello";

(function(){
	const b = "world";
	
	alert(a); // hello
	alert(b); // world
})();

alert(a); // hello
alert(b); // ReferenceError: b is not defined
```

### Prototypal Inheritance
```js
String.prototype.bang = function(){
	return this+"!"; // Notice: the context is the instance itself
}

alert("Hello".bang()); // alerts Hello!
```

### Context
To call a function on an arbitrary context, use either call or apply. call takes a list of arguments, while apply takes them all in an array.
```js
const sayThisColor = function(){
	alert(this.color);
}

const apple = { color: "red" }

sayThisColor();   // undefined
sayThisColor.call(apple); // red
```

## Events
JavaScript code runs in a single thread -> no concurrency issues
```js
const sayHello = function(){
	alert("Hello World");
}

document.getElementById("hello").addEventListener("click", sayHello, false);
```
The addEventListener method takes three parameters: event type, callback function, A boolean representing bubble (false) or capture (true) phase
Anonymous callback function
```js
document.getElementById("hello").addEventListener("click", function(event){
	alert(`Hello, World!  Event Type: ${event.type}`);
}, false);
```

### Event Object
event.target, event.currentTarget, event.preventDefault(), event.stopPropagation()

### Event Phase
Capture phase and Bubble phase
```js
const disableToolbarFunc = function(e){
	e.stopPropogation();
}

// To disable toolbar:
document.getElementById("box").addEventListener("click", disableToolbarFunc, true);

// To re-enable toolbar:
document.getElementById("box").removeEventListener("click", disableToolbarFunc, true);
```

## Document Object Model
DOM
### Nodes and Traversing the DOM
```html
<ul id="my-list">
	<li class="fruits">Apples</li>
	<li class="citrus">Oranges and <strong>Lemons</strong></li>
	<li class="berries">Cherries</li>
</ul>
```
```js
e = document.getElementById("my-list").getElementsByClassName("citrus")[0].lastChild.nodeName;
alert(e); // strong
```
Commom methods:
* Node.parentNode
* Node.childNodes - returns an array of nodes
* Node.firstChild - same as Node.childNodes[0]
* Node.lastChild - same as Node.childNodes[Node.childNodes.length-1]
* Node.previousSibling
* Node.nextSibling
* Node.getElementsByTagName("tag-name") - returns an array of element nodes having the tag name **tag-name** that are descendants of Node
* Node.getElementById("id") - returns a single node having the ID **id** that is a descendant of Node
* Node.getElementsByName("what-name") - returns an array of element nodes having their name attribute set to **what-name**.
* Node.getElementsByClassName("class") - returns an array of nodes having the class class

### Creating, Moving, and Removing Nodes
Consider the html as above.
Add another element to the list:
```js
const newLi = document.createElement("li");  // creates a node with the tag name li
newLi.appendChild(document.createTextNode("Broccoli"));
newLi.setAttribute("class", "veggies");
document.getElementById("my-list").appendChild(newLi);
```
Remove an element from the list:
```js
const apple = document.getElementById("my-list").getElementsByClassName("fruits")[0];
document.getElementById("my-list").removeChild(apple);
```
Move an element to the end of the list:
```js
const apple = document.getElementById("my-list").getElementsByClassName("fruits")[0];
document.getElementById("my-list").appendChild(apple);
```
Methods:
* Node.append(otherNode) - removes otherNode from its current location in the DOM (if applicable) and then adds it as the last child of Node
* Node.removeChild(otherNode) - removes otherNode, a child of Node, from the DOM
* document.createElement("tag-name") - create a new node with the tag name "tag-name"
* document.createTextNode("text") - create a node containing only the string "text"
* Node.setAttribute("attribute", "value") - sets the attribute node of name "attribute" to "value"

### DOM Shortcuts
textContent
```js
document.getElementById("holder").textContent = "Hello World";
document.getElementById("holder").textContent += " -  Later, he said Hello World  - ";
```
innerHTML
```js
document.getElementById("holder").innerHTML += "<p>Hello World</p>";
```

