/**
 * A class determining which renderer to use
 */
public class RendererFactory {
    /**
     * Default constructor
     */
    public RendererFactory(){}

    /**
     * Creates renderer upon type requested
     * @param type String of renderer requested
     * @param size int size of board
     * @return renderer created
     */
    public static Renderer buildRenderer(String type, int size) {
        return type.equals("console") ? new ConsoleRenderer(size) : new VoidRenderer();
    }
}
