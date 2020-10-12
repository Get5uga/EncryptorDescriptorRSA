package encryptor;

public class KeysParameters {
    private int e, n;

    void setKey(int e, int n) {
        this.e = e;
        this.n = n;
    }

    int getE() {
        return e;
    }

    int getN() {
        return n;
    }
}
