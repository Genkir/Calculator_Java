public class LineChecking {
    enum states {digit, sign}
    protected static void LineChecks(String line) throws MissInputException {
        boolean missInput = false;
        byte i = 0;
        line = line.trim();
        char[] charInLine = line.toCharArray();
        if (charInLine.length==0) {
            missInput=true;
        }
        states state = states.digit;
        if (!missInput) {
            do {
                switch (state) {
                    case digit: // поиск цифр
                        if ((charInLine[i] == '-') && (i != (byte) line.length() - 1)) // проверка на отрицательное число
                        {
                            if ((charInLine[i + 1] < '0') || (charInLine[i + 1] > '9')) { // не знак цифры, а минус
                                missInput = true;
                            }
                            if (i != (byte) line.length() - 2) {
                                if ((charInLine[i + 1] == '1') && (charInLine[i + 2] == '0')) { // проверка на -10
                                    i++;
                                }
                            }
                            i++;
                            state = states.sign; // изменение на поиск знака
                            break;
                        }
                        if ((charInLine[i] >= '0') && (charInLine[i] <= '9')) {
                            if (i != charInLine.length - 1) { // защита от проверки на 10 в конце строки
                                if ((charInLine[i] == '1') && (charInLine[i + 1] == '0')) { // проверка на 10
                                    i++;
                                }
                            }
                            state = states.sign; // изменение на поиск знака
                            break;
                        }
                        if (charInLine[i] == ' ') { // проверка на пробелы
                            break;
                        } else {
                            missInput = true; // цифры не найдено
                        }
                        break;
                    case sign:
                        if ((charInLine[i] == '-') && (i != (byte) line.length() - 1)) {
                            if ((charInLine[i + 1] >= '0') && (charInLine[i + 1] <= '9')) { // не минус, а знак цифры
                                missInput = true;
                                break;
                            }
                        }
                        if ((charInLine[i] == '+') || (charInLine[i] == '-') || (charInLine[i] == '*') || (charInLine[i] == '/')) {
                            state = states.digit; // изменение на поиск цифры
                        } else if (charInLine[i] == ' ') { // проверка на пробелы
                            break;
                        } else {
                            missInput = true; // знака не найдено
                        }
                        break;
                }
                if (missInput) { // выход из цикла при нахождении ошибки
                    break;
                }
                i++;
            } while (i < (byte) charInLine.length);
        }
        if ((state == states.digit) || (i <= 2)) { // проверка на введение одного числа или остановка ввода на операцие
            missInput = true;
        }
        if (missInput) {
            throw new MissInputException("Invalid input at ", i + 1);
        }
    }
}

class MissInputException extends Exception { // создание класса исключения
    private int number;

    public int getNumber() {
        return number;
    }

    public MissInputException(String message, int num) {
        super(message);
        number = num;
    }
}