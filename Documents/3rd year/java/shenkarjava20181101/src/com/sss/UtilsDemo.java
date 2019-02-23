package com.sss;

public class UtilsDemo {
    public static void main(String... args) {
        SimpleLambdaExpressionDemo myApp = new SimpleLambdaExpressionDemo();
//        SimpleLambdaExpressionDemo.MathOperation op = Utils::calcu;
        SimpleLambdaExpressionDemo.MathOperation op = new SimpleLambdaExpressionDemo.MathOperation() {
            @Override
            public int execute(int a, int b) {
                return Utils.calcu(a, b);
            }
        };
        int num = op.execute(40, 2);
        System.out.println("40 * 2 = " + num);
    }
}

