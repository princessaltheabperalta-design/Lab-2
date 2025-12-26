package refactored;

/**
 * Bridge Pattern - Concrete Implementation
 * Hardware-accelerated rendering engine
 */
public class HardwareRenderingEngine implements RenderingEngine {
    @Override
    public void render(String content) {
        System.out.println("Hardware rendering: " + content);
    }
}

