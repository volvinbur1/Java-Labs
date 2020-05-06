import java.util.ArrayList;
import java.util.List;

public class MonteCarloSimulation {
    private long globalSuitablePoints = 0;
    private long globalIterations = 0;
    private int threadsNumber = 0;
    public MonteCarloSimulation(int threadsNumber, long globalIterationsNumber) {
        if (threadsNumber > 0)
            this.threadsNumber = threadsNumber;
        if (globalIterationsNumber > 0)
            this.globalIterations = globalIterationsNumber;
    }

    private List<Executor> executors = new ArrayList<>();
    private List<Thread> threads = new ArrayList<>();

    public final long GetIterations() {
        return globalIterations;
    }
    public final long GetSuitablePoints() {
        return globalSuitablePoints;
    }

    public double CalculatePi() throws InterruptedException {
        for (int i = 0; i < threadsNumber; i++) {
            Executor executor = new Executor(globalIterations / threadsNumber);
            Thread thread = new Thread(executor);
            thread.start();
            executors.add(executor);
            threads.add(thread);
        }

        for (Thread thread : threads) {
            if (thread.isAlive())
                thread.join();
        }
        globalIterations = 0;
        for (Executor executor : executors) {
            globalSuitablePoints += executor.GetSuitablePoints();
            globalIterations += executor.GetThreadIteration();
        }

        return (globalSuitablePoints * 1.0 / globalIterations) * 4;
    }

}
