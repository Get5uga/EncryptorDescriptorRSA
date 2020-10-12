import encryptor.*;

public class Main {
    public static void main(String[] args) {
        GenerationKeys generationKeys = new GenerationKeys();
        generationKeys.generationKeys();

        KeysParameters publicKey = generationKeys.getPublicKey();
        KeysParameters privateKey = generationKeys.getPrivateKey();

        String str = "Methods encryption and description is worked"; //String for processing methods


        int[] encArray = Encryptor.encryption(publicKey, str);//Encryption
        for (int i = 0; encArray.length > i; i++)
            System.out.print(encArray[i] + " ");

        System.out.println("");
        String str1 = Descriptor.description(privateKey, encArray);//Description
        System.out.println(str1);

    }
}
