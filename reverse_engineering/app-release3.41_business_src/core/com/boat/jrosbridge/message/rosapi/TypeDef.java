package com.boat.jrosbridge.message.rosapi;
public class TypeDef extends com.boat.jrosbridge.message.Message {
    public String[] examples;
    public int[] fieldarraylen;
    public String[] fieldnames;
    public String[] fieldtypes;
    public String type;

    public TypeDef()
    {
        return;
    }

    public static boolean match(String p2, Class p3)
    {
        int v0 = 0;
        if (((p2.equals("bool")) && ((Boolean.TYPE.equals(p3)) || (Boolean.equals(p3)))) || (((p2.equals("int8")) && ((Byte.TYPE.equals(p3)) || (Byte.equals(p3)))) || (((p2.equals("byte")) && ((Byte.TYPE.equals(p3)) || (Byte.equals(p3)))) || (((p2.equals("uint8")) && ((Short.TYPE.equals(p3)) || (Short.equals(p3)))) || (((p2.equals("char")) && ((Short.TYPE.equals(p3)) || (Short.equals(p3)))) || (((p2.equals("int16")) && ((Short.TYPE.equals(p3)) || (Short.equals(p3)))) || (((p2.equals("uint16")) && ((Integer.TYPE.equals(p3)) || (Integer.equals(p3)))) || (((p2.equals("int32")) && ((Integer.TYPE.equals(p3)) || (Integer.equals(p3)))) || (((p2.equals("uint32")) && ((Long.TYPE.equals(p3)) || (Long.equals(p3)))) || (((p2.equals("int64")) && ((Long.TYPE.equals(p3)) || (Long.equals(p3)))) || (((p2.equals("float32")) && ((Float.TYPE.equals(p3)) || (Float.equals(p3)))) || (((p2.equals("float64")) && ((Double.TYPE.equals(p3)) || (Double.equals(p3)))) || (((p2.equals("uint64")) && (java.math.BigInteger.equals(p3))) || ((p2.equals("string")) && (String.equals(p3)))))))))))))))) {
            v0 = 1;
        }
        return v0;
    }
}
