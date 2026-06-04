package DSAStructures;

import java.util.LinkedHashMap;
import java.util.Map;

public class FisrtNonRepeated {

    public int firstUniqChar(String s) {
        if(s.length() < 2)
            return 0;

        Map<Character, CharMetaData> frequencyN = new LinkedHashMap<>();
        char[] charArr = s.toCharArray();

        for(int i = 0; i < charArr.length; i++) {
            if(frequencyN.containsKey(charArr[i])) {
                frequencyN.put(charArr[i], frequencyN.get(charArr[i]).update());
            } else {
                frequencyN.put(charArr[i], new CharMetaData(i));
            }
        }

        for(Character c : frequencyN.keySet()) {
            if(!frequencyN.get(c).isRepeated) {
                return frequencyN.get(c).idx;
            }
        }

        return -1;

    }

    public class CharMetaData {
        private boolean isRepeated;
        private int idx;

        private CharMetaData (int idx) {
            this.isRepeated = false;
            this.idx = idx;
        }

        private CharMetaData update() {
            this.isRepeated = true;
            return this;
        }

    }

}
