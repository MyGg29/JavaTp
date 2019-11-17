package machines.visitors;

import machines.CPU;
import machines.Memoire;
import machines.PC;

public class DrawVisitor implements IVisitor {

    @Override
    public void visit(PC pc) {
        System.out.println("Visiting pc...");
        System.out.println("\n"
                         + "                  .----.\n"
                         + "      .---------. | == |\n"
                         + "      |.-\"\"\"\"\"-.| |----|\n"
                         + "      ||       || | == |\n"
                         + "      ||       || |----|\n"
                         + "      |'-.....-'| |::::|\n"
                         + "      `\"\")---(\"\"` |___.|\n"
                         + "     /:::::::::::\\\" _  \"\n"
                         + "    /:::=======:::\\`\\`\\\n"
                         + "jgs `\"\"\"\"\"\"\"\"\"\"\"\"\"`  '-'\n");
    }

    @Override
    public void visit(CPU cpu) {
        System.out.println("Visiting cpu");
        System.out.println(""
+ " ,adPPYba, 8b,dPPYba,  88       88      \n"
+ "a8\"     \"\" 88P'    \"8a 88       88  \n"
+ "8b         88       d8 88       88      \n"
+ "\"8a,   ,aa 88b,   ,a8\" \"8a,   ,a88   \n"
+ " `\"Ybbd8\"' 88`YbbdP\"'   `\"YbbdP'Y8  \n"  
+ "           88                           \n"
+ "           88                           \n"
        );
    }

    @Override
    public void visit(Memoire mem) {
        System.out.println("Visiting memory");
        System.out.println(mem);
    }

}
