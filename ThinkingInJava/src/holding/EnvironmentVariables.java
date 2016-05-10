package holding;

import java.util.Map;

public class EnvironmentVariables {

    public static void main(String[] args) {
        Map<String, String> sysMap = System.getenv();
        for (Map.Entry<String, String> entry : sysMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
