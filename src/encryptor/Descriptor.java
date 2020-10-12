package encryptor;

import java.math.BigInteger;

public class Descriptor {
    public static String description(KeysParameters privateKey, int[] encArray){
        char[] array = new char[encArray.length];
        StringBuilder str = new StringBuilder();
        for (int i = 0; encArray.length > i; i++){
            array[i] = (char) toProduceDescription(privateKey, encArray[i]);
            str.append(array[i]);
        }

        return str.toString();
    }

    private static int toProduceDescription(KeysParameters privateKey, int c) {//выполняет дешифрование
        BigInteger resultBig = new BigInteger(String.valueOf(c));
        BigInteger cBig = new BigInteger(String.valueOf(c));
        BigInteger n = new BigInteger(String.valueOf(privateKey.getN()));

        for (int i = 1; i < privateKey.getE(); i++)
            resultBig = resultBig.multiply(cBig);
        resultBig = resultBig.mod(n);
        int result = resultBig.intValue();
        return result;
    }

}
