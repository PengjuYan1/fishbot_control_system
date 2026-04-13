package com.boat.jrosbridge.rosbridge.indication;
public class Indication {

    public Indication()
    {
        return;
    }

    public static boolean asArray(reflect.Field p1)
    {
        int v0_2;
        if (p1.getAnnotation(com.boat.jrosbridge.rosbridge.indication.AsArray) == null) {
            v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }

    public static String getIndicatedName(Class p1)
    {
        return com.boat.jrosbridge.rosbridge.indication.Indication.getName(p1, com.boat.jrosbridge.rosbridge.indication.Indicated);
    }

    public static String getIndicatorName(Class p1)
    {
        return com.boat.jrosbridge.rosbridge.indication.Indication.getName(p1, com.boat.jrosbridge.rosbridge.indication.Indicator);
    }

    private static String getName(Class p6, Class p7)
    {
        String v0 = 0;
        reflect.Field[] v1 = p6.getFields();
        int v3 = 0;
        while (v3 < v1.length) {
            reflect.Field v4 = v1[v3];
            if (v4.getAnnotation(p7) == null) {
                v3++;
            } else {
                v0 = v4.getName();
                break;
            }
        }
        return v0;
    }

    public static boolean isBase64Encoded(reflect.Field p2)
    {
        if ((p2.getAnnotation(com.boat.jrosbridge.rosbridge.indication.Base64Encoded) == null) || ((!p2.getType().isArray()) || (!p2.getType().getComponentType().equals(Byte.TYPE)))) {
            int v0_4 = 0;
        } else {
            v0_4 = 1;
        }
        return v0_4;
    }

    public static boolean isIndicated(reflect.Field p1)
    {
        int v0_2;
        if (p1.getAnnotation(com.boat.jrosbridge.rosbridge.indication.Indicated) == null) {
            v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }
}
