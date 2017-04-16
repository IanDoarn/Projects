/**
 * Quiz
 * written by: Ian Doarn
 */
import java.util.Scanner;
import java.util.Random;
public class Quiz
{
    // Questions to be asked in the quiz
    public static String[][] questions = new String[][]{{
            "There are three types of repetition statements: the while loop, the do-while loop, and the ____ loop.",
            "The part of the loop that contains the statements to be repeated is called the loop ____.",
            "A one-time execution of a loop body is referred to as an _______ of the loop.",
            "An _____ loop is a loop statement that executes infinitely.",
            "In designing loops, you need to consider both the loop control ______ and the loop body.",
            "The ______ loop checks the loop-continuation-condition first. If the condition is true, " +
                    "the loop body is executed; if it is false, the loop terminates.",
            "The do-while loop is similar to the while loop, except that the do-while loop executes the loop body _____ and " +
                    "then checks the loop-continuation-condition to decide whether to continue or to terminate.",
            "The while loop and the do-while loop often are used when the number of repetitions is not ______.",
            "A ______ value is a special value that signifies the end of the loop.",
            "The for loop generally is used to execute a loop body a _____ number of times.",
            "The for loop control has three parts. The first part is an initial action that often ______ a control " +
                    "variable. The second part, the loop-continuation-condition, determines whether the loop body is to be executed. " +
                    "The third part is executed after each iteration and is often used to adjust the control variable. Usually, " +
                    "the loop control variables are initialized and changed in the control structure.",
            "The while loop and for loop are called ______ loops because the continuation condition is " +
                    "checked before the loop body is executed.",
            "The do-while loop is called a _____ loop because the condition is checked after the loop body is executed.",
            "Two keywords, break and _____, can be used in a loop.",
            "The _____ keyword immediately ends the innermost loop, which contains the break.",
            "The continue keyword only ____ the current iteration."
    },{
            "Making programs modular and reusable is one of the central goals in software engineering. " +
                    "Java provides many powerful constructs that help to achieve this goal. _____ are one such construct.",
            "The method _____ specifies the modifiers, return value type, method name, " +
                    "and parameters of the method.",
            "A method may return a value. The returnValueType is the data type of the value the method returns. " +
                    "If the method does not return a value, the returnValueType is the keyword _____.",
            "The parameter list refers to the type, order, and number of a method’s parameters. The method name and " +
                    "the parameter list together constitute the method ______. Parameters are optional; " +
                    "that is, a method doesn’t need to contain any parameters.",
            "A return statement can also be used in a void method for ______ the method and returning to the " +
                    "method’s caller. This is useful occasionally for circumventing the normal flow of control in a method.",
            "The ______ that are passed to a method should have the same number, type, and order as the parameters " +
                    "in the method signature.",
            "When a program ______ a method, program control is transferred to the called method. " +
                    "A called method returns control to the caller when its return statement is executed or when its method-ending " +
                    "closing brace is reached.",
            "A value-returning method can also be _____ as a statement in Java. In this case, the caller simply " +
                    "ignores the return value.",
            "A method can be ______. This means that two methods can have the same name, as long as their method " +
                    "parameter lists differ.",
            "A variable declared in a method is called a _____ variable. The scope of a local variable starts from its " +
                    "declaration and continues to the end of the block that contains the variable. " +
                    "A local variable must be declared and initialized before it is used.",
            "Method ______ is achieved by separating the use of a method from its implementation. The client " +
                    "can use a method without knowing how it is implemented. The details of the implementation are encapsulated" +
                    " in the method and hidden from the client who invokes the method. This is " +
                    "known as information hiding or encapsulation.",
            "Method abstraction modularizes programs in a neat, hierarchical manner. Programs written as ______ of " +
                    "concise methods are easier to write, debug, maintain, and modify than would otherwise be " +
                    "the case. This writing style also promotes method reusability.",
            "When ______ a large program, use the top-down and/or bottom-up coding approach. Do not write " +
                    "the entire program at once. This approach may seem to take more time for coding (because you are " +
                    "repeatedly compiling and running the program), but it actually saves time and makes debugging easier."
    },{
            "A variable is declared as an ____ type using the syntax elementType{} arrayRefVar or " +
                    "elementType arrayRefVar{}. The style elementType{} arrayRefVar is preferred, although " +
                    "elementType arrayRefVar{} is legal.",
            "Unlike declarations for primitive data type variables, the declaration of an array variable does not " +
                    "_____ any space in memory for the array. An array variable is not a primitive data type variable. " +
                    "An array variable contains a reference to an array.",
            "You cannot _____ elements to an array unless it has already been created. You can create an array " +
                    "by using the new operator with the following syntax: new elementType{arraySize}.",
            "Each _____ in the array is represented using the syntax arrayRefVar{index}. An index must be an " +
                    "integer or an integer expression.",
            "After an array is created, its _____ becomes permanent and can be obtained using arrayRefVar.length. " +
                    "Since the index of an array always begins with 0, the last index is always arrayRefVar.length - 1. " +
                    "An out-of-bounds error will occur if you attempt to reference elements beyond the bounds of an array.",
            "Programmers often mistakenly ______ the first element in an array with index 1, but it should be 0. " +
                    "This is called the index off-by-one error."
    },{
            "A _______ array can be used to store a table.",
            "A variable for two-dimensional arrays can be ______ using the syntax: elementType{}{} arrayVar.",
            "A two-dimensional array can be created using the ______: new elementType {ROW_SIZE}{COLUMN_SIZE}.",
            "Each element in a two-dimensional array is _______ using the syntax: arrayVar{rowIndex}{columnIndex}.",
            "You can _____ and initialize a two-dimensional array using an array initializer with the " +
                    "syntax: elementType{}{} arrayVar = {{row values}, . . . , {row values}}.",
            "You can use arrays of arrays to form ________ arrays. For example, a variable for " +
                    "three-dimensional arrays can be declared as elementType{}{}{} arrayVar, and a three-dimensional " +
                    "array can be created using new elementType{size1}{size2} {size3}."
    },{
            "A _____ is a template for objects. It defines the properties of objects and provides constructors for" +
                    " creating objects and methods for manipulating them.",
            "A class is also a data type. You can use it to _____ object reference variables. An object reference " +
                    "variable that appears to hold an object actually contains a reference to that object. Strictly speaking, " +
                    "an object reference variable and an object are different, but most of the time the distinction " +
                    "can be ignored.",
            "An object is an _______ of a class. You use the new operator to create an object, " +
                    "and the dot operator (.) to access members of that object through its reference variable.",
            "An instance variable or method belongs to an instance of a class. Its use is associated with individual " +
                    "instances. A ______ variable is a variable shared by all instances of the same class. " +
                    "A static method is a method that can be invoked without using instances.",
            "Every instance of a class can access the class’s static variables and methods. " +
                    "For clarity, however, it is better to ______ static variables and methods using " +
                    "ClassName.variable and ClassName.method.",
            "Visibility modifiers specify how the class, method, and data are accessed. A ______ class, method, or " +
                    "data is accessible to all clients. A private method or data is accessible only inside the class.",
            "You can provide a getter (______) method or a setter (mutator) " +
                    "method to enable clients to see or modify the data.",
            "A getter method has the signature public returnType getPropertyName(). If the returnType is " +
                    "boolean, the get method should be defined as public boolean isPropertyName(). " +
                    "A _____ method has the signature public void setPropertyName(dataType propertyValue).",
            "All parameters are passed to methods using ______. For a parameter of a primitive type, " +
                    "the actual value is passed; for a parameter of a reference type, the reference for the object is passed.",
            "A Java array is an object that can contain primitive type values or object type values. " +
                    "When an array of objects is created, its elements are assigned the default value of _____.",
            "Once it is created, an immutable object _____ be modified. To prevent users from modifying " +
                    "an object, you can define immutable classes.",
            "The _____ of instance and static variables is the entire class, regardless of where the variables are declared. " +
                    "Instance and static variables can be declared anywhere in the class. " +
                    "For consistency, they are declared at the beginning of the class in this book.",
            "The keyword this can be used to refer to the calling object. It can also be used inside a " +
                    "______ to invoke another constructor of the same class."
    }};

    // Answers to the questions
    public static String[][] answers = new String[][]{{"for", "body", "iteration", "infinite", "structure", "while",
            "first", "predetermined", "sentinel", "fixed", "initializes", "pretest", "posttest",
            "continue", "break", "ends"},
            {"Methods", "header", "void", "signature", "terminating", "arguments",
                    "calls", "invoked", "overloaded", "local", "abstraction", "collections", "implementing"},
            {"array", "allocate", "assign", "element", "size", "reference"},
            {"two-dimensional", "declared", "syntax", "represented", "create", "multidimensional"},
            {"class", "declare", "instance", "static", "invoke", "public",
                    "accessor", "setter", "pass-by-value", "null", "cannot", "scope", "constructor"}};

    private static Random rand = new Random();
    private static Scanner input = new Scanner(System.in);

    private static int NUMBER_OF_QUIZ_QUESTIONS = 5;

    public static void main(String[] args)
    {
        giveQuiz(NUMBER_OF_QUIZ_QUESTIONS);
    }
    private static int randomInt(int min, int max)
    {
        return rand.nextInt((max - min) + 1) + min;
    }

    private static int[] getQuestion()
    {
        int chapter = randomInt(0, questions.length);
        int quesiton = randomInt(0, questions[chapter].length);
        int[] questionData = new int[] {chapter, quesiton};
        return questionData;
    }

    private static String[] getAnswer(int chapterIndex, int questionIndex)
    {
        String question = questions[chapterIndex][questionIndex];
        String answer = answers[chapterIndex][questionIndex];
        String[] questionAndAnswer = new String[] {question, answer};
        return questionAndAnswer;
    }

    private static int score(int numCorrect, int numWrong, int totalQuestions)
    {
        if(numCorrect != 0)
        {
            if(numWrong != 0)
            {
                return (int)(numCorrect / totalQuestions) * 101;
            }
            return 100;
        }
        return 0;
    }

    private static void giveQuiz(int numOfQuestions)
    {
        int correct = 0;
        int wrong = 0;
        int total = 0;

        for (int i = 0; i < numOfQuestions; i++)
        {
            int[] data = getQuestion();
            String[] questionData = getAnswer(data[0], data[1]);

            String question = questionData[0];
            String answer = questionData[1];

            total += 1;

            System.out.println(question);
            System.out.print("Your answer?");
            String userAnswer = input.next();
            input.next();

            if (userAnswer.toLowerCase() == answer)
            {
                correct += 1;
                System.out.println("Correct!");
                System.out.println("Current score: " + correct + " / " + total + " = " + score(correct, wrong, total) + "%");
            }
            else
            {
                wrong += 1;
                System.out.println("Not Quite!");
                System.out.println("The correct answer is:" + answer);
                System.out.println("Please see chapter " + questionData[0] + ", item " + questionData[1]);
                System.out.println("Current score: " + correct + " / " + total + " = " + score(correct, wrong, total) + "%");
            }
        }

        System.out.print("Would you like to take another quiz? (y/n):");
        String ans = input.next();

        if (ans.toLowerCase() == "y")
        {
            giveQuiz(numOfQuestions);
        }
    }
}
