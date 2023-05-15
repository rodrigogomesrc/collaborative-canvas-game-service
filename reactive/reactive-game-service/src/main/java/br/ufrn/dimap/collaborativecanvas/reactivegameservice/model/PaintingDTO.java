package br.ufrn.dimap.collaborativecanvas.reactivegameservice.model;


public class PaintingDTO {
    private Long pixelId;
    private Long playerId;
    private Long canvasId;
    private String color;

    public PaintingDTO() {
    }

    public PaintingDTO(Long pixelId, Long playerId, Long canvasId, String color) {
        this.pixelId = pixelId;
        this.playerId = playerId;
        this.canvasId = canvasId;
        this.color = color;
    }

    public String getcolor() {
        return this.color;
    }

    public void setPixel(String color) {
        this.color = color;
    }

    public Long getPixelId() {
        return this.pixelId;
    }

    public void setPixel(Long pixelId) {
        this.pixelId = pixelId;
    }

    public Long getPlayerId() {
        return this.playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getCanvasId() {
        return this.canvasId;
    }

    public void setCanvasId(Long canvasId) {
        this.canvasId = canvasId;
    }
}
