package com.boat.jrosbridge.rosbridge.implementation;
public class JSON {
    static final String TAG = "rosbridgeJson";

    public JSON()
    {
        return;
    }

    private static org.json.simple.JSONArray convertArrayToJSONArray(Object p4)
    {
        org.json.simple.JSONArray v0_1 = new org.json.simple.JSONArray();
        int v1 = 0;
        while (v1 < reflect.Array.getLength(p4)) {
            Object v2_1 = reflect.Array.get(p4, v1);
            if (v2_1 != null) {
                v0_1.add(com.boat.jrosbridge.rosbridge.implementation.JSON.convertElementToJSON(v2_1));
            }
            v1++;
        }
        return v0_1;
    }

    public static byte[] convertBase64JSONStringToByteArray(Object p1)
    {
        return com.boat.jrosbridge.rosbridge.implementation.Base64.decode(((String) p1));
    }

    private static Object convertByteArrayToBase64JSONString(Object p2)
    {
        return com.boat.jrosbridge.rosbridge.implementation.Base64.encodeToString(((byte[]) p2), 0);
    }

    private static Object convertElementToField(Object p2, Class p3, reflect.Field p4, com.boat.jrosbridge.rosbridge.implementation.Registry p5)
    {
        Object v0_3;
        if (!p2.getClass().equals(org.json.simple.JSONObject)) {
            if (!p2.getClass().equals(org.json.simple.JSONArray)) {
                if (!com.boat.jrosbridge.rosbridge.indication.Indication.isBase64Encoded(p4)) {
                    v0_3 = com.boat.jrosbridge.rosbridge.implementation.JSON.convertJSONPrimitiveToPrimitive(p2, p3);
                } else {
                    v0_3 = com.boat.jrosbridge.rosbridge.implementation.JSON.convertBase64JSONStringToByteArray(p2);
                }
            } else {
                if (!com.boat.jrosbridge.rosbridge.indication.Indication.asArray(p4)) {
                    v0_3 = com.boat.jrosbridge.rosbridge.implementation.JSON.convertJSONArrayToArray(((org.json.simple.JSONArray) p2), p3, p5);
                } else {
                    v0_3 = com.boat.jrosbridge.rosbridge.implementation.JSON.convertJSONArrayToMessage(((org.json.simple.JSONArray) p2), p3, p5);
                }
            }
        } else {
            v0_3 = com.boat.jrosbridge.rosbridge.implementation.JSON.convertJSONObjectToMessage(((org.json.simple.JSONObject) p2), p3, p5);
        }
        return v0_3;
    }

    private static Object convertElementToJSON(Object p2)
    {
        org.json.simple.JSONObject v1_0;
        Class v0 = p2.getClass();
        if (!com.boat.jrosbridge.message.Message.isPrimitive(v0)) {
            if (!v0.isArray()) {
                v1_0 = com.boat.jrosbridge.rosbridge.implementation.JSON.convertObjectToJSONObject(p2);
            } else {
                v1_0 = com.boat.jrosbridge.rosbridge.implementation.JSON.convertArrayToJSONArray(p2);
            }
        } else {
            v1_0 = p2;
        }
        return v1_0;
    }

    private static Object convertJSONArrayToArray(org.json.simple.JSONArray p6, Class p7, com.boat.jrosbridge.rosbridge.implementation.Registry p8)
    {
        Object v0_1 = reflect.Array.newInstance(p7, p6.size());
        int v1 = 0;
        while (v1 < p6.size()) {
            Object v2_0 = p6.get(v1);
            if (v2_0 != null) {
                Object v3;
                if (!v2_0.getClass().equals(org.json.simple.JSONObject)) {
                    if (!v2_0.getClass().equals(org.json.simple.JSONArray)) {
                        v3 = com.boat.jrosbridge.rosbridge.implementation.JSON.convertJSONPrimitiveToPrimitive(v2_0, p7);
                    } else {
                        v3 = com.boat.jrosbridge.rosbridge.implementation.JSON.convertJSONArrayToArray(((org.json.simple.JSONArray) v2_0), p7.getComponentType(), p8);
                    }
                } else {
                    v3 = com.boat.jrosbridge.rosbridge.implementation.JSON.convertJSONObjectToMessage(((org.json.simple.JSONObject) v2_0), p7, p8);
                }
                reflect.Array.set(v0_1, v1, v3);
            }
            v1++;
        }
        return v0_1;
    }

    private static com.boat.jrosbridge.message.Message convertJSONArrayToMessage(org.json.simple.JSONArray p10, Class p11, com.boat.jrosbridge.rosbridge.implementation.Registry p12)
    {
        try {
            Exception v1_2 = ((com.boat.jrosbridge.message.Message) p11.newInstance());
            int v2_1 = 0;
            reflect.Field[] v3 = p11.getFields();
            int v4 = v3.length;
            int v5 = 0;
        } catch (Exception v1_1) {
            v1_1.printStackTrace();
            return 0;
        }
        while (v5 < v4) {
            reflect.Field v6 = v3[v5];
            Class v7 = com.boat.jrosbridge.rosbridge.implementation.JSON.getFieldClass(v1_2, 0, v6, p12);
            int v8 = (v2_1 + 1);
            int v2_0 = p10.get(v2_1);
            if (v2_0 != 0) {
                v6.set(v1_2, com.boat.jrosbridge.rosbridge.implementation.JSON.convertElementToField(v2_0, v7, v6, p12));
            }
            v5++;
            v2_1 = v8;
        }
        return v1_2;
    }

    private static com.boat.jrosbridge.message.Message convertJSONObjectToMessage(org.json.simple.JSONObject p8, Class p9, com.boat.jrosbridge.rosbridge.implementation.Registry p10)
    {
        try {
            Exception v0_1 = ((com.boat.jrosbridge.message.Message) p9.newInstance());
            int v1_1 = p9.getFields();
            int v2 = v1_1.length;
            int v3 = 0;
        } catch (Exception v0_2) {
            v0_2.printStackTrace();
            return 0;
        }
        while (v3 < v2) {
            int v4 = v1_1[v3];
            Class v5 = com.boat.jrosbridge.rosbridge.implementation.JSON.getFieldClass(v0_1, p8, v4, p10);
            Object v6_1 = p8.get(v4.getName());
            if (v6_1 != null) {
                v4.set(v0_1, com.boat.jrosbridge.rosbridge.implementation.JSON.convertElementToField(v6_1, v5, v4, p10));
            }
            v3++;
        }
        return v0_1;
    }

    public static Object convertJSONPrimitiveToPrimitive(Object p4, Class p5)
    {
        Byte v0 = p4;
        if ((p5.isPrimitive()) || (Number.isAssignableFrom(p5))) {
            if ((!p5.equals(Double.TYPE)) && (!p5.equals(Double))) {
                if ((!p5.equals(Float.TYPE)) && (!p5.equals(Float))) {
                    if ((!p5.equals(Long.TYPE)) && (!p5.equals(Long))) {
                        if ((!Integer.TYPE.equals(p5)) && (!p5.equals(Integer))) {
                            if ((!p5.equals(Short.TYPE)) && (!p5.equals(Short))) {
                                if ((p5.equals(Byte.TYPE)) || (p5.equals(Byte))) {
                                    v0 = new Byte(((Number) p4).byteValue());
                                }
                            } else {
                                v0 = new Short(((Number) p4).shortValue());
                            }
                        } else {
                            v0 = new Integer(((Number) p4).intValue());
                        }
                    } else {
                        v0 = new Long(((Number) p4).longValue());
                    }
                } else {
                    v0 = new Float(((Number) p4).floatValue());
                }
            } else {
                v0 = new Double(((Number) p4).doubleValue());
            }
        }
        return v0;
    }

    private static org.json.simple.JSONArray convertObjectToJSONArray(Object p7)
    {
        org.json.simple.JSONArray v0_1 = new org.json.simple.JSONArray();
        reflect.Field[] v1_1 = p7.getClass().getFields();
        int v2 = v1_1.length;
        int v3 = 0;
        while (v3 < v2) {
            Object v5 = com.boat.jrosbridge.rosbridge.implementation.JSON.getFieldObject(v1_1[v3], p7);
            if (v5 != null) {
                v0_1.add(com.boat.jrosbridge.rosbridge.implementation.JSON.convertElementToJSON(v5));
            }
            v3++;
        }
        return v0_1;
    }

    private static org.json.simple.JSONObject convertObjectToJSONObject(Object p8)
    {
        org.json.simple.JSONObject v0_1 = new org.json.simple.JSONObject();
        reflect.Field[] v1_1 = p8.getClass().getFields();
        int v2 = v1_1.length;
        int v3 = 0;
        while (v3 < v2) {
            reflect.Field v4 = v1_1[v3];
            Object v5 = com.boat.jrosbridge.rosbridge.implementation.JSON.getFieldObject(v4, p8);
            if (v5 != null) {
                Object v6_2;
                if (!com.boat.jrosbridge.rosbridge.indication.Indication.isBase64Encoded(v4)) {
                    if (!com.boat.jrosbridge.rosbridge.indication.Indication.asArray(v4)) {
                        v6_2 = com.boat.jrosbridge.rosbridge.implementation.JSON.convertElementToJSON(v5);
                    } else {
                        v6_2 = com.boat.jrosbridge.rosbridge.implementation.JSON.convertObjectToJSONArray(v5);
                    }
                } else {
                    v6_2 = com.boat.jrosbridge.rosbridge.implementation.JSON.convertByteArrayToBase64JSONString(v5);
                }
                v0_1.put(v4.getName(), v6_2);
            }
            v3++;
        }
        return v0_1;
    }

    private static org.json.simple.JSONObject convertStringToJSONObject(String p6)
    {
        java.io.StringReader v1_1 = new java.io.StringReader(p6);
        try {
            org.json.simple.JSONObject v0 = ((org.json.simple.JSONObject) new org.json.simple.parser.JSONParser().parse(v1_1));
        } catch (Throwable v3_2) {
            System.out.println(v3_2.getMessage());
        }
        v1_1.close();
        return v0;
    }

    public static Class getFieldClass(com.boat.jrosbridge.message.Message p3, org.json.simple.JSONObject p4, reflect.Field p5, com.boat.jrosbridge.rosbridge.implementation.Registry p6)
    {
        Class v0_0 = p5.getType();
        if (v0_0.isArray()) {
            v0_0 = p5.getType().getComponentType();
        }
        if ((com.boat.jrosbridge.rosbridge.indication.Indication.isIndicated(p5)) && (p4 != null)) {
            v0_0 = ((Class) p6.lookup(p3.getClass(), ((String) p4.get(com.boat.jrosbridge.rosbridge.indication.Indication.getIndicatorName(p3.getClass())))));
        }
        return v0_0;
    }

    private static Object getFieldObject(reflect.Field p2, Object p3)
    {
        try {
            Object v0 = p2.get(p3);
        } catch (IllegalAccessException v1_1) {
            v1_1.printStackTrace();
        }
        return v0;
    }

    public static String toJSON(com.boat.jrosbridge.message.Message p2)
    {
        return com.boat.jrosbridge.rosbridge.implementation.JSON.convertObjectToJSONObject(p2).toJSONString();
    }

    public static com.boat.jrosbridge.message.Message toMessage(String p3, Class p4, com.boat.jrosbridge.rosbridge.implementation.Registry p5)
    {
        org.json.simple.JSONObject v0 = com.boat.jrosbridge.rosbridge.implementation.JSON.convertStringToJSONObject(p3);
        org.json.simple.JSONObject v1 = v0;
        if (com.boat.jrosbridge.rosbridge.operation.Wrapper.isAssignableFrom(p4)) {
            v1 = com.boat.jrosbridge.rosbridge.implementation.JSON.wrap(v0, p4);
        }
        return com.boat.jrosbridge.rosbridge.implementation.JSON.convertJSONObjectToMessage(v1, p4, p5);
    }

    private static org.json.simple.JSONObject wrap(org.json.simple.JSONObject p4, Class p5)
    {
        org.json.simple.JSONObject v0_1 = new org.json.simple.JSONObject();
        String v1 = com.boat.jrosbridge.rosbridge.indication.Indication.getIndicatorName(p5);
        String v2 = com.boat.jrosbridge.rosbridge.indication.Indication.getIndicatedName(p5);
        v0_1.put(v1, p4.get(v1));
        v0_1.put(v2, p4);
        return v0_1;
    }
}
