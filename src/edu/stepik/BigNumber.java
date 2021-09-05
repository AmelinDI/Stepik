package edu.stepik;

interface BigNumber extends Comparable {
    BigNumber add(BigNumber bigNumber);

    BigNumber sub(BigNumber bigNumber);
}

class MyBigNumber implements BigNumber {

    private final String number;
    private final Boolean positive;

    public static void main(String[] args) {
        MyBigNumber myBigNumber1 = new MyBigNumber("-38027450742057608221309764383410169802626");
        MyBigNumber myBigNumber2 = new MyBigNumber("-38027450742057608221309764383410169802626");
        int cmpResult = myBigNumber1.compareTo(myBigNumber2);

        System.out.print(myBigNumber1);
        if (cmpResult > 0) {
            System.out.print('>');
        } else if (cmpResult == 0) {
            System.out.print('=');
        } else {
            System.out.print('<');
        }
        System.out.println(myBigNumber2);
        System.out.println();

        System.out.println(myBigNumber1 + " + " + myBigNumber2 + " = " + myBigNumber1.add(myBigNumber2));
        System.out.println(myBigNumber1 + " - " + myBigNumber2 + " = " + myBigNumber1.sub(myBigNumber2));
    }

    public MyBigNumber(String number) {
        String tmpNumber = number.trim();
        switch (tmpNumber.charAt(0)) {
            case '-':
                positive = false;
                this.number = tmpNumber.substring(1);
                break;
            case '+':
                positive = true;
                this.number = tmpNumber.substring(1);
                break;
            default:
                positive = true;
                this.number = tmpNumber;
        }
    }

    @Override
    public BigNumber add(BigNumber bigNumber) {
        MyBigNumber extNumber = (MyBigNumber) bigNumber;

        if (this.positive) {
            if (extNumber.positive) { // + +
                return new MyBigNumber(pureAdd(extNumber.number));

            } else { // + -
                int cmpResult = pureCompareTo(extNumber);
                if (cmpResult == 0) {
                    return new MyBigNumber("0");
                }
                if (pureCompareTo(extNumber) > 0) {
                    return new MyBigNumber(pureSub(this.number, extNumber.number));
                }
                return new MyBigNumber('-' + pureSub(extNumber.number, this.number));
            }
        }

        if (extNumber.positive) { // - +
            if (pureCompareTo(extNumber) > 0) {
                return new MyBigNumber('-' + pureSub(this.number, extNumber.number));
            }
            return new MyBigNumber(pureSub(extNumber.number, this.number));
        }

        // - -
        return new MyBigNumber('-' + pureAdd(extNumber.number));
    }


    @Override
    public BigNumber sub(BigNumber bigNumber) {
        MyBigNumber extNumber = (MyBigNumber) bigNumber;

        if (this.positive) {
            if (extNumber.positive) { // + +
                int cmpResult = pureCompareTo(extNumber);
                if (cmpResult == 0) {
                    return new MyBigNumber("0");
                }
                if (pureCompareTo(extNumber) > 0) {
                    return new MyBigNumber(pureSub(this.number, extNumber.number));
                }
                return new MyBigNumber('-' + pureSub(extNumber.number, this.number));
            } else { // + -
                return new MyBigNumber(pureAdd(extNumber.number));
            }
        }

        if (extNumber.positive) { // - +
            return new MyBigNumber('-' + pureAdd(extNumber.number));
        }

        // - -
        if (pureCompareTo(extNumber) > 0) {
            return new MyBigNumber('-' + pureSub(this.number, extNumber.number));
        }
        return new MyBigNumber(pureSub(extNumber.number, this.number));
    }


    @Override
    public int compareTo(Object o) {
        MyBigNumber cmpNumber;
        if (o instanceof MyBigNumber) {
            cmpNumber = (MyBigNumber) o;
        } else {
            cmpNumber = new MyBigNumber(o.toString());
        }

        if (this.positive && !cmpNumber.positive) {
            return 1;
        }

        if (!this.positive && cmpNumber.positive) {
            return -1;
        }

        if (!cmpNumber.positive && !this.positive) {
            if (number.length() == cmpNumber.number.length()) {
                return -number.compareTo(cmpNumber.number);
            }
            return -number.length() - cmpNumber.number.length();
        }

        // Each value is positive
        return pureCompareTo(cmpNumber);
    }


    @Override
    public String toString() {
        if (positive) {
            return number;
        }
        return '-' + number;
    }


    private int pureCompareTo(MyBigNumber cmpNumber) {
        if (number.length() == cmpNumber.number.length()) {
            return number.compareTo(cmpNumber.number);
        }
        return number.length() - cmpNumber.number.length();
    }


    private String pureAdd(String extNumber) {
        StringBuilder sBuilder = new StringBuilder();
        int nextInt;
        int overflow = 0;
        int thisLength = this.number.length();
        int extLength = extNumber.length();
        int maxLength = Math.max(thisLength, extLength);

        for (int i = 1; i <= maxLength; i++) {
            int int1;
            int int2;
            if ((thisLength - i) >= 0) {
                int1 = this.number.charAt(thisLength - i) - 48;
            } else {
                int1 = 0;
            }
            if ((extLength - i) >= 0) {
                int2 = extNumber.charAt(extLength - i) - 48;
            } else {
                int2 = 0;
            }
            nextInt = int1 + int2 + overflow;
            if (nextInt > 9) {
                nextInt = nextInt - 10;
                overflow = 1;
            } else {
                overflow = 0;
            }
            sBuilder.insert(0, nextInt);
        }

        if (overflow == 1) {
            sBuilder.insert(0, '1');
        }
        return sBuilder.toString();
    }


    private String pureSub(String bigArg, String smallArg) {
        StringBuilder sBuilder = new StringBuilder();
        int nextInt;
        int shortFall = 0;
        int bigLength = bigArg.length();
        int smallLength = smallArg.length();

        for (int i = 1; i <= bigLength; i++) {
            int int1 = bigArg.charAt(bigLength - i) - 48;
            int int2;

            if ((smallLength - i) >= 0) {
                int2 = smallArg.charAt(smallLength - i) - 48;
            } else {
                int2 = 0;
            }

            nextInt = int1 - int2 - shortFall;
            if (nextInt < 0) {
                nextInt = nextInt + 10;
                shortFall = 1;
            } else {
                shortFall = 0;
            }
            sBuilder.insert(0, nextInt);
        }

        if (shortFall == 1) {
            throw new RuntimeException("shortFall in final check");
        }

        int i = 0;
        while (i<(bigLength-1) && sBuilder.charAt(i)=='0') {
            i++;
        }
        if (i>0) {
            sBuilder.delete(0, i);
        }

        return sBuilder.toString();
    }
}