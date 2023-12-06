package Assignment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Priority_Scheduling {

    List<process2> input = new ArrayList<>();
    List<process2> output = new ArrayList<>();
    double avgWaiting = 0;
    double avgTurnaround = 0;

    Priority_Scheduling(List<process2> in) {
        input = in;
    }

    List<process2> Sort(List<process2> p) {
        for (int i = 0; i < p.size(); i++) {
            for (int k = i + 1; k < p.size(); k++) {
                if (p.get(i).arrival > p.get(k).arrival) {
                    Collections.swap(p, i, k);
                } else if (input.get(i).arrival == input.get(k).arrival && input.get(k).priority < input.get(i).priority) {
                    Collections.swap(p, i, k);
                }
            }
        }
        return p;
    }

    List<process2> SortPri(List<process2> p) {
        for (int i = 0; i < p.size(); i++) {
            for (int k = i + 1; k < p.size(); k++) {
                if (p.get(k).priority < p.get(i).priority) {
                    Collections.swap(p, i, k);
                }
            }
        }
        return p;
    }
    boolean contains(List<process2> p, String id) {

        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).pid == id) {
                return true;
            }
        }
        return false;
    }

    public void Process() {
        Sort(input);
        int time = input.get(0).arrival;

        int y = 0;

        while (output.size() != input.size()) {
            List<process2> ready = new ArrayList<>();
            for (int i = 0; i < input.size(); i++) {
                if (time >= input.get(i).arrival && contains(output, input.get(i).pid) == false) {
                    ready.add(input.get(i));
                }
            }
            SortPri(ready);
            ready.get(ready.size() - 1).priority = ready.get(ready.size() - 1).priority - 1;
            output.add(ready.get(0));
            output.get(y).waiting = time - output.get(y).arrival;
            time = time + output.get(y).burst;
            output.get(y).turnaround = time - output.get(y).arrival;

            avgWaiting = avgWaiting + output.get(y).waiting;
            avgTurnaround = avgTurnaround + output.get(y).turnaround;
            y++;

        }
        print(output);
    }

    void print(List<process2> p) {
        for (int i = 0; i < p.size(); i++) {
            System.out.println("process name: " + p.get(i).pid
                    + " || waiting time: " + p.get(i).waiting
                    + " || Turnaround time: " + p.get(i).turnaround);

        }
        System.out.println("Average Waiting time: " + avgWaiting / output.size());
        System.out.println("Average Turnaround time: " + avgTurnaround / output.size());
    }
}