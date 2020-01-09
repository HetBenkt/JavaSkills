package nl.bos;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class HelloWorld {
    private long window;

    public void run() {
        glfwFreeCallbacks(window);
    }
}
