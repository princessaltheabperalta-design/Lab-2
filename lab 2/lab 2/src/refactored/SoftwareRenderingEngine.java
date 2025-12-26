package refactored;

/**
 * Bridge Pattern - Concrete Implementation
 * Software-based rendering engine
 */
public class SoftwareRenderingEngine implements RenderingEngine {
    @Override
    public void render(String content) {
        System.out.println("Software rendering: " + content);
    }
}

