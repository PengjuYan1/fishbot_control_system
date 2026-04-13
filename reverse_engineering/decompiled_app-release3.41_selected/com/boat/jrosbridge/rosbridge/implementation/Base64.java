package com.boat.jrosbridge.rosbridge.implementation;
public class Base64 {
    private static final char[] CA;
    private static final int[] IA;

    static Base64()
    {
        com.boat.jrosbridge.rosbridge.implementation.Base64.CA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        int[] v0_5 = new int[256];
        com.boat.jrosbridge.rosbridge.implementation.Base64.IA = v0_5;
        java.util.Arrays.fill(com.boat.jrosbridge.rosbridge.implementation.Base64.IA, -1);
        int[] v0_1 = 0;
        while (v0_1 < com.boat.jrosbridge.rosbridge.implementation.Base64.CA.length) {
            com.boat.jrosbridge.rosbridge.implementation.Base64.IA[com.boat.jrosbridge.rosbridge.implementation.Base64.CA[v0_1]] = v0_1;
            v0_1++;
        }
        com.boat.jrosbridge.rosbridge.implementation.Base64.IA[61] = 0;
        return;
    }

    public Base64()
    {
        return;
    }

    public static final byte[] decode(String p13)
    {
        int v1;
        if (p13 == null) {
            v1 = 0;
        } else {
            v1 = p13.length();
        }
        if (v1 != 0) {
            int v0_1 = 0;
            int v2_3 = 0;
            while (v2_3 < v1) {
                if (com.boat.jrosbridge.rosbridge.implementation.Base64.IA[p13.charAt(v2_3)] < 0) {
                    v0_1++;
                }
                v2_3++;
            }
            if (((v1 - v0_1) % 4) == 0) {
                int v2_1 = 0;
                int v4_0 = v1;
                while (v4_0 > 1) {
                    v4_0--;
                    if (com.boat.jrosbridge.rosbridge.implementation.Base64.IA[p13.charAt(v4_0)] > 0) {
                        break;
                    }
                    if (p13.charAt(v4_0) == 61) {
                        v2_1++;
                    }
                }
                int v4_4 = ((((v1 - v0_1) * 6) >> 3) - v2_1);
                int v6_2 = new byte[v4_4];
                int v7_1 = 0;
                int v8 = 0;
                while (v8 < v4_4) {
                    int v9 = 0;
                    int v10_0 = 0;
                    while (v10_0 < 4) {
                        int v7_3 = com.boat.jrosbridge.rosbridge.implementation.Base64.IA[p13.charAt(v7_1)];
                        if (v7_3 < 0) {
                            v10_0--;
                        } else {
                            v9 |= (v7_3 << (18 - (v10_0 * 6)));
                        }
                        v10_0++;
                        v7_1++;
                    }
                    int v10_1 = (v8 + 1);
                    v6_2[v8] = ((byte) (v9 >> 16));
                    if (v10_1 >= v4_4) {
                        v8 = v10_1;
                    } else {
                        v8 = (v10_1 + 1);
                        v6_2[v10_1] = ((byte) (v9 >> 8));
                        if (v8 < v4_4) {
                            int v10_2 = (v8 + 1);
                            v6_2[v8] = ((byte) v9);
                            v8 = v10_2;
                        }
                    }
                }
                return v6_2;
            } else {
                return 0;
            }
        } else {
            int v0_2 = new byte[0];
            return v0_2;
        }
    }

    public static final byte[] decode(byte[] p13)
    {
        int v0 = p13.length;
        int v1 = 0;
        int v2_0 = 0;
        while (v2_0 < v0) {
            if (com.boat.jrosbridge.rosbridge.implementation.Base64.IA[(p13[v2_0] & 255)] < 0) {
                v1++;
            }
            v2_0++;
        }
        if (((v0 - v1) % 4) == 0) {
            int v2_3 = 0;
            int v4_0 = v0;
            while (v4_0 > 1) {
                v4_0--;
                if (com.boat.jrosbridge.rosbridge.implementation.Base64.IA[(p13[v4_0] & 255)] > 0) {
                    break;
                }
                if (p13[v4_0] == 61) {
                    v2_3++;
                }
            }
            int v4_4 = ((((v0 - v1) * 6) >> 3) - v2_3);
            int v6_2 = new byte[v4_4];
            int v7_2 = 0;
            int v8 = 0;
            while (v8 < v4_4) {
                int v9 = 0;
                int v10_0 = 0;
                while (v10_0 < 4) {
                    int v7_5 = com.boat.jrosbridge.rosbridge.implementation.Base64.IA[(p13[v7_2] & 255)];
                    if (v7_5 < 0) {
                        v10_0--;
                    } else {
                        v9 |= (v7_5 << (18 - (v10_0 * 6)));
                    }
                    v10_0++;
                    v7_2++;
                }
                int v10_1 = (v8 + 1);
                v6_2[v8] = ((byte) (v9 >> 16));
                if (v10_1 >= v4_4) {
                    v8 = v10_1;
                } else {
                    v8 = (v10_1 + 1);
                    v6_2[v10_1] = ((byte) (v9 >> 8));
                    if (v8 < v4_4) {
                        int v10_2 = (v8 + 1);
                        v6_2[v8] = ((byte) v9);
                        v8 = v10_2;
                    }
                }
            }
            return v6_2;
        } else {
            return 0;
        }
    }

    public static final byte[] decode(char[] p13)
    {
        int v1;
        if (p13 == null) {
            v1 = 0;
        } else {
            v1 = p13.length;
        }
        if (v1 != 0) {
            int v0_1 = 0;
            int v2_2 = 0;
            while (v2_2 < v1) {
                if (com.boat.jrosbridge.rosbridge.implementation.Base64.IA[p13[v2_2]] < 0) {
                    v0_1++;
                }
                v2_2++;
            }
            if (((v1 - v0_1) % 4) == 0) {
                int v2_1 = 0;
                int v4_0 = v1;
                while (v4_0 > 1) {
                    v4_0--;
                    if (com.boat.jrosbridge.rosbridge.implementation.Base64.IA[p13[v4_0]] > 0) {
                        break;
                    }
                    if (p13[v4_0] == 61) {
                        v2_1++;
                    }
                }
                int v4_4 = ((((v1 - v0_1) * 6) >> 3) - v2_1);
                int v6_2 = new byte[v4_4];
                int v7_1 = 0;
                int v8 = 0;
                while (v8 < v4_4) {
                    int v9 = 0;
                    int v10_0 = 0;
                    while (v10_0 < 4) {
                        int v7_3 = com.boat.jrosbridge.rosbridge.implementation.Base64.IA[p13[v7_1]];
                        if (v7_3 < 0) {
                            v10_0--;
                        } else {
                            v9 |= (v7_3 << (18 - (v10_0 * 6)));
                        }
                        v10_0++;
                        v7_1++;
                    }
                    int v10_1 = (v8 + 1);
                    v6_2[v8] = ((byte) (v9 >> 16));
                    if (v10_1 >= v4_4) {
                        v8 = v10_1;
                    } else {
                        v8 = (v10_1 + 1);
                        v6_2[v10_1] = ((byte) (v9 >> 8));
                        if (v8 < v4_4) {
                            int v10_2 = (v8 + 1);
                            v6_2[v8] = ((byte) v9);
                            v8 = v10_2;
                        }
                    }
                }
                return v6_2;
            } else {
                return 0;
            }
        } else {
            int v0_2 = new byte[0];
            return v0_2;
        }
    }

    public static final byte[] decodeFast(String p14)
    {
        int v0 = p14.length();
        int v1_1 = 0;
        if (v0 != 0) {
            int v2_1 = 0;
            int v3 = (v0 - 1);
            while ((v2_1 < v3) && (com.boat.jrosbridge.rosbridge.implementation.Base64.IA[(p14.charAt(v2_1) & 255)] < 0)) {
                v2_1++;
            }
            while ((v3 > 0) && (com.boat.jrosbridge.rosbridge.implementation.Base64.IA[(p14.charAt(v3) & 255)] < 0)) {
                v3--;
            }
            int v4_4;
            if (p14.charAt(v3) != 61) {
                v4_4 = 0;
            } else {
                if (p14.charAt((v3 - 1)) != 61) {
                    v4_4 = 1;
                } else {
                    v4_4 = 2;
                }
            }
            int v5_5 = ((v3 - v2_1) + 1);
            if (v0 > 76) {
                if (p14.charAt(76) == 13) {
                    v1_1 = (v5_5 / 78);
                }
                v1_1 <<= 1;
            }
            int v6_4 = ((((v5_5 - v1_1) * 6) >> 3) - v4_4);
            byte[] v7_2 = new byte[v6_4];
            int v8_3 = 0;
            int v9_0 = 0;
            int v10_1 = ((v6_4 / 3) * 3);
            while (v8_3 < v10_1) {
                byte v12_9 = (v2_1 + 1);
                int v13_1 = (v12_9 + 1);
                byte v12_11 = (v13_1 + 1);
                int v13_3 = (v12_11 + 1);
                int v2_0 = ((((com.boat.jrosbridge.rosbridge.implementation.Base64.IA[p14.charAt(v2_1)] << 18) | (com.boat.jrosbridge.rosbridge.implementation.Base64.IA[p14.charAt(v12_9)] << 12)) | (com.boat.jrosbridge.rosbridge.implementation.Base64.IA[p14.charAt(v13_1)] << 6)) | com.boat.jrosbridge.rosbridge.implementation.Base64.IA[p14.charAt(v12_11)]);
                int v11_1 = (v8_3 + 1);
                v7_2[v8_3] = ((byte) (v2_0 >> 16));
                int v8_0 = (v11_1 + 1);
                v7_2[v11_1] = ((byte) (v2_0 >> 8));
                int v11_2 = (v8_0 + 1);
                v7_2[v8_0] = ((byte) v2_0);
                if (v1_1 <= 0) {
                    v2_1 = v13_3;
                } else {
                    v9_0++;
                    if (v9_0 != 19) {
                    } else {
                        v9_0 = 0;
                        v2_1 = (v13_3 + 2);
                    }
                }
                v8_3 = v11_2;
            }
            if (v8_3 < v6_4) {
                int v9_1 = 0;
                int v10_2 = 0;
                while (v2_1 <= (v3 - v4_4)) {
                    v9_1 |= (com.boat.jrosbridge.rosbridge.implementation.Base64.IA[p14.charAt(v2_1)] << (18 - (v10_2 * 6)));
                    v10_2++;
                    v2_1++;
                }
                int v10_3 = 16;
                while (v8_3 < v6_4) {
                    int v11_4 = (v8_3 + 1);
                    v7_2[v8_3] = ((byte) (v9_1 >> v10_3));
                    v10_3 -= 8;
                    v8_3 = v11_4;
                }
            }
            return v7_2;
        } else {
            int v1_0 = new byte[0];
            return v1_0;
        }
    }

    public static final byte[] decodeFast(byte[] p14)
    {
        int v0 = p14.length;
        int v1_0 = 0;
        if (v0 != 0) {
            int v2_0 = 0;
            int v3 = (v0 - 1);
            while ((v2_0 < v3) && (com.boat.jrosbridge.rosbridge.implementation.Base64.IA[(p14[v2_0] & 255)] < 0)) {
                v2_0++;
            }
            while ((v3 > 0) && (com.boat.jrosbridge.rosbridge.implementation.Base64.IA[(p14[v3] & 255)] < 0)) {
                v3--;
            }
            int v4_3;
            if (p14[v3] != 61) {
                v4_3 = 0;
            } else {
                if (p14[(v3 - 1)] != 61) {
                    v4_3 = 1;
                } else {
                    v4_3 = 2;
                }
            }
            int v5_4 = ((v3 - v2_0) + 1);
            if (v0 > 76) {
                if (p14[76] == 13) {
                    v1_0 = (v5_4 / 78);
                }
                v1_0 <<= 1;
            }
            int v6_4 = ((((v5_4 - v1_0) * 6) >> 3) - v4_3);
            byte[] v7_2 = new byte[v6_4];
            int v8_2 = 0;
            int v9_0 = 0;
            int v10_1 = ((v6_4 / 3) * 3);
            while (v8_2 < v10_1) {
                byte v12_4 = (v2_0 + 1);
                int v13_1 = (v12_4 + 1);
                byte v12_6 = (v13_1 + 1);
                int v13_3 = (v12_6 + 1);
                int v2_9 = ((((com.boat.jrosbridge.rosbridge.implementation.Base64.IA[p14[v2_0]] << 18) | (com.boat.jrosbridge.rosbridge.implementation.Base64.IA[p14[v12_4]] << 12)) | (com.boat.jrosbridge.rosbridge.implementation.Base64.IA[p14[v13_1]] << 6)) | com.boat.jrosbridge.rosbridge.implementation.Base64.IA[p14[v12_6]]);
                int v11_15 = (v8_2 + 1);
                v7_2[v8_2] = ((byte) (v2_9 >> 16));
                int v8_4 = (v11_15 + 1);
                v7_2[v11_15] = ((byte) (v2_9 >> 8));
                int v11_0 = (v8_4 + 1);
                v7_2[v8_4] = ((byte) v2_9);
                if (v1_0 <= 0) {
                    v2_0 = v13_3;
                } else {
                    v9_0++;
                    if (v9_0 != 19) {
                    } else {
                        v9_0 = 0;
                        v2_0 = (v13_3 + 2);
                    }
                }
                v8_2 = v11_0;
            }
            if (v8_2 < v6_4) {
                int v9_1 = 0;
                int v10_2 = 0;
                while (v2_0 <= (v3 - v4_3)) {
                    v9_1 |= (com.boat.jrosbridge.rosbridge.implementation.Base64.IA[p14[v2_0]] << (18 - (v10_2 * 6)));
                    v10_2++;
                    v2_0++;
                }
                int v10_3 = 16;
                while (v8_2 < v6_4) {
                    int v11_2 = (v8_2 + 1);
                    v7_2[v8_2] = ((byte) (v9_1 >> v10_3));
                    v10_3 -= 8;
                    v8_2 = v11_2;
                }
            }
            return v7_2;
        } else {
            int v1_1 = new byte[0];
            return v1_1;
        }
    }

    public static final byte[] decodeFast(char[] p14)
    {
        int v0 = p14.length;
        int v1_0 = 0;
        if (v0 != 0) {
            int v2_0 = 0;
            int v3 = (v0 - 1);
            while ((v2_0 < v3) && (com.boat.jrosbridge.rosbridge.implementation.Base64.IA[p14[v2_0]] < 0)) {
                v2_0++;
            }
            while ((v3 > 0) && (com.boat.jrosbridge.rosbridge.implementation.Base64.IA[p14[v3]] < 0)) {
                v3--;
            }
            int v4_3;
            if (p14[v3] != 61) {
                v4_3 = 0;
            } else {
                if (p14[(v3 - 1)] != 61) {
                    v4_3 = 1;
                } else {
                    v4_3 = 2;
                }
            }
            int v5_3 = ((v3 - v2_0) + 1);
            if (v0 > 76) {
                if (p14[76] == 13) {
                    v1_0 = (v5_3 / 78);
                }
                v1_0 <<= 1;
            }
            int v6_4 = ((((v5_3 - v1_0) * 6) >> 3) - v4_3);
            byte[] v7_2 = new byte[v6_4];
            int v8_2 = 0;
            int v9_0 = 0;
            int v10_1 = ((v6_4 / 3) * 3);
            while (v8_2 < v10_1) {
                byte v12_3 = (v2_0 + 1);
                int v13_1 = (v12_3 + 1);
                byte v12_5 = (v13_1 + 1);
                int v13_3 = (v12_5 + 1);
                int v2_9 = ((((com.boat.jrosbridge.rosbridge.implementation.Base64.IA[p14[v2_0]] << 18) | (com.boat.jrosbridge.rosbridge.implementation.Base64.IA[p14[v12_3]] << 12)) | (com.boat.jrosbridge.rosbridge.implementation.Base64.IA[p14[v13_1]] << 6)) | com.boat.jrosbridge.rosbridge.implementation.Base64.IA[p14[v12_5]]);
                int v11_14 = (v8_2 + 1);
                v7_2[v8_2] = ((byte) (v2_9 >> 16));
                int v8_4 = (v11_14 + 1);
                v7_2[v11_14] = ((byte) (v2_9 >> 8));
                int v11_15 = (v8_4 + 1);
                v7_2[v8_4] = ((byte) v2_9);
                if (v1_0 <= 0) {
                    v2_0 = v13_3;
                } else {
                    v9_0++;
                    if (v9_0 != 19) {
                    } else {
                        v9_0 = 0;
                        v2_0 = (v13_3 + 2);
                    }
                }
                v8_2 = v11_15;
            }
            if (v8_2 < v6_4) {
                int v9_1 = 0;
                int v10_2 = 0;
                while (v2_0 <= (v3 - v4_3)) {
                    v9_1 |= (com.boat.jrosbridge.rosbridge.implementation.Base64.IA[p14[v2_0]] << (18 - (v10_2 * 6)));
                    v10_2++;
                    v2_0++;
                }
                int v10_3 = 16;
                while (v8_2 < v6_4) {
                    int v11_1 = (v8_2 + 1);
                    v7_2[v8_2] = ((byte) (v9_1 >> v10_3));
                    v10_3 -= 8;
                    v8_2 = v11_1;
                }
            }
            return v7_2;
        } else {
            int v1_1 = new byte[0];
            return v1_1;
        }
    }

    public static final byte[] encodeToByte(byte[] p16, boolean p17)
    {
        int v2;
        int v1_0 = 0;
        if (p16 == null) {
            v2 = 0;
        } else {
            v2 = p16.length;
        }
        if (v2 != 0) {
            int v6_0;
            int v3_1 = ((v2 / 3) * 3);
            int v4_1 = ((((v2 - 1) / 3) + 1) << 2);
            if (!p17) {
                v6_0 = 0;
            } else {
                v6_0 = (((v4_1 - 1) / 76) << 1);
            }
            int v6_3 = (v6_0 + v4_1);
            byte[] v7 = new byte[v6_3];
            int v8_0 = 0;
            int v9_0 = 0;
            int v10_0 = 0;
            while (v8_0 < v3_1) {
                int v12_0 = (v8_0 + 1);
                int v13_3 = (v12_0 + 1);
                int v12_4 = (v13_3 + 1);
                int v8_6 = ((((p16[v8_0] & 255) << 16) | ((p16[v12_0] & 255) << 8)) | (p16[v13_3] & 255));
                int v13_6 = (v9_0 + 1);
                v7[v9_0] = ((byte) com.boat.jrosbridge.rosbridge.implementation.Base64.CA[((v8_6 >> 18) & 63)]);
                int v9_7 = (v13_6 + 1);
                v7[v13_6] = ((byte) com.boat.jrosbridge.rosbridge.implementation.Base64.CA[((v8_6 >> 12) & 63)]);
                int v13_7 = (v9_7 + 1);
                v7[v9_7] = ((byte) com.boat.jrosbridge.rosbridge.implementation.Base64.CA[((v8_6 >> 6) & 63)]);
                v9_0 = (v13_7 + 1);
                v7[v13_7] = ((byte) com.boat.jrosbridge.rosbridge.implementation.Base64.CA[(v8_6 & 63)]);
                if (p17) {
                    v10_0++;
                    if ((v10_0 == 19) && (v9_0 < (v6_3 - 2))) {
                        int v13_2 = (v9_0 + 1);
                        v7[v9_0] = 13;
                        v9_0 = (v13_2 + 1);
                        v7[v13_2] = 10;
                        v10_0 = 0;
                    }
                }
                v8_0 = v12_4;
            }
            int v8_1 = (v2 - v3_1);
            if (v8_1 > 0) {
                if (v8_1 == 2) {
                    v1_0 = ((p16[(v2 - 1)] & 255) << 2);
                }
                int v5_1;
                int v1_5 = (v1_0 | ((p16[v3_1] & 255) << 10));
                v7[(v6_3 - 4)] = ((byte) com.boat.jrosbridge.rosbridge.implementation.Base64.CA[(v1_5 >> 12)]);
                v7[(v6_3 - 3)] = ((byte) com.boat.jrosbridge.rosbridge.implementation.Base64.CA[((v1_5 >> 6) & 63)]);
                if (v8_1 != 2) {
                    v5_1 = 61;
                } else {
                    v5_1 = ((byte) com.boat.jrosbridge.rosbridge.implementation.Base64.CA[(v1_5 & 63)]);
                }
                v7[(v6_3 - 2)] = v5_1;
                v7[(v6_3 - 1)] = 61;
            }
            return v7;
        } else {
            int v1_1 = new byte[0];
            return v1_1;
        }
    }

    public static final char[] encodeToChar(byte[] p16, boolean p17)
    {
        int v2;
        int v1_0 = 0;
        if (p16 == null) {
            v2 = 0;
        } else {
            v2 = p16.length;
        }
        if (v2 != 0) {
            int v6_0;
            int v3_1 = ((v2 / 3) * 3);
            int v4_1 = ((((v2 - 1) / 3) + 1) << 2);
            if (!p17) {
                v6_0 = 0;
            } else {
                v6_0 = (((v4_1 - 1) / 76) << 1);
            }
            int v6_3 = (v6_0 + v4_1);
            char[] v7 = new char[v6_3];
            int v8_0 = 0;
            int v9_0 = 0;
            int v10_0 = 0;
            while (v8_0 < v3_1) {
                int v12_0 = (v8_0 + 1);
                int v13_1 = (v12_0 + 1);
                int v12_4 = (v13_1 + 1);
                int v8_6 = ((((p16[v8_0] & 255) << 16) | ((p16[v12_0] & 255) << 8)) | (p16[v13_1] & 255));
                int v13_4 = (v9_0 + 1);
                v7[v9_0] = com.boat.jrosbridge.rosbridge.implementation.Base64.CA[((v8_6 >> 18) & 63)];
                int v9_7 = (v13_4 + 1);
                v7[v13_4] = com.boat.jrosbridge.rosbridge.implementation.Base64.CA[((v8_6 >> 12) & 63)];
                int v13_5 = (v9_7 + 1);
                v7[v9_7] = com.boat.jrosbridge.rosbridge.implementation.Base64.CA[((v8_6 >> 6) & 63)];
                v9_0 = (v13_5 + 1);
                v7[v13_5] = com.boat.jrosbridge.rosbridge.implementation.Base64.CA[(v8_6 & 63)];
                if (p17) {
                    v10_0++;
                    if ((v10_0 == 19) && (v9_0 < (v6_3 - 2))) {
                        int v13_0 = (v9_0 + 1);
                        v7[v9_0] = 13;
                        v9_0 = (v13_0 + 1);
                        v7[v13_0] = 10;
                        v10_0 = 0;
                    }
                }
                v8_0 = v12_4;
            }
            int v8_1 = (v2 - v3_1);
            if (v8_1 > 0) {
                if (v8_1 == 2) {
                    v1_0 = ((p16[(v2 - 1)] & 255) << 2);
                }
                int v5_1;
                int v1_5 = (v1_0 | ((p16[v3_1] & 255) << 10));
                v7[(v6_3 - 4)] = com.boat.jrosbridge.rosbridge.implementation.Base64.CA[(v1_5 >> 12)];
                v7[(v6_3 - 3)] = com.boat.jrosbridge.rosbridge.implementation.Base64.CA[((v1_5 >> 6) & 63)];
                if (v8_1 != 2) {
                    v5_1 = 61;
                } else {
                    v5_1 = com.boat.jrosbridge.rosbridge.implementation.Base64.CA[(v1_5 & 63)];
                }
                v7[(v6_3 - 2)] = v5_1;
                v7[(v6_3 - 1)] = 61;
            }
            return v7;
        } else {
            int v1_1 = new char[0];
            return v1_1;
        }
    }

    public static final String encodeToString(byte[] p2, boolean p3)
    {
        return new String(com.boat.jrosbridge.rosbridge.implementation.Base64.encodeToChar(p2, p3));
    }
}
