package pgdp.sim.helpers;

import pgdp.sim.Cell;
import pgdp.sim.Plant;
import pgdp.sim.Simulation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Wrapper for the <code>Simulation</code> class.<br>
 * Can be used to single-step through the <b>simulation</b> and get readable feedback on every step.
 */
public class SimulationVisualizer extends Simulation {
    private final Cell[] cells;

    public SimulationVisualizer(Cell[] cells, int width, int height) {
        super(cells, width, height);

        // Save reference to cells to use for logging in tick
        this.cells = cells;
    }

    @Override
    public void tick() {
        System.out.println(Arrays.toString(cells));

        super.tick();
    }

    /**
     * Starts the simulation process.<br>
     * <p></p>
     * <b>Controls</b><br>
     * <b>Enter</b>: Step to next tick.<br>
     * <b>exit</b>: Leave simulation.
     * @param useEmoji Whether to render the output using emojis or normal text.
     */
    public void simulate(boolean useEmoji) {
        Scanner sc = new Scanner(System.in);

        while (!sc.nextLine().equals("exit")) {
            this.tick();
        }

        System.out.println("Exited the simulation loop!");
    }

    public static void main(String[] args) {
        Cell[] cells = new Cell[9];
        cells[0] = new Plant();

        SimulationVisualizer s = new SimulationVisualizer(cells, 3, 3);
        s.simulate(true);
    }
}
