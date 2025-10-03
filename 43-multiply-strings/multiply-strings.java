import java.math.BigInteger;

class Solution {
    public String multiply(String a, String b) {
        return new BigInteger(a).multiply(new BigInteger(b)).toString();
    }
}
