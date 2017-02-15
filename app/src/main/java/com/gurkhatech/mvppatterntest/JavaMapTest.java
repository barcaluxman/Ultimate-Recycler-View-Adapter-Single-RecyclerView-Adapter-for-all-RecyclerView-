package com.gurkhatech.mvppatterntest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by adventure on 2/14/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public class JavaMapTest {

public static void main ( String[] s ) {

    Map < Integer, abc > map = new HashMap <> ();
    ClassA a = new ClassA ();
    ClassB b = new ClassB ();
    ClassC c = new ClassC ();
    ClassD d = new ClassD ();
    map.put ( 1, a );
    map.put ( 2, b );
    map.put ( 3, c );
    map.put ( 4, d );

    System.out.print ( "Getting value by key" +1+" "+map.get ( 1 ).toString ());
    System.out.print ( "Getting key by value" +b.toString ()+" "+getValueFromKey ( map ).get ( b ));


}

static Map<abc,Integer> getValueFromKey(Map <Integer,abc> map){
    Map<abc,Integer> inversed = new HashMap <> (  );
    for (Map.Entry<Integer, abc> entry : map.entrySet())
    {
        inversed.put ( entry.getValue (),entry.getKey () );
    }
    return  inversed;
}

private static class ClassA implements abc{
    @Override
    public String toString ( ) {
        return "Class A";
    }
}

private static class ClassB implements abc{
    @Override
    public String toString ( ) {
        return "Class B";
    }
}

private static class ClassC implements abc{
    @Override
    public String toString ( ) {
        return "Class C";
    }
}

private static class ClassD implements abc {
    @Override
    public String toString ( ) {
        return "Class D";
    }
}

interface  abc{

}
}
