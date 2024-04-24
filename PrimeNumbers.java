import java.util.ArrayList;
import java.util.List;

/**
 * Prime numbers are natural numbers that are divisible by only 1 and the number itself.
 *
 * @author Eric Azevedo Carvalho
 */
public class PrimeNumbers
{

    private static final Integer SMALLEST_PRIME_NUMBER = 2;

    private Integer limit;
    private Integer current;
    private List<Integer> primeNumberList;
    private boolean start = false;

    public PrimeNumbers()
    {
        this.limit = Integer.MAX_VALUE;
        reset();
    }

    public PrimeNumbers(Integer limite)
    {
        this.limit = limite;
        reset();
    }

    public void setLimite(Integer limite)
    {
        this.limit = limite;
    }

    public final void reset()
    {
        current = SMALLEST_PRIME_NUMBER;
        primeNumberList = new ArrayList<>();
        primeNumberList.add(current);
    }

    public Integer getAtual()
    {
        return current;
    }

    public Integer next()
    {
        if (!start)
        {
            start = true;
            return current;
        }

        for (int n = current + 1; n <= limit; n++)
        {
            boolean isPrimeNumber = true;
            int maximumDivisor = n / 2;

            for (int divisor = SMALLEST_PRIME_NUMBER; divisor <= maximumDivisor; divisor++)
            {
                if (n % divisor == 0)
                {
                    isPrimeNumber = false;
                    break;
                }
            }
            if (isPrimeNumber)
            {
                return current = n;
            }
        }
        return current;
    }

    public List<Integer> getAll()
    {
        PrimeNumbers tmp = new PrimeNumbers(this.limit);

        int previous = 0;
        int current = tmp.next();

        while (previous != current)
        {
            tmp.primeNumberList.add(previous = current);
            current = tmp.next();
        }
        return tmp.primeNumberList;
    }

}
