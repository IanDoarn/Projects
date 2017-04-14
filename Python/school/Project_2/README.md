# COMP1900 Project 2
- Name: Ian Doarn
- Instructor: Bob Bagget
- Due: 4/23/2017
- Language: Python

_This is suppose to be in Java, but I wrote it in python first, then java_

## About
The goal of this project is to use the chapter summary items from chapters 5, 6, 7, 8, and 9 to 
create a program which presents interactive fill-in-the-blank quizzes.  
ach quiz should consist of five fill-in-the-blank questions derived from chapter 
summary items: one summary item selected at random from each of the five listed chapters.  
Feedback should be given after each question indicating: whether or not the user’s answer was correct, 
the correct answer (if user’s answer was wrong), the chapter number and item 
number used to make the question, and the student’s current score as both a fraction and a percentage.  
Please see the sample output at the end of this document!

#### Chapter 5

1. There are three types of repetition statements: the while loop, the do-while loop, and
the for loop.
2. The part of the loop that contains the statements to be repeated is called the loop body.
3. A one-time execution of a loop body is referred to as an iteration of the loop.
4. An infinite loop is a loop statement that executes infinitely.
5. In designing loops, you need to consider both the loop control structure and the loop
body.
6. The while loop checks the loop-continuation-condition first. If the condition
is true, the loop body is executed; if it is false, the loop terminates.
7. The do-while loop is similar to the while loop, except that the do-while loop executes
the loop body first and then checks the loop-continuation-condition to
decide whether to continue or to terminate.
8. The while loop and the do-while loop often are used when the number of repetitions
is not predetermined.
9. A sentinel value is a special value that signifies the end of the loop.
10. The for loop generally is used to execute a loop body a fixed number of times.
11. The for loop control has three parts. The first part is an initial action that often initializes
a control variable. The second part, the loop-continuation-condition,
determines whether the loop body is to be executed. The third part is executed after
each iteration and is often used to adjust the control variable. Usually, the loop control
variables are initialized and changed in the control structure.
12. The while loop and for loop are called pretest loops because the continuation condition
is checked before the loop body is executed.
13. The do-while loop is called a posttest loop because the condition is checked after the
loop body is executed.
14. Two keywords, break and continue, can be used in a loop.
15. The break keyword immediately ends the innermost loop, which contains the break.
16. The continue keyword only ends the current iteration.

#### Chapter 6

1. Making programs modular and reusable is one of the central goals in software engineering.
Java provides many powerful constructs that help to achieve this goal. Methods are
one such construct.
2. The method header specifies the modifiers, return value type, method name, and parameters
of the method. The static modifier is used for all the methods in this chapter.
3. A method may return a value. The returnValueType is the data type of the value the
method returns. If the method does not return a value, the returnValueType is the
keyword void.
4. The parameter list refers to the type, order, and number of a method’s parameters. The
method name and the parameter list together constitute the method signature. Parameters
are optional; that is, a method doesn’t need to contain any parameters.
5. A return statement can also be used in a void method for terminating the method and
returning to the method’s caller. This is useful occasionally for circumventing the normal
flow of control in a method.
6. The arguments that are passed to a method should have the same number, type, and
order as the parameters in the method signature.
7. When a program calls a method, program control is transferred to the called method. A
called method returns control to the caller when its return statement is executed or when
its method-ending closing brace is reached.
8. A value-returning method can also be invoked as a statement in Java. In this case, the
caller simply ignores the return value.
9. A method can be overloaded. This means that two methods can have the same name, as
long as their method parameter lists differ.
10. A variable declared in a method is called a local variable. The scope of a local variable
starts from its declaration and continues to the end of the block that contains the variable.
A local variable must be declared and initialized before it is used.
11. Method abstraction is achieved by separating the use of a method from its implementation.
The client can use a method without knowing how it is implemented. The details
of the implementation are encapsulated in the method and hidden from the client who
invokes the method. This is known as information hiding or encapsulation.
12. Method abstraction modularizes programs in a neat, hierarchical manner. Programs
written as collections of concise methods are easier to write, debug, maintain, and
modify than would otherwise be the case. This writing style also promotes method
reusability.
13. When implementing a large program, use the top-down and/or bottom-up coding
approach. Do not write the entire program at once. This approach may seem to take
more time for coding (because you are repeatedly compiling and running the program),
but it actually saves time and makes debugging easier.

#### Chapter 7

1. A variable is declared as an array type using the syntax elementType[] arrayRefVar
or elementType arrayRefVar[]. The style elementType[] arrayRefVar is
preferred, although elementType arrayRefVar[] is legal.
2. Unlike declarations for primitive data type variables, the declaration of an array variable
does not allocate any space in memory for the array. An array variable is not a primitive
data type variable. An array variable contains a reference to an array.
3. You cannot assign elements to an array unless it has already been created. You
can create an array by using the new operator with the following syntax: new
elementType[arraySize].
4. Each element in the array is represented using the syntax arrayRefVar[index]. An
index must be an integer or an integer expression.
5. After an array is created, its size becomes permanent and can be obtained using
arrayRefVar.length. Since the index of an array always begins with 0, the last
index is always arrayRefVar.length - 1. An out-of-bounds error will occur if you
attempt to reference elements beyond the bounds of an array.
6. Programmers often mistakenly reference the first element in an array with index 1, but
it should be 0. This is called the index off-by-one error.

#### Chapter 8

1. A two-dimensional array can be used to store a table.
2. A variable for two-dimensional arrays can be declared using the syntax:
elementType[][] arrayVar.
3. A two-dimensional array can be created using the syntax: new elementType
[ROW_SIZE][COLUMN_SIZE].
4. Each element in a two-dimensional array is represented using the syntax:
arrayVar[rowIndex][columnIndex].
5. You can create and initialize a two-dimensional array using an array initializer with the
syntax: elementType[][] arrayVar = {{row values}, . . . , {row values}}.
6. You can use arrays of arrays to form multidimensional arrays. For example, a variable
for three-dimensional arrays can be declared as elementType[][][] arrayVar, and
a three-dimensional array can be created using new elementType[size1][size2]
[size3].

#### Chapter 9

1. A class is a template for objects. It defines the properties of objects and provides
constructors for creating objects and methods for manipulating them.
2. A class is also a data type. You can use it to declare object reference variables. An
object reference variable that appears to hold an object actually contains a reference to
that object. Strictly speaking, an object reference variable and an object are different,
but most of the time the distinction can be ignored.
3. An object is an instance of a class. You use the new operator to create an object, and the
dot operator (.) to access members of that object through its reference variable.
4. An instance variable or method belongs to an instance of a class. Its use is associated
with individual instances. A static variable is a variable shared by all instances of the
same class. A static method is a method that can be invoked without using instances.
5. Every instance of a class can access the class’s static variables and methods. For clarity,
however, it is better to invoke static variables and methods using ClassName.variable
and ClassName.method.
6. Visibility modifiers specify how the class, method, and data are accessed. A public
class, method, or data is accessible to all clients. A private method or data is accessible
only inside the class.
7. You can provide a getter (accessor) method or a setter (mutator) method to enable
clients to see or modify the data.
8. A getter method has the signature public returnType getPropertyName().
If the returnType is boolean, the get method should be defined as public
boolean isPropertyName(). A setter method has the signature public void
setPropertyName(dataType propertyValue).
9. All parameters are passed to methods using pass-by-value. For a parameter of a primitive
type, the actual value is passed; for a parameter of a reference type, the reference
for the object is passed.
10. A Java array is an object that can contain primitive type values or object type values.
When an array of objects is created, its elements are assigned the default value of null.
11. Once it is created, an immutable object cannot be modified. To prevent users from
modifying an object, you can define immutable classes.
12. The scope of instance and static variables is the entire class, regardless of where the
variables are declared. Instance and static variables can be declared anywhere in the
class. For consistency, they are declared at the beginning of the class in this book.
13. The keyword this can be used to refer to the calling object. It can also be used inside
a constructor to invoke another constructor of the same class.