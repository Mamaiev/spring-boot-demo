import ua.gm.model.Photo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public void test() {
        ArrayList<Photo> list = new ArrayList<>();
        list.add(new Photo());
        list.add(new Photo());
        list.add(new Photo());
        list.add(new Photo());
        list.stream().filter(a -> a != null).count();
        Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.TEN));


        List<String> texts = new ArrayList<>();
        texts.add("Ronaldo");
        texts.add("Ronaldo");
        texts.add("Pele");
        Set<String> textSet = texts.stream()
                .filter(text -> text.length() < 12)
                .collect(Collectors.toSet());

    }
}
