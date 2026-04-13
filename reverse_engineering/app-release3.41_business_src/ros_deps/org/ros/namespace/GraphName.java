package org.ros.namespace;
public class GraphName {
    static final String ANONYMOUS_PREFIX = "anonymous_";
    private static final String ROOT = "/";
    private static final String SEPARATOR = "/";
    private static final java.util.regex.Pattern VALID_GRAPH_NAME_PATTERN;
    private static java.util.concurrent.atomic.AtomicInteger anonymousCounter;
    private final String name;

    static GraphName()
    {
        org.ros.namespace.GraphName.VALID_GRAPH_NAME_PATTERN = java.util.regex.Pattern.compile("^([\\~\\/A-Za-z][\\w_\\/]*)?$");
        org.ros.namespace.GraphName.anonymousCounter = new java.util.concurrent.atomic.AtomicInteger();
        return;
    }

    private GraphName(String p1)
    {
        this.name = p1;
        return;
    }

    private static String canonicalize(String p3)
    {
        if (!org.ros.namespace.GraphName.VALID_GRAPH_NAME_PATTERN.matcher(p3).matches()) {
            try {
                throw new Exception(new StringBuilder().append("Invalid graph name: ").append(p3).toString());
            } catch (StringBuilder v0_2) {
                v0_2.printStackTrace();
            }
        }
        while ((!p3.equals("/")) && (p3.endsWith("/"))) {
            p3 = p3.substring(0, (p3.length() - 1));
        }
        if (p3.startsWith("~/")) {
            p3 = new StringBuilder().append("~").append(p3.substring(2)).toString();
        }
        return p3;
    }

    public static org.ros.namespace.GraphName empty()
    {
        return new org.ros.namespace.GraphName("");
    }

    public static org.ros.namespace.GraphName newAnonymous()
    {
        return new org.ros.namespace.GraphName(new StringBuilder().append("anonymous_").append(org.ros.namespace.GraphName.anonymousCounter.incrementAndGet()).toString());
    }

    public static org.ros.namespace.GraphName of(String p2)
    {
        return new org.ros.namespace.GraphName(org.ros.namespace.GraphName.canonicalize(p2));
    }

    public static org.ros.namespace.GraphName root()
    {
        return new org.ros.namespace.GraphName("/");
    }

    public boolean equals(Object p6)
    {
        if (this != p6) {
            if (p6 != null) {
                if (this.getClass() == p6.getClass()) {
                    if (this.name != null) {
                        if (!this.name.equals(((org.ros.namespace.GraphName) p6).name)) {
                            return 0;
                        }
                    } else {
                        if (((org.ros.namespace.GraphName) p6).name != null) {
                            return 0;
                        }
                    }
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 1;
        }
    }

    public org.ros.namespace.GraphName getBasename()
    {
        int v0_1 = this.name.lastIndexOf(47);
        if (v0_1 <= -1) {
            return this;
        } else {
            if ((v0_1 + 1) >= this.name.length()) {
                return org.ros.namespace.GraphName.empty();
            } else {
                return new org.ros.namespace.GraphName(this.name.substring((v0_1 + 1)));
            }
        }
    }

    public org.ros.namespace.GraphName getParent()
    {
        if (this.name.length() != 0) {
            if (!this.name.equals("/")) {
                int v0_1 = this.name.lastIndexOf(47);
                if (v0_1 <= 1) {
                    if (!this.isGlobal()) {
                        return org.ros.namespace.GraphName.empty();
                    } else {
                        return org.ros.namespace.GraphName.root();
                    }
                } else {
                    return new org.ros.namespace.GraphName(this.name.substring(0, v0_1));
                }
            } else {
                return org.ros.namespace.GraphName.root();
            }
        } else {
            return org.ros.namespace.GraphName.empty();
        }
    }

    public int hashCode()
    {
        return this.name.hashCode();
    }

    public boolean isEmpty()
    {
        return this.name.isEmpty();
    }

    public boolean isGlobal()
    {
        int v1 = 0;
        if ((!this.isEmpty()) && (this.name.charAt(0) == 47)) {
            v1 = 1;
        }
        return v1;
    }

    public boolean isPrivate()
    {
        int v1 = 0;
        if ((!this.isEmpty()) && (this.name.charAt(0) == 126)) {
            v1 = 1;
        }
        return v1;
    }

    public boolean isRelative()
    {
        if ((this.isPrivate()) || (this.isGlobal())) {
            int v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }

    public boolean isRoot()
    {
        return this.name.equals("/");
    }

    public org.ros.namespace.GraphName join(String p2)
    {
        return this.join(org.ros.namespace.GraphName.of(p2));
    }

    public org.ros.namespace.GraphName join(org.ros.namespace.GraphName p4)
    {
        if ((!p4.isGlobal()) && (!this.isEmpty())) {
            if (!this.isRoot()) {
                if (!p4.isEmpty()) {
                    return new org.ros.namespace.GraphName(new StringBuilder().append(this.toString()).append("/").append(p4.toString()).toString());
                } else {
                    return this;
                }
            } else {
                return p4.toGlobal();
            }
        } else {
            return p4;
        }
    }

    public org.ros.namespace.GraphName toGlobal()
    {
        if (!this.isGlobal()) {
            if (!this.isPrivate()) {
                return new org.ros.namespace.GraphName(new StringBuilder().append("/").append(this.name).toString());
            } else {
                return new org.ros.namespace.GraphName(new StringBuilder().append("/").append(this.name.substring(1)).toString());
            }
        } else {
            return this;
        }
    }

    public org.ros.namespace.GraphName toRelative()
    {
        if ((!this.isPrivate()) && (!this.isGlobal())) {
            return this;
        } else {
            return new org.ros.namespace.GraphName(this.name.substring(1));
        }
    }

    public String toString()
    {
        return this.name;
    }
}
