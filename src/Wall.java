import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure, CompositeBlock {
    private List<Block> blocks;
    private String color;
    private String material;

    @Override
    public Optional findBlockByColor(String color) {
        List<Optional<Block>> newList = new ArrayList<>();
        for (int i = 0; i < blocks.size(); i++) {
            if(color.equals(blocks.get(i).getColor())){
                newList.add(Optional.ofNullable(blocks.get(i)));
            }
        }
        return newList.get((int)(Math.random()*(newList.size())));
    }

    @Override
    public List findBlocksByMaterial(String material) {
        return blocks.stream().filter(x -> x.getMaterial().equals(material)).collect(Collectors.toList());
    }

    @Override
    public int count() {
        return blocks.size();
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public List getBlocks() {
        return blocks;
    }
}