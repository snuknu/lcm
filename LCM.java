import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Least Common Multiple LCM Calculator.
 *
 * @author Eric Azevedo Carvalho
 */
public class LCM
{

    private ArrayList<Integer> elements;

    public LCM(Integer... values)
    {
        if (values.length > 0)
        {
            this.elements = new ArrayList<>(new HashSet<>(Arrays.asList(values)));
        }
    }

    private boolean isDivisible(List<Integer> passo, Integer np)
    {
        for (Integer fator : passo)
        {
            if (fator % np == 0)
            {
                return true;
            }
        }
        return false;
    }

    public Integer calculate()
    {
        Integer lcm = 1;
        Integer factoringCheck = 0;

        Collections.sort(elements);

        List<List<Integer>> steps = new ArrayList<>();
        steps.add(new ArrayList<>(elements));

        List<Integer> decomposition = new ArrayList<>();

        PrimeNumbers pn = new PrimeNumbers(elements.get(elements.size() - 1));
        Integer currentFactor = pn.next();

        while (factoringCheck != 1)
        {
            List<Integer> lastStep = steps.get(steps.size() - 1);
            List<Integer> newStep = null;

            if (isDivisible(lastStep, currentFactor))
            {
                newStep = new ArrayList<>();
                decomposition.add(pn.getAtual());
                steps.add(newStep);

                for (Integer factor : lastStep)
                {
                    if (factor % currentFactor == 0)
                    {
                        newStep.add(factor / currentFactor);
                    }
                    else
                    {
                        newStep.add(factor);
                    }
                }
            }
            else
            {
                currentFactor = pn.next();
            }

            if (newStep != null)
            {
                factoringCheck = 1;
                for (Integer factor : newStep)
                {
                    if (factor != 1)
                    {
                        factoringCheck = 0;
                        break;
                    }
                }
            }
        }

        for (Integer factor : decomposition)
        {
            lcm *= factor;
        }

        return lcm;
    }
}
