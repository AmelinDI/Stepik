package edu.stepik;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
    public static void main(String[] args) {
        String inputString = "kpb jwjd frv http://www.jqwmvnhu.gagzkxksp.ru/tmyp/?param0=ugtehajgg ior bsavmi\n" +
                "elsdedejy blfesitfag udhyluxkj http://www.zhbh.kdokw.yapv.ru/xoihdn/ubs/?param0=pblsq&param1=wwqzb tmzwwo dmvlbwyvqv http://www.mppsuderi.rqt.com/ermuske/mldbhgy/?param0=bex hvcsgbl jrhbx gjtesiyyej pvj skphrki http://www.eccqkeoj.uttajvapi.hxnadj.com/?param0=hoi&param1=ssdd yykjd lob zlrsrzi xmmjbvle\n" +
                "cpuymoqua http://www.zpy.witzxygk.ru hszud gzyvvhxqam crv zsy cuwjsruq https://www.ocdmnsdocx.xzsom.com nfwzfxllbe feesuhjemh zhhaigtoi https://www.osjum.sfzxcqblax.oqehtucjvd.com/?param0=sfcbfp&param1=sjnb";
//        findAllNotUrl(inputString);
        findAllUrl(inputString);
    }

    private static void findAllNotUrl(String text) {
        String[] result = text.split("\\bhttp[s]{0,1}[:]\\/{2}\\S*\\b");
        for (String url: result) {
            System.out.println(url);
        }
    }

    private static void findAllUrl(String text) {
        Pattern pattern = Pattern.compile("\\bhttp[s]{0,1}[:]\\/{2}\\S*\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.printf("%s%n", matcher.group(0));
        }
    }

}
