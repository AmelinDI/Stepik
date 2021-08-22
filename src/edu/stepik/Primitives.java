package edu.stepik;

public class Primitives {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf(42) == 42);
        System.out.println(Long.valueOf(42L).equals(new Long(42L)));
        System.out.println(new Integer(42) == new Integer(42));
        System.out.println(Integer.valueOf(42).equals(42L));
        System.out.println(Long.valueOf(42L).equals(42));

        System.out.println();
        System.out.println(reverse(12345));
        System.out.println(Integer.toHexString(reverseByte(0x00000012)));

    }


    static int reverse(int n) {
        int result = 0;
        int c;

        while (n>0){
            c = n%10;
            n = n/10;
            result = result*10 + c;
        }

        return result;
    }


    static int reverseByte(int n) {
        int result = 0;

//        if (n!=0xfe01ccd1) throw new RuntimeException(Integer.toHexString(n));

        for (int i = 0; i < 4; i++) {
            result = result<<8;
            result += n%256;
            n = n >>> 8;
        }

        return result;
    }

}
