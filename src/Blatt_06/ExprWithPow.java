package Blatt_06;

import aud.example.expr.*;

public class ExprWithPow extends ExpressionParser{

public class Power extends AtomicExpression {
    public Power() {}

    @Override
    public Type getType() {
        return Type.OpDivide;
    }

    @Override
    public String toString() {
        return "^";
    }

    @Override
    public double getValue() {
        ExpressionTree left =(ExpressionTree) node_.getLeft();
        ExpressionTree right=(ExpressionTree) node_.getRight();
        return Math.pow(left.getData().getValue(), right.getData().getValue());
    }


}

    public ExpressionTree power(int level) {
        super.verbose(level, "<power>");

        ExpressionTree left = factor(level + 1);

        if (super.lookahead() == Tokenizer.POWER) {
            super.nextToken();
            ExpressionTree right = power(level + 1);
            return new ExpressionTree(new Power(),left,right);
        }

        return left;
    }

    @Override
    protected ExpressionTree product(int level) {
        super.verbose(level, "<product>");

        ExpressionTree left = power(level + 1);

        if (super.lookahead()==Tokenizer.TIMES) {
            super.nextToken();
            ExpressionTree right=product(level+1);
            return new ExpressionTree(new Times(),left,right);
        }
        else if (super.lookahead()==Tokenizer.DIVIDE) {
            super.nextToken();
            ExpressionTree right=product(level+1);
            return new ExpressionTree(new Divide(),left,right);
        }

        return left;
    }

    public static void main(String[] args) {
    }

}