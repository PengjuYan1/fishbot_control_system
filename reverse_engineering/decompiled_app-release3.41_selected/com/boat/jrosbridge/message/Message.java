package com.boat.jrosbridge.message;
public abstract class Message {

    public Message()
    {
        return;
    }

    public static String getMessageType(Class p1)
    {
        return ((com.boat.jrosbridge.message.MessageType) p1.getAnnotation(com.boat.jrosbridge.message.MessageType)).string();
    }

    public static boolean isPrimitive(Class p1)
    {
        if ((!p1.isPrimitive()) && ((!p1.equals(String)) && ((!Number.isAssignableFrom(p1)) && (!p1.equals(Boolean))))) {
            int v0_3 = 0;
        } else {
            v0_3 = 1;
        }
        return v0_3;
    }

    public static void register(Class p5, java.util.Map p6)
    {
        try {
            com.boat.jrosbridge.message.Message.typecheck(p5);
            com.boat.jrosbridge.message.MessageException v0_0 = com.boat.jrosbridge.message.Message.getMessageType(p5);
            java.io.PrintStream v1_2 = ((Class) p6.get(v0_0));
        } catch (com.boat.jrosbridge.message.MessageException v0_1) {
            System.out.println(v0_1.getMessage());
            return;
        }
        if (v1_2 != null) {
            if (!v1_2.equals(p5)) {
                throw new com.boat.jrosbridge.message.MessageException(new StringBuilder().append("Message String \'").append(v0_0).append("\' is assigned to two different classes (").append(p5.getName()).append(" and ").append(v1_2.getName()).append(")").toString());
            } else {
            }
        }
        p6.put(v0_0, p5);
        return;
    }

    private static void typecheck(Class p7)
    {
        if (!com.boat.jrosbridge.message.Message.isAssignableFrom(p7)) {
            throw new com.boat.jrosbridge.message.MessageException(new StringBuilder().append("Class \'").append(p7.getName()).append("\' does not extend Message").toString());
        } else {
            if (com.boat.jrosbridge.message.Message.getMessageType(p7) == null) {
                throw new com.boat.jrosbridge.message.MessageException(new StringBuilder().append("Class \'").append(p7.getName()).append("\' is missing the MessageType annotation").toString());
            } else {
                com.boat.jrosbridge.message.MessageException v0_6 = p7.getFields();
                String v1_8 = v0_6.length;
                int v2_6 = 0;
                while (v2_6 < v1_8) {
                    Class v4 = v0_6[v2_6].getType();
                    if (!v4.isArray()) {
                        if (!com.boat.jrosbridge.message.Message.isPrimitive(v4)) {
                            com.boat.jrosbridge.message.Message.typecheck(v4);
                        }
                    } else {
                        boolean v5_2 = v4.getComponentType();
                        if (!com.boat.jrosbridge.message.Message.isPrimitive(v5_2)) {
                            com.boat.jrosbridge.message.Message.typecheck(v5_2);
                        }
                    }
                    v2_6++;
                }
                return;
            }
        }
    }
}
