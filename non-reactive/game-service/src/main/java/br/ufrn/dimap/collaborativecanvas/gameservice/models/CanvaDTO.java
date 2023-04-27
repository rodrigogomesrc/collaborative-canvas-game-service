package br.ufrn.dimap.collaborativecanvas.gameservice.models;

import java.util.ArrayList;
import java.util.List;

public class CanvaDTO {

    private Long id;
    private String name;
    private Long creatorId;
    private String link;
    private long qtdPaintedPixels;
    private List<PixelDTO> pixels;
    private List<HistoryDTO> histories;

    public CanvaDTO() {
    }

    public CanvaDTO(Long id, String name, Long creatorId, String link, int ySize, int xSize) {
        this.id = id;
        this.name = name;
        this.creatorId = creatorId;
        this.link = link;
        this.qtdPaintedPixels = 0;
        this.pixels = new ArrayList<>();
        this.histories = new ArrayList<>();
        this.initializePixels(ySize, xSize);
    }
    private void initializePixels(int ySize, int xSize) {
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                this.pixels.add(new PixelDTO(j, i, "white", this));
            }
        }
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public long getQtdPaintedPixels() {
        return qtdPaintedPixels;
    }

    public void setQtdPaintedPixels(long qtdPaintedPixels) {
        this.qtdPaintedPixels = qtdPaintedPixels;
    }

    public List<PixelDTO> getPixels() {
        return pixels;
    }

    public void setPixels(List<PixelDTO> pixels) {
        this.pixels = pixels;
    }

    public List<HistoryDTO> getHistories() {
        return histories;
    }

    public void setHistories(List<HistoryDTO> histories) {
        this.histories = histories;
    }


    
}
