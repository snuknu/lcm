public class AllTests {

    public static void main(String[] args) {
        
        // TEST PRIME NUMBER CLASS
        System.out.println("TEST PRIME NUMBER CLASS");

        PrimeNumbers primeNumbers = new PrimeNumbers();
        primeNumbers.setLimite(100);

        System.out.println(primeNumbers.next());
        System.out.println(primeNumbers.next());
        System.out.println(primeNumbers.next());
        System.out.println(primeNumbers.getAll());
        System.out.println();

        // TEST LCM CALCULATOR
        System.out.println("TEST LCM CALCULATOR");

        System.out.println((new LCM(48, 84)).calculate());
        System.out.println((new LCM(4, 8, 12)).calculate());
        System.out.println((new LCM(60, 45, 27)).calculate());
        System.out.println((new LCM(80, 20, 25)).calculate());
        System.out.println((new LCM(5, 10, 25, 50, 100)).calculate());

    }
}
