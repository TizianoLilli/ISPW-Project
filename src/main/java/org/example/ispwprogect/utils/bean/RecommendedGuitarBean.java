package org.example.ispwprogect.utils.bean;

import java.util.List;

public class RecommendedGuitarBean {
    private List<String> selectedArtists;
    private String recommendedGuitarModel;

    // Costruttore senza argomenti
    public RecommendedGuitarBean() {}

    // Costruttore con parametri
    public RecommendedGuitarBean(List<String> selectedArtists, String recommendedGuitarModel) {
        this.selectedArtists = selectedArtists;
        this.recommendedGuitarModel = recommendedGuitarModel;
    }

    // Getter e Setter per selectedArtists
    public List<String> getSelectedArtists() {
        return selectedArtists;
    }

    public void setSelectedArtists(List<String> selectedArtists) {
        this.selectedArtists = selectedArtists;
    }

    // Getter e Setter per recommendedGuitarModel
    public String getRecommendedGuitarModel() {
        return recommendedGuitarModel;
    }

    public void setRecommendedGuitarModel(String recommendedGuitarModel) {
        this.recommendedGuitarModel = recommendedGuitarModel;
    }
}
