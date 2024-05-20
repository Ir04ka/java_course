# Условия задач

## task_1

### Task1
Вывод Hello World.

### Task2
На вход поступают два больших вещественных числа в форме строки. И тип операции ADD, SUB, MULT, DIV, REM, POW. Сложение, вычитание, умножение, деление, остаток после деления, возведение в степень.
Нужно вывести результат операции между двумя числами, учтя пограничные случаи и возможные ошибки.
Услоаия: сделать через BIgDecimal и BigInteger. Для операции POW левый операнд целочисленный, а правый помещается в int.

#### Пример работы:  
##### Ввод  
2.712121213124124124124 3 ADD  
2 3.00000000000000001 SUB  
2 10 POW

##### Вывод  
5.712121213124124124124  
-1.0000000000000000  
1024

### Task3
Ввод/вывод из файла.
На вход поступает файл input.txt в формате Фамилия Имя Отчество и еще всякие разные данные. Во входных данных могут быть грязные данные, т.е. отсутствует фамилия, имя, отчество. Может прийти даже пустая строчка. Нужно обработать все строчки, которые получится, остальные пропускаем. Для каждого человека вывести его имя и инициалы через новую строчку.

#### Пример работы:  
##### Ввод  
Ионов Кирилл Игоревич 6	2387412 21339 фвывр ыфво  
Петров Петр Петрович всякие разные даннные 13901239  
Alexeev Alex Alexeevich  
Петров Миша  

##### Вывод  
Кирилл И.И.  
Петр П.П.  
Alex A.A.  
...есть разные варианты...  

## task_4

### Task1
На вход подаются даты в формате "год месяц день". Вывести число дней, которое прошло между минимальной и максимальной датой.

##### Ввод  
2010 1 1  
2022 12 31  

##### Вывод  
4747

### Task2
На вход подается имя дня недели и количество дней. Нужно вывести, какой день недели будет через заданное количество дней. Количество дней >= 0.  
Условие: сделать через Enum.

#### Пример работы:
##### Ввод  
sunday 10

##### Вывод  
wednesday

### Task3
В конец строки 100 000 раз дописывается строчка, состоящая из 10 рандомных символов. При каждой записи строчка из 10 символов генерируется заново.  
Выберать из существующих классов java.lang.* такую реализацию строки, которая будет наиболее оптимальной для использования в таком алгоритме и доказать, что она будет быстрее.
