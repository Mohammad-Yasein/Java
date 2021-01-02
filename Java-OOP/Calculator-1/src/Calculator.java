import java.io.Serializable;

public class Calculator implements Serializable {
    private double operandOne = 0;
    private double operandTwo = 0;
    private char operation = '+';
    private double result = 0;

    public Calculator() {
    }

    public Calculator(double operandOne, double operandTwo, char operation) {
        this.operandOne = operandOne;
        this.operandTwo = operandTwo;
        this.operation = operation;
    }

    public void performOperation() {
        switch (operation) {
            case '+':
                result = operandOne + operandTwo;
                break;
            case '-':
                result = operandOne - operandTwo;
                break;
            default:
                System.out.println("Invalid Operation!");
        }
    }

    public double getOperandOne() {
        return operandOne;
    }

    public void setOperandOne(double operandOne) {
        this.operandOne = operandOne;
    }

    public double getOperandTwo() {
        return operandTwo;
    }

    public void setOperandTwo(double operandTwo) {
        this.operandTwo = operandTwo;
    }

    public char getOperation() {
        return operation;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public double getResult() {
        return result;
    }
}
