public class Calculator {
    public static float calculate(float firstOperand, float secandOperand, char operator){
        switch (operator){
            case '+':
                return firstOperand + secandOperand;
            case '-':
                return firstOperand - secandOperand;
            case '*':
                return firstOperand * secandOperand;
            case '/':
                if (secandOperand!=0)
                return  firstOperand / secandOperand;
                else
                    throw new RuntimeException("You can't devide zero You're fool");
            default:
                throw new RuntimeException(("Please try again"));
        }
    }
}
