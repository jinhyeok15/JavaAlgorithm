import java.util.regex.*;
import java.util.*;

public class NewsCluster {
    public int solution(String str1, String str2) {
        int answer = 0;
        String[] str1Set = trunc(elementSet(str1));
        String[] str2Set = trunc(elementSet(str2));
        boolean[] status = new boolean[str2Set.length];
        for (String s1 : str1Set) {
            for (int i=0; i<str2Set.length; i++) {
                String s2 = str2Set[i];
                if (s1.toLowerCase().equals(s2.toLowerCase()) && !status[i]){
                    status[i] = true;
                    break;
                }
            }
        }
        int nNum = 0;
        for (boolean b : status) {
            if (b) nNum++;
        }
        int uNum = str1Set.length + str2Set.length - nNum;
        if (str1Set.length==0 && str2Set.length==0) {
            answer = 65536;
        } else {
            double jNum = 65536 * nNum / uNum;
            answer = (int) Math.floor(jNum);
        }

        return answer;
    }

    private String[] elementSet(String string) {
        String[] arrOut = new String[string.length()-1];
        char[] charArr = string.toCharArray();
        int i = 1;
        while (i<string.length()) {
            String element = Character.toString(charArr[i-1]) +
                    Character.toString(charArr[i]);
            arrOut[i-1] = element;
            i++;
        }
        return arrOut;
    }

    private String[] trunc(String[] elSet) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]*$");
        List<String> arrList = new ArrayList<String>();
        for (String el : elSet) {
            Matcher matcher = pattern.matcher(el);
            if (matcher.find()) arrList.add(el);
        }
        return arrList.toArray(new String[0]);
    }
}
