public class ArrayMath {

    protected  int Calculator(String line) { // выполнение математических операций с переменными

        int result = 0;
        int[] digit;
        char[] sign;

        line=line.trim();
        digit = ArrayOfDigits(line);
        sign = ArrayOfSign(line);

        if (sign[1] == 0) { // операции с двумя переменными
            switch (sign[0]) {
                case '+':
                    return  digit[0] + digit[1];
                case '-':
                    return digit[0] - digit[1];
                case '*':
                    return digit[0] * digit[1];
                case '/':
                    return digit[0] / digit[1];
            }
        }
        else { // операции с тремя переменными
            switch (sign[1]) {
                case  '+':
                    switch (sign[0]) {
                        case '+':
                            return  digit[0] + digit[1] + digit[2];
                        case '-':
                            return digit[0] - digit[1] + digit[2];
                        case '*':
                            return digit[0] * digit[1] + digit[2];
                        case '/':
                            return digit[0] / digit[1] + digit[2];
                    }
                case '-':
                    switch (sign[0]) {
                        case '+':
                            return  digit[0] + digit[1] - digit[2];
                        case '-':
                            return digit[0] - digit[1] - digit[2];
                        case '*':
                            return digit[0] * digit[1] - digit[2];
                        case '/':
                            return digit[0] / digit[1] - digit[2];
                    }
                case '*':
                    switch (sign[0]) {
                        case '+':
                            return digit[0] + digit[1] * digit[2];
                        case '-':
                            return digit[0] - digit[1] * digit[2];
                        case '*':
                            return digit[0] * digit[1] * digit[2];
                        case '/':
                            return digit[0] / digit[1] * digit[2];
                    }
                case '/':
                    switch (sign[0]) {
                        case '+':
                            return digit[0] + digit[1] / digit[2];
                        case '-':
                            return digit[0] - digit[1] / digit[2];
                        case '*':
                            return digit[0] * digit[1] / digit[2];
                        case '/':
                            return digit[0] / digit[1] / digit[2];
                    }
            }
        }
        return result;
    }
    private static int[] ArrayOfDigits (String line) { // создание массива из чисел в строке
        char[] charInLine = line.toCharArray();
        int[] digits = new int[3];
        byte i = 0 , k = 0;
        do {
            if ((charInLine[i] >= '0') && (charInLine[i] <= '9')) {
                if (i!=charInLine.length - 1) { // защита от проверки на 10 на конце строки
                    if ((charInLine[i] == '1') && (charInLine[i + 1] == '0')) { // проверка на 10
                        if (i == 0) {
                            digits[k] = 10; // 10 в начале строки
                            i++;
                        } else if (charInLine[i - 1] == '-') {
                            digits[k] = -10; //  -10
                            i++;
                        } else {
                            digits[k] = 10; // 10
                            i++;
                        }
                        k++;
                        i++;
                        continue; // пропуск проверки на другие цифры и изменение счётчика
                    }
                }
                if (i == 0) {
                    digits[k] = charInLine[i] - '0'; // преобразование символа в число на начале строки
                }
                else if (charInLine[i - 1] == '-') {
                    digits[k] = (charInLine[i] - '0') * -1; // преобразование символа в отрицательное число
                } else {
                    digits[k] = charInLine[i] - '0'; //преобразование символа в число
                }
                k++;
            }
            i++;
        } while (i<charInLine.length);
        return  digits;
    }

    private static char[] ArrayOfSign(String line) { // создание массива из знаков мат операций
        char[] charInLine = line.toCharArray();
        char[] signs = new char[2];
        byte i = 0, k = 0;
        do {
            if ((charInLine[i]=='-')&&(charInLine[i+1] >= '0')&&(charInLine[i+1] <='9')) { // проверка на отрицательное число
                i++;
            }
            else if ((charInLine[i] == '+') || (charInLine[i] == '-') || (charInLine[i] == '*') || (charInLine[i] == '/')) { // запись знака в массив
                    signs[k] = charInLine[i];
                    k++;
                }
            i++;
        } while (i < charInLine.length - 1);
        return signs;
    }
}
