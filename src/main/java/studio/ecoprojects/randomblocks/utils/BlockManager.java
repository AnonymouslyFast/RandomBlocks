package studio.ecoprojects.randomblocks.utils;

import org.bukkit.Material;

import java.util.*;
import java.util.stream.Collectors;

public class BlockManager {

    public static HashMap<Material, Material> Materials = new HashMap<>();


    private static void Init() {
        List<Material> mats = Arrays.stream(Material.values()).filter(Material::isBlock).collect(Collectors.toList());
        for (Material mat : mats) {
            Material counterMat;
            do {
                counterMat = mats.get(new Random().nextInt(0, mats.size()-1));
            } while (Materials.containsKey(counterMat)&& counterMat == mat && mat == Material.AIR);
            Materials.put(mat, counterMat);
        }
    }


    public static void Start() {
        if (Materials.isEmpty()) {
            Init();
        }
    }

    public static Material GetCounterMaterial(Material mat) {
        return Materials.get(mat);
    }

}
