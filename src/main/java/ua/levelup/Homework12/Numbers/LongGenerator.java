package ua.levelup.Homework12.Numbers;

public class LongGenerator extends AbstractGenerator <Long>{
    @Override
    public Long getNextRand() {
        return random.nextLong();
    }
}
