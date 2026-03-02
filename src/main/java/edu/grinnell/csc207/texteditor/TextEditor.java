package edu.grinnell.csc207.texteditor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

/**
 * The driver for the TextEditor Application.
 */
public class TextEditor {

    /**
     * Clears the screen and renders the current state of the gapBuffer
     * @param args
     */

    public static void drawBuffer(GapBuffer buf, Screen screen) throws IOException {
        screen.clear();
        
        for (int i = 0; i < buf.getSize(); i++){
            char c = buf.getChar(i);
            TextCharacter tc = TextCharacter.fromCharacter(c)[0];
            screen.setCharacter(i, 0, tc);
        }

        screen.setCursorPosition(new TerminalPosition(buf.getCursorPosition(), 0));
        screen.refresh();
    }

    /**
     * The main entry point for the TextEditor application.
     * @param args command-line arguments.
     * @throws IOException if file or terminal operations fail.
     */
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java TextEditor <filename>");
            System.exit(1);
        }

        String fileName = args[0];
        Path path = Paths.get(fileName);
        GapBuffer buf = new GapBuffer();

        if(Files.exists(path)){
            String content = Files.readString(path);
            for(int i = 0; i < content.length(); i++){
                buf.insert(content.charAt(i));
            }
        }

        DefaultTerminalFactory factory = new DefaultTerminalFactory();
        Screen screen = factory.createScreen();
        screen.startScreen();

        boolean isRunning = true;
        while (isRunning) {
            drawBuffer(buf, screen);
            KeyStroke stroke = screen.readInput();
            KeyType type = stroke.getKeyType();

            if (type == KeyType.Escape){
                isRunning = false;
            } else if (type == KeyType.Character){
                char typedChar = stroke.getCharacter();
                buf.insert(typedChar); 
            } else if (type == KeyType.Backspace){
                buf.delete();
            } else if (type == KeyType.ArrowLeft){
                buf.moveLeft();
            } else if (type == KeyType.ArrowRight){
                buf.moveRight();
            }
        }

        screen.stopScreen();
        
        String finalOutput = buf.toString();
        Files.writeString(path, finalOutput);

        System.out.println("File Saved to " + fileName);
    }
}
