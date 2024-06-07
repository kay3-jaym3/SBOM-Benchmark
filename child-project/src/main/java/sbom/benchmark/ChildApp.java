package sbom.benchmark;

public class ChildApp {
    public static void main(String[] args) {
        RandomNumberGenerator randomNo = new RandomNumberGenerator();
        int randomNum = randomNo.generateRandomNumber(1, 100);
        System.out.println("Random Number: " + randomNum);
    }
}
