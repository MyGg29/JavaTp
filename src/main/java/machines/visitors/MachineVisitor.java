package machines.visitors;

import machines.CPU;
import machines.Memoire;
import machines.PC;

public class MachineVisitor implements IVisitor {

    @Override
    public void visit(PC pc) {
        System.out.println("Visiting pc...");
        System.out.println(pc);
    }

    @Override
    public void visit(CPU cpu) {
        System.out.println("Visiting cpu");
        System.out.println(cpu);
    }

    @Override
    public void visit(Memoire mem) {
        System.out.println("Visiting memory");
        System.out.println(mem);
    }

}
