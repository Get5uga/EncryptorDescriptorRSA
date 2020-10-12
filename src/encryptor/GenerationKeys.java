package encryptor;

import java.util.ArrayList;
import java.util.List;

public class GenerationKeys {

    private final int COUNT_SN = 50;
    private KeysParameters publicKey = new KeysParameters();
    private KeysParameters privateKey = new KeysParameters();

    public void generationKeys(){
        getKeyParam();
    }

    private void getKeyParam() {
        ArrayList<Integer> arraySimpleNum;
        int p=0, q = 0, n = 0, fi, e = 0, d=0;
        while (p == q || n < 256){//generation two Prime numbers for receivings "N"
            p = getRandomNum();
            q = getRandomNum();
            arraySimpleNum = getFirstPrimes(COUNT_SN);
            p = arraySimpleNum.get(p);
            q = arraySimpleNum.get(q);
            n = p * q;//parameter public key
        }
        fi = (p - 1) * (q - 1);//get num "fi"
        e = getEVariable(fi);//get open exponent
        d = getDVariable(fi, e);//get "D" is parameter private key
        publicKey.setKey(e, n);//setting the generated key parameters
        privateKey.setKey(d, n);//setting the generated key parameters
    }

    private int getDVariable(int fi, int e) {
        double d;
        int k = 1;
        while ((fi * k + 1) % e != 0) k++;
        d = (fi * k +1) / e;
        return (int) d;
    }

    private int getEVariable(int fi) {
        ArrayList<Integer> array;
        array = getFirstPrimes(100);
        int i =0;
        while (fi % array.get(i) == 0){
        i++;
        }
        return array.get(i);
    }

    private int getRandomNum() {
        double random = Math.random() * COUNT_SN;
        return (int) random;
    }

    public KeysParameters getPublicKey() {
        return publicKey;
    }

    public KeysParameters getPrivateKey() {
        return privateKey;
    }

    private ArrayList<Integer> getFirstPrimes(int count) {//return ArrayList with int value Prime numbers in the amount of "count"
        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 3; primes.size() < count; i += 2) {
            if (isPrime(i, primes)) {
                primes.add(i);
            }
        }
        return primes;
    }

    private boolean isPrime(int n, List<Integer> primes) {//checking a Prime number or not
        double sqrt = Math.sqrt(n);
        for (int i = 0; i < primes.size(); i++) {
            int prime = primes.get(i);
            if (prime > sqrt) {
                return true;
            }
            if (n % prime == 0) {
                return false;
            }
        }
        return true;
    }
}
