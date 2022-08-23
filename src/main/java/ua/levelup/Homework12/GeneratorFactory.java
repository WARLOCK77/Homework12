package ua.levelup.Homework12;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import ua.levelup.Homework12.Numbers.Generator;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratorFactory {

    private static final List<Generator<?>> generatorObjects = new ArrayList<>();
    private static Random random = new Random();

    static {
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void init() throws Exception {
        Reflections reflections = new Reflections("ua.levelup.Homework12.Numbers", Scanners.SubTypes);
        Class<? extends Generator>[] array = new Class[0];
        Class<? extends Generator>[] generatorsClasses = reflections.getSubTypesOf(Generator.class).toArray(array);

        for (Class<? extends Generator> generatorClass : generatorsClasses) {
            if (Modifier.isAbstract(generatorClass.getModifiers())) {
                continue;
            }
            generatorObjects.add(generatorClass.getDeclaredConstructor().newInstance());
        }
    }

    public static <T extends Number> Generator<T> getGenerator() {
        return (Generator<T>) generatorObjects.get(random.nextInt(generatorObjects.size()));
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Generator<Number> generator = getGenerator();
            System.out.println(generator.getClass().getSimpleName());
            System.out.println(generator.getNextRand());
        }
    }
}
