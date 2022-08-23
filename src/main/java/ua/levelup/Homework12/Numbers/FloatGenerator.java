package ua.levelup.Homework12.Numbers;

public class FloatGenerator extends AbstractGenerator<Float>{
    @Override
    public Float getNextRand() {
        return random.nextFloat();
    }
}
