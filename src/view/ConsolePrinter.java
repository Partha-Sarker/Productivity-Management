package view;

public class ConsolePrinter {
    private int dashCount = 100, gapNewLineCount = 2;
    private char lineChar = '-';

    public ConsolePrinter() {
//        displayHorizontalLine();
    }

    public void displayHorizontalLine() {
        for (int i = 0; i < dashCount; i++) {
            System.out.print(lineChar);
        }
        System.out.println();
    }

    public void addGap() {
        for (int i = 0; i < gapNewLineCount; i++) {
            System.out.println();
        }
    }

    public void displayNewLine() {
        System.out.println();
    }

    public void displayText(String text) {
        System.out.print(text);
    }

    public void displayTextWithNewLine(String text) {
        System.out.println(text);
    }
}
