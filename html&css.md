# HTML
HTML (HyperText Markup Language) defines the content of a web page.  
The notes are based on [CSE330 Wiki@WashU](https://classes.engineering.wustl.edu/cse330/index.php?title=HTML_and_CSS).

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
### Semantic Elements
**&lt;header&gt;**: defines header section  
**&lt;footer&gt;**: defines footer section  
**&lt;nav&gt;**: defines the section contains navigation links  
**&lt;article&gt;**: defines an article  
**&lt;section&gt;**: defines a real section  
**&lt;figure&gt;**: defines a figure  
&ensp;&ensp;**&lt;figcaption&gt;**: defines a caption for that figure (should be nested inside of &lt;figure&gt;)  
**&lt;form&gt;**: defines a [form](#html-forms)

### External Media
**&lt;iframe src="source"&gt;**:defines a little window where _source_ is loaded  
**&lt;link rel="what" type="mime" href="source"&gt;**:defines a external document _what_ located at _source_ with the mime type _mime_  
**&lt;img src="source" alt="text"&gt;**: defines a image located at _source_ the has an alternative text _text_
**&lt;audio&gt;**: defines a audio clip  
**&lt;video&gt;**: defines a video clip  
**&lt;canvas&gt;**: defines a canvas for advanced drawing  

### Outlining Elements
**&lt;h1&gt; to &lt;h6&gt;**: defines the outline  
**&lt;p&gt;**: defines a paragraph  
**&lt;dl&gt;**: defines a dictionary list  
&ensp;&ensp;**&lt;dt&gt;**: defines a dictionary term  
&ensp;&ensp;**&lt;dd&gt;**: defines a dictionary definition  
**&lt;table&gt;**: defines a table  
&ensp;&ensp;**&lt;thead&gt;, &lt;tbody&gt;, &lt;tfoot&gt;**: defines the heading, body content, and footing of a table  
&ensp;&ensp;**&lt;tr&gt;**: defines a table row  
&ensp;&ensp;**&lt;th&gt;**: defines a table cell containing a heading  
&ensp;&ensp;**&lt;td&gt;**: defines a table cell containing data  
**&lt;ol&gt; and &lt;ul&gt;**: defines an ordered and an unordered list  
&ensp;&ensp;**&lt;li&gt;**: defines a list item  
**&lt;q&gt;**: defines a short, inline quoted text  
**&lt;blackquote&gt;**: defines a block of text quoted text

### Miscellaneous Elements
**&lt;a href="destination"&gt;**: defines a hyperlink to _destionation_  
**&lt;br /&gt;**: defines a line break  
**&lt;button&gt;**: defines a clickable button  
**&lt;code&gt;**: defines a piece of code  
**&lt;output&gt;**: defines the result of a calculation  
**&lt;pre&gt;**: defines pre-formatted text in which whitespace will be preserved  
**&lt;script&gt;**: defines a script  
**&lt;div&gt;**: defines a blcok section (useful for styling)  
**&lt;span&gt;**: defines an inline section (useful for styling)  

## HTML Forms

# CSS
