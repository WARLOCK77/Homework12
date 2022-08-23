package ua.levelup.Homework12.Numbers;

public class DoubleGenerator extends AbstractGenerator<Double>{

    @Override
    public Double getNextRand() {
        return random.nextDouble();
    }
}
