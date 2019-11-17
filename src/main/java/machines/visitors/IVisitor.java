package machines.visitors;

import machines.PC;
import machines.CPU;
import machines.Memoire;

public interface IVisitor {
    void visit(PC pc);
    void visit(CPU cpu);
    void visit(Memoire mem);
}