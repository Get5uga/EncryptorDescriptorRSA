package encryptor;

import java.math.BigInteger;

public class Encryptor {

    public static int[] encryption(KeysParameters publicKey, String str){
        char[] array = str.toCharArray();
        int[] encArray = new int[array.length];
        for (int i = 0; array.length > i; i++)
            encArray[i] = toProduceEncryption(publicKey, array[i]);

        return encArray;
    }

    private static int toProduceEncryption(KeysParameters publicKey, int m) {//выполняет шифрование
        BigInteger resultBig = new BigInteger(String.valueOf(m));
        BigInteger mBig = new BigInteger(String.valueOf(m));
        BigInteger n = new BigInteger(String.valueOf(publicKey.getN()));

        for (int i = 1; i < publicKey.getE(); i++)
            resultBig = resultBig.multiply(mBig);
        resultBig = resultBig.mod(n);
        int result = resultBig.intValue();
        return result;
    }

}