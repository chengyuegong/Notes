# HTML & CSS
The notes are based on [CSE330 Wiki@WashU](https://classes.engineering.wustl.edu/cse330/index.php?title=HTML_and_CSS).  
Validator: [HTML validator](https://validator.w3.org/), [CSS validator](https://jigsaw.w3.org/css-validator/)  
Tutorial from w3schools: [HTML](https://www.w3schools.com/html/), [CSS](https://www.w3schools.com/Css/)

**Contents**
* [HTML](#html)
* [CSS](#css)
* [Using HTML and CSS](#using-html-and-css)

# HTML
HTML (HyperText Markup Language) defines the content of a web page.  

Basic structure of a web page
```html
<!DOCTYPE html>
<html>
<head>
	<title>My First Web Page</title>
</head>
<body>
	<p>Hello World!</p>
</body>
</html>
```

## Commonly Used Tags
Check [Tag Reference](https://www.w3schools.com/tags/) for all tags

### Semantic Elements
- **&lt;header&gt;**: defines header section
- **&lt;footer&gt;**: defines footer section
- **&lt;nav&gt;**: defines the section contains navigation links
- **&lt;article&gt;**: defines an article
- **&lt;section&gt;**: defines a real section
- **&lt;figure&gt;**: defines a figure
	- **&lt;figcaption&gt;**: defines a caption for that figure (should be nested inside of &lt;figure&gt;)
- **&lt;form&gt;**: defines a [form](#html-forms)

### External Media
- **&lt;iframe src="source"&gt;**:defines a little window where _source_ is loaded
- **&lt;link rel="what" type="mime" href="source"&gt;**:defines a external document _what_ located at _source_ with the mime type _mime_
- **&lt;img src="source" alt="text"&gt;**: defines a image located at _source_ the has an alternative text _text_
- **&lt;audio&gt;**: defines a audio clip
- **&lt;video&gt;**: defines a video clip
- **&lt;canvas&gt;**: defines a canvas for advanced drawing

### Outlining Elements
- **&lt;h1&gt; to &lt;h6&gt;**: defines the outline
- **&lt;p&gt;**: defines a paragraph
- **&lt;dl&gt;**: defines a dictionary list
	- **&lt;dt&gt;**: defines a dictionary term
	- **&lt;dd&gt;**: defines a dictionary definition
- **&lt;table&gt;**: defines a table
	- **&lt;thead&gt;, &lt;tbody&gt;, &lt;tfoot&gt;**: defines the heading, body content, and footing of a table
	- **&lt;tr&gt;**: defines a table row
		- **&lt;th&gt;**: defines a table cell containing a heading
		- **&lt;td&gt;**: defines a table cell containing data
- **&lt;ol&gt; and &lt;ul&gt;**: defines an ordered and an unordered list
	- **&lt;li&gt;**: defines a list item
- **&lt;q&gt;**: defines a short, inline quoted text
- **&lt;blackquote&gt;**: defines a block of text quoted text

### Miscellaneous Elements
- **&lt;a href="destination"&gt;**: defines a hyperlink to _destionation_
- **&lt;br /&gt;**: defines a line break
- **&lt;button&gt;**: defines a clickable button
- **&lt;code&gt;**: defines a piece of code
- **&lt;output&gt;**: defines the result of a calculation
- **&lt;pre&gt;**: defines pre-formatted text in which whitespace will be preserved
- **&lt;script&gt;**: defines a script
- **&lt;div&gt;**: defines a blcok section (useful for styling)
- **&lt;span&gt;**: defines an inline section (useful for styling)

## HTML Forms
**Examples**
```
<form action="http://www.google.com/search" method="GET">
	<label>Search Query: <input type="text" name="q" /></label>
	<input type="submit" value="Search" />
</form>
```

### HTTP Request Methods
1. **GET** transfers the variables in the URL
2. **POST** transfers the variables as an HTTP header

When to use GET vs. POST
- Need to bookmark the destination page: GET
- Transmit sensitive information: POST
- Transmit large dataL: POST
- Modify something in a database: POST

### Input Types
- **text**
- **submit**
- **hidden**: allows for a variable to be passed, but user don't have to input any data
- **password**: allows for text to be hidden while typed
- **number**: forces the content to be numerical
	- The **step**, **min**, **max** can be set: ```<input type="number" name="percentage" step="1" min="0" max="100" />```
- **checkbox**: yes or no
- **radio**: multiple choice
- **file**: allows for file uploads


# CSS
CSS (Cascading Style Sheet) defines the appearance of a web page.

## Selectors
- **foo**: selects an element with tag name _foo_
- **.foo**: selects an element with class name _foo_
- **#foo**: selects an element with ID _foo_
- **[foo="bar]**: selects an element with the attribute _foo_ whose value is _bar_
- **foo bar**: selects an element matching _bar_ that is a descendant of an element matching _foo_
- **foo > bar**: selects an element matching _bar_ that is a child of an element matching _foo_
- **foo + bar**: selects an element matching _bar_ that is the next sibling of an element matching _foo_

## Pseudo-Classes
- **foo:first-child**: selects an element matching _foo_ that is the first child of its parent
- **foo:last-child**: selects an element matching _foo_ that is the last child of its parent
- **foo:empty**: selects an element matching _foo_ that has no children
- for Form elements
	- **input:checked**: selects all checkboxes and radio buttopns that are checked
- for Hyperlink elements
	- **a:link**: selects all hyperlinks that have not been visited yet
	- **a:checked**: selects all hyperlinks that have been visited
- for Interactive elements (like buttons, hyperlinks, etc)
	- **foo:active**: selects all elements matching _foo_ that are being pressed on
	- **foo:hover**: selects all elements matching _foo_ that are being hovered over
	- **foo:focus**: selects all elements matching _foo_ that are selected

## Properties
- **background-image**: defines the background image of an element
- **background-color**: defines the background color of an element (will be displayed if the image can't be found)
- **border**: defines the border around an element
- **border-radius**: defines the rounded corner of an element
- **float**: defines the flow
- **cursor**: defines the type of cursor that apppears when the element is in focus
- **font**: defines the font-size, line-height, and font-family
- **list-style-type**: defines both ordered and unordered lists
- **text-align**: defines algnment of the text (left, right, center)
- **display**: defines the display mode (inline, block, none) (none means stop being displayed)

## Units
- **px**: defines a distance in pixels (relative to resolution)
- **em**: defines a distance raltive to font size
- **rem**: defines a distance raltive to font size of the root element
- **pt**: defines a distance equal to 1/72 of an inch (regardless of resolution)
- **%**: defines a distance relative to that property of its parent element

## The Box Model
- Inline
- Block (margin, border, padding, content)

# Using HTML and CSS
CSS should be included in the &lt;head&gt; tag

## How to include CSS
1. Loading external stylesheet (preferred)
```html
<head>
	<link rel="stylesheet" type="text/css" href="path/to/stylesheet.css" />
</head>
```
2. Embedding stylesheet in the document
```html
<head>
<style type="text/css">
	selectors {
		property: value;
	}
	</style>
</head>
```
3. Inline style (should be avoided)
```html
<body>
	<p style="color:red;"> not good </p>
</body>
```
