package Assignment;
import java.util.List;
public class process2
{
    public String pid;
    public int burst;
    public int arrival;
    public int waiting;
    public int turnaround;
    public double quantum;
    public int priority;

    process2(String x, int y, int z)  
    {
        pid = x;
        arrival = y;
        burst = z;
    }

    process2(int x) 
    {
        burst = x;
        pid = "context switch";
    }

    process2(String name, int x, int y, int z) 
    {
        pid = name;
        arrival = x;
        burst = y;
        priority = z;
    }
}