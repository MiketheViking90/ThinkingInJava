package holding;

import java.util.Arrays;
import java.util.List;

import holding.domain.Heavy;
import holding.domain.Light;
import holding.domain.Powder;
import holding.domain.Slush;
import holding.domain.Snow;


public class AsListInference {

    public static void main(String[] args) {
        List<Snow> shows = Arrays.asList(new Heavy(), new Powder(), new Slush());
        List<Snow> confusedSnow = Arrays.asList(new Light(), new Heavy());
    }

}
