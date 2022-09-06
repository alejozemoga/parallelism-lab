package rase_condition;

import java.util.Map;

public class CheckThenActExample {

    /**
     * If two or more threads call the checkThenAct() method on the same CheckThenActExample object,
     * then two or more threads may execute the if-statement at the same time, evaluate
     * sharedMap.containsKey("key") to true, and thus move into the body code block
     * of the if-statement. In there, multiple threads may then try to remove the key,
     * value pair stored for the key "key", but only one of them will actually be able to do it.
     * The rest will get a null value back, since another thread already removed the key,value pair.
     * @param sharedMap
     */
    public void checkThenAct(Map<String, String> sharedMap) {
        if(sharedMap.containsKey("key")){
            String val = sharedMap.remove("key");
            if(val == null) {
                System.out.println("Value for 'key' was null");
            }
        } else {
            sharedMap.put("key", "value");
        }
    }
}
