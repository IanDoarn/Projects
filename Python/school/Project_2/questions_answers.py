import random
import sys


questions = [
             [
              'There are three types of repetition statements: the while loop, the do-while loop, and the ____ loop.',
              'The part of the loop that contains the statements to be repeated is called the loop ____.',
              'A one-time execution of a loop body is referred to as an _______ of the loop.',
              'An _____ loop is a loop statement that executes infinitely.',
              'In designing loops, you need to consider both the loop control ______ and the loop body.',
              'The ______ loop checks the loop-continuation-condition first. If the condition is true, '
              'the loop body is executed; if it is false, the loop terminates.',
              'The do-while loop is similar to the while loop, except that the do-while loop executes the loop body _____ and '
              'then checks the loop-continuation-condition to decide whether to continue or to terminate.',
              'The while loop and the do-while loop often are used when the number of repetitions is not ______.',
              'A ______ value is a special value that signifies the end of the loop.',
              'The for loop generally is used to execute a loop body a _____ number of times.',
              'The for loop control has three parts. The first part is an initial action that often ______ a control '
              'variable. The second part, the loop-continuation-condition, determines whether the loop body is to be executed. '
              'The third part is executed after each iteration and is often used to adjust the control variable. Usually, '
              'the loop control variables are initialized and changed in the control structure.',
              'The while loop and for loop are called ______ loops because the continuation condition is '
              'checked before the loop body is executed.',
              'The do-while loop is called a _____ loop because the condition is checked after the loop body is executed.',
              'Two keywords, break and _____, can be used in a loop.',
              'The _____ keyword immediately ends the innermost loop, which contains the break.',
              'The continue keyword only ____ the current iteration.'
              ],
             [
              'Making programs modular and reusable is one of the central goals in software engineering. '
              'Java provides many powerful constructs that help to achieve this goal. _____ are one such construct.',
              'The method _____ specifies the modifiers, return value type, method name, '
              'and parameters of the method.',
              'A method may return a value. The returnValueType is the data type of the value the method returns. '
              'If the method does not return a value, the returnValueType is the keyword _____.',
              'The parameter list refers to the type, order, and number of a method’s parameters. The method name and '
              'the parameter list together constitute the method ______. Parameters are optional; '
              'that is, a method doesn’t need to contain any parameters.',
              'A return statement can also be used in a void method for ______ the method and returning to the '
              'method’s caller. This is useful occasionally for circumventing the normal flow of control in a method.',
              'The ______ that are passed to a method should have the same number, type, and order as the parameters '
              'in the method signature.',
              'When a program ______ a method, program control is transferred to the called method. '
              'A called method returns control to the caller when its return statement is executed or when its method-ending '
              'closing brace is reached.',
              'A value-returning method can also be _____ as a statement in Java. In this case, the caller simply '
              'ignores the return value.',
              'A method can be ______. This means that two methods can have the same name, as long as their method '
              'parameter lists differ.',
              'A variable declared in a method is called a _____ variable. The scope of a local variable starts from its '
              'declaration and continues to the end of the block that contains the variable. '
              'A local variable must be declared and initialized before it is used.',
              'Method ______ is achieved by separating the use of a method from its implementation. The client '
              'can use a method without knowing how it is implemented. The details of the implementation are encapsulated'
              ' in the method and hidden from the client who invokes the method. This is '
              'known as information hiding or encapsulation.',
              'Method abstraction modularizes programs in a neat, hierarchical manner. Programs written as ______ of '
              'concise methods are easier to write, debug, maintain, and modify than would otherwise be '
              'the case. This writing style also promotes method reusability.',
              'When ______ a large program, use the top-down and/or bottom-up coding approach. Do not write '
              'the entire program at once. This approach may seem to take more time for coding (because you are '
              'repeatedly compiling and running the program), but it actually saves time and makes debugging easier.'
              ],
             [
              'A variable is declared as an ____ type using the syntax elementType[] arrayRefVar or '
              'elementType arrayRefVar[]. The style elementType[] arrayRefVar is preferred, although '
              'elementType arrayRefVar[] is legal.',
              'Unlike declarations for primitive data type variables, the declaration of an array variable does not '
              '_____ any space in memory for the array. An array variable is not a primitive data type variable. '
              'An array variable contains a reference to an array.',
              'You cannot _____ elements to an array unless it has already been created. You can create an array '
              'by using the new operator with the following syntax: new elementType[arraySize].',
              'Each _____ in the array is represented using the syntax arrayRefVar[index]. An index must be an '
              'integer or an integer expression.',
              'After an array is created, its _____ becomes permanent and can be obtained using arrayRefVar.length. '
              'Since the index of an array always begins with 0, the last index is always arrayRefVar.length - 1. '
              'An out-of-bounds error will occur if you attempt to reference elements beyond the bounds of an array.',
              'Programmers often mistakenly ______ the first element in an array with index 1, but it should be 0. '
              'This is called the index off-by-one error.'
              ],
             [
              'A _______ array can be used to store a table.',
              'A variable for two-dimensional arrays can be ______ using the syntax: elementType[][] arrayVar.',
              'A two-dimensional array can be created using the ______: new elementType [ROW_SIZE][COLUMN_SIZE].',
              'Each element in a two-dimensional array is _______ using the syntax: arrayVar[rowIndex][columnIndex].',
              'You can _____ and initialize a two-dimensional array using an array initializer with the '
              'syntax: elementType[][] arrayVar = {{row values}, . . . , {row values}}.',
              'You can use arrays of arrays to form ________ arrays. For example, a variable for '
              'three-dimensional arrays can be declared as elementType[][][] arrayVar, and a three-dimensional '
              'array can be created using new elementType[size1][size2] [size3].'
              ],
             [
              'A _____ is a template for objects. It defines the properties of objects and provides constructors for'
              ' creating objects and methods for manipulating them.',
              'A class is also a data type. You can use it to _____ object reference variables. An object reference '
              'variable that appears to hold an object actually contains a reference to that object. Strictly speaking, '
              'an object reference variable and an object are different, but most of the time the distinction '
              'can be ignored.',
              'An object is an _______ of a class. You use the new operator to create an object, '
              'and the dot operator (.) to access members of that object through its reference variable.',
              'An instance variable or method belongs to an instance of a class. Its use is associated with individual '
              'instances. A ______ variable is a variable shared by all instances of the same class. '
              'A static method is a method that can be invoked without using instances.',
              'Every instance of a class can access the class’s static variables and methods. '
              'For clarity, however, it is better to ______ static variables and methods using '
              'ClassName.variable and ClassName.method.',
              'Visibility modifiers specify how the class, method, and data are accessed. A ______ class, method, or '
              'data is accessible to all clients. A private method or data is accessible only inside the class.',
              'You can provide a getter (______) method or a setter (mutator) '
              'method to enable clients to see or modify the data.',
              'A getter method has the signature public returnType getPropertyName(). If the returnType is '
              'boolean, the get method should be defined as public boolean isPropertyName(). '
              'A _____ method has the signature public void setPropertyName(dataType propertyValue).',
              'All parameters are passed to methods using ______. For a parameter of a primitive type, '
              'the actual value is passed; for a parameter of a reference type, the reference for the object is passed.',
              'A Java array is an object that can contain primitive type values or object type values. '
              'When an array of objects is created, its elements are assigned the default value of _____.',
              'Once it is created, an immutable object _____ be modified. To prevent users from modifying '
              'an object, you can define immutable classes.',
              'The _____ of instance and static variables is the entire class, regardless of where the variables are declared. '
              'Instance and static variables can be declared anywhere in the class. '
              'For consistency, they are declared at the beginning of the class in this book.',
              'The keyword this can be used to refer to the calling object. It can also be used inside a '
              '______ to invoke another constructor of the same class.'
              ]
             ]

answers = [['for', 'body', 'iteration', 'infinite', 'structure', 'while',
            'first', 'predetermined', 'sentinel', 'fixed', 'initializes', 'pretest', 'posttest',
            'continue', 'break', 'ends'],
           ['Methods', 'header', 'void', 'signature', 'terminating', 'arguments',
            'calls', 'invoked', 'overloaded', 'local', 'abstraction', 'collections', 'implementing'],
           ['array', 'allocate', 'assign', 'element', 'size', 'reference'],
           ['two-dimensional', 'declared', 'syntax', 'represented', 'create', 'multidimensional'],
           ['class', 'declare', 'instance', 'static', 'invoke', 'public',
            'accessor', 'setter', 'pass-by-value', 'null', 'cannot', 'scope', 'constructor']]

questions_asked = []
quizzes = []

def get_question():
    chapter_index = random.randrange(len(questions))
    question_index = random.randrange(len(questions[chapter_index]))
    chapter_number = chapter_index + 5
    question = questions[chapter_index][question_index]
    data = [question, chapter_index, question_index, chapter_number]
    questions_asked.append(question)

    if question in questions_asked:
        return data
    else:
        get_question()

def get_answer(chapter_index, question_index):
    return answers[chapter_index][question_index]

def score(num_correct, num_wrong, total):
    if num_correct is not 0:
        if num_wrong is not 0:
            return int((num_correct / total) * 101)
        else:
            return 100
    else:
        return  0

def give_quiz(question_count=5):
    correct = 0
    wrong = 0
    total = 0
    quiz_info = {'total': 0, 'wrong': [], 'correct': []}


    for q in range(question_count):

        data = get_question()
        question = data[0]
        answer = get_answer(data[1], data[2])

        total = q + 1
        print(question)
        user_answer = input('Your Answer? ')

        if user_answer.lower() == answer.lower():
            print('Correct!')
            correct += 1
            quiz_info['correct'].append({'number': q + 1,
                                         'user_answer': user_answer,
                                         'correct_answer': answer,
                                         'question': question})
            print('Current score: {} / {} = {}%'.format(str(correct),
                                                        str(total),
                                                        str(score(correct, wrong, total))))
        else:
            wrong += 1
            quiz_info['wrong'].append({'number': q + 1,
                                         'user_answer': user_answer,
                                         'correct_answer': answer,
                                         'question': question})
            print('Not quite!')
            print('The correct answer was: {}'.format(answer.lower()))
            print('Please see chapter {}, item {}.'.format(str(data[3]),
                                                           str(data[2] + 1)))
            print('Current score: {} / {} = {}%'.format(str(correct),
                                                        str(total),
                                                        str(score(correct, wrong, total))))

        print('\n')

    print('Final score: {} / {} = {}%'.format(str(correct),
                                              str(total),
                                              str(score(correct, wrong, total))))

    if input('Would you like to take another quiz? (y/n):').lower() != 'y':
        quiz_info['total'] = total
        quiz_info['score'] = score(correct, wrong, total)
        quizzes.append(quiz_info)
        questions_asked.clear()
        if input('View Report Card? (y/n):').lower() == 'y':
            report_card(quizzes)
    else:
        quiz_info['total'] = total
        quiz_info['score'] = score(correct, wrong, total)
        quizzes.append(quiz_info)
        questions_asked.clear()
        print('')
        give_quiz()

def report_card(quizzes):
    print('This is your report card for the quiz / quizzes you took!\n')
    print('Number of quizzes taken: {}\n\n'.format(str(len(quizzes))))

    for quiz_index in range(len(quizzes)):
        print('Quiz {}'.format(str(quiz_index + 1)))
        quiz = quizzes[quiz_index]

        print('Score: {}% Total Questions: {}'.format(str(quiz['score']),
                                                      str(quiz['total'])))
        print('Correct: {} Wrong: {}'.format(str(len(quiz['correct'])),
                                             str(len(quiz['wrong']))))
        print('')
        print('Questions missed:')
        for question in quiz['wrong']:
            print("{}.) {}".format(str(question['number']), question['question']))
            print('Your answer: {}'.format(question['user_answer']))
            print('Correct answer: {}'.format(question['correct_answer']))
            print('\n')
        print('Questions Correct:')
        for question in quiz['correct']:
            print("{}.) {}".format(str(question['number']), question['question']))
            print('Your answer: {}'.format(question['user_answer']))
            print('Correct answer: {}'.format(question['correct_answer']))
            print('\n')

if __name__ == '__main__':
    give_quiz()