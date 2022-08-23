package ua.levelup.Homework12.Numbers;

public class IntegerGenerator extends AbstractGenerator<Integer>{

    @Override
    public Integer getNextRand() {
        return random.nextInt();
    }
}
