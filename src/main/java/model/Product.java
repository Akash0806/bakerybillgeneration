package main.java.model;

import main.java.pack.Pack;

import java.util.ArrayList;
import java.util.List;

public abstract class Product {
    private List<Pack> packs;

    public abstract String name();

    public abstract String code();

    public List<Pack> getPacks() {
        if (packs == null) {
            packs = new ArrayList<>();
        }
        return packs;
    }

    public void addPack(Pack pack) {
        getPacks().add(pack);
    }

}
