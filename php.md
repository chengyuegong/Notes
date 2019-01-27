# PHP

PHP is a programming language.  
This notes are based on [PHP Guide](https://classes.engineering.wustl.edu/cse330/index.php?title=PHP#PHP_Language_Components).

**Contents**
* [Variables](#variables)
* [Strings](#strings)
* [Arrays](#arrays)
* [Conditional Statements](#conditional-statements)
* [Loops](#loops)
* [Functions](#functions)
* [Object-Oriented Programming](#object-oriented-programming)

## Variables
All variables start with **$**. PHP is a weak-typed language.
```php
<?php
$i = 5;
$msg = "Hello World";
?>
```

## Strings
Be either single-quoted or double-quoted. Single-quoted strings are always taken literally; double-quoted strings allow for additional elements.
```php
<?php
$a = "Apple";
$b = "Banana";

$fruits_double = "$a\n$b"; # contains line break
$fruits_single = '$a\n$b'; # contains the string $a\n$b
?>
```

Concatenate multiple strings together using period.
```php
<?php
$c = "Cherry";
$g = "Grapefruit";

$fruits = $c."\n".$g;
?>
```

## Arrays
```php
<?php
$fruits = array("Apple", "Banana", "Cherry", "Grapefruit");
echo $fruits[1];   # Banana
echo count($fruits);   # 4
array_shift($fruits);   # remove the first element of the array
echo $fruits[1];   # Cherry
echo count($fruits);   # 3
?>
```

Associative arrays (Dictionaries): arrays whose keys are strings rather than numbers
```php
<?php
$fruits["a"] = "Apple";
$fruits["b"] = "Banana";
$fruits["c"] = "Cherry";
$fruits["g"] = "Grapefruit";

echo $fruits["c"];   # Cherry
$keys = array_keys($fruits);   # get an array containing indexed values of the fruits' keys
echo $keys[3];   # g
?>
```
## Conditional Statements
if - elseif
```php
<?php
$grade = 85;

if ($grade < 60) {
	echo "F";
} elseif ($grade < 70) {
	echo "D";
} elseif ($grade < 80) {
	echo "C";
} elseif ($grade < 90) {
	echo "B";
} else {
	echo "A";
}
?>
```

switch - case
```php
<?php
$food = "Apple";

switch ($food) {

case "Apple":
case "Banana":
case "Cherry":
case "Grapefruit":
	echo "You must like fruit!";
	break;
case "Broccoli":
case "Spinach":
	echo "You must like vegetables!";
	break;
default:
	echo "You don't like fruits or vegetables!";
	break;
}
?>
```

## Loops
for, while, foreach
```php
<?php
$mystring = "";
$i = 0;
while ($i < 5) {
	$mystring .= "Blah";
	$i++;
}
echo $mystring;   # displays BlahBlahBlahBlahBlah

$myarray = array("Apple", "Banana", "Cherry", "Grapefruit");
$mystring = "";
for($i=0; $i<count($myarray); $i++){
	$mystring .= $i.": ".$myarray[$i].", ";
}
echo $mystring;   # displays 0: Apple, 1: Banana, 2: Cherry, 3: Grapefruit

$mystring = "";
foreach($myarray as $key => $value){
	$mystring .= $key.": ".$value;
}
echo $mystring;   #displays 0: Apple, 1: Banana, 2: Cherry, 3: Grapefruit
?>
```

## Functions
```php
<?php
function add($x, $y) {
  return $x+$y;
}
echo add(3,5); # 8
?>
```

default parameter values
```php
<?php
function sayHello($name="John Doe") {
  return "Hello, $name... how do you do?";
}

echo sayHello("Todd"); # Hello, Todd... how do you do?
echo sayHello(); # Hello, John Doe... how do you do?
?>
```

## Object-Oriented Programming
* $this: refer to current instance
* $instance->property: access properties and methods from an instance
* ClassName::StaticPropertyOrMethods: access static properties and methods from a class
* $instance = new ClassName(): define the instance
```php
<?php
class Food {
	protected $name;
  
	function __construct($name){
		$this->name = $name;
	}
	
	static function getDefinition(){
		return "Food is nourishment for carbon-based lifeforms.";
	}
	
	function formatName(){
		return "Gotta love to eat " . $this->name;
	}
}

class Fruit extends Food {
	function formatName(){
		return Food::formatName() . " (fruit)";
	}
}

$fruit = new Fruit("Cherry");
echo $fruit->formatName() . "\n";   # Gotta love to eat Cherry (fruit)
echo Fruit::getDefinition() . "\n";   # Food is nourishment for carbon-based lifeforms.
?>
```
