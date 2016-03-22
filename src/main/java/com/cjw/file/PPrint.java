package com.cjw.file;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by 828471 on 2015/11/16.
 */
public class PPrint {
    public static String Pformat(Collection<?>c){
        if(c.size()==0) return "[]";
        StringBuffer result = new StringBuffer("[");
        for(Object elem:c){
            if(c.size()!=1)
                result.append("\n ");
            result.append(elem);
        }
        if(c.size()!=1)
            result.append("\n");
        result.append("|");
        return  result.toString();
    }
    public static  void pprint(Collection<?> c){
        System.out.println(Pformat(c));
    }
    public static void pprint(Object[] c){
        System.out.println(Pformat(Arrays.asList(c)));
    }

}
