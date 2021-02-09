public class MathematicsOperations {

    public Long factorial(int number){
        long factorial = 1;
        for(int i = 2;i<=number;i++)
        {
            factorial *= i;
        }

        return factorial;
    }


    public int Sum(int number1, int number2) {
        int sum;
        sum = number1 + number2;
        return sum;
    }
}
