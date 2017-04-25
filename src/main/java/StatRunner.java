import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Nick on 4/24/17.
 */
public class StatRunner {
    private static ArrayList<Player> players = new ArrayList<>();

    public StatRunner(ArrayList<Player> p)
    {
        players = p;
    }
    public String runEm()
    {
        String result = "";
        result += "Sum of all points: " + statSum() + "\n";
        result += "Total number of rolls: " + statNumRolls() + "\n";
        result += "Average roll: " + statAverage() + "\n";
        result += "Median roll: " + statMedian() + "\n";
        result += "Max roll: " + statMaxRoll() + "\n";
        result += "Min roll: " + statMinRoll() + "\n";
        result += "Standard Range: " + statRangeNormal() + "\n";
        result += "Standard deviation: " + statStdDev() + "\n";
        result += "Median Skew: " + statMedianSkew() + "\n";
        result += "Mode Skew: " + statModeSkew() + "\n";
        result += "Mode: " + statMode() + "\n";
        result += "Variance: " + statVariance();
        return result;
    }
    //Sum of all points scored
    static int statSum()
    {
        Integer sum = 0;

        for (Player i: players)
        {
            sum += i.getTotalPoints();
        }

        return sum;
    }

    //sum of number of total rolls
    static int statNumRolls()
    {
        int numRolls = 0;
        for(Player i : players)
        {
            numRolls += i.getRolls().size();
        }
        return numRolls;
    }

    //average roll for entire data set
    static double statAverage()
    {
        return ((double)statSum() / (double)statNumRolls());
    }

    //sorts entire data set
    static ArrayList<Integer> statSort()
    {
        ArrayList<Integer> sorted = new ArrayList<>();
        for(Player i : players)
        {
            for (int j : i.getRolls())
            {
                sorted.add(j);
            }
        }
        Collections.sort(sorted);

        return sorted;
    }
    //median roll
    static double statMedian()
    {
        double median;

        ArrayList sorted = new ArrayList(statSort());

        if(sorted.size() % 2 == 0)
        {
            median = ((double)(int)sorted.get(sorted.size() / 2) + (double)(int)sorted.get((sorted.size() / 2) + 1)) / 2;
        }
        else
        {
            median = (double)(int)sorted.get((sorted.size() / 2) + 1);
        }

        return median;
    }
    //highest roll
    static int statMaxRoll()
    {
        return Collections.max(statSort());
    }
    //smallest roll
    static int statMinRoll()
    {
        return Collections.min(statSort());
    }

    static int statRangeNormal()
    {
        return (statMaxRoll() - statMinRoll());
    }

    static double statStdDev()
    {
        double deviation, devSum = 0, mean;

        mean = statAverage();
        ArrayList<Integer> dataset = statSort();
        for(int i = 0; i < dataset.size(); i++)
        {
            devSum += Math.pow((mean - (double)(int)dataset.get(i)), 2);
        }

        deviation = Math.pow((devSum / (double)dataset.size()), 0.5);

        return deviation;
    }


    static double statMedianSkew()
    {
        return ((statAverage() - statMedian()) / statStdDev());
    }

    static int statMode()
    {
        ArrayList sorted = new ArrayList(statSort());
        int mode = 0, modeCount = 0, temp = 0, current;

        current = (int)sorted.get(0);

        for(int i = 0; i < sorted.size(); i++)
        {
            if(((int)sorted.get(i)) == current)
            {
                temp++;

                if(temp > modeCount)
                {
                    modeCount = temp;
                    mode = (int)sorted.get(i);
                }
            }
            else
            {
                current = (int)sorted.get(i);
                temp = 0;
            }
        }

        return mode;
    }

    static double statVariance()
    {
        return Math.pow(statStdDev(), 2);
    }

    static double statModeSkew()
    {
        return (statAverage() - statMode()) / statStdDev();
    }



}
